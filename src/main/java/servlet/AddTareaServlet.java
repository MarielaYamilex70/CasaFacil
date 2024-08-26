package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelos.Tarea;

import java.io.IOException;

import gestion.TareaDAO;

/**
 * Servlet implementation class AddTareaServlet
 */
@WebServlet("/AddTareaServlet")
public class AddTareaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// private TareaDAO tareaDAO;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idStr = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		int puntuacion = Integer.parseInt(request.getParameter("puntuacion"));
		boolean esObligatoria = request.getParameter("esObligatoria") != null;
		String ciclo = request.getParameter("ciclo");
		String estado = request.getParameter("estado");

		
		Tarea tarea = new Tarea(nombre, descripcion, puntuacion, esObligatoria, ciclo, estado);

		System.out.println("Nueva Tarea: " + tarea.toString());

		TareaDAO tareaDAO = new TareaDAO();

		if (idStr == null || idStr.isEmpty()) {
			// Adicionar nueva tarea
			tareaDAO.addTarea(tarea);
		} else {
			// Modificar tarea existente
			int id = Integer.parseInt(idStr);
			tareaDAO.actualizarTarea(id, tarea);
		}

		// Redirigir a la página principal o mostrar un mensaje de éxito
		response.sendRedirect("ListarTareasServlet");
	}

}
