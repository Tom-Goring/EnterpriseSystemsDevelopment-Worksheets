import org.apache.derby.shared.common.error.DerbySQLIntegrityConstraintViolationException;

import java.math.BigDecimal;
import java.sql.SQLException;

class InvalidWithdrawalAmount extends Exception {
    InvalidWithdrawalAmount(String s) {
        super(s);
    }
}

public class Customer {
    private final int id;
    private BigDecimal balance;

    public Customer(int id, String balance) {
        this.id = id;
        this.balance = new BigDecimal(balance);
    }

    public int getId() {
        return id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void deposit(BigDecimal amount) {
        balance = balance.add(amount);
        new Transaction(this, amount, TransactionType.Deposit).save();
        this.save();
    }

    public void withdraw(BigDecimal amount) throws InvalidWithdrawalAmount {
        if (balance.compareTo(amount) > 0) {
            balance = balance.subtract(amount);
            new Transaction(this, amount, TransactionType.Withdrawal).save();
            this.save();
        } else {
            throw new InvalidWithdrawalAmount("Withdrawal amount is too large.");
        }
    }

    public void transferTo(Customer target, BigDecimal amount) throws InvalidWithdrawalAmount {
        this.withdraw(amount);
        target.deposit(amount);
    }

    public void save() {
        try {
            BankDao.putCustomer(this);
        } catch (SQLException throwables) {
            if (throwables instanceof DerbySQLIntegrityConstraintViolationException) {
                this.update();
            }
            else {
                throwables.printStackTrace();
            }
        }
    }

    private void update() {
        try {
            BankDao.updateCustomer(this);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", balance=" + balance +
                '}';
    }
}