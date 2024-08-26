package servlet;

import jakarta.servlet.RequestDispatcher;
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

@WebServlet("/ModiTareaServlet")
public class ModiTareaServlet extends HttpServlet {
	// private TareaDAO tareaDAO;

	/*
	 * public void init() { tareaDAO = new TareaDAO(ConexionBD.getConnection()); }
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Obtener el ID de la tarea desde la URL
		int id = Integer.parseInt(request.getParameter("id"));

		response.setContentType("text/html");
		response.getWriter().println("<html><body>");
		response.getWriter().println("<h2>ModiTareaServlet</h2>");
		response.getWriter().println("<p>ID: " + id + "</p>");
		response.getWriter().println("</body></html>");

		
		TareaDAO tareaDAO = new TareaDAO();

		// Obtener la tarea desde la base de datos
		Tarea tarea = tareaDAO.obtenerTareaPorId(id);

		// Pasar la tarea como atributo a la JSP
		request.setAttribute("tarea", tarea);

		// Redirigir a la página de modificación de tarea
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/modiTarea.jsp");
		dispatcher.forward(request, response);
	}
}
