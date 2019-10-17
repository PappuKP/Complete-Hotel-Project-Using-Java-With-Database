


import java.sql.*;
import javax.swing.*;

public class mySqlConnection {
    Connection conn = null;
    public static Connection ConnectDB(){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/smarthotel","root","");
        
        return conn;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}
