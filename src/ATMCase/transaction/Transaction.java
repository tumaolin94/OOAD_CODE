package ATMCase.transaction;

import ATMCase.Account;
import ATMCase.BankDatabase;
import ATMCase.Screen;

public abstract class Transaction {
  private Account account;
  private Screen screen;
  BankDatabase bankDatabase;

  public Transaction(Account account, Screen screen, BankDatabase bankDatabase) {
    this.account = account;
    this.screen = screen;
    this.bankDatabase = bankDatabase;
  }

  public Account getAccount() {
    return account;
  }

  public Screen getScreen() {
    return screen;
  }

  public BankDatabase getBankDatabase() {
    return bankDatabase;
  }

  public abstract void execute();
}
