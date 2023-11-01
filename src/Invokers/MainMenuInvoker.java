package Invokers;

import Rooms.Rooms;
import Interfaces.RoomsCommand;

/**
 * Клас `MainMenuInvoker` використовується для виклику команд для головного меню.
 * Він має дві команди: команда для виклику меню кімнати та команда для виклику меню кімнат.
 */
public class MainMenuInvoker {
    private final RoomsCommand roomMenu;       // Команда для виклику меню кімнати
    private final RoomsCommand roomsMenu;      // Команда для виклику меню кімнат

    /**
     * Конструктор класу `MainMenuInvoker` ініціалізує команди для меню кімнати та меню кімнат.
     *
     * @param roomMenu      Команда для виклику меню кімнати.
     * @param roomsMenu     Команда для виклику меню кімнат.
     */
    public MainMenuInvoker(RoomsCommand roomMenu, RoomsCommand roomsMenu) {
        this.roomMenu = roomMenu;
        this.roomsMenu = roomsMenu;
    }

    /**
     * Метод `callRoomMenu` викликає команду для відкриття меню кімнати.
     *
     * @param rooms Об'єкт класу `Rooms`, з яким взаємодіє меню кімнати.
     */
    public void callRoomMenu(Rooms rooms) {
        roomMenu.execute(rooms);
    }

    /**
     * Метод `callBuildingMenu` викликає команду для відкриття меню кімнат.
     *
     * @param rooms Об'єкт класу `Rooms`, з яким взаємодіє меню кімнат.
     */
    public void callBuildingMenu(Rooms rooms) {
        roomsMenu.execute(rooms);
    }
}
