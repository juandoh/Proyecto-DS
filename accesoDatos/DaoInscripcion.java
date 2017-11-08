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
            return pre;
		} catch(SQLException e){ 
			System.out.println(e); 
			JOptionPane.showMessageDialog(null, "Ocurrio un problema en la BASE DE DATOS del Sistema");}
		catch(Exception e){ System.out.println(e); }
		return null;
	}
	
	public String consultarNoinscrito(String cedula){
		String sql_select;
		String resultado="";
		
		sql_select="SELECT nombre_participante FROM  inscripcion WHERE cedula ='" + cedula + "'";
		
		try{
			Connection conn= fachada.getConnetion();
            System.out.println("consultando en la bd sobre preinscripcion.");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
            	resultado = tabla.getString(1);
            	
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
