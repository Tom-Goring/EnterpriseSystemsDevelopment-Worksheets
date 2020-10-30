import java.math.BigDecimal;
import java.sql.SQLException;

public class Driver {
    public static void main(String[] args) {
        try {
            Customer a = BankDao.getCustomer(1);
            System.out.println(a);
            a.deposit(BigDecimal.valueOf(1));
            System.out.println(a);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
