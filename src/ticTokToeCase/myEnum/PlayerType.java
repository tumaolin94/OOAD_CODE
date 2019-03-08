package ticTokToeCase.myEnum;

public enum PlayerType {
  BLACK(1), WHITE(-1);

  private int value;

  PlayerType(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  @Override
  public String toString() {
    switch (this){
      case BLACK: return "Black";
      case WHITE: return "White";
      default: return "";
    }
  }
}
