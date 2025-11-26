import java.util.List;

public interface IEmployeeRepository 
{
    List<EmployeeNew> getAllEmployees();
    EmployeeNew searchEmployee(String criteria);
    void updateEmployee(EmployeeNew employee);
    void addEmployee(EmployeeNew employee);
    void deleteEmployee(int empID);
}
