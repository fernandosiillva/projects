package cap1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection getConnection() {		
		try {			
			Connection c = DriverManager.getConnection("jdbc:mysql//localhost/banco","root","123");
			return c;
		} catch (SQLException e) {
			throw new RuntimeException(e);  
		}
	}
}
