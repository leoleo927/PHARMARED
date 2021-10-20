package mantenimiento;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import beans.ProductoDTO;
import interfaces.ProductoDAO;
import utils.MySQLConexion8;

public class MySQLProductoDAO implements ProductoDAO {

	@Override
	public ArrayList<ProductoDTO> listar() {
		ArrayList<ProductoDTO> lista = null;
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "{call tb_productos_sp_listar()}";
			cst = con.prepareCall(sql);
			rs = cst.executeQuery();
			lista = new ArrayList<ProductoDTO>();
			while (rs.next()) {
				ProductoDTO p = new ProductoDTO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDouble(4),
						rs.getInt(5), rs.getInt(6));
				lista.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MySQLConexion8.closeConexion(con);
		}
		return lista;
	}

	@Override
	public ArrayList<ProductoDTO> listarByCategoria(int idCategoria) {
		ArrayList<ProductoDTO> lista = null;
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "{call tb_productos_sp_listar_x_categoria(?)}";
			cst = con.prepareCall(sql);
			cst.setInt(1, idCategoria);
			rs = cst.executeQuery();
			lista = new ArrayList<ProductoDTO>();
			while (rs.next()) {
				ProductoDTO p = new ProductoDTO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDouble(4),
						rs.getInt(5), rs.getInt(6));
				lista.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MySQLConexion8.closeConexion(con);
		}
		return lista;
	}

	@Override
	public ProductoDTO listarById(String idProd) {
		ProductoDTO prod = null;
		Connection con = null;
		CallableStatement cst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "{call tb_productos_sp_listar_x_id(?)}";
			cst = con.prepareCall(sql);
			cst.setString(1, idProd);
			rs = cst.executeQuery();
			prod = new ProductoDTO();
			if (rs.next()) {
				prod = new ProductoDTO(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getInt(5),
						rs.getInt(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MySQLConexion8.closeConexion(con);
		}
		return prod;
	}

	@Override
	public int registrar(ProductoDTO p) {
		int rs = 0;
		Connection con = null;
		CallableStatement cst = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "{call tb_productos_sp_registrar(?,?,?,?,?)}";
			cst = con.prepareCall(sql);
			cst.setString(1, p.getDescripcion());
			cst.setInt(2, p.getStock());
			cst.setDouble(3, p.getPrecio());
			cst.setInt(4, p.getIdCategoria());
			cst.setInt(5, p.getEstado());
			rs = cst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error al actualizar usuario : " + e.getMessage());
		} finally {
			MySQLConexion8.closeConexion(con);
		}
		return rs;
	}

	@Override
	public int actualizar(ProductoDTO p) {
		int rs = 0;
		Connection con = null;
		CallableStatement cst = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "{call tb_productos_sp_actualizar(?,?,?,?,?,?)}";
			cst = con.prepareCall(sql);
			cst.setString(1, p.getIdprod());
			cst.setString(2, p.getDescripcion());
			cst.setInt(3, p.getStock());
			cst.setDouble(4, p.getPrecio());
			cst.setInt(5, p.getIdCategoria());
			cst.setInt(6, p.getEstado());
			rs = cst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error al actualizar usuario : " + e.getMessage());
		} finally {
			MySQLConexion8.closeConexion(con);
		}
		return rs;
	}

	@Override
	public int eliminar(ProductoDTO p) {
		int rs = 0;
		Connection con = null;
		CallableStatement cst = null;
		try {
			con = MySQLConexion8.getConexion();
			String sql = "{call tb_productos_sp_eliminar(?)}";
			cst = con.prepareCall(sql);
			cst.setString(1, p.getIdprod());
			rs = cst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error al eliminar usuario : " + e.getMessage());
		} finally {
			MySQLConexion8.closeConexion(con);
		}
		return rs;
	}
}
