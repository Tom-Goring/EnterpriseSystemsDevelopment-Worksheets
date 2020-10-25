import com.sun.javaws.WinBrowserSupport;
import com.sun.javaws.exceptions.InvalidArgumentException;

import java.math.BigDecimal;

class InvalidWithdrawalException extends Exception {
    InvalidWithdrawalException(String s) {
        super(s);
    }
}

public class CustomerAccount {
    private int accountNumber;
    private BigDecimal balance;

    public CustomerAccount(int accountNumber, String balance) {
        this.accountNumber = accountNumber;
        this.balance = new BigDecimal(balance);
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public int compareToBalance(String amountToCompare) {
        return balance.compareTo(new BigDecimal(amountToCompare));
    }

    public void deposit(String amountToDeposit) {
        balance = balance.add(new BigDecimal(amountToDeposit));
    }

    public void withdraw(String amountToWithdraw) throws InvalidWithdrawalException {
        BigDecimal newBalance = balance.subtract(new BigDecimal(amountToWithdraw));
        if (newBalance.compareTo(BigDecimal.ZERO) > 0) {
            this.balance = newBalance;
        } else {
            throw new InvalidWithdrawalException("Not enough money in account to complete withdrawal!");
        }
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void applyInterest(String interest_rate) {
        BigDecimal interest = balance.multiply(new BigDecimal(interest_rate));
        balance = balance.add(interest);
    }
}
