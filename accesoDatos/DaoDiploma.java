package accesoDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import logica.Diploma;
import logica.Sede;

public class DaoDiploma {
	
	FachadaBD fachada;
	
	public DaoDiploma() {
		// TODO Auto-generated constructor stub
		fachada = new FachadaBD();
	}
	//--------------------------------------------------------------------------------------
	
	public String obtenerNombreParticipante(String cedula){
		String sql_select, nombre=null;
		
		sql_select="SELECT DISTINCT nombre_participante FROM  inscripcion WHERE cedula ='" + cedula + "';";
		
		try{
			Connection conn= fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
            	nombre = tabla.getString(1);
            }
            //return pre;
		} catch(SQLException e){ 
			System.out.println(e); 
			JOptionPane.showMessageDialog(null, "Ocurrio un problema en la BASE DE DATOS del Sistema");}
		catch(Exception e){ System.out.println(e); }
		return nombre;
	}
	//--------------------------------------------------------------------------------------
	
	public int generarDiploma(Diploma dip){
		String sql_guardar;
		int numeroFilas = 0;
		
		sql_guardar = "INSERT INTO diploma VALUES ('"+
				dip.getNombre_participante() + "', '" + dip.getCedula() +  "', '" +
				dip.getFecha() + "', '" + dip.getNombre_evento() + "', '" + dip.getHoras() + "', '" + dip.getTipo() + "');";
		
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
	};
	//--------------------------------------------------------------------------------------
	
	public String comprobarDiplomaInexistente(String cedula, String nombre_evento){
		String sql_select, nombre="";
		
		sql_select="SELECT nombre_participante FROM diploma WHERE cedula ='" + cedula + "' AND nombre_evento = '" + nombre_evento + "';";
		
		try{
			Connection conn= fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
            	nombre = tabla.getString(1);
            }
            //return pre;
		} catch(SQLException e){ 
			System.out.println(e); 
			JOptionPane.showMessageDialog(null, "Ocurrio un problema en la BASE DE DATOS del Sistema");}
		catch(Exception e){ System.out.println(e); }
		return nombre;
	}
	//--------------------------------------------------------------------------------------
	
	public String comprobarParticipanteParticipaEvento(String cedula, String nombre_evento){
		String sql_select, nombre="";
		
		sql_select="SELECT nombre_participante FROM inscripcion WHERE cedula ='" + cedula + "' AND nombre_evento = '" + nombre_evento + "';";
		
		try{
			Connection conn= fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
            	nombre = tabla.getString(1);
            }
            //return pre;
		} catch(SQLException e){ 
			System.out.println(e); 
			JOptionPane.showMessageDialog(null, "Ocurrio un problema en la BASE DE DATOS del Sistema");}
		catch(Exception e){ System.out.println(e); }
		return nombre;
	}
	//--------------------------------------------------------------------------------------
	
	//Metodo que se encarga de Consultar los datos de todos los diplomas en la base de datos
	public ArrayList<Diploma> consultarDiplomas(){
		
		String sql_select;
		
		ArrayList<Diploma> miLista = new ArrayList<Diploma>();
		Diploma s;
		
		sql_select="SELECT * FROM diploma ;";
		
		try{
			Connection conn= fachada.getConnetion();
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            
            while(tabla.next()){
            	s = new Diploma();
            	s.setNombre_participante(tabla.getString("nombre_participante"));
            	s.setCedula(tabla.getString("cedula"));
            	s.setFecha(tabla.getString("fecha"));
            	s.setNombre_evento(tabla.getString("nombre_evento"));
            	s.setHoras(tabla.getString("horas"));
            	s.setTipo(tabla.getString("tipo"));
            	miLista.add(s);
            }

		}catch(SQLException e){ 
			System.out.println(e); 
			JOptionPane.showMessageDialog(null, "Ocurrio un problema en la BASE DE DATOS del Sistema");
		}
		catch(Exception e){ 
			System.out.println(e);
		}
		return miLista;	
	}
	//--------------------------------------------------------------------------------------
	
	public void cerrarConexionBD(){
        fachada.closeConection(fachada.getConnetion());
    }
	//--------------------------------------------------------------------------------------
}
