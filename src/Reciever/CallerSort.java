package Reciever;

import Rooms.Rooms;
import Interfaces.RoomCommand;
import Menues.SortMenu;

public class CallerSort implements RoomCommand {
    @Override
    public void execute(Rooms rooms, int numberRoom) {
        new SortMenu(rooms,numberRoom);
    }
}
