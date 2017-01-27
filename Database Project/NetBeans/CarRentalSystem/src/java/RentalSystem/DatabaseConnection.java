package RentalSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class DatabaseConnection
{
    private Connection conn;
    private Statement stmt;
    private ResultSet res;
    public Connection setConnection()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/CarRentalSystem", "root", "");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return conn;
    }
    public ResultSet getResult(String sql, Connection conn)
    {
        this.conn=conn;
        try
        {
            stmt = conn.createStatement();
            res = stmt.executeQuery(sql);
        }
        catch (Exception e)
        {
            System.out.println("I found error here");
        }
        return res;
    }
}