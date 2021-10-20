<%@page import="beans.ProductoDTO"%>
<%@page import="beans.UsuarioDTO"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			<tools:cabecera tituloPagina="Carrito de compra" />
		</header>

		<main>

			<section class="container" style="width: 100%;">
				<div class="row justify-content-center">
					<div class="col-3 text-center">
						<a href="prod?opcion=f&idCategoria=1" class="btn btn-primary">Continuar
							comprando <span class="glyphicon glyphicon-repeat"></span>
						</a>
					</div>
				</div>
				<br>
				<div class="table-responsive" style="width: 70%; float: left;">
					<table class="table">
						<tr>
							<th></th>
							<th>Id</th>
							<th>Descripcion</th>
							<th>Cantidad</th>
							<th>Precio</th>
							<th>Eliminar</th>
						</tr>
						<%
							// obtiene el listado enviado desde el servlet
						ArrayList<ProductoDTO> lstProductos = (ArrayList<ProductoDTO>) request.getAttribute("carrito");
						double subtotal = (double) request.getAttribute("subtotal");
						if (lstProductos != null) {
							for (ProductoDTO x : lstProductos) {
						%>
						<tr class="grilla_campo">
							<td><img alt="" src="img/productos/<%=x.getIdprod()%>.png"
								width="100px"></td>
							<td><%=x.getIdprod()%></td>
							<td><%=x.getDescripcion()%></td>
							<td><%=x.getStock()%></td>
							<td>S/.<%=new DecimalFormat("#0.00").format(x.getPrecio())%></td>
							<td><a class="btn btn-danger"
								href="venta?idprod=<%=x.getIdprod()%>&opcion=qc"><i
									class="bi bi-x-lg"></i></a></td>
							<td></td>
						</tr>

						<%
							}
						}
						%>
					</table>
				</div>
				<div
					style="width: 29%; height: 400px; float: left; border: 1px solid">
					<h1>Resumen de pedido</h1>
					<hr>
					<%-- muestra la variable global enviada desde el Listener --%>
					<table class="table">
						<tr>
							<td>Sub total S/.</td>
							<td><%=subtotal%></td>
						</tr>
					</table>

					<form action="venta" method="post">
						<button class="btn btn-primary" name="opcion" value="rv">
							Procesar compra <span class="glyphicon glyphicon-ok"></span>
						</button>
					</form>


				</div>
			</section>
		</main>
		<footer> </footer>
	</div>





</body>
</html>

