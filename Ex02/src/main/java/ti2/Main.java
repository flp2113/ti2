package ti2;

public class Main {
	public static void main(String[] args) {
		Student s1 = new Student(1, "Felipe", 18, 2, "Ciencia da Computacao");
		DAO dao = new DAO("jdbc:postgresql://localhost:5432/ti2", "postgres", "galo1234");
		//dao.insertStudent(s1);
		//dao.updateStudent(s1, "Poggers", 20, 3, "Enfermagem");
		dao.deleteStudent(1);
		
		dao.readStudent();
	}
}
