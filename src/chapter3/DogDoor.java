package chapter3;

import java.util.Timer;
import java.util.TimerTask;

public class DogDoor {
  private boolean open;

  public DogDoor() {
    this.open = false;
  }

  public void open() {
    System.out.println("The dog door open.");
    this.open = true;

    final Timer timer = new Timer();
    timer.schedule(new TimerTask() {

      @Override
      public void run() {
        close();
        timer.cancel();
      }
    },2000);
  }

  public void close() {
    System.out.println("The dog door close.");
    this.open = false;
  }

  public boolean isOpen() {
    return open;
  }
}
