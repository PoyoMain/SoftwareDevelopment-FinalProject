import java.util.Scanner;

public class InputService {

    private Scanner scanner;

    public InputService() {
        this.scanner = new Scanner(System.in);
    }

    public int getInt(String message) {
        while (true) {
            System.out.print(message);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }

    public double getDouble(String message) {
        while (true) {
            System.out.print(message);
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    public String getString(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    public String getOptionalString(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }
}