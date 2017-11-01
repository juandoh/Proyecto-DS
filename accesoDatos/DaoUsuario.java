package accesoDatos;
/**
 * 
 * @author juan diego ordonnez
 *
 */

import java.sql.*;

import javax.swing.JOptionPane;
import logica.*;

public class DaoUsuario {
	
	FachadaBD fachada;

	public DaoUsuario() {
		// TODO Auto-generated constructor stub
		fachada = new FachadaBD();
	}
	
	//Metodo encargado de guardar los datos del Usuario en la base de datos
	public int guardarUsuario( Usuario u ){
		String sql_guardar;
		int numeroFilas = 0;
		
		sql_guardar = "INSERT INTO usuario VALUES ('"+
				u.getNombre() + "', '" + u.getApellido() +  "', '" +
				u.getCedula() + "', '" + u.getNick() + "', '" + u.getContrasenna() + "', '" + u.getTelefono() + "', '" +
				u.getTipo() + "', '" + u.getEstado() + "', '" + u.getEmail() + "');";
		
		try {
			Connection conn = fachada.getConnetion();
			Statement sentencia = conn.createStatement();
			
			numeroFilas = sentencia.executeUpdate(sql_guardar); 
			System.out.println("up " + numeroFilas);
			conn.close();
			return numeroFilas;
			
		} catch ( SQLException e){
			System.out.println(e);
			JOptionPane.showMessageDialog(null, "Ocurrio un problema en la BASE DE DATOS del Sistema");
		}
		catch ( Exception e) {
			System.out.println(e); 
		}
		return -1;
		
	}//Fin del método
	
	//Metodo encargado de Modificar los datos en la base de datos
	public int modificarUsuario(String nombre, String apellido, String cedula, String nick, String contrasenna, String telefono,
			String tipo, String estado, String email){
		String sql_modificar;
		int numeroFilas = 0;
		
		sql_modificar = "UPDATE usuario set nombre=" + nombre + ", apellido=" + apellido + ", nick=" + nick + 
				", contrasenna=" + contrasenna + ", telefono=" + telefono + ", tipo=" + tipo +
				", estado=" + estado + ", email=" + email + " WHERE cedula='"+ cedula +"'";
		
		try {
			Connection conn = fachada.getConnetion();
			Statement sentencia = conn.createStatement();
			
			numeroFilas = sentencia.executeUpdate(sql_modificar);
			System.out.println("up " + numeroFilas);
			conn.close();
			return numeroFilas;
		} catch ( SQLException e){
			System.out.println(e); 
			JOptionPane.showMessageDialog(null, "Ocurrio un problema en la BASE DE DATOS del Sistema");
		}
		catch ( Exception e) {
			System.out.println(e); 
		}
		
		return -1;
	}//Fin del metodo modificar
	
	//Metodo que se encarga de Listar los Usuarios que estan registrados en el sistema
	//public Usuario listarUsuario(){
		
	//}
	
	//Metodo para cerrar la conexion a la base de datos
	public void cerrarConexionBD(){
        fachada.closeConection(fachada.getConnetion());
    }

}
