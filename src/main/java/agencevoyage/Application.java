package agencevoyage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Application {
	private static Application instance = null;
	
	private String jdbcUrl = "jdbc:postgresql://localhost:5432/Vol";
	private String jdbcUser = "postgres";
	private String jdbcPassword = "admin";
	
	private Application() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Application getInstance() {
		if(instance == null) {
			instance = new Application();
		}
		
		return instance;
	}
	
	public Connection createConnection() throws SQLException {
		return DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
	}
}
