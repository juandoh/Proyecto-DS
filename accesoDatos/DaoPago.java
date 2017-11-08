package accesoDatos;
/**
 * 
 * @author juan diego ordonez
 *
 */

import java.sql.*;

import logica.Pago;

public class DaoPago {
	
	FachadaBD fachada;

	public DaoPago() {
		// TODO Auto-generated constructor stub
		fachada = new FachadaBD();
	}
	
	//Metodo para guardar el Pago en la base de datos
	public int guardarPago( Pago p ){
		String sql_guardar;
        int numFilas=0;
        
        sql_guardar="INSERT INTO pago VALUES ('" +
                p.getNombreEvento() + "', '" + p.getNombreParticipante() + "', '" + 
        		p.getCedula() + "', '" + p.getFormaPago() + "', '" + p.getValor() + "', '" + p.getFecha() + "')";
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
