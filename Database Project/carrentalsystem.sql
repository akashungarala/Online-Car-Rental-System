-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 16, 2015 at 03:50 PM
-- Server version: 5.6.26
-- PHP Version: 5.6.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `carrentalsystem`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_add_customer`(IN `fname` VARCHAR(40), IN `mname` VARCHAR(20), IN `lname` VARCHAR(20), IN `pnum` CHAR(10), IN `eid` VARCHAR(30))
    MODIFIES SQL DATA
    COMMENT 'Adds a new customer'
BEGIN
	INSERT INTO Customer (first_name, middle_name, last_name, phone_number, email_id) VALUES (fname, mname, lname, pnum, eid);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_add_registered_customer`(IN `eid` VARCHAR(30), IN `pwd` VARCHAR(20))
    MODIFIES SQL DATA
    COMMENT 'Adds a new registered customer'
BEGIN
	INSERT INTO RegisteredCustomer (email_id, password) VALUES (eid, pwd);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_add_rental`(IN `rid` INT(4), IN `lid` VARCHAR(15), IN `ccname` VARCHAR(30), IN `ccnum` CHAR(16), IN `expyear` CHAR(4), IN `month` CHAR(2), IN `cvv` CHAR(3))
    MODIFIES SQL DATA
    COMMENT 'Adds a new record in Rental table while pick-up'
BEGIN
	DECLARE carvin CHAR(18);
    DECLARE valid BOOLEAN;
    DECLARE cid INT(4);
    SELECT category_id INTO @cid FROM Reservation WHERE reservation_id=rid;
	SELECT VIN INTO @carvin FROM Car WHERE category_id=@cid AND availability=1 LIMIT 1;
	UPDATE Car SET availability=0 WHERE VIN=@carvin;
    SELECT EXISTS (SELECT CategoryID FROM v_category_available_carcount V WHERE CategoryID=@cid) INTO @valid;
    IF @valid = 0
    THEN
    	UPDATE CarCategory SET availability=0 WHERE category_id=@cid;
    END IF;
    INSERT INTO Rental (reservation_id, license_id, cc_name, cc_number, cc_expiry_date_year, cc_expiry_date_month, cc_cvv, pick_up_time, VIN) VALUES (rid, lid, ccname, ccnum, expyear, month, cvv, NOW(), @carvin);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_add_reservation_driver`(IN `eid` VARCHAR(30), IN `cid` INT(4), IN `pdate` DATE, IN `rdate` DATE, IN `discount` DOUBLE, IN `amount` DOUBLE, IN `lid` VARCHAR(15), IN `fname` VARCHAR(40), IN `mname` VARCHAR(20), IN `lname` VARCHAR(20))
    MODIFIES SQL DATA
    COMMENT 'Creates records in the tables Reservation and Driver'
BEGIN
	DECLARE rid INT(4);
    INSERT INTO Reservation (email_id, category_id, pick_up_date, return_date, discount_amount, transaction_amount) VALUES (eid, cid, pdate, rdate, discount, amount);
    SELECT reservation_id INTO @rid FROM Reservation WHERE email_id=eid AND category_id=cid AND pick_up_date=pdate;
    INSERT INTO Driver (reservation_id, license_id, first_name, middle_name, last_name) VALUES (@rid, lid, fname, mname, lname);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_generate_category_id`()
    MODIFIES SQL DATA
    COMMENT 'Generates a random category id'
BEGIN
	UPDATE CarCategory SET category_id = (SELECT FLOOR(6000.0 + RAND()*999.0) AS id FROM CarCategory WHERE category_id = NULL AND id NOT IN (SELECT category_id FROM CarCategory) LIMIT 1);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_generate_membership_id`()
    MODIFIES SQL DATA
    COMMENT 'Generates a random membership id'
