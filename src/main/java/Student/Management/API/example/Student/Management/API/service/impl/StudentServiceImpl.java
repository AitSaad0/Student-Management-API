package Student.Management.API.example.Student.Management.API.service.impl;

import Student.Management.API.example.Student.Management.API.dto.StudentDto;
import Student.Management.API.example.Student.Management.API.entity.Student;
import Student.Management.API.example.Student.Management.API.repository.StudentRepository;
import Student.Management.API.example.Student.Management.API.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public Student addStudent(StudentDto studentDto) {
        Student student = new Student();
        BeanUtils.copyProperties(studentDto, student);
        return studentRepository.save(student);
    }

    public StudentDto transferToDto(Student student){
        StudentDto studentDto = new StudentDto();
        BeanUtils.copyProperties(student,studentDto);
        return studentDto;
    }

}
