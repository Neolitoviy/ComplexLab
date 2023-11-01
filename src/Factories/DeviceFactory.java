package Factories;

import Interfaces.InventoryFactory;
import Inventory.Inventory;
import Inventory.Device;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Клас `DeviceFactory` реалізує інтерфейс `InventoryFactory` і використовується для створення об'єктів класу `Device` на основі даних з `ResultSet`.
 */
public class DeviceFactory implements InventoryFactory {
    /**
     * Метод `createInventory` створює об'єкт класу `Device` на основі даних з `ResultSet`.
     *
     * @param rs Результат запиту до бази даних у вигляді `ResultSet`, з якого отримуються дані для створення об'єкта.
     * @return Об'єкт класу `Device`, створений на основі даних з `ResultSet`.
     * @throws SQLException Виняток, який виникає у випадку помилки при роботі з базою даних.
     */
    @Override
    public Inventory createInventory(ResultSet rs) throws SQLException {
        return new Device(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7));
    }
}
