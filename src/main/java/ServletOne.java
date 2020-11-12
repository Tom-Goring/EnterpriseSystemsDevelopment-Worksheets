import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ServletOne extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Student> numList = new ArrayList<>();

        try {
            System.out.println(System.getProperty("user.dir"));
            Scanner scanner = new Scanner(new File("C:\\Users\\tomgo\\IdeaProjects\\ServletTest\\src\\main\\resources\\grades.txt"));

            int current_student = 0;
            while (scanner.hasNextLine()) {
                numList.add(new Student(""+current_student, scanner.nextInt()));
                scanner.nextLine();
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Histogram h = new Histogram(numList);

        request.setAttribute("histogramString", h.printHistogram());

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
