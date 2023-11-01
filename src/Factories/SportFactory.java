package Factories;

import Interfaces.InventoryFactory;
import Inventory.Inventory;
import Inventory.Sport;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Клас `SportFactory` реалізує інтерфейс `InventoryFactory` і використовується для створення об'єктів класу `Sport` на основі даних з `ResultSet`.
 */
public class SportFactory implements InventoryFactory {
    /**
     * Метод `createInventory` створює об'єкт класу `Sport` на основі даних з `ResultSet`.
     *
     * @param rs Результат запиту до бази даних у вигляді `ResultSet`, з якого отримуються дані для створення об'єкта.
     * @return Об'єкт класу `Sport`, створений на основі даних з `ResultSet`.
     * @throws SQLException Виняток, який виникає у випадку помилки при роботі з базою даних.
     */
    @Override
    public Inventory createInventory(ResultSet rs) throws SQLException {
        return new Sport(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7));
    }
}