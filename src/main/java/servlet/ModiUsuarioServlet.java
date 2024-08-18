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

@WebServlet("/ModiUsuarioServlet")
public class ModiUsuarioServlet extends HttpServlet {
	private UsuarioDAO usuarioDAO;

	@Override
	public void init() {
		try {
			usuarioDAO = new UsuarioDAO();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Obtener el ID del usuario desde el parámetro de la URL
		int id = Integer.parseInt(request.getParameter("id"));

		// Obtener el usuario desde la base de datos
		Usuario usuario = usuarioDAO.obtenerUsuarioPorId(id);

		// Pasar el usuario como atributo en la petición
		request.setAttribute("usuario", usuario);

		// Redirigir al JSP de modificación de usuario
		RequestDispatcher dispatcher = request.getRequestDispatcher("modiUsuario.jsp");
		dispatcher.forward(request, response);
	}
}
