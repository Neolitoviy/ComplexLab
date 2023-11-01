package Inventory;

import java.util.Scanner;

/**
 * Клас `Device` представляє інвентар у формі цифрових приладів та містить інформацію про кожний об'єкт.
 * Цей клас успадковує властивості з базового класу `Inventory`.
 */
public class Device extends Inventory {
    private final int rentCost;
    private final int termMonth;

    /**
     * Конструктор класу `Device`, який ініціалізує інформацію про цифровий прилад.
     *
     * @param size      Розмір приладу.
     * @param name      Назва приладу.
     * @param price     Ціна приладу.
     * @param rentCost  Вартість оренди приладу.
     * @param termMonth Термін оренди приладу в місяцях.
     * @param id        Унікальний ідентифікатор приладу.
     * @param number    Кількість приладів.
     */
    public Device(String size, String name, int price, int rentCost, int termMonth, int id, int number) {
        desc = new Description(size, name, price, id, number);
        this.rentCost = rentCost;
        this.termMonth = termMonth;
        setGroup("Device");
    }

    /**
     * Повертає рядкове представлення об'єкту `Device`, включаючи інформацію про цифровий прилад та його опис.
     *
     * @return Рядкове представлення об'єкту `Device`.
     */
    @Override
    public String toString() {
        return "\nЦифрові прилади :" +
                "\nВартість оренди = " + rentCost +
                "\nКількість місяців = " + termMonth
                + desc;
    }

    /**
     * Конструктор класу `Device` без параметрів, який дозволяє введення даних про цифровий прилад з консолі.
     */
    public Device() {
        setGroup("Device");
        String size, nameToy;
        int price, id;
        Scanner scanInt = new Scanner(System.in);
        Scanner scanString = new Scanner(System.in);
        System.out.println("Введіть розмір:");
        size = scanString.nextLine();
        System.out.println("Введіть назву:");
        nameToy = scanString.nextLine();
        System.out.println("Введіть ціну:");
        price = scanInt.nextInt();
        System.out.println("Введіть ідентифікатор:");
        id = scanInt.nextInt();

        System.out.println("Введіть вартість оренди:");
        rentCost = scanInt.nextInt();
        System.out.println("Введіть термін оренди (у місяцях):");
        termMonth = scanInt.nextInt();
        desc = new Description(size, nameToy, price, id, 1);
    }

    /**
     * Повертає вартість оренди цифрового приладу.
     *
     * @return Вартість оренди приладу.
     */
    public int getRentCost() {
        return rentCost;
    }

    /**
     * Повертає термін оренди цифрового приладу в місяцях.
     *
     * @return Термін оренди приладу в місяцях.
     */
    public int getTermMonth() {
        return termMonth;
    }
}
