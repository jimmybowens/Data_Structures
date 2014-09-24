package project_two_second;

public class Savings_Account extends Account{
  public Savings_Account(String accountName, int accountNumber, String accountPhone, String accountSSN, double accountBalance,
  String accountType){
    super(accountName,accountNumber,accountPhone,accountSSN,accountBalance,accountType);
  }
  public double generateEndingBalance(){
    if(accountBalance < 5000){
      this.interestRate = 0.04;
    }else{
      this.interestRate = 0.05;
    }
    closingBalance = accountBalance + (accountBalance * interestRate);
    return closingBalance;
  }
}