package Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bus.Customer;

public class CustomerDB {
	
public static Customer Display() throws SQLException{
		   
		//Display customer details
	    Connection conn = ConnectionDB.ConnDB();
	    Customer cus = new Customer();
		String sqlQuery;
		System.out.println("\nCustomer list...\n");
	    sqlQuery = "select * from \"FANTASTIC 5 BANK\".\"CUSTOMER\"";
	    Statement myStatement = null;
	    ResultSet myResultSet = null;
	    myStatement = conn.createStatement();
	    myResultSet = myStatement.executeQuery(sqlQuery);
	    
	    while(myResultSet.next())
	    {
	    	 System.out.println(cus);
	    	cus.setId(myResultSet.getInt(1));
	   
	    	cus.setLn(myResultSet.getString(2));
	     	cus.setFn(myResultSet.getString(3));
	    	cus.setPass(myResultSet.getString(4));
	    	System.out.println("\nID:" + cus.getId() + " First Name:" + cus.getFn()+ " Last Name:" + cus.getLn() + " Password:" + cus.getPass());
	    }
	   
	    conn.close();
	   return cus;
	 
	   
	}

public static void Add(Customer customer) throws SQLException{
	//add customer
	Connection conn = ConnectionDB.ConnDB();

    String sqlStmt = "insert into \"FANTASTIC 5 BANK\". customer values (?,?,?,?)";
    PreparedStatement myPreparedStatement = null;
    myPreparedStatement = conn.prepareStatement(sqlStmt);
    myPreparedStatement.setLong(1, customer.getId()); //(coluna, variable)
    myPreparedStatement.setString(2, customer.getFn());
    myPreparedStatement.setString(3, customer.getLn());
    myPreparedStatement.setString(4, customer.getPass());
    myPreparedStatement.executeUpdate(); //insert, delete, update
    conn.commit();
    conn.close();
}

public static void Delete(Customer customer) throws SQLException{
	//delete customer
	Connection conn = ConnectionDB.ConnDB();
	String sqlStmt = "delete from \"FANTASTIC 5 BANK\". customer where c_id = " + customer.getId();
	PreparedStatement myPreparedStatement = null;
    myPreparedStatement = conn.prepareStatement(sqlStmt);  
    myPreparedStatement.executeUpdate(); 
    conn.commit();
    conn.close();
}

public static Customer Search(Customer customer) throws SQLException{

	//search customer
	Connection conn = ConnectionDB.ConnDB();
    Customer cus = new Customer();
	String sqlQuery;
	sqlQuery = "select * from \"FANTASTIC 5 BANK\".\"CUSTOMER\" where c_id = " + customer.getId();
	Statement myStatement = null;
    ResultSet myResultSet = null;
    myStatement = conn.createStatement();
    myResultSet = myStatement.executeQuery(sqlQuery);
    
    while(myResultSet.next())
    {
    
    	cus.setId(myResultSet.getInt(1));
    	cus.setFn(myResultSet.getString(2));
    	cus.setLn(myResultSet.getString(3));
    	cus.setPass(myResultSet.getString(4));
    	System.out.println("\nID:" + cus.getId() + " Last Name:" + cus.getFn()+ " First Name:" + cus.getLn() + " Password:" + cus.getPass());
    }
    
    conn.close();
    return cus;
	
}

public static Customer Login(Customer customer) throws SQLException{

	//login as customer
	Connection conn = ConnectionDB.ConnDB();
    Customer cus = new Customer();
	String sqlQuery;
	sqlQuery = "select * from \"FANTASTIC 5 BANK\".\"CUSTOMER\" where c_id ="+ customer.getId() + "and c_password =\'" + customer.getPass() +"\'";
	// System.out.println(sqlQuery);
	Statement myStatement = null;
    ResultSet myResultSet = null;
    myStatement = conn.createStatement();
    myResultSet = myStatement.executeQuery(sqlQuery);
 
    if(myResultSet.next()){
    	
    	   	cus.setId(myResultSet.getInt(1));
    	   	cus.setLn(myResultSet.getString(2));
        	cus.setFn(myResultSet.getString(3));
        	
        	cus.setPass(myResultSet.getString(4));
        	
        	System.out.println("\nID:" + cus.getId() + " First Name:" + cus.getFn()+ " Last Name:" + cus.getLn() + " Password:" + cus.getPass());
    }
    
       
    conn.close();
    return cus;
	
}

public static void Update(Customer customer) throws SQLException{
	//update customer
	Connection conn = ConnectionDB.ConnDB();
	String sqlStmt = "update customer set c_first='" + customer.getFn() + "' where c_id= "  + customer.getId();
	PreparedStatement myPreparedStatement = null;
    myPreparedStatement = conn.prepareStatement(sqlStmt);  
    myPreparedStatement.executeUpdate(); 
    conn.commit();
    conn.close();
}


}