BEGIN
	UPDATE RegisteredCustomer SET membership_id = (SELECT FLOOR(1000.0 + RAND()*999.0) AS id FROM RegisteredCustomer WHERE membership_id = NULL AND id NOT IN (SELECT membership_id FROM RegisteredCustomer) LIMIT 1);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_generate_rental_id`()
    MODIFIES SQL DATA
    COMMENT 'Generates a random rental id'
BEGIN
	UPDATE Rental SET rental_id = (SELECT FLOOR(7000.0 + RAND()*999.0) AS id FROM Rental WHERE rental_id = NULL AND id NOT IN (SELECT rental_id FROM Rental) LIMIT 1);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_generate_reservation_id`()
    MODIFIES SQL DATA
    COMMENT 'Generates a random reservation id'
BEGIN
	UPDATE Reservation SET reservation_id = (SELECT FLOOR(2000.0 + RAND()*999.0) AS id FROM Reservation WHERE reservation_id = NULL AND id NOT IN (SELECT reservation_id FROM Reservation) LIMIT 1);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_update_customer`(IN `fname` VARCHAR(40), IN `mname` VARCHAR(20), IN `lname` VARCHAR(20), IN `pnum` CHAR(10), IN `eid` VARCHAR(30))
    MODIFIES SQL DATA
    COMMENT 'Updates data in a record in the table customer'
BEGIN
	UPDATE Customer SET first_name=fname, middle_name=mname, last_name=lname, phone_number=pnum WHERE email_id=eid;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_update_rental`(IN `rid` INT(4), IN `lid` VARCHAR(15), IN `carvin` CHAR(18))
    MODIFIES SQL DATA
    COMMENT 'Updates the record in the Rental table'
BEGIN
	DECLARE due DOUBLE;
	DECLARE pay DOUBLE;
	DECLARE rentperday DOUBLE;
	DECLARE discount DOUBLE;
	DECLARE basic DOUBLE;
	DECLARE tax DOUBLE;
	DECLARE daycount INT;
	DECLARE actualdaycount INT;
	DECLARE eid VARCHAR(30);
    DECLARE valid BOOLEAN;
	UPDATE Car SET availability=1 WHERE VIN=carvin;
    UPDATE CarCategory SET availability=1 WHERE category_id=(SELECT category_id FROM Car WHERE VIN=carvin);
	SELECT email_id INTO @eid FROM Reservation WHERE reservation_id=rid;
	SELECT DATEDIFF(return_date, pick_up_date) INTO @daycount FROM Reservation WHERE reservation_id=rid;
	SELECT DATEDIFF(CURDATE(), pick_up_date) INTO @actualdaycount FROM Reservation WHERE reservation_id=rid;
	SELECT CC.renting_price INTO @rentperday FROM CarCategory CC JOIN Reservation R ON CC.category_id=R.category_id AND reservation_id=rid;
    IF @actualdaycount>@daycount
    THEN
    	SET @due = ((@actualdaycount - @daycount)*@rentperday);
    ELSE
    	SET @due=0;
    END IF;
	SELECT discount_amount INTO @discount FROM Reservation WHERE reservation_id=rid;
	SET @basic = @actualdaycount*@rentperday;
	SET @tax = (8.25*@basic)/100;
	SET @pay = @basic+@tax-@discount;
	UPDATE Rental SET return_time=NOW(), over_due_amount=@due, amount_to_pay=@pay WHERE reservation_id=rid;
    UPDATE RegisteredCustomer SET num_rentals=(num_rentals+1) WHERE email_id=@eid;
END$$

--
-- Functions
--
CREATE DEFINER=`root`@`localhost` FUNCTION `f_return_actual_days_count`(`rid` INT(4)) RETURNS int(11)
    READS SQL DATA
    COMMENT 'Returns the actual days count'
BEGIN
	DECLARE dayscount INT;
    SELECT DATEDIFF(DATE(return_time), DATE(pick_up_time)) INTO @dayscount FROM Rental WHERE rental_id=rid;
    RETURN @dayscount;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `f_return_car_category_id`(`rid` INT(4)) RETURNS int(4)
    READS SQL DATA
    COMMENT 'Returns the car category id'
