package Factories;

import Interfaces.InventoryFactory;
import Inventory.Inventory;
import Inventory.Sport;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SportFactory implements InventoryFactory {
    public Inventory createInventory(ResultSet rs) throws SQLException {
        return new Sport(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7));
    }
}