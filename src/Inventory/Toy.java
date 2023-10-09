package Inventory;

public class Toy extends Inventory {
    private final String brand;

    public Toy(String size, String name, int price, int id, String brand, int number) {
        super(new Description(size, name, price, id, number)); // Виклик конструктора батьківського класу Inventory
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public String toString() {
        return "Toy{" +
                "Brand='" + brand +
                ", Description=" + getDesc() +
                '}';
    }
}
