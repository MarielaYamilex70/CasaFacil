package gestion;

public abstract class Tareas {

	private String nombre;
	private int puntuacion;
	private boolean esObligatoria;

	public Tareas(String nombre, int puntuacion, boolean esObligatoria) {
		this.nombre = nombre;
		this.puntuacion = puntuacion;
		this.esObligatoria = esObligatoria;
	}

	public String getNombre() {
		return nombre;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public boolean esObligatoria() {
		return esObligatoria;
	}

	public abstract void realizarTarea(); // Método abstracto que será implementado por las subclases

	@Override
	public String toString() {
		return nombre + " - Puntos: " + puntuacion + " - Obligatoria: " + (esObligatoria ? "Sí" : "No");
	}

}
