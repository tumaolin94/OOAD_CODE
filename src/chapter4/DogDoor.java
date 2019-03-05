package chapter4;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class DogDoor {
  private boolean open;
  private List<Bark> allowedBarks;


  public DogDoor() {
    this.open = false;
    this.allowedBarks = new ArrayList<>();
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

  public List<Bark> getAllowedBarks() {
    return allowedBarks;
  }

  public void addAllowedBarkk(Bark bark) {
    this.allowedBarks.add(bark);
  }
}
