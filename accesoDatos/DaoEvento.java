package accesoDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import logica.Evento;
import logica.preInscripcion;

public class DaoEvento {
	
	FachadaBD fachada;

	public DaoEvento() {
		// TODO Auto-generated constructor stub
		fachada = new FachadaBD();
	}
	
	public Evento consultarEvento(String nombre_evt, String ciudad_evt){
		Evento evt = new Evento();
		String sql_select;
		
		sql_select="SELECT * FROM  evento WHERE nombre = '" + nombre_evt + "' AND ciudad ='" + ciudad_evt + "';";
		
		try{
			Connection conn= fachada.getConnetion();
            System.out.println("consultando en la bd sobre evento.");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
            	evt.setNombre(tabla.getString(1));
            	evt.setFecha(tabla.getString(2));
            	evt.setCiudad(tabla.getString(3));
            	evt.setCosto(tabla.getString(4));
            	evt.setEstado(tabla.getString(5));
            }
            //return evt;
		} catch(SQLException e){ 
			System.out.println(e); 
			JOptionPane.showMessageDialog(null, "Ocurrio un problema en la BASE DE DATOS del Sistema");}
		catch(Exception e){ System.out.println(e); }
		return evt;
	}
	
	public int cancelarEvento(String nombre_evt, String fecha_evt){
			String sql_modificar;
			int numeroFilas = 0;
	
			sql_modificar = "UPDATE evento set estado = " + "'cancelado'" +"" + " WHERE nombre= '"+ nombre_evt +
					"' AND fecha = '" + fecha_evt + "';";
	
			try {
				Connection conn = fachada.getConnetion();
				Statement sentencia = conn.createStatement();
		
				numeroFilas = sentencia.executeUpdate(sql_modificar);
				System.out.println("up " + numeroFilas);
				conn.close();
				return numeroFilas;
			} catch ( SQLException e){
				System.out.println(e); 
				JOptionPane.showMessageDialog(null, "Ocurrio un problema en la BASE DE DATOS del Sistema", "Fallo Cancelacion Evento.", JOptionPane.WARNING_MESSAGE);
			}
			catch ( Exception e) {
				System.out.println(e); 
			}
	
			return -1;
	}
	//-------------------------------------------------------------------------------------------
	
	public String[] consultarCiudades(){//Consulta las ciudades donde hay eventos
		int iterador=0;
		String[] ciudades=null;
		String sql_select;
		
		
		sql_select="SELECT DISTINCT ciudad FROM  evento;";
		
        try{
        	
	        ResultSet tabla = auxiliarConsultas(sql_select);
	        
            while(tabla.next()){
            	iterador++;
            }
            
            ResultSet tabla2 = auxiliarConsultas(sql_select);
            
            //int indice_guardador=iterador-1;
            ciudades= new String[iterador];
            
            while(tabla2.next()){
            	ciudades[iterador-1] = tabla2.getString(1);
            	iterador--;
            }
        } catch(SQLException e){ 
			System.out.println(e); 
			JOptionPane.showMessageDialog(null, "Problema base de datos: Consulta ciudades cancelar-evento.");}
		catch(Exception e){ System.out.println(e); }
        
        return ciudades;
	}
	//----------------------------------------------------------------------------------------------------------
	public ResultSet auxiliarConsultas(String sql_select){//Realiza la cosulta en sql que entra como parametro
		ResultSet tabla = null;//
		try{
			Connection conn= fachada.getConnetion();
	        Statement sentencia = conn.createStatement();
	        tabla = sentencia.executeQuery(sql_select);
	        //return tabla;
		} catch(SQLException e){ 
			System.out.println(e); 
			JOptionPane.showMessageDialog(null, "Problema en la cancelacion de evento.");}
		catch(Exception e){ System.out.println(e); }
		return tabla;
	}
	//----------------------------------------------------------------------------------------------------------
	
	public String[] consultarEventosEnCiudad(String ciudad){
		int iterador=0;
		String[] eventos=null;
		String sql_select;
		
		
		sql_select="SELECT nombre FROM  evento WHERE ciudad = '" + ciudad + "';";
		
        try{
        	
	        ResultSet tabla = auxiliarConsultas(sql_select);
	        
            while(tabla.next()){
            	iterador++;
            }
            
            ResultSet tabla2 = auxiliarConsultas(sql_select);
            
            //int indice_guardador=iterador-1;
            eventos= new String[iterador];
            
            while(tabla2.next()){
            	eventos[iterador-1] = tabla2.getString(1);
            	iterador--;
            }
        } catch(SQLException e){ 
			System.out.println(e); 
			JOptionPane.showMessageDialog(null, "Problema base de datos: Consulta evento cancelar-evento.");}
		catch(Exception e){ System.out.println(e); }
        
        return eventos;
	}
	
	public void cerrarConexionBD(){
        fachada.closeConection(fachada.getConnetion());
    }

}
