package EpamLearn;

import EpamLearn.service.Service;
import java.io.File;

public class Runner {

  public static void main(String[] args) {
    String pathToFile = String.valueOf(args[0]);
    File file = new File(pathToFile);
    if (file.exists()) {
      if (file.isDirectory()) {
        Service.writeTheStructureOfFoldersAndFilesToFile(file);
      } else {
        Service.readFileAndOutputTheDataToTheConsole(pathToFile);
      }
    } else {
      System.out.println("Такой директории или файла не существует");
    }
  }
}
