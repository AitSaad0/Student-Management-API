package Student.Management.API.example.Student.Management.API.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Setter;
import lombok.Getter;

import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.Instant;

@Getter @Setter
public class StudentDto {

    @NotNull(message = "student_id is required")
    @Positive(message = "student_id must be positive")
    private Long student_id;

    @NotBlank(message = "apogee is required")
    @Pattern(regexp = "^\\d{7}$", message = "Apogee must be digit")
    @Size(min = 7, max = 7, message = "Apogee must be exactly 7 digits")
    private String apogee;

    @NotBlank(message = "first_name is required")
    @Size(max = 15, message = "First name must be under 15 character")
    private String first_name;

    @NotBlank(message = "last_name is required")
    @Size(max = 15, message = "Last name must be under 15 character")
    private String last_name;

    @NotNull
    @Positive(message = "Age must be positive")
    @Max(value = 60, message = "Age must be less than or equal to 60")
    @Min(value = 18, message = "Age must be at least 18")
    private int age;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^\\d{10}$", message = "Phone number must be digit")
    private String phone_number;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "field is required")
    private String field;
}
