package Inventory;

public class Device extends Inventory {
    private final int rentCost;
    private final int termMonth;

    public Device(String size,String name,int price,int rentCost,int termMonth,int id,int number){
        desc = new Description(size,name,price,id,number);
        this.rentCost = rentCost;
        this.termMonth = termMonth;
        setGroup("Device");
    }

    public int getRentCost() {
        return rentCost;
    }

    @Override
    public String toString() {
        return  "\nЦифрові прилади :" +
                "\nВартість оренди = " + rentCost +
                "\nКількість місяців = " + termMonth
                + desc;
    }
}
