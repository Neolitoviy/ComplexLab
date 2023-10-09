package Rooms;

import Inventory.Inventory;
import java.util.ArrayList;

public class Playroom {
    ArrayList<Inventory> Inventory;
    String nameOfRoom;
    int NumberRoom;
    int NumberToys;

    public Playroom(String NameOfRoom, int NumberRoom, int NumberToys){
        Inventory = new ArrayList<>(NumberToys);
        this.nameOfRoom = NameOfRoom;
        this.NumberRoom = NumberRoom;
        this.NumberToys = NumberToys;
    }

    public void buyInventory(Inventory inventory){
        Inventory.add(inventory);
    }

    public void showInventory(){
        for (Inventory inventory : Inventory) {
            System.out.println(inventory);
        }
    }
}
