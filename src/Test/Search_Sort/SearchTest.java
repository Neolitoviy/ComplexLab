package Test.Search_Sort;

import Rooms.Rooms;
import Rooms.Playroom;
import Inventory.Sport;
import Inventory.Toy;
import Logger.MyLogger;
import SSMS_Connection.SSMS;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;

/**
 * Цей клас містить набір тестів для перевірки функціональності пошуку і сортування в класі Playroom.
 */
public class SearchTest {
    SSMS connection;
    Rooms rooms;

    /**
     * Тест для перевірки функції пошуку за групою інвентаря в ігровій кімнаті.
     */
    @Test
    public void TestSearchByGroup(){
        MyLogger log = new MyLogger();
        try {
            connection = new SSMS();
        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        }
        rooms = new Rooms(connection.getConn());

        Playroom room = new Playroom("test",0,3, connection.getConn(), rooms);
        room.buyInventory(new Sport("small","test1",0," "," ",0,1));
        room.buyInventory(new Toy("small","doll",15,43632,"kite",2));

        Assert.assertTrue(room.searchByGroup("Sport"));
        Assert.assertFalse(room.searchByGroup("Device"));
    }

    /**
     * Тест для перевірки функції пошуку за розміром інвентаря в ігровій кімнаті.
     */
    @Test
    public void TestSearchBySize(){
        MyLogger log = new MyLogger();
        try {
            connection = new SSMS();
        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        }
        Playroom room = new Playroom("test",0,3,connection.getConn(), rooms);
        room.buyInventory(new Sport("small","test1",0," "," ",0,1));
        room.buyInventory(new Toy("medium","doll",15,43632,"kite",2));

        Assert.assertTrue(room.searchBySize("SMALL"));
        Assert.assertFalse(room.searchBySize("big"));
    }

    /**
     * Тест для перевірки функції пошуку за назвою інвентаря в ігровій кімнаті.
     */
    @Test
    public void TestSearchByName(){
        MyLogger log = new MyLogger();
        try {
            connection = new SSMS();
        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        }
        Playroom room = new Playroom("test",0,3,connection.getConn(), rooms);
        room.buyInventory(new Sport("small","test1",0," "," ",0,1));
        room.buyInventory(new Toy("small","doll",15,43632,"kite",2));

        Assert.assertTrue(room.searchByName("DOLL"));
        Assert.assertFalse(room.searchByName("pen"));
    }
}
