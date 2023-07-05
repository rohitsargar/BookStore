package bookstore.helper;
import java.sql.*;

public class ConnectionProvider {
	private static Connection con;
	public static Connection getConnection() {
		
		try {
			if(con==null){
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/bookstore","root","");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return con;
		
	}

}
