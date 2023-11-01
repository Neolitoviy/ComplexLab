package Reciever;

import Rooms.Rooms;
import Interfaces.*;
import Menues.RoomMenu;

/**
 * Клас `CallerRoomMenu` реалізує інтерфейс `RoomsCommand` і використовується для виклику меню конкретної кімнати.
 */
public class CallerRoomMenu implements RoomsCommand {
    /**
     * Метод `execute` викликає меню конкретної кімнати для об'єкта `Rooms`.
     *
     * @param rooms Об'єкт класу `Rooms`, для якого викликається меню кімнати.
     */
    public void execute(Rooms rooms){
        new RoomMenu(rooms);
    }
}