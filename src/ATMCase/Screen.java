package ATMCase;

public class Screen {


  public void displayMessageLine(String s) {
    System.out.println(s);
  }

  public void displayDollarAmount(double amount){
    System.out.printf("$%,.2f", amount);
  }
}
