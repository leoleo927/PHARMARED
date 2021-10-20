package dao;

import interfaces.EstadoDAO;
import interfaces.ProductoCategoriaDAO;
import interfaces.ProductoDAO;
import interfaces.UsuarioDAO;
import interfaces.UsuarioTipoDAO;

public abstract class DAOFactory {
	public static final int MYSQL = 1;
	public static final int SQL = 2;
	public static final int ORCLE = 3;

	public abstract UsuarioDAO getUsuarioDAO();
	
	public abstract UsuarioTipoDAO getUsuarioTipoDAO();

	public abstract ProductoDAO getProductoDAO();

	public abstract ProductoCategoriaDAO getProductoCategoriaDAO();
	
	public abstract EstadoDAO getEstadoDAO();

	public static DAOFactory getDAOFactory(int qBD) {
		switch (qBD) {
		case MYSQL:
			return new MySQLDAOFactory();
		// otros
		default:
			return null;

		}

	}
}
