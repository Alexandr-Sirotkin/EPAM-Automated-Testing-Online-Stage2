package EpamLearn.core;

import EpamLearn.exceptions.NoFacultiesInTheUniversityException;
import java.util.List;

public class University {

  private String name;
  private List<Faculty> facultiesList;

  public University(String name, List<Faculty> facultiesList)
      throws NoFacultiesInTheUniversityException {
    this.name = name;
    setFacultiesList(facultiesList);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setFacultiesList(List<Faculty> facultiesList)
      throws NoFacultiesInTheUniversityException {
    if (facultiesList.isEmpty()) {
      throw new NoFacultiesInTheUniversityException("There aren't faculties in the University.");
    } else {
      this.facultiesList = facultiesList;
    }
  }

  public double getAverageMarkInTheSubjectInTheGroupAtTheFaculty(String facultiesName,
      String groupName, Subjects subject) {
    int sumOfMarks = 0;
    int numberOfMarks = 0;
    for (Faculty faculty : facultiesList) {
      if (faculty.getName() == facultiesName) {
        for (Group group : faculty.getGroupsList()) {
          if (group.getName() == groupName) {
            for (Student student : group.getStudentsList()) {
              for (Mark mark : student.getMarksList()) {
                if (mark.getSubject() == subject) {
                  sumOfMarks += mark.getMark();
                  numberOfMarks++;
                }
              }
            }
          }
        }
      }
    }
    return sumOfMarks * 1.0 / numberOfMarks;
  }

  public double getAverageMarkInTheSubjectForTheUniversity(Subjects subject) {
    int sumOfMarks = 0;
    int numberOfMarks = 0;
    for (Faculty faculty : facultiesList) {
      for (Group group : faculty.getGroupsList()) {
        for (Student student : group.getStudentsList()) {
          for (Mark mark : student.getMarksList()) {
            if (mark.getSubject() == subject) {
              sumOfMarks += mark.getMark();
              numberOfMarks++;
            }
          }
        }
      }
    }
    return sumOfMarks * 1.0 / numberOfMarks;
  }

  @Override
  public String toString() {
    return "University{" +
        "name='" + name + '\'' +
        ", facultiesList=" + facultiesList +
        '}';
  }
}
