package battleShip;

public class Ship {

  String name;
  int length;

  public Ship(String name, int length) {
    this.name = name;
    this.length = length;
  }

  public int getLength() {
    return length;
  }

  public void setLength(int length) {
    this.length = length;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
