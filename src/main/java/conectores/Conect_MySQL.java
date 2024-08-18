package conectores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class Conect_MySQL {

	private static String url = "jdbc:mysql://localhost:3307/test";
	private static String user = "maryam";
	private static String password = "WR__so[B5k0ogkf7";

	public Conect_MySQL() {

		try {
			// Establece la conexión
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("Conexión establecida.");

			// Crea una sentencia SQL
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM clientes";

			// Ejecuta la consulta
			ResultSet rs = stmt.executeQuery(sql);

			// Procesa los resultados
			while (rs.next()) {
				System.out.println("Columna 1: " + rs.getString(1));
				System.out.println("Columna 2: " + rs.getString(2));
			}

			// Cierra la conexión
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Cierra la conexión

		}
	}

	/*
	 * public static Connection setConnection() throws SQLException{ return
	 * DriverManager.getConnection(url, user, password); }
	 * 
	 * public static void closeConnection(){
	 * 
	 * }
	 * 
	 * // Método para ejecutar una consulta y devolver el ResultSet public static
	 * ResultSet executeQuery(String query) { Connection connection = null;
	 * Statement statement = null; ResultSet resultSet = null;
	 * 
	 * try { // Cargar el controlador de MySQL
	 * Class.forName("com.mysql.cj.jdbc.Driver");
	 * 
	 * // Crear la conexión connection = DriverManager.getConnection(url, user,
	 * password);
	 * 
	 * // Crear una declaración statement = connection.createStatement();
	 * 
	 * // Ejecutar la consulta y obtener el ResultSet resultSet =
	 * statement.executeQuery(query);
	 * 
	 * // Nota: No cerrar el connection, statement y resultSet aquí porque el
	 * resultSet se devuelve return resultSet; } catch (SQLException |
	 * ClassNotFoundException e) { e.printStackTrace(); }
	 * 
	 * // En caso de error, devolver null return null; }
	 */

}
