package Inventory;

public class Description {
    private String ToyName;
    private String size;
    private int price;
    private int id;
    private int number;

    public Description(String size, String ToyName, int price, int id, int number) {
        this.size = size;
        this.ToyName = ToyName;
        this.price = price;
        this.id = id;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getToyName() {
        return ToyName;
    }

    public void setToyName(String toyName) {
        this.ToyName = toyName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Description{" +
                "ToyName='" + ToyName +
                ", Id=" + id +
                ", Price=" + price +
                ", Size='" + size +
                ", Number=" + number +
                '}';
    }
}