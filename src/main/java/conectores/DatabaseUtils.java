package conectores;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.util.Properties;

//import main.ConfigLoader;

public class DatabaseUtils {

	// Datos de conexión
	
	private static final String URL = ConfigLoader.getProperty("db.url");
	private static final String USERNAME = ConfigLoader.getProperty("db.user");
	private static final String PASSWORD = ConfigLoader.getProperty("db.password");

	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;

	public static boolean isValidUser(String username, String password) {
		boolean isValid = false;
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				PreparedStatement ps = conn
						.prepareStatement("SELECT COUNT(*) FROM users WHERE username = ? AND password = ?")) {
			ps.setString(1, username);
			ps.setString(2, password);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next() && rs.getInt(1) > 0) {
					isValid = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isValid;
	}

	// Método para establecer la conexión
	public static Connection setConnection() throws SQLException {
		if (connection == null || connection.isClosed()) {

			return DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} else {
			return connection;
		}
	}

	// Método para cerrar la conexión, el statement y el resultSet
	
	/*
	 * A partir de Java 7, se introdujo la estructura try-with-resources, que
	 * facilita la gestión de recursos que implementan la interfaz AutoCloseable
	 * (que incluye Closeable, la cual es implementada por muchas clases de I/O y
	 * conexiones). 
	 * 
	 * try (Connection connection = DriverManager.getConnection(url, user, password)) 
	 * { 
	 * 		// Usa la conexión aquí 
	 * 
	 * } catch (SQLException e) {
	 * 		e.printStackTrace(); 
	 * 
	 * } 
	 * // La conexión se cierra automáticamente al salir del bloque try
	 */
	
	public static void closeConnection(ResultSet resultSet, Statement statement, Connection connection) {

		try {
			// if (resultSet != null || !resultSet.isClosed()) resultSet.close();
			if (resultSet != null)
				resultSet.close();
			// if (statement != null || !statement.isClosed()) statement.close();
			if (statement != null)
				statement.close();
			// if (connection != null || !statement.isClosed()) connection.close();
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Método para ejecutar una consulta y devolver el ResultSet
	public static ResultSet executeQuery(String query) {
		
		try {

			// Crear la conexión si no existe
			if (connection == null || connection.isClosed()) {
				connection = setConnection();
			}
			// Crear una declaración
			statement = connection.createStatement();

			// Ejecutar la consulta y obtener el ResultSet
			resultSet = statement.executeQuery(query);

			return resultSet;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	
}
