package beans;

public class PedidoDTO {
	private String idpedido;
	private String cod_cli;
	private String fech_ingr;
	private String fech_env;
	private int estado_pedido;
	private double total;

	public PedidoDTO() {
		super();
	}

	public PedidoDTO(String idpedido, String cod_cli, String fech_ingr, String fech_env, int estado_pedido,
			double total) {
		super();
		this.idpedido = idpedido;
		this.cod_cli = cod_cli;
		this.fech_ingr = fech_ingr;
		this.fech_env = fech_env;
		this.estado_pedido = estado_pedido;
		this.total = total;
	}

	public String getIdpedido() {
		return idpedido;
	}

	public void setIdpedido(String idpedido) {
		this.idpedido = idpedido;
	}

	public String getCod_cli() {
		return cod_cli;
	}

	public void setCod_cli(String cod_cli) {
		this.cod_cli = cod_cli;
	}

	public String getFech_ingr() {
		return fech_ingr;
	}

	public void setFech_ingr(String fech_ingr) {
		this.fech_ingr = fech_ingr;
	}

	public String getFech_env() {
		return fech_env;
	}

	public void setFech_env(String fech_env) {
		this.fech_env = fech_env;
	}

	public int getEstado_pedido() {
		return estado_pedido;
	}

	public void setEstado_pedido(int estado_pedido) {
		this.estado_pedido = estado_pedido;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
}
