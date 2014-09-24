package project_two_second;

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
    
     /*ArrayList <String> tempAccountSSN = new ArrayList<String>();
     ArrayList <String> tempAccountType = new ArrayList<String>();
     ArrayList <Integer> tempAccountNumber = new ArrayList<Integer>();
     ArrayList <Integer> tempAccountBalance = new ArrayList<Integer>();
     int token;*/
     
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
   /*String tempAccountName;
   String tempAccountSSN;
   String tempAccountPhone;
   String tempAccountType;
   int tempAccountNumber;
   int tempAccountBalance;*/
   
   /*ArrayList <String> tempAccountName = new ArrayList<String>();
   ArrayList <Integer> tempAccountNumber = new ArrayList<Integer>();
   ArrayList <String> tempAccountPhone = new ArrayList<String>();
   ArrayList <String> tempAccountSSN = new ArrayList<String>();
   ArrayList <Double> tempAccountBalance = new ArrayList<Double>();
   ArrayList <String> tempAccountType = new ArrayList<String>();*/
   
   //sort string tokens
   for(int i=0; i < stringHolder.size(); i++){
     if(stringHolder.get(i).matches("[A-Z][a-z]+( [A-Z][a-z]+)?")){
       //System.out.println(stringHolder.get(i)+ " YEAAH");
       tempAccountName.add(stringHolder.get(i));
     }
     else if(stringHolder.get(i).matches("\\d{3}-\\d{4}")){
       tempAccountPhone.add(stringHolder.get(i));
       //System.out.println(stringHolder.get(i)+ " ACOUNT PHONEEEEE");
     }
     else if(stringHolder.get(i).matches("\\d{3}-\\d{2}-\\d{4}")){
       tempAccountSSN.add(stringHolder.get(i));
       //System.out.println(stringHolder.get(i)+ " SSNNNNNN");
     }
     else if(stringHolder.get(i).matches("[A-Za-z]")){
       tempAccountType.add(stringHolder.get(i));
       //System.out.println(stringHolder.get(i)+ " ACOUNT TYPEEEEE");
     }
   }
   //sort int tokens
   for(int i=0; i < intHolder.size(); i ++){
     if(Integer.toString(intHolder.get(i)).matches("\\d{8}")){
       tempAccountNumber.add(intHolder.get(i));
       //System.out.println(intHolder.get(i)+ " ACOUNT Number");
     }
     else{
       tempAccountBalance.add((double)intHolder.get(i));
       //System.out.println(intHolder.get(i)+ " ACOUNT Balance");
     }
   }
 }
 
 //create accounts objects
 public void createAccounts(){
   for(int i=0; i < tempAccountName.size();i++){
     accountsDatabase.add(new Business_Account(tempAccountName.get(i),tempAccountNumber.get(i),tempAccountPhone.get(i),tempAccountSSN.get(i),tempAccountBalance.get(i),tempAccountType.get(i)));
     //accountsDatabase.add(new Business_Account("Business",14872,"555-0498","122-78-7545",4500,"B"));
     if(tempAccountType.get(i).equals("B")){
       accountsDatabase.add(new Business_Account(tempAccountName.get(i),tempAccountNumber.get(i),tempAccountPhone.get(i),tempAccountSSN.get(i),tempAccountBalance.get(i),tempAccountType.get(i)));
     }
     System.out.println(tempAccountType.get(i));
   }
 }
 
 public void testArray(){
   for(int i= 0; i < accountsDatabase.size(); i++){
     System.out.println(accountsDatabase.get(i).getAccountName() + "  "+ accountsDatabase.get(i).getAccountNumber() + "  " +accountsDatabase.get(i).getAccountSSN()+"  "+accountsDatabase.get(i).getAccountSSN()+ "  "+accountsDatabase.get(i).getAccountBalance()+ "  "+accountsDatabase.get(i).getAccountType());
   }
   for(int i=0; i < intHolder.size(); i++){
   }
   System.out.println(tempAccountNumber.size());
   System.out.println(tempAccountType.size());
 }
 
 //generate bank statements
 
  public static void main(String [] args) throws IOException{
    Driver test = new Driver();
    test.readFile();
    test.sortTokens();
    test.createAccounts();
    test.testArray();
    System.out.println(test.accountsDatabase.size());
    
    Account newBusiness = new Business_Account("Business",14872,"555-0498","122-78-7545",4500,"B");
    Account newSavings = new Savings_Account("Savings",14872,"555-0498","122-78-7545",4500,"B");
    Account newChecking = new Checking_Account("Checking",14872,"555-0498","122-78-7545",4500,"B");
    System.out.println(newBusiness.accountName);
    System.out.println(newSavings.accountName);
    System.out.println(newChecking.accountName);
  }
}