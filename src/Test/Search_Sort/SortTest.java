package Test.Search_Sort;

import Rooms.Rooms;
import Rooms.Playroom;
import Inventory.*;
import SSMS_Connection.SSMS;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;

/**
 * Цей клас містить набір тестів для перевірки сортування інвентаря в ігровій кімнаті.
 */
public class SortTest {
    SSMS connection;
    Rooms rooms;

    /**
     * Тест для перевірки сортування інвентаря за розміром в ігровій кімнаті.
     */
    @Test
    public void TestSortBySize(){
        try {
            connection = new SSMS();
        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        }
        rooms = new Rooms(connection.getConn());
        Playroom room = new Playroom("test",0,3,connection.getConn(), rooms);
        room.buyInventory(new Sport("small","test1",0," "," ",0,1));
        room.buyInventory(new Sport("big","test2",0," "," ",0,1));
        room.buyInventory(new Sport("medium","test3",0," "," ",0,1));
        room.sortBySize();
        for (int i = 0;i < room.getInvent().size() - 1;++i) {
            int temp = room.getInvent().get(i).getSize().compareTo(room.getInvent().get(i+1).getSize());
            Assert.assertFalse(temp > 0);
        }
    }

    /**
     * Тест для перевірки сортування інвентаря за ціною в ігровій кімнаті.
     */
    @Test
    public void TestSortByPrice(){
        try {
            connection = new SSMS();
        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        }
        rooms = new Rooms(connection.getConn());
        Playroom room = new Playroom("test",0,3,connection.getConn(), rooms);
        room.buyInventory(new Sport("small","test1",100," "," ",0,1));
        room.buyInventory(new Sport("big","test2",25," "," ",0,1));
        room.buyInventory(new Sport("medium","test3",433," "," ",0,1));
        room.sortByPrice();
        for (int i = 0;i < room.getInvent().size() - 1;++i) {
            Assert.assertFalse(room.getInvent().get(i).getPrice() > room.getInvent().get(i+1).getPrice());
        }
    }

    /**
     * Тест для перевірки сортування інвентаря за групою в ігровій кімнаті.
     */
    @Test
    public void TestSortByGroup(){
        try {
            connection = new SSMS();
        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        }
        rooms = new Rooms(connection.getConn());
        Playroom room = new Playroom("test",0,3,connection.getConn(), rooms);
        room.buyInventory(new Sport("small","test1",0," "," ",0,1));
        room.buyInventory(new Toy("small","doll",15,43632,"kite",2));
        room.buyInventory(new Device("medium","phone",16,6,8,9,1));
        room.sortByGroup();
        for (int i = 0;i < room.getInvent().size() - 1;++i) {
            int temp = room.getInvent().get(i).getGroup().compareTo(room.getInvent().get(i+1).getGroup());
            Assert.assertFalse(temp > 0);
        }
    }

    /**
     * Тест для перевірки сортування інвентаря за кількістю в ігровій кімнаті.
     */
    @Test
    public void TestSortByNumber(){
        try {
            connection = new SSMS();
        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        }
        rooms = new Rooms(connection.getConn());
        Playroom room = new Playroom("test",0,3,connection.getConn(), rooms);
        room.buyInventory(new Sport("small","test1",0," "," ",0,7));
        room.buyInventory(new Toy("small","doll",15,43632,"kite",3));
        room.buyInventory(new Sport("medium","test3",0," "," ",0,25));
        room.sortByNumber();
        for (int i = 0;i < room.getInvent().size() - 1;++i) {
            Assert.assertFalse(room.getInvent().get(i).getNumber() > room.getInvent().get(i+1).getNumber());
        }
    }
}
