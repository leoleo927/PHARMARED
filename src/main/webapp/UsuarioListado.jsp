<%@page import="beans.UsuarioDTO"%>
<%@page import="beans.ProductoCategoriaDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="interfaces.ProductoDAO"%>
<%@page import="dao.DAOFactory"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">

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
			<tools:cabecera tituloPagina="Usuarios" />
		</header>

		<main>
			<section class="container" style="width: 100%;">
				<div class="row justify-content-center">
					<div class="col-3 text-center">
						<a href="UsuarioRegistrar.jsp" class="btn btn-primary">Agregar
							Usuario<span class="glyphicon glyphicon-repeat"></span>
						</a>
					</div>
				</div>
				<br>
				<div class="table-responsive">
					<table class="table">
						<tr>
							<th></th>
							<th>Codigo</th>
							<th>Nombre</th>
							<th>Apellido</th>
							<th>Usuario</th>
							<th>Tipo</th>
							<th>Estado</th>
							<th>Actualizar</th>
						</tr>
						<tools:usuarioLista />
					</table>
				</div>
			</section>
		</main>
		${mensaje }
	</div>
</body>
</html>