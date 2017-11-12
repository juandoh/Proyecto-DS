package accesoDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import logica.Sede;

/**
 * 
 * @author juan diego
 *
 */

public class DaoSede {
	
	FachadaBD fachada;

	public DaoSede() {
		// TODO Auto-generated constructor stub
		fachada = new FachadaBD();
	}
	
	//Metodo encargado de guardar los datos de una Sede en la base de datos
	
	//Metodo que se encarga de Consultar los datos de un Usario en la base de datos
	public Sede consultarSede( String nomSede, String ciudad){
		Sede s = new Sede();
		String sql_select;
		
		sql_select="SELECT direccion, numero_sede FROM  sede WHERE nombre='" + nomSede + "'" + " and ciudad='" + ciudad + "'";
		
		try{
			Connection conn= fachada.getConnetion();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
            	s.setNombreSede(tabla.getString(1));
            	s.setDireccion(tabla.getString(2));
            	s.setNumeroSede(tabla.getString(3));
            	s.setCiudad(tabla.getString(4));
            	
            	System.out.println("ok");
            }
            return s;
		}catch(SQLException e){ 
			System.out.println(e); 
			JOptionPane.showMessageDialog(null, "Ocurrio un problema en la BASE DE DATOS del Sistema");}
		catch(Exception e){ System.out.println(e); }
		return null;
		
	}//Fin del metodo consultar
	
	//Metodo encargado de Modificar los datos de una Sede en la base de datos
	public int modificarSede(String nomSede, String direccion, String numeroSede, String ciudad){
		String sql_modificar;
		int numeroFilas = 0;
		
		sql_modificar = "UPDATE sede set direccion=" + direccion +
				", numero_sede=" + numeroSede + " WHERE nombre='"+ nomSede +"' and " + "ciudad='" + ciudad + "'";
		
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
	}//Fin del metodo Modificar
	
	//Metodo para cerrar la conexion a la base de datos
	public void cerrarConexionBD(){
        fachada.closeConection(fachada.getConnetion());
    }

}
