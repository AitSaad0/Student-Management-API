package org.example.Student.Management.API.repository;

import org.example.Student.Management.API.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
    boolean existsByApogee(String apogee);


}
