package Rooms;

import java.util.ArrayList;
import java.util.List;

public class Rooms {
    private final List<Playroom> rooms;
    private final int maxBudget;
    private final int maxNumberToys;
    private int curBudget;

    public Rooms() {
        rooms = new ArrayList<>(3);
        maxBudget = 7000;
        maxNumberToys = 50;
        curBudget = maxBudget;
        initializeRooms();
    }

    private void initializeRooms() {
        for (int i = 0; i < 3; i++) {
            String name = "Room" + (i + 1);
            rooms.add(new Playroom(name, i + 1, maxNumberToys / 3));
        }
    }

    public void showAllInventory() {
        for (Playroom room : rooms) {
            room.showInventory();
        }
    }
}
