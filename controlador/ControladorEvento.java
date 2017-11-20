package controlador;

import javax.swing.JOptionPane;

import accesoDatos.DaoEvento;
import accesoDatos.DaoInscripcion;
import logica.Evento;
import logica.Inscripcion;
import logica.preInscripcion;

public class ControladorEvento {
	
	DaoEvento daoEvento;

	public ControladorEvento() {
		// TODO Auto-generated constructor stub
		daoEvento = new DaoEvento();
	}
	//-------------------------------------------------------------------------------------------
	
	//Metodo para consultar la preInscripcion
	public Evento consultarEvento(String nombre_evt, String ciudad_evt){
		Evento evt = new Evento();
		System.out.println("Se van a obtener los datos de la preinscripcion.");
		
		//Se llama al dao para consultar
		evt = daoEvento.consultarEvento(nombre_evt, ciudad_evt);
		return evt;
	}
	//-------------------------------------------------------------------------------------------
	
	public int cancelarEvento(String nombre_evt, String fecha_evt){
		//Se llama al dao para cancelar
		System.out.println("Se va a cancelar un evento.");
						
		int result = daoEvento.cancelarEvento(nombre_evt, fecha_evt);
		
		if(result == 1){JOptionPane.showMessageDialog(null, "Se cancelo el evento correctamente.","Cancelacion Realizada.", JOptionPane.INFORMATION_MESSAGE);}
		else if(result == -1){JOptionPane.showMessageDialog(null, "No se pudo realizar la cancelacion.", "Fallo Cancelacion.", JOptionPane.WARNING_MESSAGE);}
		
		return result;
	}
	//-------------------------------------------------------------------------------------------
	
	public String[] consultarCiudades(){
		String[] ciudades;
		System.out.println("Se van a obtener las ciudades donde hay eventos.");
		
		//Se llama al dao para consultar
		ciudades = daoEvento.consultarCiudades();
		return ciudades;
	}
	//-------------------------------------------------------------------------------------------
	
	public String[] consultarEventosEnCiudad(String ciudad){
		String[] eventos;
		System.out.println("Se van a obtener los eventos en la ciudad indicada.");
		
		//Se llama al dao para consultar
		eventos = daoEvento.consultarEventosEnCiudad(ciudad);
		return eventos;
	}
	//-------------------------------------------------------------------------------------------

	//Metodo para cerrar la conexion
	public void cerrarConexionBD(){
        daoEvento.cerrarConexionBD();
	}
	//-------------------------------------------------------------------------------------------

}
