package Rooms;

import Factories.DeviceFactory;
import Factories.SportFactory;
import Factories.ToyFactory;
import Interfaces.InventoryFactory;
import Inventory.Device;
import Inventory.Inventory;
import Inventory.Sport;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;


public class Rooms {
    private final String nameOfBuilding;
    private ArrayList<Playroom> rooms;
    private Accounting accounting;
    private ArrayList<Inventory> fullInvent;

    public Rooms(Connection conn){
        accounting = new Accounting();
        nameOfBuilding = "Іграшковий дім";
        fullInvent = new ArrayList<Inventory>();
        rooms = new ArrayList <>(3);
        for(int i = 0;i < 3;i++){
            String name = "Кімната - " + (i+1);
            rooms.add(new Playroom(name,i+1,accounting.getMaxNumberToys() / 3,conn,this));
        }
    }

    public Accounting getAccounting() {
        return accounting;
    }

    public boolean fillRooms(Connection conn) throws SQLException {
        for (int i = 0; i < rooms.size(); i++) {
            buyInventoryFromSSMSTable(conn, "dbo.SportRoom", (i + 1), new SportFactory(), 3);
            buyInventoryFromSSMSTable(conn, "dbo.DeviceRoom", (i + 1), new DeviceFactory(), 3);
            buyInventoryFromSSMSTable(conn, "dbo.ToysRoom", (i + 1), new ToyFactory(), 3);
        }
        fillFullInvent();
        return true;
    }

    private void buyInventoryFromSSMSTable(Connection conn, String tableName, int index, InventoryFactory factory, int priceColumnIndex) throws SQLException {
        Statement stat = conn.createStatement();
        String query = "Select * from " + tableName + index;
        ResultSet rs = stat.executeQuery(query);

        while (rs.next()) {
            if (((accounting.getCurBudget() - rs.getInt(3)) < 0) ||  (accounting.getCurNumberToys() == accounting.getMaxNumberToys())) {
                System.out.println("Неможливо купити - " + rs.getString(2) + " ID:" + rs.getInt(6));
            } else {
                rooms.get(index).buyInventory(factory.createInventory(rs));
                accounting.reduceBudget(rs.getInt(3));
                accounting.addNewToy();
            }
        }
    }

    public void showAllInventory(){
        for(Inventory invent : fullInvent){
            System.out.println(invent);
        }
    }

    public void showInventoryInRoom(int numberRoom){
        rooms.get(numberRoom).showInventory();
    }

    public boolean searchByGroup(String group){
        boolean founded = false;
        for (Playroom room : rooms) {
            if(room.searchByGroup(group))
                founded = true;
        }
        return founded;
    }

    public boolean searchBySize(String size){
        boolean founded = false;
        for (Playroom room : rooms) {
            if(room.searchBySize(size))
                founded = true;
        }
        return founded;
    }

    public boolean searchByName(String name){
        boolean founded = false;
        for (Playroom room : rooms) {
            if(room.searchByName(name))
                founded = true;
        }
        return founded;
    }

    public void sortBySize(){
        fullInvent.sort(Comparator.comparing(Inventory::getSize));
        showAllInventory();
    }

    public void sortByPrice(){
        fullInvent.sort(Comparator.comparing(Inventory::getPrice));
        showAllInventory();
    }

    public void sortByGroup(){
        fullInvent.sort(Comparator.comparing(Inventory::getGroup));
        showAllInventory();
    }

    public void sortByNumber(){
        fullInvent.sort(Comparator.comparing(Inventory::getNumber));
        showAllInventory();
    }

    public ArrayList<Playroom> getRooms() {
        return rooms;
    }

    public void budgetInfo(){
        System.out.println(accounting);
    }

    void fillFullInvent(){
        for (Playroom room : rooms) {
            fullInvent.addAll(room.invent);
        }
    }

    public void fillRoomsTest(){
        rooms.get(1).buyInventory(new Device("large","laptop",777,100,2,25616,3));
        rooms.get(0).buyInventory(new Sport("medium","ball machine",500,"football","new",15124,1));
        rooms.get(1).buyInventory(new Device("small","tablet",100,50,2,25612,1));
    }

    public void fillInventTest(){
        fullInvent.add(new Device("large","laptop",777,100,2,25616,3));
        fullInvent.add(new Sport("medium","ball machine",500,"football","new",15124,1));
        fullInvent.add(new Device("small","tablet",100,50,2,25612,1));
    }

    public ArrayList<Inventory> getFullInvent() {
        return fullInvent;
    }
}

