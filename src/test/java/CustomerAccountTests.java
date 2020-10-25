import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerAccountTests {
    @Test
    void successfulWithdrawal() {
        CustomerAccount ca = new CustomerAccount(1, "100");
        try {
            ca.withdraw("10");
        } catch (InvalidWithdrawalException e) {
            fail();
        }
        assertEquals(ca.compareToBalance("90"), 0);
    }

    @Test
    void invalidWithdraw() {
        CustomerAccount ca = new CustomerAccount(1, "100");
        try {
            ca.withdraw("200");
            fail();
        } catch (InvalidWithdrawalException e) {
            assertTrue(true);
        }
    }

    @Test
    void deposit() {
        CustomerAccount ca = new CustomerAccount(1, "0");
        ca.deposit("100");
        assertEquals(ca.compareToBalance("100"), 0);
    }

    @Test
    void interest() {
        CustomerAccount ca = new CustomerAccount(1, "100");
        ca.applyInterest("0.03");
        assertEquals(ca.getBalance().compareTo(new BigDecimal(103)), 0);
    }
}
