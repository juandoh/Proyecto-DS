package controlador;

import javax.swing.JOptionPane;

import accesoDatos.DaoDiploma;
import accesoDatos.DaoInscripcion;
import logica.Diploma;

public class ControladorDiploma {
	
	DaoDiploma daoDiploma;

	public ControladorDiploma() {
		// TODO Auto-generated constructor stub
		daoDiploma = new DaoDiploma();
	}
	//--------------------------------------------------------------------------------------
	
	public String obtenerNombreParticipante(String cedula){
		String nombre=null;
		nombre = daoDiploma.obtenerNombreParticipante(cedula);
		return nombre;
	}
	//--------------------------------------------------------------------------------------
	
	public int generarDiploma(String nombre_participante, String cedula, String fecha, String nombre_evento, String horas, String tipo){
		Diploma dip = new Diploma();
		dip.setNombre_participante(nombre_participante);
		dip.setCedula(cedula);
		dip.setFecha(fecha);
		dip.setNombre_evento(nombre_evento);
		dip.setHoras(horas);
		dip.setTipo(tipo);
		
		int result = daoDiploma.generarDiploma(dip);
		
		if(result == 1){JOptionPane.showMessageDialog(null, "El diploma se genero correctamente.","Generacion diploma Realizada", JOptionPane.INFORMATION_MESSAGE);}
		else if(result == -1){JOptionPane.showMessageDialog(null, "No se pudo generar el diploma.", "Fallo generacion diploma", JOptionPane.WARNING_MESSAGE);}
		return result;
		
	}
	//--------------------------------------------------------------------------------------
	//Si se puede obtener el nombre del participante a partir de cedula y nombre de evento en la tabla diploma,
	//significa que el diploma ya existe.
	public boolean comprobarDiplomaInexistente(String cedula, String nombre_evento){
		String nombre = daoDiploma.comprobarDiplomaInexistente(cedula, nombre_evento);
		
		if(nombre.equals("") || nombre == null){
			return true;
		}else{
			return false;
		}
	}
	//--------------------------------------------------------------------------------------
	//Si se puede obtener el nombre del participante a partir de cedula y nombre de evento en la tabla inscripcion,
	//significa que el participante si participo en ese evento.
	public boolean comprobarParticipanteParticipaEvento(String cedula, String nombre_evento){
		String nombre = daoDiploma.comprobarParticipanteParticipaEvento(cedula, nombre_evento);
		
		if(nombre.equals("") || nombre == null){
			return false;
		}else{
			return true;
		}
	}
	//--------------------------------------------------------------------------------------
	
	//Metodo para cerrar la conexion
	public void cerrarConexionBD(){
        daoDiploma.cerrarConexionBD();
	}
	//--------------------------------------------------------------------------------------

}
