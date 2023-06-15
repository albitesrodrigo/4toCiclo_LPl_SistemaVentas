package interfaces;

import java.util.List;

import beans.Producto;

public interface ProductoDAO {

	// Métodos del CRUD
	public Producto ConsultaPorCodigo(int codigoProducto);
	public int Agregar(Producto producto);
	public List<Producto> Listar();
}
