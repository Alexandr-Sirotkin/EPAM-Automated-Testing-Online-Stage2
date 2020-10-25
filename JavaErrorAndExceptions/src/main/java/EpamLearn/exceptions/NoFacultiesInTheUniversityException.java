package EpamLearn.exceptions;

public class NoFacultiesInTheUniversityException extends Exception {

  public NoFacultiesInTheUniversityException() {
  }

  public NoFacultiesInTheUniversityException(String message) {
    super(message);
  }

  public NoFacultiesInTheUniversityException(String message, Throwable cause) {
    super(message, cause);
  }

  public NoFacultiesInTheUniversityException(Throwable cause) {
    super(cause);
  }
}
