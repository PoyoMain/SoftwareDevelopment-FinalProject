import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
    protected IEmployeeRepository employeeRepository;

    public EmployeeService(IEmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }

    public Employee searchEmployee(String criteria) {
        return employeeRepository.searchEmployee(criteria);
    }

    public void updateEmployee(Employee employee) {
        employeeRepository.updateEmployee(employee);
    }

    public void addEmployee(Employee employee) {
        employeeRepository.addEmployee(employee);
    }

    public void deleteEmployee(int id) {
        employeeRepository.deleteEmployee(id);
    }

    public void updateSalary(double percentage, double minSalary, double maxSalary) {
        List<Employee> employees = employeeRepository.getAllEmployees();
        for (Employee emp : employees) {
            if (emp.getSalary() >= minSalary && emp.getSalary() <= maxSalary) {
                double newSalary = emp.getSalary() + (emp.getSalary() * percentage / 100);
                emp.setSalary(newSalary);
                employeeRepository.updateEmployee(emp);
            }
        }
    }
}
