package etiquetas;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import beans.UsuarioDTO;
import dao.DAOFactory;

public class UsuarioListaTag extends TagSupport {

	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try {
			DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			ArrayList<UsuarioDTO> lista = fabrica.getUsuarioDAO().listar();

			for (int i = 0; i < lista.size(); i++) {
				UsuarioDTO u = lista.get(i);
				out.println("<tr>");
				out.println("<td>");
				out.println("<div style=\"width:100px;\"><img src=\"img/P0001.jpg\" class=\"card-img-top\" alt=\""
						+ u.getCodigo() + "\" width=\"100\"></div>");
				out.println("</td>");
				out.println("<td>");
				out.println("<p>" + u.getCodigo() + "</p>");
				out.println("</td>");
				out.println("<td>");
				out.println("<p>" + u.getNombre() + "</p>");
				out.println("</td>");
				out.println("<td>");
				out.println("<p>" + u.getApellido() + "</p>");
				out.println("</td>");
				out.println("<td>");
				out.println("<p>" + u.getUsuario() + "</p>");
				out.println("</td>");
				out.println("<td>");
				out.println("<p>" + u.getTipo() + "</p>");
				out.println("</td>");
				out.println("<td>");
				out.println("<p>" + u.getEstado() + "</p>");
				out.println("</td>");
				out.println("<td>");
				out.println("<a class=\"btn btn-success\" href=\"usu?opcion=q&cod=" + u.getCodigo()
						+ "\"><i class=\"bi bi-pencil-fill\"></i></a>");
				out.println("<a class=\"btn btn-danger\" href=\"usu?opcion=e&cod=" + u.getCodigo()
						+ "\"><i class=\"bi bi-x-lg\"></i></a>");
				out.println("</td>");
				out.println("<tr>");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en CabeceraTag: " + e.getMessage());
		}
		return SKIP_BODY;
	}

	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}
}
