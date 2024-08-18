package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import conectores.DatabaseUtils;
import gestion.UsuarioDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelos.Usuario;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		// response.setContentType("text/html");
		// response.getWriter().println("<html><body><h2>Servlet de
		// Login</h2></body></html>");

//        ResultSet resultSet = null;
//        Statement statement = null;
//        Connection connection = null;
//        String query = "SELECT id, nombre, puntuacion FROM usuarios WHERE email = '"+email+"' AND pwd = '"+password+"';";
//        
		try {

//      	    connection = DatabaseUtils.setConnection();
//           
//            statement = connection.createStatement();
//
//            resultSet = statement.executeQuery(query);

			/*
			 * if (resultSet != null) {
			 * 
			 * // Redirigir a la página de bienvenida response.sendRedirect("welcome.html");
			 */

			// if (resultSet != null && resultSet.next()) { // Asegúrate de llamar a
			// `next()`

			UsuarioDAO usuarioDAO = new UsuarioDAO();
			Usuario usuario = usuarioDAO.obtenerUsuario(email, password);

			if (usuario != null) {
				// Recoger el ID y el nombre del usuario
//                int id = resultSet.getInt("id");
//                String nombre = resultSet.getString("nombre");
//                int puntuacion = resultSet.getInt("puntuacion");

				// Almacenar el ID y el nombre en la sesión
//                request.getSession().setAttribute("id", id);
//                request.getSession().setAttribute("nombre", nombre);
//                request.getSession().setAttribute("puntuacion", puntuacion);

				request.getSession().setAttribute("usuarioSession", usuario);

				// Redirecciona a usuario.jsp usando forward
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);
			} else {
				// Almacenar el ID y el nombre en la sesión
				request.getSession().setAttribute("email", email);

				// Redirecciona a usuario.jsp usando forward
				RequestDispatcher dispatcher = request.getRequestDispatcher("login.html");
				dispatcher.forward(request, response);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Cerrar el ResultSet, Statement y Connection
			// DatabaseUtils.closeConnection(resultSet, statement, connection);

		}
	}
}
