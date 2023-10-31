package Main;

import Rooms.Rooms;
import Logger.MyLogger;
import Menues.MenuInitialization;
import SSMS_Connection.SSMS;
import EmailSender.EmailSender;


import javax.mail.MessagingException;
import java.io.IOException;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException, IOException, MessagingException {
        MyLogger logger = new MyLogger();
        SSMS connection = new SSMS();
        Rooms rooms = new Rooms(connection.getConn());

        try {
            rooms.fillRooms(connection.getConn());
            MyLogger.getLogger().info("Rooms filled by inventory");
        }
        catch (SQLException e){
            MyLogger.getLogger().severe("Error filling rooms");
        }

        new MenuInitialization(rooms);
    }
}



