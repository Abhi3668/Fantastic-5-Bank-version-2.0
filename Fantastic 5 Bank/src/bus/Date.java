package bus;

public class Date {
	private int month;
	private int year;
	private int day;
		
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	public Date(int month, int year, int day) {
		
		this.month = month;
		this.year = year;
		this.day = day;
	}
	
public Date() {
		
		this.month = 0;
		this.year = 0;
		this.day =0;
	}
@Override
public String toString() {
	return "Date [\nmonth=" + month + "\nyear=" + year + "\nday=" + day + "]";
}	
	
	

}


