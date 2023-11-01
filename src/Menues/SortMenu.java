package Menues;

import Rooms.Rooms;

import java.util.Scanner;

/**
 * Клас `SortMenu` відображає меню сортування та обробку користувацьких виборів.
 * Використовується для взаємодії з користувачем у виборі параметрів сортування об'єктів у `Rooms`.
 *
 * Цей клас може бути використаний як для сортування в усіх кімнатах, так і для сортування в конкретній кімнаті.
 * Щоб використовувати сортування в конкретній кімнаті, необхідно вказати номер кімнати у конструкторі.
 */
public class SortMenu {
    private boolean loop = true;

    /**
     * Конструктор класу `SortMenu`.
     *
     * @param rooms         Екземпляр класу `Rooms`, який представляє усі кімнати для сортування.
     * @param numberRoom    Номер кімнати, в якій ведеться сортування. Якщо `-1`, то сортування виконується в усіх кімнатах.
     */
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

    /**
     * Обробляє вибір користувача щодо сортування об'єктів в кімнатах.
     *
     * @param choice      Вибір користувача.
     * @param rooms       Екземпляр класу `Rooms`, в якому виконується сортування.
     * @param numberRoom  Номер кімнати, в якій ведеться сортування.
     */
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
