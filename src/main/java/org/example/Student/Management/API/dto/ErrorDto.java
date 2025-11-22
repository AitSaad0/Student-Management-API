package org.example.Student.Management.API.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
public class ErrorDto {
    private String apiPath;
    private HttpStatus status;
    private String errorMessage;
    private LocalDateTime timestamp;
}

