package gestion;

public class AspirarCasa extends Tareas {

	public AspirarCasa(int puntuacion, boolean esObligatoria) {
		super("Aspirar la Casa", puntuacion, esObligatoria);
	}

	@Override
	public void realizarTarea() {
		System.out.println("Realizando tarea: Aspirar la Casa");
		// Lógica específica de la tarea, si es necesario
	}

}
