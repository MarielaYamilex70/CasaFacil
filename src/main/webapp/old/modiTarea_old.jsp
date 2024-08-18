<%@ page import="modelos.Tarea" %>
<%
    Tarea tarea = (Tarea) request.getAttribute("tarea");
    
    System.out.println("Tarea -> "+tarea.toString());
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Modificar Tarea</title>
</head>
<body>
    <h1>Modificar Tarea</h1>
    <form action="AddTareaServlet" method="post">
        <input type="hidden" name="id" value="<%= tarea.getId() %>" />
        
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" value="<%= tarea.getNombre() %>" required>
        <br>
        
        <label for="descripcion">Descripci�n:</label>
        <textarea id="descripcion" name="descripcion" required><%= tarea.getDescripcion() %></textarea>
        <br>
        
        <label for="puntuacion">Puntuaci�n:</label>
        <input type="number" id="puntuacion" name="puntuacion" value="<%= tarea.getPuntuacion() %>" required>
        <br>
        
        <label for="esObligatoria">�Es Obligatoria?</label>
        <input type="checkbox" id="esObligatoria" name="esObligatoria" <%= tarea.isEsObligatoria() ? "checked" : "" %>>
        <br>
        
        <label for="ciclo">Ciclo:</label>
        <select id="ciclo" name="ciclo">
             <option value="Diaria" <%= tarea.getCiclo().equals("Diaria") ? "selected" : "" %>>Diaria</option>
             <option value="Semanal" <%= tarea.getCiclo().equals("Semanal") ? "selected" : "" %>>Semanal</option>
             <option value="Quincenal" <%= tarea.getCiclo().equals("Quincenal") ? "selected" : "" %>>Quincenal</option>
            <option value="Mensual" <%= tarea.getCiclo().equals("Mensual") ? "selected" : "" %>>Mensual</option>
        </select>
        <br>
        
        <label for="estado">Estado:</label>
        <select id="estado" name="estado">
       
            <option value="Pendiente" <%= tarea.getEstado().equals("Pendiente") ? "selected" : "" %>>Pendiente</option>
            <option value="Completada" <%= tarea.getEstado().equals("Completada") ? "selected" : "" %>>Completada</option>
            <option value="Incumplida" <%= tarea.getEstado().equals("Incumplida") ? "selected" : "" %>>Incumplida</option>
            <option value="Aplazada" <%= tarea.getEstado().equals("Aplazada") ? "selected" : "" %>>Aplazada</option>
           
        </select>
        <br>
        
        <input type="submit" value="Guardar">
    </form>
    <a href="ListarTareasServlet">Volver a la lista de tareas</a>
</body>
</html>

