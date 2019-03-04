package chapter3;

public class DogDoorSimulator {
  public static void main(String[] args) {
    DogDoor door = new DogDoor();

    BarkRecognizer barkRecognizer = new BarkRecognizer(door);

    System.out.println("Fido barks to go outside...");
    barkRecognizer.recognize("Woof");
    System.out.println("Fido has goone outside...");
    System.out.println("Fido's all done...");
    try {
      Thread.currentThread().sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("Fido barks to go inside...");
    barkRecognizer.recognize("Woof");
    System.out.println("Fido's back inside...");
//    remote.pressButton();

  }
}
