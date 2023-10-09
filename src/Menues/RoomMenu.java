package Menues;

import java.util.Scanner;

public class RoomMenu {
    public RoomMenu(){

        boolean loop = true;

        while(loop){
            System.out.println("\n\tRoom Menu:");
            System.out.println("1. Get in first room");
            System.out.println("2. Get in second room");
            System.out.println("3. Get in third room");
            System.out.println("4. Back");
            System.out.print("Enter choice:");
            Scanner scan = new Scanner(System.in);
            int choice = scan.nextInt();

            switch (choice) {
                case 1 -> System.out.println("Room 1 menu is under maintenance");
                case 2 -> System.out.println("Room 2 menu is under maintenance");
                case 3 -> System.out.println("Room 3 menu is under maintenance");
                case 4 -> loop = false;
                default -> System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
