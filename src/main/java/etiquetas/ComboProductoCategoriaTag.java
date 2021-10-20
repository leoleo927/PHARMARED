package etiquetas;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import beans.ProductoCategoriaDTO;

import dao.DAOFactory;

public class ComboProductoCategoriaTag extends TagSupport {
	private int idCategoria;

	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try {
			DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			ArrayList<ProductoCategoriaDTO> lista = fabrica.getProductoCategoriaDAO().listar();
			out.println("<option value='-1'>Seleccione</option>");
			for (ProductoCategoriaDTO c : lista) {
				if (c.getIdCategoria() == idCategoria) {
					out.println("<option value='" + c.getIdCategoria() + "' selected>" + c.getDescripcion() + "</option>");
				} else {
					out.println("<option value='" + c.getIdCategoria() + "'>" + c.getDescripcion() + "</option>");
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
