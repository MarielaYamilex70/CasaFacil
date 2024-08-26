<%@ page import="java.util.List" %>
<%@ page import="modelos.Usuario" %>
<%
    // Recuperar el usuario de la sesión
    Usuario usuarioSession = (Usuario) session.getAttribute("usuarioSession");
	//Redirigir al login si no hay usuario en sesión
	if (usuarioSession == null) {
	    response.sendRedirect("login.html"); // O "LoginServlet", dependiendo de cómo manejas el login
    return;
	} 
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Casa Fácil</title>
    <link rel="stylesheet" href="css/styles.css">
    <style>
       
    </style>
</head>
<body>

    <!-- Incluir la cabecera -->
    <jsp:include page="header.jsp" />

    <!-- Contenido principal -->
    <div class="main-content">
       <div class="container-listaUsuarios">
       <!-- <h2>Lista de Usuarios</h2> -->
	    <a href="addUsuario.jsp">Adicionar Nuevo Usuario</a>
	    <table border="1" cellpadding="10">
	        <thead>
	            <tr>
	                <th>ID</th>
	                <th>Nombre</th>
	                <th>Email</th>
	                <th>Puntuación</th>
	                <th>Acciones</th>
	            </tr>
	        </thead>
	        <tbody>
	            <% 
	                List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
	                for (Usuario usuario : usuarios) {
	            %>
	            <tr>
	                <td><%= usuario.getId() %></td>
	                <td><%= usuario.getNombre() %></td>
	                <td><%= usuario.getEmail() %></td>
	                <td><%= usuario.getPuntuacion() %></td>
	                <td> 
	                	<a href="ListarTareasUsuarioServlet?id=<%= usuario.getId() %>">Tareas</a> |
	                    <a href="ModiUsuarioServlet?id=<%= usuario.getId() %>">Modificar</a> |
	                    <a href="BorrarUsuarioServlet?id=<%= usuario.getId() %>" onclick="return confirm('¿Estás seguro de eliminar este usuario?');">Eliminar</a>
	                </td>
	            </tr>
	            <% } %>
	        </tbody>
	    </table>
	    <!-- <a href="index.jsp">Volver a la página principal</a> -->
	    </div>
    </div>

    <!-- Incluir el pie de página -->
    <jsp:include page="footer.jsp" />

</body>
</html>
