package project_two;

public class Business_Accounts extends Accounts{
  //private double interestRate;
  private double endingBalance;
  public Business_Accounts(String accountName, int accountNumber, String accountPhone, String accountSSN, double accountBalance,
                           String accountType){
    super(accountName, accountNumber, accountPhone, accountSSN, accountBalance, accountType);
  }
  
  public double generateBalance(){
    return accountBalance;
  }
  
  
}
