public class Student {
    public static Integer numStudents = 0;

    private int id;
    private String name;

    public Student(Integer id, String name) {
        this.id = id;
        this.name = name;
        numStudents = numStudents + 1;
    }

    public static void main(String[] args) {
        for (Integer i = 0; i < 10; i++) {
            Student s = new Student(i, "Student " + i.toString());
        }
        System.out.println("Number of students: " + Student.numStudents.toString());
    }
}