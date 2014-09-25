package project_two_second;

import java.io.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;


public class Driver {
  ArrayList<Account> accountsDatabase = new ArrayList<Account>();
  ArrayList <String> stringHolder = new ArrayList<String>();
  ArrayList <Integer> intHolder = new ArrayList<Integer>();
  
  ArrayList <String> tempAccountName = new ArrayList<String>();
  ArrayList <Integer> tempAccountNumber = new ArrayList<Integer>();
  ArrayList <String> tempAccountPhone = new ArrayList<String>();
  ArrayList <String> tempAccountSSN = new ArrayList<String>();
  ArrayList <Double> tempAccountBalance = new ArrayList<Double>();
  ArrayList <String> tempAccountType = new ArrayList<String>();
     
 public Driver()throws IOException{
   start(); 
 }
 
 public void readFile() throws IOException{
     Scanner getInput = null;
     try{
       getInput = new Scanner( new File(System.getProperty("user.home")+File.separator+"Desktop"+File.separator+"accounts data.txt")); // read file from desktop
       getInput.nextLine();
     }catch(IOException i){
       System.out.println(i);
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
 
 public void sortTokens(){
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
   for(int i=0; i < tempAccountName.size();i++){
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
 
 public void generateRandomDepositsWithdrawals(int accountNumber){
   Random randomizer = new Random();
   for(int i = 0; i < accountsDatabase.size(); i ++){
     if(accountNumber == accountsDatabase.get(i).getAccountNumber()){
       int decideDepositOrWithdrawal = randomizer.nextInt(2);
       System.out.println(decideDepositOrWithdrawal);
     }
   }
 }
 
/* public void testArray(){
   for(int i= 0; i < accountsDatabase.size(); i++){
     System.out.println(accountsDatabase.get(i).getAccountName() + "  "+ accountsDatabase.get(i).getAccountNumber() + "  " +accountsDatabase.get(i).getAccountSSN()+"  "+accountsDatabase.get(i).getAccountSSN()+ "  "+accountsDatabase.get(i).getAccountBalance()+ "  "+accountsDatabase.get(i).getAccountType());
     System.out.println(accountsDatabase.get(i).generateEndingBalance());
   }
 }*/
 
 //generate bank statements
 public void generateStatements(){
   String filePath = null;
    PrintWriter writeData = null; //declare file object
    try{
      filePath = System.getProperty("user.home")+File.separator+"Desktop"+File.separator+"Account Statements.txt"; //get new file path
      writeData = new PrintWriter(filePath, "utf-8"); //open new file for writing student data
    }catch(IOException i){
      System.out.println(i); //print error message is something is wrong with opening the new file for writing data
    }
    
    for(int i=0; i < accountsDatabase.size(); i++){
      generateRandomDepositsWithdrawals(accountsDatabase.get(i).getAccountNumber());
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
      writeData.println("[ADDRESS ON FILE                                                                                                       ACCOUNT NUMBER: "+accountsDatabase.get(i).getAccountNumber());
      writeData.println("Phone: "+accountsDatabase.get(i).getAccountPhone());
      writeData.println("                                            IMPORTANT NOTICE: Statement Ending September 15, 2014                               ");
      writeData.println("TRANSACTION SUMMARY:");
      writeData.println("");
      writeData.println("POSTING DATE                                   DEBITS              CREDITS              OPEN BALANCE             CLOSING BALANCE           INTEREST RATE");
      writeData.println(date+"                     "+accountsDatabase.get(i).getAccountDebits()+"                "+accountsDatabase.get(i).getAccountCredits()+"                 "+accountsDatabase.get(i).getAccountOpeningBalance()+"                   "+accountsDatabase.get(i).generateEndingBalance()+ "                     "+accountsDatabase.get(i).getAccountInterestRate());
      /*for(int m=0; m <accountsDatabase.get(i).getDepositArray().size();m++){
        writeData.println(date+"                                        "+accountsDatabase.get(m).getDepositArray().get(m)+" (C)");
      }
      for(int m=0; m <accountsDatabase.get(i).getWithdrawalArray().size();m++){
        writeData.println(date+"                   "+accountsDatabase.get(m).getWithdrawalArray().get(m)+" (W)");
      }*/
      
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
 
 public void start() throws IOException{
   readFile();
   sortTokens();
   createAccounts();
   generateStatements();
 }
 
 public void askForUserInput()throws IOException{
   Scanner getInput = new Scanner(System.in);
   boolean stop = false;
   boolean isDeposit = false;
   boolean isWidthdrawal = false;
   boolean isValidEntry = false;
   boolean gotAccountNumber = false;
   boolean madeDeposit = false;
   System.out.println("Welcome to Towson Community Bank. What would you like to do today? Enter D for deposit, W for withdrawal, or T to run test cases.");
   while(stop==false){
     //getInput.next();
     while(!isValidEntry){
       System.out.println("Please enter D for deposit, W for withdrawal, or T to run test cases.");
       if(getInput.next().equalsIgnoreCase("D")){
         isValidEntry = true;
         isDeposit = true;
       }
     }//end check
     
     while(!gotAccountNumber && isDeposit){
       //if(getInput.hasNextDouble()){
         //System.out.println("Please enter a valid account number");
       double token = 0;
         try{
           System.out.println("Please enter a valid account number");
           token = getInput.nextDouble();
         
         for(int i=0; i < accountsDatabase.size(); i++){
           int compareValue = Double.compare(token,accountsDatabase.get(i).getAccountNumber());
           if(compareValue == 0 ){
             gotAccountNumber = true;
           }
         }
         }catch(InputMismatchException i){
           System.out.println("The following error occured:"+ i+ ". System restarted...");
           askForUserInput();
         }
     }
     
     while(isDeposit && gotAccountNumber && !madeDeposit){
       System.out.println("Enter amount to deposit");
       double token = 0;
       try{
         token =getInput.nextDouble();
         if(token!=0){
           System.out.println(token + " will be deposited");
           madeDeposit = true;
         }
       }catch(InputMismatchException i){
         System.out.println("The following error occured:"+ i+ ". System restarted...");
         askForUserInput();
       }
     }
     
   }
     
   
 }
 
  public static void main(String [] args) throws IOException{
    new Driver();
    //Driver init = new Driver();
    //init.start();
    //init.askForUserInput();
    /*
    //TEST CASES FOR EACH ACCOUNT
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
    */
  }
}