package Inventory;

public class Device extends Inventory {
    private final int RentCost;
    private final int TermMonth;

    public Device(String size, String name, int price, int RentCost, int TermMonth, int id, int number) {
        super(new Description(size, name, price, id, number)); // Виклик конструктора батьківського класу Inventory
        this.RentCost = RentCost;
        this.TermMonth = TermMonth;
    }

    public int getRentCost() {
        return RentCost;
    }

    @Override
    public String toString() {
        return "Device{" +
                "RentCost=" + RentCost +
                ", TermMonth=" + TermMonth +
                ", Description=" + getDesc() +
                '}';
    }
}
