package chapter2;

import java.util.Timer;
import java.util.TimerTask;

public class DogDoorSimulator {
  public static void main(String[] args){
    DogDoor door = new DogDoor();
    Remote remote = new Remote(door);

    System.out.println("Fido barks to go outside...");
    remote.pressButton();
    System.out.println("Fido has goone outside...");
//    remote.pressButton();
    System.out.println("Fido's all done...");
//    remote.pressButton();
    System.out.println("Fido's back inside...");
//    remote.pressButton();

    final Timer timer = new Timer();
    timer.schedule(new TimerTask() {
      @Override
      public void run() {
        remote.pressButton();
        timer.cancel();
      }
    },5000);
  }
}
