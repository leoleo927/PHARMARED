package beans;

public class ProductoCategoriaDTO {
	private int idCategoria;
	private String descripcion;

	public ProductoCategoriaDTO() {
		super();
	}

	public ProductoCategoriaDTO(int idCategoria, String descripcion) {
		super();
		this.idCategoria = idCategoria;
		this.descripcion = descripcion;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
