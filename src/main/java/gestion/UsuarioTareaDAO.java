package gestion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import conectores.DatabaseUtils;
import modelos.Tarea;
import modelos.Usuario;
import modelos.UsuarioTarea;

public class UsuarioTareaDAO {

	private Connection connection;

	public UsuarioTareaDAO() throws SQLException {
		this.connection = DatabaseUtils.setConnection();
	}

	// Asignar tarea a un usuario
	public void asignarTarea(Usuario usuario, Tarea tarea) {
		String sql = "INSERT INTO usuario_tarea (usuario_id, tarea_id) VALUES (?, ?)";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, usuario.getId());
			statement.setInt(2, tarea.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Obtener todas las tareas asignadas a un usuario
	public List<UsuarioTarea> obtenerTareasPorUsuario(int usuarioId) {
		System.out.println("usuarioId-> " + usuarioId);
		List<UsuarioTarea> tareas = new ArrayList<>();
		String sql = "SELECT ut.id, t.nombre, ut.estado, ut.fecha_asignacion FROM usuario_tarea ut "
				+ "JOIN tareas t ON ut.tarea_id = t.id WHERE ut.usuario_id = ?";

		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, usuarioId);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String nombreTarea = resultSet.getString("nombre");
				String estado = resultSet.getString("estado");
				Timestamp fechaAsignacion = resultSet.getTimestamp("fecha_asignacion");

				Tarea tarea = new Tarea();
				tarea.setNombre(nombreTarea);

				UsuarioTarea usuarioTarea = new UsuarioTarea(id, new Usuario(usuarioId), tarea, estado,
						fechaAsignacion);
				tareas.add(usuarioTarea);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return tareas;
	}

