<%@ page import="modelos.Usuario" %>
<jsp:include page="/OpenWeatherAPIServlet" />
<%
    // Recuperar el usuario de la sesión
    Usuario usuarioSession = (Usuario) session.getAttribute("usuarioSession");
	// Recuperar datos de OpenWeatherAPIServlet
	String ciudad = (String) request.getAttribute("ciudad");
	String temperature = (String) request.getAttribute("temperature");
	String description = (String) request.getAttribute("description");

%>

<div class="navbar">
    <!-- Logo o nombre de la aplicación -->
    
    <% if (usuarioSession != null) { %>
         <a href="index.jsp" class="logo">Casa Fácil  |</a>
          <% if (temperature != null) { %>
          		<a href="index.jsp" class="username">${ciudad}: ${temperature} °C, ${description} |</a>
          <% }  %>
         <a href=""><span class="username"><%= usuarioSession.getNombre() %></span></a>
         
     <% } else { %>
     	 <a href="index.jsp" class="logo">Casa Fácil</a>
     	 <% if (temperature != null) { %>
          		<a href="index.jsp" class="username">|  ${ciudad}: ${temperature} °C, ${description}</a>
          <% }  %>
     <% } %>
     
    <!-- Menú de navegación -->
    <div class="menu">
 
        <a href="index.jsp" class="<%= request.getRequestURI().endsWith("index.jsp") ? "active" : "" %>">Inicio</a>
        <a href="ListarTareasServlet" class="<%= request.getRequestURI().contains("listarTareas") ? "active" : "" %>">Gestionar Tareas</a>
        <a href="ListarUsuariosServlet" class="<%= request.getRequestURI().contains("listarUsuarios") ? "active" : "" %>">Gestionar Usuarios</a>
        <a href="LogoutServlet">Cerrar Sesión</a>
        
    </div>
</div>
