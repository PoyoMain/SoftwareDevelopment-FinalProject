import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        IEmployeeRepository repo = new EmployeeRepository();
        EmployeeService service = new EmployeeService(repo);
        UpdateService updateService = new UpdateService(repo);

        while (true) {

            System.out.println("\n================ EMPLOYEE MANAGEMENT MENU ================");
            System.out.println("1. Add Employee");
            System.out.println("2. Delete Employee");
            System.out.println("3. Display All Employees");
            System.out.println("4. Increase Salaries Within Range");
            System.out.println("5. Search Employee (Name / ID / SSN)");
            System.out.println("6. Update Employee Data (Name, Job, Division)");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input. Try again.");
                continue;
            }

            switch (choice) {

                // =========================================================
                // 1) ADD EMPLOYEE
                // =========================================================
                case 1:
                    boolean validID = false;
                    boolean validSalary = false;
                    int id = 0;
                    double salary = 0.0;
                    do {
                        System.out.print("Enter Employee ID: ");
                        try {
                        id = Integer.parseInt(scanner.nextLine());
                        validID = true;
                        } catch (Exception e) {
                            System.out.println("Please enter a valid integer.");
                        }
                    } while (validID == false);

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter SSN: ");
                    String ssn = scanner.nextLine();
                    
                    do {
                        System.out.print("Enter Salary: ");
                        try {
                            salary = Double.parseDouble(scanner.nextLine());
                            validSalary = true;
                        } catch (Exception e) {
                            System.out.println("Please enter a valid number.");
                        }
                    } while (validSalary == false);

                    System.out.print("Enter Job Title: ");
                    String job = scanner.nextLine();

                    System.out.print("Enter Division: ");
                    String division = scanner.nextLine();

                    List<PayStatement> payHistory = new ArrayList<>();
                    Employee emp = new Employee(id, name, ssn, salary, job, division, payHistory);

                    service.addEmployee(emp);
                    break;

                // =========================================================
                // 2) DELETE EMPLOYEE
                // =========================================================
                case 2: {
                    Employee found = null;

                    // Loop until a valid employee is found
                    do {
                        System.out.print("Enter Employee ID, Name, or SSN to delete: ");
                        String criteria = scanner.nextLine();

                        if (criteria.isBlank()) {
                            System.out.println("Input cannot be blank.");
                            continue;
                        }

                        found = service.searchEmployee(criteria);

                        if (found == null) {
                            System.out.println("No employee matches that criteria. Try again.");
                        }

                    } while (found == null);

                    // Delete the employee using their ID
                    service.deleteEmployee(found.getEmpid());

                    break;
                }





                // =========================================================
                // 3) DISPLAY ALL EMPLOYEES
                // =========================================================
                case 3:
                    List<Employee> all = service.getAllEmployees();

                    if (all.isEmpty()) {
                        System.out.println("No employees found.");
                        break;
                    }

                    System.out.println("\n---------- EMPLOYEE LIST ----------");
                    for (Employee e : all) {
                        printEmployee(e);
                    }
                    break;

                // =========================================================
                // 4) INCREASE SALARY BY RANGE
                // =========================================================
                case 4:
                   double min = 0, max = 0, pct = 0;
                   boolean valid = false;

                   // MIN salary
                   do {
                       System.out.print("Enter minimum salary: ");
                       String input = scanner.nextLine();

                       try {
                           min = Double.parseDouble(input);
                           valid = true;
                       } catch (NumberFormatException e) {
                           System.out.println("Please enter a valid number for minimum salary.");
                       }
                   } while (!valid);

                   valid = false;

                   // MAX salary
                   do {
                       System.out.print("Enter maximum salary: ");
                       String input = scanner.nextLine();

                       try {
                           max = Double.parseDouble(input);
                           valid = true;
                       } catch (NumberFormatException e) {
                           System.out.println("Please enter a valid number for maximum salary.");
                       }
                   } while (!valid);

                   valid = false;

                   // Percentage
                   do {
                       System.out.print("Enter percentage increase: ");
                       String input = scanner.nextLine();

                       try {
                           pct = Double.parseDouble(input);
                           valid = true;
                       } catch (NumberFormatException e) {
                           System.out.println("Please enter a valid percentage.");
                       }
                   } while (!valid);

                   // Now call service
                   service.updateSalary(pct, min, max);
                   break;


                // =========================================================
                // 5) SEARCH EMPLOYEE
                // =========================================================
                case 5:
                    int opt = -1;
                    valid = false;

                    do {
                        System.out.print("Search by: 1=Name  2=ID  3=SSN\nYour choice: ");
                        String input = scanner.nextLine();

                        try {
                            opt = Integer.parseInt(input);

                            if (opt >= 1 && opt <= 3) {
                                valid = true;
                            } else {
                                System.out.println("Please enter 1, 2, or 3.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Please enter a numeric option (1, 2, or 3).");
                        }

                    } while (!valid);


                    if (opt == 1) {
                        System.out.print("Enter name: ");
                        service.searchEmployee(scanner.nextLine());

                    } else if (opt == 2) {
                        System.out.print("Enter ID: ");
                        service.searchEmployee(scanner.nextLine());

                    } else if (opt == 3) {
                        System.out.print("Enter SSN: ");
                        service.searchEmployee(scanner.nextLine());
                    }
                    break;


                // =========================================================
                // 6) UPDATE EMPLOYEE DATA (name + job + division)
                // =========================================================
                case 6:
                    System.out.println("Update using: 1=Name  2=ID  3=SSN");

                    int method = -1;
                    valid = false;

                    do {
                        System.out.print("Your choice: ");
                        String input = scanner.nextLine();

                        try {
                            method = Integer.parseInt(input);
                            if (method < 1 || method > 3) {
                                System.out.println("Please choose 1, 2, or 3.");
                            } else {
                                valid = true;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Enter a numeric choice.");
                        }

                    } while (!valid);

                    String criteria = "";

                    // Ask user for matching input depending on search method
                    if (method == 1) {
                        System.out.print("Enter Name: ");
                        criteria = scanner.nextLine();

                    } else if (method == 2) {
                        System.out.print("Enter ID: ");
                        criteria = scanner.nextLine();

                    } else if (method == 3) {
                        System.out.print("Enter SSN: ");
                        criteria = scanner.nextLine();
                    }

                    // 💡 Only ONE search method is used here!
                    Employee target = service.searchEmployee(criteria);

                    if (target == null) {
                        System.out.println("Employee not found.");
                        break;
                    }

                    // Optional updates
                    System.out.print("Enter NEW Name (leave blank to keep): ");
                    String newName = scanner.nextLine();

                    System.out.print("Enter NEW Job Title (leave blank to keep): ");
                    String newJob = scanner.nextLine();

                    System.out.print("Enter NEW Division (leave blank to keep): ");
                    String newDivision = scanner.nextLine();

                    updateService.updateEmployeeData(
                        target.getEmpid(),
                        newName,
                        newJob,
                        newDivision
                    );
                    break;


                // =========================================================
                // 7) EXIT
                // =========================================================
                case 7:
                    System.out.println("Goodbye!");
                    return;

                // =========================================================
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    // =========================================================
    // Helper Method to Print Employee Info
    // =========================================================
    private static void printEmployee(Employee e) {
    System.out.println(
        "ID: " + e.getEmpid() +
        ", Name: " + e.getName() +
        ", SSN: " + e.getSSN() +
        ", Salary: $" + e.getSalary() +
        ", Job Title: " + e.getJobTitle() +
        ", Division: " + e.getDivision()
    );
    }

}
