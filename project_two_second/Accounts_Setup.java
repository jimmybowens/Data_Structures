package project_two_second;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

public class Accounts_Setup{
  ArrayList<Account> accountsDatabase = new ArrayList<Account>();
  ArrayList <String> stringHolder = new ArrayList<String>();
  ArrayList <Integer> intHolder = new ArrayList<Integer>();
  
  ArrayList <String> tempAccountName = new ArrayList<String>();
  ArrayList <Integer> tempAccountNumber = new ArrayList<Integer>();
  ArrayList <String> tempAccountPhone = new ArrayList<String>();
  ArrayList <String> tempAccountSSN = new ArrayList<String>();
  ArrayList <Double> tempAccountBalance = new ArrayList<Double>();
  ArrayList <String> tempAccountType = new ArrayList<String>();
  public Accounts_Setup()throws IOException{
    //startSetup();
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
}
  
//create accounts objects
 public void createAccounts(){
   for(int i=0; i < tempAccountName.size();i++){
     //accountsDatabase.add(new Accounts(tempAccountName.get(i),tempAccountNumber.get(i),tempAccountPhone.get(i),tempAccountSSN.get(i),tempAccountBalance.get(i),tempAccountType.get(i)));
     //create correct account in database
     if(tempAccountType.get(i).equals("B")){
       accountsDatabase.add(new Business_Account(tempAccountName.get(i),tempAccountNumber.get(i),tempAccountPhone.get(i),tempAccountSSN.get(i),tempAccountBalance.get(i),tempAccountType.get(i)));
     }
   }
 }
 
public void startSetup() throws IOException{
   readFile();
   sortTokens();
   createAccounts();
   testArray();
 }


public void testArray(){
   for(int i= 0; i < accountsDatabase.size(); i++){
     System.out.println(accountsDatabase.get(i).getAccountName() + "  "+ accountsDatabase.get(i).getAccountNumber() + "  " +accountsDatabase.get(i).getAccountSSN()+"  "+accountsDatabase.get(i).getAccountSSN()+ "  "+accountsDatabase.get(i).getAccountBalance()+ "  "+accountsDatabase.get(i).getAccountType());
   }
   for(int i=0; i < intHolder.size(); i++){
   }
   System.out.println(tempAccountNumber.size());
   System.out.println(tempAccountType.size());
   System.out.println(tempAccountType.size());
   
 }
 
 
 
 
}