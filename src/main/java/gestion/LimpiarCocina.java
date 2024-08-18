package gestion;

public class LimpiarCocina extends Tareas {

	public LimpiarCocina(int puntuacion, boolean esObligatoria) {
		super("Limpiar la Cocina", puntuacion, esObligatoria);
	}

	@Override
	public void realizarTarea() {
		System.out.println("Realizando tarea: Limpiar la Cocina");
		// Agregar la lógica específica de la tarea
	}

}
