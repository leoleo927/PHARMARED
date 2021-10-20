<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Farmacia</title>
<meta name="viewport"
	content="width=device-width, user-scalable=yes, initial-scale=1.0, maximum-scale=3.0, minimum-scale=1.0">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.3/css/all.css">
<link rel="stylesheet" href="css/estilos.css" type="text/css">
</head>
<body>
	<div class="col-12 user-img">
		<img src="img/logo.png" alt="Logo Login">
	</div>

	<form class="formulario" action="index" method="post">
		<h1>FARMACIA</h1>

		<div class="contenedor">
			<div class="input-contenedor">
				<i class="fas fa-envelope icon"></i> <input type="text" id="txtUsuario" name="txtUsuario"
					placeholder="Correo Electronico" required>
			</div>

			<div class="input-contenedor">
				<i class="fas fa-key icon"></i> <input type="password" id="txtClave" name="txtClave"
					placeholder="Contraseña" required>
			</div>

			<button type="submit" class="button" name="opcion" value="li">INGRESAR</button>
			<p>
				¿No tienes una cuenta? <a class="link" href="Registro.jsp">REGISTRATE
				</a>
			</p>
			${mensaje }
		</div>
	</form>
</body>
</html>