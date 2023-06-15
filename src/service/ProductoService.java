package service;

import java.util.List;

import beans.Producto;
import dao.DAOFactory;
import interfaces.ProductoDAO;
import utils.Constantes;

public class ProductoService {

	DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGEN_DE_DATOS_MYSQL);
	ProductoDAO objPro = fabrica.getProducto();
	
	public Producto ConsultarPorCodigo(int codigoProducto) {
		return objPro.ConsultaPorCodigo(codigoProducto);
	}
	public int Agrega(Producto producto) {
		return objPro.Agregar(producto);
	}
	public List<Producto> Lista() {
		return objPro.Listar();
	}
}