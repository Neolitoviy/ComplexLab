package Menues;

import Rooms.Rooms;

import java.util.Scanner;

public class SearchMenu {
    public SearchMenu(Rooms rooms, int numberRoom) {
        boolean loop = true;
        Scanner scan = new Scanner(System.in);

        while (loop) {
            printSearchMenu();

            int choice = scan.nextInt();
            scan.nextLine();

            if (numberRoom == -1) {
                handleUserChoice(choice, rooms);
            } else {
                handleUserChoiceInRoom(choice, rooms, numberRoom);
            }

            if (choice == 4)
                loop = false;

            if (choice == 5) {
                System.out.println("\n\tДо зустрічі!");
                System.exit(0);
            }
        }
    }

    private void printSearchMenu() {
        System.out.println("\n\t\tМеню пошуку:");
        System.out.println("1. Пошук за групою");
        System.out.println("2. Пошук за розміром");
        System.out.println("3. Пошук за ім'ям");
        System.out.println("4. Назад");
        System.out.println("5. Вихід");
    }

    private void handleUserChoice(int choice, Rooms rooms) {
        Scanner scan = new Scanner(System.in);
        String searching;

        switch (choice) {
            case 1 -> {
                System.out.println("Введіть групу:");
                searching = scan.nextLine();
                System.out.println("\nРезультат:");
                if (searching.equalsIgnoreCase("Device") || searching.equalsIgnoreCase("Sport") || searching.equalsIgnoreCase("Toy")) {
                    rooms.searchByGroup(searching);
                }
            }
            case 2 -> {
                System.out.println("Введіть розмір:");
                searching = scan.nextLine();
                System.out.println("\nРезультат:");
                if (searching.equalsIgnoreCase("small") || searching.equalsIgnoreCase("medium") || searching.equalsIgnoreCase("large")) {
                    rooms.searchBySize(searching);
                }
            }
            case 3 -> {
                System.out.println("Введіть ім'я:");
                searching = scan.nextLine();
                System.out.println("\nРезультат:");
                rooms.searchByName(searching);
            }
        }
    }

    private void handleUserChoiceInRoom(int choice, Rooms rooms, int numberRoom) {
        Scanner scan = new Scanner(System.in);
        String searching;

        switch (choice) {
            case 1 -> {
                System.out.println("Введіть групу:");
                searching = scan.nextLine();
                System.out.println("\nРезультат:");
                if (searching.equalsIgnoreCase("Device") || searching.equalsIgnoreCase("Sport") || searching.equalsIgnoreCase("Toy")) {
                    rooms.getRooms().get(numberRoom).searchByGroup(searching);
                }
            }
            case 2 -> {
                System.out.println("Введіть розмір:");
                searching = scan.nextLine();
                System.out.println("\nРезультат:");
                if (searching.equalsIgnoreCase("small") || searching.equalsIgnoreCase("medium") || searching.equalsIgnoreCase("large")) {
                    rooms.getRooms().get(numberRoom).searchBySize(searching);
                }
            }
            case 3 -> {
                System.out.println("Введіть ім'я:");
                searching = scan.nextLine();
                System.out.println("\nРезультат:");
                rooms.getRooms().get(numberRoom).searchByName(searching);
            }
        }
    }
}
