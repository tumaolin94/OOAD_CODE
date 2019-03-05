package chapter5;

public enum Wood {
  INDIAN_ROSEWOOD, BRAZILIAN_ROSEWOOD;

  public String toString(){
    switch (this) {
      case INDIAN_ROSEWOOD: return "indian rosewood";
      case BRAZILIAN_ROSEWOOD: return "brazilian rosewood";
      default: return "";
    }
  }
}
