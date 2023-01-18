package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionDB {//DBConnection
	private static Connection myConnection = null;

	public static Connection ConnDB() throws SQLException{
		 ResourceBundle rb = ResourceBundle.getBundle("orcale");

	        String url = rb.getString("db.url");
	System.out.println(url);
	        String username = rb.getString("db.username");
	System.out.println(username);
	        String password = rb.getString("db.password");
			//String service = "localhost";
			
			
			myConnection = DriverManager.getConnection(url,username,password);
		   	return myConnection;
			
			
		}

}
