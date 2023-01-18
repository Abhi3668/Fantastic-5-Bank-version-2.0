package Data;

import java.sql.PreparedStatement;
import java.sql.Statement;

import bus.Account;
import bus.Checking;
import bus.Date;
import bus.Saving;
import bus.enumAccType;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SavingDB {

public static Saving Display() throws SQLException{
		   //Display saving
	    Connection conn = ConnectionDB.ConnDB();
	    Saving sav = new Saving();
		String sqlQuery;
		System.out.println("\nSaving list...\n");
	    sqlQuery = "select * from \"FANTASTIC 5 BANK\".saving";
	    Statement myStatement = null;
	    ResultSet myResultSet = null;
	    myStatement = conn.createStatement();
	    myResultSet = myStatement.executeQuery(sqlQuery);
	    
	    while(myResultSet.next())
	    {
	    
	    	sav.setS_number(myResultSet.getInt(1));
	    	sav.setS_balance(myResultSet.getFloat(2));
	    	sav.setS_fee(myResultSet.getInt(3));
	    	System.out.println("\nSaving No:" + sav.getS_number()+ " Balance: " + sav.getS_balance()+ " Fee: " + sav.getS_fee());
	    }
	    
	    conn.close();
	   return sav;
	   
	}

public static void Add(Saving saving) throws SQLException{
	//add saving
	Connection conn = ConnectionDB.ConnDB();

    String sqlStmt = "insert into \"FANTASTIC 5 BANK\".saving values (?,?,?,?)";
    PreparedStatement myPreparedStatement = null;
    myPreparedStatement = conn.prepareStatement(sqlStmt);
   
    myPreparedStatement.setLong(1, saving.getS_number()); //(coluna, variable)
    myPreparedStatement.setInt(2, saving.getAccNo());
    myPreparedStatement.setFloat(3, saving.getS_balance());
    myPreparedStatement.setInt(4, saving.getS_fee());

  

    
    myPreparedStatement.executeUpdate(); //insert, delete, update
    conn.commit();
    conn.close();
}

public static void Update(Saving sav) throws SQLException{
//update saving
Connection conn = ConnectionDB.ConnDB();
String sqlStmt = "update \"FANTASTIC 5 BANK\".saving Set s_balance = " +sav.getS_balance()+ " where s_number = "  + sav.getS_number();
PreparedStatement myPreparedStatement = null;
myPreparedStatement = conn.prepareStatement(sqlStmt);  
myPreparedStatement.executeUpdate(); 
conn.commit();
conn.close();
}

public static void Delete(Saving saving) throws SQLException{
	//delete saving
	Connection conn = ConnectionDB.ConnDB();
	String sqlStmt = "delete from \"FANTASTIC 5 BANK\". saving where s_number = " + saving.getS_number();
	PreparedStatement myPreparedStatement = null;
    myPreparedStatement = conn.prepareStatement(sqlStmt);  
    myPreparedStatement.executeUpdate(); 
    conn.commit();
    conn.close();
}

public static Saving Search(Saving saving) throws SQLException{

	//Search saving
	Connection conn = ConnectionDB.ConnDB();
    Saving sav= new Saving();
	String sqlQuery;
	sqlQuery = "select * from \"FANTASTIC 5 BANK\". saving where s_number = " + saving.getS_number();
	Statement myStatement = null;
    ResultSet myResultSet = null;
    myStatement = conn.createStatement();
    myResultSet = myStatement.executeQuery(sqlQuery);
    
    while(myResultSet.next())
    {
    
    	sav.setS_number(myResultSet.getInt(1));
    	sav.setS_balance(myResultSet.getFloat(2));
    	sav.setS_fee(myResultSet.getInt(3));
    	System.out.println("\nSaving No:" + sav.getS_number() + " Balance: " + sav.getS_balance()+ " Fee: " + sav.getS_fee());
    }
    
    conn.close();
    return sav;
	
}

public static Saving DisplayAll(long c_id) throws SQLException{
	   
	//Display all details of saving
    Connection conn = ConnectionDB.ConnDB();
    Saving sav = new Saving();
	String sqlQuery;
	 System.out.println("======================================================================================================");
	System.out.println("\nAccount Details\n");
    sqlQuery = "select s.s_number, ac.ac_number, s.s_balance,ac.ac_id from \"FANTASTIC 5 BANK\" .saving s join \"FANTASTIC 5 BANK\".account ac ON s.ac_number = ac.ac_number WHERE ac.ac_id ="+ c_id ;
    Statement myStatement = null;
    ResultSet myResultSet = null;
    myStatement = conn.createStatement();
    myResultSet = myStatement.executeQuery(sqlQuery);
    
    while(myResultSet.next())
    {

    	sav.setS_number(myResultSet.getLong(1));
    	sav.setAccNo(myResultSet.getInt(2));
    	sav.setS_balance(myResultSet.getInt(3));
    	System.out.println("\nSaving Number: " + sav.getS_number() + " Account Number: "  + sav.getAccNo() + " Balance: " + sav.getS_balance());
    	 System.out.println("======================================================================================================");
    }
    
    conn.close();
   return sav;
   
}

public static int GetIndex() throws SQLException{
//index
	int nextNumber=0;
	Connection conn = ConnectionDB.ConnDB();
  
	String sqlQuery;
	sqlQuery = "select max(s_number)as TempNumber from \"FANTASTIC 5 BANK\".saving ";
	Statement myStatement = null;
    ResultSet myResultSet = null;
    myStatement = conn.createStatement();
    myResultSet = myStatement.executeQuery(sqlQuery);
    
    if(myResultSet.next())
    {
    	nextNumber = myResultSet.getInt(1)+1;
    	
    	
    }
    conn.commit();
    conn.close();
    return nextNumber;
	
}

public static Account CusXAcc(long l) throws SQLException{
	//find ac_number by ac_id and c_id
	Connection conn = ConnectionDB.ConnDB();
   
    
    Saving sav= new Saving();
	String sqlQuery;
	sqlQuery = "select ac_number from \"FANTASTIC 5 BANK\". account where ac_id =" + l;
	Statement myStatement = null;
    ResultSet myResultSet = null;
    myStatement = conn.createStatement();
    myResultSet = myStatement.executeQuery(sqlQuery);
    
    while(myResultSet.next())
    {   
    	
    	sav.setAccNo(myResultSet.getInt(1));
    	
    	  	
    	
    }
    conn.commit();
    conn.close();
    return sav;
	
}


public static long SavByAcc(long acc) throws SQLException{
	//Find savings by account number
	Connection conn = ConnectionDB.ConnDB();
   
    
    
	String sqlQuery;
	sqlQuery = "select s_number from \"FANTASTIC 5 BANK\".saving where ac_number = " + acc;
	Statement myStatement = null;
    ResultSet myResultSet = null;
    myStatement = conn.createStatement();
    myResultSet = myStatement.executeQuery(sqlQuery);
    
    while(myResultSet.next())
    {   
    	
    	acc=myResultSet.getLong(1);
    	
    	
    }
    conn.commit();
    conn.close();
    return acc;
	
}



public static Float TotalDeposit(long l) throws SQLException{
	//TotalDeposit
	Connection conn = ConnectionDB.ConnDB();
    
    float total=0;
    
	String sqlQuery;
	sqlQuery = "select sum(amount) from \"FANTASTIC 5 BANK\".transaction where t_type = 'Deposit' and sa_number="+l;
	Statement myStatement = null;
    ResultSet myResultSet = null;
    myStatement = conn.createStatement();
    myResultSet = myStatement.executeQuery(sqlQuery);
    
    while(myResultSet.next())
    {   
    	
    	total =myResultSet.getLong(1);
    	
    	  	System.out.println(total);
    	
    }
    conn.commit();
    conn.close();
    return total;
	
}

public static Float Totalwithdrawal(long l) throws SQLException{
	//Totalwithdrawal
	Connection conn = ConnectionDB.ConnDB();
    
    float total=0;
    
	String sqlQuery;
	sqlQuery = "select sum(amount) from \"FANTASTIC 5 BANK\". transaction where t_type = 'Withdraw' and sa_number="+l;
	Statement myStatement = null;
    ResultSet myResultSet = null;
    myStatement = conn.createStatement();
    myResultSet = myStatement.executeQuery(sqlQuery);
    
    while(myResultSet.next())
    {   
    	
    	total =myResultSet.getLong(1);
    	
    	  	
    	
    }
    conn.commit();
    conn.close();
    return total;
	
}


}
