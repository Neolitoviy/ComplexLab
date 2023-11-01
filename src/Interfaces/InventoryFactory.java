package Interfaces;

import Inventory.Inventory;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Інтерфейс `InventoryFactory` визначає метод `createInventory`, який повинен бути реалізований в класах-фабриках для створення об'єктів класу `Inventory`.
 * Цей метод призначений для створення об'єкта класу `Inventory` на основі даних з `ResultSet`.
 */
public interface InventoryFactory {
    /**
     * Метод `createInventory` створює об'єкт класу `Inventory` на основі даних з `ResultSet`.
     *
     * @param rs Результат запиту до бази даних у вигляді `ResultSet`, з якого отримуються дані для створення об'єкта.
     * @return Об'єкт класу `Inventory`, створений на основі даних з `ResultSet`.
     * @throws SQLException Виняток, який виникає у випадку помилки при роботі з базою даних.
     */
    Inventory createInventory(ResultSet rs) throws SQLException;
}
