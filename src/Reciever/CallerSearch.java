package Reciever;

import Rooms.Rooms;
import Interfaces.RoomCommand;
import Menues.SearchMenu;

public class CallerSearch implements RoomCommand {
    @Override
    public void execute(Rooms rooms, int numberRoom) {
        new SearchMenu(rooms,numberRoom);
    }
}
