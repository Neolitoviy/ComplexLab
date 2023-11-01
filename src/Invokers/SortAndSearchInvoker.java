package Invokers;

import Rooms.Rooms;
import Interfaces.RoomCommand;

/**
 * Клас `SortAndSearchInvoker` використовується для виклику команд для меню сортування та пошуку.
 * Він має дві команди: команда для виклику меню сортування та команда для виклику меню пошуку.
 */
public class SortAndSearchInvoker {
    private final RoomCommand sortMenu;    // Команда для виклику меню сортування
    private final RoomCommand searchMenu;  // Команда для виклику меню пошуку

    /**
     * Конструктор класу `SortAndSearchInvoker` ініціалізує команди для меню сортування та пошуку.
     *
     * @param sortMenu   Команда для виклику меню сортування.
     * @param searchMenu Команда для виклику меню пошуку.
     */
    public SortAndSearchInvoker(RoomCommand sortMenu, RoomCommand searchMenu) {
        this.sortMenu = sortMenu;
        this.searchMenu = searchMenu;
    }

    /**
     * Метод `callSortMenu` викликає команду для відкриття меню сортування.
     *
     * @param rooms       Об'єкт класу `Rooms`, з яким взаємодіє меню сортування.
     * @param numberRoom  Номер кімнати, в якій відбувається сортування.
     */
    public void callSortMenu(Rooms rooms, int numberRoom) {
        sortMenu.execute(rooms, numberRoom);
    }

    /**
     * Метод `callSearchMenu` викликає команду для відкриття меню пошуку.
     *
     * @param rooms       Об'єкт класу `Rooms`, з яким взаємодіє меню пошуку.
     * @param numberRoom  Номер кімнати, в якій відбувається пошук.
     */
    public void callSearchMenu(Rooms rooms, int numberRoom) {
        searchMenu.execute(rooms, numberRoom);
    }
}