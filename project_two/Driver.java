package project_two;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

public class Driver {
 
 public Driver(){}
 
 public void readFile() throws IOException{
     Scanner getInput = null;
     String accountNumber, phoneNumber, accountType;//to perform regula expressions
     //accountNumber ="^(\\d{8})$";
     Pattern social = Pattern.compile("^(\\d{3}-?\\d{2}-?\\d{4})$");
     Pattern ssn = Pattern.compile("\\d{3}[-]?\\d{2}[-]?(\\d{4})");
     Pattern phone = Pattern.compile("\\d{3}[-]?\\d{4}");
     phoneNumber = "^(\\d{3}-?\\d{4})$";
     accountType ="[a-zA-Z]";
     Pattern name = Pattern.compile("^[a-zA-Z]+");
     String stringToken = null;
     int intToken;
     
     
     
     try{
       getInput = new Scanner( new File(System.getProperty("user.home")+File.separator+"Desktop"+File.separator+"accounts data.txt")); // read file from desktop
       getInput.nextLine();
     }catch(IOException i){
       System.out.println(i);
     }
     
     while(getInput.hasNextLine()){
       while(getInput.hasNext()){
         if(getInput.hasNextInt()){
           //intToken = getInput.nextInt();
           if(getInput.next().length()== 8){
             System.out.println(getInput.next() + " Account Number");
           }
           if(!(getInput.next().length()==8)){
             System.out.println(getInput.next() +" Balance");
           }
         }
         else if(getInput.hasNext(name)){
           System.out.println(getInput.next());
         }
         else if(getInput.hasNext(ssn)){
           System.out.println(getInput.next() + " Social"); 
         }
         if(getInput.hasNext(phone)){
           System.out.println(getInput.next() + " Phone");
         }
         else{
         getInput.next();
         }
       }
       getInput.nextLine();
     }
     getInput.close();
   }
 
 public static void main(String[] args) throws IOException{
  Driver test = new Driver();
  test.readFile();
  
 }

}
