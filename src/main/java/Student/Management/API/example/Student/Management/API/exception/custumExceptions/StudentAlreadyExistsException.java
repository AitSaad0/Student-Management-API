package Student.Management.API.example.Student.Management.API.exception.custumExceptions;

public class StudentAlreadyExistsException extends RuntimeException {
  public StudentAlreadyExistsException(String message) {
    super(message);
  }
}
