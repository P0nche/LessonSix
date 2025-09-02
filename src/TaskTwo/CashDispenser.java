package TaskTwo;

import static TaskTwo.Main.scanner;

public class CashDispenser {
    private final String regNumber;
    private int countOfTwenty;
    private int countOfFifty;
    private int countOfOneHundred;

    public CashDispenser(String regNumber) {
        this.regNumber = regNumber;
        countOfTwenty = 0;
        countOfFifty = 0;
        countOfOneHundred = 0;
    }

    public CashDispenser(String regNumber, int countOfTwenty, int countOfFifty, int countOfOneHundred) {
        this.regNumber = regNumber;
        this.countOfTwenty = countOfTwenty;
        this.countOfFifty = countOfFifty;
        this.countOfOneHundred = countOfOneHundred;
    }

    public void addMoney() {
        System.out.print("Введите количество купюр по 20: ");
        int amountOfTwenty = scanner.nextInt();
        System.out.print("Введите количество купюр по 50: ");
        int amountOfFifty = scanner.nextInt();
        System.out.print("Введите количество купюр по 100: ");
        int amountOfOneHundred = scanner.nextInt();
        System.out.println("Вы положили на счёт: " + (amountOfTwenty + amountOfFifty + amountOfOneHundred));

        countOfTwenty += amountOfTwenty;
        countOfFifty += amountOfFifty;
        countOfOneHundred += amountOfOneHundred;
    }

    public boolean lostMoney() {
        System.out.print("Введите сумму для снятия: ");
        int amount = scanner.nextInt();

        int sum = 20 * countOfTwenty + 50 * countOfFifty + 100 * countOfOneHundred;
        int difCountOfTwenty = 0;
        int difCountOfFifty = 0;
        int difCountOfOneHundred = 0;

        if(sum == 0) {
            System.out.println("Денег в банкомате нет(");
            return false;
        }

        if (amount <= sum && amount > 0) {
            int difference = sum - amount;

            if (difference == 10 || difference == 30) {
                System.out.println("Мы не можем выдать такую сумму.");
                return false;
            }

            while (difference > 0) {
                if (difference % 50 != 0 && difCountOfTwenty <= countOfTwenty) {
                    difference -= 20;
                    difCountOfTwenty++;
                } else if (difference % 100 != 0 && difCountOfFifty <= countOfFifty) {
                    difference -= 50;
                    difCountOfFifty++;
                } else {
                    difference -= 100;
                    difCountOfOneHundred++;
                }
            }

            int lostCountOfTwenty = countOfOneHundred - difCountOfOneHundred;
            int lostCountOfFifty = countOfFifty - difCountOfFifty;
            int lostCountOfOneHundred = countOfTwenty - difCountOfTwenty;

            System.out.println("100: " + lostCountOfTwenty);
            System.out.println("50: " + lostCountOfFifty);
            System.out.println("20: " + lostCountOfOneHundred);

            countOfOneHundred -= lostCountOfOneHundred;
            countOfFifty -= lostCountOfFifty;
            countOfTwenty -= lostCountOfTwenty;

            return true;

        }
        System.out.println("Операция не прошла!");
        return false;
    }

    public void checkMoney() {
        int sum = 20 * countOfTwenty + 50 * countOfFifty + 100 * countOfOneHundred;
        System.out.println("В банкомате: ");
        System.out.println("100: " + countOfOneHundred);
        System.out.println("50: " + countOfFifty);
        System.out.println("20: " + countOfTwenty);
        System.out.println("Итого: " + sum);
    }

    public String getRegNumber() {
        return regNumber;
    }
}
