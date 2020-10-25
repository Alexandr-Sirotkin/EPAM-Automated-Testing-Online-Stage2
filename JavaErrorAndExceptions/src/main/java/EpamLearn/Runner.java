package EpamLearn;

import EpamLearn.core.Faculty;
import EpamLearn.core.Group;
import EpamLearn.core.Mark;
import EpamLearn.core.Student;
import EpamLearn.core.Subjects;
import EpamLearn.core.University;
import EpamLearn.exceptions.MarkOutOfBoundsException;
import EpamLearn.exceptions.NoFacultiesInTheUniversityException;
import EpamLearn.exceptions.NoGroupsInTheFacultyException;
import EpamLearn.exceptions.NoStudentsInTheGroupExceptions;
import EpamLearn.exceptions.StudentHasNoSubjectsException;
import java.util.Arrays;

public class Runner {

  public static void main(String[] args) {

    try {
      Student student1 = new Student(12356, "Шевчук", "Николай", Arrays.asList(
          new Mark(Subjects.CULTURAL_STUDIES, 7),
          new Mark(Subjects.DRAWING, 4),
          new Mark(Subjects.ECONOMY, 5),
          new Mark(Subjects.HISTORY, 8),
          new Mark(Subjects.HYDROGASDYNAMICS, 5),
          new Mark(Subjects.METROLOGY, 7),
          new Mark(Subjects.THERMODYNAMICS, 4),
          new Mark(Subjects.PHYSICAL_CULTURE, 8),
          new Mark(Subjects.SOCIOLOGY, 9),
          new Mark(Subjects.LOGICS, 8),
          new Mark(Subjects.JURISPRUDENCE, 6)));
      Student student2 = new Student(12789, "Богуш", "Максим", Arrays.asList(
          new Mark(Subjects.ETHICS, 4),
          new Mark(Subjects.FOREIGN_LANGUAGE, 5),
          new Mark(Subjects.LOGICS, 5),
          new Mark(Subjects.ETHICS, 7),
          new Mark(Subjects.DRAWING, 5),
          new Mark(Subjects.PHILOSOPHY, 5),
          new Mark(Subjects.SOCIOLOGY, 6),
          new Mark(Subjects.HIGHER_MATHEMATICS, 4),
          new Mark(Subjects.NATURAL_SCIENCE, 6),
          new Mark(Subjects.JURISPRUDENCE, 6)));
      Student student3 = new Student(12126, "Шестюк", "Евгений", Arrays.asList(
          new Mark(Subjects.CULTURAL_STUDIES, 7),
          new Mark(Subjects.DRAWING, 7),
          new Mark(Subjects.ECONOMY, 7),
          new Mark(Subjects.HISTORY, 8),
          new Mark(Subjects.HYDROGASDYNAMICS, 7),
          new Mark(Subjects.METROLOGY, 8),
          new Mark(Subjects.THERMODYNAMICS, 7),
          new Mark(Subjects.PHYSICAL_CULTURE, 8),
          new Mark(Subjects.SOCIOLOGY, 9),
          new Mark(Subjects.LOGICS, 8),
          new Mark(Subjects.JURISPRUDENCE, 7)));
      Student student4 = new Student(12478, "Козлов", "Никита", Arrays.asList(
          new Mark(Subjects.ETHICS, 4),
          new Mark(Subjects.FOREIGN_LANGUAGE, 5),
          new Mark(Subjects.LOGICS, 5),
          new Mark(Subjects.ETHICS, 4),
          new Mark(Subjects.DRAWING, 5),
          new Mark(Subjects.PHILOSOPHY, 6),
          new Mark(Subjects.SOCIOLOGY, 4),
          new Mark(Subjects.HIGHER_MATHEMATICS, 4),
          new Mark(Subjects.NATURAL_SCIENCE, 5),
          new Mark(Subjects.JURISPRUDENCE, 5)));
      Student student5 = new Student(12386, "Шишло", "Максим", Arrays.asList(
          new Mark(Subjects.CULTURAL_STUDIES, 8),
          new Mark(Subjects.DRAWING, 8),
          new Mark(Subjects.ECONOMY, 7),
          new Mark(Subjects.HISTORY, 8),
          new Mark(Subjects.HYDROGASDYNAMICS, 7),
          new Mark(Subjects.METROLOGY, 8),
          new Mark(Subjects.THERMODYNAMICS, 7),
          new Mark(Subjects.PHYSICAL_CULTURE, 9),
          new Mark(Subjects.SOCIOLOGY, 9),
          new Mark(Subjects.LOGICS, 8),
          new Mark(Subjects.JURISPRUDENCE, 8)));
      Student student6 = new Student(12789, "Батырева", "Мария", Arrays.asList(
          new Mark(Subjects.ETHICS, 7),
          new Mark(Subjects.FOREIGN_LANGUAGE, 6),
          new Mark(Subjects.LOGICS, 7),
          new Mark(Subjects.ETHICS, 8),
          new Mark(Subjects.DRAWING, 6),
          new Mark(Subjects.PHILOSOPHY, 7),
          new Mark(Subjects.SOCIOLOGY, 8),
          new Mark(Subjects.HIGHER_MATHEMATICS, 8),
          new Mark(Subjects.NATURAL_SCIENCE, 8),
          new Mark(Subjects.JURISPRUDENCE, 7)));
      Group group1 = new Group("ТЭ-11", Arrays.asList(student1, student3, student5));
      Group group2 = new Group("АГ-11", Arrays.asList(student2, student4, student6));
      Faculty facultyEnergy = new Faculty("Энергетический", Arrays.asList(group1));
      Faculty facultyCorrespondence = new Faculty("Заочный", Arrays.asList(group2));
      University university = new University("ГГТУ им. П.О.Сухого",
          Arrays.asList(facultyEnergy, facultyCorrespondence));
      System.out.println("Средний балл по всем предметам студента Шевчука Николая: " + student1
          .getAverageMarkInAllSubjectsOfTheStudent());
      System.out.println(
          "Cредний балл по высшей математике в группе АГ-11 на Заочном факультете: " + university
              .getAverageMarkInTheSubjectInTheGroupAtTheFaculty("Заочный", "АГ-11",
                  Subjects.HIGHER_MATHEMATICS));
      System.out.println("Средний балл по черчению для всего университета: " + university
          .getAverageMarkInTheSubjectForTheUniversity(Subjects.DRAWING));
    } catch (StudentHasNoSubjectsException e) {
      System.err.println(e);
    } catch (MarkOutOfBoundsException e) {
      System.err.println(e);
    } catch (NoStudentsInTheGroupExceptions e) {
      System.err.println(e);
    } catch (NoGroupsInTheFacultyException e) {
      System.err.println(e);
    } catch (NoFacultiesInTheUniversityException e) {
      System.err.println(e);
    }
  }
}
