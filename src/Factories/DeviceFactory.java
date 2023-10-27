package Factories;

import Interfaces.InventoryFactory;
import Inventory.Inventory;
import Inventory.Device;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DeviceFactory implements InventoryFactory {
    public Inventory createInventory(ResultSet rs) throws SQLException {
        return new Device(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7));
    }
}
