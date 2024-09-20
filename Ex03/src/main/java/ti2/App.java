package ti2;

import static spark.Spark.*;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        port(4567);

        // Banco em memória
        Map<Integer, Student> students = new HashMap<>();
        Gson gson = new Gson();

        staticFiles.location("/public");

        post("/students", (req, res) -> {
            Student student = gson.fromJson(req.body(), Student.class);
            students.put(student.getId(), student);
            res.status(201); 
            return gson.toJson(student);
        });

        get("/students", (req, res) -> gson.toJson(students.values()));

        get("/students/:id", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            Student student = students.get(id);
            if (student == null) {
                res.status(404); 
                return "Student not found";
            }
            return gson.toJson(student);
        });

        put("/students/:id", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            Student updatedStudent = gson.fromJson(req.body(), Student.class);
            Student student = students.get(id);
            if (student == null) {
                res.status(404);
                return "Student not found";
            }
            student.setId(updatedStudent.getId());
            student.getName(updatedStudent.getName());
            student.getAge(updatedStudent.getAge());
            student.getSemester(updatedStudent.getSemester());
            student.getCourse(updatedStudent.getCourse());
            return gson.toJson(student);
        });

        delete("/students/:id", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            Student student = students.remove(id);
            if (student == null) {
                res.status(404);
                return "Student not found";
            }
            res.status(204);
            return "";
        });
    }
}