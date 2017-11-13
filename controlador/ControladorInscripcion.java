package controlador;

/**
 * 
 * @author Davis Mera
 * @author juan diego
 *
 */

import javax.swing.JOptionPane;

import accesoDatos.DaoInscripcion;
import accesoDatos.DaoPreInscripcion;
import logica.Inscripcion;
import logica.Usuario;
import logica.preInscripcion;

public class ControladorInscripcion {
	
	DaoInscripcion daoInscripcion;

	public ControladorInscripcion() {
		// TODO Auto-generated constructor stub
		daoInscripcion = new DaoInscripcion();
	}
	
	//Metodo para consultar la preInscripcion
	public preInscripcion consultarPreinscripcion(String cedula){
		preInscripcion previa = new preInscripcion();
		System.out.println("Se van a obtener los datos de la preinscripcion.");
		
		//Se llama al dao para consultar
		previa = daoInscripcion.consultarPreinscripcion(cedula);
		return previa;
	}
	
	//Metodo para consultar los evento Preinscritos
	public String[] consultarEventosPreinscritos(String cedula){
		String[] eventos;
		System.out.println("Se van a obtener los datos de la preinscripcion.");
		
		//Se llama al dao para consultar
		eventos = daoInscripcion.consultarEventosPreinscritos(cedula);
		return eventos;
	}
	
	//Metodo para comprobar
	public boolean comprobarNoInscrito(String cedula, String evento){
		String[] resultado = daoInscripcion.consultarNoinscrito(cedula, evento);
		if(resultado[0].equals("") && resultado[1].equals("")){return false;}
		else{return true;}
	}
	
	//Metodo para insertar una Inscripcion en el sistema
	public int insertarInscripcion (String nombre_evento, String nombre_participante, String cedula, String fecha, String telefono, String email){
		Inscripcion ins = new Inscripcion(nombre_evento, nombre_participante, cedula, fecha, telefono, email);
		
		//Se llama al dao para guardar
		System.out.println("Se va a insertar un Usuario");
						
		int result = daoInscripcion.guardarInscripcion(ins);
		
		if(result == 1){JOptionPane.showMessageDialog(null, "Se realizo la inscripcion correctamente.","Inscripcion Realizada", JOptionPane.INFORMATION_MESSAGE);}
		else if(result == -1){JOptionPane.showMessageDialog(null, "No se pudo realizar la inscripcion.", "Fallo Inscripcion", JOptionPane.WARNING_MESSAGE);}
		
		return result;
	}
	
	//Metodo para cerrar la conexion
	public void cerrarConexionBD(){
        daoInscripcion.cerrarConexionBD();
	}

}
