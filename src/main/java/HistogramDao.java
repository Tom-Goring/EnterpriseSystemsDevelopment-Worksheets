import java.sql.*;

public class HistogramDao {
    public static Student getStudent(String id) {
        Connection con = Database.getInstance().getConnection();

        try {
            PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM \"Grades\" WHERE ID = ?");
            preparedStatement.setString(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            rs.next();

            Student s = new Student((String)rs.getObject(1), (int)rs.getObject(2));

            rs.close();

            return s;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        // Pretty sure returning null is a bit heretical
        return null;
    }
}
