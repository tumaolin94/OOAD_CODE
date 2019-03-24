package battleShip;

public enum Direction {
  UP(0, -1), DOWN(0, 1), LEFT(-1, 0), RIGHT(1, 0);

  int x;
  int y;

  Direction(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public static Direction getDirection(int choice){
    switch (choice){
      case 0: return UP;
      case 1: return DOWN;
      case 2: return LEFT;
      case 3: return RIGHT;
      default: return null;
    }
  }
}
