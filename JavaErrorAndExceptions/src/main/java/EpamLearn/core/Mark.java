package EpamLearn.core;

import EpamLearn.exceptions.MarkOutOfBoundsException;

public class Mark {

  private Subjects subject;
  private int mark;

  public Mark(Subjects subject, int mark) throws MarkOutOfBoundsException {
    this.subject = subject;
    setMark(mark);
  }

  public Subjects getSubject() {
    return subject;
  }

  public void setSubject(Subjects subject) {
    this.subject = subject;
  }

  public int getMark() {
    return mark;
  }

  public void setMark(int mark) throws MarkOutOfBoundsException {
    if (mark < 0 || mark > 10) {
      throw new MarkOutOfBoundsException("The mark cannot be less than 0 and more than 10.");
    } else {
      this.mark = mark;
    }
  }

  @Override
  public String toString() {
    return "Mark{" +
        "subject=" + subject +
        ", mark=" + mark +
        '}';
  }

}
