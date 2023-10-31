package Inventory;

import java.util.Scanner;

public class Device extends Inventory {
    private final int rentCost;
    private final int termMonth;

    public Device(String size,String name,int price,int rentCost,int termMonth,int id,int number){
        desc = new Description(size,name,price,id,number);
        this.rentCost = rentCost;
        this.termMonth = termMonth;
        setGroup("Device");
    }

    @Override
    public String toString() {
        return  "\nЦифрові прилади :" +
                "\nВартість оренди = " + rentCost +
                "\nКількість місяців = " + termMonth
                + desc;
    }

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

    public int getRentCost() {
        return rentCost;
    }

    public int getTermMonth() {
        return termMonth;
    }
}
