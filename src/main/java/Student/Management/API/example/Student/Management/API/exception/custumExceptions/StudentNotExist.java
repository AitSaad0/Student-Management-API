package Student.Management.API.example.Student.Management.API.exception.custumExceptions;

public class StudentNotExist extends RuntimeException {
  public StudentNotExist(String message) {
    super(message);
  }
}
