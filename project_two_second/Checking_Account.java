package project_two_second;
import java.util.*;

public class Checking_Account extends Account{
  public Checking_Account(String accountName, int accountNumber, String accountPhone, String accountSSN, double accountBalance,
  String accountType){
    super(accountName,accountNumber,accountPhone,accountSSN,accountBalance,accountType);
    setInterestRate(0.025);
    //deposit(80);
    //withdraw(40);
    //withdraw(10);
    //withdraw(40);
    //deposit(800);
  }
  
  /* public ArrayList getDepositArray(){
    return depositArray;
  }
  public ArrayList getWithdrawalArray(){
    return withdrawalArray;
  }*/
}