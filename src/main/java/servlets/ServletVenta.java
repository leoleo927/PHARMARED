package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ProductoDTO;
import dao.DAOFactory;
import mantenimiento.MySQLProductoDAO;

/**
 * Servlet implementation class ServletCompra
 */
@WebServlet(name = "venta", urlPatterns = { "/venta" })
public class ServletVenta extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletVenta() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Entro al servlet de producto");
		String opc = request.getParameter("opcion");
		opc = (opc == null ? "error" : opc);
		System.out.println("Opcion seleccionada : " + opc);

		switch (opc) {
		case "lc":
			listarCarrito(request, response);
			break;
		case "ac":
			agregarCarrito(request, response);
			break;
		case "qc":
			quitarCarrito(request, response);
			break;
		case "rv":
			realizarVenta(request, response);
			break;
		default:
			response.sendRedirect("LogIn.jsp");
		}
	}

	private void listarCarrito(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<ProductoDTO> carrito;
		double subtotal = 0.0;
		if (request.getSession().getAttribute("carrito") != null) {
			carrito = (ArrayList<ProductoDTO>) request.getSession().getAttribute("carrito");
			for (ProductoDTO productoDTO : carrito) {
				subtotal += productoDTO.getPrecio() * productoDTO.getStock();
			}
		} else {
			carrito = new ArrayList<ProductoDTO>();
		}

		request.setAttribute("carrito", carrito);
		request.setAttribute("subtotal", subtotal);
		request.getRequestDispatcher("Canasta.jsp").forward(request, response);
	}

	private void agregarCarrito(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mensaje = "";

		// entradas
		String idprod = request.getParameter("txtIdpro");
		System.out.println(idprod);
		String descripcion = request.getParameter("txtDescripcion");
		int cantidad = Integer.parseInt(request.getParameter("txtCantidad"));
		double precio = Double.parseDouble(request.getParameter("txtPrecio"));

		ArrayList<ProductoDTO> carrito;
		if (request.getSession().getAttribute("carrito") != null) {
			carrito = (ArrayList<ProductoDTO>) request.getSession().getAttribute("carrito");
		} else {
			carrito = new ArrayList<ProductoDTO>();
		}
		ProductoDTO pBusqueda = null;
		int index = 0;

		for (int i = 0; i < carrito.size(); i++) {
			ProductoDTO p = carrito.get(i);

			if (p.getIdprod().equals(idprod)) {
				index = i;
				pBusqueda = p;
				break;
			}
		}
		if (pBusqueda == null) {
			pBusqueda = new ProductoDTO();
			pBusqueda.setIdprod(idprod);
			pBusqueda.setDescripcion(descripcion);
			pBusqueda.setStock(cantidad);
			pBusqueda.setPrecio(precio);
			carrito.add(pBusqueda);
		} else {
			pBusqueda.setIdprod(idprod);
			pBusqueda.setDescripcion(descripcion);
			pBusqueda.setStock(cantidad);
			pBusqueda.setPrecio(precio);
			carrito.set(index, pBusqueda);
		}

		request.getSession().setAttribute("carrito", carrito);

		mensaje = "<script>alert('Producto agregado al carrito');</script>";

		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher("ProductoCatalogo.jsp").forward(request, response);
	}

	private void quitarCarrito(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mensaje = "";
		double subtotal = 0.0;

		// entradas
		String idprod = request.getParameter("idprod");

		ArrayList<ProductoDTO> carrito;
		if (request.getSession().getAttribute("carrito") != null) {
			carrito = (ArrayList<ProductoDTO>) request.getSession().getAttribute("carrito");
		} else {
			carrito = new ArrayList<ProductoDTO>();
		}
		ProductoDTO pBusqueda = null;
		int index = 0;

		for (int i = 0; i < carrito.size(); i++) {
			ProductoDTO p = carrito.get(i);

			if (p.getIdprod().equals(idprod)) {
				index = i;
				pBusqueda = p;
				break;
			}
		}

		if (pBusqueda != null) {
			carrito.remove(index);
		}

		for (ProductoDTO productoDTO : carrito) {
			subtotal += productoDTO.getPrecio() * productoDTO.getStock();
		}

		request.getSession().setAttribute("carrito", carrito);

		mensaje = "<script>alert('Producto retirado del carrito');</script>";

		request.setAttribute("mensaje", mensaje);
		request.setAttribute("carrito", carrito);
		request.setAttribute("subtotal", subtotal);
		request.getRequestDispatcher("Canasta.jsp").forward(request, response);
	}

	private void realizarVenta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mensaje = "";

		request.getSession().setAttribute("carrito", new ArrayList<ProductoDTO>());

		mensaje = "<script>alert('Pedido generado');</script>";

		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher("Principal.jsp").forward(request, response);
	}
}
