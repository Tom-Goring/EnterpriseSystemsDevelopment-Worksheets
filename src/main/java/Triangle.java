public class Triangle {
    int A, B, C;

    public Triangle(int a, int b, int c) {
        A = a;
        B = b;
        C = c;
    }

    public void printType() {
        if (A == B && B == C){
            System.out.println("This triangle is Equilateral");
        }

        // if Scalene
        else if (A != B && A != C && B != C){
            System.out.println("This triangle is Scalene");
        }

        // if Isosceles
        else {
            System.out.println("This triangle is Isosceles");
        }
    }
}
