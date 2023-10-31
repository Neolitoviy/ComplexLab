package Menues;

import Rooms.Rooms;

import java.util.Scanner;

public class SortMenu {
    private boolean loop = true;

    public SortMenu(Rooms rooms, int numberRoom) {
        while (loop) {
            System.out.println("\n\t\tМеню сортування");
            System.out.println("1. Сортувати за розміром");
            System.out.println("2. Сортувати за ціною");
            System.out.println("3. Сортувати за групою");
            System.out.println("4. Сортувати за кількістю іграшок");
            System.out.println("5. Назад");

            Scanner scan = new Scanner(System.in);
            int choice = scan.nextInt();
            processChoice(choice, rooms,numberRoom);
        }
    }

    public void processChoice(int choice, Rooms rooms, int numberRoom){
        if (numberRoom == -1) {
            if (choice == 1) {
                System.out.println("Сортуємо за розміром:");
                rooms.sortBySize();
            } else if (choice == 2) {
                System.out.println("Сортуємо за ціною:");
                rooms.sortByPrice();
            } else if (choice == 3) {
                System.out.println("Сортуємо за групою:");
                rooms.sortByGroup();
            } else if (choice == 4) {
                System.out.println("Сортуємо за кількістю іграшок:");
                rooms.sortByNumber();
            }
        } else {
            if (choice == 1) {
                System.out.println("Сортуємо за розміром:");
                rooms.getRooms().get(numberRoom).sortBySize();
            } else if (choice == 2) {
                System.out.println("Сортуємо за ціною:");
                rooms.getRooms().get(numberRoom).sortByPrice();
            } else if (choice == 3) {
                System.out.println("Сортуємо за групою:");
                rooms.getRooms().get(numberRoom).sortByGroup();
            } else if (choice == 4) {
                System.out.println("Сортуємо за кількістю іграшок:");
                rooms.getRooms().get(numberRoom).sortByNumber();
            }
        }
        if (choice >= 6 || choice <=0) {
            System.out.println("\n\t До зустрічі!");
            System.exit(0);
        }
        if (choice == 5)
            loop = false;
    }
}
