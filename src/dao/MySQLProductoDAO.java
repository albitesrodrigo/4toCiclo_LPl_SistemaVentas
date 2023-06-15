package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import beans.Producto;
import interfaces.ProductoDAO;
import utils.MySqlDBConexion;


public class MySQLProductoDAO implements ProductoDAO {

	@Override
	public Producto ConsultaPorCodigo(int codigoProducto) {
		Producto producto = null;
		List<Producto> data = new ArrayList<Producto>();
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			cn = MySqlDBConexion.getConexion();
			String consulta = "SELECT * FROM productos WHERE id = " + codigoProducto;
			pstm = cn.prepareStatement(consulta);
			rs = pstm.executeQuery();
			while (rs.next()) {
				producto = new Producto();
				producto.setCodigo(rs.getInt("id"));
				producto.setNombreProducto(rs.getString("nombreproducto"));
				producto.setDescripcion(rs.getString("descripcionproducto"));
				producto.setUnidad(rs.getString("unidad"));
				producto.setPrecio(rs.getString("precio"));
				data.add(producto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return producto;
	}

	@Override
	public int Agregar(Producto producto) {
		int estado = 0;
		Connection cn = null;
		PreparedStatement pstm = null;

		try {
			cn = MySqlDBConexion.getConexion();
			String sentencia = "INSERT INTO productos (nombreproducto, descripcionproducto, unidad, precio) VALUES (?,?,?,?)";
			pstm = cn.prepareStatement(sentencia);
			pstm.setString(1, producto.getNombreProducto());
			pstm.setString(2, producto.getDescripcion());
			pstm.setString(3, producto.getUnidad());
			pstm.setString(4, producto.getPrecio());
			pstm.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return estado;
	}

	@Override
	public List<Producto> Listar() {
		Producto producto = null;
		List<Producto> lista = new ArrayList();
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			cn = MySqlDBConexion.getConexion();
			String consulta = "SELECT * FROM productos";
			pstm = cn.prepareStatement(consulta);
			rs = pstm.executeQuery();
			while (rs.next()) {
				producto = new Producto();
				producto.setCodigo(rs.getInt("id"));
				producto.setNombreProducto(rs.getString("nombreproducto"));
				producto.setDescripcion(rs.getString("descripcionproducto"));
				producto.setUnidad(rs.getString("unidad"));
				producto.setPrecio(rs.getString("precio"));
				lista.add(producto);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
}
