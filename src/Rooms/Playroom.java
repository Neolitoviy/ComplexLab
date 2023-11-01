package Rooms;

import Inventory.Inventory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import Inventory.*;
import Logger.MyLogger;

/**
 * Клас `Playroom` представляє ігрову кімнату, де зберігаються іграшки та обладнання.
 * Кожна ігрова кімната має свою назву, номер, та максимальну кількість іграшок.
 * Також клас взаємодіє з базою даних та здійснює облік бюджету та кількості іграшок.
 */
public class Playroom {
    ArrayList<Inventory> invent; // Список іграшок та обладнання в ігровій кімнаті
    String nameOfRoom;          // Назва ігрової кімнати
    Connection conn;            // З'єднання з базою даних
    int noRoom;                 // Номер кімнати
    int numberToys;             // Максимальна кількість іграшок
    Rooms build;                // Посилання на об'єкт, який представляє будівлю


    /**
     * Конструктор класу `Playroom` ініціалізує ігрову кімнату з вказаною назвою, номером, максимальною кількістю іграшок,
     * з'єднанням з базою даних та посиланням на об'єкт, який представляє будівлю.
     *
     * @param nameOfRoom Назва ігрової кімнати.
     * @param noRoom     Номер кімнати.
     * @param numberToys Максимальна кількість іграшок в кімнаті.
     * @param conn       З'єднання з базою даних.
     * @param build      Об'єкт, який представляє будівлю.
     */
    public Playroom(String nameOfRoom, int noRoom, int numberToys, Connection conn, Rooms build) {
        this.build = build;
        this.conn = conn;
        invent = new ArrayList<>();
        this.nameOfRoom = nameOfRoom;
        this.noRoom = noRoom;
        this.numberToys = numberToys;
    }

    /**
     * Метод для додавання іграшки або обладнання до ігрової кімнати.
     *
     * @param inv Інвентар, який потрібно додати.
     */
    public void buyInventory(Inventory inv) {
        invent.add(inv);
    }

    /**
     * Метод для відображення інвентаря ігрової кімнати.
     */
    public void showInventory() {
        System.out.println(nameOfRoom + ":");
        for (Inventory inventory : invent) {
            System.out.println(inventory);
        }
    }

    /**
     * Метод для пошуку інвентаря за групою.
     *
     * @param group Група інвентаря для пошуку.
     * @return `true`, якщо інвентар знайдено; `false`, якщо інвентар не знайдено.
     */
    public boolean searchByGroup(String group) {
        boolean founded = false;
        for (Inventory inventory : invent) {
            if (inventory.getGroup().equalsIgnoreCase(group)) {
                System.out.println(inventory);
                founded = true;
            }
        }
        return founded;
    }

    /**
     * Метод для пошуку інвентаря за розміром.
     *
     * @param size Розмір інвентаря для пошуку.
     * @return `true`, якщо інвентар знайдено; `false`, якщо інвентар не знайдено.
     */
    public boolean searchBySize(String size){
        boolean founded = false;
        for (Inventory inventory : invent) {
            if (inventory.getDesc().getSize().equalsIgnoreCase(size)) {
                System.out.println(inventory);
                founded = true;
            }
        }
        return founded;
    }

    /**
     * Метод для пошуку інвентаря за назвою.
     *
     * @param name Назва інвентаря для пошуку.
     * @return `true`, якщо інвентар знайдено; `false`, якщо інвентар не знайдено.
     */
    public boolean searchByName(String name){
        boolean founded = false;
        for (Inventory inventory : invent) {
            if (inventory.getDesc().getToyName().equalsIgnoreCase(name)) {
                System.out.println(inventory);
                founded = true;
            }
        }
        return founded;
    }

    /**
     * Метод для сортування інвентаря за розміром і відображення результату.
     */
    public void sortBySize(){
        invent.sort(Comparator.comparing(Inventory::getSize));
        showInventory();
    }

    /**
     * Метод для сортування інвентаря за ціною і відображення результату.
     */
    public void sortByPrice(){
        invent.sort(Comparator.comparing(Inventory::getPrice));
        showInventory();
    }

    /**
     * Метод для сортування інвентаря за групою і відображення результату.
     */
    public void sortByGroup(){
        invent.sort(Comparator.comparing(Inventory::getGroup));
        showInventory();
    }

