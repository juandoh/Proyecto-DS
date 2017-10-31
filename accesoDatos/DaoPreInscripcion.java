package accesoDatos;
/**
 * 
 * @author Daniel Calero
 *
 */

import java.sql.*;

import logica.preInscripcion;

public class DaoPreInscripcion {
	
	FachadaBD fachada;

	public DaoPreInscripcion() {
		// TODO Auto-generated constructor stub
		fachada = new FachadaBD();
	}
	
	//Metodo para guardar la preInscripcion en la base de datos
	public int guardarPreInscripcion( preInscripcion p ){
		String sql_guardar;
        int numFilas=0;
        
        sql_guardar="INSERT INTO pre_inscripcion VALUES ('" +
                p.getNombreEvento() + "', '" + p.getNombreParticipante() + "', '" + 
        		p.getCedula() + "', '" + p.getfecha() + ")";
        
        try{
            Connection conn= fachada.getConnetion();
            Statement sentencia = conn.createStatement();

            numFilas = sentencia.executeUpdate(sql_guardar);            
            System.out.println("up " + numFilas);
            return numFilas;
            
        }
        catch(SQLException e){
            System.out.println(e); 
            }
        catch(Exception e){ 
            System.out.println(e);
        }
        return -1;
	}//Fin del metodo guardar
	
	//Metodo para cerrar la conexion a la base de datos
	public void cerrarConexionBD(){
        fachada.closeConection(fachada.getConnetion());
    }

}
