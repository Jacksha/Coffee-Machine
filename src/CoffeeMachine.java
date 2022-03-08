import java.util.Scanner;

public class CoffeeMachine {

    static int watter;
    static int milk;
    static int beans;
    static int cups;
    static int money;
    Coffee coffee;

    Scanner scanner = new Scanner(System.in);

    // Constructor
    public CoffeeMachine(int watter, int milk, int beans, int cups, int money) {
        this.watter = watter;
        this.milk = milk;
        this.beans = beans;
        this.cups = cups;
        this.money = money;
    }


    // Getters - Setters
    public static int getWatter() {
        return watter;
    }

    public static void setWatter(int watter) {
        CoffeeMachine.watter = watter;
    }

    public static int getMilk() {
        return milk;
    }

    public static void setMilk(int milk) {
        CoffeeMachine.milk = milk;
    }

    public static int getBeans() {
        return beans;
    }

    public static void setBeans(int beans) {
        CoffeeMachine.beans = beans;
    }

    public static int getCups() {
        return cups;
    }

    public static void setCups(int cups) {
        CoffeeMachine.cups = cups;
    }

    public static int getMoney() {
        return money;
    }

    public static void setMoney(int money) {
        CoffeeMachine.money = money;
    }

    public Coffee getCoffee() {
        return coffee;
    }

    public void setCoffee(Coffee coffee) {
        this.coffee = coffee;
    }



    // Method for status
    public void remaining() {
        System.out.println("The coffee machine has:");
        System.out.println(watter + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(beans + " g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println("$" + money + " of money");
        System.out.println("");
    }

    // method for making coffee
    public void makeCoffee(Coffee oneCoffee) {
        if (this.watter < oneCoffee.watter) {
            System.out.println("Not enough watter to make " + oneCoffee.coffeeName + " you need to fill up.\n");
        } else if (this.milk < oneCoffee.milk) {
            System.out.println("Not enough milk to make " + oneCoffee.coffeeName + " you need to fill up.\n");
        } else if (this.beans < oneCoffee.beans) {
            System.out.println("Not enough coffee beans to make " + oneCoffee.coffeeName + " you need to fill up.\n");
        } else if (this.cups < oneCoffee.cups) {
            System.out.println("Not enough cups to make " + oneCoffee.coffeeName + " you need to fill up.\n");
        } else {
            this.watter -= oneCoffee.watter;
            this.milk -= oneCoffee.milk;
            this.beans -= oneCoffee.beans;
            this.cups -= oneCoffee.cups;
            this.money += oneCoffee.money;
            System.out.println(oneCoffee.cups + " cup of " + oneCoffee.coffeeName + " done! Have a nice day.\n");
        }
    }

    // fill the machine
    public void fillTheMachine() {
        System.out.println("Write how many ml of water you want to add: ");
        this.watter += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        this.milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        this.beans += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add: ");
        this.cups += scanner.nextInt();
        System.out.println("");
    }

    // take money!
    public void takeMoney() {
        System.out.println("I gave you $" +this.money);
        this.money -= this.money;
    }
}