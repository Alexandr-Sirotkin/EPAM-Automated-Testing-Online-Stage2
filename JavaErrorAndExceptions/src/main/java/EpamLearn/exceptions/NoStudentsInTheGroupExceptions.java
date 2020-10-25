package EpamLearn.exceptions;

public class NoStudentsInTheGroupExceptions extends Exception {

  public NoStudentsInTheGroupExceptions() {
  }

  public NoStudentsInTheGroupExceptions(String message) {
    super(message);
  }

  public NoStudentsInTheGroupExceptions(String message, Throwable cause) {
    super(message, cause);
  }

  public NoStudentsInTheGroupExceptions(Throwable cause) {
    super(cause);
  }
}
