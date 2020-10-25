import java.util.HashMap;
import java.util.Random;

public class Driver {
    public static void main(String[] args)  {
        AccountManager am = new AccountManager(new HashMap<>());

        Random rnd = new Random();

        for (int i = 0; i < 30; i++) {
            am.addCustomer(new CustomerAccount(i, String.valueOf(rnd.nextInt(1000))));
        }

        am.getCustomerTable().forEach((k, v) -> System.out.println(k + " " + v.getBalance()));

        am.applyInterestToAll("0.03");

        am.getCustomerTable().forEach((k, v) -> System.out.println(k + " " + v.getBalance()));
    }
}
