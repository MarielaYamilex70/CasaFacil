package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelos.Tarea;
import modelos.Usuario;
import modelos.UsuarioTarea;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import gestion.TareaDAO;
import gestion.UsuarioDAO;
import gestion.UsuarioTareaDAO;

/**
 * Servlet implementation class ListarTareasServlet
 */
@WebServlet("/ListarTareasServlet")
public class ListarTareasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * private TareaDAO tareaDAO;
	 * 
	 * public void init() { tareaDAO = new TareaDAO( DatabaseUtils.setConnection());
	 * }
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// Obtener la lista de tareas desde la base de datos
			TareaDAO tareaDAO = new TareaDAO();
			List<Tarea> listaTareas = tareaDAO.obtenerTodasLasTareas();
			// Poner la lista de tareas como atributo en la petición
			request.setAttribute("tareas", listaTareas);

			// Obtener la lista de usuarios desde la base de datos
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			List<Usuario> usuarios = usuarioDAO.obtenerTodosLosUsuarios();
			// Poner la lista de usuarios como atributo en la petición
			request.setAttribute("usuarios", usuarios);

			/*
			 * // Obtener la lista de la relacion desde la base de datos UsuarioTareaDAO
			 * usuarioTareaDAO = new UsuarioTareaDAO(); List<UsuarioTarea> usuariostareas =
			 * usuarioTareaDAO.obtenerTodasLasRealaciones(); // Poner la lista de
			 * usuariostareas como atributo en la petición
			 * request.setAttribute("usuariostareas", usuariostareas);
			 */

			request.getRequestDispatcher("listarTareas.jsp").forward(request, response);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
