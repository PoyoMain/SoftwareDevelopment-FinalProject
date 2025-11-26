import java.util.List;

public class EmployeeRepository implements IEmployeeRepository 
{
    List<EmployeeNew> employees;

    @Override
    public List<EmployeeNew> getAllEmployees() {
        return employees;
    }

    @Override
    public EmployeeNew searchEmployee(String criteria) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchEmployee'");
    }

    @Override
    public void updateEmployee(EmployeeNew employee) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateEmployee'");
    }

    @Override
    public void addEmployee(EmployeeNew employee) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addEmployee'");
    }

    @Override
    public void deleteEmployee(int empID) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteEmployee'");
    }
}
