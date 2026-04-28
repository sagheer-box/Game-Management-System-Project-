import java.util.Scanner;

public class Launcher {
    private Scanner scanner;
    private Arsenal arsenal;
    private RequestLine requestQueue;

    public Launcher() {
        scanner = new Scanner(System.in);
        arsenal = new Arsenal();
        requestQueue = new RequestLine();
    }

    public static void main(String[] args) {
        Launcher app = new Launcher();
        app.mainMenu();
    }

    private void mainMenu() {
        boolean running = true;
        while (running) {
            System.out.println("\n========== MAIN MENU ==========");
            System.out.println("1. Arsenal Menu");
            System.out.println("2. Request Queue Menu");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");
            int choice = readInteger();
            switch (choice) {
                case 1:
                    arsenalMenu();
                    break;
                case 2:
                    queueMenu();
                    break;
                case 3:
                    running = false;
                    System.out.println("Exiting application...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }

    private void arsenalMenu() {
        boolean inArsenalMenu = true;
        while (inArsenalMenu) {
            System.out.println("\n========== ARSENAL MENU ==========");
            System.out.println("1. View Arsenal");
            System.out.println("2. Register Gear");
            System.out.println("3. Remove Gear");
            System.out.println("4. Modify Gear");
            System.out.println("5. Locate Gear");
            System.out.println("6. Back to Main Menu");
            System.out.print("Select an option: ");
            int choice = readInteger();
            switch (choice) {
                case 1:
                    arsenal.showArsenal();
                    break;
                case 2:
                    registerGearPrompt();
                    break;
                case 3:
                    removeGearPrompt();
                    break;
                case 4:
                    modifyGearPrompt();
                    break;
                case 5:
                    locateGearPrompt();
                    break;
                case 6:
                    inArsenalMenu = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void queueMenu() {
        boolean inQueueMenu = true;
        while (inQueueMenu) {
            System.out.println("\n========== REQUEST QUEUE MENU ==========");
            System.out.println("1. View Queue");
            System.out.println("2. Add Request");
            System.out.println("3. Fulfill Request");
            System.out.println("4. Peek Next");
            System.out.println("5. Back to Main Menu");
            System.out.print("Select an option: ");
            int choice = readInteger();
            switch (choice) {
                case 1:
                    requestQueue.showLine();
                    break;
                case 2:
                    addRequestPrompt();
                    break;
                case 3:
                    fulfillRequestPrompt();
                    break;
                case 4:
                    peekNextPrompt();
                    break;
                case 5:
                    inQueueMenu = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void registerGearPrompt() {
        scanner.nextLine();
        System.out.print("Enter gear title: ");
        String title = scanner.nextLine();
        System.out.print("Enter category: ");
        String category = scanner.nextLine();
        System.out.print("Enter stock quantity: ");
        int stock = readInteger();
        System.out.print("Enter strength value: ");
        int strength = readInteger();
        Gear newGear = new Gear(title, category, stock, strength);
        arsenal.registerGear(newGear);
    }

    private void removeGearPrompt() {
        scanner.nextLine();
        System.out.print("Enter gear title to remove: ");
        String title = scanner.nextLine();
        arsenal.removeGear(title);
    }

    private void modifyGearPrompt() {
        scanner.nextLine();
        System.out.print("Enter gear title to modify: ");
        String title = scanner.nextLine();
        System.out.print("Enter new stock quantity: ");
        int newStock = readInteger();
        System.out.print("Enter new strength value: ");
        int newStrength = readInteger();
        arsenal.modifyGear(title, newStock, newStrength);
    }

    private void locateGearPrompt() {
        scanner.nextLine();
        System.out.print("Enter gear title to locate: ");
        String title = scanner.nextLine();
        arsenal.locateGear(title);
    }

    private void addRequestPrompt() {
        scanner.nextLine();
        System.out.print("Enter gear title for request: ");
        String title = scanner.nextLine();
        System.out.print("Enter category: ");
        String category = scanner.nextLine();
        System.out.print("Enter stock quantity: ");
        int stock = readInteger();
        System.out.print("Enter strength value: ");
        int strength = readInteger();
        Gear requestGear = new Gear(title, category, stock, strength);
        requestQueue.addRequest(requestGear);
        System.out.println("Request added to queue.");
    }

    private void fulfillRequestPrompt() {
        if (requestQueue.queueEmpty()) {
            System.out.println("Queue is empty. No requests to fulfill.");
            return;
        }
        Gear fulfilledGear = requestQueue.fulfillRequest();
        arsenal.registerGear(fulfilledGear);
        System.out.println("Request fulfilled and gear registered to arsenal.");
    }

    private void peekNextPrompt() {
        if (requestQueue.queueEmpty()) {
            System.out.println("Queue is empty. No next request.");
            return;
        }
        Gear nextGear = requestQueue.nextUp();
        System.out.println("\n========== NEXT REQUEST ==========");
        System.out.println(String.format("| %-25s | %-20s | %-8s | %-10s |", "Gear Title", "Category", "Stock", "Strength"));
        System.out.println("===================================================================================================");
        System.out.println(nextGear.toString());
        System.out.println("===================================================================================================\n");
    }

    private int readInteger() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a valid integer: ");
            }
        }
    }
}
