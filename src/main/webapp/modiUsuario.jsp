<%@ page import="modelos.Usuario" %>
<%
    Usuario usuario = (Usuario) request.getAttribute("usuario");
    if (usuario == null) {
        response.sendRedirect("listarUsuarios.jsp?error=UsuarioNoEncontrado");
    }
    System.out.println("Tarea -> "+usuario.toString());
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>

    <!-- Incluir la cabecera -->
    <jsp:include page="header.jsp" />

    <!-- Contenido principal -->
    <div class="main-content">
       <div class="container-form">
         <h2>Modificar Usuario</h2>
		    <form action="AddUsuarioServlet" method="post" class="form-Add-Modi">
		        <input type="hidden" id="id" name="id" value="<%= usuario.getId() %>" >
		        <div class="form-group">
		        
		        <label for="nombre">Nombre:</label>
		        <input type="text" id="nombre" name="nombre" value="<%= usuario.getNombre() %>" required>
		        </div>
			     <div class="form-group">
		        
		        <label for="email">Email:</label>
		        <input type="email" id="email" name="email" value="<%= usuario.getEmail() %>" required>
		        </div>
			     <div class="form-group">
		        
		        <label for="pwd">Contraseña:</label>
		        <input type="password" id="pwd" name="pwd" value="<%= usuario.getPwd() %>" required>
		       </div>
			     <div class="form-group">
		        
		        <label for="puntuacion">Puntuación:</label>
		        <input type="number" id="puntuacion" name="puntuacion" value="<%= usuario.getPuntuacion() %>" required>
		        </div>
			     
		        
		        <input type="submit" value="Guardar Cambios">
		    </form>
		    <!-- <a href="listarUsuarios">Volver a la lista de usuarios</a> -->
		 </div>
     </div>
    

    <!-- Incluir el pie de página -->
    <jsp:include page="footer.jsp" />
</body>
</html>
