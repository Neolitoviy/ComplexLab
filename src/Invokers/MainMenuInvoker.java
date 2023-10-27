package Invokers;

import Rooms.Rooms;
import Interfaces.RoomsCommand;

public class MainMenuInvoker {
    RoomsCommand roomsMenu;
    RoomsCommand buildingMenu;

    public MainMenuInvoker(RoomsCommand roomsMenu, RoomsCommand buildingMenu) {
        this.roomsMenu = roomsMenu;
        this.buildingMenu = buildingMenu;
    }

    public void callRoomMenu(Rooms rooms){
        roomsMenu.execute(rooms);
    }

    public void callBuildingMenu(Rooms rooms){
        buildingMenu.execute(rooms);
    }

}
