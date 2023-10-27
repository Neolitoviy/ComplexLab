package Inventory;

public class Description {
    private String size;
    private String ToyName;
    private int price;
    private int id;
    private final int number;

    public Description(String size, String nameToy, int price,int id,int number) {
        this.size = size;
        this.ToyName = nameToy;
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

    public void setToyName(String rename) {
        this.ToyName = rename;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Description getDesc(){
        return this;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return  "\n\tОпис: " +
                "\n\tРозмір = " + size +
                "\n\tНазва іграшки = " + ToyName +
                "\n\tЦіна = " + price +
                "\n\tID = " + id +
                "\n\tКількість = " + number;
    }
}
