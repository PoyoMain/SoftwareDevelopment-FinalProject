import java.util.ArrayList;
import java.util.List;

public class UpdateService extends EmployeeService {
    public UpdateService(IEmployeeRepository employeeRepository) {
        super(employeeRepository);
    }
    public void updateEmployeeData(int empid, String newName, String newJobTitle, String newDivision) {
        Employee employee = employeeRepository.searchEmployee(String.valueOf(empid));
        if (employee != null) {
            if (newName != null && !newName.isEmpty()) {
                employee.setName(newName);
            }
            if (newJobTitle != null && !newJobTitle.isEmpty()) {
                employee.setJobTitle(newJobTitle);
            }
            if (newDivision != null && !newDivision.isEmpty()) {
                employee.setDivision(newDivision);
            }
            employeeRepository.updateEmployee(employee);
            System.out.println("Updated Employee ID: " + empid);
        } else {
            System.out.println("Employee with ID " + empid + " not found.");
        }
    }
}
