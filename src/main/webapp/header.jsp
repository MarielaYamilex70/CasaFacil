<%@ page import="modelos.Usuario" %>
<%
    // Recuperar el usuario de la sesi�n
    Usuario usuarioSession = (Usuario) session.getAttribute("usuarioSession");
	
%>
<div class="navbar">
    <!-- Logo o nombre de la aplicaci�n -->
    
    <% if (usuarioSession != null) { %>
         <a href="index.jsp" class="logo">Casa F�cil  |</a>
         <a href=""><span class="username"><%= usuarioSession.getNombre() %></span></a>
         
     <% } else { %>
     	 <a href="index.jsp" class="logo">Casa F�cil</a>
     <% } %>

    <!-- Men� de navegaci�n -->
    <div class="menu">
        <!-- <a href="index.jsp">Inicio</a>
        <a href="ListarTareasServlet">Gestionar Tareas</a>
        <a href="ListarUsuariosServlet">Gestionar Usuarios</a> -->
        
        
<%--         <a href="index.jsp" class="<%= (pagina.equals("index.jsp") ? "active" : "") %>">Inicio</a>
        <a href="ListarTareasServlet" class="<%= (pagina.equals("ListarTareasServlet") ? "active" : "") %>">Gestionar Tareas</a>
        <a href="ListarUsuariosServlet" class="<%= (pagina.equals("ListarUsuariosServlet") ? "active" : "") %>">Gestionar Usuarios</a>
 --%>        
 
        <a href="index.jsp" class="<%= request.getRequestURI().endsWith("index.jsp") ? "active" : "" %>">Inicio</a>
        <a href="ListarTareasServlet" class="<%= request.getRequestURI().contains("listarTareas") ? "active" : "" %>">Gestionar Tareas</a>
        <a href="ListarUsuariosServlet" class="<%= request.getRequestURI().contains("listarUsuarios") ? "active" : "" %>">Gestionar Usuarios</a>
 		
        <a href="LogoutServlet">Cerrar Sesi�n</a>
        
    </div>
</div>
