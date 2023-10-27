package Interfaces;

import Inventory.Inventory;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface InventoryFactory {
    Inventory createInventory(ResultSet rs) throws SQLException;
}