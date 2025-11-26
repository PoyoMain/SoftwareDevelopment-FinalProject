import java.util.ArrayList;
import java.util.List;

public class EmployeeNew {
    private int empid;
    private String name;
    private String SSN;
    private double salary;
    private String jobTitle;
    private String division;
    private List<PayStatement> payHistory;


    public EmployeeNew(int empid, String name, String SSN, double salary, String jobTitle, String division, List<PayStatement> payHistory){
        this.empid = empid;
        this.name = name;
        this.SSN = SSN;
        this.salary = salary;
        this.jobTitle = jobTitle;
        this.division = division;
        this.payHistory = payHistory;
    }

    public int getEmpid() {
        return empid;
    }

    public String getName() {
        return name;
    }

    public String getSSN() {
        return SSN;
    }

    public double getSalary() {
        return salary;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getDivision() {
        return division;
    }

    public List<PayStatement> getPayHistory() {
        return payHistory;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public void addPayStatement(PayStatement payStatement) {
        this.payHistory.add(payStatement);
    }

}

