import java.util.ArrayList;
import java.util.List;


public class EmployeeRepository implements IEmployeeRepository {
    private List<Employee> employees;

    public EmployeeRepository() {
        this.employees = new ArrayList<>();
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @Override
    public Employee searchEmployee(String criteria) {
        Integer idCriteria = null;

        //Attempts to parse the criteria as an ID
        try {
            idCriteria = Integer.parseInt(criteria);
        } catch (NumberFormatException e) {
            //Catches the parse if it isn't a number, skips the ID matching if that is the case
        }

        for (Employee emp : employees) {

            //Matches by employee name
            if (emp.getName().equalsIgnoreCase(criteria)) {
                System.out.println("Found Employee by Name: " + emp.getName());
                emp.printEmployeeDetails();
                return emp;
            }

            //Matches by employee ID
            if (idCriteria != null && emp.getEmpid() == idCriteria) {
                System.out.println("Found Employee by ID: " + emp.getEmpid());
                emp.printEmployeeDetails();
                return emp;
            }

            //Matches by employee SSN
            if (emp.getSSN().equals(criteria)) {
                System.out.println("Found Employee by SSN: " + emp.getSSN());
                emp.printEmployeeDetails();
                return emp;
            }
        }

        System.out.println("Employee with criteria \"" + criteria + "\" not found.");
        return null;
    }



    @Override
    public void updateEmployee(Employee employee) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getEmpid() == employee.getEmpid()) {
                employees.set(i, employee);
                System.out.println("Updated Employee ID: " + employee.getEmpid());
                return;
            }
        }
        System.out.println("Employee with ID " + employee.getEmpid() + " not found.");
        return;
    }

    @Override
    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("Added Employee ID: " + employee.getEmpid());
    }

    @Override
    public void deleteEmployee(int id) {
        boolean removed = employees.removeIf(emp -> emp.getEmpid() == id);
        if (removed) {
            System.out.println("Deleted Employee ID: " + id);
        } else {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

}
