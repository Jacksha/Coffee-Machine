import java.util.Scanner;

public class CoffeeMain {
    static String menu = "";
    static String choice = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creating "CoffeeMachine" object machine
        CoffeeMachine machine = new CoffeeMachine(400, 540, 120, 9, 550);

        // Creating "Coffee" objects...
        Coffee espresso = new Coffee("Espresso", 250, 0, 16, 1, 4);
        Coffee latte = new Coffee("Latte", 350, 75, 20, 1, 7);
        Coffee cappuccino = new Coffee("Cappuccino", 200, 100, 12, 1, 6);

        // Main menu loop -> "exit" for exit loop
        while (!choice.equals("exit")) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            choice = scanner.next();

            // Main menu
            switch (choice) {

                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:, back - to main menu:");
                    menu = scanner.next();
                    switch (menu) {
                        case "1":
                            machine.makeCoffee(espresso);
                            break;
                        case "2":
                            machine.makeCoffee(latte);
                            break;
                        case "3":
                            machine.makeCoffee(cappuccino);
                            break;
                        case "back":
                            break;
                        default:
                            System.out.println("Unknown command");
                            break;
                    }
                    break;

                case "fill":
                    machine.fillTheMachine();
                    break;

                case "take":
                    machine.takeMoney();
                    break;

                case "remaining":
                    machine.remaining();
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
}