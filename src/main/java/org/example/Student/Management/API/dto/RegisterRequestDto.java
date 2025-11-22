package org.example.Student.Management.API.dto;


import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class RegisterRequestDto {

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
    @Pattern(regexp = "^\\d{10}$", message = "Phone number must be 10 digits")
    private String phone_number;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "field is required")
    private String field;

    @NotBlank(message = "Password is required")
    @Size(min = 8, max = 20, message = "Password length must be between 8 and 50 characters")
    private String password;
}
