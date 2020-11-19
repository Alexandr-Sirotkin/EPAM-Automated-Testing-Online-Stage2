package EpamLearn.core;

import EpamLearn.exceptions.NoStudentsInTheGroupExceptions;
import java.util.List;

public class Group {

  private String name;
  private List<Student> studentsList;

  public Group(String name, List<Student> studentsList) throws NoStudentsInTheGroupExceptions {
    this.name = name;
    setStudentsList(studentsList);
  }

  String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  List<Student> getStudentsList() {
    return studentsList;
  }

  private void setStudentsList(List<Student> studentsList) throws NoStudentsInTheGroupExceptions {
    if (studentsList.isEmpty()) {
      throw new NoStudentsInTheGroupExceptions("There aren't students in the group.");
    } else {
      this.studentsList = studentsList;
    }
  }

  @Override
  public String toString() {
    return "Group{" +
        "name='" + name + '\'' +
        ", studentsList=" + studentsList +
        '}';
  }
}
