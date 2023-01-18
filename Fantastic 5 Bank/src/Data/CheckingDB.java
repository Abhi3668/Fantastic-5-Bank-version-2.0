package Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bus.Account;
import bus.Checking;

public class CheckingDB {
	
	public static Checking Display() throws SQLException{
		//Display Checking Account details
	Connection conn = ConnectionDB.ConnDB();
	 Checking ch = new Checking();
		String sqlQuery;
		System.out.println("\nChecking list...\n");
	 sqlQuery = "select * from \"FANTASTIC 5 BANK\". checking";
	 Statement myStatement = null;
	 ResultSet myResultSet = null;
	 myStatement = conn.createStatement();
	 myResultSet = myStatement.executeQuery(sqlQuery);
	 
	 while(myResultSet.next())
	 {
	 
	 	ch.setCh_number(myResultSet.getInt(1));
	 	ch.setCh_balance(myResultSet.getFloat(2));
	    ch.setCh_fee(myResultSet.getString(3).charAt(0));
	 
	 	
	 	System.out.println("\nChecking Number:" + ch.getCh_number() 
	 			+ "Balance" +ch.getCh_balance()+ "Fee"+ch.getCh_fee());
	 }
	 
	 conn.close();
	return ch;

	}



	public static Checking Search(Checking ch) throws SQLException{
//Search checking account

	Connection conn = ConnectionDB.ConnDB();
	Checking che = new Checking();

	String sqlQuery;
	sqlQuery = "select * from \"FANTASTIC 5 BANK\".checking where ch_number = " + ch.getCh_number();
	Statement myStatement = null;
	ResultSet myResultSet = null;
	myStatement = conn.createStatement();
	myResultSet = myStatement.executeQuery(sqlQuery);

	while(myResultSet.next())
	{  	che.setCh_number(myResultSet.getInt(1));
		che.setCh_balance(myResultSet.getFloat(2));
		che.setCh_fee(myResultSet.getString(3).charAt(0));
		
		System.out.println("\nChecking Number:" + ch.getCh_number() 
	 			+"Balance" +ch.getCh_balance()+ "Fee"+ch.getCh_fee());
	}

	conn.close();
	return che;

	}

	public static void Update(Checking che) throws SQLException{
//update checking account
		Connection conn = ConnectionDB.ConnDB();
		String sqlStmt = "update \"FANTASTIC 5 BANK\". checking Set ch_balance = " +che.getCh_balance()+ " where ch_number= "  + che.getCh_number();
		PreparedStatement myPreparedStatement = null;
		myPreparedStatement = conn.prepareStatement(sqlStmt);  
		myPreparedStatement.executeUpdate(); 
		conn.commit();
		conn.close();
		}
	
	public static Checking DisplayAll(long c_id) throws SQLException{
		   
		// Display all the details of checking account
	    Connection conn = ConnectionDB.ConnDB(); 
	    Checking che = new Checking();
		
		String sqlQuery;
		 System.out.println("======================================================================================================");
		System.out.println("\nAccount Details\n");
	    sqlQuery = "select  ch.ch_number, ch.ac_number, ch.ch_balance, ac.ac_number,ac.ac_id from \"FANTASTIC 5 BANK\".checking ch join \"FANTASTIC 5 BANK\". account ac on ch.ac_number = ac.ac_number where ac.ac_id = "+c_id;
	  // System.out.println(sqlQuery);
	    Statement myStatement = null;
	    ResultSet myResultSet = null;
	    myStatement = conn.createStatement();
	    myResultSet = myStatement.executeQuery(sqlQuery);
	    
	    while(myResultSet.next())
	    	
	    {
	   
	    	che.setCh_number(myResultSet.getInt(1));
	    	che.setAccNo(myResultSet.getInt(2));
	    	che.setCh_balance(myResultSet.getInt(3));
	    	
	    		
	 System.out.println("\nChecking Number: " + che.getCh_number() + " Account Number: "  + che.getAccNo() + " Balance: " + che.getCh_balance());
	 System.out.println("======================================================================================================");
	    }
	    
	    conn.close();
	   return che;
	   
	}
	
	
	public static Account CusXAcc(long l) throws SQLException{
		//finding account number with ac_id
		Connection conn = ConnectionDB.ConnDB();
	   
	    
	    Checking che= new Checking();
		String sqlQuery;
		sqlQuery = "select ac_number from \"FANTASTIC 5 BANK\".account where ac_id =" + l;
		Statement myStatement = null;
	    ResultSet myResultSet = null;
	    myStatement = conn.createStatement();
	    myResultSet = myStatement.executeQuery(sqlQuery);
	    
	    while(myResultSet.next())
	    {   
	    	
	    	che.setAccNo(myResultSet.getInt(1));
	    	
	    	  	
	    	
	    }
	    conn.commit();
	    conn.close();
	    return che;
		
	}
	
	public static int CheByAcc(int acc) throws SQLException{
		//find checking number with ac_number
		Connection conn = ConnectionDB.ConnDB();
	   
	    String sqlQuery;
		sqlQuery = "select ch_number from \"FANTASTIC 5 BANK\". checking where ac_number = " + acc;
		Statement myStatement = null;
	    ResultSet myResultSet = null;
	    myStatement = conn.createStatement();
	    myResultSet = myStatement.executeQuery(sqlQuery);
	    
	    while(myResultSet.next())
	    {   
	    	
	    	acc=myResultSet.getInt(1);
	    	
	    	
	    }
	    conn.commit();
	    conn.close();
	    return acc;
		
	}
	
	

}
