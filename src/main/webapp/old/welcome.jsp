<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bienvenido</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
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
            background: #ffffff;
            opacity: 0.95; /* El contenedor y su contenido tendrán un 50% de opacidad */
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            max-width: 500px;
            padding: 20px;
            text-align: center;
        }
        h1 {
            color: #333333;
        }
        p {
            color: #666666;
            font-size: 18px;
        }
        .welcome-btn {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            font-size: 16px;
            color: #ffffff;
            background-color: #007bff;
            border: none;
            border-radius: 4px;
            text-decoration: none;
            cursor: pointer;
        }
        .welcome-btn:hover {
            background-color: #0056b3;
        }
        footer {
            margin-top: 20px;
            color: #999999;
            font-size: 14px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>¡Bienvenido <%= session.getAttribute("nombre") %>!!!!</h1>
        <p>Tu registro ha sido exitoso. </p>
        <p> Gracias por unirte a nuestro Proyecto Casa Fácil.</p>
        
        <a href="index.html" class="welcome-btn">Ir a la página principal</a>
        <footer>&copy; 2024 Video Club</footer>
    </div>
</body>
</html>
