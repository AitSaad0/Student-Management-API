package Student.Management.API.example.Student.Management.API.controller;

import Student.Management.API.example.Student.Management.API.dto.StudentDto;
import Student.Management.API.example.Student.Management.API.entity.Student;
import Student.Management.API.example.Student.Management.API.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/add-student")
    public ResponseEntity<Student> addStudent(@Valid @RequestBody StudentDto studentDto){
        Student student = studentService.addStudent(studentDto);
        return  ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

    @GetMapping("/get-students")
    public ResponseEntity<List<StudentDto>> getStudents(){
        List<StudentDto> studentDto = studentService.getStudents();
        return ResponseEntity.ok().body(studentDto);
    }

    @GetMapping("get-student-by-id")
    public ResponseEntity<StudentDto> getStudent(@RequestParam(required = true) Long id){
        StudentDto studentDto = studentService.getStudentById(id);
        return ResponseEntity.ok(studentDto);
    }
}
