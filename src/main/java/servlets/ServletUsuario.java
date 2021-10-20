package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.UsuarioDTO;
import dao.DAOFactory;
import mantenimiento.MySQLUsuarioDAO;

/**
 * Servlet implementation class ServletUsuario
 */
@WebServlet(name = "usu", urlPatterns = { "/usu" })
public class ServletUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletUsuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String opc = request.getParameter("opcion");
		System.out.println("opcion selecionada: " + opc);

		switch (opc) {
		case "ls":
			listar(request, response);
			break;
		case "q":
			buscar(request, response);
			break;
		case "r":
			registrar(request, response);
			break;
		case "a":
			actualizar(request, response);
			break;
		case "e":
			eliminar(request, response);
			break;

		default:
			System.out.println("opcion no disponible");
		}
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entro al Listado");
		request.getRequestDispatcher("UsuarioListado.jsp").forward(request, response);
	}

	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entro a buscar");
		// ArrayList<ProductoDTO> lista =new MSQLProductoDAO().listado();
		int codigo = Integer.parseInt(request.getParameter("cod"));
		DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		UsuarioDTO usuario = fabrica.getUsuarioDAO().listarByCodigo(codigo);
		request.setAttribute("usuarioCrud", usuario);
		request.getRequestDispatcher("UsuarioActualizar.jsp").forward(request, response);

	}

	private void registrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mensaje = "";
		String url;

		String nombre = request.getParameter("txtNombre");
		String apellido = request.getParameter("txtApellido");
		String usuario = request.getParameter("txtUsuario");
		String clave = request.getParameter("txtClave");
		String fnacim = request.getParameter("txtFecha");
		int tipo = Integer.parseInt(request.getParameter("cboTipo"));
		int estado = Integer.parseInt(request.getParameter("cboEstado"));

		UsuarioDTO u = new UsuarioDTO(0, nombre, apellido, usuario, clave, fnacim, tipo, estado);
		DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		int respuesta = fabrica.getUsuarioDAO().registrar(u);

		if (respuesta == 1) {
			mensaje = "<script>alert('Usuario registrado');</script>";
			url = "UsuarioListado.jsp";
		} else {
			mensaje = "<script>alert('Usuario no registrado');</script>";
			url = "UsuarioRegistrar.jsp";
		}
		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher(url).forward(request, response);
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mensaje = "";
		String url;

		int codigo = Integer.parseInt(request.getParameter("txtCodigo"));
		String nombre = request.getParameter("txtNombre");
		String apellido = request.getParameter("txtApellido");
		String usuario = request.getParameter("txtUsuario");
		String clave = request.getParameter("txtClave");
		String fnacim = request.getParameter("txtFecha");
		int tipo = Integer.parseInt(request.getParameter("cboTipo"));
		int estado = Integer.parseInt(request.getParameter("cboEstado"));

		UsuarioDTO u = new UsuarioDTO(codigo, nombre, apellido, usuario, clave, fnacim, tipo, estado);
		DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		int respuesta = fabrica.getUsuarioDAO().actualizar(u);

		if (respuesta == 1) {
			mensaje = "<script>alert('Usuario actualizado');</script>";
			url = "UsuarioListado.jsp";
		} else {
			mensaje = "<script>alert('Usuario no Actualizado');</script>";
			url = "UsuarioActualizar.jsp";
		}
		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher(url).forward(request, response);

	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mensaje = "";
		String url;
		
		int codigo = Integer.parseInt(request.getParameter("cod"));
		UsuarioDTO u = new UsuarioDTO();
		u.setCodigo(codigo);
		DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		int respuesta = fabrica.getUsuarioDAO().eliminar(u);

		if (respuesta == 1) {
			mensaje = "<script>alert('Usuario eliminado');</script>";
			url = "UsuarioListado.jsp";
		} else {
			mensaje = "<script>alert('Usuario no eliminado');</script>";
			url = "UsuarioListado.jsp";
		}
		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
