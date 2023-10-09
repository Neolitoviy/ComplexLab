package Inventory;

public class Sport extends Inventory {
    private final String SportName;
    private final String quality;

    public Sport(String size, String name, int price, String SportName, String quality, int id, int number) {
        super(new Description(size, name, price, id, number)); // Виклик конструктора батьківського класу Inventory
        this.SportName = SportName;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return "Sport{" +
                "SportName='" + SportName +
                ", Quality='" + quality +
                ", Description=" + getDesc() +
                '}';
    }
}
