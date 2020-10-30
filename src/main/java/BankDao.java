import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class BankDao {
    public static Customer getCustomer(int id) throws SQLException {
        Connection con = Database.getInstance().getConnection();

        PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM \"Customers\" WHERE ID = ?");
        preparedStatement.setInt(1, id);

        ResultSet rs = preparedStatement.executeQuery();

        rs.next();

        Customer c = new Customer(rs.getInt(1), rs.getString(2));

        rs.close();

        return c;
    }

    public static void putCustomer(Customer c) throws SQLException {
        Connection con = Database.getInstance().getConnection();

        PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO \"Customers\" VALUES (?, ?)");
        preparedStatement.setInt(1, c.getId());
        preparedStatement.setString(2, c.getBalance().toString());
        preparedStatement.execute();
    }

    public static void updateCustomer(Customer c) throws SQLException {
        Connection con = Database.getInstance().getConnection();

        PreparedStatement preparedStatement = con.prepareStatement("UPDATE \"Customers\" SET BALANCE = ? WHERE ID = ?");
        preparedStatement.setString(1, c.getBalance().toString());
        preparedStatement.setInt(2, c.getId());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public static void putTransaction(Transaction t) throws SQLException {
        Connection con = Database.getInstance().getConnection();

        PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO \"Transactions\" ( \"CustomerID\", \"Amount\", \"Date\", \"Type\") VALUES (?, ?, ?, ?)");
        preparedStatement.setInt(1, t.customer.getId());
        preparedStatement.setString(2, t.amount.toString());
        preparedStatement.setString(3, t.date);
        preparedStatement.setString(4, t.type.toString());
        preparedStatement.execute();
    }

    public static HashMap<Integer, Customer> getAllCustomers() throws SQLException {
        Connection con = Database.getInstance().getConnection();

        PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM \"Customers\"");
        ResultSet rs = preparedStatement.executeQuery();

        HashMap<Integer, Customer> customers = new HashMap<>();

        while (rs.next()) {
            customers.put(rs.getInt(1), new Customer(rs.getInt(1), rs.getString(2)));
        }

        rs.close();

        return customers;
    }
}
