package Reciever;

import Interfaces.Command;
import Menues.RoomsMenu;

public class CallerBuildMenu implements Command {
    @Override
    public void execute() {
        new RoomsMenu();
    }
}
