package Menues;

import Invokers.MainMenuInvoker;
import Reciever.CallerBuildMenu;
import Reciever.CallerRoomMenu;
import Reciever.CallerExit;

import java.util.Scanner;

public class MenuInitialization {
    public MenuInitialization(){
        CallerBuildMenu buildMenu = new CallerBuildMenu();
        CallerRoomMenu roomMenu = new CallerRoomMenu();
        CallerExit exit = new CallerExit();
        MainMenuInvoker invoker = new MainMenuInvoker(roomMenu,buildMenu,exit);

        while(true) {
            System.out.println("\t\t\t\tMenu:");
            System.out.println("1. Work with all rooms");
            System.out.println("2. Work with certain room");
            System.out.println("3. Exit");
            System.out.print("Enter choice:");

            Scanner scan = new Scanner(System.in);
            int choice = scan.nextInt();

            switch (choice) {
                case 1 -> invoker.callBuildingMenu();
                case 2 -> invoker.callRoomMenu();
                default -> invoker.callExit();
            }
        }
    }
}
