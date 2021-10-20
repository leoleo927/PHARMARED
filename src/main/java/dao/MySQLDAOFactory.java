package dao;

import interfaces.EstadoDAO;
import interfaces.ProductoCategoriaDAO;
import interfaces.ProductoDAO;
import interfaces.UsuarioDAO;
import interfaces.UsuarioTipoDAO;
import mantenimiento.MySQLEstadoDAO;
import mantenimiento.MySQLProductoCategoriaDAO;
import mantenimiento.MySQLProductoDAO;
import mantenimiento.MySQLUsuarioDAO;
import mantenimiento.MySQLUsuarioTipoDAO;

public class MySQLDAOFactory extends DAOFactory {

	@Override
	public UsuarioDAO getUsuarioDAO() {
		return new MySQLUsuarioDAO();
	}

	@Override
	public UsuarioTipoDAO getUsuarioTipoDAO() {
		// TODO Auto-generated method stub
		return new MySQLUsuarioTipoDAO();
	}

	@Override
	public ProductoDAO getProductoDAO() {
		return new MySQLProductoDAO();
	}

	@Override
	public ProductoCategoriaDAO getProductoCategoriaDAO() {
		return new MySQLProductoCategoriaDAO();
	}

	@Override
	public EstadoDAO getEstadoDAO() {
		// TODO Auto-generated method stub
		return new MySQLEstadoDAO();
	}

}
