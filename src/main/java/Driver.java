import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args)  {
        ArrayList<Integer> numList = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File("./src/main/resources/grades.txt"));

            while (scanner.hasNextLine()) {
                numList.add(scanner.nextInt());
                scanner.nextLine();
            }

            scanner.close();
        } catch (FileNotFoundException exe) {
            exe.printStackTrace();
        }

        Histogram h = new Histogram(numList);

        h.printHistogram();
    }
}
