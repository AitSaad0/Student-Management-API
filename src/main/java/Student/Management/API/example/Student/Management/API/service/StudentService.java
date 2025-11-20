package Student.Management.API.example.Student.Management.API.service;

import Student.Management.API.example.Student.Management.API.dto.StudentDto;
import Student.Management.API.example.Student.Management.API.entity.Student;

import java.util.List;

public interface StudentService {
    public Student addStudent(StudentDto studentDto);

    public List<StudentDto> getStudents();

    public StudentDto getStudentById(Long student_id);

    public Student updateStudent(StudentDto studentDto);


}
