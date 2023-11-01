package Inventory;

//import org.junit.Ignore;

import java.util.Scanner;

/**
 * Клас `Sport` представляє інвентар у формі спортивного обладнання та містить інформацію про кожний об'єкт.
 * Цей клас розширює властивості базового класу `Inventory`.
 */
public class Sport extends Inventory {
    private final String sportName;
    private final String quality;

    /**
     * Конструктор класу `Sport`, який ініціалізує інформацію про спортивний інвентар.
     *
     * @param size      Розмір інвентарю.
     * @param name      Назва інвентарю.
     * @param price     Ціна інвентарю.
     * @param sportName Назва виду спорту.
     * @param quality   Якість інвентарю.
     * @param id        Унікальний ідентифікатор інвентарю.
     * @param number    Кількість інвентарю.
     */
    public Sport(String size, String name, int price, String sportName, String quality, int id, int number) {
        desc = new Description(size, name, price, id, number);
        this.sportName = sportName;
        this.quality = quality;
        setGroup("Sport");
    }

    /**
     * Конструктор класу `Sport` без параметрів, який дозволяє введення даних про спортивний інвентар з консолі.
     */
    public Sport() {
        setGroup("Sport");
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

        System.out.println("Введіть якість:");
        quality = scanString.nextLine();
        System.out.println("Введіть назву виду спорту:");
        sportName = scanString.nextLine();
        desc = new Description(size, nameToy, price, id, 1);
    }

    /**
     * Повертає рядкове представлення об'єкту `Sport`, включаючи інформацію про спортивний інвентар та його опис.
     *
     * @return Рядкове представлення об'єкту `Sport`.
     */
    @Override
    public String toString() {
        return
                "\nСпортивний еквіп :" +
                        "\nСпортивна приналежність = " + sportName +
                        "\nЯкість = " + quality
                        + desc;
    }

    /**
     * Повертає назву виду спорту спортивного інвентарю.
     *
     * @return Назва виду спорту.
     */
    public String getSportName() {
        return sportName;
    }

    /**
     * Повертає якість спортивного інвентарю.
     *
     * @return Якість інвентарю.
     */
    public String getQuality() {
        return quality;
    }
}
