package Student.Management.API.example.Student.Management.API.controller;

import Student.Management.API.example.Student.Management.API.dto.StudentDto;
import Student.Management.API.example.Student.Management.API.entity.Student;
import Student.Management.API.example.Student.Management.API.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/add-student")
    public ResponseEntity<Student> addStudent(@RequestBody StudentDto studentDto){
        Student student = studentService.addStudent(studentDto);
        return  ResponseEntity.status(HttpStatus.CREATED).body(student);
    }
}
