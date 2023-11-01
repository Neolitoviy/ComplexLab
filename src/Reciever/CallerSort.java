package Reciever;

import Rooms.Rooms;
import Interfaces.RoomCommand;
import Menues.SortMenu;

/**
 * Клас `CallerSort` реалізує інтерфейс `RoomCommand` і використовується для виклику меню сортування в кімнаті.
 */
public class CallerSort implements RoomCommand {
    /**
     * Метод `execute` викликає меню сортування в кімнаті для об'єкта `Rooms` та конкретної кімнати за номером.
     *
     * @param rooms      Об'єкт класу `Rooms`, для якого викликається меню сортування.
     * @param numberRoom Номер кімнати, в якій виконується сортування.
     */
    @Override
    public void execute(Rooms rooms, int numberRoom) {
        new SortMenu(rooms, numberRoom);
    }
}