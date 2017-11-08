package logica;

public class Inscripcion {
	String nombreEvento;
	String nombreParticipante;
	String cedula;
	String fecha_Inscripcion;
	String telefono;
	String email;
	//String forma_pago;
	//String valor;
	
	public Inscripcion(String nombre_evento, String nombre_participante, String cedula, String fecha_inscripcion, String telefono, String email) {
		this.nombreEvento = nombre_evento;
		this.nombreParticipante = nombre_participante;
		this.cedula = cedula;
		this.fecha_Inscripcion = fecha_inscripcion;
		this.telefono = telefono;
		this.email = email;
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
		return fecha_Inscripcion;
	}
	
	//Metodo para conseguir el telefono del participante
	public String getTelefono(){
		return telefono;
	}
		
	//Metodo para conseguir el email del participante
	public String getEmail(){
		return email;
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
		
	//Metodo para asignar fecha de inscripcion
	public void setFecha(String fecha){
		this.fecha_Inscripcion = fecha;
	}
	
	//Metodo para asignar telefono
	public void setTelefono(String telefono){
		this.telefono = telefono;
	}
	
	//Metodo para asignar email
		public void setEmail(String email){
			this.email = email;
		}
	

}
