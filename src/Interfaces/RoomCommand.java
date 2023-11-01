package Interfaces;

import Rooms.Rooms;

/**
 * Інтерфейс `RoomCommand` визначає метод `execute`, який повинен бути реалізований в класах, що імплементують цей інтерфейс.
 * Цей метод призначений для виконання певних операцій на об'єктах класу `Rooms` для конкретної кімнати.
 */
public interface RoomCommand {
    /**
     * Метод `execute` виконує певну операцію на об'єктах класу `Rooms` для конкретної кімнати.
     *
     * @param rooms      Об'єкт класу `Rooms`, над яким виконується операція.
     * @param numberRoom Номер кімнати, на якій виконується операція.
     */
    public void execute(Rooms rooms, int numberRoom);
}
