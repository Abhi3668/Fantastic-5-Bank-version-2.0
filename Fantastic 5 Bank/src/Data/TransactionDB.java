package Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bus.*;

public class TransactionDB {
	
public static Transaction Display() throws SQLException{
		   
		//Display transaction
	    Connection conn = ConnectionDB.ConnDB();
	    Transaction tra = new Transaction();
		String sqlQuery;
		 System.out.println("======================================================================================================");
		System.out.println("\nTransaction list...\n");
	    sqlQuery = "select * from \"FANTASTIC 5 BANK\".transaction";
	    Statement myStatement = null;
	    ResultSet myResultSet = null;
	    myStatement = conn.createStatement();
	    myResultSet = myStatement.executeQuery(sqlQuery);
	       
	    
	    while(myResultSet.next())
	    { 
	    
	    	tra.setT_number(myResultSet.getInt(1));
	    	tra.setSa_number(myResultSet.getLong(2));
	    	tra.setType(myResultSet.getString(3));
	    	tra.setT_date(myResultSet.getDate(4));
	       	tra.setAmount(myResultSet.getFloat(5));
	       
	        
	    	System.out.println("\nTransaction Number: " + tra.getT_number() + " SubAccount Number: " + tra.getSa_number()+ " Type: " + tra.getType()+ " Date: "+tra.getT_date()
	    			+ " Amount = " +tra.getAmount() );
	    	 
	    }
	    
	    conn.close();
	   return tra;
	   
	}

public static void Add(Transaction tra) throws SQLException{
	//add transaction
	Connection conn = ConnectionDB.ConnDB();

    String sqlStmt = "insert into \"FANTASTIC 5 BANK\".transaction values (?,?,?,?,?)";
    PreparedStatement myPreparedStatement = null;
    myPreparedStatement = conn.prepareStatement(sqlStmt);
    myPreparedStatement.setInt(1, tra.getT_number()); 
    myPreparedStatement.setLong(2, tra.getSa_number());
    myPreparedStatement.setString(3, tra.getType().toString());
    
    java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
    myPreparedStatement.setDate(4, sqlDate);
    myPreparedStatement.setFloat(5, tra.getAmount());
    myPreparedStatement.executeUpdate(); 
    conn.commit();
    conn.close();
}



public static Transaction Search(Transaction tran) throws SQLException{

//search transaction
Connection conn = ConnectionDB.ConnDB();
Transaction tra = new Transaction();

String sqlQuery;
sqlQuery = "select * from \"FANTASTIC 5 BANK\". Transaction where ac_number = " + tran.getT_number();
Statement myStatement = null;
ResultSet myResultSet = null;
myStatement = conn.createStatement();
myResultSet = myStatement.executeQuery(sqlQuery);

	while(myResultSet.next())
	{ 

		tra.setT_number(myResultSet.getInt(1));
		tra.setSa_number(myResultSet.getInt(2));
		tra.setType(myResultSet.getString(3));
		
		
		tra.setT_date(myResultSet.getDate(4));
		tra.setAmount(myResultSet.getFloat(5));
		System.out.println("\nTransaction Number: " + tra.getT_number() + " SubAccount Number: " + tra.getSa_number()+ " Type: " + tra.getType()+ " Date: "+tra.getT_date()
			+ "Amount" +tra.getAmount() );
	}

conn.close();
return tra;

}

public static void Update(Transaction tra) throws SQLException{
//update transaction
Connection conn = ConnectionDB.ConnDB();
String sqlStmt = "update Transaction " +"Set t_number = "  + tra.getT_number() + "," + " t_type = '" + tra.getType()+ ","+" t_date = '" +tra.getT_date()
		+ "," + "amount = '" + tra.getAmount()+ "'" +" where t_number= "  + tra.getT_number();
PreparedStatement myPreparedStatement = null; 
myPreparedStatement = conn.prepareStatement(sqlStmt);  
myPreparedStatement.executeUpdate(); 
conn.commit();
conn.close();
}


public static int GetIndex() throws SQLException{
// Index
	int nextNumber=0;
	Connection conn = ConnectionDB.ConnDB();
  
	String sqlQuery;
	sqlQuery = "select max(t_number)as TempNumber from \"FANTASTIC 5 BANK\". transaction ";
	Statement myStatement = null;
    ResultSet myResultSet = null;
    myStatement = conn.createStatement();
    myResultSet = myStatement.executeQuery(sqlQuery);
    
    if(myResultSet.next())
    {
    	nextNumber = myResultSet.getInt(1)+1;
    	
    	
    }
    
    conn.close();
    return nextNumber;
	
}


public static Float TotalDeposit(long l) throws SQLException{
	//Total Deposit
	Connection conn = ConnectionDB.ConnDB();
    
    float total=0;
    
	String sqlQuery;
	sqlQuery = "select sum(amount) from \"FANTASTIC 5 BANK\".Transaction where t_type = 'Deposit' and sa_number="+l;
	Statement myStatement = null;
    ResultSet myResultSet = null;
    myStatement = conn.createStatement();
    myResultSet = myStatement.executeQuery(sqlQuery);
    
    while(myResultSet.next())
    {   
    	
    	total =myResultSet.getInt(1);
    	
    	  	
    	
    }
    conn.commit();
    conn.close();
    return total;
	
}

public static Float Totalwithdrawal(long l) throws SQLException{
	//Total withdrawal
	Connection conn = ConnectionDB.ConnDB();
    
    float total=0;
    
	String sqlQuery;
	sqlQuery = "select sum(amount) from \"FANTASTIC 5 BANK\". Transaction where t_type = 'Withdraw' and sa_number="+l;
	Statement myStatement = null;
    ResultSet myResultSet = null;
    myStatement = conn.createStatement();
    myResultSet = myStatement.executeQuery(sqlQuery);
    
    while(myResultSet.next())
    {   
    	
    	total =myResultSet.getInt(1);
    	
    	  	
    	
    }
    conn.commit();
    conn.close();
    return total;
	
}




}
