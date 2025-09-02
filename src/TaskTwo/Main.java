package TaskTwo;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Введите регистрационный номер банкомата: ");
        String regNumber = scanner.nextLine();
        System.out.print("Введите количество купюр по 20: ");
        int countOfTwenty = scanner.nextInt();
        System.out.print("Введите количество купюр по 50: ");
        int countOfFifty = scanner.nextInt();
        System.out.print("Введите количество купюр по 100: ");
        int countOfOneHundred = scanner.nextInt();
        System.out.println("Вы положили на счёт: " + (countOfTwenty * 20 + countOfFifty * 50 + countOfOneHundred * 100));

        CashDispenser dispenser = new CashDispenser(regNumber, countOfTwenty, countOfFifty, countOfOneHundred);

        menu(dispenser);
        scanner.close();
    }

    public static void menu(CashDispenser dispenser) {
        while (true) {
            System.out.println("\t\t__Банкомат__");
            System.out.println("\tРегистрационный номер: " + dispenser.getRegNumber());

            System.out.println("1. Посмотреть сумму в банке и количество купюр.");
            System.out.println("2. Положить деньги.");
            System.out.println("3. Снять деньги.");
            System.out.println("4. Выход.");

            switch (scanner.next()) {
                case "1" -> {
                    dispenser.checkMoney();
                    continue;
                }

                case "2" -> {

                    dispenser.addMoney();
                    continue;
                }

                case "3" -> {
                    dispenser.lostMoney();
                    continue;
                }

                case "4" -> {
                    System.out.println("До встречи!!!");
                    return;
                }

                default -> {
                    continue;
                }
            }
        }
    }

}
