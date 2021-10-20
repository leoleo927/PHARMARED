package mantenimiento;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.EstadoDTO;
import interfaces.EstadoDAO;
import utils.MySQLConexion8;

public class MySQLEstadoDAO implements EstadoDAO {

	@Override
	public ArrayList<EstadoDTO> listar() {
		ArrayList<EstadoDTO> lista = null;
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "{call tb_estados_sp_listar()}";
			cst = con.prepareCall(sql);
			rs = cst.executeQuery();
			lista = new ArrayList<EstadoDTO>();
			while (rs.next()) {
				EstadoDTO c = new EstadoDTO(rs.getInt(1), rs.getString(2));
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
