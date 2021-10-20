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
		<h1>REGISTRATE</h1>

		<div class="contenedor">

			<div class="input-contenedor">
				<i class="fas fa-user icon"></i> <input type="text"
					placeholder="Nombre" name="txtNombre">
			</div>

			<div class="input-contenedor">
				<i class="fas fa-user icon"></i> <input type="text"
					placeholder="Apellido" name="txtApellido">
			</div>

			<div class="input-contenedor">
				<i class="fas fa-key icon"></i> <input type="text"
					placeholder="Usuario" name="txtUsuario">
			</div>

			<div class="input-contenedor">
				<i class="fas fa-key icon"></i> <input type="password"
					placeholder="Contraseña" name="txtClave">
			</div>

			<div class="input-contenedor">
				<i class="fas fa-calendar-alt icon"></i><input type="date"
					 name="txtFecha"
					placeholder="Fecha de Nacimiento">
			</div>

			<button type="submit" class="button" name="opcion" value="r">Registar</button>

			<p>
				¿Ya tienes una cuenta? <a class="link" href="LogIn.jsp">INICIAR
					SESION</a>
			</p>
		</div>
	</form>


</body>
</html>