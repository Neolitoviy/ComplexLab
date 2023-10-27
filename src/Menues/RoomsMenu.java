package Menues;

import Rooms.Rooms;
import Interfaces.RoomCommand;
import Invokers.SortAndSearchInvoker;
import Reciever.CallerSearch;
import Reciever.CallerSort;

import java.util.Scanner;

public class RoomsMenu {
    public RoomsMenu(Rooms rooms) {
        RoomCommand search = new CallerSearch();
        RoomCommand sort = new CallerSort();
        SortAndSearchInvoker inv = new SortAndSearchInvoker(sort, search);
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
