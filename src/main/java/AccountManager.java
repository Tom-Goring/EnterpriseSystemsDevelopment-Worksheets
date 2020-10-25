import java.util.ArrayList;
import java.util.HashMap;

public class AccountManager {
    private HashMap<Integer, CustomerAccount> customerTable;

    public AccountManager(HashMap<Integer, CustomerAccount> customerTable) {
        this.customerTable = customerTable;
    }

    public void applyInterestToAll(String rate) {
        customerTable.forEach((key, value) -> value.applyInterest("0.03"));
    }

    public void addCustomer(CustomerAccount customer) {
        customerTable.put(customer.getAccountNumber(), customer);
    }

    public void removeCustomer(CustomerAccount customer) {
        customerTable.remove(customer.getAccountNumber());
    }

    public HashMap<Integer, CustomerAccount> getCustomerTable() {
        return customerTable;
    }
}
