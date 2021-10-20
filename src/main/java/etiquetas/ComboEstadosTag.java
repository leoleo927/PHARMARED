package etiquetas;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import beans.EstadoDTO;
import beans.ProductoCategoriaDTO;
import beans.UsuarioTipoDTO;
import dao.DAOFactory;

public class ComboEstadosTag extends TagSupport {
	private int estado;

	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try {
			DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
			ArrayList<EstadoDTO> lista = fabrica.getEstadoDAO().listar();
			for (EstadoDTO e : lista) {
				if (e.getIdEstado() == estado) {
					out.println("<option value='" + e.getIdEstado() + "' selected>" + e.getDescripcion() + "</option>");
				} else {
					out.println("<option value='" + e.getIdEstado() + "'>" + e.getDescripcion() + "</option>");
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

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

}
