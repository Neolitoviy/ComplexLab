package Inventory;

public class Toy extends Inventory {
    private final String brand;

    public Toy(String size, String name, int price, int number, String brand, int id) {
        desc = new Description(size, name, price, id, number);
        this.brand = brand;
        setGroup("Toy");
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public String toString() {
        return  "\nІграшка :" +
                "\nБренд = " + brand
                + desc;
    }


}
