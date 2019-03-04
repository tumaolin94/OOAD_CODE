package chapter4;

import java.util.Objects;

public class Bark {
  private String sound;

  public Bark(String sound) {
    this.sound = sound;
  }

  public String getSound() {
    return sound;
  }

  @Override
  public boolean equals(Object o) {
    if(o instanceof Bark){
      Bark otherbark = (Bark)o;
      if(this.sound.equalsIgnoreCase(otherbark.sound)){
        return true;
      }
    }

    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(sound);
  }
}
