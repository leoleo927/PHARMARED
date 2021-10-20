package etiquetas;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import beans.ProductoCategoriaDTO;
import beans.ProductoDTO;
import dao.DAOFactory;

public class ProductoCatalogoTag extends TagSupport {
	private int idCategoria;

	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try {
			DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			ArrayList<ProductoDTO> lista = fabrica.getProductoDAO().listarByCategoria(idCategoria);

			for (int i = 0; i < lista.size(); i++) {
				ProductoDTO p = lista.get(i);
				if ((i + 1) % 3 == 1) {
					out.println("<tr>");
					out.println("<td>");
					out.println("<div class=\"card\">");
					out.println("<img src=\"img/" + p.getIdprod() + ".jpg\" class=\"card-img-top\" alt=\""
							+ p.getIdprod() + "\">");
					out.println("<div class=\"card-body\">");
					out.println("<h5 class=\"card-title\">" + p.getDescripcion() + "</h5>");
					out.println("<p class=\"card-text\">" + p.getPrecio() + "</p>");
					out.println("<a href=\"prod?opcion=s&idProd=" + p.getIdprod() + "\""
							+ " class=\"btn btn-primary\">Comprar</a>\r\n");
					out.println("</div>");
					out.println("</div>");
					out.println("</td>");
					if (i == lista.size() - 1) {
						out.println("<tr>");
					}
				} else if ((i + 1) % 3 == 2) {
					out.println("<td>");
					out.println("<div class=\"card\">");
					out.println("<img src=\"img/" + p.getIdprod() + ".jpg\" class=\"card-img-top\" alt=\""
							+ p.getIdprod() + "\">");
					out.println("<div class=\"card-body\">");
					out.println("<h5 class=\"card-title\">" + p.getDescripcion() + "</h5>");
					out.println("<p class=\"card-text\">" + p.getPrecio() + "</p>");
					out.println("<a href=\"prod?opcion=s&idProd=" + p.getIdprod() + "\""
							+ " class=\"btn btn-primary\">Comprar</a>\r\n");
					out.println("</div>");
					out.println("</div>");
					out.println("</td>");
					if (i == lista.size() - 1) {
						out.println("<tr>");
					}
				} else if ((i + 1) % 3 == 0) {
					out.println("<td>");
					out.println("<div class=\"card\">");
					out.println("<img src=\"img/" + p.getIdprod() + ".jpg\" class=\"card-img-top\" alt=\""
							+ p.getIdprod() + "\">");
					out.println("<div class=\"card-body\">");
					out.println("<h5 class=\"card-title\">" + p.getDescripcion() + "</h5>");
					out.println("<p class=\"card-text\">" + p.getPrecio() + "</p>");
					out.println("<a href=\"prod?opcion=s&idProd=" + p.getIdprod() + "\""
							+ " class=\"btn btn-primary\">Comprar</a>\r\n");
					out.println("</div>");
					out.println("</div>");
					out.println("</td>");
					out.println("<tr>");
				}
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

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
}
