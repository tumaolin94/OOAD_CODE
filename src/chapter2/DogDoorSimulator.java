package chapter2;

import java.util.Timer;
import java.util.TimerTask;

public class DogDoorSimulator {
  public static void main(String[] args) {
    DogDoor door = new DogDoor();
    Remote remote = new Remote(door);

    System.out.println("Fido barks to go outside...");
    remote.pressButton();
    System.out.println("Fido has goone outside...");
//    remote.pressButton();
    System.out.println("Fido's all done...");
//    remote.pressButton();
    try {
      Thread.currentThread().sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("Fido barks to go inside...");
    remote.pressButton();
    System.out.println("Fido's back inside...");
//    remote.pressButton();

  }
}
