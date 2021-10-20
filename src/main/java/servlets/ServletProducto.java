package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ProductoDTO;
import dao.DAOFactory;
import interfaces.ProductoDAO;
import mantenimiento.MySQLProductoDAO;

/**
 * Servlet implementation class ProductoServlet
 */
@WebServlet(name = "prod", urlPatterns = { "/prod" })
public class ServletProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletProducto() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
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
		case "r":
			registrar(request, response);
			break;
		case "a":
			actualizar(request, response);
			break;
		case "e":
			eliminar(request, response);
			break;
		case "ls":
			listar(request, response);
			break;
		case "q":
			buscar(request, response);
			break;
		case "s":
			seleccionar(request, response);
			break;
		case "c":
			cargar(request, response);
			break;
		case "f":
			filtrar(request, response);
			break;
		default:
			response.sendRedirect("error.jsp");
		}
	}

	private void seleccionar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// obtener la info de un producto y lo envia a la pagina compra
		System.out.println("-- Entró a buscar el producto --");
		// entradas
		String idProd = request.getParameter("idProd");
		DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ProductoDTO p = fabrica.getProductoDAO().listarById(idProd);

		request.setAttribute("prodCompra", p);

		// request.getRequestDispatcher("/compra.jsp").forward(request, response);
		request.getRequestDispatcher("Compra.jsp").forward(request, response);
	}

	private void filtrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idCategoria = Integer.parseInt(request.getParameter("idCategoria"));
		request.getSession().setAttribute("idCategoria", idCategoria);
		request.getRequestDispatcher("ProductoCatalogo.jsp").forward(request, response);
	}

	private void cargar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entró a listar");

		DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ArrayList<ProductoDTO> lista = fabrica.getProductoDAO().listar();

		// enviar el listado al JSP
		request.setAttribute("lstProductos", lista);
		request.getRequestDispatcher("ProductoCatalogo.jsp").forward(request, response);

	}

	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-- Entró a buscar el producto --");
		// entradas
		String idprod = request.getParameter("idprod");
		DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		ProductoDTO p = fabrica.getProductoDAO().listarById(idprod);
		request.setAttribute("prodCrud", p);
		request.getRequestDispatcher("ProductoActualizar.jsp").forward(request, response);
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// entrada
		System.out.println("Entró al listado");
		request.getRequestDispatcher("ProductoListado.jsp").forward(request, response);
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("-- Entró a eliminar el producto --");
		// entradas
		String mensaje = "";
		String url;

		String idprod = request.getParameter("idprod");
		DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);

		ProductoDTO p = new ProductoDTO();
		p.setIdprod(idprod);

		int respuesta = fabrica.getProductoDAO().eliminar(p);

		if (respuesta == 1) {
			mensaje = "<script>alert('Producto eliminado');</script>";
			url = "ProductoListado.jsp";
		} else {
			mensaje = "<script>alert('Producto no eliminado');</script>";
			url = "ProductoListado.jsp";
		}
		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher(url).forward(request, response);
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mensaje = "";
		String url;

		String idprod = request.getParameter("txtIdProd");
		String descripcion = request.getParameter("txtDescripcion");
		int stock = Integer.parseInt(request.getParameter("txtStock"));
		Double precio = Double.parseDouble(request.getParameter("txtPrecio"));
		int idCategoria = Integer.parseInt(request.getParameter("cboCategoria"));
		int estado = Integer.parseInt(request.getParameter("cboEstado"));

		ProductoDTO p = new ProductoDTO(idprod, descripcion, stock, precio, idCategoria, estado);
		DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);

		int respuesta = fabrica.getProductoDAO().actualizar(p);

		if (respuesta == 1) {
			mensaje = "<script>alert('Producto actualizado');</script>";
			url = "ProductoListado.jsp";
		} else {
			mensaje = "<script>alert('Producto no actualizado');</script>";
			url = "ProductoCrud.jsp";
		}
		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher(url).forward(request, response);
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mensaje = "";
		String url;

		String idprod = request.getParameter("txtIdProd");
		String descripcion = request.getParameter("txtDescripcion");
		int stock = Integer.parseInt(request.getParameter("txtStock"));
		Double precio = Double.parseDouble(request.getParameter("txtPrecio"));
		int idCategoria = Integer.parseInt(request.getParameter("cboCategoria"));
		int estado = Integer.parseInt(request.getParameter("cboEstado"));

		ProductoDTO p = new ProductoDTO(idprod, descripcion, stock, precio, idCategoria, estado);
		DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);

		int respuesta = fabrica.getProductoDAO().registrar(p);

		if (respuesta == 1) {
			mensaje = "<script>alert('Producto creado');</script>";
			url = "ProductoListado.jsp";
		} else {
			mensaje = "<script>alert('Producto no creado');</script>";
			url = "ProductoCrud.jsp";
		}
		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher(url).forward(request, response);
	}
}
