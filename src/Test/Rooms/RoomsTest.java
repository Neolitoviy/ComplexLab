package Test.Rooms;
import Rooms.Rooms;

import Logger.MyLogger;
import SSMS_Connection.SSMS;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Цей клас містить набір тестів для перевірки функціональності класу Rooms.
 */
public class RoomsTest {
    /**
     * Конструктор для ініціалізації логгера.
     *
     * @throws IOException Виникає у разі помилок вводу/виводу.
     */
    public RoomsTest() throws IOException {
        MyLogger log = new MyLogger();
    }

    /**
     * Тест для перевірки заповнення кімнат інвентарем.
     *
     * @throws SQLException Виникає у разі помилок взаємодії з базою даних.
     */
    @Test
    public void TestFillingRooms() throws SQLException {
        SSMS connection;
        try {
            connection = new SSMS();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        Rooms rooms = new Rooms(connection.getConn());
        Assert.assertTrue(rooms.fillRooms(connection.getConn()));
    }

    /**
     * Тест для перевірки функції пошуку інвентаря за назвою, групою та розміром.
     *
     * @throws SQLException Виникає у разі помилок взаємодії з базою даних.
     */
    @Test
    public void TestSearching() throws SQLException {
        SSMS connection;
        try {
            connection = new SSMS();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Rooms rooms = new Rooms(connection.getConn());
        rooms.fillRoomsTest();

        Assert.assertTrue(rooms.searchByName("ball machine"));
        Assert.assertTrue(rooms.searchByGroup("Sport"));
        Assert.assertTrue(rooms.searchBySize("MEDIUM"));
    }

    /**
     * Тест для перевірки сортування інвентаря за групою.
     *
     * @throws SQLException Виникає у разі помилок взаємодії з базою даних.
     */
    @Test
    public void TestSortingByGroup() throws SQLException {
        SSMS connection;
        try {
            connection = new SSMS();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Rooms rooms = new Rooms(connection.getConn());
        rooms.fillInventTest();
        rooms.sortByGroup();

        for(int i = 0; i < rooms.getFullInvent().size() - 1; i++){
            int temp = rooms.getFullInvent().get(i).getGroup().compareTo(rooms.getFullInvent().get(i+1).getGroup());
            Assert.assertFalse(temp > 0);
        }
    }

    /**
     * Тест для перевірки сортування інвентаря за ціною.
     *
     * @throws SQLException Виникає у разі помилок взаємодії з базою даних.
     */
    @Test
    public void TestSortingByPrice() throws SQLException {
        SSMS connection;
        try {
            connection = new SSMS();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Rooms rooms = new Rooms(connection.getConn());
        rooms.fillInventTest();
        rooms.sortByPrice();

        for(int i = 0; i < rooms.getFullInvent().size() - 1; i++){
            Assert.assertFalse(rooms.getFullInvent().get(i).getPrice() > rooms.getFullInvent().get(i+1).getPrice());
        }
    }

    /**
     * Тест для перевірки сортування інвентаря за розміром.
     *
     * @throws SQLException Виникає у разі помилок взаємодії з базою даних.
     */
    @Test
    public void TestSortingBySize() throws SQLException {
        SSMS connection;
        try {
            connection = new SSMS();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Rooms rooms = new Rooms(connection.getConn());
        rooms.fillInventTest();
        rooms.sortBySize();

        for(int i = 0; i < rooms.getFullInvent().size() - 1; i++){
            int temp = rooms.getFullInvent().get(i).getSize().compareTo(rooms.getFullInvent().get(i+1).getSize());
            Assert.assertFalse(temp > 0);
        }
    }

    /**
     * Тест для перевірки сортування інвентаря за номером.
     *
     * @throws SQLException Виникає у разі помилок взаємодії з базою даних.
     */
    @Test
    public void TestSortingByNumber() throws SQLException {
        SSMS connection;
        try {
            connection = new SSMS();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Rooms rooms = new Rooms(connection.getConn());
        rooms.fillInventTest();
        rooms.sortByNumber();

        for(int i = 0; i < rooms.getFullInvent().size() - 1; i++){
            Assert.assertFalse(rooms.getFullInvent().get(i).getNumber() > rooms.getFullInvent().get(i+1).getNumber());
        }
    }

    /**
     * Тест для перевірки отримання списку кімнат.
     */
    @Test
    public void TestGettingRooms(){
        SSMS connection;
        try {
            connection = new SSMS();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Rooms rooms = new Rooms(connection.getConn());
        Assert.assertNotNull(rooms.getRooms());
    }
}
