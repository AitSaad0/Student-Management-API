package Student.Management.API.example.Student.Management.API.exception;


import Student.Management.API.example.Student.Management.API.dto.ErrorDto;
import Student.Management.API.example.Student.Management.API.exception.custumExceptions.StudentAlreadyExistsException;
import Student.Management.API.example.Student.Management.API.exception.custumExceptions.StudentNotExist;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        fieldErrors.forEach(fieldError -> errors.put(fieldError.getField(), fieldError.getDefaultMessage()));
        return ResponseEntity.badRequest().body(errors);

    }

    @ExceptionHandler(StudentAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> studentAlreadyExistsExceptionHandler(StudentAlreadyExistsException ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put("error", ex.getMessage());
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Map<String, String>> MethodArgumentTypeMismatchExceptionHandler(MethodArgumentTypeMismatchException ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put("error", "The id should be of type integer");
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<Map<String, String>> MissingServletRequestParameterExceptionhandler(MissingServletRequestParameterException ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put("error", "Id is required");
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(StudentNotExist.class)
    public ResponseEntity<Map<String, String>> studentNotExistExceptionHandler(StudentNotExist ex) {
        Map<String, String> errors = new HashMap<>();
        errors.put("error", ex.getMessage());
        return ResponseEntity.badRequest().body(errors);
    }



}
