package Menues;

import Rooms.Rooms;
import Interfaces.RoomCommand;
import Invokers.SortAndSearchInvoker;
import Reciever.CallerSearch;
import Reciever.CallerSort;

import java.util.Scanner;

/**
 * Клас, що представляє меню всіх кімнат.
 */
public class RoomsMenu {
    /**
     * Об'єкт для виклику команди пошуку.
     */
    private RoomCommand search = new CallerSearch();

    /**
     * Об'єкт для виклику команди сортування.
     */
    private RoomCommand sort = new CallerSort();

    /**
     * Об'єкт для виклику команд пошуку та сортування.
     */
    private SortAndSearchInvoker inv = new SortAndSearchInvoker(sort, search);

    /**
     * Конструктор класу RoomsMenu.
     *
     * @param rooms Об'єкт класу Rooms, який містить інформацію про кімнати та інвентар.
     */
    public RoomsMenu(Rooms rooms) {
        boolean loop = true;

        while (loop) {
            System.out.println("\n\tМеню всіх кімнат:");
            System.out.println("1. Перелік всього інвентарю");
            System.out.println("2. Пошук");
            System.out.println("3. Сортування");
            System.out.println("4. Назад");

            System.out.print("Введіть вибір:");
            Scanner scan = new Scanner(System.in);
            int choice = scan.nextInt();

            switch (choice) {
                case 1 -> rooms.showAllInventory();
                case 2 -> inv.callSearchMenu(rooms, -1);
                case 3 -> inv.callSortMenu(rooms, -1);
                case 4 -> loop = false;
            }
        }
    }
}
