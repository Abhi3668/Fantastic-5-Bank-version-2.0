package bus;

import java.sql.SQLException;
import java.text.*;

import Data.SavingDB;
import Data.TransactionDB;

public class Transaction {
private int t_number;
private long sa_number;
private java.util.Date t_date;
private float amount;
private String type;

public int getT_number() {
	return t_number;
}
public void setT_number(int t_number) {
	this.t_number = t_number;
}

public long getSa_number() {
	return sa_number;
}
public void setSa_number(long l) {
	this.sa_number = l;
}
public java.util.Date getT_date() {
	return t_date;
}
public void setT_date(java.util.Date t_date) {
	this.t_date = t_date;
}
public float getAmount() {
	return amount;
}
public void setAmount(float amount) {
	this.amount = amount;
}
public String getType() {
	return type;
}
public void setType(String string) {
	this.type = string;
}

public Transaction(int t_number, int sa_number, java.util.Date t_date, float amount, String type ) {
	
	this.t_number = t_number;
	this.sa_number = sa_number;
	this.t_date = t_date;
	this.amount = amount;
	this.type = type;
	
}
public Transaction() {
	
	this.t_number = 0;
	this.sa_number = 0;
	this.t_date = null;
	this.amount = 0;
	this.type = "Undefined";
	
}

public static int GetIndex() throws SQLException{
	return TransactionDB.GetIndex();
}
@Override
public String toString() {
	return "Transation [t_number = " + t_number + ", sa_number =" + sa_number
			+ ", t_date = " + t_date + ", amount = " + amount + ", type = " + type + "]";
}

public static Transaction Display() throws SQLException{
	return TransactionDB.Display();
}

public static void Add(Transaction tra) throws SQLException{
	TransactionDB.Add(tra);
}

public static Float TotalDeposit(long l) throws SQLException{
	return TransactionDB.TotalDeposit(l);
}

public static Float Totalwithdrawal(long l) throws SQLException{
	return TransactionDB.Totalwithdrawal(l);
}

}
