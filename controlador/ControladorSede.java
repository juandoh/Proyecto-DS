package controlador;
/**
 * @author juan diego
 */

import logica.Sede;
import accesoDatos.DaoSede;

public class ControladorSede {
	
	DaoSede daoSede;

	public ControladorSede() {
		// TODO Auto-generated constructor stub
		daoSede = new DaoSede();
	}
	
	//Metodo que se encarga de Modificar los datos de la sede en la base de datos
	public int modificarSede( String nomSede, String direccion, String numeroSede, String ciudad){
		
		//se llama al dao para modificar
		System.out.println("Se va a modificar una Sede");
		
		int result = daoSede.modificarSede(nomSede, direccion, numeroSede, ciudad);
		
		System.out.println("Se modifico la Sede");
		
		return result;
		
	}
	
	//Metodo que se encarga de Consultar los datos de una Sede
	public Sede consultarSede( String nomSede, String ciudad){
		
		Sede s = new Sede();
		
		System.out.println("Se va a consultar una Sede");
		
		//Se llama al dao para consultar
		s = daoSede.consultarSede(nomSede, ciudad);
		
		return s;
	}
	
	//Metodo para cerrar la conexion con la base de datos
	public void cerrarConexionBD(){
        daoSede.cerrarConexionBD();
    }

}