    /**
     * Метод для сортування інвентаря за кількістю і відображення результату.
     */
    public void sortByNumber(){
        invent.sort(Comparator.comparing(Inventory::getNumber));
        showInventory();
    }

    /**
     * Метод для отримання списку інвентарю в ігровій кімнаті.
     *
     * @return Список інвентарю.
     */
    public ArrayList<Inventory> getInvent() {
        return invent;
    }

    /**
     * Метод для додавання нової іграшки або обладнання до ігрової кімнати та оновлення бази даних.
     *
     * @throws SQLException Виняток, який виникає при помилках підключення до бази даних.
     */
    public void addNewToy() throws SQLException {
        System.out.println("\tМЕНЮ ДОДАВАННЯ");
        System.out.println("1 - Додати спорт еквіп в інвентар");
        System.out.println("2 - Додати іграшку в інвентар");
        System.out.println("3 - Додати пристрій в інвентар");
        Scanner scan = new Scanner(System.in);
        System.out.println("Введіть вибір:");

        int choice = scan.nextInt();

        Inventory tempObj;
        String tableName;
        switch (choice) {
            case 1 -> {
                tableName = "dbo.SportRoom";
                tempObj = new Sport();
            }
            case 2 -> {
                tableName = "dbo.ToysRoom";
                tempObj = new Toy();
            }
            case 3 -> {
                tableName = "dbo.DeviceRoom";
                tempObj = new Device();
            }
            default -> {
                System.out.println("Невірний ввід");
                return;
            }
        }

        int check = 0;
        for(Inventory i : invent){
            if(i.getDesc().getId() == tempObj.getDesc().getId()){
                i.incNumber();
                check = 1;
            }
        }
        if(check == 0){
            invent.add(tempObj);
        }
        build.getAccounting().reduceBudget(tempObj.getPrice());
        build.getAccounting().addNewToy();
        tableName += noRoom;
        updateDB(tempObj,tableName);
    }

    /**
     * Метод для оновлення записів бази даних після додавання нового інвентарю.
     *
     * @param obj   Інвентар, який було додано.
     * @param table Назва таблиці в базі даних для оновлення.
     * @throws SQLException Виняток, який виникає при помилках підключення до бази даних.
     */
    public void updateDB(Inventory obj,String table) throws SQLException {
        Statement stat;
        try {
            stat = conn.createStatement();
            MyLogger.getLogger().info("Підключення до додавання було встановлено");
        }
        catch (SQLException e){
            MyLogger.getLogger().severe("Неможливо підключитися");
            return;
        }
        ResultSet rs = stat.executeQuery("SELECT * FROM " + table + " WHERE id=" + obj.getDesc().getId());
        if(!rs.isBeforeFirst()){
            if(obj.getGroup().equalsIgnoreCase("Sport")){
                stat.execute("INSERT INTO " + table + " (size,name,price,id,number,quality,sportName) " + "VALUES "
                        + "('" + obj.getSize()+ "','" + obj.getName() +  "',"+ obj.getPrice() + "," + obj.getDesc().getId()
                        + "," + obj.getNumber() + ",'" +  ((Sport)obj).getQuality()+ "','" +((Sport)obj).getSportName() + "')");
            }
            else if(obj.getGroup().equalsIgnoreCase("Toy")){
               stat.execute("INSERT INTO " + table + " (size,name,price,id,number,brand) " + "VALUES "
                        + "('" + obj.getSize() +"','" + obj.getName() + "',"+obj.getPrice() + "," + obj.getDesc().getId()
                        + "," + obj.getNumber() + ",'" + ((Toy)obj).getBrand() + "')");
            }
            else if(obj.getGroup().equalsIgnoreCase("Device")){
                stat.execute("INSERT INTO " + table + " (size,name,price,id,number,rentCost,termMonth) " + "VALUES "
                        + "('" + obj.getSize() +"','" + obj.getName() + "',"+obj.getPrice() + "," + obj.getDesc().getId()
                        + "," + obj.getNumber() + "," + ((Device)obj).getRentCost() + "," + ((Device)obj).getTermMonth() + ")");
            }
        }
        else {
            stat.execute("UPDATE " + table + " SET number=number+1" + " WHERE id=" + obj.getDesc().getId());
        }
    }
}