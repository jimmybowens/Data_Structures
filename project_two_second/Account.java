/*
 *
 * Jimmy Bowens
 * COSC Advanced Data Structures
 * Professor H. Zhou
 * Date: September 27, 2014
 * 
 * The purpose of this project is to fullfill the requirements of Project #2. The project description is below
 * 
 * 
 * Project  2  COSC 600       
 * 
 * by Prof. H. Zhou  
 * 
 * Due:  9/29//2014  
 * 
 * You are to create a set of classes to implement a banking mode in Java, and are expected to employ the techniques of inheritance and polymorphism.  
 * A bank has account owners, each of them may have one or more bank accounts, such as savings accounts, checking accounts, and business accounts. 
 * Each account has the following information stored as private data: such as name,  account_number, and balance.  
 * At the end of each month, the bank issues a statement for each bank account containing the following information: name, SSN, account_number, phone_number, open balance, and close balance. 
 * The close balance is the open balance plus the interest calculated based on the type of the account. To simplify your task, you can assume that there was no transaction in the past month.
 * 
 * With a polymorphic method, the interest of each account is calculated differently: 
 * 1. No interest for business accounts 
 * 2. 2.5% interest for each checking account 
 * 3. 4% for each saving account if the balance  < $5000 5% otherwise  
 * 
 * You may need to create the following classes: accounts, business_accounts, checking_accounts, savings_accounts, and the driver class.  
 * 
 * Read the following data from a file and use it  to test your program:  
 * 
 * NAME     ACCOUNT PHONE     SSN   BALANCE  TYPE  
 * 
 * Sam     78192222  555-0498 123-45-6789       4500               B 
 * Carla    74329832  555-9812 233-98-3831     230                 C 
 * Woody    72872911  555-9281 823-23-0911     5700               S 
 * Diane    63672822  555-9232 212-11-0091     2300               S 
 * Norm    27873773  555-2932 918-22-0911     1400               C 
 * Cliff    38737737  555-9171 811-12-9811     6700               S 
 * Tom        72932331                 555-9283         235-09-9282       7800               C  
 * 
 * Submit your program along with the output produced 
 
 */

package project_two_second;

import java.util.*;

public class Account{
  double interestRate = 0; // default interest rate for all acounts if not overidden by sub accounts                                                                                           
  double closingBalance = 0; //default closing balance a the start of the application
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
  
  public void deposit(double depositedAmount){ //call to make deposits to each account
    depositArray.add(depositedAmount);
    System.out.println("Deposit of "+depositedAmount+ " made to "+getAccountName()+"'s "+getAccountType()+" account with account number "+getAccountNumber());
  }
  public void withdraw(double withdrawnAmount){ //call to make withdrawals from each account
    withdrawalArray.add(withdrawnAmount);
    System.out.println("Withdrawal of "+withdrawnAmount+ " withdrawn from "+getAccountName()+"'s "+getAccountType()+" account with account number "+getAccountNumber());
  }
  public void setInterestRate(double interestRate){ //set interest rate for each account. It will set the default interest rate if not overridden by each sub account
    this.interestRate = interestRate;
  }
  
  public double generateEndingBalance(){ //this method is called to generate the final closing balance after accounting for deposits and withdrawals, and generate the closing balance based on interest rate
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
    return closingBalance;//return the final closing balance for each account if not overidden by each account
  }  
}