BEGIN
	DECLARE cid INT(4);
    SELECT category_id INTO @cid FROM Reservation WHERE reservation_id=rid;
    RETURN @cid;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `f_return_car_category_name`(`cid` INT(4)) RETURNS varchar(20) CHARSET latin1
    READS SQL DATA
    COMMENT 'Returns the car category name'
BEGIN
	DECLARE name VARCHAR(60);
	SELECT category_name INTO @name FROM CarCategory WHERE category_id=cid;
	RETURN @name;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `f_return_cc_name`(`rid` INT(4)) RETURNS varchar(30) CHARSET latin1
    READS SQL DATA
    COMMENT 'Returns the Name as on Credit Card'
BEGIN
	DECLARE ccname VARCHAR(30);
    SELECT cc_name INTO @ccname FROM Rental WHERE rental_id=rid;
    RETURN @ccname;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `f_return_cc_number`(`rid` INT(4)) RETURNS char(16) CHARSET latin1
    READS SQL DATA
    COMMENT 'Returns the Credit Card Number'
BEGIN
	DECLARE ccnumber CHAR(16);
    SELECT cc_number INTO @ccnumber FROM Rental WHERE rental_id=rid;
    RETURN @ccnumber;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `f_return_days_count`(`pdate` DATE, `rdate` DATE) RETURNS int(11)
    NO SQL
    COMMENT 'Returns the days count'
BEGIN
	RETURN DATEDIFF(rdate, pdate);
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `f_return_discount`(`rid` INT(4)) RETURNS double
    READS SQL DATA
    COMMENT 'Returns the discount amount'
BEGIN
	DECLARE discount DOUBLE;
    SELECT discount_amount INTO @discount FROM Reservation WHERE reservation_id=rid;
    RETURN @discount;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `f_return_discount_percentage`(`mid` INT(4)) RETURNS int(11)
    READS SQL DATA
    COMMENT 'Returns the discount percentage'
BEGIN
	DECLARE discount INT;
    DECLARE count INT;
    SET @discount=0;
    SELECT num_rentals INTO @count FROM RegisteredCustomer WHERE membership_id=mid;
    IF @count<10
    THEN
    	SET @discount=0;
    ELSEIF (@count>=10 & @count<=30)
	THEN
		SET @discount=5;
	ELSEIF (@count>30 & @count<50)
	THEN
		SET @discount=10;
    ELSEIF (@count>50)
	THEN
		SET @discount=15;
	END IF;
    RETURN @discount;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `f_return_expected_days_count`(`rid` INT(4)) RETURNS int(11)
    READS SQL DATA
    COMMENT 'Returns the expected days count'
BEGIN
	DECLARE dayscount INT;
    SELECT DATEDIFF(return_date, pick_up_date) INTO @dayscount FROM Reservation WHERE reservation_id=rid;
    RETURN @dayscount;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `f_return_membership_id`(`eid` VARCHAR(30)) RETURNS int(4) unsigned
    READS SQL DATA
    COMMENT 'Returns the membership id'
BEGIN
	DECLARE mid INT(4);
	SELECT membership_id INTO @mid FROM RegisteredCustomer WHERE email_id=eid;
	RETURN @mid;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `f_return_name`(`eid` VARCHAR(30)) RETURNS varchar(60) CHARSET latin1
    READS SQL DATA
    COMMENT 'Returns the user name'
BEGIN
	DECLARE name VARCHAR(60);
	SELECT CONCAT(first_name, ' ', last_name) INTO @name FROM Customer WHERE email_id=eid;
	RETURN @name;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `f_return_pick_up_time`(`rid` INT(4)) RETURNS timestamp
    READS SQL DATA
    COMMENT 'Returns the pick-up time'
BEGIN
	DECLARE ptime TIMESTAMP;
    SELECT pick_up_time INTO @ptime FROM Rental WHERE rental_id=rid;
    RETURN @ptime;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `f_return_rental_id`(`rid` INT(4)) RETURNS int(4)
    READS SQL DATA
    COMMENT 'Returns the rental id'
BEGIN
	DECLARE rentalid INT(4);
    SELECT rental_id INTO @rentalid FROM Rental WHERE reservation_id=rid;
    RETURN @rentalid;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `f_return_renting_price`(`cid` INT(4)) RETURNS double
    READS SQL DATA
    COMMENT 'Returns the renting price'
