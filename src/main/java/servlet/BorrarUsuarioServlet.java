package servlet;

import java.io.IOException;
import java.sql.SQLException;

import gestion.TareaDAO;
import gestion.UsuarioDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/BorrarUsuarioServlet")
public class BorrarUsuarioServlet extends HttpServlet {
	// private TareaDAO tareaDAO;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Obtener el ID de la tarea desde el parámetro de la URL
		int id = Integer.parseInt(request.getParameter("id"));

		UsuarioDAO usuarioDAO = null;
		try {
			usuarioDAO = new UsuarioDAO();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Borrar la tarea de la base de datos
		usuarioDAO.borrarUsuario(id);

		// Redirigir a la página listar usuarios
		response.sendRedirect("ListarUsuariosServlet");
	}
}
