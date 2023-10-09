package Reciever;

import Interfaces.*;
import Menues.RoomMenu;

public class CallerRoomMenu implements Command {
    public void execute(){
        new RoomMenu();
    }
}
