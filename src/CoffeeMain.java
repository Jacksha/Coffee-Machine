import java.util.Scanner;

public class CoffeeMain {
    static String initChoice = "";
    static String menu = "";
    static String choice = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creating "CoffeeMachine" object machine
        CoffeeMachine machine = new CoffeeMachine("coffee_machine_status.txt");
        machine.initStatus();

        // Creating "UserAdmin" object machine
        UserAdmin admin1 = new UserAdmin("coffee_machine_status.txt");
        admin1.initStatus();

        // Creating "Coffee" objects...
        Coffee espresso = new Coffee("Espresso", 250, 0, 16, 4);
        Coffee latte = new Coffee("Latte", 350, 75, 20, 7);
        Coffee cappuccino = new Coffee("Cappuccino", 200, 100, 12, 6);

        // Main menu loop -> "exit" for exit loop
        while (!initChoice.equals("exit")) {

            // buy, admin or exit
            System.out.println("Write action (buy, admin, exit): ");
            initChoice = scanner.next();
            switch (initChoice) {

                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:, back - to main menu:");
                    menu = scanner.next();
                    // buy menu
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

                case "admin":
                    System.out.println("Username: ");
                    String user = scanner.next();
                    System.out.println("Password: ");
                    String pass = scanner.next();
                    System.out.println("");
                    if (admin1.chckCred(user, pass)) {
                        System.out.println("Login successful!");
                        while (!choice.equals("exit")) {
                            System.out.println("Write action (fill, take, remaining, exit): ");
                            choice = scanner.next();
                            // Admin menu
                            switch (choice) {
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
                                    System.out.println("Loging out");
                                    break;
                                default:
                                    System.out.println("Unknown command");
                                    break;
                            }
                        }
                    } else {
                        System.out.println("Wrong Credentials!");
                    }
                    break;

                case "exit":
                    System.out.println("Exiting Coffee Machine...");
                    machine.saveStatus(admin1);
                    break;

                default:
                    System.out.println("Unknown command");
                    break;
            }
        }
    }
}