package Reciever;

import Interfaces.Command;

public class CallerExit implements Command {
    @Override
    public void execute() {
        System.exit(0);
    }
}
