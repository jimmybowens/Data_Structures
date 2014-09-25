package project_two_second;

import java.util.*;

public class Account{
  double interestRate = 0;
  double closingBalance = 0;
  protected String accountName, accountPhone, accountSSN, accountType;
  protected int accountNumber;
  protected double accountOpeningBalance;
  protected double accountBalance;
  protected double accountCredits = 0;
  protected double accountDebits = 0;
  protected ArrayList<Double> depositArray = new ArrayList<Double>();//record monies deposited
  protected ArrayList<Double> withdrawalArray = new ArrayList<Double>();//record monies withdrawn
  
  public Account(String accountName, int accountNumber, String accountPhone, String accountSSN, double accountBalance,
  String accountType){
    this.accountName = accountName;
    this.accountNumber = accountNumber;
    this.accountPhone = accountPhone;
    this.accountSSN = accountSSN;
    this.accountBalance = accountBalance;
    this.accountOpeningBalance = accountBalance;//set opening balance equal to the account balance when account was created
    this.accountCredits = accountBalance;//set account credit equals to account balance when account was created to generate first credit to account
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
  public double getAccountDebits(){
    return this.accountDebits;
  }
  public double getAccountCredits(){
    return this.accountCredits;
  }
  public double getAccountOpeningBalance(){
    return this.accountOpeningBalance;
  }
  public double getAccountInterestRate(){
    return interestRate;
  }
  
  public ArrayList getDepositArray(){
    return depositArray;
  }
  public ArrayList getWithdrawalArray(){
    return withdrawalArray;
  }
  
  public void deposit(double depositedAmount){
    depositArray.add(depositedAmount);
    System.out.println("Deposit of "+depositedAmount+ " made to "+getAccountName()+"'s "+getAccountType()+" account with account number "+getAccountNumber());
  }
  public void withdraw(double withdrawnAmount){
    withdrawalArray.add(withdrawnAmount);
    System.out.println("Withdrawal of "+withdrawnAmount+ " withdrawn from "+getAccountName()+"'s "+getAccountType()+" account with account number "+getAccountNumber());
  }
  public void setInterestRate(double interestRate){
    this.interestRate = interestRate;
  }
  
  public double generateEndingBalance(){
    //check if any deposits or withdrawals made
    double totalTransactions = 0;
    for(int i=0; i < depositArray.size();i++){
      totalTransactions = totalTransactions + depositArray.get(i);
    }
    for(int i=0; i < withdrawalArray.size();i++){
      totalTransactions = totalTransactions - withdrawalArray.get(i);
    }
    
    closingBalance = accountOpeningBalance + totalTransactions;
    closingBalance = closingBalance +(closingBalance * interestRate);
    return closingBalance;
  }
  
  
}