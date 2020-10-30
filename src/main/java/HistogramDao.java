import java.sql.*;
import java.util.ArrayList;

public class HistogramDao {
    public static Student getStudent(String id) throws SQLException {
        Connection con = Database.getInstance().getConnection();

        PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM \"Grades\" WHERE ID = ?");
        preparedStatement.setString(1, id);

        ResultSet rs = preparedStatement.executeQuery();

        rs.next();

        Student s = new Student((String)rs.getObject(1), (int)rs.getObject(2));

        rs.close();

        return s;
    }

    public static ArrayList<Student> getAllStudents() throws SQLException {
        Connection con = Database.getInstance().getConnection();

        PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM \"Grades\"");

        ResultSet rs = preparedStatement.executeQuery();

        ArrayList<Student> sList = new ArrayList<>();

        while (rs.next()) {
            sList.add(new Student(rs.getString(1), rs.getInt(2)));
        }

        return sList;
    }

    public static void putStudent(String id, int grade) throws SQLException {
        Connection con = Database.getInstance().getConnection();

        PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO \"Grades\" VALUES (?, ?)");
        preparedStatement.setString(1, id);
        preparedStatement.setInt(2, grade);
        preparedStatement.execute();
    }
}
