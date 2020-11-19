package EpamLearn.core;

import EpamLearn.exceptions.StudentHasNoMarksException;
import java.util.List;

public class Student {

  private int id;
  private String surname;
  private String name;
  private List<Mark> marksList;

  public Student(int id, String surname, String name, List<Mark> marksList) throws StudentHasNoMarksException {
    this.id = id;
    this.surname = surname;
    this.name = name;
    setMarksList(marksList);
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  List<Mark> getMarksList() {
    return marksList;
  }

  private void setMarksList(List<Mark> marksList) throws StudentHasNoMarksException {
    if (marksList.isEmpty()) {
      throw new StudentHasNoMarksException("The student hasn't subjects");
    } else {
      this.marksList = marksList;
    }
  }

  public double getAverageMarkInAllSubjectsOfTheStudent() {
    int sumOfMarks = 0;
    int numberOfMarks = marksList.size();
    for (Mark mark : marksList) {
      sumOfMarks += mark.getMark();
    }
    return sumOfMarks * 1.0 / numberOfMarks;
  }

  @Override
  public String toString() {
    return "Student{" +
        "id=" + id +
        ", surname='" + surname + '\'' +
        ", name='" + name + '\'' +
        ", marksList=" + marksList +
        '}';
  }
}
