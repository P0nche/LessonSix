package TaskOne;

public class CreditCard {
    private final String accountNumber;
    private double money;

    public CreditCard(String accountNumber) {
        this.accountNumber = accountNumber;
        money = 0;
    }

    public CreditCard(String accountNumber, double money) {
        this.accountNumber = accountNumber;
        this.money = money;
    }

    public void addMoney(double amount) {
        money += amount;
    }

    public void lostMoney(double amount) {
        if (amount < money && amount > 0) {
            money -= amount;
        }
    }

    @Override
    public String toString() {
        return "Номер счета: " + accountNumber + "\nБаланс: " + money + '\n';
    }
}
