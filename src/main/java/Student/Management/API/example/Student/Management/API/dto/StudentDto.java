package Student.Management.API.example.Student.Management.API.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Setter;
import lombok.Getter;

import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter @Setter
public class StudentDto {

    private int student_id;
    private String apogee;
    private String first_name;
    private String last_name;
    private int age;
    private int phone_number;
    private String email;
    private String field;
}
