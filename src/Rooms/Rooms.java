package Rooms;

import Inventory.Inventory;
import Interfaces.InventoryFactory;
import Factories.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;

public class Rooms {
    private final String nameOfBuilding;
    private final ArrayList<Playroom> rooms;
    private final int maxBudget;
    private final int maxNumberToys;
    private int curBudget;
    private int curNumberToys;
    private final ArrayList<Inventory> fullInvent;

    public Rooms() {
        nameOfBuilding = "Іграшковий дім";
        fullInvent = new ArrayList<>();
        rooms = new ArrayList<>(3);
        maxBudget = 20000;
        maxNumberToys = 60;
        curBudget = maxBudget;
        curNumberToys = 0;
        for (int i = 0; i < 3; i++) {
            String name = "Кімната-" + (i + 1);
            rooms.add(new Playroom(name, i + 1, maxNumberToys / 3));
        }
    }

    public void fillRooms(Connection conn) throws SQLException {
        for (int i = 0; i < rooms.size(); i++) {
            buyInventoryFromSSMSTable(conn, "dbo.SportRoom", (i + 1), new SportFactory(), 3);
            buyInventoryFromSSMSTable(conn, "dbo.DeviceRoom", (i + 1), new DeviceFactory(), 4);
            buyInventoryFromSSMSTable(conn, "dbo.ToysRoom", (i + 1), new ToyFactory(), 3);
        }
        fillFullInvent();
    }

    private void buyInventoryFromSSMSTable(Connection conn, String tableName, int index, InventoryFactory factory, int priceColumnIndex) throws SQLException {
        Statement stat = conn.createStatement();
        String query = "Select * from " + tableName + index;
        ResultSet rs = stat.executeQuery(query);

        while (rs.next()) {
            if (curBudget - rs.getInt(priceColumnIndex) < 0 || curNumberToys == maxNumberToys) {
                System.out.println("Неможливо купити - " + rs.getString(2) + " ID:" + rs.getInt(6));
            } else {
                rooms.get(index).buyInventory(factory.createInventory(rs));
                curBudget -= rs.getInt(priceColumnIndex);
                curNumberToys += 1;
            }
        }
    }

    public void showAllInventory() {
        for (Inventory invent : fullInvent) {
            System.out.println(invent);
        }
    }

    public void showInventoryInRoom(int numberRoom) {
        rooms.get(numberRoom).showInventory();
    }

    public void searchByGroup(String group) {
        for (Playroom room : rooms) {
            room.searchByGroup(group);
        }
    }

    public void searchBySize(String size) {
        for (Playroom room : rooms) {
            room.searchBySize(size);
        }
    }

    public void searchByName(String name) {
        for (Playroom room : rooms) {
            room.searchByName(name);
        }
    }

    public void sortBySize() {
        fullInvent.sort(Comparator.comparing(Inventory::getSize));
        showAllInventory();
    }

    public void sortByPrice() {
        fullInvent.sort(Comparator.comparing(Inventory::getPrice));
        showAllInventory();
    }

    public void sortByGroup() {
        fullInvent.sort(Comparator.comparing(Inventory::getGroup));
        showAllInventory();
    }

    public void sortByNumber() {
        fullInvent.sort(Comparator.comparing(Inventory::getNumber));
        showAllInventory();
    }

    public ArrayList<Playroom> getRooms() {
        return rooms;
    }

    public void budgetInfo() {
        System.out.println("\n\tМаксимальний бюджет \"" + nameOfBuilding + "\" - " + maxBudget + "$");
        System.out.println("\tПоточний бюджет - " + curBudget + "$\n");
    }

    void fillFullInvent() {
        for (Playroom room : rooms) {
            fullInvent.addAll(room.invent);
        }
    }
}