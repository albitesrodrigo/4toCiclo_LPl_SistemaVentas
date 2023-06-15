package dao;

import beans.Venta;
import utils.MySqlDBConexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MySQLVentaDAO {
	public String ObtenerNumeroDeFactura() {
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		String numerodefactura = "";
		String consulta = "SELECT MAX(numerofactura) FROM ventas";
		try {
			cn = MySqlDBConexion.getConexion();
			pstm = cn.prepareStatement(consulta);
			rs = pstm.executeQuery();
			while (rs.next()) {
				numerodefactura = rs.getString(1);
				System.err.println("numfac" + numerodefactura);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return numerodefactura;

	}

	public void RegistrarVenta(Venta venta) {
		Connection cn = null;
		PreparedStatement pstm = null;

		try {
			cn = MySqlDBConexion.getConexion();
			String sentencia = "INSERT INTO ventas (idclienteventa,idempleadoventa,numerofactura,fechaventa,totalventa,estado) VALUES(?,?,?,?,?,?)";
			pstm = cn.prepareStatement(sentencia);
			pstm.setInt(1, venta.getIdCliente());
			pstm.setInt(2, venta.getIdEmpleado());
			pstm.setString(3, venta.getNumeroComprobante());
			pstm.setString(4, venta.getFecha());
			pstm.setDouble(5, venta.getMonto());
			pstm.setString(6, venta.getEstado());
			pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void GuardarDetalleVenta(Venta venta) {
		Connection cn = null;
		PreparedStatement pstm = null;

		try {
			cn = MySqlDBConexion.getConexion();
			String sentencia = "INSERT INTO detalleventa (idventa,idproducto,cantidadproducto,precioventa) VALUES(?,?,?,?)";
			pstm = cn.prepareStatement(sentencia);
			pstm.setInt(1, venta.getIdVenta());
			pstm.setInt(2, venta.getIdProducto());
			pstm.setInt(3, venta.getCantidad());
			pstm.setDouble(4, venta.getPrecio());
			pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int ObtenerMaximoIdVentas() {
		int idVenta = 0;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			cn = MySqlDBConexion.getConexion();
			String consulta = "SELECT MAX(idVenta) FROM ventas";
			pstm = cn.prepareStatement(consulta);
			rs = pstm.executeQuery();
			while (rs.next()) {
				idVenta = rs.getInt(1);
				System.out.println("max" + idVenta);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return idVenta;
	}
}
