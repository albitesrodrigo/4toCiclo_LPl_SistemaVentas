package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlDBConexion {

	public static Connection getConexion() {
		Connection cn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost/mibdventas", "root", "81434345Br");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return cn;
	}
}