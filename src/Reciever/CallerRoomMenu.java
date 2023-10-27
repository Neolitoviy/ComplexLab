package Reciever;

import Rooms.Rooms;
import Interfaces.*;
import Menues.RoomMenu;

public class CallerRoomMenu implements RoomsCommand {
    @Override
    public void execute(Rooms rooms){
        new RoomMenu(rooms);
    }
}
