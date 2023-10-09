package Inventory;

public abstract class Inventory {
    protected Description desc;

    public Inventory(Description desc) {
        this.desc = desc;
    }

    public Description getDesc() {
        return this.desc;
    }

}
