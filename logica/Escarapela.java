package logica;
/**
 * 
 * @author juan diego ordonnez
 *
 */

public class Escarapela {
	
	String participante;
	String cedula;
	String fecha;
	String nombreEvento;

	//Constructor
	public Escarapela() {
		// TODO Auto-generated constructor stub
	}
	
	//Metodo para conseguir el nombre del participante
	public String getParticipante(){
		return participante;
	}
	
	//Metodo para conseguir la cedula del participante
	public String getCedula(){
		return cedula;
	}
	
	//Metodo para conseguir la fecha del evento
	public String getFecha(){
		return fecha;
	}
	
	//Metodo para conseguir el nombre del evento
	public String getNombreEvento(){
		return nombreEvento;
	}
	
	//Metodo para asignar el nombre del Participante
	public void setParticipante(String participante){
		this.participante=participante;
	}
	
	//Metodo para asignar la cedula del Participante
	public void setCedula(String cedula){
		this.cedula=cedula;
	}
	
	//Metodo para asignar la fecha del Evento
	public void setFecha(String fecha){
		this.fecha=fecha;
	}
	
	//Metodo para asignar el nombre del Evento
	public void setNombreEvento(String nomEvento){
		this.nombreEvento=nomEvento;
	}

}
