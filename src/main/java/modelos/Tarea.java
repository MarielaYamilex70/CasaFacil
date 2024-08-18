package modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conectores.DatabaseUtils;

public class Tarea {
	private int id;
	private String nombre;
	private String descripcion;
	private int puntuacion;
	private boolean esObligatoria;
	private String ciclo;
	private String estado;

	// Constructor
	public Tarea(String nombre, String descripcion, int puntuacion, boolean esObligatoria, String ciclo,
			String estado) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.puntuacion = puntuacion;
		this.esObligatoria = esObligatoria;
		this.ciclo = ciclo;
		this.estado = estado;

	}

	public Tarea() {
		System.out.println(" Soy un Objeto Tarea....");
	}

	public Tarea(int id, String nombre, String descripcion, int puntuacion, boolean esObligatoria, String ciclo,
			String estado) {

		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.puntuacion = puntuacion;
		this.esObligatoria = esObligatoria;
		this.ciclo = ciclo;
		this.estado = estado;
	}

	// Getters y Setters

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	public boolean isEsObligatoria() {
		return esObligatoria;
	}

	public void setEsObligatoria(boolean esObligatoria) {
		this.esObligatoria = esObligatoria;
	}

	public String getCiclo() {
		return ciclo;
	}

	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return nombre + " - Descripcion: " + descripcion + " - Puntos: " + puntuacion + " - Obligatoria: "
				+ (esObligatoria ? "Sí" : "No") + " - Ciclo: " + ciclo + " - Estado: " + estado;
	}

	// Método para obtener el ID del usuario asignado a una tarea
	/*
	 * public int obtenerUsuarioIdPorTarea() { String sql =
	 * "SELECT usuario_id FROM usuario_tarea WHERE tarea_id = ?"; int usuarioId =
	 * -1;
	 * 
	 * Connection connection = null;
	 * 
	 * try {
	 * 
	 * // Conexion a la BBDD connection = DatabaseUtils.setConnection();
	 * PreparedStatement statement = connection.prepareStatement(sql);
	 * statement.setInt(1, this.id); ResultSet resultSet = statement.executeQuery();
	 * 
	 * if (resultSet.next()) { usuarioId = resultSet.getInt("usuario_id"); } } catch
	 * (SQLException e) { e.printStackTrace(); }
	 * 
	 * return usuarioId; }
	 */

}
