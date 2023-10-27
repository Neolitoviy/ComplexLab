package SSMS_Connection;

import java.sql.*;

public class SSMS {
    private Connection conn;
    public SSMS() {
        conn = null;
        try {
            String dbURL = "jdbc:sqlserver://VanyaPC;databaseName=Inventory;integratedSecurity=true;encrypt=false";
            conn = DriverManager.getConnection(dbURL);
            System.out.println("Підключено до SSMS");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Connection getConn() {
        return conn;
    }
}
