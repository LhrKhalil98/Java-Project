package Data;
import java.sql.* ; 
public class SingleConnection {
	private static Connection connection ; 
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/stock" , "root" , ""); 
			System.out.println("connection success") ; 
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace(); 	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		return connection ; 
	}


}
