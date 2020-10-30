import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        try {
            ArrayList<Student> s = HistogramDao.getAllStudents();
            Histogram h = new Histogram(s);
            h.printHistogram();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<Student> readData() throws FileNotFoundException {
        ArrayList<Student> studentGrades = new ArrayList<>();

        Scanner scanner = new Scanner(new File("./src/main/resources/grades.txt"));

        while (scanner.hasNextLine()) {
            studentGrades.add(new Student(("Student_" + studentGrades.size() + 1), scanner.nextInt()));
            scanner.nextLine();
        }

        scanner.close();
        return studentGrades;
    }
}
