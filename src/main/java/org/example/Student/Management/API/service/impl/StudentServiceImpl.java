package org.example.Student.Management.API.service.impl;

import org.example.Student.Management.API.dto.StudentDto;
import org.example.Student.Management.API.entity.Student;
import org.example.Student.Management.API.exception.custumExceptions.StudentAlreadyExistsException;
import org.example.Student.Management.API.exception.custumExceptions.StudentNotExist;
import org.example.Student.Management.API.repository.StudentRepository;
import org.example.Student.Management.API.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    //Add new Student to db
    public Student addStudent(StudentDto studentDto) {
        if(studentRepository.existsByApogee(studentDto.getApogee())) {
            throw new StudentAlreadyExistsException("Student with apogee " +  studentDto.getApogee() + " already exists");
        }
        Student student = new Student();
        BeanUtils.copyProperties(studentDto, student);
        return studentRepository.save(student);
    }

    //Get All Students
    public List<StudentDto> getStudents(){
        return studentRepository.findAll().stream().map(this::transferToDto).collect(Collectors.toUnmodifiableList());
    }


    //Get Student by id
    public StudentDto getStudentById(Long student_id){
        Student student = studentRepository.findById(student_id).
                orElseThrow(() -> new StudentNotExist("Student with id " + student_id + " does not exist"));
        return transferToDto(student);
    }


    //update student
    public Student updateStudent(StudentDto studentDto) {
            long id = studentDto.getStudent_id();
            Student student = studentRepository.findById(id)
                    .orElseThrow(() -> new StudentNotExist("Student with id " + id + " does not exist"));
            BeanUtils.copyProperties(studentDto, student, "student_id", "apogee");
            return studentRepository.save(student);
    }



    //Transfer student to studentDto
    public StudentDto transferToDto(Student student){
        StudentDto studentDto = new StudentDto();
        BeanUtils.copyProperties(student,studentDto);
        return studentDto;
    }

}
