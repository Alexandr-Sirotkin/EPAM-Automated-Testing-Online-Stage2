package EpamLearn;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Car implements Runnable {

  Semaphore parking;
  int waitingTime;
  Random random = new Random();

  public Car(Semaphore parking, int waitingTime) {
    this.parking = parking;
    this.waitingTime = waitingTime;
  }

  @Override
  public void run() {
    System.out.println("Машина " + Thread.currentThread().getName() + " приезжает на автостоянку.");
    try {
      boolean avaliable = this.parking.tryAcquire(1, waitingTime, TimeUnit.SECONDS);
      if (!avaliable) {
        System.out.println(
            "Машина " + Thread.currentThread().getName()
                + " не может больше ждать и уезжает на другую автостоянку.");
        return;
      }
      System.out.println("Машина " + Thread.currentThread().getName() + " паркуется.");
      int time = random.nextInt(12 * 1000);
      System.out.println(
          "Машина " + Thread.currentThread().getName() + " простоит на автостоянке " + time
              + " миллисекунд.");
      Thread.sleep(time);
      System.out
          .println("Машина " + Thread.currentThread().getName() + " освобождает место и уезжает.");
      this.parking.release();
    } catch (InterruptedException e) {
      System.err.println(e);
    }
  }
}
