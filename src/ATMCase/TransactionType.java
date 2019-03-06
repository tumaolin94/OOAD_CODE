package ATMCase;

public enum TransactionType {
  BALANCE_INQUIRY, WITHDRAWAL, DEPOSIT, EXIT, ERROR;

  public static TransactionType getOperation(int i){
    switch (i){
      case 1: return BALANCE_INQUIRY;
      case 2: return WITHDRAWAL;
      case 3: return DEPOSIT;
      case 4: return EXIT;
      default: return ERROR;
    }
  }
}
