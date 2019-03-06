package ATMCase;

import java.util.ArrayList;
import java.util.List;

public class BankDatabase {

  private List<Account> accounts;

  public BankDatabase(){
    accounts = new ArrayList<>();
  }

  public void addAccount(Account account){
    accounts.add(account);
  }


  public Account getAccount(int accountNumber){
    for(Account currentAccount: accounts){
      if(currentAccount.getAccountNumber() == accountNumber){
        return currentAccount;
      }
    }
    return null;
  }

  public boolean authenticateUser(int userAccountNumber, int userPIN){
    Account userAccount = getAccount(userAccountNumber);
    if(userAccount != null){
      return  userAccount.validatePIN(userPIN);
    }else{
      return false;
    }
  }



  public void credit(int userAccountNumber, double amount){
    getAccount(userAccountNumber).credit(amount);
  }

  public void debit(int userAccountNumber, double amount){
    getAccount(userAccountNumber).debit(amount);
  }

}
