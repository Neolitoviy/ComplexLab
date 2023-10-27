package Factories;

import Interfaces.InventoryFactory;
import Inventory.Inventory;
import Inventory.Toy;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ToyFactory implements InventoryFactory {
    public Inventory createInventory(ResultSet rs) throws SQLException {
        return new Toy(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(6), rs.getString(5), rs.getInt(4));
    }
}