<%@ page import="java.util.List" %>
<%@ page import="modelos.Usuario" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de Usuarios</title>
    <style>
        /* Estilo para centrar la tabla y añadir sombra */
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
            min-height: 100vh;
            margin: 0;
        }

        h1 {
            text-align: center;
            margin-bottom: 20px;
        }

        a {
            text-decoration: none;
            color: #007bff;
            margin-bottom: 20px;
            display: inline-block;
        }

        table {
            width: 80%;
            max-width: 1000px;
            border-collapse: collapse;
            margin: 20px auto;
            background-color: white;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* Sombra */
        }

        table, th, td {
            border: 1px solid #ddd;
        }

        th, td {
            padding: 10px;
            text-align: left;
        }

        th {
            background-color: #f2f2f2;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        tr:hover {
            background-color: #f1f1f1;
        }

        .actions a {
            margin-right: 10px;
            color: #007bff;
        }

        .actions a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <h1>Lista de Usuarios</h1>
    <a href="addUsuario.html">Adicionar Nuevo Usuario</a>
    <table border="1" cellpadding="10">
        <thead>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Email</th>
                <th>Puntuación</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
            <% 
                List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
                for (Usuario usuario : usuarios) {
            %>
            <tr>
                <td><%= usuario.getId() %></td>
                <td><%= usuario.getNombre() %></td>
                <td><%= usuario.getEmail() %></td>
                <td><%= usuario.getPuntuacion() %></td>
                <td> 
                	<a href="ListarTareasUsuarioServlet?id=<%= usuario.getId() %>">Tareas</a> |
                    <a href="ModiUsuarioServlet?id=<%= usuario.getId() %>">Modificar</a> |
                    <a href="BorrarUsuarioServlet?id=<%= usuario.getId() %>" onclick="return confirm('¿Estás seguro de eliminar este usuario?');">Eliminar</a>
                </td>
            </tr>
            <% } %>
        </tbody>
    </table>
    <a href="index.jsp">Volver a la página principal</a>
</body>
</html>
