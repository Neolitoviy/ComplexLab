package Test.AddingToy;

import Rooms.Rooms;
import Inventory.*;
import Logger.MyLogger;
import SSMS_Connection.SSMS;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestAddingInventory {
    @Test
    public void TestAddExistingToy() throws SQLException, IOException {
        MyLogger log = new MyLogger();
        SSMS connection;
        try {
            connection = new SSMS();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Rooms rooms = new Rooms(connection.getConn());
        Statement stat;
        try {
            stat = connection.getConn().createStatement();
        }
        catch (SQLException e){
            MyLogger.getLogger().severe("Cannot connect");
            return;
        }

        ResultSet rs = stat.executeQuery("SELECT * FROM dbo.SportRoom3 WHERE id = 26");
        rs.next();
        int number = rs.getInt("number");
        rooms.getRooms().get(2).updateDB(new Sport("medium","gloves",150,"MMA","new",546,1),"dbo.SportRoom3");
        rs = stat.executeQuery("SELECT * FROM dbo.SportRoom3 WHERE id = 26");
        rs.next();
        Assert.assertEquals(number,rs.getInt(7));

        stat.execute("UPDATE dbo.SportRoom3 SET number=number-1 WHERE id=26");
    }
}
