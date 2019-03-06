package ATMCase.transaction;

import ATMCase.Account;
import ATMCase.BankDatabase;
import ATMCase.CashDispenser;
import ATMCase.Keypad;
import ATMCase.Screen;
import ATMCase.transaction.Transaction;

public class Withdrawl extends Transaction {

  private  int amount;
  private Keypad keypad;
  private CashDispenser cashDispenser;

  private final int CANCELED = 0;
  public Withdrawl(Account account, Screen screen, BankDatabase bankDatabase,
      Keypad keypad, CashDispenser cashDispenser) {
    super(account, screen, bankDatabase);
    this.keypad = keypad;
    this.cashDispenser = cashDispenser;
  }


  @Override
  public void execute() {
    boolean cashDispensed = false;
    double availableBalance;
    BankDatabase bankDatabase = getBankDatabase();
    Screen screen = getScreen();
    Account account = getAccount();
    do{
      amount = displayMenuOfAmounts();
      if(amount != CANCELED){
        availableBalance = account.getAvailableBalance();
        if(amount <= availableBalance){
          if(cashDispenser.isSufficientCashAvailable(amount)){
            bankDatabase.debit(account.getAccountNumber(), amount);

            cashDispenser.dispenseCash(amount);
            cashDispensed = true;

            screen.displayMessageLine("Your cash has been dispensed");
          }else{
            screen.displayMessageLine("\nInsufficient cash available in the ATM.");
            screen.displayMessageLine("\nPlease choose a smaller amount");
          }
        }else{
          screen.displayMessageLine("\nBalance is insufficient");
        }
      }else{
        screen.displayMessageLine("\nCanceling");
        return;
      }
    }while(!cashDispensed);
  }

  private int displayMenuOfAmounts() {
    int userChoice = 0;
    Screen screen = getScreen();
    int[] amounts = {0, 20, 50, 100};
    while(userChoice == 0){
      screen.displayMessageLine("\nWithdrawal Menu:");
      screen.displayMessageLine("1 - $20");
      screen.displayMessageLine("2 - $50");
      screen.displayMessageLine("3 - $100");
      screen.displayMessageLine("4 - Cancel");
    }

    int input = keypad.getInput();
    switch (input){
      case 1:
      case 2:
      case 3:
        userChoice = amounts[input];
        break;
      case 4:
        userChoice = CANCELED;
        default:
          screen.displayMessageLine("ERROR, Try again");
    }
    return userChoice;
  }


}
