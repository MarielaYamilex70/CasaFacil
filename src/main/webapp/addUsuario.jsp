<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Casa Fácil</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>

    <!-- Incluir la cabecera -->
    <jsp:include page="header.jsp" />

    <!-- Contenido principal -->
    <div class="main-content">
       <div class="container-form">
         <h2>Adicionar Nuevo Usuario</h2>

	    <!-- Formulario para adicionar -->
	    <form action="AddUsuarioServlet" method="post" class="form-Add-Modi">
	    
	        <input type="hidden" name="id" value="" />
	        	<div class="form-group">
			        <label for="nombre">Nombre:</label>
			        <input type="text" id="nombre" name="nombre" required>
			     </div>
			     <div class="form-group">
			        <label for="email">Email:</label>
			        <input type="email" id="email" name="email" required>
			     </div>
			     <div class="form-group">
			        <label for="pwd">Contraseña:</label>
			        <input type="password" id="pwd" name="pwd" required>
			     </div>
			     <div class="form-group">
			        <label for="puntuacion">Puntuación:</label>
			        <input type="number" id="puntuacion" name="puntuacion" required>
			     </div>
			    
			        <input type="submit" value="Guardar Usuario">
	    </form>
	    <!-- <a href="ListarUsuariosServlet">Volver a la lista de Usuarios</a> -->
	    </div>
     </div>
    

    <!-- Incluir el pie de página -->
    <jsp:include page="footer.jsp" />

</body>
</html>
