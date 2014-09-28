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

import java.io.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

public class Driver {
  ArrayList<Account> accountsDatabase = new ArrayList<Account>(); //contains the database of all objects for all accounts created
  ArrayList <String> stringHolder = new ArrayList<String>();
  ArrayList <Integer> intHolder = new ArrayList<Integer>();
  ArrayList <String> tempAccountName = new ArrayList<String>();
  ArrayList <Integer> tempAccountNumber = new ArrayList<Integer>();
  ArrayList <String> tempAccountPhone = new ArrayList<String>();
  ArrayList <String> tempAccountSSN = new ArrayList<String>();
  ArrayList <Double> tempAccountBalance = new ArrayList<Double>();
  ArrayList <String> tempAccountType = new ArrayList<String>();
     
 public Driver()throws IOException{
   start(); //calls all the related method for this class in succession
 }
 
 public void readFile() throws IOException{//read the file from which the accounts are to be created from
     Scanner getInput = null;
     try{
       getInput = new Scanner( new File(System.getProperty("user.home")+File.separator+"Desktop"+File.separator+"accounts data.txt")); // read file from desktop
       getInput.nextLine();
     }catch(IOException i){
       System.out.println(i);//prints error if any
     }
     
     while(getInput.hasNext()){
       if(getInput.hasNextInt()){
         intHolder.add(Integer.parseInt(getInput.next()));
       }
       else{
         stringHolder.add(getInput.next());
       }
     }
     getInput.close();
   }
 
 public void sortTokens(){//this method is responsible for sorting the tokens after they have been read into the program
   //sort string tokens
   for(int i=0; i < stringHolder.size(); i++){
     if(stringHolder.get(i).matches("[A-Z][a-z]+( [A-Z][a-z]+)?")){
       tempAccountName.add(stringHolder.get(i));
     }
     else if(stringHolder.get(i).matches("\\d{3}-\\d{4}")){
       tempAccountPhone.add(stringHolder.get(i));
     }
     else if(stringHolder.get(i).matches("\\d{3}-\\d{2}-\\d{4}")){
       tempAccountSSN.add(stringHolder.get(i));
     }
     else if(stringHolder.get(i).matches("[A-Za-z]")){
       tempAccountType.add(stringHolder.get(i));
     }
   }
   //sort int tokens
   for(int i=0; i < intHolder.size(); i ++){
     if(Integer.toString(intHolder.get(i)).matches("\\d{8}")){
       tempAccountNumber.add(intHolder.get(i));
     }
     else{
       tempAccountBalance.add((double)intHolder.get(i));
     }
   }
 }
 