	// Actualizar estado de la tarea
	public void actualizarEstadoTarea(int id, String nuevoEstado) {
		String sql = "UPDATE usuario_tarea SET estado = ? WHERE id = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setString(1, nuevoEstado);
			statement.setInt(2, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Eliminar relación usuario-tarea por id de la relacion
	public void eliminarAsignacion(int id) {
		String sql = "DELETE FROM usuario_tarea WHERE id = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Eliminar relación usuario-tarea por id del usuario y de la tarea
	public void eliminarAsignacionPorUsuarioYTarea(int usuarioId, int tareaId) {
		String sql = "DELETE FROM usuario_tarea WHERE usuario_id = ? AND tarea_id = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, usuarioId);
			statement.setInt(2, tareaId);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Obtener una relación usuario-tarea por su ID
	public UsuarioTarea obtenerUsuarioTareaPorId(int usuarioTareaId) {
		UsuarioTarea usuarioTarea = null;
		String sql = "SELECT ut.id, ut.usuario_id, ut.tarea_id, ut.estado, ut.fecha_asignacion, u.nombre AS usuario_nombre, t.nombre AS tarea_nombre "
				+ "FROM usuario_tarea ut " + "JOIN usuarios u ON ut.usuario_id = u.id "
				+ "JOIN tareas t ON ut.tarea_id = t.id " + "WHERE ut.id = ?";

		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, usuarioTareaId);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				int id = resultSet.getInt("id");
				int usuarioId = resultSet.getInt("usuario_id");
				int tareaId = resultSet.getInt("tarea_id");
				String estado = resultSet.getString("estado");
				Timestamp fechaAsignacion = resultSet.getTimestamp("fecha_asignacion");

				String usuarioNombre = resultSet.getString("usuario_nombre");
				String tareaNombre = resultSet.getString("tarea_nombre");

				Usuario usuario = new Usuario(usuarioId);
				usuario.setNombre(usuarioNombre);

				Tarea tarea = new Tarea();
				tarea.setId(tareaId);
				tarea.setNombre(tareaNombre);

				usuarioTarea = new UsuarioTarea(id, usuario, tarea, estado, fechaAsignacion);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usuarioTarea;
	}

	// Obtener una relación usuario-tarea por su ID de Tarea
	public UsuarioTarea obtenerUsuarioTareaPorTarea(int TareaId) {
		UsuarioTarea usuarioTarea = null;
		String sql = "SELECT * FROM usuario_tarea  WHERE tarea_id = ?";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, TareaId);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				int id = resultSet.getInt("id");
				int usuarioId = resultSet.getInt("usuario_id");
				int tareaId = resultSet.getInt("tarea_id");
				String estado = resultSet.getString("estado");
				Timestamp fechaAsignacion = resultSet.getTimestamp("fecha_asignacion");

				// String usuarioNombre = resultSet.getString("usuario_nombre");
				// String tareaNombre = resultSet.getString("tarea_nombre");

				Usuario usuario = new Usuario(usuarioId);
				// usuario.setNombre(usuarioNombre);

				Tarea tarea = new Tarea();
				tarea.setId(tareaId);
				// tarea.setNombre(tareaNombre);

				usuarioTarea = new UsuarioTarea(id, usuario, tarea, estado, fechaAsignacion);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarioTarea;

	}

	// Obtener todas las relación usuario-tarea
	public List<UsuarioTarea> obtenerTodasLasRealaciones() {

		List<UsuarioTarea> usuariostareas = new ArrayList<>();

		String sql = "SELECT * FROM usuario_tarea  ";

		try (PreparedStatement statement = connection.prepareStatement(sql)) {

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				int usuarioId = resultSet.getInt("usuario_id");
				int tareaId = resultSet.getInt("tarea_id");
				String estado = resultSet.getString("estado");
				Timestamp fechaAsignacion = resultSet.getTimestamp("fecha_asignacion");

				Usuario usuario = new Usuario(usuarioId);

				Tarea tarea = new Tarea();
				tarea.setId(tareaId);

				UsuarioTarea usuarioTarea = new UsuarioTarea(id, usuario, tarea, estado, fechaAsignacion);

				usuariostareas.add(usuarioTarea);

				System.out.println("Tarea -> obtenerTodasLasRelaciones" + usuarioTarea.toString());

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuariostareas;

	}

	// Método para obtener el ID del usuario asignado a una tarea
	public int obtenerUsuarioIdPorTarea(int tareaId) {
		String sql = "SELECT usuario_id FROM usuario_tarea WHERE tarea_id = ?";
		int usuarioId = -1;

		try {

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, tareaId);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				usuarioId = resultSet.getInt("usuario_id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usuarioId;
	}

	// Método para actualizar el usuario asociado a una tarea en la tabla/relacion
	// usuario_tarea
	public void actualizarUsuarioID(int TareaId, int nuevoUsuarioId) {
		// si queremos hacer le en el tiempo tiene que venir tambien el id de la
		// relacion
		String sql = "UPDATE usuario_tarea SET usuario_id = ?, estado='pendiente', fecha_asignacion = NULL  WHERE tarea_id = ? ; ";

		/*
		 * String sql =
		 * "UPDATE usuario_tarea SET usuario_id = ?`, estado`='pendiente'  WHERE tarea_id = ? ; "
		 * + " UPDATE tareas SET estado = 'Pendiente'  WHERE id = ? ;"; //String sql =
		 * "UPDATE usuario_tarea SET usuario_id = ?  WHERE tarea_id = ?; ";
		 */

		System.out.println("********New Consulta -> " + sql);
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, nuevoUsuarioId); // Nuevo ID de usuario
			statement.setInt(2, TareaId); // ID de tarea de la relación usuario_tarea
			// statement.setInt(3, TareaId);

			int filasActualizadas = statement.executeUpdate();
			if (filasActualizadas > 0) {
				System.out.println("Usuario asociado a la tarea actualizado con éxito.");
			} else {
				System.out.println("No se encontró ninguna relación usuario-tarea con el ID especificado.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
