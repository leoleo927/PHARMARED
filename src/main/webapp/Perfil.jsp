<%@page import="beans.UsuarioDTO"%>
<%@ taglib uri="/WEB-INF/libreria.tld" prefix="tools"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	// validar si ha logueado
UsuarioDTO usuLogIn = (UsuarioDTO) request.getSession().getAttribute("usuLogIn");
if (usuLogIn == null) {
	response.sendRedirect("LogIn.jsp");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js"
	integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT"
	crossorigin="anonymous"></script>
<!-- Popper JS -->
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
	integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
	crossorigin="anonymous"></script>
<!-- CSS only -->
<!-- Latest compiled and minified CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
	crossorigin="anonymous">


</head>
<body>
	<div id="contenedor">
		<header>
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<div class="container-fluid d-flex">
					<button class="navbar-toggler" type="button"
						data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<tools:menuPrincipal tipo="${usuLogIn.tipo }"
							nombre="${usuLogIn.nombre }" apellido="${usuLogIn.apellido }" />
					</div>
				</div>
			</nav>
			<tools:cabecera tituloPagina="Actualización de datos" />
		</header>

		<main>
			<section class="container" style="width: 50%">
				<h2></h2>
				<form id="frmBase" action="index" method="post">
					<div class="row g-2">
						<div class="col-md mb-3">
							<div class="form-floating">
								<input type="text" class="form-control" id="txtNombre"
									name="txtNombre" placeholder="Ingresar Nombre" required
									maxlength="15" value="${usuLogIn.nombre }"><label
									for="txtNombre">Nombres</label>
							</div>
						</div>
						<div class="col-md mb-3">
							<div class="form-floating">
								<input type="text" class="form-control" id="txtApellido"
									name="txtApellido" placeholder="Ingresar Apellidos"
									value="${usuLogIn.apellido }"><label for="txtApellido">Apellidos</label>
							</div>
						</div>
					</div>
					<div class="row g-2">
						<div class="col-md mb-3">
							<div class="form-group form-floating">
								<input type="text" class="form-control" id="txtUsuario"
									name="txtUsuario" placeholder="Ingresar Usuario"
									value="${usuLogIn.usuario }"><label
									for="exampleInputEmail1">Usuario</label>
							</div>
						</div>
						<div class="col-md mb-3">
							<div class="form-group form-floating">
								<input type="password" class="form-control" id="txtClave"
									name="txtClave" placeholder="Ingresar Contraseña"
									value="${usuLogIn.clave }"><label for="txtClave">Contraseña</label>
							</div>
						</div>
					</div>
					<div class="row g-2">
						<div class="col-sm mb-3">
							<div class="form-group form-floating mb-3">
								<input type="date" class="form-control" id="txtFecha"
									name="txtFecha" placeholder="año/mes/día"
									value="${usuLogIn.fnacim }"><label for="txtFecha">Fecha
									de nacimiento</label>
							</div>
						</div>
						<div class="col-sm mb-3">
							<div class="form-floating">
								<input type="hidden" class="form-control" id="txtCodigo"
									name="txtCodigo" placeholder="Codigo"
									value="${usuLogIn.codigo }">
							</div>
						</div>
					</div>
					<button type="submit" class="btn btn-primary" name="opcion"
						value="a">Actualizar</button>
					<a class="btn btn-primary" href="Principal.jsp">Regresar</a>
				</form>
				<br> ${mensaje }
			</section>

		</main>
		<footer> </footer>
	</div>
	<!-- Button trigger modal -->
</body>
</html>