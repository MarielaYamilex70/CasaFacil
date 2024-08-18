package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import gestion.UsuarioDAO;
import gestion.UsuarioTareaDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelos.Usuario;
import modelos.UsuarioTarea;

@WebServlet("/ListarTareasUsuarioServlet")
public class ListarTareasUsuarioServlet extends HttpServlet {
	private UsuarioTareaDAO usuarioTareaDAO;

	@Override
	public void init() {
		try {
			usuarioTareaDAO = new UsuarioTareaDAO();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			int usuarioId = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("usuarioId", usuarioId);

			Usuario usuario = new UsuarioDAO().obtenerUsuarioPorId(usuarioId);
			String nombreUsuario = usuario.getNombre();
			request.setAttribute("nombreUsuario", nombreUsuario);

			List<UsuarioTarea> tareas = usuarioTareaDAO.obtenerTareasPorUsuario(usuarioId);
			request.setAttribute("tareas", tareas);

			RequestDispatcher dispatcher = request.getRequestDispatcher("listarTareasUsuario.jsp");
			dispatcher.forward(request, response);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
