package controlador;

import logica.preInscripcion;
import accesoDatos.DaoPreInscripcion;

/**
 * 
 * @author Daniel Calero
 *
 */

public class ControladorPreInscripcion {
	
	DaoPreInscripcion daoPreInscripcion;

	//Constructor
	public ControladorPreInscripcion() {
		// TODO Auto-generated constructor stub
		daoPreInscripcion = new DaoPreInscripcion();
	}
	
	//Metodo que se encarga de Insentar los datos de la preInscripcion en la base de datos
	public int insertarPreInscripcion( String nomEvento, String nomParticipante, String cedula, String fecha){
		preInscripcion p = new preInscripcion();
		
		p.setNombreEvento(nomEvento);
		p.setNombreParticipante(nomParticipante);
		p.setCedula(cedula);
		p.setFecha(fecha);
		
		//Se llama al dao para guardar
        System.out.println("Se va a insertar una preInscripcion");
        
        int result = daoPreInscripcion.guardarPreInscripcion(p);

        System.out.println("Se inserto una nueva preInscripcion");
        
        return result;
	}
	
	//Metodo para cerrar la conexion a la base de datos
	public void cerrarConexionBD(){
        daoPreInscripcion.cerrarConexionBD();
    }

}//Fin de la clase ControladorPreInscripción