BEGIN
	DECLARE price DOUBLE;
	SELECT renting_price INTO @price FROM CarCategory WHERE category_id=cid;
	RETURN @price;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `f_return_reservation_id`(`eid` VARCHAR(30), `cid` INT(4), `pdate` DATE) RETURNS int(4)
    READS SQL DATA
    COMMENT 'Returns the reservation id'
BEGIN
	DECLARE rid INT(4);
    SELECT reservation_id INTO @rid FROM Reservation WHERE email_id=eid AND category_id=cid AND pick_up_date=pdate;
    RETURN @rid;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `f_return_return_date`(`rid` INT(4)) RETURNS date
    READS SQL DATA
    COMMENT 'Returns the return date'
BEGIN
	DECLARE rdate INT(4);
    SELECT return_date INTO @rdate FROM Reservation WHERE reservation_id=rid;
    RETURN @rdate;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `f_return_return_time`(`rid` INT(4)) RETURNS timestamp
    READS SQL DATA
    COMMENT 'Returns the return time'
BEGIN
	DECLARE rtime TIMESTAMP;
    SELECT return_time INTO @rtime FROM Rental WHERE rental_id=rid;
    RETURN @rtime;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `f_return_vin`(`rid` INT(4)) RETURNS varchar(18) CHARSET latin1
    READS SQL DATA
    COMMENT 'Returns the VIN'
BEGIN
	DECLARE carvin VARCHAR(18);
    SELECT VIN INTO @carvin FROM Rental WHERE rental_id=rid;
    RETURN @carvin;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `f_validate_car_category`(`cid` INT(4)) RETURNS tinyint(1)
    READS SQL DATA
    COMMENT 'Validates the existence of the car category'
BEGIN
	DECLARE exist BOOLEAN;
	SELECT EXISTS (SELECT * FROM Carcategory WHERE category_id=cid) INTO @exist;
	RETURN @exist;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `f_validate_car_category_availability`(`cid` INT(4), `pdate` DATE) RETURNS tinyint(1)
    READS SQL DATA
    COMMENT 'Validates the availability for car category'
BEGIN
	DECLARE exist BOOLEAN;
    SELECT EXISTS (SELECT * FROM v_category_available_carcount WHERE CategoryID=cid) INTO @exist;
    RETURN @exist;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `f_validate_guest`(`eid` VARCHAR(30)) RETURNS tinyint(1)
    READS SQL DATA
    COMMENT 'Validates the guest'
BEGIN
	DECLARE exist BOOLEAN;
    SELECT EXISTS (SELECT * FROM Customer WHERE email_id=eid) INTO @exist;
    IF @exist = 1
    THEN
    	RETURN 0;
    ELSE
        RETURN 1;
	END IF;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `f_validate_new_user`(`eid` VARCHAR(30)) RETURNS tinyint(1)
    READS SQL DATA
    COMMENT 'Validates the new user'
BEGIN
	DECLARE exist BOOLEAN;
    SELECT EXISTS (SELECT * FROM RegisteredCustomer WHERE email_id=eid) INTO @exist;
    IF @exist = 1
    THEN
    	RETURN 0;
    ELSE
        RETURN 1;
	END IF;
END$$

CREATE DEFINER=`root`@`localhost` FUNCTION `f_validate_user`(`eid` VARCHAR(30), `pwd` VARCHAR(20)) RETURNS tinyint(1)
    READS SQL DATA
    COMMENT 'Validates the user'
BEGIN
	DECLARE exist BOOLEAN;
    SELECT EXISTS (SELECT * FROM RegisteredCustomer WHERE email_id=eid AND password=pwd) INTO @exist;
    RETURN @exist;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `car`
--

