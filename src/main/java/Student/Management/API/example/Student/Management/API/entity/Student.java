package Student.Management.API.example.Student.Management.API.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "students")
@Getter @Setter
public class Student{
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

    @ColumnDefault("NULL")
    @Column(name="created_at",  nullable=false)
    private Instant createdAt;

    @ColumnDefault("NULL")
    @Column(name="created_by",  nullable=false)
    private String createdBy;

    private Instant updatedAt;
    private Instant updatedBy;
}
