import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

enum TransactionType {
    Withdrawal,
    Deposit
}

public class Transaction {
    int id;
    Customer customer;
    BigDecimal amount;
    String date;
    TransactionType type;

    public Transaction(Customer customer, BigDecimal amount, TransactionType type) {
        id = (int) (Math.random() * Integer.MAX_VALUE + 0);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();

        this.customer = customer;
        this.amount = amount;
        this.date = dtf.format(now);
        this.type = type;
    }

    public void save() {
        try {
            BankDao.putTransaction(this);
            System.out.println("Saving transaction " + id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", customer=" + customer.getId() +
                ", amount=" + amount +
                ", date='" + date + '\'' +
                ", type=" + type +
                '}';
    }
}
