import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write how many ml of water the coffee machine has: ");
        int watter = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has: ");
        int milk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        int beans = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need: ");
        int cups = scanner.nextInt();

        int maxWatter = watter / 200;
        int maxMilk = milk / 50;
        int maxBeans = beans / 15;
        int maxCups = maxWatter < maxMilk ? (maxWatter < maxBeans ? maxWatter : maxBeans) : (maxMilk < maxBeans ? maxMilk : maxBeans);

        if (maxCups == cups) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (maxCups > cups) {
            System.out.println("Yes, I can make that amount of coffee (and even " + (maxCups - cups) + " more than that)");
        } else {
            System.out.println("No, I can make only " + maxCups + " cup(s) of coffee");
        }
    }
}