package SSMS_Connection;

import Logger.MyLogger;
import EmailSender.EmailSender;

import javax.mail.MessagingException;
import java.io.IOException;
import java.sql.*;

public class SSMS {
    private Connection conn;
    public SSMS() throws SQLException {
        conn = null;
        try {
            String dbURL = "jdbc:sqlserver://VanyaPC;databaseName=Inventory;integratedSecurity=true;encrypt=false";
            conn = DriverManager.getConnection(dbURL);
            MyLogger.getLogger().info("Connected to SSMS successfully");
            EmailSender sender = new EmailSender();
            sender.sendMsg("Connected to SSMS successfully");
        } catch (SQLException ex) {
            MyLogger.getLogger().severe("SQL Server don't response\n");
            try {
                EmailSender sender = new EmailSender();
                sender.sendMsg("SQL SERVER CAN'T RESPONSE");
            } catch (IOException e) {
                MyLogger.getLogger().severe("IOException error");
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
            ex.printStackTrace();
            System.exit(0);
        } catch (MessagingException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConn() {
        return conn;
    }
}
