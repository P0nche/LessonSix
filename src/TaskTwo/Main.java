package TaskTwo;

public class Main {
    public static void main(String[] args) {
        CashDispenser dispenser = new CashDispenser("124", 5, 5, 5);
        dispenser.lostMoney(740);
        dispenser.checkMoney();
    }
}
