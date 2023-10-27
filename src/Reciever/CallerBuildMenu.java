package Reciever;

import Rooms.Rooms;
import Interfaces.RoomsCommand;
import Menues.RoomsMenu;

public class CallerBuildMenu implements RoomsCommand {
    @Override
    public void execute(Rooms rooms) {
        new RoomsMenu(rooms);
    }
}
