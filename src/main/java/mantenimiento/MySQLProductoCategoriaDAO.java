package mantenimiento;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.ProductoCategoriaDTO;
import interfaces.ProductoCategoriaDAO;
import utils.MySQLConexion8;

public class MySQLProductoCategoriaDAO implements ProductoCategoriaDAO {

	@Override
	public ArrayList<ProductoCategoriaDTO> listar() {
		ArrayList<ProductoCategoriaDTO> lista = null;
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "{call tb_categorias_sp_listar()}";
			cst = con.prepareCall(sql);
			rs = cst.executeQuery();
			lista = new ArrayList<ProductoCategoriaDTO>();
			while (rs.next()) {
				ProductoCategoriaDTO c = new ProductoCategoriaDTO(rs.getInt(1), rs.getString(2));
				lista.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MySQLConexion8.closeConexion(con);
		}
		return lista;
	}
}
