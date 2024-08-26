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
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"> <!-- Font Awesome -->
    
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>

    <!-- Incluir la cabecera -->
    <jsp:include page="/views/header.jsp" />

    <!-- Contenido principal -->
    <div class="main-content">
        <div class="container-index welcome">
	        <h1>Bienvenido a la Gestión de Tareas Domésticas</h1>
	        <p>Organiza y gestiona las tareas del hogar de manera eficiente.</p>
	        <a href="ListarTareasServlet" class="btn_index">
	            <i class="fa fa-tasks"></i> Gestionar Tareas
	        </a>
    	</div>
    </div>

    <!-- Incluir el pie de página -->
    <jsp:include page="/views/footer.jsp" />

</body>
</html>
