<%@ page import="modelos.UsuarioTarea" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <<title>Casa Fácil</title>
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
       
    <h2>Tareas Asignadas a "<%= request.getAttribute("nombreUsuario") %>"</h2>
    <table border="1">
        <thead>
            <tr>
                <th>Tarea</th>
                <th>Estado</th>
                <th>Fecha de Asignación</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<UsuarioTarea> tareas = (List<UsuarioTarea>) request.getAttribute("tareas");
                for (UsuarioTarea usuarioTarea : tareas) {
            %>
            <tr>
                <td><%= usuarioTarea.getTarea().getNombre() %></td>
                <td><%= usuarioTarea.getEstado() %></td>
                <td><%= usuarioTarea.getFechaAsignacion() %></td>
                <td>
                    <form action="ModiEstadoTareaServlet?usuarioId=<%= request.getAttribute("usuarioId") %>" method="post">
                        <input type="hidden" name="id" value="<%= usuarioTarea.getId() %>" />
                        
                        <select name="estado">
                            <option value="pendiente" <%= usuarioTarea.getEstado().equals("pendiente") ? "selected" : "" %>>Pendiente</option>
                            <option value="en_progreso" <%= usuarioTarea.getEstado().equals("en_progreso") ? "selected" : "" %>>En Progreso</option>
                            <option value="completada" <%= usuarioTarea.getEstado().equals("completada") ? "selected" : "" %>>Completada</option>
                        </select>
                        <input type="submit" value="Actualizar">
                    </form>
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
