package student_app;

import java.util.ArrayList;
import java.util.List;

public class StudentDb {
    private static List<Student> studentList = new ArrayList<Student>();

    public static Student getStudent(int id) {
        for (Student student : studentList) {
            if (student.getId() == id) {
                return student;
            }
        }
        return new Student(0, null, 0);
    }

    public static List<Student> getStudentList() {
        return studentList;
    }

    public static void addStudent(Student newStudent) {
        studentList.add(newStudent);
    }

    public static boolean updateStudent(int id, Student student) {
        for (Student student2 : studentList) {
            if (student2.getId() == id) {
                student2.setId(student.getId());
                student2.setName(student.getName());
                student2.setYear(student.getYear());
                return true;
            }
        }
        return false;
    }

    public static boolean deleteStudent(int id) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == id) {
                studentList.remove(i);
                return true;
            }
        }
        return false;
    }
}
