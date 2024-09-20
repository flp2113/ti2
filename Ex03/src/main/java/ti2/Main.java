package ti2;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student(1, "Felipe", 18, 2, "Ciencia da Computacao");

        DAO dao = new DAO("jdbc:postgresql://localhost:5432/ti2", "postgres", "galo1234");

        dao.insertStudent(s1);
        dao.updateStudent(s1, "Poggers", 20, 3, "Enfermagem");
        dao.deleteStudent(1);
        List<Student> students = dao.readStudent();
        for (Student student : students) {
            System.out.println("ID: " + student.getId());
            System.out.println("Name: " + student.getName());
            System.out.println("Age: " + student.getAge());
            System.out.println("Semester: " + student.getSemester());
            System.out.println("Course: " + student.getCourse());
            System.out.println("-----------------------------");
        }
    }
}