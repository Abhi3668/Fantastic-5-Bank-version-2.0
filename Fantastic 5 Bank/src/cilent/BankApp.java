package cilent;

import java.sql.SQLException;
import java.util.Scanner;

//import Data.CreditDB;
import Data.SavingDB;
import bus.*;


public class BankApp {
	 
	
	public static void main(String[] args) throws SQLException {

		Scanner scan = new Scanner(System.in);
	    int option;
	   
	    Customer cus = new Customer();
	    Transaction tra = new Transaction();
	    Saving sav = new Saving();
	    Checking che = new Checking();
	 
	    
	    do{	//Home Page
	    	System.out.println("\nWelcome to Fantastic 5 Bank");
	    	System.out.println("\nChoose an option:- ");
	    	System.out.println("\n1.Login");
	    	System.out.println("\n2.Exit application ");
	    	option= scan.nextInt();
	    	
			switch(option)
			{
			case 1:
			{//Login page
				try {
				System.out.println("\nEnter customer id: ");
			    cus.setId(scan.nextLong());
			    scan.nextLine();
			    System.out.println("\nEnter customer password: ");
			    cus.setPass(scan.next());}
				catch(Exception e) {
					System.out.println("Enter a valid 9 digit customer id");
				}
			    System.out.println("======================================================================================================");
			    Customer.Login(cus);
			    if(Customer.Login(cus).getId()==0 || Customer.Login(cus).getPass().equals("")){
			    	System.out.println("Customer not found!");
			    	return;
			    }
			   
			   
			    
			    do{
			    //Welcome Page
			    	 System.out.println("======================================================================================================");
				System.out.println("\nWelcome");
				System.out.println("\nChoose an option");
				System.out.println("\n1. Display your Account Details");
				System.out.println("2. Create a Saving Account");
				System.out.println("3. Delete a Saving Account");
				System.out.println("4. Transactions");
				System.out.println("5. Exit application");
				option= scan.nextInt();
				 System.out.println("======================================================================================================");
				switch(option)
				{
				case 1:
					//Display
					Checking.DisplayAll(cus.getId());
					Saving.DisplayAll(cus.getId());
			    Account.DisplayAll(cus.getId());
					break;
			case 2:
				//Add Saving
				 
				 	 System.out.println("======================================================================================================");
				 	System.out.println("Enter the Saving Number : ");					
					sav.setS_number(Saving.GetIndex());
					 System.out.println("======================================================================================================");
					sav.setAccNo(Saving.CusXAcc(cus.getId()).getAccNo());
					sav.setS_balance(0);
					sav.setS_fee(0);
					 System.out.println("======================================================================================================");
					System.out.println("\nS_number:- " +sav.getS_number());
					System.out.println("\nA_number:- "+sav.getAccNo());;
					System.out.println("\nS_balance:- "+sav.getS_balance());
				System.out.println("\nS_fee:- "+sav.getS_fee());
				 System.out.println("======================================================================================================");
				Saving.Add(sav);
					//TransactionDB.Display();
			break;
		
				case 3:
					  //Delete Saving
					Saving sav1 = new Saving();
					 System.out.println("======================================================================================================");
					System.out.println("Enter saving account number: ");
			        sav1.setS_number(scan.nextLong());
			        if(sav.getS_balance()!=0)
			        {
			        	System.out.println("You have a positive balance, make a withdrawal of your total balance ");
			        	 System.out.println("======================================================================================================");}
			        else
			        { System.out.println("======================================================================================================");
			        System.out.println("Account "+sav1+" is deleted");	
			        Saving.Delete(sav1);}
					break;
			
				case 4:
					//Add a transaction
					Checking.DisplayAll(cus.getId());
					Saving.DisplayAll(cus.getId());
					Account.DisplayAll(cus.getId());
					
						System.out.println("\nChoose the type of account you want to access");
						System.out.println("Choose [1] to Checking, [2] to Saving or [3] to exit");
						int	accoption= scan.nextInt();
					    System.out.println("======================================================================================================");
						switch(accoption) {
						case 1:{						
						//checking account
						tra.setSa_number(Checking.CheByAcc(Checking.CusXAcc(cus.getId()).getAccNo()));
																		
						break;
							}
						case 2:{//saving account
						tra.setSa_number(Saving.SavByAcc(Saving.CusXAcc(cus.getId()).getAccNo()));
						break;
										}
								default:	
								 }
					do{// Transaction Functions
						 System.out.println("======================================================================================================");
						System.out.println("Choose [1] to deposit, [2] to withdrawal or [3] to exit");
						option= scan.nextInt();
						 System.out.println("======================================================================================================");
						 switch(option)
						 {
							case 1:
							{//deposit
								tra.setT_number(Transaction.GetIndex());
											
															
								tra.setType("Deposit");
								 System.out.println("======================================================================================================");
								System.out.println("Enter the amount: ");
					tra.setAmount(scan.nextFloat());	
					 System.out.println("======================================================================================================");
					Transaction.Add(tra);
								Transaction.Display();
								 System.out.println("======================================================================================================");
								if(accoption==1){
									//deposit in checking
									che.setCh_balance(Transaction.TotalDeposit(tra.getSa_number())-Transaction.Totalwithdrawal(tra.getSa_number()));
									Checking.Update(che);
								}
								
								else if(accoption==2){
									
									//deposit in savings
									sav.setS_balance(Transaction.TotalDeposit(tra.getSa_number())-Transaction.Totalwithdrawal(tra.getSa_number()));
									Saving.Update(sav);
									System.out.println(sav);
								} 
							
								break;
							}
							case 2:
							{//Withdraw from accounts
								tra.setT_number(Transaction.GetIndex());
								
								
								tra.setType("Withdraw");
								System.out.println("Enter the amount: ");
								tra.setAmount(scan.nextInt());	
								Transaction.Add(tra);
								Transaction.Display();
								
								if(accoption==1){// withdraw from checking
									
									che.setCh_balance(Transaction.TotalDeposit(tra.getSa_number())-Transaction.Totalwithdrawal(tra.getSa_number()));
									Checking.Update(che);
								}
								
								else if(accoption==2){
									if(sav.getS_balance()<tra.getAmount()) {
										System.out.println(sav.getS_balance()<tra.getAmount());
										System.out.println("Insufficient funds");
									}
									else
									// withdraw from saving
									sav.setS_balance(SavingDB.TotalDeposit(tra.getSa_number())-SavingDB.Totalwithdrawal(tra.getSa_number()));
								}
									
								
										
									
								
					
								
								break;
							}
							
							default:	
					 }
			 	}while(option !=3);
					
				}
			    }while(option != 5);
			    //Exit application
			    System.out.println("======================================================================================================");
			    System.out.println(" Thank you for using our services ");
			    
			    System.out.println("======================================================================================================");
			    break;
			}
			case 2:
				break;
			default:
		}
	    }while(option !=2);
	    //App Closed
	    System.out.println("======================================================================================================");
	    System.out.println("Thank you for using our services");
	    System.out.println("======================================================================================================");


	    
	    scan.close();
	    System.exit(0);

	}
  }

		

					
