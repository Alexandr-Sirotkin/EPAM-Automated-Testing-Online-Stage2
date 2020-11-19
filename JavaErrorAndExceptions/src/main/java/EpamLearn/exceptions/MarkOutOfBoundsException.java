package EpamLearn.exceptions;

public class MarkOutOfBoundsException extends RuntimeException {

  public MarkOutOfBoundsException() {
  }

  public MarkOutOfBoundsException(String message) {
    super(message);
  }

  public MarkOutOfBoundsException(String message, Throwable cause) {
    super(message, cause);
  }

  public MarkOutOfBoundsException(Throwable cause) {
    super(cause);
  }
}
