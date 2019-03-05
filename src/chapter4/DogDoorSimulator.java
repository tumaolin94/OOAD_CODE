package chapter4;

public class DogDoorSimulator {
  public static void main(String[] args) {
    DogDoor door = new DogDoor();

    door.addAllowedBarkk(new Bark("rowlf"));
    door.addAllowedBarkk(new Bark("rooowlf"));
    door.addAllowedBarkk(new Bark("rawlf"));
    door.addAllowedBarkk(new Bark("woof"));


    BarkRecognizer barkRecognizer = new BarkRecognizer(door);

    System.out.println("Bruce barks to go outside...");
    barkRecognizer.recognize(new Bark("rowlf"));
    System.out.println("\nBruce has goone outside...");

    try {
      Thread.currentThread().sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("\nBruce's all done...");

    //Simulate another dog's bark
    Bark smallDogBark = new Bark("yip");
    System.out.println("A small dog starts barking.");
    barkRecognizer.recognize(smallDogBark);

    try {
      Thread.currentThread().sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("\nBruce barks to go inside...");
    barkRecognizer.recognize(new Bark("rooowlf"));
    System.out.println("\nFido's back inside...");
//    remote.pressButton();

  }
}
