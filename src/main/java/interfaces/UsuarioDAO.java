package interfaces;

import java.util.ArrayList;

import beans.UsuarioDTO;

public interface UsuarioDAO {
	public UsuarioDTO logIn(UsuarioDTO u);

	public ArrayList<UsuarioDTO> listar();

	public UsuarioDTO listarByCodigo(int codigo);

	public int registrar(UsuarioDTO u);

	public int actualizar(UsuarioDTO u);
	
	public int actualizarPerfil(UsuarioDTO u);

	public int eliminar(UsuarioDTO u);

	public int logOut(UsuarioDTO u);
}
