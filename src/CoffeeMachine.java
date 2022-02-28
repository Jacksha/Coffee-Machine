import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int watter = 400;
        int milk = 540;
        int beans = 120;
        int cups = 9;
        int money = 550;
        int menu = 0;

        System.out.println("The coffee machine has:");
        System.out.println(watter + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(beans + " g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println("$" + money + " of money");

        System.out.println("Write action (buy, fill, take): ");
        String choice = scanner.next();

        switch (choice) {
            case "buy":
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
                menu = scanner.nextInt();
                switch (menu) {
                    case 1:
                        if (watter >= 250 && beans >= 16 && cups >= 1) {
                            watter -= 250;
                            beans -= 16;
                            cups--;
                            money += 4;
                        } else {
                            System.out.println("Not enough ingredients!");
                        }
                        break;
                    case 2:
                        if (watter >= 350 && milk >= 75 && beans >= 20 && cups >= 1) {
                            watter -= 350;
                            milk -= 75;
                            beans -= 20;
                            cups--;
                            money += 7;
                        } else {
                            System.out.println("Not enough ingredients!");
                        }
                        break;
                    case 3:
                        if (watter >= 200 && milk >= 100 && beans >= 12 && cups >= 1) {
                            watter -= 200;
                            milk -= 100;
                            beans -= 12;
                            cups--;
                            money += 6;
                        } else {
                            System.out.println("Not enough ingredients!");
                        }
                        break;
                    default:
                        System.out.println("Unknown command");
                        break;
                }
                break;

            case "fill":
                System.out.println("Write how many ml of water you want to add: ");
                watter += scanner.nextInt();
                System.out.println("Write how many ml of milk you want to add: ");
                milk += scanner.nextInt();
                System.out.println("Write how many grams of coffee beans you want to add:");
                beans += scanner.nextInt();
                System.out.println("Write how many disposable cups of coffee you want to add: ");
                cups += scanner.nextInt();
                break;

            case "take":
                System.out.println("I gave you $" +money);
                money -= money;
                break;
            default:
                System.out.println("Unknown command");
                break;
        }

        System.out.println("The coffee machine has:");
        System.out.println(watter + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(beans + " g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println("$" + money + " of money");
    }
}
