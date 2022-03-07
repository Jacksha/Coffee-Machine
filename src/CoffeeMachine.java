import java.util.Scanner;

public class CoffeeMachine {

    static int watter = 400;
    static int milk = 540;
    static int beans = 120;
    static int cups = 9;
    static int money = 550;
    static String menu = "";
    static String choice = "";
    Coffee coffee;

    //making Coffee instances
    Coffee espresso = new Coffee("Espresso", 250, 0, 16, 1, 4);
    Coffee latte = new Coffee("Latte", 350, 75, 20, 1, 7);
    Coffee cappuccino = new Coffee("Cappuccino", 200, 100, 12, 1, 6);

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
    public static void makeCoffee(Coffee coffee) {
        if (watter < coffee.watter) {
            System.out.println("Not enough watter to make " + coffee.coffeeName + " you need to fill up.");
        } else if (milk < coffee.milk) {
            System.out.println("Not enough milk to make " + coffee.coffeeName + " you need to fill up.");
        } else if (beans < coffee.beans) {
            System.out.println("Not enough coffee beans to make " + coffee.coffeeName + " you need to fill up.");
        } else if (cups < coffee.cups) {
            System.out.println("Not enough cups to make " + coffee.coffeeName + " you need to fill up.");
        } else {
            watter -= coffee.watter;
            milk -= coffee.milk;
            beans -= coffee.beans;
            cups -= coffee.cups;
            money += coffee.money;
            System.out.println(coffee.cups + " cup of " + coffee.coffeeName + " done! Have a nice day.");
        }
    }
}

class Coffee {
    String coffeeName;
    int watter;
    int milk;
    int beans;
    int cups;
    int money;

    Coffee(String coffeeName, int watter, int milk, int beans, int cups, int money) {
        this.coffeeName = coffeeName;
        this.watter = watter;
        this.milk = milk;
        this.beans = beans;
        this.cups = cups;
        this.money = money;
    }
}
