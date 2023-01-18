package bus;

import java.sql.SQLException;

import Data.CheckingDB;
import Data.SavingDB;

public class Checking extends Account {
	private long ch_number;
	private float ch_balance;
	private char ch_fee;
	 
	public long getCh_number() {
		return ch_number;
	}
	public void setCh_number(int ch_number) {
		this.ch_number = ch_number;
	}
	
	public float getCh_balance() {
		return ch_balance;
	}
	public void setCh_balance(float ch_balance) {
		this.ch_balance = ch_balance;
	}
	public char getCh_fee() {
		return ch_fee;
	}
	public void setCh_fee(char ch_fee) {
		this.ch_fee = ch_fee;
	}
	public Checking(int ac_number, int pin, Date ac_opendate, float balance,
			enumAccType ac_type, int ac_id, int ch_number,
			float ch_balance, char ch_fee) {
		super(ac_number, pin, ac_opendate, balance, ac_type, ac_id);
		this.ch_number = ch_number;
		this.ch_balance = ch_balance;
		this.ch_fee = ch_fee;
	}
	public Checking(int ac_number, int pin, Date ac_opendate, float balance,
			enumAccType ac_type, int ac_id) {
		super(ac_number, pin, ac_opendate, balance, ac_type, ac_id);
		
		this.ch_number = ch_number;
		this.ch_balance = ch_balance;
		this.ch_fee = ch_fee;
		}
	public Checking() {
		super();
		this.ch_number = 0;
		this.ch_balance = 0;
		this.ch_fee = ' ';
	}
	
	public String toString() {
		return "Checking [ch_number=" + ch_number + ", ch_balance=" + ch_balance + ", ch_fee=" + ch_fee + "]";
	}
	
	
	public static Checking DisplayAll(long l) throws SQLException{
		
		return CheckingDB.DisplayAll(l);
	}
	public static void Update(Checking che) throws SQLException{
		CheckingDB.Update(che);
	}
	public static Account CusXAcc(long l) throws SQLException{
		return CheckingDB.CusXAcc(l);
	}
	public static int CheByAcc(int acc) throws SQLException{
		return CheckingDB.CheByAcc(acc);}
}

