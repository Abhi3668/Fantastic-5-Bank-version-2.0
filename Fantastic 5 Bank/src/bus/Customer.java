package bus;

import java.sql.SQLException;

import Data.CustomerDB;

public class Customer {
	
private long c_id;
private String c_last;
private String c_first;
private String c_password;

public String getPass() {
	return c_password;
}
public void setPass(String pass) {
	this.c_password = pass;
}
public long getId() {
	return c_id;
}
public void setId(long l) {
	this.c_id = l;
}
public String getFn() {
	return c_last;
}
public void setFn(String fn) {
	this.c_last = fn;
}
public String getLn() {
	return c_first;
}
public void setLn(String ln) {
	this.c_first = ln;
}


public Customer() {
	this.c_id = 0;
	this.c_last = "";
	this.c_first = "";
	this.c_password = "";
}

public Customer(int id, String fn, String ln,  String pass) {
	
	this.c_id = id;
	this.c_last = fn;
	this.c_first = ln;
	
	this.c_password =pass;
}

public String toString() {
	return "\nClient [id=" + c_id + "\nfn=" + c_last + "\nln=" + c_first + "\npass=" + c_password +"]";
}

public static Customer Display() throws SQLException{
	
	return CustomerDB.Display();
}

public static void Add(Customer customer) throws SQLException{
	CustomerDB.Add(customer);
}

public static void Delete(Customer customer) throws SQLException{
	CustomerDB.Delete(customer);
}

public static Customer Search(Customer customer) throws SQLException{
	return CustomerDB.Search(customer);
}

public static void Update(Customer customer) throws SQLException{
	CustomerDB.Update(customer);
}

public static Customer Login(Customer customer)throws SQLException{
	
	return CustomerDB.Login(customer);
}
}
