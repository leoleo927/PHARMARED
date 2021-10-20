package etiquetas;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class CabeceraTag extends TagSupport {
	private String tituloPagina;

	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try {
			out.println(
					"<div id=\"carouselExampleDark\" class=\"carousel carousel-dark slide\" data-bs-ride=\"carousel\">");
			out.println("<div class=\"carousel-indicators\">");
			out.println(
					"<button type=\"button\" data-bs-target=\"#carouselExampleDark\" data-bs-slide-to=\"0\" class=\"active\" aria-current=\"true\" aria-label=\"Slide 1\"></button>");
			out.println(
					"<button type=\"button\" data-bs-target=\"#carouselExampleDark\" data-bs-slide-to=\"1\" aria-label=\"Slide 2\"></button>");
			out.println(
					"<button type=\"button\" data-bs-target=\"#carouselExampleDark\" data-bs-slide-to=\"2\" aria-label=\"Slide 3\"></button>");
			out.println("</div>");
			out.println("<div class=\"carousel-inner\">");
			out.println("<div class=\"carousel-item active\" data-bs-interval=\"5000\">");
			out.println("<img src=\"img/Banner1.jpeg\" class=\"d-block w-100\" alt=\"Banner1\">");
			out.println("</div>");
			out.println("<div class=\"carousel-item\" data-bs-interval=\"5000\">");
			out.println("<img src=\"img/Banner2.jpeg\" class=\"d-block w-100\" alt=\"Banner2\">");
			out.println("</div>");
			out.println("<div class=\"carousel-item\" data-bs-interval=\"5000\">");
			out.println("<img src=\"img/Banner3.jpeg\" class=\"d-block w-100\" alt=\"Banner3\">");
			out.println("</div>");
			out.println("</div>");
			out.println(
					"<button class=\"carousel-control-prev\" type=\"button\" data-bs-target=\"#carouselExampleDark\" data-bs-slide=\"prev\">");
			out.println("<span class=\"carousel-control-prev-icon\" aria-hidden=\"true\"></span>");
			out.println("<span class=\"visually-hidden\">Previous</span>");
			out.println("</button>");
			out.println(
					"<button class=\"carousel-control-next\" type=\"button\" data-bs-target=\"#carouselExampleDark\" data-bs-slide=\"next\">");
			out.println("<span class=\"carousel-control-next-icon\" aria-hidden=\"true\"></span>");
			out.println("<span class=\"visually-hidden\">Next</span>");
			out.println("</button>");
			out.println("</div>");
			out.println("<br>");
			out.println("<h1 class=\"text-center\">" + tituloPagina + "</h1>");
			out.println("<br>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en CabeceraTag: " + e.getMessage());
		}
		return SKIP_BODY;
	}

	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}

	public String getTituloPagina() {
		return tituloPagina;
	}

	public void setTituloPagina(String tituloPagina) {
		this.tituloPagina = tituloPagina;
	}
}
