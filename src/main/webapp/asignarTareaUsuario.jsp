<%@ page import="java.util.List" %>
<%@ page import="modelos.Usuario" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Asignar Tarea a Usuario</title>
</head>
<body>
    <h1>Asignar Tarea a Usuario</h1>
    <form action="AsignarTareaServlet" method="post">
        <!-- Campo oculto para almacenar el ID de la tarea -->
        <input type="hidden" id="tareaId" name="tareaId" value="<%= request.getParameter("tareaId") %>">

        <label for="usuarioId">Seleccionar Usuario:</label>
        <select id="usuarioId" name="usuarioId" required>
            <option value="">Seleccione un usuario</option>
            <% 
                // Lista de usuarios como atributo en el request
                List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
         		
                for (Usuario usuario : usuarios) {
            %>
                <option value="<%= usuario.getId() %>"><%= usuario.getNombre() %> - <%= usuario.getEmail() %></option>
            <% } %>
        </select>
        <br><br>

        <p>Tarea seleccionada: <strong><%= request.getParameter("tareaNombre") %></strong></p>
        <br><br>

        <input type="submit" value="Asignar Tarea">
    </form>
    <br>
    <a href="listarUsuarios.jsp">Volver a la lista de usuarios</a>
</body>
</html>