 //create accounts objects
 public void createAccounts(){
   for(int i=0; i < tempAccountName.size();i++){//This method is responsible for creating all the accounts of various types
     if(tempAccountType.get(i).equals("B")){
       accountsDatabase.add(new Business_Account(tempAccountName.get(i),tempAccountNumber.get(i),tempAccountPhone.get(i),tempAccountSSN.get(i),tempAccountBalance.get(i),tempAccountType.get(i)));
     }
     if(tempAccountType.get(i).equals("C")){
       accountsDatabase.add(new Checking_Account(tempAccountName.get(i),tempAccountNumber.get(i),tempAccountPhone.get(i),tempAccountSSN.get(i),tempAccountBalance.get(i),tempAccountType.get(i)));
     }
     if(tempAccountType.get(i).equals("S")){
       accountsDatabase.add(new Savings_Account(tempAccountName.get(i),tempAccountNumber.get(i),tempAccountPhone.get(i),tempAccountSSN.get(i),tempAccountBalance.get(i),tempAccountType.get(i)));
     }
   }
 }
 //generate bank statements
 public void generateStatements(){//This method is responsible for generating the final bankstatement for each account
   String filePath = null;
    PrintWriter writeData = null; //declare file object
    try{
      filePath = System.getProperty("user.home")+File.separator+"Desktop"+File.separator+"Account Statements.txt"; //get new file path
      writeData = new PrintWriter(filePath, "utf-8"); //open new file for writing student data
    }catch(IOException i){
      System.out.println(i); //print error message is something is wrong with opening the new file for writing data
    }
    for(int i=0; i < accountsDatabase.size(); i++){
      Calendar calendar = new GregorianCalendar();
      Date date = calendar.getTime();
      writeData.println("");
      writeData.println("");
      writeData.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------");
      writeData.println("Towson Community Bank");
      writeData.println("8000 York Rd, Towson, MD 21252");
      writeData.println("(410) 704-2000");
      writeData.println("");
      writeData.println("");
      writeData.println("ATTN: "+accountsDatabase.get(i).getAccountName()+ "                                                                                                             SSN: "+accountsDatabase.get(i).getAccountSSN());
      writeData.println("[ADDRESS ON FILE                                                                                 "+"Type: "+accountsDatabase.get(i).getAccountType()+"            ACCOUNT NUMBER: "+accountsDatabase.get(i).getAccountNumber());
      writeData.println("Phone: "+accountsDatabase.get(i).getAccountPhone());
      writeData.println("                                            IMPORTANT NOTICE: Statement Ending September 15, 2014                               ");
      writeData.println("TRANSACTION SUMMARY:");
      writeData.println("");
      writeData.println("POSTING DATE                                   DEBITS              CREDITS              OPEN BALANCE             CLOSING BALANCE           INTEREST RATE");
      writeData.println(date+"                     "+accountsDatabase.get(i).getAccountDebits()+"                "+accountsDatabase.get(i).getAccountCredits()+"                 "+accountsDatabase.get(i).getAccountOpeningBalance()+"                   "+accountsDatabase.get(i).generateEndingBalance()+ "                     "+accountsDatabase.get(i).getAccountInterestRate());
      for(double a : accountsDatabase.get(i).depositArray){
        writeData.println(date+"                                        "+a+" (C)");
      }
      for(double a : accountsDatabase.get(i).withdrawalArray){
        System.out.println("HERE: "+a);
        writeData.println(date+"                   "+a+" (W)");
      } 
    }
    System.out.println("Data successfully written to file 'accounts data.txt' on Desktop");
    writeData.close();
 }
 //test data
  public void testAccounts(){
    //TEST CASES FOR EACH TYPE OF ACCOUNTS
    System.out.println("Printing test data for each types of account...");
    Account biz = new Business_Account("John", 7765353,"746-3445","343-33-3323",100,"B");
    System.out.println("Balance: "+biz.generateEndingBalance());
    System.out.println("Current interest rate: "+biz.getAccountInterestRate());
    biz.deposit(200);
    System.out.println("Balance: "+biz.generateEndingBalance());
    biz.withdraw(200);
    System.out.println("Balance: "+biz.generateEndingBalance());
    System.out.println("------------------------------------------------------");
    Account savings = new Savings_Account("John", 7765353,"746-3445","343-33-3323",100,"S");
    System.out.println("Balance: "+savings.generateEndingBalance());
    System.out.println("Current interest rate: "+savings.getAccountInterestRate());
    savings.deposit(200);
    System.out.println("Balance: "+savings.generateEndingBalance());
    System.out.println("Current interest rate: "+savings.getAccountInterestRate());
    savings.withdraw(200);
    System.out.println("Balance: "+savings.generateEndingBalance());
    System.out.println("Current interest rate: "+savings.getAccountInterestRate());
    savings.deposit(7000);
    System.out.println("Balance: "+savings.generateEndingBalance());
    System.out.println("Current interest rate: "+savings.getAccountInterestRate());
    System.out.println("------------------------------------------------------");
    Account checking = new Checking_Account("John", 7765353,"746-3445","343-33-3323",100,"C");
    System.out.println("Balance: "+checking.generateEndingBalance());
    System.out.println("Current interest rate: "+checking.getAccountInterestRate());
    checking.deposit(200);
    System.out.println("Balance: "+checking.generateEndingBalance());
    System.out.println("Current interest rate: "+checking.getAccountInterestRate());
    checking.withdraw(200);
    System.out.println("Balance: "+checking.generateEndingBalance());
    System.out.println("Current interest rate: "+checking.getAccountInterestRate());
    }
 public void start() throws IOException{
   readFile(); //read the file
   sortTokens(); //sort the tokens
   createAccounts(); //create the accounts
   generateStatements(); //generate all the statements for all the customers of all accounts
   testAccounts(); // run test cases independenly tpo simulate deposits and withdrawals, and to show the change in interest rate for savings based on balance levels
 }
  public static void main(String [] args) throws IOException{
    new Driver(); //start the program by a single call without instantiating
  }
}