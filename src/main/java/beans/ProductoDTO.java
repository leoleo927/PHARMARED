package beans;

public class ProductoDTO {
	private String idprod;
	private String descripcion;
	private int stock;
	private double precio;
	private int idCategoria;
	private int estado;

	public ProductoDTO() {
		super();
	}

	public ProductoDTO(String idprod, String descripcion, int stock, double precio, int idCategoria, int estado) {
		super();
		this.idprod = idprod;
		this.descripcion = descripcion;
		this.stock = stock;
		this.precio = precio;
		this.idCategoria = idCategoria;
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "ProductoDTO [id=" + idprod + ", descripcion=" + descripcion + ", stock=" + stock + ", idCategoria="
				+ idCategoria + ", precio=" + precio + ", estado=" + estado + "]";
	}

	public String getIdprod() {
		return idprod;
	}

	public void setIdprod(String idprod) {
		this.idprod = idprod;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

}
