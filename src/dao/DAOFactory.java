package dao;

import interfaces.UsuarioDAO;
import interfaces.VentaDAO;
import interfaces.ProductoDAO;

public abstract class DAOFactory {

	// Posibles orígenes de datos
	public static final int MYSQL = 1;
	public static final int SQLSERVER = 2;
	public static final int ORACLE = 3;
	public static final int DB2 = 4;
	public static final int INFORMIX = 5;
	
	// Vinculamos las interfaces que tengamos
	public abstract ProductoDAO getProducto();
	public abstract UsuarioDAO getUsuario();
	public abstract VentaDAO getVenta();
	
	public static DAOFactory getDAOFactory(int whichFactory) {
		switch(whichFactory) {
			case MYSQL:
				return new MySQLDAOFactory();
			case ORACLE:
				//return new OracleDAOFactory();
			case SQLSERVER:
				//return new SQLServerDAOFactory();
		}
		return null;
	}
	
}
