package mantenimiento;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.UsuarioTipoDTO;
import interfaces.UsuarioTipoDAO;
import utils.MySQLConexion8;


public class MySQLUsuarioTipoDAO implements UsuarioTipoDAO {

	@Override
	public ArrayList<UsuarioTipoDTO> listar() {
		ArrayList<UsuarioTipoDTO> lista = null;
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "{call tb_tipos_sp_listar()}";
			cst = con.prepareCall(sql);
			rs = cst.executeQuery();
			lista = new ArrayList<UsuarioTipoDTO>();
			while (rs.next()) {
				UsuarioTipoDTO c = new UsuarioTipoDTO(rs.getInt(1), rs.getString(2));
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
