package Inventory;

import java.util.Scanner;

/**
 * Клас `Toy` представляє інвентар у формі іграшок та містить інформацію про кожний об'єкт.
 * Цей клас розширює властивості базового класу `Inventory`.
 */
public class Toy extends Inventory {
    private final String brand;

    /**
     * Конструктор класу `Toy`, який ініціалізує інформацію про іграшку.
     *
     * @param size      Розмір іграшки.
     * @param name      Назва іграшки.
     * @param price     Ціна іграшки.
     * @param id        Унікальний ідентифікатор іграшки.
     * @param brand     Бренд іграшки.
     * @param number    Кількість іграшок.
     */
    public Toy(String size, String name, int price, int id, String brand, int number) {
        desc = new Description(size, name, price, id, number);
        this.brand = brand;
        setGroup("Toy");
    }

    /**
     * Конструктор класу `Toy` без параметрів, який дозволяє введення даних про іграшку з консолі.
     */
    public Toy() {
        setGroup("Toy");
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

        System.out.println("Введіть бренд:");
        brand = scanString.nextLine();

        desc = new Description(size, nameToy, price, id, 1);
    }

    /**
     * Повертає рядкове представлення об'єкту `Toy`, включаючи інформацію про іграшку та її опис.
     *
     * @return Рядкове представлення об'єкту `Toy`.
     */
    @Override
    public String toString() {
        return "\nІграшка :" +
                "\nБренд = " + brand
                + desc;
    }

    /**
     * Повертає бренд іграшки.
     *
     * @return Бренд іграшки.
     */
    public String getBrand() {
        return brand;
    }
}