CREATE TABLE IF NOT EXISTS `car` (
  `VIN` varchar(18) NOT NULL DEFAULT '',
  `category_id` int(4) unsigned DEFAULT NULL,
  `license_plate` char(8) NOT NULL,
  `availability` tinyint(1) DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `car`
--

INSERT INTO `car` (`VIN`, `category_id`, `license_plate`, `availability`) VALUES
('1HD1KAV106Y69592', 6001, 'GHB-7865', 1),
('1HD1KAV106Y695921', 6002, 'BHG-5678', 1),
('1HD1KAV106Y695922', 6002, 'VGJ-5678', 1),
('1LNLM9842KY774961', 6003, 'DFG-3456', 1),
('2BNPDDJH51K97100', 6001, 'ABD-768', 1),
('2HGES16535HG81755', 6001, 'SDF-8765', 1),
('2HGES16535HG81756', 6002, 'HHJ-4567', 1),
('2HGES16535HG81758', 6004, 'SDF-4456', 1),
('2HGES16535HG81759', 6003, 'CGH-8765', 1),
('2HGES16535HG81760', 6004, 'SDF-8762', 1),
('2HGES16535HG81761', 6005, 'BHJK-456', 1),
('2HGES16535HG81763', 6006, 'BVF-5679', 0),
('2KJPDDJH51K971089', 6001, 'LCH-3210', 1),
('2WKPDDJH51K970989', 6001, 'BGD-4321', 1),
('2WKPDDJH51K97099', 6003, 'FGB-5676', 1),
('2WKPDDJH51K970990', 6002, 'CJG-5678', 1),
('2WKPDDJH51K970995', 6004, 'VGH-4221', 1),
('2WKPDDJH51K970997', 6005, 'VBJ-6778', 1),
('3FRWW6FC3DV072954', 6002, 'BJR-8765', 1),
('3FRWW6FC3DV072957', 6003, 'CKK-6787', 1),
('5GAET13M262340847', 6001, 'NJH-8765', 1),
('5GAET13M262340848', 6001, 'DVG-7653', 1),
('5GAET13M262340851', 6003, 'XCF-4322', 1),
('5GAET13M262340852', 6004, 'BGG-8759', 1),
('5GAET13M262340853', 6005, 'BHH-5678', 1),
('5GAET13M262340854', 6005, 'VHH-5567', 1),
('5GAET13M262340855', 6005, 'NGG-4567', 1),
('5GAET13M262341848', 6002, 'JHF-5678', 1),
('JS1GL52A4D2145863', 6002, 'KKF-7654', 1),
('JS1GL52A4D2145864', 6003, 'CFF-5567', 1),
('KMHHU6KJ1DU186741', 6001, 'CVF-7865', 1),
('KMHHU6KJ1DU186742', 6002, 'LKJ-9879', 1),
('KMHHU6KJ1DU186744', 6004, 'CFF-5435', 1),
('KMHHU6KJ1DU186747', 6005, 'VHJ-7656', 1),
('KMHHU6KJ1DU186749', 6004, 'VBH-6645', 1);

-- --------------------------------------------------------

--
-- Table structure for table `carcategory`
--

CREATE TABLE IF NOT EXISTS `carcategory` (
  `category_id` int(4) unsigned NOT NULL,
  `category_name` varchar(20) NOT NULL,
  `renting_price` double NOT NULL DEFAULT '0',
  `availability` tinyint(1) DEFAULT '1'
) ENGINE=InnoDB AUTO_INCREMENT=6011 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `carcategory`
--

INSERT INTO `carcategory` (`category_id`, `category_name`, `renting_price`, `availability`) VALUES
(6001, 'Economy', 25, 1),
(6002, 'Intermediate', 24, 1),
(6003, 'SUV', 28, 1),
(6004, 'Luxury', 35, 1),
(6005, 'Compact', 23, 1),
(6006, 'Family', 26, 0),
(6007, 'Convertible', 28, 1),
(6008, 'Cargo Van', 34, 1),
(6009, 'Mid-Level', 24, 1),
(6010, 'Roadster', 34, 1);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE IF NOT EXISTS `customer` (
  `email_id` varchar(30) NOT NULL DEFAULT '',
  `first_name` varchar(40) NOT NULL,
  `middle_name` varchar(20) DEFAULT NULL,
  `last_name` varchar(20) NOT NULL,
  `phone_number` char(10) NOT NULL,
  `registration_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`email_id`, `first_name`, `middle_name`, `last_name`, `phone_number`, `registration_time`) VALUES
('aaradhana@gmail.com', 'Aaradhana', '', 'Raghunathan', '980765453', '2015-12-11 03:45:41'),
('admin@carrentalsystem.com', 'Admin_first', 'Admin_middle', 'Admin_last', '9999999999', '2015-12-11 03:41:45'),
('akash@gmail.com', 'Akash', 'Venkata Naga', 'Ungarala', '9803378946', '2015-12-11 03:43:06'),
('alex@gmail.com', 'Alex', '', 'Phillips', '765654321', '2015-12-11 03:47:07'),
('imani@gmail.com', 'Imani', NULL, 'Bansal', '3152108765', '2015-12-11 03:44:13'),
('madhuvani@gmail.com', 'Madhuvani', '', 'Vanam', '987678654', '2015-12-11 03:46:23');

-- --------------------------------------------------------

--
-- Table structure for table `driver`
--

CREATE TABLE IF NOT EXISTS `driver` (
  `reservation_id` int(4) unsigned NOT NULL DEFAULT '0',
  `license_id` varchar(15) NOT NULL DEFAULT '',
  `first_name` varchar(40) NOT NULL,
  `middle_name` varchar(20) DEFAULT NULL,
  `last_name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `driver`
--

INSERT INTO `driver` (`reservation_id`, `license_id`, `first_name`, `middle_name`, `last_name`) VALUES
(2, '887543214578', 'Aiko', 'Roth', 'Carney'),
(3, '454534', 'Akash', 'Venkata Naga', 'Ungarala'),
(4, 'AK8472', 'Akash', 'Venkata Naga', 'Ungarala');

-- --------------------------------------------------------

--
-- Table structure for table `registeredcustomer`
--

CREATE TABLE IF NOT EXISTS `registeredcustomer` (
  `membership_id` int(4) unsigned NOT NULL,
  `email_id` varchar(30) NOT NULL,
  `password` varchar(20) NOT NULL,
  `num_rentals` int(11) DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=1006 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `registeredcustomer`
--

INSERT INTO `registeredcustomer` (`membership_id`, `email_id`, `password`, `num_rentals`) VALUES
(1000, 'admin@carrentalsystem.com', 'admin', 0),
(1001, 'akash@gmail.com', 'ungarala', 2),
(1002, 'imani@gmail.com', 'bansal', 0),
(1003, 'aaradhana@gmail.com', 'raghunathan', 0),
(1004, 'madhuvani@gmail.com', 'vanam', 0);

-- --------------------------------------------------------

--
-- Table structure for table `rental`
--

CREATE TABLE IF NOT EXISTS `rental` (
  `rental_id` int(4) unsigned NOT NULL,
  `reservation_id` int(4) unsigned DEFAULT NULL,
  `license_id` varchar(15) DEFAULT NULL,
  `VIN` char(18) DEFAULT NULL,
  `pick_up_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `return_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `cc_name` varchar(30) NOT NULL,
  `cc_number` char(16) NOT NULL,
  `cc_cvv` char(3) NOT NULL,
  `cc_expiry_date_year` char(4) NOT NULL,
  `cc_expiry_date_month` char(2) NOT NULL,
  `over_due_amount` double DEFAULT NULL,
  `amount_to_pay` double DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rental`
--

INSERT INTO `rental` (`rental_id`, `reservation_id`, `license_id`, `VIN`, `pick_up_time`, `return_time`, `cc_name`, `cc_number`, `cc_cvv`, `cc_expiry_date_year`, `cc_expiry_date_month`, `over_due_amount`, `amount_to_pay`) VALUES
(6, 2, '887543214578', '1HD1KAV106Y69592', '2015-12-16 05:25:02', '2015-12-16 05:26:30', 'Venkata Naga Akash', '1234567899876541', '785', '2020', '08', 0, 25.98),
(17, 4, 'AK8472', '2HGES16535HG81758', '2015-12-10 14:06:31', '2015-12-16 14:09:38', 'Venkata Naga Akash', '2583691473691472', '475', '2018', '08', 0, 227.325);

-- --------------------------------------------------------

--
-- Table structure for table `reservation`
--

CREATE TABLE IF NOT EXISTS `reservation` (
  `reservation_id` int(4) unsigned NOT NULL,
  `email_id` varchar(30) DEFAULT NULL,
  `category_id` int(4) unsigned DEFAULT NULL,
  `pick_up_date` date NOT NULL,
  `return_date` date NOT NULL,
  `discount_amount` double DEFAULT '0',
  `transaction_amount` double DEFAULT '0'
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reservation`
--

INSERT INTO `reservation` (`reservation_id`, `email_id`, `category_id`, `pick_up_date`, `return_date`, `discount_amount`, `transaction_amount`) VALUES
(2, 'akash@gmail.com', 6002, '2015-12-15', '2015-12-25', 0, 259.8),
(3, 'akash@gmail.com', 6006, '2015-12-07', '2015-12-21', 0, 394.03),
(4, 'akash@gmail.com', 6004, '2015-12-10', '2015-12-20', 0, 378.875);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_category_available_carcount`
--
CREATE TABLE IF NOT EXISTS `v_category_available_carcount` (
`CategoryID` int(4) unsigned
,`AvailableCarCount` bigint(21)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_category_carcount`
--
CREATE TABLE IF NOT EXISTS `v_category_carcount` (
`CategoryID` int(4) unsigned
,`TotalCarCount` bigint(21)
,`AvailableCarCount` bigint(21)
,`RentedCarCount` bigint(22)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `v_category_total_carcount`
--
CREATE TABLE IF NOT EXISTS `v_category_total_carcount` (
`CategoryID` int(4) unsigned
,`TotalCarCount` bigint(21)
);

-- --------------------------------------------------------

--
-- Structure for view `v_category_available_carcount`
--
DROP TABLE IF EXISTS `v_category_available_carcount`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_category_available_carcount` AS select `cc`.`category_id` AS `CategoryID`,count(`c`.`VIN`) AS `AvailableCarCount` from (`carcategory` `cc` left join `car` `c` on((`cc`.`category_id` = `c`.`category_id`))) where (`c`.`availability` = 1) group by `cc`.`category_id`;

-- --------------------------------------------------------

--
-- Structure for view `v_category_carcount`
--
DROP TABLE IF EXISTS `v_category_carcount`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_category_carcount` AS select `t`.`CategoryID` AS `CategoryID`,`t`.`TotalCarCount` AS `TotalCarCount`,`a`.`AvailableCarCount` AS `AvailableCarCount`,(`t`.`TotalCarCount` - `a`.`AvailableCarCount`) AS `RentedCarCount` from (`v_category_total_carcount` `t` join `v_category_available_carcount` `a` on((`t`.`CategoryID` = `a`.`CategoryID`)));

-- --------------------------------------------------------

--
-- Structure for view `v_category_total_carcount`
--
DROP TABLE IF EXISTS `v_category_total_carcount`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_category_total_carcount` AS select `cc`.`category_id` AS `CategoryID`,count(`c`.`VIN`) AS `TotalCarCount` from (`carcategory` `cc` left join `car` `c` on((`cc`.`category_id` = `c`.`category_id`))) group by `cc`.`category_id`;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `car`
--
ALTER TABLE `car`
  ADD PRIMARY KEY (`VIN`),
  ADD UNIQUE KEY `uc_licenseplate` (`license_plate`),
  ADD UNIQUE KEY `uc_VIN` (`VIN`,`category_id`),
  ADD KEY `index_car_VIN` (`VIN`),
  ADD KEY `index_car_category` (`category_id`),
  ADD KEY `index_car_licenseplate` (`license_plate`);

--
-- Indexes for table `carcategory`
--
ALTER TABLE `carcategory`
  ADD PRIMARY KEY (`category_id`),
  ADD UNIQUE KEY `category_name` (`category_name`),
  ADD KEY `index_carcategory_id` (`category_id`),
  ADD KEY `index_carcategory_name` (`category_name`),
  ADD KEY `index_carcategory_price` (`renting_price`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`email_id`),
  ADD KEY `index_customer_email` (`email_id`),
  ADD KEY `index_customer_phone` (`phone_number`),
  ADD KEY `index_customer_name` (`last_name`,`first_name`);

--
-- Indexes for table `driver`
--
ALTER TABLE `driver`
  ADD PRIMARY KEY (`reservation_id`,`license_id`),
  ADD KEY `index_driver_reservation` (`reservation_id`,`license_id`),
  ADD KEY `index_driver_name` (`last_name`,`first_name`);

--
-- Indexes for table `registeredcustomer`
--
ALTER TABLE `registeredcustomer`
  ADD PRIMARY KEY (`membership_id`),
  ADD UNIQUE KEY `email_id` (`email_id`),
  ADD UNIQUE KEY `uc_member` (`email_id`,`membership_id`),
  ADD UNIQUE KEY `uc_login` (`email_id`,`password`),
  ADD KEY `index_registeredcustomer_membership` (`membership_id`),
  ADD KEY `index_registeredcustomer_email` (`email_id`);

--
-- Indexes for table `rental`
--
ALTER TABLE `rental`
  ADD PRIMARY KEY (`rental_id`),
  ADD UNIQUE KEY `uc_rental` (`reservation_id`,`license_id`,`VIN`),
  ADD KEY `index_rental_id` (`rental_id`),
  ADD KEY `index_rental_reservation` (`reservation_id`),
  ADD KEY `index_rental_license` (`license_id`),
  ADD KEY `index_rental_VIN` (`VIN`),
  ADD KEY `index_rental_ccname` (`cc_name`),
  ADD KEY `index_rental_ccnumber` (`cc_number`);

--
-- Indexes for table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`reservation_id`),
  ADD UNIQUE KEY `uc_reservation` (`reservation_id`,`email_id`,`category_id`),
  ADD KEY `category_id` (`category_id`),
  ADD KEY `index_reservation_id` (`reservation_id`),
  ADD KEY `index_reservation_email` (`email_id`),
  ADD KEY `index_reservation_pickupdate` (`pick_up_date`),
  ADD KEY `index_reservation_returndate` (`return_date`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `carcategory`
--
ALTER TABLE `carcategory`
  MODIFY `category_id` int(4) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6011;
--
-- AUTO_INCREMENT for table `registeredcustomer`
--
ALTER TABLE `registeredcustomer`
  MODIFY `membership_id` int(4) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=1006;
--
-- AUTO_INCREMENT for table `rental`
--
ALTER TABLE `rental`
  MODIFY `rental_id` int(4) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=18;
--
-- AUTO_INCREMENT for table `reservation`
--
ALTER TABLE `reservation`
  MODIFY `reservation_id` int(4) unsigned NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `car`
--
ALTER TABLE `car`
  ADD CONSTRAINT `car_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `carcategory` (`category_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `driver`
--
ALTER TABLE `driver`
  ADD CONSTRAINT `driver_ibfk_1` FOREIGN KEY (`reservation_id`) REFERENCES `reservation` (`reservation_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `registeredcustomer`
--
ALTER TABLE `registeredcustomer`
  ADD CONSTRAINT `registeredcustomer_ibfk_1` FOREIGN KEY (`email_id`) REFERENCES `customer` (`email_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `rental`
--
ALTER TABLE `rental`
  ADD CONSTRAINT `rental_ibfk_1` FOREIGN KEY (`reservation_id`, `license_id`) REFERENCES `driver` (`reservation_id`, `license_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `rental_ibfk_2` FOREIGN KEY (`VIN`) REFERENCES `car` (`VIN`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `reservation_ibfk_1` FOREIGN KEY (`email_id`) REFERENCES `customer` (`email_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `reservation_ibfk_2` FOREIGN KEY (`category_id`) REFERENCES `carcategory` (`category_id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
