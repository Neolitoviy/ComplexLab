package Reciever;

import Rooms.Rooms;
import Interfaces.RoomsCommand;
import Menues.RoomsMenu;

/**
 * Клас `CallerRoomsMenu` реалізує інтерфейс `RoomsCommand` і використовується для виклику побудови меню кімнат.
 */
public class CallerRoomsMenu implements RoomsCommand {
    /**
     * Метод `execute` викликає побудову меню кімнат для об'єкта `Rooms`.
     *
     * @param rooms Об'єкт класу `Rooms`, для якого будується меню кімнат.
     */
    @Override
    public void execute(Rooms rooms) {
        new RoomsMenu(rooms);
    }
}