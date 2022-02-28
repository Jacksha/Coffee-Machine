import java.util.Scanner;

public class CoffeeMachine {

    static int watter = 400;
    static int milk = 540;
    static int beans = 120;
    static int cups = 9;
    static int money = 550;
    static String menu = "";
    static String choice = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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
                            makeCoffee("Espresso", 250, 0, 16, 1, 4);
                            break;
                        case "2":
                            makeCoffee("Latte", 350, 75, 20, 1, 7);
                            break;
                        case "3":
                            makeCoffee("Cappuccino", 200, 100, 12, 1, 6);
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

    // Function for making coffee
    public static void makeCoffee(String coffeeName, int watterDose, int milkDose, int beansDose, int cupsDose, int price) {
        if (watter < watterDose) {
            System.out.println("Not enough watter to make " + coffeeName + " you need to fill up.");
        } else if (milk < milkDose) {
            System.out.println("Not enough milk to make " + coffeeName + " you need to fill up.");
        } else if (beans < beansDose) {
            System.out.println("Not enough coffee beans to make " + coffeeName + " you need to fill up.");
        } else if (cups < cupsDose) {
            System.out.println("Not enough cups to make " + coffeeName + " you need to fill up.");
        } else {
            watter -= watterDose;
            milk -= milkDose;
            beans -= beansDose;
            cups -= cupsDose;
            money += price;
            System.out.println(cupsDose + " cup of " + coffeeName + " done! Have a nice day.");
        }
    }
}
