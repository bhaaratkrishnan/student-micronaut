package student_app;

import io.micronaut.http.annotation.*;

import java.util.List;

import io.micronaut.http.MediaType;

@Controller("/student")
public class StudentController {
    @Get(produces = MediaType.APPLICATION_JSON)
    public List<Student> allStudents() {
        return StudentDb.getStudentList();
    }

    @Get("/{id}")
    public Student student(@PathVariable int id) {

        return StudentDb.getStudent(id);

    }

    @Post(consumes = MediaType.APPLICATION_JSON, produces = MediaType.TEXT_PLAIN)
    public String addStudent(@Body Student student) {
        StudentDb.addStudent(student);
        return "Student Added";
    }

    @Put("/{id}")
    public String updateStudent(@PathVariable int id, @Body Student student) {
        if (StudentDb.updateStudent(id, student)) {
            return "Student Updated";
        } else {
            return "Id Error";
        }
    }

    @Delete("/{id}")
    public String deleteStudent(@PathVariable int id) {
        if (StudentDb.deleteStudent(id)) {
            return "Student Deleted";
        } else {
            return "Id Error";
        }
    }
}
