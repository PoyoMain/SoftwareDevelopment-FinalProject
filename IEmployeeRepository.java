import java.util.List;

public interface IEmployeeRepository 
{
    List<Employee> getAllEmployees();
    Employee searchEmployee(String criteria);
    void updateEmployee(Employee employee);
    void addEmployee(Employee employee);
    void deleteEmployee(int empID);
}
