package ticTokToeCase.myEnum;

public enum GameType {
  ACTIVE(false), TIE(true), BLACK_WIN(true), WHITE_WIN(true);

  private boolean isOver;

  GameType(boolean isOver) {
    this.isOver = isOver;
  }

  public boolean isOver() {
    return isOver;
  }

  @Override
  public String toString() {
    switch (this){
      case TIE: return "Tie";
      case ACTIVE: return "Still Active";
      case BLACK_WIN: return "Black Win";
      case WHITE_WIN: return "White Win";
      default: return "";
    }
  }
}
