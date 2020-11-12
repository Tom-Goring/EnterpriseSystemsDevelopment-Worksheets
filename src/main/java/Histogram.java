import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Histogram {
    ArrayList<Student> students;
    HashMap<Integer, Integer> gradeFrequency;

    public Histogram(ArrayList<Student> students) {
        this.students = students;
        this.gradeFrequency = new HashMap<>();

        for (Student s : this.students) {
            Integer quotient = s.getGrade() / 10;
            Integer j = gradeFrequency.getOrDefault(quotient, 0);
            this.gradeFrequency.put(quotient, j + 1);
        }
    }

    public String printHistogram() {
        String output = "";
        for (int i = 1; i < 100; i += 10) {
            int quotient = i / 10;
            int freq = this.gradeFrequency.getOrDefault(quotient, 0);
            char[] chars = new char[freq];
            Arrays.fill(chars, '*');
            String result = new String(chars);
            output = output.concat(String.format("%2d - %3d | %s %n <br/>", i, i + 9, result));
        }

        return output;
    }
}