package TaskOne;

public class Main {
    public static void main(String[] args) {
        CreditCard cardOne = new CreditCard("154238", 500);
        CreditCard cardTwo = new CreditCard("824829", 1000);
        CreditCard cardThree = new CreditCard("298489", 100);

        System.out.println(cardOne.toString());
        System.out.println(cardTwo.toString());
        System.out.println(cardThree.toString());

        cardOne.addMoney(500);
        cardTwo.addMoney(200);
        cardThree.lostMoney(50);

        System.out.println(cardOne.toString());
        System.out.println(cardTwo.toString());
        System.out.println(cardThree.toString());
    }
}
