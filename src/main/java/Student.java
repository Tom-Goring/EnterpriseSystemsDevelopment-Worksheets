public class Student {
    private String id;
    private int grade;

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", grade=" + grade +
                '}';
    }

    public Student(String id, int grade) {
        this.id = id;
        this.grade = grade;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}