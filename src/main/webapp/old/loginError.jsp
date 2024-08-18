<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Bienvenido</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f8ff;
            color: #333;
            text-align: center;
            margin: 0;
            padding: 0;
            
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            font-family: Arial, sans-serif;
            
            /*background: linear-gradient(135deg, #f8f9fa, #e9ecef);*/
            background-image: url('./images/conjunto-personajes-minimalistas-que-realizan-tareas-domesticas_01.jpg');
		    /*background-size: cover;
		   	background-position: center;
		    background-repeat: no-repeat;
		    background-attachment: fixed;*/
		    background-size: 100% 100%; /* La imagen se ajusta al tamaño de la pantalla */
    		background-repeat: no-repeat; /* Evita que la imagen se repita */
    		background-position: center; /* Centra la imagen en la pantalla */
        }
        .container {
            width: 80%;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            opacity: 0.95; /* El contenedor y su contenido tendrán un 50% de opacidad */
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        h1 {
            color: #2c3e50;
        }
        .score {
            font-size: 1.2em;
            color: #e74c3c;
        }
        .welcome {
            font-size: 1.5em;
            color: #3498db;
        }
        .button {
            display: inline-block;
            padding: 10px 20px;
            font-size: 1em;
            color: #fff;
            background-color: #3498db;
            border: none;
            border-radius: 4px;
            text-decoration: none;
            margin-top: 20px;
        }
        .button:hover {
            background-color: #2980b9;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1 class="welcome">Usuario y/o contraseña incorrectos !!!!</h1>
        <p class="score"><%= session.getAttribute("email") %></p>
        <a href="login.html" class="button">Volver al login</a>
    </div>
</body>
</html>
