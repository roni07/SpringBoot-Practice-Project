package basic.vaadin.vaadinbasic.service;

import basic.vaadin.vaadinbasic.model.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {
    private ObjectMapper objectMapper;

    public StudentService(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public List<Student> getAllStudents(){
        Student[] students = null;

        try{
            URL url = new URL("http://localhost:8086/student/all");
            students = objectMapper.readValue(url, Student[].class);
            System.out.println("Read from server" + Arrays.toString(students));
        }

        catch (IOException e){
            e.printStackTrace();
        }

        List<Student> studentList = Arrays.asList(students);
        return studentList;
    }
}
