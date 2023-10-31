package Inventory;

public class Description {
    private String size;
    private final String ToyName;
    private final int price;
    private final int id;
    private  int number;

    public Description(String size, String nameToy, int price,int id,int number) {
        this.size = size;
        this.ToyName = nameToy;
        this.price = price;
        this.id = id;
        this.number = number;
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


    public int getPrice() {
        return price;
    }

    public int getId() {
        return id;
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

    public void incNumber(){
        number++;
    }
}
