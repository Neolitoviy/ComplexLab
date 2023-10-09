package Reciever;

import Interfaces.Command;
import Menues.SearchMenu;

public class CallerSearch implements Command {
    @Override
    public void execute() {
        new SearchMenu();
    }
}
