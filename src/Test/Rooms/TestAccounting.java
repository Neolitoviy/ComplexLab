package Test.Rooms;
import Rooms.Rooms;
import Logger.MyLogger;
import Rooms.Accounting;
import SSMS_Connection.SSMS;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Цей клас містить набір тестів для перевірки функціональності класу Accounting.
 */
public class TestAccounting {
    /**
     * Тест для перевірки правильності отримання інформації про облік бюджету.
     */
    @Test
    public void TestGettingInfo(){
        Accounting accounting = new Accounting();
        Assert.assertEquals(20000,accounting.getCurBudget());
        Assert.assertEquals(60,accounting.getMaxNumberToys());
        Assert.assertEquals(0,accounting.getCurNumberToys());
    }


    /**
     * Тест для перевірки функції додавання нової іграшки.
     */
    @Test
    public void TestAddingToy(){
        Accounting accounting = new Accounting();
        accounting.addNewToy();
        Assert.assertEquals(1,accounting.getCurNumberToys());
    }

    /**
     * Тест для перевірки функції зменшення бюджету.
     */
    @Test
    public void TestReduceBudget(){
        Accounting accounting = new Accounting();
        accounting.reduceBudget(5000);
        Assert.assertEquals(15000,accounting.getCurBudget());
    }

    /**
     * Тест для перевірки правильності отримання максимального бюджету.
     */
    @Test
    public void TestGettingMaxBudget(){
        Accounting accounting = new Accounting();
        Assert.assertEquals(accounting.getMaxBudget(),20000);
    }

    /**
     * Тест для перевірки отримання об'єкту обліку в класі Rooms.
     *
     * @throws SQLException Виникає у разі помилок взаємодії з базою даних.
     * @throws IOException Виникає у разі помилок вводу/виводу.
     */
    @Test
    public void TestGettingAccounting() throws SQLException, IOException {
        new MyLogger();
        SSMS ssms = new SSMS();
        Rooms rooms = new Rooms(ssms.getConn());
        Assert.assertNotNull(rooms.getAccounting());
    }
}
