package Interfaces;

import Rooms.Rooms;

/**
 * Інтерфейс `RoomsCommand` визначає метод `execute`, який повинен бути реалізований в класах, що імплементують цей інтерфейс.
 * Цей метод призначений для виконання певних операцій на об'єктах класу `Rooms`.
 */
public interface RoomsCommand {
    /**
     * Метод `execute` виконує певну операцію на об'єктах класу `Rooms`.
     *
     * @param rooms Об'єкт класу `Rooms`, над яким виконується операція.
     */
    public void execute(Rooms rooms);
}