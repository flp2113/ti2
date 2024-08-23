package ti2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAO {
	private String url;
	private String username;
	private String password;
	private Connection connection;

	public DAO(String url, String username, String password) {
		this.url = url;
		this.username = username;
		this.password = password;
		
		try {
			Class.forName("org.postgresql.Driver");
			this.connection = DriverManager.getConnection(this.url, this.username, this.password);
			System.out.println("DATABASE CONNECTED!");
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
		
	public boolean insertStudent(Student student) {
	    boolean status = false;
	    String sql = "INSERT INTO student (id, name, age, semester, course) VALUES (?, ?, ?, ?, ?)";
	    try (PreparedStatement preparedStatement = this.connection.prepareStatement(sql)) {
	    	preparedStatement.setInt(1, student.getId());
	        preparedStatement.setString(2, student.getName());
	        preparedStatement.setInt(3, student.getAge());
	        preparedStatement.setInt(4, student.getSemester());
	        preparedStatement.setString(5, student.getCourse());

	        int rowsAffected = preparedStatement.executeUpdate();
	        if (rowsAffected > 0) {
	            status = true;
	        }
	    } catch (Exception e) {
	        System.err.println("INSERT: " + e.getMessage());
	    }
	    return status;
	}
	
	public boolean readStudent() {
		boolean status = false;
		try {
			Statement statement = this.connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM student");
			while(resultSet.next()) {
				System.out.println(resultSet.getString("id") + " " +
							resultSet.getString("name").stripTrailing() + " " +
							resultSet.getString("age") + " " +
							resultSet.getString("semester") + " " +
							resultSet.getString("course").stripTrailing()
						);
			}
		} catch(Exception e) {
			System.err.println("READ " + e.getMessage());
		}
		return status;
	}
	
	public boolean updateStudent(Student student, String new_name, int new_age, int new_semester, String new_course) {
	    boolean status = false;
	    String sql = "UPDATE student SET name = ?, age = ?, semester = ?, course = ? WHERE id = ?";
	    
	    try (PreparedStatement preparedStatement = this.connection.prepareStatement(sql)) {
	        preparedStatement.setString(1, new_name);
	        preparedStatement.setInt(2, new_age);
	        preparedStatement.setInt(3, new_semester);
	        preparedStatement.setString(4, new_course);
	        preparedStatement.setInt(5, student.getId()); 

	        int rowsAffected = preparedStatement.executeUpdate();
	        if (rowsAffected > 0) {
	            status = true;  
	        }
	    } catch (Exception e) {
	        System.err.println("UPDATE " + e.getMessage());
	    }
	    return status;
	}
	
	public boolean deleteStudent(int studentId) {
	    boolean status = false;
	    String sql = "DELETE FROM student WHERE id = ?";
	    
	    try (PreparedStatement preparedStatement = this.connection.prepareStatement(sql)) {
	        preparedStatement.setInt(1, studentId);

	        int rowsAffected = preparedStatement.executeUpdate();
	        if (rowsAffected > 0) {
	            status = true;
	        }
	    } catch (Exception e) {
	        System.err.println("DELETE " + e.getMessage());
	    }
	    return status;
	}
	
}
