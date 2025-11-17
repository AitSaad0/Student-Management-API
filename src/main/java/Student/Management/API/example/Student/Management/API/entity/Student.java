package Student.Management.API.example.Student.Management.API.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "students")
@Getter @Setter
public class Student extends BaseEntity{
    @Id
    @Column
    private int student_id;

    @Column(nullable = false, unique = true)
    private String apogee;

    @Column(nullable = false)
    private String first_name;

    @Column(nullable = false)
    private String last_name;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private int phone_number;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String field;
}
