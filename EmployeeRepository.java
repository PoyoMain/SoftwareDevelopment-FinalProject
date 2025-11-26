public class EmployeeRepository implements IEmployeeRepository 
{
    List<Employee> employees;

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @Override
    public Employee searchEmployee(String criteria) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchEmployee'");
    }

    @Override
    public void updateEmployee(Employee employee) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateEmployee'");
    }

    @Override
    public void addEmployee(Employee employee) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addEmployee'");
    }

    @Override
    public void deleteEmployee(int empID) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteEmployee'");
    }
}
