package Inventory;

/**
 * Клас `Description` представляє інформацію про конкретний об'єкт інвентарю.
 *
 * Кожен об'єкт має опис, що включає в себе розмір, назву іграшки, ціну, унікальний ідентифікатор та кількість.
 */
public class Description {
    private String size;
    private final String ToyName;
    private final int price;
    private final int id;
    private  int number;

    /**
     * Конструктор класу `Description`, який ініціалізує інформацію про об'єкт інвентарю.
     *
     * @param size      Розмір іграшки.
     * @param nameToy   Назва іграшки.
     * @param price     Ціна іграшки.
     * @param id        Унікальний ідентифікатор іграшки.
     * @param number    Кількість іграшок.
     */
    public Description(String size, String nameToy, int price, int id, int number) {
        this.size = size;
        this.ToyName = nameToy;
        this.price = price;
        this.id = id;
        this.number = number;
    }

    /**
     * Повертає розмір інвентарю.
     *
     * @return Розмір інвентарю.
     */
    public String getSize() {
        return size;
    }

    /**
     * Встановлює розмір інвентарю.
     *
     * @param size Розмір інвентарю.
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * Повертає назву іграшки.
     *
     * @return Назва іграшки.
     */
    public String getToyName() {
        return ToyName;
    }

    /**
     * Повертає ціну інвентарю.
     *
     * @return Ціна інвентарю.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Повертає унікальний ідентифікатор інвентарю.
     *
     * @return Унікальний ідентифікатор.
     */
    public int getId() {
        return id;
    }

    /**
     * Повертає кількість інвентарю.
     *
     * @return Кількість інвентарю.
     */
    public int getNumber() {
        return number;
    }

    /**
     * Збільшує кількість інвентарю на одиницю.
     */
    public void incNumber(){
        number++;
    }

    /**
     * Повертає рядкове представлення об'єкту інвентарю.
     *
     * @return Рядкове представлення опису інвентарю, включаючи розмір, назву, ціну, унікальний ідентифікатор і кількість.
     */
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
