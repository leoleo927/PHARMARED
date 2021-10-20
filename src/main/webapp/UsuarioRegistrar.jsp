<%@page import="beans.UsuarioDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%-- Importar la libreria personalizada --%>
<%@ taglib uri="/WEB-INF/libreria.tld" prefix="tools"%>
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
			<tools:cabecera tituloPagina="Actualizar usuario" />
		</header>

		<main>
			<section class="container" style="width: 50%">
				<h2></h2>
				<form id="frmBase" action="usu" method="post">
					<div class="row g-2">
						<div class="col-md mb-3">
							<div class="form-floating">
								<input type="text" class="form-control" id="txtNombre"
									name="txtNombre" placeholder="Ingresar Nombre" required
									maxlength="15" value="${usuarioCrud.nombre }"><label
									for="txtNombre">Nombres</label>
							</div>
						</div>
						<div class="col-md mb-3">
							<div class="form-floating">
								<input type="text" class="form-control" id="txtApellido"
									name="txtApellido" placeholder="Ingresar Apellidos"
									value="${usuarioCrud.apellido }"><label
									for="txtApellido">Apellidos</label>
							</div>
						</div>
					</div>
					<div class="row g-2">
						<div class="col-md mb-3">
							<div class="form-floating">
								<input type="text" class="form-control" id="txtUsuario"
									name="txtUsuario" placeholder="Ingresar Usuario"
									value="${usuarioCrud.usuario }"><label
									for="exampleInputEmail1">Usuario</label>
							</div>
						</div>
						<div class="col-md mb-3">
							<div class="form-floating">
								<input type="password" class="form-control" id="txtClave"
									name="txtClave" placeholder="Ingresar Contraseña"
									value="${usuarioCrud.clave }"><label for="txtClave">Contraseña</label>
							</div>
						</div>
					</div>
					<div class="row g-2">
						<div class="col-sm mb-3">
							<div class="form-floating">
								<input type="date" class="form-control" id="txtFecha"
									name="txtFecha" placeholder="año/mes/día"
									value="${usuarioCrud.fnacim }"><label for="txtFecha">Fecha
									de nacimiento</label>
							</div>
						</div>
						<div class="col-sm mb-3">
							<div class="form-floating">
								<select class="form-control" id="cboTipo" name="cboTipo"
									aria-label="Tipo">
									<%-- usamos custom tag para las opciones --%>
									<tools:comboUsuTipo tipo="${usuarioCrud.tipo }" />
								</select> <label for="cboTipo">Tipo</label>
							</div>
						</div>
					</div>
					<div class="row g-2">
						<div class="col-sm mb-3">
							<div class="form-floating">
								<select class="form-control" id="cboEstado" name="cboEstado"
									aria-label="Estado">
									<%-- usamos custom tag para las opciones --%>
									<tools:comboEstados estado="${usuarioCrud.estado }" />
								</select> <label for="cboEstado">Estado</label>
							</div>
						</div>
						<div class="col-sm mb-3">
							<div class="form-floating">
								<input type="hidden" class="form-control" id="txtCodigo"
									name="txtCodigo" placeholder="Codigo"
									value="${usuarioCrud.codigo }">
							</div>
						</div>
					</div>
					<button type="submit" class="btn btn-primary" name="opcion"
						value="r">Registrar</button>
					<a class="btn btn-warning" href="usu?opcion=ls">Regresar</a>
				</form>
				<br> ${mensaje }
			</section>

		</main>
		<footer> </footer>
	</div>
	<!-- Button trigger modal -->
</body>
</html>