package Invokers;

import Interfaces.Command;

public class MainMenuInvoker {
    Command roomsMenu;
    Command buildingMenu;
    Command exit;

    public MainMenuInvoker(Command roomsMenu, Command buildingMenu, Command exit) {
        this.roomsMenu = roomsMenu;
        this.buildingMenu = buildingMenu;
        this.exit = exit;
    }

    public void callRoomMenu(){
        roomsMenu.execute();
    }

    public void callBuildingMenu(){
        buildingMenu.execute();
    }

    public void callExit(){
        exit.execute();
    }
}
