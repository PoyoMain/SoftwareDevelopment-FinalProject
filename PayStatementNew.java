import java.util.ArrayList;
import java.util.List;

public class PayStatementNew {
    private String month;
    private double amount;

    public PayStatementNew(String month, double amount) {
        this.month = month;
        this.amount = amount;
    }

    public String getMonth() {
        return month;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}