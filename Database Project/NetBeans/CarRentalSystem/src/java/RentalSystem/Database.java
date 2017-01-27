package RentalSystem;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Types;

public class Database
{
    static DatabaseConnection dbconn = new DatabaseConnection();
    static Connection conn = dbconn.setConnection();
    public static boolean validate_user(String useremail, String userpassword) throws SQLException
    {
        CallableStatement func = conn.prepareCall("{ ? = CALL f_validate_user(?, ?) }");
        func.registerOutParameter(1, Types.TINYINT);
        func.setString(2, useremail);
        func.setString(3, userpassword);
        func.execute(); 
        return func.getBoolean(1);
    }
    public static boolean validate_newuser(String useremail) throws SQLException
    {
        CallableStatement func = conn.prepareCall("{ ? = CALL f_validate_newuser(?) }");
        func.registerOutParameter(1, Types.TINYINT);
        func.setString(2, useremail);
        func.execute();   
        return func.getBoolean(1);
    }
    public static boolean validate_guest(String guestemail) throws SQLException
    {
        CallableStatement func = conn.prepareCall("{ ? = CALL f_validate_guest(?) }");
        func.registerOutParameter(1, Types.TINYINT);
        func.setString(2, guestemail);
        func.execute();   
        return func.getBoolean(1);
    }
    public static boolean validate_car_category_availability(String carcategory, String pickup) throws SQLException
    {
        int carcategoryid = Integer.parseInt(carcategory);
        Date pickupdate = Date.valueOf(pickup);
        CallableStatement func = conn.prepareCall("{ ? = CALL f_validate_car_category_availability(?, ?) }");
        func.registerOutParameter(1, Types.TINYINT);
        func.setInt(2, carcategoryid);
        func.setDate(3, pickupdate);
        func.execute();
        return func.getBoolean(1);
    }
    public static void add_customer(String first, String middle, String last, String phone, String email, String password) throws SQLException
    {
        CallableStatement proc = conn.prepareCall("{ CALL sp_add_customer(?, ?, ?, ?, ?, ?) }");
        proc.setString(1, first);
        proc.setString(2, middle);
        proc.setString(3, last);
        proc.setString(4, phone);
        proc.setString(5, email);
        proc.setString(6, password);
        proc.execute();
    }
    public static void add_reservation_driver(String eid, String cid, String pdate, String rdate, String discount, String amount, String lid, String first, String middle, String last) throws SQLException
    {
        int categoryid = Integer.parseInt(cid);
        Date pickupdate = Date.valueOf(pdate);
        Date returndate = Date.valueOf(rdate);
        double discountamount = Double.parseDouble(discount);
        double transactionamount = Double.parseDouble(amount);
        CallableStatement proc = conn.prepareCall("{ CALL sp_add_reservation_driver(?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }");
        proc.setString(1, eid);
        proc.setInt(2, categoryid);
        proc.setDate(3, pickupdate);
        proc.setDate(4, returndate);
        proc.setDouble(5, discountamount);
        proc.setDouble(6, transactionamount);
        proc.setString(7, lid);
        proc.setString(8, first);
        proc.setString(9, middle);
        proc.setString(10, last);
        proc.execute();
    }
    public static int return_membershipid(String email) throws SQLException
    {
        CallableStatement func = conn.prepareCall("{ ? = CALL f_return_membershipid(?) }");
        func.registerOutParameter(1, Types.INTEGER);
        func.setString(2, email);
        func.execute();
        return func.getInt(1);
    }
    public static int return_reservationid(String eid, String cid, String pdate) throws SQLException
    {
        int categoryid = Integer.parseInt(cid);
        Date pickupdate = Date.valueOf(pdate);
        CallableStatement func = conn.prepareCall("{ ? = CALL f_return_reservationid(?, ?, ?) }");
        func.registerOutParameter(1, Types.INTEGER);
        func.setString(2, eid);
        func.setInt(3, categoryid);
        func.setDate(4, pickupdate);
        func.execute();
        return func.getInt(1);
    }
    public static String return_name(String email) throws SQLException
    {
        CallableStatement func = conn.prepareCall("{ ? = CALL f_return_name(?) }");
        func.registerOutParameter(1, Types.VARCHAR);
        func.setString(2, email);
        func.execute();
        return func.getString(1);
    }
    public static String return_carcategoryname(int categoryid) throws SQLException
    {
        CallableStatement func = conn.prepareCall("{ ? = CALL f_return_carcategoryname(?) }");
        func.registerOutParameter(1, Types.VARCHAR);
        func.setInt(2, categoryid);
        func.execute();
        return func.getString(1);
    }
    public static double return_rentingprice(int categoryid) throws SQLException
    {
        CallableStatement func = conn.prepareCall("{ ? = CALL f_return_rentingprice(?) }");
        func.registerOutParameter(1, Types.DOUBLE);
        func.setInt(2, categoryid);
        func.execute();
        return func.getDouble(1);
    }
    public static int return_discountpercentage(int membershipid) throws SQLException
    {
        CallableStatement func = conn.prepareCall("{ ? = CALL f_return_discountpercentage(?) }");
        func.registerOutParameter(1, Types.INTEGER);
        func.setInt(2, membershipid);
        func.execute();
        return func.getInt(1);
    }
    public static double return_basicamount(double rentperday, Date pdate, Date rdate) throws SQLException
    {
        CallableStatement func = conn.prepareCall("{ ? = CALL f_return_basicamount(?, ?, ?) }");
        func.registerOutParameter(1, Types.DOUBLE);
        func.setDouble(2, rentperday);
        func.setDate(3, pdate);
        func.setDate(4, rdate);
        func.execute();
        return func.getDouble(1);
    }
//    public static String[][] return_carcategory() throws SQLException
//    {
//        Statement s = conn.createStatement();
//        String sql = "SELECT * FROM Car_Category";
//        ResultSet rs = s.executeQuery(sql);
//        rs.last();
//        int row_count = rs.getRow();
//        ResultSetMetaData rsmd = rs.getMetaData();
//        int column_count = rsmd.getColumnCount();
//        rs.beforeFirst();
//        String[][] category = new String[row_count][column_count];
//        int i=0;
//        while(rs.next() && i<row_count)
//        {
//            for(int j=0; j<column_count; j++)
//                category[i][j] = rs.getString(j+1);
//            i++;
//        }
//        return category; 
//    }
//    public static String[] return_carcategory_column(int columnnumber) throws SQLException
//    {
//        String[][] category = return_carcategory();
//        int row_count, col_count;
//        row_count = category.length;
//        if(row_count >= 1)
//            col_count = category[0].length;
//        String[] column = new String[row_count];
//        for(int i=0; i<row_count; i++)
//            column[i] = category[i][columnnumber];
//        return column;
//    }
}