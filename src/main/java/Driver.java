import java.sql.*;

public class Driver {
    public static void main(String[] args) {
        System.out.println(HistogramDao.getStudent("Student_1").getGrade());
    }
}
