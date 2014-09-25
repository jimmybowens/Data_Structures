package project_two_second;

import java.util.*;

public class Business_Account extends Account{
  public Business_Account(String accountName, int accountNumber, String accountPhone, String accountSSN, double accountBalance,
  String accountType){
    super(accountName,accountNumber,accountPhone,accountSSN,accountBalance,accountType);
    setInterestRate(0);
    deposit(50);
    withdraw(60);
    deposit(80);
    //deposit(80);
    //withdraw(100);
    
  }
  
  /* public ArrayList getDepositArray(){
    return depositArray;
  }
  public ArrayList getWithdrawalArray(){
    return withdrawalArray;
  }*/
}