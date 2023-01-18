package bus;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Data.AccountDB;
import Data.ConnectionDB;

public class Account {
	private int ac_number;
	private int pin;
	private Date ac_opendate;
	private float balance;
	private enumAccType ac_type;
	private int ac_id;
	
	
	public int getAc_id() {
		return ac_id;
	}
	public void setAc_id(int ac_id) {
		this.ac_id = ac_id;
	}
	public int getAccNo() {
		return ac_number;
	}
	public void setAccNo(int accNo) {
		this.ac_number = accNo;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public Date getDate() {
		return ac_opendate;
	}
	public void setDate(Date date) {
		this.ac_opendate = date;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public enumAccType getType() {
		return ac_type;
	}
	public void setType(enumAccType type) {
		this.ac_type = type;
	}
	public Account(int ac_number, int pin, Date ac_opendate, float balance,
			enumAccType ac_type, int ac_id) {
		
		this.ac_number = ac_number;
		this.pin = pin;
		this.ac_opendate = ac_opendate;
		this.balance = balance;
		this.ac_type = ac_type;
		this.ac_id = ac_id;
	}
	public Account() {
		this.ac_number = 0;
		this.pin = 0;
		this.ac_opendate =null;
		this.balance = 0;
		this.ac_type = enumAccType.Undefined;
		this.ac_id = 0;
	}
	@Override
	public String toString() {
		return "Account [ac_number=" + ac_number + ", pin=" + pin
				+ ", ac_opendate=" + ac_opendate + ", balance=" + balance
				+ ", ac_type=" + ac_type + ", ac_id=" + ac_id + "]";
	}

	public static Account DisplayAll(long l) throws SQLException{
		return AccountDB.DisplayAll( l);
	}
	
	

}
