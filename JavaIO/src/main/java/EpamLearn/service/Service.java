package EpamLearn.service;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Service {

  private static int spaceForDirectory = 1;
  private static int spaceForFile = 1;

  public static void writeTheStructureOfFoldersAndFilesToFile(File file) {
    File folderAndFileStructure = new File(
        "src\\main\\java\\resources\\folderAndFileStructure.txt");
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(folderAndFileStructure))) {
      writer.write("--||" + file.getName());
      writer.newLine();
      File[] child = file.listFiles();
      writeContent(child, writer);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void writeContent(File[] listFiles, BufferedWriter writer) throws IOException {
    StringBuffer stringBuffer = new StringBuffer(" ");
    for (File file : listFiles) {
      if (file.isDirectory()) {
        stringBuffer.setLength(4 * (spaceForDirectory++));
        writer.write(stringBuffer.toString() + "--||" + file.getName());
        writer.newLine();
        File[] child = file.listFiles();
        spaceForFile++;
        writeContent(child, writer);
        spaceForDirectory--;
        spaceForFile--;
      } else {
        stringBuffer.setLength(4 * (spaceForFile));
        writer.write(stringBuffer.toString() + "*" + file.getName());
        writer.newLine();
      }
    }
  }

  public static void readFileAndOutputTheDataToTheConsole(String path) {
    try {
      List<String> lines = Files.readAllLines(Paths.get(path), UTF_8);
      int countFolders = 0;
      int countFiles = 0;
      long sumOfFileNameLength = 0L;
      for (String line : lines) {
        if (line.contains("--||")) {
          countFolders++;
        }
        if (line.contains("*")) {
          countFiles++;
          sumOfFileNameLength += line.trim().replace("*", "").length();
        }
      }
      System.out.println("Количество папок: " + countFolders);
      System.out.println("Количество файлов " + countFiles);
      System.out.println("Среднее количество файлов в папке: " + countFiles * 1.0 / countFolders);
      System.out
          .println("Средняя длинна названия файла: " + sumOfFileNameLength * 1.0 / countFiles);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
