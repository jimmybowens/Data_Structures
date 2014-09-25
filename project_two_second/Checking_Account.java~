package project_two_second;
public class Checking_Account extends Account{
  public Checking_Account(String accountName, int accountNumber, String accountPhone, String accountSSN, double accountBalance,
  String accountType){
    super(accountName,accountNumber,accountPhone,accountSSN,accountBalance,accountType);
  }
  public double generateEndingBalance(){
    this.interestRate = 0.025;
    closingBalance = accountBalance + (accountBalance * interestRate);
    return closingBalance;
  }
}