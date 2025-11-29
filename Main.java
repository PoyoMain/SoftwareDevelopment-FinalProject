import java.util.Scanner;

public class Main {

    // Scanner shared by all menu operations
    private static final Scanner scanner = new Scanner(System.in);
    private static final EmployeeRepository repository = new EmployeeRepository();

    // Menu printer
    private static final MenuPrinter menuPrinter = new MainMenuPrinter();

    public static void main(String[] args) {
        boolean running = true;

        menuPrinter.printMenu();

        while (running) {
            System.out.print("Enter command number (1-5): ");
            int choice = getChoice();

            switch (choice) {
                case 1:
                    addEmployee();
                    break;

                case 2:
                    updateEmployee();
                    break;

                case 3:
                    deleteEmployee();
                    break;

                case 4:
                    searchEmployee();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    running = false;
                    break;
            
                default:
                    System.out.println("Invalid choice. Please try again.\n");
            }
        }

        scanner.close();
    }


    private static int getChoice() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input! Please enter a number.");
            scanner.next(); // Clear invalid input
            System.out.print("Enter command number: ");
        }
        return scanner.nextInt();
    }

    // ---------------------------
    // Placeholder methods: to be REPLACED with real classses later.
    // ---------------------------

    private static void addEmployee() {
        System.out.println("[Adding Employee...]");
        // FUTURE: incorporate class/interfaces
    }

    private static void updateEmployee() {
        System.out.println("[Updating Employee...]");
        // FUTURE: incorporate class/interfaces
    }

    private static void deleteEmployee() {
        System.out.println("[Deleting Employee...]");
        // FUTURE: incorporate class/interfaces
    }

    private static void searchEmployee() {
        System.out.println("[Searching Employee...]");
        // FUTURE: incorporate class/interfaces
    }
}