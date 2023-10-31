package Inventory;

import java.util.Scanner;

public class Toy extends Inventory {
    private String brand;

    public Toy(String size,String name,int price,int id,String brand,int number){
        desc = new Description(size,name,price,id,number);
        this.brand = brand;
        setGroup("Toy");
    }

    @Override
    public String toString() {
        return  "\nІграшка :" +
                "\nБренд = " + brand
                + desc;
    }
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


    public String getBrand() {
        return brand;
    }
}
