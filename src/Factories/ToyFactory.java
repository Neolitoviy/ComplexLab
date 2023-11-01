package Factories;

import Interfaces.InventoryFactory;
import Inventory.Inventory;
import Inventory.Toy;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Клас `ToyFactory` реалізує інтерфейс `InventoryFactory` і використовується для створення об'єктів класу `Toy` на основі даних з `ResultSet`.
 */
public class ToyFactory implements InventoryFactory {
    /**
     * Метод `createInventory` створює об'єкт класу `Toy` на основі даних з `ResultSet`.
     *
     * @param rs Результат запиту до бази даних у вигляді `ResultSet`, з якого отримуються дані для створення об'єкта.
     * @return Об'єкт класу `Toy`, створений на основі даних з `ResultSet`.
     * @throws SQLException Виняток, який виникає у випадку помилки при роботі з базою даних.
     */
    @Override
    public Inventory createInventory(ResultSet rs) throws SQLException {
        return new Toy(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(6), rs.getString(5), rs.getInt(4));
    }
}