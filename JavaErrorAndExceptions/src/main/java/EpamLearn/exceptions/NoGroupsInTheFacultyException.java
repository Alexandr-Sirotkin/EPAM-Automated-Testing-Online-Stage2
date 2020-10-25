package EpamLearn.exceptions;

public class NoGroupsInTheFacultyException extends Exception {

  public NoGroupsInTheFacultyException() {
  }

  public NoGroupsInTheFacultyException(String message) {
    super(message);
  }

  public NoGroupsInTheFacultyException(String message, Throwable cause) {
    super(message, cause);
  }

  public NoGroupsInTheFacultyException(Throwable cause) {
    super(cause);
  }
}
