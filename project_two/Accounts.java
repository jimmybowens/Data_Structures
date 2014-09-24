package project_two;

public class Accounts {
  protected String accountName, accountPhone, accountSSN, accountType;
  protected int accountNumber;
  protected double accountBalance;
  public Accounts(String accountName, int accountNumber, String accountPhone, String accountSSN, double accountBalance,
  String accountType){
    this.accountName = accountName;
    this.accountNumber = accountNumber;
    this.accountPhone = accountPhone;
    this.accountSSN = accountSSN;
    this.accountBalance = accountBalance;
    this.accountType = accountType;
  }
  
  public String getAccountName(){
    return this.accountName;
  }
  public int getAccountNumber(){
    return this.accountNumber;
  }
  public String getAccountPhone(){
    return this.accountPhone;
  }
  public String getAccountSSN(){
    return this.accountSSN;
  }
  public double getAccountBalance(){
    return this.accountBalance;
  }
  public String getAccountType(){
    return this.accountType;
  }

}
