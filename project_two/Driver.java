package project_two;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

public class Driver {
  ArrayList<Accounts> accountsDatabase = new ArrayList<Accounts>();
 public Driver(){}
 
 public void readFile() throws IOException{
     Scanner getInput = null;
     Accounts newAccount;
     ArrayList <String> tempAccountName = new ArrayList<String>();
     ArrayList <String> tempAccountPhone = new ArrayList<String>();
     ArrayList <String> tempAccountSSN = new ArrayList<String>();
     ArrayList <String> tempAccountType = new ArrayList<String>();
     ArrayList <Integer> tempAccountNumber = new ArrayList<Integer>();
     ArrayList <Integer> tempAccountBalance = new ArrayList<Integer>();
     int token;
     
     try{
       getInput = new Scanner( new File(System.getProperty("user.home")+File.separator+"Desktop"+File.separator+"accounts data.txt")); // read file from desktop
       getInput.nextLine();
     }catch(IOException i){
       System.out.println(i);
     }
     
     while(getInput.hasNextLine()){
       //read integer first
       while(getInput.hasNext()){
         
         if(getInput.hasNextInt()){
           token = getInput.nextInt();
           if(Integer.toString(token).length() == 8){
             tempAccountNumber.add(token);
             System.out.println(tempAccountBalance.get(0));
           }//end if
           if(!(Integer.toString(token).length() == 8)){
             tempAccountBalance.add(token);
             //System.out.println(tempAccountBalance.get(0));
           }
         }//end if
         getInput.next();
       }//end while
       getInput.nextLine();//read next line
     }//end while
     getInput.close();
   }
 
 public void testArray(){
   for(int i= 0; i < accountsDatabase.size(); i++){
     System.out.println(accountsDatabase.get(i).accountNumber + " Account Number From Database");
   }
 }
 
 
 public static void main(String[] args) throws IOException{
  Driver test = new Driver();
  test.readFile();
  test.testArray();
  
 }

}
