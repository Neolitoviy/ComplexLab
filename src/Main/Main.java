package Main;

import Rooms.Rooms;
import Logger.MyLogger;
import Menues.MenuInitialization;
import SSMS_Connection.SSMS;
import java.sql.SQLException;

/**
 * Головний клас програми.
 */
public class Main {
    /**
     * Точка входу в програму.
     *
     * @param args Параметри командного рядка.
     * @throws SQLException Помилка SQL.
     */
    public static void main(String[] args) throws SQLException {
        MyLogger logger = new MyLogger();
        SSMS connection = new SSMS();
        Rooms rooms = new Rooms(connection.getConn());

        try {
            rooms.fillRooms(connection.getConn());
            MyLogger.getLogger().info("Кімнати заповнені інвертарем");
        }
        catch (SQLException e){
            MyLogger.getLogger().severe("Помилка заповнення кімнат");
        }

        new MenuInitialization(rooms);
    }
}




