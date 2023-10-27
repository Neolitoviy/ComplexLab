import Rooms.Rooms;
import Menues.MenuInitialization;
import SSMS_Connection.SSMS;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Rooms rooms = new Rooms();
        SSMS connection = new SSMS();
        rooms.fillRooms(connection.getConn());
        new MenuInitialization(rooms);
    }
}
