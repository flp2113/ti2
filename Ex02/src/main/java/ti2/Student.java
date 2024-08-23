package ti2;

public class Student {
	private int id;
	private String name;
	private int age;
	private int semester;
	private String course;
	
	//CONSTRUCTOR
	public Student(int id, String name, int age, int semester, String course) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.semester = semester;
		this.course = course;
	}
	
	//GETTERS
	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public int getSemester() {
		return this.semester;
	}
	
	public String getCourse() {
		return this.course;
	}
	
	//SETTERS
	public void setId(int id) {
		this.id = id;
	}

	public void getName(String name) {
		this.name = name;
	}
	
	public void getAge(int age) {
		this.age = age;
	}
	
	public void getSemester(int semester) {
		this.semester = semester;
	}
	
	public void getCourse(String course) {
		this.course = course;
	}
}
