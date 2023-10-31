package Menues;

import Rooms.Rooms;

import java.util.Scanner;

public class RoomMenu {
    public RoomMenu(Rooms rooms){
        boolean loop = true;

        while(loop){
            System.out.println("\n\tКоридор:");
            System.out.println("1. Увійти в першу кімнату");
            System.out.println("2. Увійти в другу кімнату");
            System.out.println("3. Увійти в третю кімнату");
            System.out.println("4. Назад");
            System.out.print("Введіть вибір:");
            Scanner scan = new Scanner(System.in);
            int choice = scan.nextInt();

            switch (choice) {
                case 1 -> new CertainMenu(0, rooms);
                case 2 -> new CertainMenu(1, rooms);
                case 3 -> new CertainMenu(2, rooms);
                case 4 -> loop = false;
            }
        }
    }
}
