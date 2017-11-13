package accesoDatos;
/**
 * 
 * @author juan diego ordonnez
 *
 */

import java.sql.*;

import javax.swing.JOptionPane;

import logica.Escarapela;

public class DaoEscarapela {
	
	FachadaBD fachada;

	public DaoEscarapela() {
		// TODO Auto-generated constructor stub
		fachada = new FachadaBD();
	}
	
	public int guardarEscarapela( Escarapela es){
		String sql_guardar;
		int numeroFilas = 0;
		
		sql_guardar = "INSERT INTO escarapela VALUES ('"+
				es.getParticipante() + "', '" + es.getCedula() +  "', '" +
				es.getFecha() + "', '" + es.getNombreEvento() + "');";
		
		try{
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
	}//Fin del metodo guardar
	
	//Metodo para cerrar la conexion a la base de datos
	public void cerrarConexionBD(){
        fachada.closeConection(fachada.getConnetion());
    }

}
