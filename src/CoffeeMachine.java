import javax.imageio.IIOException;
import java.io.*;
import java.util.Scanner;
import java.io.FileWriter;

public class CoffeeMachine {

    static int watter;
    static int milk;
    static int beans;
    static int cups;
    static int money;
    static String fileName;
    Coffee coffee;

    Scanner scanner = new Scanner(System.in);
    Scanner statusScan;

    // Constructor
    public CoffeeMachine(String fileName) {
        this.fileName = fileName;
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


    // Initialize the status for this machine
    void initStatus() {
        try {
            statusScan = new Scanner(new FileReader("./doc/" + fileName));
            statusScan.nextLine();
            statusScan.useDelimiter("; |\n");
            String strNum = statusScan.next();
            this.watter = Integer.parseInt(strNum);
            strNum = statusScan.next();
            this.milk = Integer.parseInt(strNum);
            strNum = statusScan.next();
            this.beans = Integer.parseInt(strNum);
            strNum = statusScan.next();
            this.cups = Integer.parseInt(strNum);
            strNum = statusScan.next();
            this.money = Integer.parseInt(strNum);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    // save status
    void saveStatus(UserAdmin user) {
        try {
            FileWriter writeStatus = new FileWriter("./doc/" + fileName);
            writeStatus.write("watter; milk; beans; cups; money \n");
            writeStatus.write(this.watter + "; ");
            writeStatus.write(this.milk + "; ");
            writeStatus.write(this.beans + "; ");
            writeStatus.write(this.cups + "; ");
            writeStatus.write(this.money + "\n");
            writeStatus.write(user.getUsername() + "; ");
            writeStatus.write(user.getPassword() + "");
            writeStatus.close();

        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
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
        if (this.watter < oneCoffee.recWatter) {
            System.out.println("Not enough watter to make " + oneCoffee.coffeeName + " you need to fill up.\n");
        } else if (this.milk < oneCoffee.recMilk) {
            System.out.println("Not enough milk to make " + oneCoffee.coffeeName + " you need to fill up.\n");
        } else if (this.beans < oneCoffee.recBeans) {
            System.out.println("Not enough coffee beans to make " + oneCoffee.coffeeName + " you need to fill up.\n");
        } else if (this.cups < 1) {
            System.out.println("Not enough cups to make " + oneCoffee.coffeeName + " you need to fill up.\n");
        } else {
            this.watter -= oneCoffee.recWatter;
            this.milk -= oneCoffee.recMilk;
            this.beans -= oneCoffee.recBeans;
            this.cups -= 1;
            this.money += oneCoffee.recMoney;
            System.out.println("\nOne cup of " + oneCoffee.coffeeName + " done! Have a nice day.\n");
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
        System.out.println("\nI gave you $" +this.money + "\n");
        this.money -= this.money;
    }

}