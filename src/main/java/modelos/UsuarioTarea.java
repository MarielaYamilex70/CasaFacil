package modelos;

import java.sql.Timestamp;

public class UsuarioTarea {
	private int id;
	private Usuario usuario;
	private Tarea tarea;
	private String estado; // pendiente, en_progreso, completado, etc.
	private Timestamp fechaAsignacion;

	// Constructor con todos los atributos
	public UsuarioTarea(int id, Usuario usuario, Tarea tarea, String estado, Timestamp fechaAsignacion) {

		this.id = id;
		this.usuario = usuario;
		this.tarea = tarea;
		this.estado = estado;
		this.fechaAsignacion = fechaAsignacion;

	}

	// Constructor sin id
	public UsuarioTarea(Usuario usuario, Tarea tarea, String estado, Timestamp fechaAsignacion) {

		this.usuario = usuario;
		this.tarea = tarea;
		this.estado = estado;
		this.fechaAsignacion = fechaAsignacion;

	}

	// getters y setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Tarea getTarea() {
		return tarea;
	}

	public void setTarea(Tarea tarea) {
		this.tarea = tarea;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Timestamp getFechaAsignacion() {
		return fechaAsignacion;
	}

	public void setFechaAsignacion(Timestamp fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion;
	}

	@Override
	public String toString() {
		return " ID: " + id + " - ID Usuario: " + usuario.getId() + " - ID Tarea: " + tarea.getId();
	}

}
