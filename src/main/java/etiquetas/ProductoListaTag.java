package etiquetas;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import beans.ProductoCategoriaDTO;
import beans.ProductoDTO;
import dao.DAOFactory;

public class ProductoListaTag extends TagSupport {

	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try {
			DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			ArrayList<ProductoDTO> lista = fabrica.getProductoDAO().listar();

			for (int i = 0; i < lista.size(); i++) {
				ProductoDTO p = lista.get(i);
				out.println("<tr>");
				out.println("<td>");
				out.println("<div style=\"width:100px;\"><img src=\"img/" + p.getIdprod()
						+ ".jpg\" class=\"card-img-top\" alt=\"" + p.getIdprod() + "\" width=\"100\"></div>");
				out.println("</td>");
				out.println("<td>");
				out.println("<p>" + p.getIdprod() + "</p>");
				out.println("</td>");
				out.println("<td>");
				out.println("<p>" + p.getDescripcion() + "</p>");
				out.println("</td>");
				out.println("<td>");
				out.println("<p>" + p.getStock() + "</p>");
				out.println("</td>");
				out.println("<td>");
				out.println("<p>" + p.getPrecio() + "</p>");
				out.println("</td>");
				out.println("<td>");
				out.println("<p>" + p.getIdCategoria() + "</p>");
				out.println("</td>");
				out.println("<td>");
				out.println("<p>" + p.getEstado() + "</p>");
				out.println("</td>");
				out.println("<td>");
				out.println("<a class=\"btn btn-success\" href=\"prod?opcion=q&idprod=" + p.getIdprod()
						+ "\"><i class=\"bi bi-pencil-fill\"></i></a>");
				out.println("<a class=\"btn btn-danger\" href=\"prod?opcion=e&idprod=" + p.getIdprod()
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
