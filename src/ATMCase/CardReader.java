package ATMCase;

import java.util.Scanner;

public class CardReader {

  private Scanner input;
  public CardReader(){
    input = new Scanner(System.in);
  }

  public int getCardNumber(){
    return input.nextInt();
  }


}
