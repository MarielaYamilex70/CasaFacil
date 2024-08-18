package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelos.Usuario;

import java.io.IOException;
import java.sql.SQLException;

import gestion.UsuarioDAO;

@WebServlet("/AddUsuarioServlet")
public class AddUsuarioServlet extends HttpServlet {
	private UsuarioDAO usuarioDAO;

	public void init() {
		try {
			usuarioDAO = new UsuarioDAO();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idStr = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		int puntuacion = Integer.parseInt(request.getParameter("puntuacion"));

		Usuario usuario = new Usuario(nombre, email, pwd, puntuacion);

		if (idStr == null || idStr.isEmpty()) {
			try {
				usuarioDAO.addUsuario(usuario);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			// int id = Integer.parseInt(idStr);
			// usuario.setId(id);
			// Obtener el ID de la tarea desde el parámetro de la URL
			int id = Integer.parseInt(request.getParameter("id"));
			usuarioDAO.modiUsuario(id, usuario);
		}

		// response.sendRedirect("listarUsuarios");
		// Redirigir a la página principal o mostrar un mensaje de éxito
		response.sendRedirect("ListarUsuariosServlet");
	}
}
