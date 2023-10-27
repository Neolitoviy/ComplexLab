package Rooms;

import Inventory.Inventory;

import java.util.*;

public class Playroom {
    ArrayList<Inventory> invent;
    String nameOfRoom;
    int noRoom;
    int numberToys;

    public Playroom(String nameOfRoom, int noRoom, int numberToys){
        invent = new ArrayList<>();
        this.nameOfRoom = nameOfRoom;
        this.noRoom = noRoom;
        this.numberToys = numberToys;
    }

    public void buyInventory(Inventory inv){
        invent.add(inv);
    }

    public void showInventory(){
        System.out.println(nameOfRoom + ":");
        for (Inventory inventory : invent) {
            System.out.println(inventory);
        }
    }

    public void searchByGroup(String group){
        for (Inventory inventory : invent) {
            if (inventory.getGroup().equalsIgnoreCase(group)) {
                System.out.println(inventory);
            }
        }
    }

    public void searchBySize(String size){
        for (Inventory inventory : invent) {
            if (inventory.getDesc().getSize().equalsIgnoreCase(size)) {
                System.out.println(inventory);
            }
        }
    }

    public void searchByName(String name){
        for (Inventory inventory : invent) {
            if (inventory.getDesc().getToyName().equalsIgnoreCase(name)) {
                System.out.println(inventory);
            }
        }
    }

    public void sortBySize(){
        invent.sort(Comparator.comparing(Inventory::getSize));
    }

    public void sortByPrice(){
        invent.sort(Comparator.comparing(Inventory::getPrice));
    }

    public void sortByGroup(){
        invent.sort(Comparator.comparing(Inventory::getGroup));
    }

    public void sortByNumber(){invent.sort(Comparator.comparing(Inventory::getNumber));}
}
