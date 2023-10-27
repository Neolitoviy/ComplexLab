package Menues;

import Rooms.Rooms;

import java.util.Scanner;

public class SortMenu {
    private boolean loop = true;

    public SortMenu(Rooms rooms, int numberRoom) {
        while (loop) {
            printSortMenu();

            Scanner scan = new Scanner(System.in);
            int choice = scan.nextInt();
            scan.nextLine();

            if (numberRoom == -1) {
                processChoice(choice, rooms);
            } else {
                processChoiceInRoom(choice, rooms, numberRoom);
            }
        }
    }

    private void printSortMenu() {
        System.out.println("\n\t\tМеню сортування");
        System.out.println("1. Сортувати за розміром");
        System.out.println("2. Сортувати за ціною");
        System.out.println("3. Сортувати за групою");
        System.out.println("4. Сортувати за кількістю іграшок");
        System.out.println("5. Назад");
    }

    private void processChoice(int choice, Rooms rooms) {
        switch (choice) {
            case 1 -> {
                System.out.println("Сортуємо за розміром:");
                rooms.sortBySize();
            }
            case 2 -> {
                System.out.println("Сортуємо за ціною:");
                rooms.sortByPrice();
            }
            case 3 -> {
                System.out.println("Сортуємо за групою:");
                rooms.sortByGroup();
            }
            case 4 -> {
                System.out.println("Сортуємо за кількістю іграшок:");
                rooms.sortByNumber();
            }
            case 5 -> loop = false;
            default -> System.out.println("Невірний вибір. Спробуйте ще раз.");
        }
    }

    private void processChoiceInRoom(int choice, Rooms rooms, int numberRoom) {
        switch (choice) {
            case 1 -> {
                System.out.println("Сортуємо за розміром:");
                rooms.getRooms().get(numberRoom).sortBySize();
            }
            case 2 -> {
                System.out.println("Сортуємо за ціною:");
                rooms.getRooms().get(numberRoom).sortByPrice();
            }
            case 3 -> {
                System.out.println("Сортуємо за групою:");
                rooms.getRooms().get(numberRoom).sortByGroup();
            }
            case 4 -> {
                System.out.println("Сортуємо за кількістю іграшок:");
                rooms.getRooms().get(numberRoom).sortByNumber();
            }
            case 5 -> loop = false;
            default -> System.out.println("Невірний вибір. Спробуйте ще раз.");
        }
    }
}
