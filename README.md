Jimmy Bowens
COSC 600 Data Structures
Professor H. Zhou
Date: September 27, 2014
Project Due Dater: September 29, 2014
==============

The purpose of this project is to fullfill the requirements for Project #2

====PROJECT DESCRIPTION====

You are to create a set of classes to implement a banking mode in Java, and are expected to employ the techniques of inheritance and polymorphism.

A bank has account owners, each of them may have one or more bank accounts, such as savings accounts, checking accounts, and business accounts. 
Each account has the following information stored as private data: such as name,  account_number, and balance.  
At the end of each month, the bank issues a statement for each bank account containing the following information: name, SSN, account_number, phone_number, open balance, and close balance. 
The close balance is the open balance plus the interest calculated based on the type of the account. To simplify your task, you can assume that there was no transaction in the past month. 

With a polymorphic method, the interest of each account is calculated differently:
1.	No interest for business accounts
2.	2.5% interest for each checking account
3.	4% for each saving account if the balance  < $5000
5% otherwise

You may need to create the following classes: accounts, business_accounts, checking_accounts, savings_accounts, and the driver class.

Read the following data from a file and use it  to test your program:

NAME     ACCOUNT	PHONE	    SSN		 BALANCE	 TYPE

Sam 	   78192222		555-0498	123-45-6789     4500               B
Carla	   74329832		555-9812	233-98-3831	    230                C
Woody	   72872911		555-9281	823-23-0911	    5700               S
Diane	   63672822		555-9232	212-11-0091	    2300               S
Norm	   27873773		555-2932	918-22-0911	    1400               C
Cliff	   38737737		555-9171	811-12-9811	    6700               S
Tom        72932331     555-9283    235-09-9282     7800               C

Submit your program along with the output produced

====WHAT I HAVE DONE IN THIS PROJECT====

This application contains five classes: Account, Savings_Account, Checking_Account, Business_Account, and Driver. All these classes
have been fully implemented, and the applications works as is intended.

====HOW TO RUN THIS APPLICATION==== 

(1) STEP ONE
This program was written, compiled, and tested using the Dr.Java IDLE. It is recommended that Dr.Java be used for quick demo and 
testing the application.

Create a directory on your computer with the name 'project_two_second'. This is the package the application will look for. Download the application files
into this directory Note: you must download all files into this directory. f you use a differently name directory, all the associated classes' package name must be updated to reflect this and prevent compile errors.

(2) STEP TWO
Compile the application, if no errors (you should not get any compile errors), click run to demo the application.

(3) STEP THREE
A new file with the name 'Account Statements.txt" has been placed on your computer's Desktop. This is the output file.

====FURTHER DEMO CASES====

I have taken the liberty to generate some test cases.

After the program has been compiled and demo, the console of the Dr.Java IDLE will show output of some test cases of deposits and withdrawals.
The reason for this is to demonstrate that the application is indeed performing within the parameters of the project requirements. Each account
has been given the functionality of deposit and withdrawal. The demo cases for the savings account, specifically, will show the interest rate
changing based on the closing balance levels.

Thank You!