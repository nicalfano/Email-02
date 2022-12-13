package co.develhope.Email1.servicies;

import co.develhope.Email1.entities.Student;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    static List<Student> students = Arrays.asList(
            new Student("1","Nicola", "Alfano","nicalfano@hotmail.it"),
            new Student("2","Nicola", "Alfano","nicalfano@hotmail.com"),
            new Student("3","Nicola", "Alfano","nicalfano@hotmail.org"),
            new Student("4","Nicola", "Alfano","nicalfano@hotmail.co")
    );

    public Student getStudentById(String studentId){
        Optional<Student> student = students.stream().filter(s -> s.getId().equals(studentId)).findAny();
        if(student.isPresent()) return student.get();
        return null;
}
}
