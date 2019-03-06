package ATMCase.transaction;

import ATMCase.Account;
import ATMCase.BankDatabase;
import ATMCase.DepositSlot;
import ATMCase.Keypad;
import ATMCase.Screen;
import ATMCase.transaction.Transaction;

public class Deposit extends Transaction {

 private double amount;
 private Keypad keypad;
 private DepositSlot depositSlot;
 private final static int CANCELED = 0;

  public Deposit(Account account, Screen screen, BankDatabase bankDatabase,
      Keypad keypad, DepositSlot depositSlot) {
    super(account, screen, bankDatabase);
    this.keypad = keypad;
    this.depositSlot = depositSlot;
  }


  @Override
  public void execute() {
    BankDatabase bankDatabase = getBankDatabase();
    Screen screen = getScreen();

    amount = promptForDepositAmount();

    if(amount != CANCELED){
      screen.displayMessageLine("Please insert a deposit envelope contianing");
      screen.displayDollarAmount(amount);
      screen.displayMessageLine(".");

      boolean envelopReceived = depositSlot.isEnvelopeReceived();
      if(envelopReceived){
        screen.displayMessageLine("Received");
        bankDatabase.credit(getAccount().getAccountNumber(), amount);
      }else{
        screen.displayMessageLine("Not Received");
      }
    }else {
      screen.displayMessageLine("Canceling");
    }
  }

  private double promptForDepositAmount() {
    Screen screen = getScreen();
    screen.displayMessageLine("Please enter a deposit amount");
    int input = keypad.getInput();
    if(input == CANCELED){
      return CANCELED;
    }else{
      return (double) input / 100;
    }
  }
}
