package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelos.Usuario;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import conectores.DatabaseUtils;
import gestion.UsuarioDAO;

/**
 * Servlet implementation class RegistroServlets
 */
//@WebServlet("/RegistroServlet")
public class RegistroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public RegistroServlet() {
        // Constructor por defecto
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		// Obtén los parámetros del formulario
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");

		// Añadir la lógica para procesar los datos del formulario
		// Guardar los datos en una base de datos o validar las entradas
		
		try {

			Usuario usuario = new Usuario(name, email, password, 0);
			UsuarioDAO usuarioDAO = new UsuarioDAO();

			if (usuarioDAO.addUsuario(usuario)) {

				
				request.getSession().setAttribute("usuarioSession", usuario);
				// Redirecciona a usuario.jsp usando forward
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);

			} else {
				response.sendRedirect("registro.html");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} 

	}

}
