package dao;

import interfaces.ProductoDAO;
import interfaces.UsuarioDAO;
import interfaces.VentaDAO;

public class MySQLDAOFactory extends DAOFactory{

	@Override
	public ProductoDAO getProducto() {
		// TODO Auto-generated method stub
		return new MySQLProductoDAO();
	}

	@Override
	public UsuarioDAO getUsuario() {
		// TODO Auto-generated method stub
		return new MySQLUsuarioDAO();
	}

	@Override
	public MySQLVentaDAO getVenta() {
		// TODO Auto-generated method stub
		return new MySQLVentaDAO();
	}

}
