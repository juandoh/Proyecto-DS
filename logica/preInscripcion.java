package logica;

public class preInscripcion {
	
	String nombreEvento;
	String nombreParticipante;
	String cedula;
	String fecha;

	public preInscripcion() {
		// TODO Auto-generated constructor stub
	}
	
	//Metodo para conseguir el nombre del evento
	public String getNombreEvento(){
		return nombreEvento;
	}
	
	//Metodo para conseguir el nombre del participante
	public String getNombreParticipante() {
        return nombreParticipante;
    }
	
	//Metodo para conseguir la cedula del participante
	public String getCedula() {
        return cedula;
    }
	
	//Metodo para conseguir la fecha del evento
	public String getfecha(){
		return fecha;
	}
	
	//Metodo para asignar el nombre del evento
	public void setNombreEvento(String nombreEvento){
		this.nombreEvento = nombreEvento;
	}
	
	//Metodo para asignar el nombre del participante
	public void setNombreParticipante(String nombreParticipante){
		this.nombreParticipante = nombreParticipante;
	}
	
	//Metodo para asignar la cedula del participante
	public void setCedula(String cedula) {
        this.cedula = cedula;
    }
	
	//Metodo para asignar fecha del evento
	public void setFecha(String fecha){
		this.fecha = fecha;
	}

}//Fin de la clase preInscripcion
