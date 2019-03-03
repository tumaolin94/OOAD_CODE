package chapter2;

public class DogDoor {
  private boolean open;

  public DogDoor() {
    this.open = false;
  }

  public void open() {
    System.out.println("The dog door open.");
    this.open = true;
  }

  public void close() {
    System.out.println("The dog door close.");
    this.open = false;
  }

  public boolean isOpen() {
    return open;
  }
}
