package EpamLearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.Semaphore;

public class Runner {

  public static void main(String[] args) {
    System.out.println("Введите количество мест на автостоянке:");
    try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
      int numberOfPlaces = Integer.parseInt(reader.readLine());
      System.out.println("Введите количество автомобилей:");
      int numberOfCars = Integer.parseInt(reader.readLine());
      Semaphore parking = new Semaphore(numberOfPlaces);
      int[] waitingTimeArray = new int[numberOfCars];
      for (int i = 1; i < numberOfCars + 1; i++) {
        System.out.println("Введите максимально допустимое время ожидания " + i
            + "-й машины свободного места в секундах:");
        waitingTimeArray[i - 1] = Integer.parseInt(reader.readLine());
      }
      for (int i = 0; i < numberOfCars; i++) {
        Thread car = new Thread(new Car(parking, waitingTimeArray[i]));
        car.start();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
