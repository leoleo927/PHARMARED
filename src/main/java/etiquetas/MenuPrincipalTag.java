package etiquetas;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class MenuPrincipalTag extends TagSupport {

	// atributo
	private int tipo = 2;
	private String nombre = "";
	private String apellido = "";

	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try {
			out.println("<a class=\"btn btn-secondary\" href=\"Principal.jsp\">Inicio</a>");
			out.println("<ul class=\"navbar-nav me-auto mb-2 mb-lg-0 w-50\">");
			out.println(
					"<li class=\"nav-item\"><a class=\"btn btn-secondary\" href=\"ProductoCatalogo.jsp\">Catálogo</a></li>");
			if (tipo != 2) {
				out.println("<li class=\"nav-item dropdown\">");
				out.println(
						"<a class=\"btn btn-secondary dropdown-toggle\" href=\"#\" id=\"navbarMantenimientos\" role=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">Mantenimientos</a>");
				out.println("<ul class=\"dropdown-menu\" aria-labelledby=\"navbarMantenimientos\">");
				out.println(
						"<li class=\"dropdown-item\"><a class=\"nav-link\" href=\"UsuarioListado.jsp\">Usuarios</a></li>");
				out.println(
						"<li class=\"dropdown-item\"><a class=\"nav-link\" href=\"ProductoListado.jsp\">Producto</a></li>");
				out.println("</ul>");
				out.println("</li>");
				
				out.println("<li class=\"nav-item dropdown\">");
				out.println(
						"<a class=\"btn btn-secondary dropdown-toggle\" href=\"#\" id=\"navbarReportes\" role=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">Reportes</a>");
				out.println("<ul class=\"dropdown-menu\" aria-labelledby=\"navbarReportes\">");
				out.println(
						"<li class=\"dropdown-item\"><a class=\"nav-link\" href=\"ReporteVenta.jsp\">Venta</a></li>");
				out.println("</ul>");
				out.println("</li>");
			}

			out.println(
					"<li class=\"nav-item\"><a class=\"btn btn-secondary\" href=\"venta?opcion=lc\">Canasta de Compra</a></li>");
			out.println("</ul>");
			out.println("<span class=\"navbar-text\">Usted se ha identificado como: <strong>" + nombre + " " + apellido
					+ "<strong></span>");
			out.println("<ul class=\"navbar-nav me-auto mb-2 mb-lg-0 w-100\">");
			out.println(
					"<li class=\"nav-item\"><a class=\"btn btn-secondary btn-sm\" href=\"Perfil.jsp\">Mi Perfil</a></li>");
			out.println(
					"<li class=\"nav-item\"><a class=\"btn btn-secondary btn-sm\" href=\"index?opcion=lo\">Cerrar Sesión</a></li>");
			out.println("</ul>");
			out.println("");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en MenuPrincipalTag: " + e.getMessage());
		}
		return SKIP_BODY;
	}

	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

}
