package project_two_second;

public class Business_Account extends Account{
  public Business_Account(String accountName, int accountNumber, String accountPhone, String accountSSN, double accountBalance,
  String accountType){
    super(accountName,accountNumber,accountPhone,accountSSN,accountBalance,accountType);
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