package Inventory;

//import org.junit.Ignore;

import java.util.Scanner;

public class Sport extends Inventory {
    private String sportName;
    private String quality;

    public Sport(String size, String name, int price, String sportName, String quality, int id, int number) {
        desc = new Description(size, name, price, id, number);
        this.sportName = sportName;
        this.quality = quality;
        setGroup("Sport");
    }


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

    @Override
    public String toString() {
        return
                "\nСпортивний еквіп :" +
                        "\nСпортивна приналежність = " + sportName +
                        "\nЯкість = " + quality
                        + desc;
    }

    public String getSportName() {
        return sportName;
    }

    public String getQuality() {
        return quality;
    }
}
