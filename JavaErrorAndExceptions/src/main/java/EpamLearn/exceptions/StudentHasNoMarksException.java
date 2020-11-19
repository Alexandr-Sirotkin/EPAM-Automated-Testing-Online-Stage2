package EpamLearn.exceptions;

public class StudentHasNoMarksException extends RuntimeException {

  public StudentHasNoMarksException() {
  }

  public StudentHasNoMarksException(String message) {
    super(message);
  }

  public StudentHasNoMarksException(String message, Throwable cause) {
    super(message, cause);
  }

  public StudentHasNoMarksException(Throwable cause) {
    super(cause);
  }
}
