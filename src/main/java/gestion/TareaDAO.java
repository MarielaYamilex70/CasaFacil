package gestion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conectores.DatabaseUtils;
import modelos.Tarea;

public class TareaDAO {

	public TareaDAO() {
		System.out.println(" Soy un Objeto TareaDAO ");
	}

	/*
	 * private Connection connection;
	 * 
	 * public TareaDAO(Connection conexion) throws SQLException { this.connection =
	 * DatabaseUtils.setConnection(); }
	 */

	public void addTarea() {
		System.out.println(" Soy un Objeto TareaDAO ");

	}

	// Método para añadir una tarea a la base de datos
	public void addTarea(Tarea tarea) {
		String sql = "INSERT INTO tareas (nombre, descripcion, puntuacion, obligatoria, ciclo, estado) VALUES (?, ?, ?, ?, ?, ?)";
		System.out.println("Add Tarea: " + tarea.getNombre() + " - Descripcion: " + tarea.getDescripcion()
				+ " - Puntos: " + tarea.getPuntuacion() + " - Obligatoria: " + tarea.isEsObligatoria() + " - Ciclo: "
				+ tarea.getCiclo() + " - Estado: " + tarea.getEstado());

		//Connection connection = null;

		try {
			// Conexion a la BBDD
			Connection connection = DatabaseUtils.setConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(sql);

			System.out.println("Add Tarea: " + tarea.getNombre() + " - Descripcion: " + tarea.getDescripcion()
					+ " - Puntos: " + tarea.getPuntuacion() + " - Obligatoria: " + tarea.isEsObligatoria()
					+ " - Ciclo: " + tarea.getCiclo() + " - Estado: " + tarea.getEstado());

			// Establecer los parámetros desde el objeto Tarea
			preparedStatement.setString(1, tarea.getNombre());
			preparedStatement.setString(2, tarea.getDescripcion());
			preparedStatement.setInt(3, tarea.getPuntuacion());
			preparedStatement.setBoolean(4, tarea.isEsObligatoria());
			preparedStatement.setString(5, tarea.getCiclo());
			preparedStatement.setString(6, tarea.getEstado());

			System.out.println(preparedStatement.toString());

			// Ejecutar la actualización
			preparedStatement.executeUpdate();

			System.out.println("Tarea añadida con éxito.");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Tarea> obtenerTodasLasTareas() {
		List<Tarea> tareas = new ArrayList<>();
		String sql = "SELECT * FROM tareas";

		System.out.println("sql-> " + sql);

		try (Connection connection = DatabaseUtils.setConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {
			ResultSet resultSet = statement.executeQuery();

			System.out.println("Estoy en -> obtenerTodasLasTareas");

			while (resultSet.next()) {
				Tarea tarea = new Tarea();
				tarea.setId(resultSet.getInt("id"));
				tarea.setNombre(resultSet.getString("nombre"));
				tarea.setDescripcion(resultSet.getString("descripcion"));
				tarea.setPuntuacion(resultSet.getInt("puntuacion"));
				tarea.setEsObligatoria(resultSet.getBoolean("obligatoria"));
				tarea.setCiclo(resultSet.getString("ciclo"));
				tarea.setEstado(resultSet.getString("estado"));
				tareas.add(tarea);
				System.out.println("Tarea -> obtenerTodasLasTareas" + tarea.toString());

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return tareas;
	}

	// Método para actualizar una tarea en la base de datos
	public boolean actualizarTarea(int id, Tarea tarea) {
		String sql = "UPDATE tareas SET nombre = ?, descripcion = ?, puntuacion = ?, obligatoria = ?, ciclo = ?, estado = ? WHERE id = ?";
		//Connection connection = null;

		try {
			// Conexion a la BBDD
			Connection connection = DatabaseUtils.setConnection();

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, tarea.getNombre());
			statement.setString(2, tarea.getDescripcion());
			statement.setInt(3, tarea.getPuntuacion());
			statement.setBoolean(4, tarea.isEsObligatoria());
			statement.setString(5, tarea.getCiclo());
			statement.setString(6, tarea.getEstado());
			statement.setInt(7, id);

			int filasActualizadas = statement.executeUpdate();
			return filasActualizadas > 0; // Devuelve true si se actualizó al menos una fila

		} catch (SQLException e) {
			e.printStackTrace();
			return false; // Devuelve false si hubo un error
		}

	}

	// Método para obtener una tarea por nombre
	public Tarea obtenerTareaPorNombre(String nombre) {
		Tarea tarea = null;
		String sql = "SELECT * FROM tareas WHERE nombre = ?";

		//Connection connection = null;

		try {
			// Conexion a la BBDD
			Connection connection = DatabaseUtils.setConnection();
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, nombre);

			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				int id = resultSet.getInt("id");
				String descripcion = resultSet.getString("descripcion");
				int puntuacion = resultSet.getInt("puntuacion");
				boolean esObligatoria = resultSet.getBoolean("obligatoria");
				String ciclo = resultSet.getString("ciclo");
				String estado = resultSet.getString("estado");

				// tarea = new Tarea(nombre, descripcion, puntuacion, esObligatoria, ciclo,
				// estado);
				tarea = new Tarea(id, nombre, descripcion, puntuacion, esObligatoria, ciclo, estado);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return tarea;
	}

	// Método para obtener una tarea por ID
	public Tarea obtenerTareaPorId(int id) {

		System.out.println("obtenerTareaPorId -> ID: " + id);
		Tarea tarea = null;
		String sql = "SELECT * FROM tareas WHERE id = ?";

		//Connection connection = null;

		try {
			// Conexion a la BBDD
			Connection connection = DatabaseUtils.setConnection();

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);

			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				String nombre = resultSet.getString("nombre");
				String descripcion = resultSet.getString("descripcion");
				int puntuacion = resultSet.getInt("puntuacion");
				boolean esObligatoria = resultSet.getBoolean("obligatoria");
				String ciclo = resultSet.getString("ciclo");
				String estado = resultSet.getString("estado");
				// boolean esCompletada = resultSet.getBoolean("esCompletada");

				tarea = new Tarea(id, nombre, descripcion, puntuacion, esObligatoria, ciclo, estado);
				System.out.println(" Soy un Objeto Tarea -> " + tarea.toString());

				// tarea = new Tarea(nombre, esObligatoria);
				// if (esCompletada) {
				// tarea.completarTarea();
				// }
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return tarea;
	}

	// Método para obtener el ID de una tarea por su nombre
	public Integer obtenerIdPorNombre(String nombre) {
		Integer id = null;
		String sql = "SELECT id FROM tareas WHERE nombre = ?";

		//Connection connection = null;

		try {
			// Conexion a la BBDD
			Connection connection = DatabaseUtils.setConnection();

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, nombre);

			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				id = resultSet.getInt("id");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return id;
	}

	// Método para borrar una tarea por su ID
	public boolean borrarTarea(int id) {
		String sql = "DELETE FROM tareas WHERE id = ?";

       //Connection connection = null;

		try {
			// Conexion a la BBDD
			Connection connection = DatabaseUtils.setConnection();

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);

			int filasBorradas = statement.executeUpdate();
			return filasBorradas > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
