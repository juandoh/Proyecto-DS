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
	
	//Metodo encargado de Modificar los datos del Usuario en la base de datos
	public int modificarUsuario(String nombre, String apellido, String cedula, String contrasenna, String telefono,
			String tipo, String estado, String email){
		String sql_modificar;
		int numeroFilas = 0;
		
		sql_modificar = "UPDATE usuario set nombre=" + nombre + ", apellido=" + apellido +
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
	
	//Metodo que se encarga de Consultar los datos de un Usario en la base de datos
	public Usuario consultarUsuario( String cedula ){
		Usuario u = new Usuario();
		String sql_select;
		
		sql_select="SELECT nombre, apellido, nick, contrasenna, telefono, tipo, estado, email FROM  usuario WHERE cedula='" + cedula + "'";
		
		try{
			Connection conn= fachada.getConnetion();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
            	u.setNombre(tabla.getString(1));
            	u.setApellido(tabla.getString(2));
            	u.setNick(tabla.getString(3));
            	u.setContrasenna(tabla.getString(4));
            	u.setTelefono(tabla.getString(5));
            	u.setTipo(tabla.getString(6));
            	u.setEstado(tabla.getString(7));
            	u.setEmail(tabla.getString(8));
            	
            	System.out.println("ok");
            }
            return u;
		} catch(SQLException e){ 
			System.out.println(e); 
			JOptionPane.showMessageDialog(null, "Ocurrio un problema en la BASE DE DATOS del Sistema");}
		catch(Exception e){ System.out.println(e); }
		return null;
	}
	
	//Metodo que se encarga de Listar los Usuarios que estan registrados en el sistema
	//public Usuario listarUsuario(){
		
	//}
	
	//Metodo para cerrar la conexion a la base de datos
	public void cerrarConexionBD(){
        fachada.closeConection(fachada.getConnetion());
    }

}
