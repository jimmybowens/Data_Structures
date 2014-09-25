package project_two_second;

public class Savings_Account extends Account{
  public Savings_Account(String accountName, int accountNumber, String accountPhone, String accountSSN, double accountBalance,
  String accountType){
    super(accountName,accountNumber,accountPhone,accountSSN,accountBalance,accountType);
  }
  public void setInterestRate(){
    if(closingBalance < 5000){
      this.interestRate = 0.04;
    }
    else{
      this.interestRate = 0.05;
    }
  }
  
  public double generateEndingBalance(){
    //decide interest rate for savings
    setInterestRate();
    //check if any deposits or withdrawals made
    double totalTransactions = 0;
    for(int i=0; i < depositArray.size();i++){
      totalTransactions = totalTransactions + depositArray.get(i);
    }
    for(int i=0; i < withdrawalArray.size();i++){
      totalTransactions = totalTransactions - withdrawalArray.get(i);
    }
    setInterestRate();
    closingBalance = accountOpeningBalance + totalTransactions;
    closingBalance = closingBalance +(closingBalance * interestRate);
    setInterestRate();
    return closingBalance;
  }
}