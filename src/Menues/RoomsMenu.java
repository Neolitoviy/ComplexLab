package Menues;

import Invokers.SortAndSearchInvoker;
import Reciever.CallerSearch;
import Reciever.CallerSort;

import java.util.Scanner;

public class RoomsMenu {
    public RoomsMenu(){
        CallerSearch search = new CallerSearch();
        CallerSort sort = new CallerSort();
        SortAndSearchInvoker inv = new SortAndSearchInvoker(sort,search);
        boolean loop = true;

        while(loop){
            System.out.println("\n\tRooms Menu:");
            System.out.println("1. List all inventory");
            System.out.println("2. Search");
            System.out.println("3. Sort");
            System.out.println("4. Back");

            System.out.print("Enter choice:");
            Scanner scan = new Scanner(System.in);
            int choice = scan.nextInt();

            switch (choice) {
                case 1 -> { // TODO: 09.10.2023  ;
                }
                case 2 -> inv.callSearchMenu();
                case 3 -> inv.callSortMenu();
                case 4 -> loop = false;
            }
        }
    }
}
