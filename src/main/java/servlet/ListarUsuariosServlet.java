package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelos.Usuario;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import conectores.DatabaseUtils;
import gestion.UsuarioDAO;

@WebServlet("/ListarUsuariosServlet")
public class ListarUsuariosServlet extends HttpServlet {
	/*
	 * private UsuarioDAO usuarioDAO;
	 * 
	 * @Override public void init() { usuarioDAO = new
	 * UsuarioDAO(ConexionBD.getConnection()); }
	 */

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			// Obtener la lista de usuarios desde la base de datos
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			List<Usuario> usuarios = usuarioDAO.obtenerTodosLosUsuarios();

			// Poner la lista de usuarios como atributo en la petición
			request.setAttribute("usuarios", usuarios);

			// Redirigir a la JSP para mostrar la lista de usuarios
			String tareaIdStr = request.getParameter("tareaId");

			if (tareaIdStr == null || tareaIdStr.isEmpty()) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/views/listarUsuarios.jsp");
				dispatcher.forward(request, response);
			} else {
				int tareaId = Integer.parseInt(request.getParameter("tareaId"));
				RequestDispatcher dispatcher = request.getRequestDispatcher("/views/asignarTareaUsuario.jsp");
				request.setAttribute("tareaId", tareaId);
				dispatcher.forward(request, response);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}