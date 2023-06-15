package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import beans.Usuario;
import interfaces.UsuarioDAO;
import utils.MySqlDBConexion;

public class MySQLUsuarioDAO implements UsuarioDAO {
    
    @Override
    public Usuario BuscarCliente(int documento){
    	Usuario usuario = null;
        Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "SELECT * FROM usuarios WHERE documento = ?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, documento);
			rs = pstm.executeQuery();
			if (rs.next()) {
				usuario.setId(rs.getInt("id"));
				usuario.setDocumento(rs.getInt("documento"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setCorreo(rs.getString("correo"));
				usuario.setRol(rs.getString("rol"));
                System.err.println(""+usuario.getNombre());
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return usuario;
    }

    @Override
    public Usuario Validar(int documento, String password) {
    	Usuario usuario = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			cn = MySqlDBConexion.getConexion();
			String consulta = "SELECT * FROM usuarios WHERE documento = ? AND password = ?";
			pstm = cn.prepareStatement(consulta);
			pstm.setInt(1, documento);
			pstm.setString(2, password);
            rs = pstm.executeQuery();
            rs.next();
			if (rs.next()) {
				usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
                usuario.setDocumento(rs.getInt("documento"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setPassword(rs.getString("password"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setEstado(rs.getString("estado"));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return usuario;
    }

    @Override
    public List<Usuario> Listar() {
    	List<Usuario> lista = new ArrayList();
    	Usuario obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
    	
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "SELECT * FROM usuarios";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setDocumento(rs.getInt("documento"));
				usuario.setNombre(rs.getString("nombre"));
				usuario.setCorreo(rs.getString("correo"));
				usuario.setPassword(rs.getString("password"));
				usuario.setEstado(rs.getString("estado"));
				usuario.setRol(rs.getString("rol"));
                lista.add(usuario);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return lista;
    }

    @Override
    public int Agregar(Usuario usuario) {
    	int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "INSERT INTO usuarios (documento,nombre,correo,password,rol,estado) VALUES (?,?,?,?,?,?)";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, usuario.getDocumento());
			pstm.setString(2, usuario.getNombre());
			pstm.setString(3, usuario.getCorreo());
			pstm.setString(4, usuario.getPassword());
			pstm.setString(5, usuario.getRol());
			pstm.setString(6, usuario.getEstado());
			estado = pstm.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return estado;
	}

    @Override
    public Usuario ListarPorId(int id) {
    	Usuario usuario = new Usuario();
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
    	
		try {
			cn = MySqlDBConexion.getConexion();
			String consulta = "SELECT * FROM usuarios WHERE id=" + id;
			pstm = cn.prepareStatement(consulta);
			rs = pstm.executeQuery();
			while (rs.next()) {
				usuario.setDocumento(rs.getInt(2));
                usuario.setNombre(rs.getString(3));
                usuario.setCorreo(rs.getString(4));
                usuario.setPassword(rs.getString(5));
                usuario.setRol(rs.getString(6));
                usuario.setEstado(rs.getString(7));
			}
        } 
		catch (Exception e) {
			e.printStackTrace();
        }

        return usuario;

    }

    @Override
    public int Actualizar(Usuario usuario) {
    	int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
        
        try {
        	cn = MySqlDBConexion.getConexion();
        	String sentencia = "UPDATE usuarios set documento=?,nombre=?,correo=?,password=?,Rol=?,estado=? WHERE id=?";
        	pstm = cn.prepareStatement(sentencia);
        	pstm.setInt(1, usuario.getDocumento());
        	pstm.setString(2, usuario.getNombre());
        	pstm.setString(3, usuario.getCorreo());
        	pstm.setString(4, usuario.getPassword());
        	pstm.setString(5, usuario.getRol());
        	pstm.setString(6, usuario.getEstado());
        	pstm.setInt(7, usuario.getId());
        	pstm.executeUpdate();

        } catch (Exception e) {
        	e.printStackTrace();
        }
        return estado;
    }

    @Override
    public int eliminarUsuario(int id) {
    	int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		
		try {
			cn = MySqlDBConexion.getConexion();
			String sql = "delete from tb_producto where cod_pro=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, id);
			estado = pstm.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return estado;
    }
}