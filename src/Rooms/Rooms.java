package Rooms;

import Factories.DeviceFactory;
import Factories.SportFactory;
import Factories.ToyFactory;
import Interfaces.InventoryFactory;
import Inventory.Device;
import Inventory.Inventory;
import Inventory.Sport;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Клас `Rooms` представляє об'єкт, який включає кілька ігрових кімнат у будівлі "Іграшковий дім".
 * Він керує обліком бюджету, інвентарем та робить запити до бази даних для заповнення кімнат інвентарем.
 */
public class Rooms {
    private final ArrayList<Playroom> rooms;
    private final Accounting accounting;
    private final ArrayList<Inventory> fullInvent;

    /**
     * Конструктор класу `Rooms` ініціалізує об'єкт, створює облік бюджету та ініціалізує ігрові кімнати.
     *
     * @param conn Підключення до бази даних для заповнення кімнат інвентарем.
     */
    public Rooms(Connection conn){
        accounting = new Accounting();
        fullInvent = new ArrayList<Inventory>();
        rooms = new ArrayList <>(3);
        for(int i = 0;i < 3;i++){
            String name = "Кімната - " + (i+1);
            rooms.add(new Playroom(name,i+1,accounting.getMaxNumberToys() / 3,conn,this));
        }
    }

    /**
     * Повертає об'єкт обліку бюджету та кількості іграшок.
     *
     * @return Об'єкт обліку бюджету та кількості іграшок.
     */
    public Accounting getAccounting() {
        return accounting;
    }

    /**
     * Метод заповнює кімнати інвентарем з бази даних.
     *
     * @param conn Підключення до бази даних.
     * @return `true`, якщо заповнення кімнат пройшло успішно.
     * @throws SQLException Виникає, якщо сталася помилка під час роботи з базою даних.
     */
    public boolean fillRooms(Connection conn) throws SQLException {
        for (int i = 0; i < rooms.size(); i++) {
            buyInventoryFromSSMSTable(conn, "dbo.SportRoom", (i + 1), new SportFactory(), 3);
            buyInventoryFromSSMSTable(conn, "dbo.DeviceRoom", (i + 1), new DeviceFactory(), 3);
            buyInventoryFromSSMSTable(conn, "dbo.ToysRoom", (i + 1), new ToyFactory(), 3);
        }
        fillFullInvent();
        return true;
    }

    /**
     * Приватний метод для купівлі інвентарю з бази даних та додавання його до ігрової кімнати.
     *
     * @param conn                Підключення до бази даних.
     * @param tableName           Назва таблиці в базі даних.
     * @param index               Індекс кімнати (номер кімнати).
     * @param factory             Фабрика для створення об'єктів інвентарю.
     * @param priceColumnIndex    Індекс стовпця з цінами в базі даних.
     * @throws SQLException        Виникає, якщо сталася помилка під час роботи з базою даних.
     */
    private void buyInventoryFromSSMSTable(Connection conn, String tableName, int index, InventoryFactory factory, int priceColumnIndex) throws SQLException {
        Statement stat = conn.createStatement();
        String query = "Select * from " + tableName + index;
        ResultSet rs = stat.executeQuery(query);

        while (rs.next()) {
            if (((accounting.getCurBudget() - rs.getInt(3)) < 0) ||  (accounting.getCurNumberToys() == accounting.getMaxNumberToys())) {
                System.out.println("Неможливо купити - " + rs.getString(2) + " ID:" + rs.getInt(6));
            } else {
                rooms.get(index).buyInventory(factory.createInventory(rs));
                accounting.reduceBudget(rs.getInt(3));
                accounting.addNewToy();
            }
        }
    }

    /**
     * Метод відображає всі предмети інвентарю у всіх ігрових кімнатах.
     */
    public void showAllInventory(){
        for(Inventory invent : fullInvent){
            System.out.println(invent);
        }
    }

    /**
     * Метод відображає інвентар у конкретній ігровій кімнаті за заданим номером.
     *
     * @param numberRoom Номер ігрової кімнати.
     */
    public void showInventoryInRoom(int numberRoom){
        rooms.get(numberRoom).showInventory();
    }

    /**
     * Метод виконує пошук предметів інвентарю за групою.
     *
     * @param group Назва групи для пошуку.
     * @return `true`, якщо були знайдені предмети інвентарю в ігрових кімнатах.
     */
    public boolean searchByGroup(String group){
        boolean founded = false;
        for (Playroom room : rooms) {
            if(room.searchByGroup(group))
                founded = true;
        }
        return founded;
    }

    /**
     * Метод виконує пошук предметів інвентарю за розміром.
     *
     * @param size Розмір для пошуку.
     * @return `true`, якщо були знайдені предмети інвентарю в ігрових кімнатах.
     */
    public boolean searchBySize(String size){
        boolean founded = false;
        for (Playroom room : rooms) {
            if(room.searchBySize(size))
                founded = true;
        }
        return founded;
    }

    /**
     * Метод виконує пошук предметів інвентарю за ім'ям.
     *
     * @param name Назва для пошуку.
     * @return `true`, якщо були знайдені предмети інвентарю в ігрових кімнатах.
     */
    public boolean searchByName(String name){
        boolean founded = false;
        for (Playroom room : rooms) {
            if(room.searchByName(name))
                founded = true;
        }
        return founded;
    }

    /**
     * Сортує весь інвентар за розміром та виводить його.
     */
    public void sortBySize(){
        fullInvent.sort(Comparator.comparing(Inventory::getSize));
        showAllInventory();
    }

    /**
     * Сортує весь інвентар за ціною та виводить його.
     */
    public void sortByPrice(){
        fullInvent.sort(Comparator.comparing(Inventory::getPrice));
        showAllInventory();
    }

    /**
     * Сортує весь інвентар за групою та виводить його.
     */
    public void sortByGroup(){
        fullInvent.sort(Comparator.comparing(Inventory::getGroup));
        showAllInventory();
    }

    /**
     * Сортує весь інвентар за кількістю та виводить його.
     */
    public void sortByNumber(){
        fullInvent.sort(Comparator.comparing(Inventory::getNumber));
        showAllInventory();
    }

    /**
     * Повертає список ігрових кімнат.
     *
     * @return Список ігрових кімнат.
     */
    public ArrayList<Playroom> getRooms() {
        return rooms;
    }

    /**
     * Виводить інформацію про поточний бюджет.
     */
    public void budgetInfo(){
        System.out.println(accounting);
    }

    /**
     * Заповнює список інвентарю від усіх ігрових кімнат.
     */
    void fillFullInvent(){
        for (Playroom room : rooms) {
            fullInvent.addAll(room.invent);
        }
    }

    /**
     * Тестовий метод для заповнення ігрових кімнат інвентарем.
     */
    public void fillRoomsTest(){
        rooms.get(1).buyInventory(new Device("large","laptop",777,100,2,25616,3));
        rooms.get(0).buyInventory(new Sport("medium","ball machine",500,"football","new",15124,1));
        rooms.get(1).buyInventory(new Device("small","tablet",100,50,2,25612,1));
    }

    /**
     * Тестовий метод для заповнення інвентарю вручну.
     */
    public void fillInventTest(){
        fullInvent.add(new Device("large","laptop",777,100,2,25616,3));
        fullInvent.add(new Sport("medium","ball machine",500,"football","new",15124,1));
        fullInvent.add(new Device("small","tablet",100,50,2,25612,1));
    }

    /**
     * Повертає список усього інвентарю в кімнатах.
     *
     * @return Список інвентарю.
     */
    public ArrayList<Inventory> getFullInvent() {
        return fullInvent;
    }
}