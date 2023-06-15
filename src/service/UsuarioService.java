package service;

import java.util.List;

import beans.Usuario;
import dao.DAOFactory;
import interfaces.ProductoDAO;
import interfaces.UsuarioDAO;
import utils.Constantes;

public class UsuarioService {

	DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGEN_DE_DATOS_MYSQL);
	UsuarioDAO objUsu = fabrica.getUsuario();
	
	public Usuario BuscaCliente(int documento) {
		return objUsu.BuscarCliente(documento);
	}
	public Usuario Valida(int documento, String password) {
		return objUsu.Validar(documento, password);
	}
	public List<Usuario> Lista(){
		return objUsu.Listar();
	}
	public int Agrega(Usuario usuario) {
		return objUsu.Agregar(usuario);
	}
	public Usuario ListaPorId(int id) {
		return objUsu.ListarPorId(id);
	}
	public int Actualiza(Usuario usuario) {
		return objUsu.Actualizar(usuario);
	}
	public int Elimina(int id) {
		return objUsu.eliminarUsuario(id);
	}
}