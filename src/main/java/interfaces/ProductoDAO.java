package interfaces;

import java.util.ArrayList;

import beans.ProductoDTO;

public interface ProductoDAO {
	public ArrayList<ProductoDTO> listar();

	public ArrayList<ProductoDTO> listarByCategoria(int idCategoria);

	public ProductoDTO listarById(String idprod);

	public int registrar(ProductoDTO p);
	
	public int eliminar(ProductoDTO p);

	public int actualizar(ProductoDTO p);
}
