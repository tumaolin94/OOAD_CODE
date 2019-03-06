package ATMCase;

public class Account {

  private int accountNumber;
  private int pin;
  private double availableBalance;
  private double totalBalance;

  public Account(int accountNumber, int pin, double availableBalance, double totalBalance) {
    this.accountNumber = accountNumber;
    this.pin = pin;
    this.availableBalance = availableBalance;
    this.totalBalance = totalBalance;
  }

  public boolean validatePIN(int userPIN){
    return userPIN == pin;
  }

  public void credit(double amount){
    totalBalance += amount;
  }

  public void debit(double amount){
    availableBalance -= amount;
    totalBalance -= amount;

  }

  public int getAccountNumber() {
    return accountNumber;
  }

  public int getPin() {
    return pin;
  }

  public double getAvailableBalance() {
    return availableBalance;
  }

  public double getTotalBalance() {
    return totalBalance;
  }
}
