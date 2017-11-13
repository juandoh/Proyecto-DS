package accesoDatos;

/**
 * 
 * @author Davis Mera
 *
 */

import java.sql.*;
import javax.swing.JOptionPane;

import logica.Inscripcion;
import logica.Usuario;
import logica.preInscripcion;

public class DaoInscripcion {
	
	FachadaBD fachada;

	public DaoInscripcion() {
		// TODO Auto-generated constructor stub
		fachada = new FachadaBD();
	}
	//------------------------------------------------------------------------
	
	public int guardarInscripcion( Inscripcion ins ){
		String sql_guardar;
		int numeroFilas = 0;
		
		sql_guardar = "INSERT INTO inscripcion VALUES ('"+
				ins.getNombreEvento() + "', '" + ins.getNombreParticipante() +  "', '" +
				ins.getCedula() + "', '" + ins.getfecha() + "', '" + ins.getTelefono() + "', '" + ins.getEmail() + "');";
		
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
	}
	//-----------------------------------------------------------------------------
	
	public preInscripcion consultarPreinscripcion(String cedula){
		preInscripcion pre = new preInscripcion();
		String sql_select;
		
		sql_select="SELECT nombre_evento, nombre_participante, cedula, fecha FROM  pre_inscripcion WHERE cedula ='" + cedula + "'";
		
		try{
			Connection conn= fachada.getConnetion();
            System.out.println("consultando en la bd sobre preinscripcion.");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
            	pre.setNombreEvento(tabla.getString(1));
            	pre.setNombreParticipante(tabla.getString(2));
            	pre.setCedula(tabla.getString(3));
            	pre.setFecha(tabla.getString(4));
            	
            	System.out.println("ok, datos de preinscripcion obtenidos.");
            }
            //return pre;
		} catch(SQLException e){ 
			System.out.println(e); 
			JOptionPane.showMessageDialog(null, "Ocurrio un problema en la BASE DE DATOS del Sistema");}
		catch(Exception e){ System.out.println(e); }
		return pre;
	}
	//-------------------------------------------------------------------------------------------
	
	public String[] consultarEventosPreinscritos(String cedula){
		int iterador=0;
		String[] eventos=null;
		String sql_select;
		
		
		sql_select="SELECT nombre_evento FROM  pre_inscripcion WHERE cedula ='" + cedula + "';";
		
        try{
        	
	        ResultSet tabla = auxiliarConsulaEventos(sql_select);
	        
            while(tabla.next()){
            	iterador++;
            	System.out.println("iterador es: "+iterador);
            }
            
            ResultSet tabla2 = auxiliarConsulaEventos(sql_select);
            
            //int indice_guardador=iterador-1;
            eventos= new String[iterador];
            
            while(tabla2.next()){
            	eventos[iterador-1] = tabla2.getString(1);
            	iterador--;
            	System.out.println("evento numero : "+iterador+" : "+tabla2.getString(1));
            }
        } catch(SQLException e){ 
			System.out.println(e); 
			JOptionPane.showMessageDialog(null, "Problema base de datos: Consulta eventos preinscritos.");}
		catch(Exception e){ System.out.println(e); }
        
        return eventos;
	}
	//----------------------------------------------------------------------------------------------------------
	public ResultSet auxiliarConsulaEventos(String sql_select){
		ResultSet tabla = null;//
		try{
			Connection conn= fachada.getConnetion();
	        System.out.println("consultando en la bd sobre preinscripcion.");
	        Statement sentencia = conn.createStatement();
	        tabla = sentencia.executeQuery(sql_select);
	        //return tabla;
		} catch(SQLException e){ 
			System.out.println(e); 
			JOptionPane.showMessageDialog(null, "Problema en la consulta de eventos.");}
		catch(Exception e){ System.out.println(e); }
		return tabla;
	}
	//----------------------------------------------------------------------------------------------------------
	
	public String[] consultarNoinscrito(String cedula, String evento){
		String sql_select;
		String nombre_evento="";
		String nombre_participante="";
		String[] resultado = {"", ""};
		
		sql_select="SELECT nombre_evento, nombre_participante  FROM  inscripcion WHERE cedula ='" + cedula + "' AND nombre_evento ='"+evento+"';";
		
		try{
			Connection conn= fachada.getConnetion();
            System.out.println("consultando en la bd sobre preinscripcion.");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
            	nombre_evento = tabla.getString(1);
            	nombre_participante = tabla.getString(2);
            	resultado[0] = nombre_evento;
            	resultado[1] = nombre_participante;
            	System.out.println("ok, datos de preinscripcion obtenidos.");
            }
            return resultado;
		} catch(SQLException e){ 
			System.out.println(e); 
			JOptionPane.showMessageDialog(null, "Ocurrio un problema en la BASE DE DATOS del Sistema");}
		catch(Exception e){ System.out.println(e); }
		return resultado;
	}
	
	public void cerrarConexionBD(){
        fachada.closeConection(fachada.getConnetion());
    }

}
