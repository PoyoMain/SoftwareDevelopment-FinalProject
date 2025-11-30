import java.util.*;

public class Main {

    public static void main(String[] args) {

        IEmployeeRepository repo = new EmployeeRepository();
        EmployeeService service = new EmployeeService(repo);
        UpdateService updateService = new UpdateService(repo);
        InputService input = new InputService();

        while (true) {

            System.out.println("\n================ EMPLOYEE MANAGEMENT MENU ================");
            System.out.println("1. Add Employee");
            System.out.println("2. Delete Employee");
            System.out.println("3. Display All Employees");
            System.out.println("4. Increase Salaries Within Range");
            System.out.println("5. Search Employee (Name / ID / SSN)");
            System.out.println("6. Update Employee Data (Name, Job, Division)");
            System.out.println("7. Exit");

            int choice = input.getInt("Choose an option: ");

            switch (choice) {

                //First case that adds the employee
                case 1: {
                    int id = input.getInt("Enter Employee ID: ");
                    String name = input.getString("Enter Name: ");
                    String ssn = input.getString("Enter SSN: ");
                    double salary = input.getDouble("Enter Salary: ");
                    String job = input.getString("Enter Job Title: ");
                    String division = input.getString("Enter Division: ");

                    List<PayStatement> payHistory = new ArrayList<>();
                    Employee emp = new Employee(id, name, ssn, salary, job, division, payHistory);

                    service.addEmployee(emp);
                    break;
                }

                //Second case that deletes employee
                case 2: {
                    Employee found = null;
                    while (found == null) {
                        String criteria = input.getString("Enter Employee ID, Name, or SSN to delete: ").trim();
                        
                        if (criteria.isEmpty()) {
                            System.out.println("Input cannot be blank.");
                            continue;
                        }

                        found = service.searchEmployee(criteria);
                        
                        if (found == null) {
                            System.out.println("No employee matches that criteria. Try again.");
                        }
                    }

                    service.deleteEmployee(found.getEmpid());
                    break;
                }
                        
                //Third case that displays all the employees with their info to the user
                case 3: {
                    List<Employee> all = service.getAllEmployees();

                    if (all.isEmpty()) {
                        System.out.println("No employees found.");
                    } else {
                        System.out.println("\n---------- EMPLOYEE LIST ----------");
                        for (Employee e : all) {
                            printEmployee(e);
                        }    
                    }
                    break;
                }

                //Increases the salaries of all the employees within a range by a percentage
                case 4: {
                    double min = input.getDouble("Enter minimum salary: ");
                    double max = input.getDouble("Enter maximum salary: ");
                    double pct = input.getDouble("Enter percentage increase: ");

                    service.updateSalary(pct, min, max);
                    break;
                }

                //Searches for an employee
                case 5: {
                    int opt = -1;
                    boolean valid = false;

                    while (!valid) {
                        String inputStr = input.getString("Search by: 1=Name    2=ID    3=SSN\nYour choice: ");
                        try {
                            opt = Integer.parseInt(inputStr);
                            if (opt >= 1 && opt <= 3) {
                                valid = true;
                            } else {
                                System.out.println("Please enter 1, 2, or 3.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Please enter a numeric option (1, 2, or 3).");
                        }
                    }

                    String criteria = "";
                    if (opt == 1) criteria = input.getString("Enter Name: ");
                    else if (opt == 2) criteria = input.getString("Enter ID: ");
                    else if (opt == 3) criteria = input.getString("Enter SSN: ");

                    service.searchEmployee(criteria);
                    break;
                }

                //Updates employee data (Name, jobtitle, and/or division)
                case 6: {
                    int method = -1;
                    boolean valid = false;

                    while (!valid) {
                        String inputStr = input.getString("Update using: 1=Name    2=ID    3=SSN\nYour choice: ");
                        try {
                            method = Integer.parseInt(inputStr);
                            if (method >= 1 && method <= 3) {
                                valid = true;
                            } else {
                                System.out.println("Please enter 1, 2, or 3.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Please enter a numeric option (1, 2, or 3).");
                        }
                    }

                    String criteria = "";
                    if (method == 1) criteria = input.getString("Enter Name: ");
                    else if (method == 2) criteria = input.getString("Enter ID: ");
                    else if (method == 3) criteria = input.getString("Enter SSN: ");

                    Employee target = service.searchEmployee(criteria);
                    if (target == null) {
                        System.out.println("Employee not found.");
                        break;
                    }

                    String newName = input.getOptionalString("Enter NEW Name (leave blank to keep): ");
                    String newJob = input.getOptionalString("Enter NEW Job Title (leave blank to keep): ");
                    String newDivision = input.getOptionalString("Enter NEW Division (leave blank to keep): ");

                    updateService.updateEmployeeData(
                        target.getEmpid(),
                        newName,
                        newJob,
                        newDivision
                    );
                    break;
                }

                //Exits out of the program
                case 7:
                    System.out.println("Goodbye!");
                    return;

                // =========================================================
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    //Method that displays all of the employee information
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


