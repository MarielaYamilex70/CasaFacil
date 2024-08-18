package gestion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conectores.DatabaseUtils;
import modelos.Usuario;

public class UsuarioDAO {

	private Connection conexion;

	public UsuarioDAO() throws SQLException {
		this.conexion = DatabaseUtils.setConnection();
	}

	// Método para adicionar un usuario a la base de datos
	public boolean addUsuario(Usuario usuario) throws SQLException {
		String sql = "INSERT INTO usuarios (nombre, email, pwd, puntuacion) VALUES (?, ?, ?, ?)";

		try (PreparedStatement statement = conexion.prepareStatement(sql)) {
			statement.setString(1, usuario.getNombre());
			statement.setString(2, usuario.getEmail());
			statement.setString(3, usuario.getPwd());
			statement.setInt(4, usuario.getPuntuacion());

			int filasInsertadas = statement.executeUpdate();

			if (filasInsertadas == 0) {
				throw new SQLException("El usuario con el email " + usuario.getEmail() + " ya existe.");
			}

			return filasInsertadas > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// Método para modificar un usuario existente
	public boolean modiUsuario(int id, Usuario usuario) {
		String sql = "UPDATE usuarios SET nombre = ?, email = ?, pwd = ?, puntuacion = ? WHERE id = ?";
		System.out.println(" Soy un Objeto Usuario -> " + usuario.toString());

		try (PreparedStatement statement = conexion.prepareStatement(sql)) {
			statement.setString(1, usuario.getNombre());
			statement.setString(2, usuario.getEmail());
			statement.setString(3, usuario.getPwd());
			statement.setInt(4, usuario.getPuntuacion());
			statement.setInt(5, id);

			int filasActualizadas = statement.executeUpdate();
			return filasActualizadas > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// Método para obtener un usuario por su ID
	public Usuario obtenerUsuario(String email, String pwd) {
		Usuario usuario = null;
		String sql = "SELECT * FROM usuarios WHERE email = ? AND pwd= ?";

		try (PreparedStatement statement = conexion.prepareStatement(sql)) {
			statement.setString(1, email);
			statement.setString(2, pwd);

			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				String nombre = resultSet.getString("nombre");
				// String email = resultSet.getString("email");
				// String pwd = resultSet.getString("pwd");
				int puntuacion = resultSet.getInt("puntuacion");

				usuario = new Usuario(nombre, email, pwd, puntuacion);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usuario;
	}

	// Método para borrar un usuario por su ID
	public boolean borrarUsuario(int id) {
		String sql = "DELETE FROM usuarios WHERE id = ?";

		try (PreparedStatement statement = conexion.prepareStatement(sql)) {
			statement.setInt(1, id);

			int filasBorradas = statement.executeUpdate();
			return filasBorradas > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// Método para obtener el ID de un usuario a partir de su email
	public Usuario obtenerUsuarioPorId(int id) {

		System.out.println("ID Usuario -> " + id);
		Usuario usuario = null;
		String sql = "SELECT * FROM usuarios WHERE id = ?";

		try (PreparedStatement statement = conexion.prepareStatement(sql)) {
			statement.setInt(1, id);

			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				String nombre = resultSet.getString("nombre");
				String email = resultSet.getString("email");
				String pwd = resultSet.getString("pwd");
				int puntuacion = resultSet.getInt("puntuacion");

				usuario = new Usuario(id, nombre, email, pwd, puntuacion);
				System.out.println(" Soy un Objeto Usuario -> " + usuario.toString());

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return usuario;
	}

	public List<Usuario> obtenerTodosLosUsuarios() {
		List<Usuario> usuarios = new ArrayList<>();
		String sql = "SELECT id, nombre, email, puntuacion FROM usuarios";

		try (PreparedStatement statement = conexion.prepareStatement(sql);
				ResultSet resultSet = statement.executeQuery()) {

			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String nombre = resultSet.getString("nombre");
				String email = resultSet.getString("email");
				int puntuacion = resultSet.getInt("puntuacion");

				Usuario usuario = new Usuario(id, nombre, email, puntuacion);
				usuarios.add(usuario);

				System.out.println(" Soy un Objeto Usuario -> " + usuario.toString());

			}
		} catch (SQLException e) {
			e.printStackTrace();
			// Manejo de errores, podrías lanzar una excepción personalizada
		}

		return usuarios;
	}

}
