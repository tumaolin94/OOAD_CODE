package battleShip;

public class Grid {

  private boolean isShip;
  private boolean isHitted;

  public Grid() {
    isShip = false;
    isHitted = false;
  }

  public boolean isShip() {
    return isShip;
  }

  public void setShip(boolean ship) {
    isShip = ship;
  }

  public boolean isHitted() {
    return isHitted;
  }

  public void setHitted(boolean hitted) {
    isHitted = hitted;
  }

}
