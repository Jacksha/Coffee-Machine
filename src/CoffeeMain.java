import java.util.Scanner;

public class CoffeeMain {
    static String menu = "";
    static String choice = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CoffeeMachine machine = new CoffeeMachine();

        // "exit" for exit loop
        while (!choice.equals("exit")) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            choice = scanner.next();

            switch (choice) {

                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:, back - to main menu:");
                    menu = scanner.next();
                    switch (menu) {
                        case "1":
                            makeCoffee(espresso);
                            break;
                        case "2":
                            makeCoffee(latte);
                            break;
                        case "3":
                            makeCoffee(cappuccino);
                            break;
                        case "back":
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

                case "remaining":
                    remaining();
                    break;

                case "exit":
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Unknown command");
                    break;
            }
        }
    }

    // Function for status
    public static void remaining() {
        System.out.println("The coffee machine has:");
        System.out.println(watter + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(beans + " g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println("$" + money + " of money");
    }

    // method for making coffee
    public static void makeCoffee(Coffee oneCoffee) {
        if (watter < oneCoffee.watter) {
            System.out.println("Not enough watter to make " + oneCoffee.coffeeName + " you need to fill up.");
        } else if (milk < oneCoffee.milk) {
            System.out.println("Not enough milk to make " + oneCoffee.coffeeName + " you need to fill up.");
        } else if (beans < oneCoffee.beans) {
            System.out.println("Not enough coffee beans to make " + oneCoffee.coffeeName + " you need to fill up.");
        } else if (cups < oneCoffee.cups) {
            System.out.println("Not enough cups to make " + oneCoffee.coffeeName + " you need to fill up.");
        } else {
            watter -= oneCoffee.watter;
            milk -= oneCoffee.milk;
            beans -= oneCoffee.beans;
            cups -= oneCoffee.cups;
            money += oneCoffee.money;
            System.out.println(oneCoffee.cups + " cup of " + oneCoffee.coffeeName + " done! Have a nice day.");
        }
    }
}