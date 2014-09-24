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
     
 public Driver(){}
 
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
 
 public void testArray(){
   for(int i= 0; i < accountsDatabase.size(); i++){
     System.out.println(accountsDatabase.get(i).getAccountName() + "  "+ accountsDatabase.get(i).getAccountNumber() + "  " +accountsDatabase.get(i).getAccountSSN()+"  "+accountsDatabase.get(i).getAccountSSN()+ "  "+accountsDatabase.get(i).getAccountBalance()+ "  "+accountsDatabase.get(i).getAccountType());
     System.out.println(accountsDatabase.get(i).generateEndingBalance());
   }
 }
 
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
      writeData.println("");
      writeData.println("");
      writeData.println("------------------------------------------------------------------------------------------");
      writeData.println("Towson Community Bank");
      writeData.println("8000 York Rd, Towson, MD 21252");
      writeData.println("(410) 704-2000");
      writeData.println("");
      writeData.println("");
      writeData.println("ATTN: "+accountsDatabase.get(i).getAccountName());
      writeData.println("[ADDRESS ON FILE                                                   ACCOUNT NUMBER: "+accountsDatabase.get(i).getAccountNumber());
      writeData.println("                                            IMPORTANT NOTICE                               ");
      writeData.println("TRANSACTION SUMMARY:");
      writeData.println("");
      writeData.println("POSTING DATE                   DEBITS                   CREDITS                 BALANCE");
      
      writeData.println(
      //writeData.println(accountsDatabase.get(i).getAccountNumber());
      //writeData.println("Statement, September 2014" );
      //writeData.println("");
      //writeData.println("");
      //writeData.println(accountsDatabase.get(i).getAccountName()+ " "+accountsDatabase.get(i).getAccountNumber());
    }
    
    writeData.close();
 }
 
  public static void main(String [] args) throws IOException{
    Driver test = new Driver();
    test.readFile();
    test.sortTokens();
    test.createAccounts();
    test.generateStatements();
    test.testArray();
  }
}