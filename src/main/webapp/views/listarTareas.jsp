<%@ page import="java.util.List" %>
<%@ page import="modelos.Tarea" %>
<%@ page import="modelos.Usuario" %>
<%@ page import="modelos.UsuarioTarea" %>
<%@ page import="gestion.UsuarioTareaDAO" %>
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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"> <!-- Font Awesome -->
</head>
<body>

    <!-- Incluir la cabecera -->
    <jsp:include page="header.jsp" />

    <!-- Contenido principal -->
    <div class="main-content">
      <div class="container">
      <!--  <h2>Lista de Tareas</h2> -->
	    <a href="addTarea.jsp">Adicionar Nueva Tarea</a>
	    <table border="1" cellpadding="10">
	        <thead>
	            <tr>
	                <th>ID</th>
	                <th>Nombre</th>
	                <th>Descripción</th>
	                <th>Puntuación</th>
	                <th>Obligatoria</th>
	                <th>Ciclo</th>
	                <!--<th>Estado</th>-->
	                <th>Acciones</th>
	                <th>Asignar Usuarios</th>
	            </tr>
	        </thead>
	        <tbody>
	            <% 
	            	/* List<UsuarioTarea> usuariostareas = (List<UsuarioTarea>) request.getAttribute("usuariostareas"); */
	                List<Tarea> tareas = (List<Tarea>) request.getAttribute("tareas");
	                for (Tarea tarea : tareas) {
	            %>
	            <tr>
	                <td><%= tarea.getId() %></td>
	                <td><%= tarea.getNombre() %></td>
	                <td><%= tarea.getDescripcion() %></td>
	                <td><%= tarea.getPuntuacion() %></td>
	                <td><%= tarea.isEsObligatoria() ? "Sí" : "No" %></td>
	                <td><%= tarea.getCiclo() %></td>
	                <!--<td><%= tarea.getEstado() %></td>-->
	                <td>
	                    <a href="ModiTareaServlet?id=<%= tarea.getId() %>">Modificar</a> |
	                    <a href="BorrarTareaServlet?id=<%= tarea.getId() %>" onclick="return confirm('¿Estás seguro de eliminar esta tarea?');">Eliminar</a>
	                </td>
	                <td>
	                    <form action="AsignarTareaServlet" method="post">
					        <!-- Campo oculto para almacenar el ID de la tarea -->
					        <input type="hidden" id="tareaId" name="tareaId" value="<%= tarea.getId() %>">
					
					        <label for="usuarioId"></label>
					        <select id="usuarioId" name="usuarioId" required>
					            <option value="">Seleccione un usuario</option>
					            <% 
					                // Lista de usuarios como atributo en el request
					                List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
					        		
					        		UsuarioTareaDAO usuarioTareaDAO = new UsuarioTareaDAO();
					         		
					                for (Usuario usuario : usuarios) {
					            %>
	<%-- 				                <option value="<%= usuario.getId() %>" <%= (tarea.obtenerUsuarioIdPorTarea()==usuario.getId()) ? "selected" : "" %>><%= usuario.getNombre() %> - <%= usuario.getEmail() %> - [<%= usuario.getId() %>]</option> --%>
					                <option value="<%= usuario.getId() %>" <%= (usuarioTareaDAO.obtenerUsuarioIdPorTarea(tarea.getId())==usuario.getId()) ? "selected" : "" %>><%= usuario.getNombre() %> - <%= usuario.getEmail() %> - [<%= usuario.getId() %>]</option>
	
					            <% } %>
					        </select>
					
					        <!-- <input type="submit" value="Asignar"><input type="submit" value="Eliminar"> -->
					        <!-- <input type="submit" value="Asignar" onclick="document.getElementById('action').value='asignar'">
	    					<input type="submit" value="Eliminar" onclick="document.getElementById('action').value='eliminar'"> -->
	    					
	    					 <!-- <input type="submit" name="action" class="btn-add" value="asignar">
	    					 <input type="submit" name="action" class="btn-del" value="eliminar"> -->
	    					 
	    					 <button type="submit" name="action" class="btn-icon" title="Asignar" value="asignar">
					            <i class="fa fa-plus"></i>
					           <!--  <span class="btn-text">Asignar</span> -->
					        </button>
					        <button type="submit" name="action" class="btn-icon" title="Eliminar" value="eliminar">
					            <i class="fa fa-trash-alt"></i>
					            <!-- <span class="btn-text">Eliminar</span> -->
        					</button>
					    </form>
					         
	    			</td>
	  			
	            </tr>
	            <% } %>
	        </tbody>
	    </table>
	   <!--  <a href="index.jsp">Volver a la página principal</a> -->
	    </div>
    </div>

    <!-- Incluir el pie de página -->
    <jsp:include page="footer.jsp" />

</body>
</html>
