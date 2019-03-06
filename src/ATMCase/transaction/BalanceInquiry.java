package ATMCase.transaction;

import ATMCase.Account;
import ATMCase.BankDatabase;
import ATMCase.Screen;
import ATMCase.transaction.Transaction;

public class BalanceInquiry extends Transaction {


  public BalanceInquiry(Account account, Screen screen, BankDatabase bankDatabase) {
    super(account, screen, bankDatabase);
  }


  @Override
  public void execute() {
    BankDatabase bankDatabase = getBankDatabase();
    Screen screen = getScreen();
    Account account = getAccount();
    double availableBalance = account.getAvailableBalance();
    double totalBalance = account.getTotalBalance();

    screen.displayMessageLine("Balance Information:");
    screen.displayMessageLine(" - Available balance: ");
    screen.displayDollarAmount(availableBalance);
    screen.displayMessageLine("\n - Total balance: ");
    screen.displayDollarAmount(totalBalance);
  }


}
