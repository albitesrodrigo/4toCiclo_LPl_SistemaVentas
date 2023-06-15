package interfaces;

import java.util.List;
import beans.Usuario;

public interface UsuarioDAO {
	
	public Usuario BuscarCliente(int documento);
	public Usuario Validar(int documento, String password);
	public List<Usuario> Listar();
	public int Agregar(Usuario usuario);
	public Usuario ListarPorId(int id);
	public int Actualizar(Usuario usuario);
	public int eliminarUsuario(int id);
}