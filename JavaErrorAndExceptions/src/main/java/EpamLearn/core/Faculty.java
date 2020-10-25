package EpamLearn.core;

import EpamLearn.exceptions.NoGroupsInTheFacultyException;
import java.util.List;

public class Faculty {

  private String name;
  private List<Group> groupsList;

  public Faculty(String name, List<Group> groupsList) throws NoGroupsInTheFacultyException {
    this.name = name;
    setGroupsList(groupsList);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Group> getGroupsList() {
    return groupsList;
  }

  public void setGroupsList(List<Group> groupsList) throws NoGroupsInTheFacultyException {
    if (groupsList.isEmpty()) {
      throw new NoGroupsInTheFacultyException("There aren't groups in the faculty.");
    } else {
      this.groupsList = groupsList;
    }
  }

  @Override
  public String toString() {
    return "Faculty{" +
        "name='" + name + '\'' +
        ", groupsList=" + groupsList +
        '}';
  }
}
