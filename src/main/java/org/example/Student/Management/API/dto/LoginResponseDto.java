package org.example.Student.Management.API.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.example.Student.Management.API.entity.Student;

public record LoginResponseDto(String message, StudentDto student, String jwt) {
}
