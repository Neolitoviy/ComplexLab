package Invokers;

import Rooms.Rooms;
import Interfaces.RoomCommand;

public class SortAndSearchInvoker {
    RoomCommand sortMenu;
    RoomCommand searchMenu;

    public SortAndSearchInvoker(RoomCommand sortMenu, RoomCommand searchMenu) {
        this.sortMenu = sortMenu;
        this.searchMenu = searchMenu;
    }

    public void callSortMenu(Rooms rooms, int numberRoom){
        sortMenu.execute(rooms,numberRoom);
    }

    public void callSearchMenu(Rooms rooms, int numberRoom){
        searchMenu.execute(rooms,numberRoom);
    }
}
