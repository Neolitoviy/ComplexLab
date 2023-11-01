package SSMS_Connection;

import Logger.MyLogger;
import EmailSender.EmailSender;

import javax.mail.MessagingException;
import java.io.IOException;
import java.sql.*;

/**
 * Клас `SSMS` відповідає за з'єднання з Microsoft SQL Server.
 * Він ініціює підключення і відправляє логи та повідомлення по електронній пошті при успішному чи неуспішному з'єднанні.
 */
public class SSMS {
    private Connection conn;

    /**
     * Конструктор класу `SSMS` створює з'єднання з Microsoft SQL Server.
     *
     * @throws SQLException Виникає, якщо виникають проблеми з підключенням до SQL Server.
     */
    public SSMS() throws SQLException {
        conn = null;
        try {
            String dbURL = "jdbc:sqlserver://VanyaPC;databaseName=Inventory;integratedSecurity=true;encrypt=false";
            conn = DriverManager.getConnection(dbURL);
            MyLogger.getLogger().info("Підключено до SSMS успішно");
            EmailSender sender = new EmailSender();
            sender.sendMsg("Підключено до SSMS успішно");
        } catch (SQLException ex) {
            MyLogger.getLogger().severe("SQL Server не відповідає\n");
            try {
                EmailSender sender = new EmailSender();
                sender.sendMsg("SQL Server не може відповісти");
            } catch (IOException e) {
                MyLogger.getLogger().severe("Помилка введення/виведення (IOException)");
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
            ex.printStackTrace();
            System.exit(0);
        } catch (MessagingException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Отримати об'єкт Connection, який представляє з'єднання з Microsoft SQL Server.
     *
     * @return З'єднання з SQL Server.
     */
    public Connection getConn() {
        return conn;
    }
}
