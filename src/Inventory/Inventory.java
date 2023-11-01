package Inventory;

/**
 * Абстрактний клас `Inventory` представляє інвентар об'єктів і містить загальну інформацію про них.
 *
 * Цей клас слугує як базовий клас для конкретних типів інвентарю, і може бути успадкований і розширений.
 */
public abstract class Inventory {
    Description desc;
    private String group;

    /**
     * Повертає опис інвентарю.
     *
     * @return Опис інвентарю у вигляді об'єкта класу `Description`.
     */
    public Description getDesc(){
        return this.desc;
    }

    /**
     * Повертає розмір інвентарю.
     *
     * @return Розмір інвентарю.
     */
    public String getSize(){return desc.getSize();}

    /**
     * Повертає ім'я інвентарю.
     *
     * @return Ім'я інвентарю.
     */
    public String getName() {return desc.getToyName();}

    /**
     * Повертає групу, до якої належить інвентар.
     *
     * @return Група інвентарю.
     */
    public String getGroup(){
        return group;
    }

    /**
     * Повертає ціну інвентарю.
     *
     * @return Ціна інвентарю.
     */
    public int getPrice(){return desc.getPrice();}

    /**
     * Повертає кількість інвентарю.
     *
     * @return Кількість інвентарю.
     */
    public int getNumber(){return desc.getNumber();}

    /**
     * Встановлює групу для інвентарю.
     *
     * @param group Група, до якої належить інвентар.
     */
    public void setGroup(String group) {
        this.group = group;
    }

    /**
     * Збільшує кількість інвентарю на одиницю.
     */
    public void incNumber(){desc.incNumber();}
}
