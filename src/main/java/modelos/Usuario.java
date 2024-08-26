package modelos;

public class Usuario {
	private int id;
	private String nombre;
	private String email;
	private String pwd;
	private int puntuacion;

	// Constructor sin id
	public Usuario(String nombre, String email, String pwd, int puntuacion) {
		this.nombre = nombre;
		this.email = email;
		this.pwd = pwd;
		this.puntuacion = puntuacion;
	}

	// Constructor sin pwd
	public Usuario(int id, String nombre, String email, int puntuacion) {
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.puntuacion = puntuacion;
	}

	// Constructor solo id
	public Usuario(int id) {
		this.id = id;

	}

	// Constructor con todos los atributos
	public Usuario(int id, String nombre, String email, String pwd, int puntuacion) {

		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.pwd = pwd;
		this.puntuacion = puntuacion;
	}

	// Getters y Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	// Método para representar al usuario como una cadena
	@Override
	public String toString() {
		return "Usuario{" + "id='" + id + '\'' + "nombre='" + nombre + '\'' + ", email='" + email + '\''
				+ ", puntuacion=" + puntuacion + '}';
	}

}
