package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelos.Tarea;

import java.io.IOException;
import java.util.List;

import conectores.DatabaseUtils;
import gestion.TareaDAO;

@WebServlet("/BorrarTareaServlet")
public class BorrarTareaServlet extends HttpServlet {
	// private TareaDAO tareaDAO;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Obtener el ID de la tarea desde el parámetro de la URL
		int id = Integer.parseInt(request.getParameter("id"));

		TareaDAO tareaDAO = new TareaDAO();

		// Borrar la tarea de la base de datos
		tareaDAO.borrarTarea(id);

		// Redirigir a la página principal o mostrar un mensaje de éxito
		response.sendRedirect("ListarTareasServlet");
	}
}
