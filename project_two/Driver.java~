package project_two;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Driver {
 
 public Driver(){}
 
 public void readFile() throws IOException{
     Scanner getInput = null;
     String name, accountNumber, phoneNumber, ssn, accountType;//to perform regula expressions
     accountNumber ="^(\\d{8})$";
     ssn = "^(\\d{3}-?\\d{2}-?\\d{4})$";
     phoneNumber = "^(\\d{3}-?\\d{4})$";
     accountType ="[a-zA-Z]";
     name = "^[a-zA-Z]+";
     
     try{
       getInput = new Scanner( new File(System.getProperty("user.home")+File.separator+"Desktop"+File.separator+"accounts data.txt")); // read file from desktop
       while(getInput.hasNext()){
        if(getInput.hasNext()){
          String token = getInput.next();
          if(token.matches(ssn)){
            System.out.println("SSN "+token);
          }else if(token.matches(phoneNumber)){
            System.out.println("Phone Number: "+token );
          }else if(token.matches(accountNumber)){
            System.out.println("Account Number: "+token);
          }else if(token.matches(accountType)){
            System.out.println("Account type: "+token);
          }else if(token.matches(name)){
            System.out.println("Name: "+token);
          }
            
        }else{
         getInput.next();
        }
       }
     
     }catch(IOException i){
       System.out.println(i); 
     }
     finally{
       if(getInput != null){
         getInput.close();
       }
     }
       
   }
 
 public static void main(String[] args) throws IOException{
  Driver test = new Driver();
  test.readFile();
  
 }

}
