package servlet;

import java.io.IOException;
import java.sql.SQLException;

import gestion.TareaDAO;
import gestion.UsuarioDAO;
import gestion.UsuarioTareaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelos.Tarea;
import modelos.Usuario;
import modelos.UsuarioTarea;

@WebServlet("/AsignarTareaServlet")
public class AsignarTareaServlet extends HttpServlet {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String action = request.getParameter("action");
			int usuarioId = Integer.parseInt(request.getParameter("usuarioId"));
			int tareaId = Integer.parseInt(request.getParameter("tareaId"));

			System.out.println("**action: " + action);
			System.out.println("**Usuario ID: " + usuarioId);
			System.out.println("**Tarea ID: " + tareaId);

			Usuario usuario = new UsuarioDAO().obtenerUsuarioPorId(usuarioId);

			Tarea tarea = new TareaDAO().obtenerTareaPorId(tareaId);

			UsuarioTarea usuariotarea = usuarioTareaDAO.obtenerUsuarioTareaPorTarea(tareaId);

			if ("asignar".equals(action)) {
				// Lógica para asignar el usuario a la tarea
				if (usuariotarea == null) {
					// Nueva asignacion
					System.out.println("**Nueva Relacion Usuario-Tarea.");
					usuarioTareaDAO.asignarTarea(usuario, tarea);

				} else {
					// cambio del usuario
					System.out.println("Usuario-Tarea : " + usuariotarea.toString());
					usuarioTareaDAO.actualizarUsuarioID(tareaId, usuarioId);
				}
			} else if ("eliminar".equals(action)) {
				// Lógica para eliminar la relación tarea-usuario
				usuarioTareaDAO.eliminarAsignacionPorUsuarioYTarea(usuarioId, tareaId);
			}
			// usuarioTareaDAO.asignarTarea(usuario, tarea);
			response.sendRedirect("ListarTareasServlet");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
