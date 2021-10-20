package etiquetas;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import beans.UsuarioTipoDTO;
import dao.DAOFactory;

public class ComboUsuarioTipoTag extends TagSupport {
	private int tipo;

	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try {
			DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			ArrayList<UsuarioTipoDTO> lista = fabrica.getUsuarioTipoDAO().listar();
			out.println("<option value='-1'>Seleccione</option>");
			for (UsuarioTipoDTO ut : lista) {
				if (ut.getIdTipo() == tipo) {
					out.println("<option value='" + ut.getIdTipo() + "' selected>" + ut.getDescripcion() + "</option>");
				} else {
					out.println("<option value='" + ut.getIdTipo() + "'>" + ut.getDescripcion() + "</option>");
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

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
}
