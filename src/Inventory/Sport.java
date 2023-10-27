package Inventory;

public class Sport extends Inventory {
    private final String sportName;
    private final String quality;

    public Sport(String size, String name, int price, String sportName, String quality, int id, int number) {
        desc = new Description(size, name, price, id, number);
        this.sportName = sportName;
        this.quality = quality;
        setGroup("SportEquipment");
    }

    @Override
    public String toString() {
        return
                "\nСпортивний еквіп :" +
                        "\nСпортивна приналежність = " + sportName +
                        "\nЯкість = " + quality
                        + desc;
    }
}
