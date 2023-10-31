package Rooms;

public class Accounting {
    private final int maxBudget;
    private final int maxNumberToys;
    private int curBudget;
    private int curNumberToys;

    public Accounting(){
        maxBudget = 60000;
        maxNumberToys = 60;
        curBudget = maxBudget;
        curNumberToys = 0;
    }

    public int getCurBudget() {
        return curBudget;
    }

    public int getCurNumberToys() {
        return curNumberToys;
    }

    public int getMaxNumberToys() {
        return maxNumberToys;
    }

    public void reduceBudget(int price){
        curBudget = curBudget - price;
    }

    public void addNewToy(){
        curNumberToys++;
    }

    @Override
    public String toString() {
        return "\n\tОБЛІК" +
                "\nМаксимальний бюджет = " + maxBudget +
                "\nМаксимальна кількість іграшок = " + maxNumberToys +
                "\nПоточний бюджет = " + curBudget +
                "\nПоточна кількість іграшок = " + curNumberToys;
    }

    public int getMaxBudget() {
        return maxBudget;
    }
}
