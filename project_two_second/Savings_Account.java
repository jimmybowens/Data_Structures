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

public class Savings_Account extends Account{
  public Savings_Account(String accountName, int accountNumber, String accountPhone, String accountSSN, double accountBalance,
  String accountType){
    super(accountName,accountNumber,accountPhone,accountSSN,accountBalance,accountType);
  }
  public void setInterestRate(){ //decide the interest rate for each savings account based on balance
    if(closingBalance < 5000){
      this.interestRate = 0.04;
    }
    else{
      this.interestRate = 0.05;
    }
  }
  
  public double generateEndingBalance(){ //override this method from the super class
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
    return closingBalance; //returns final closing balance
  }
}