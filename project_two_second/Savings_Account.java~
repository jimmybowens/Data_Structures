package project_two_second;

import java.util.*;

public class Savings_Account extends Account{
  public Savings_Account(String accountName, int accountNumber, String accountPhone, String accountSSN, double accountBalance,
  String accountType){
    super(accountName,accountNumber,accountPhone,accountSSN,accountBalance,accountType);
    //deposit(800);
    //withdraw(400);
    //deposit(700);
    //deposit(600);
    //deposit(800);
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
  
  /* public ArrayList getDepositArray(){
    return depositArray;
  }
  public ArrayList getWithdrawalArray(){
    return withdrawalArray;
  }*/
}