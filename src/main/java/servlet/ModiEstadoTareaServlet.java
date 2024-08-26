package servlet;

import java.io.IOException;
import java.sql.SQLException;

import gestion.TareaDAO;
import gestion.UsuarioDAO;
import gestion.UsuarioTareaDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelos.Tarea;
import modelos.Usuario;
import modelos.UsuarioTarea;

@WebServlet("/ModiEstadoTareaServlet")
public class ModiEstadoTareaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioTareaDAO usuarioTareaDAO;

	@Override
	public void init() throws ServletException {
		try {
			usuarioTareaDAO = new UsuarioTareaDAO();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// Obtener parámetros de la solicitud
			int usuarioTareaId = Integer.parseInt(request.getParameter("id"));
			
			String nuevoEstado = request.getParameter("estado");
			int usuarioId = Integer.parseInt(request.getParameter("usuarioId"));

			System.out.println("Usuario-Tarea ID: " + usuarioTareaId);

			System.out.println("Usuario ID: " + usuarioId);
			
			// Validar los parámetros
			if (nuevoEstado == null || nuevoEstado.isEmpty()) {
				response.sendRedirect("listarTareas.jsp?error=Estado%20no%20válido");
				return;
			}

			// Actualizar el estado de la tarea en la base de datos
			UsuarioTarea usuarioTarea = usuarioTareaDAO.obtenerUsuarioTareaPorId(usuarioTareaId);
			if (usuarioTarea != null) {
				usuarioTarea.setEstado(nuevoEstado);
				
				usuarioTareaDAO.actualizarEstadoTarea(usuarioTareaId, nuevoEstado);
				if (nuevoEstado.equals("completada")) {

					UsuarioDAO usuarioDAO = new UsuarioDAO();
					TareaDAO tareaDAO = new TareaDAO();

					Usuario usuario = usuarioDAO.obtenerUsuarioPorId(usuarioId);
					Tarea tarea = tareaDAO.obtenerTareaPorId(usuarioTarea.getTarea().getId());
					System.out.println("Tarea : " + tarea.toString());

					if (usuario != null && tarea != null) {
						System.out.println("Usuario encontrado: " + usuario.getNombre());
						System.out.println("Tarea encontrada: " + tarea.getNombre());
						System.out.println("Puntuación Tarea: " + tarea.getPuntuacion());
						System.out.println("Puntuación Usuario: " + usuario.getPuntuacion());
						usuario.setPuntuacion(usuario.getPuntuacion() + tarea.getPuntuacion());
						usuarioDAO.modiUsuario(usuarioId, usuario);
						System.out.println("Puntuación actualizada: " + usuario.getPuntuacion());
					} else {
						System.out.println("Usuario o Tarea no encontrados.");
						// System.out.println("Usuario encontrado: " + usuario.getNombre());
						// System.out.println("Tarea encontrada: " + tarea.getNombre());
					}

				}
			}

			// Redirigir a la lista de tareas 
			response.sendRedirect("ListarTareasUsuarioServlet?id=" + usuarioId);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}