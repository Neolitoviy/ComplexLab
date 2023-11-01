package Rooms;

/**
 * Клас `Accounting` використовується для ведення обліку бюджету та кількості іграшок.
 * Він має максимальний бюджет та максимальну кількість іграшок, а також відслідковує поточний бюджет і кількість іграшок.
 */
public class Accounting {
    private final int maxBudget;       // Максимальний бюджет
    private final int maxNumberToys;   // Максимальна кількість іграшок
    private int curBudget;             // Поточний бюджет
    private int curNumberToys;         // Поточна кількість іграшок

    /**
     * Конструктор класу `Accounting` ініціалізує максимальний бюджет та максимальну кількість іграшок,
     * а також задає початкові значення для поточного бюджету і кількості іграшок.
     */
    public Accounting() {
        maxBudget = 60000;
        maxNumberToys = 60;
        curBudget = maxBudget;
        curNumberToys = 0;
    }

    /**
     * Метод, що повертає поточний бюджет.
     *
     * @return Поточний бюджет.
     */
    public int getCurBudget() {
        return curBudget;
    }

    /**
     * Метод, що повертає поточну кількість іграшок.
     *
     * @return Поточна кількість іграшок.
     */
    public int getCurNumberToys() {
        return curNumberToys;
    }

    /**
     * Метод, що повертає максимальну кількість іграшок.
     *
     * @return Максимальна кількість іграшок.
     */
    public int getMaxNumberToys() {
        return maxNumberToys;
    }

    /**
     * Метод для зменшення поточного бюджету на вказану суму (ціну іграшки).
     *
     * @param price Сума, на яку потрібно зменшити бюджет.
     */
    public void reduceBudget(int price) {
        curBudget = curBudget - price;
    }

    /**
     * Метод для додавання нової іграшки до обліку.
     */
    public void addNewToy() {
        curNumberToys++;
    }

    /**
     * Перевизначений метод `toString`, який надає рядкове представлення облікової інформації.
     *
     * @return Рядкове представлення обліку бюджету та кількості іграшок.
     */
    @Override
    public String toString() {
        return "\n\tОБЛІК" +
                "\nМаксимальний бюджет = " + maxBudget +
                "\nМаксимальна кількість іграшок = " + maxNumberToys +
                "\nПоточний бюджет = " + curBudget +
                "\nПоточна кількість іграшок = " + curNumberToys;
    }

    /**
     * Метод, що повертає максимальний бюджет.
     *
     * @return Максимальний бюджет.
     */
    public int getMaxBudget() {
        return maxBudget;
    }
}