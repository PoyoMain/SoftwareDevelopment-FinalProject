public class MainMenuPrinter implements MenuPrinter {
    @Override
    public void printMenu() {
        System.out.println();
        System.out.println("====== Employee Management System Commands ======");
        System.out.println("1: Add Employee");
        System.out.println("2: Update Employee");
        System.out.println("3: Delete Employee");
        System.out.println("4: Search Employee");
        System.out.println("5: Exit");
        System.out.println("=================================================\n");
    }
}
