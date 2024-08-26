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
         <h2>Nueva Tarea</h2>

	    <!-- Formulario para adicionar -->
	    
	    <form action="AddTareaServlet" method="POST" class="form-Add-Modi">
	        <!-- Campo oculto para el ID de la tarea (solo necesario en la modificación) -->
	        <input type="hidden" name="id" value="" />
	
	        <label for="nombre">Nombre de la Tarea:</label>
	        <input type="text" id="nombre" name="nombre" required />
	
	        <label for="descripcion">Descripción:</label>
	        <textarea id="descripcion" name="descripcion" rows="4" required></textarea>
	
	        <label for="puntuacion">Puntuación:</label>
	        <input type="number" id="puntuacion" name="puntuacion" required />
	
	        <label for="esObligatoria">¿Es Obligatoria?</label>
	        <input type="checkbox" id="esObligatoria" name="esObligatoria" />
	
	        <label for="ciclo">Ciclo:</label>
	        <select id="ciclo" name="ciclo">
	            <option value="Diaria">Diaria</option>
	            <option value="Semanal">Semanal</option>
	            <option value="Quincenal">Quincenal</option>
	            <option value="Mensual">Mensual</option>
	        </select>
	
	        <label for="estado">Estado:</label>
	        <select id="estado" name="estado">
	            <option value="Pendiente">Pendiente</option>
	            <option value="Incumplida">Incumplida</option>
	            <option value="Completada">Completada</option>
	            <option value="Aplazada">Aplazada</option>
	        </select>
	
	        <input type="submit" value="Guardar Tarea" />
	    </form>
	    <!-- <a href="ListarTareasServlet">Volver a la lista de tareas</a> -->
	    </div>
     </div>
    

    <!-- Incluir el pie de página -->
    <jsp:include page="footer.jsp" />

</body>
</html>
