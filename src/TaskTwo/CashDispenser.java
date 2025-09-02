package TaskTwo;

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

    public void addMoney(int amountOfTwenty, int amountOfFifty, int amountOfOneHundred) {
        countOfTwenty += amountOfTwenty;
        countOfFifty += amountOfFifty;
        countOfOneHundred += amountOfOneHundred;
    }

    public boolean lostMoney(int amount) {
        int sum = 20 * countOfTwenty + 50 * countOfFifty + 100 * countOfOneHundred;
        int newCountOfTwenty = 0;
        int newCountOfFifty = 0;
        int newCountOfOneHundred = 0;

        if (amount <= sum && amount > 0) {
            int difference = sum - amount;

            if (difference == 10 || difference == 30) {
                System.out.println("Мы не можем выдать такую сумму.");
                return false;
            }

            while (difference > 0) {
                if (difference % 50 != 0 && newCountOfTwenty <= countOfTwenty) {
                    difference -= 20;
                    newCountOfTwenty++;
                } else if (difference % 100 != 0 && newCountOfFifty <= countOfFifty) {
                    difference -= 50;
                    newCountOfFifty++;
                } else {
                    difference -= 100;
                    newCountOfOneHundred++;
                }


                System.out.println("100: " + (countOfOneHundred - newCountOfOneHundred));
                System.out.println("50: " + (countOfFifty - newCountOfFifty));
                System.out.println("20: " + (countOfTwenty - newCountOfTwenty));

                countOfOneHundred -= (countOfOneHundred - newCountOfOneHundred);
                countOfFifty -= (countOfFifty - newCountOfFifty);
                countOfTwenty -= (countOfTwenty - newCountOfTwenty);

                return true;
            }

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
}
