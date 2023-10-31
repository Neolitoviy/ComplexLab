package Menues;

import Rooms.Rooms;
import Invokers.MainMenuInvoker;
import Logger.MyLogger;
import Reciever.CallerBuildMenu;
import Reciever.CallerRoomsMenu;

import java.util.Scanner;

public class MenuInitialization {
    public MenuInitialization(Rooms rooms) {
        CallerBuildMenu buildMenu = new CallerBuildMenu();
        CallerRoomsMenu roomMenu = new CallerRoomsMenu();
        MainMenuInvoker invoker = new MainMenuInvoker(roomMenu,buildMenu);

        while(true) {
            System.out.println("\t\t\t\tМеню:");
            System.out.println("1. Робота з усіма кімнатами");
            System.out.println("2. Робота з певною кімнатою");
            System.out.println("3. Отримати інформацію про бюджет");
            System.out.println("4. Вихід");
            System.out.print("Введіть вибір:");

            Scanner scan = new Scanner(System.in);
            int choice = scan.nextInt();

            switch (choice) {
                case 1 -> invoker.callBuildingMenu(rooms);
                case 2 -> invoker.callRoomMenu(rooms);
                case 3 -> rooms.budgetInfo();
                default -> {
                    System.out.println("\n\tДо зустрічі!");
                    MyLogger.getLogger().info("Program finished");
                    System.exit(0);
                }
            }
        }
    }
}
