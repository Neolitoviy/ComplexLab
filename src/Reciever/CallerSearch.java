package Reciever;

import Rooms.Rooms;
import Interfaces.RoomCommand;
import Menues.SearchMenu;

/**
 * Клас `CallerSearch` реалізує інтерфейс `RoomCommand` і використовується для виклику меню пошуку в кімнаті.
 */
public class CallerSearch implements RoomCommand {
    /**
     * Метод `execute` викликає меню пошуку в кімнаті для об'єкта `Rooms` та конкретної кімнати за номером.
     *
     * @param rooms      Об'єкт класу `Rooms`, для якого викликається меню пошуку.
     * @param numberRoom Номер кімнати, в якій виконується пошук.
     */
    @Override
    public void execute(Rooms rooms, int numberRoom) {
        new SearchMenu(rooms, numberRoom);
    }
}

