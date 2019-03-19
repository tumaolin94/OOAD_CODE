package LibraryCase;

import LibraryCase.myEnum.AccountStatus;

public abstract class Account {
  private String id;
  private String password;
  private AccountStatus status;
  private Person person;


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public AccountStatus getStatus() {
    return status;
  }

  public void setStatus(AccountStatus status) {
    this.status = status;
  }

  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

  public boolean resetPassword(String oldPassword, String newPassword){
    if(!oldPassword.equals(this.password)){
      return false;
    }else{
      this.password = newPassword;
      return true;
    }
  }


}
