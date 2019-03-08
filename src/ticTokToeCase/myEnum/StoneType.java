package ticTokToeCase.myEnum;

public enum StoneType {
  BLACK("O"), WHITE("X"), EMPTY(" ");

  private String content;

  StoneType(String content) {
    this.content = content;
  }

  public String getContent() {
    return content;
  }
}
