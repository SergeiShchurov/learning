import java.util.Scanner;

public class CoffeeMachine {

    static final Scanner scanner = new Scanner(System.in);

    // initial for machine
    static int waterInMachine = 400;
    static int milkInMachine = 540;
    static int beansInMachine = 120;
    static int cashInMachine = 550;
    static int cupsInMachine = 9;
    
    // these are for one cup of coffee
    static int waterForCoffee;
    static int milkForCoffee;
    static int beansForCoffee;
    static int costForCoffee;

    // this is for while loop
    static boolean loop = true;

    public static void makeCoffee() {
        if (waterForCoffee <= waterInMachine && milkForCoffee <= milkInMachine && beansForCoffee <= beansInMachine) {
            System.out.println("I have enough resources, making you a coffee!");
            waterInMachine -= waterForCoffee;
            milkInMachine -= milkForCoffee;
            beansInMachine -= beansForCoffee;
            cashInMachine += costForCoffee;
            cupsInMachine -= 1;
        } else if (waterForCoffee > waterInMachine) {
            System.out.println("Sorry, not enough water!");
        } else if (milkForCoffee > milkInMachine) {
            System.out.println("Sorry, not enough milk!");
        } else if (beansForCoffee > beansInMachine) {
            System.out.println("Sorry, not enough coffee beans!");
        }
    }

    public static void fillMachine() {
        System.out.println("Write how many ml of water you want to add:");
        waterInMachine += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        milkInMachine += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        beansInMachine += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
        cupsInMachine += scanner.nextInt();
    }

    public static void takeMoney() {
        System.out.println("I gave you $" + cashInMachine);
        cashInMachine = 0;
    }

    public static void remainIngredients() {
        System.out.println("The coffee machine has:");
        System.out.println(waterInMachine + " ml of water");
        System.out.println(milkInMachine + " ml of milk");
        System.out.println(beansInMachine + " g of coffee beans");
        System.out.println(cupsInMachine + " disposable cups");
        System.out.println("$" + cashInMachine + " of money");        
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (loop) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.nextLine();
            switch(action) {
                case "buy":
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                String coffeeChose = scanner.nextLine();
                switch (coffeeChose) {
                    // espresso
                    case "1":
                        waterForCoffee = 250;
                        milkForCoffee = 0;
                        beansForCoffee = 16;
                        costForCoffee = 4;
                        makeCoffee();
                        break;
                    // latte
                    case "2":
                        waterForCoffee = 350;
                        milkForCoffee = 75;
                        beansForCoffee = 20;
                        costForCoffee = 7;                  
                        makeCoffee();
                        break;
                    // cappuccino
                    case "3":
                        waterForCoffee = 200;
                        milkForCoffee = 100;
                        beansForCoffee = 12;
                        costForCoffee = 6;                
                        makeCoffee();
                        break;
                    case "back":
                        break;
                    default:
                        System.out.println("Wrong chose");
                        break;
                }
                break;
                case "fill":
                fillMachine();
                break;
                case "take":
                takeMoney();
                break;
                case "remaining":
                remainIngredients();
                break;
                case "exit":
                    loop = false;
                break;
                default:
                System.out.println("Doesn't exists");
                break;
            }
        }
        scanner.close();
    }
}