package controlador;

import logica.Escarapela;
import accesoDatos.DaoEscarapela;

/**
 * 
 * @author juan diego ordonnez
 *
 */

public class ControladorEscarapela {
	
	DaoEscarapela daoEscarapela;

	//Constructor
	public ControladorEscarapela() {
		// TODO Auto-generated constructor stub
		daoEscarapela = new DaoEscarapela();
	}
	
	//Metodo que se encarga de Insentar los datos de la Escarapela en la base de datos
	public int insertarUsuario(String nomParticipante, String cedula, String fecha, String nomEvento){
		
		Escarapela e = new Escarapela();
		
		e.setParticipante(nomParticipante);
		e.setCedula(cedula);
		e.setFecha(fecha);
		e.setNombreEvento(nomEvento);
		
		//Se llama al dao para guardar
		System.out.println("Se va a insertar una Escarapela");
		
		int result = daoEscarapela.guardarEscarapela(e);
		
		System.out.println("Se inserto un nuevo Usuario");
		
		return result;
		
	}//Fin del metodo insertar
	

}
