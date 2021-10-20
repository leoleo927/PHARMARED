package mantenimiento;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.UsuarioDTO;
import interfaces.UsuarioDAO;
import utils.MySQLConexion8;

public class MySQLUsuarioDAO implements UsuarioDAO {
	@Override
	public UsuarioDTO logIn(UsuarioDTO u) {
		UsuarioDTO usu = null;
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "{call tb_usuarios_sp_validaAcceso(?,?)}";
			cst = con.prepareCall(sql);
			cst.setString(1, u.getUsuario());
			cst.setString(2, u.getClave());
			rs = cst.executeQuery();

			if (rs.next()) {
				usu = new UsuarioDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getInt(8));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MySQLConexion8.closeConexion(con);
		}
		return usu;
	}

	@Override
	public ArrayList<UsuarioDTO> listar() {
		ArrayList<UsuarioDTO> lista = null;
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "{call tb_usuarios_sp_listar()}";
			cst = con.prepareCall(sql);
			rs = cst.executeQuery();
			lista = new ArrayList<UsuarioDTO>();
			while (rs.next()) {
				UsuarioDTO u = new UsuarioDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8));
				lista.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MySQLConexion8.closeConexion(con);
		}
		return lista;
	}

	@Override
	public UsuarioDTO listarByCodigo(int codigo) {
		UsuarioDTO usuario = null;
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "{call tb_usuarios_sp_listar_x_codigo(?)}";
			cst = con.prepareCall(sql);
			cst.setInt(1, codigo);
			rs = cst.executeQuery();
			usuario = new UsuarioDTO();
			if (rs.next()) {
				usuario = new UsuarioDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MySQLConexion8.closeConexion(con);
		}
		return usuario;
	}

	@Override
	public int registrar(UsuarioDTO u) {
		int rs = 0;
		Connection con = null;
		CallableStatement cst = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "{call tb_usuarios_sp_registrar(?,?,?,?,?,?,?)}";
			cst = con.prepareCall(sql);
			cst.setString(1, u.getNombre());
			cst.setString(2, u.getApellido());
			cst.setString(3, u.getUsuario());
			cst.setString(4, u.getClave());
			cst.setString(5, u.getFnacim());
			cst.setInt(6, u.getTipo());
			cst.setInt(7, u.getEstado());
			rs = cst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error al crear usuario : " + e.getMessage());
		} finally {
			MySQLConexion8.closeConexion(con);
		}
		return rs;
	}

	@Override
	public int actualizar(UsuarioDTO u) {
		int rs = 0;
		Connection con = null;
		CallableStatement cst = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "{call tb_usuarios_sp_actualizar(?,?,?,?,?,?,?,?)}";
			cst = con.prepareCall(sql);
			cst.setInt(1, u.getCodigo());
			cst.setString(2, u.getNombre());
			cst.setString(3, u.getApellido());
			cst.setString(4, u.getUsuario());
			cst.setString(5, u.getClave());
			cst.setString(6, u.getFnacim());
			cst.setInt(7, u.getTipo());
			cst.setInt(8, u.getEstado());
			rs = cst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error al actualizar usuario : " + e.getMessage());
		} finally {
			MySQLConexion8.closeConexion(con);
		}
		return rs;
	}
	
	@Override
	public int actualizarPerfil(UsuarioDTO u) {
		int rs = 0;
		Connection con = null;
		CallableStatement cst = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "{call tb_usuarios_sp_actualizar_perfil(?,?,?,?,?,?)}";
			cst = con.prepareCall(sql);
			cst.setInt(1, u.getCodigo());
			cst.setString(2, u.getNombre());
			cst.setString(3, u.getApellido());
			cst.setString(4, u.getUsuario());
			cst.setString(5, u.getClave());
			cst.setString(6, u.getFnacim());
			rs = cst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error al actualizar usuario : " + e.getMessage());
		} finally {
			MySQLConexion8.closeConexion(con);
		}
		return rs;
	}

	@Override
	public int eliminar(UsuarioDTO u) {
		int rs = 0;
		Connection con = null;
		CallableStatement cst = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "{call tb_usuarios_sp_eliminar(?)}";
			cst = con.prepareCall(sql);
			cst.setInt(1, u.getCodigo());
			rs = cst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error al eliminar usuario : " + e.getMessage());
		} finally {
			MySQLConexion8.closeConexion(con);
		}
		return rs;
	}

	@Override
	public int logOut(UsuarioDTO u) {
		// TODO Auto-generated method stub
		return 0;
	}

}
