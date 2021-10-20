package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.UsuarioDTO;
import dao.DAOFactory;
import mantenimiento.MySQLUsuarioDAO;

/**
 * Servlet implementation class ServletUsuarioLog
 */
@WebServlet(name = "index", urlPatterns = { "/index" })
public class ServletUsuarioLog extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletUsuarioLog() {
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
		case "index":
			index(request, response);
			break;
		case "li":
			logIn(request, response);
			break;
		case "r":
			registrar(request, response);
			break;
		case "a":
			actualizarPerfil(request, response);
			break;
		case "lo":
			logOut(request, response);
			break;

		default:
			System.out.println("opcion no disponible");
		}
	}

	private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "LogIn.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

	private void logIn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url;
		String usuario = request.getParameter("txtUsuario");
		String clave = request.getParameter("txtClave");

		UsuarioDTO u = new UsuarioDTO();
		u.setUsuario(usuario);
		u.setClave(clave);

		DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		UsuarioDTO uLogIn = fabrica.getUsuarioDAO().logIn(u);

		if (uLogIn == null) {
			url = "LogIn.jsp";
			request.setAttribute("mensaje", "<script>alert('Usuario Inexistente');</script>");
		} else {
			request.getSession().setAttribute("usuLogIn", uLogIn);
			url = "Principal.jsp";
			request.setAttribute("mensaje", "<script>alert('Bienvenido Usuario');</script>");
		}
		request.getRequestDispatcher(url).forward(request, response);

	}

	private void logOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "LogIn.jsp";
		request.getSession().removeAttribute("usuLogIn");
		request.getRequestDispatcher(url).forward(request, response);
	}

	private void actualizarPerfil(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mensaje = "";
		String url;

		int codigo = Integer.parseInt(request.getParameter("txtCodigo"));
		String nombre = request.getParameter("txtNombre");
		String apellido = request.getParameter("txtApellido");
		String usuario = request.getParameter("txtUsuario");
		String clave = request.getParameter("txtClave");
		String fnacim = request.getParameter("txtFecha");

		UsuarioDTO u = new UsuarioDTO(codigo, nombre, apellido, usuario, clave, fnacim);
		DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		int respuesta = fabrica.getUsuarioDAO().actualizarPerfil(u);

		System.out.println("Respuesta: " + respuesta);

		if (respuesta == 1) {
			mensaje = "<script>alert('Usuario actualizado');</script>";
			url = "Principal.jsp";
		} else {
			mensaje = "<script>alert('Usuario no Actualizado');</script>";
			url = "Perfil.jsp";
		}
		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher(url).forward(request, response);

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
		int tipo = 2;
		int estado = 1;

		UsuarioDTO u = new UsuarioDTO(0, nombre, apellido, usuario, clave, fnacim, tipo, estado);
		DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		int respuesta = fabrica.getUsuarioDAO().registrar(u);

		if (respuesta == 1) {
			mensaje = "<script>alert('Usuario registrado');</script>";
			url = "LogIn.jsp";
		} else {
			mensaje = "<script>alert('Usuario no registrado');</script>";
			url = "LogIn.jsp";
		}
		request.setAttribute("mensaje", mensaje);
		request.getRequestDispatcher(url).forward(request, response);
	}
}
