package ATMCase;

public class ATMTest {
  public static void main(String[] args){
    BankDatabase database = new BankDatabase();
    initializeDB(database);
    ATM theATM = new ATM(database);
    theATM.run();
  }

  private static void initializeDB(BankDatabase database) {
    Account account = new Account(1,123456, 100.0, 100.0);
    database.addAccount(account);
  }


}
