package Reciever;

import Rooms.Rooms;
import Interfaces.*;
import Menues.RoomMenu;

public class CallerRoomsMenu implements RoomsCommand {
    public void execute(Rooms rooms){
        new RoomMenu(rooms);
    }
}
