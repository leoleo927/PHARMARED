<%@page import="beans.UsuarioDTO"%>
<%@ taglib uri="/WEB-INF/libreria.tld" prefix="tools"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
		</header>
		<main>
			<tools:cabecera tituloPagina="Compra de Productos" />
			<section class="container" style="width: 100%;">
				<%--  cuerpo de la pagina --%>
				<fieldset>
					<legend style="background-color: silver; text-align: center;">Formulario
						de compras</legend>
					<form action="venta" method="post">
						<div>
							<input type="hidden" id="txtIdpro" name="txtIdpro"
								value="${prodCompra.idprod }">
						</div>
						<div>
							<input type="hidden" id="txtDescripcion" name="txtDescripcion"
								value="${prodCompra.descripcion }">
						</div>
						<div>
							<input type="hidden" id="txtPrecio" name="txtPrecio"
								value="${prodCompra.precio }">
						</div>
						<table class="table">
							<tr>
								<td>
									<table>
										<tr>
											<td><img src="img/${prodCompra.idprod }.jpg" alt=""></td>
										</tr>
									</table>
								</td>
								<td><br></td>
								<td>
									<table>
										<tr>
											<td><label>Cod producto :</label></td>
											<td><label>${prodCompra.idprod }</label> <a href="#"><img
													src="img/lupa.png" alt=""> </a></td>
										</tr>
										<tr>
											<td>Descripción :</td>
											<td><label>${prodCompra.descripcion }</label></td>
										</tr>
										<tr>
											<td>Precio :</td>
											<td><label><fmt:setLocale value="es_PE" /> <fmt:formatNumber
														type="currency" value="${prodCompra.precio}" /></label></td>
										</tr>
										<tr>
											<td>Cantidad a comprar :</td>
											<td><input type="number" id="txtCantidad"
												name="txtCantidad" min="1" max="" value="1"></td>
										</tr>

										<tr>
											<td>
												<button class="btn btn-primary" name="opcion" value="ac">
													Agregar compra <span
														class="glyphicon glyphicon-shopping-cart"></span>
												</button>
										</tr>

									</table>
								</td>

							</tr>
						</table>


					</form>
				</fieldset>
			</section>
		</main>
		<footer> </footer>
	</div>

</body>
</html>