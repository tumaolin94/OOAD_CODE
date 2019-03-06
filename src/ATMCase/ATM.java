package ATMCase;

import ATMCase.transaction.BalanceInquiry;
import ATMCase.transaction.Deposit;
import ATMCase.transaction.Transaction;
import ATMCase.transaction.Withdrawl;

public class ATM {
  private boolean userAuthenticated;
  private int currentAccountNumber;
  private Keypad keypad;
  private Screen screen;
  private DepositSlot depositSlot;
  private CashDispenser cashDispenser;
  private BankDatabase bankDatabase;
  private CardReader cardReader;

  public ATM(BankDatabase bankDatabase) {
    userAuthenticated = false;
    currentAccountNumber = 0;
    screen = new Screen();
    keypad = new Keypad();
    cashDispenser = new CashDispenser();
    depositSlot = new DepositSlot();
    this.bankDatabase = bankDatabase;
    cardReader = new CardReader();
  }

  public void run(){
    while(true){
      while(!userAuthenticated){
        screen.displayMessageLine("\n Welcome!");
        authenticateUser();
      }
      Account currentAccount = bankDatabase.getAccount(currentAccountNumber);
      performTransactions(currentAccount);
      userAuthenticated = false;
      currentAccountNumber = 0;
      screen.displayMessageLine("\nThanks for your time! Goodbye!");
    }
  }

  private void performTransactions(Account account) {
    Transaction currentTransaction = null;
    boolean userExited = false;
    while(!userExited){
      TransactionType mainMenuSelection = displayMainMenu();
      switch (mainMenuSelection){
        case BALANCE_INQUIRY:
        case WITHDRAWAL:
        case DEPOSIT:
          currentTransaction = createTransaction(account, mainMenuSelection);
          currentTransaction.execute();
          break;
        case EXIT:
          screen.displayMessageLine("\nExiting the system...");
          userExited = true;
          break;
        default:
            screen.displayMessageLine("\n Try again");
            break;
      }
    }
  }

  private Transaction createTransaction(Account currentAccount, TransactionType mainMenuSelection) {
    Transaction tmp = null;
    switch (mainMenuSelection){
      case BALANCE_INQUIRY:
        tmp = new BalanceInquiry(currentAccount, screen, bankDatabase);
        break;
      case WITHDRAWAL:
        tmp = new Withdrawl(currentAccount, screen, bankDatabase, keypad, cashDispenser);
        break;
      case DEPOSIT:
        tmp = new Deposit(currentAccount, screen, bankDatabase, keypad, depositSlot);
        break;

    }
    return tmp;
  }

  private TransactionType displayMainMenu() {
    screen.displayMessageLine("\nMain menu:");
    screen.displayMessageLine("1- view balance:");
    screen.displayMessageLine("2- Withdraw cash:");
    screen.displayMessageLine("3- Deposit funds:");
    screen.displayMessageLine("4- Exits:");
    int index = keypad.getInput();
    return TransactionType.getOperation(index);
  }

  private void authenticateUser() {
    screen.displayMessageLine("\nPlease insert your card!");
    int accountNumber = cardReader.getCardNumber();
    screen.displayMessageLine("\nPlease input your PIN!");
    int pin = keypad.getInput();

    userAuthenticated = bankDatabase.authenticateUser(accountNumber, pin);

    if(userAuthenticated){
      currentAccountNumber = accountNumber;
    }else{
      screen.displayMessageLine("\nInvalid Card or PIN. Please try again!");
    }
  }
}
