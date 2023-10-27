package Menues;

import Rooms.Rooms;
import Interfaces.RoomCommand;
import Invokers.SortAndSearchInvoker;
import Reciever.CallerSearch;
import Reciever.CallerSort;

import java.util.Scanner;

public class CertainMenu {
    private final RoomCommand sortMenu = new CallerSort();
    private final RoomCommand searchMenu = new CallerSearch();

    SortAndSearchInvoker inv = new SortAndSearchInvoker(sortMenu, searchMenu);

    public CertainMenu(int numberRoom, Rooms rooms) {
        boolean loop = true;

        while (loop) {
            System.out.println("\t\tМеню певної кімнати:");
            System.out.println("1. Показати інвентар кімнати");
            System.out.println("2. Пошук");
            System.out.println("3. Сортування");
            System.out.println("4. Назад");

            Scanner scan = new Scanner(System.in);
            int choice = scan.nextInt();

            switch (choice) {
                case 1 -> rooms.showInventoryInRoom(numberRoom);
                case 2 -> inv.callSearchMenu(rooms, numberRoom);
                case 3 -> inv.callSortMenu(rooms, numberRoom);
                case 4 -> loop = false;
            }
        }
    }
}
