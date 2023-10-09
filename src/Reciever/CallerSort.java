package Reciever;

import Interfaces.Command;
import Menues.SortMenu;

public class CallerSort implements Command {
    @Override
    public void execute() {
        new SortMenu();
    }
}
