package project_two_second;

public class Business_Account extends Account{
  public Business_Account(String accountName, int accountNumber, String accountPhone, String accountSSN, double accountBalance,
  String accountType){
    super(accountName,accountNumber,accountPhone,accountSSN,accountBalance,accountType);
  }
  public double generateEndingBalance(){
    this.interestRate = 0;
    closingBalance = accountBalance + (accountBalance * interestRate);
    return closingBalance;
  }
  
}