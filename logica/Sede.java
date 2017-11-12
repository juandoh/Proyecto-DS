package logica;

/**
 * 
 * @author juan diego
 *
 */

public class Sede {
	
	String nombreSede;
	String direccion;
	String numeroSede;
	String ciudad;

	//Constructor
	public Sede() {
		// TODO Auto-generated constructor stub
	}
	
	//Metodo para conseguir el nombre de la sede
	public String getNombreSede(){
		return nombreSede;
	}
	
	//Metodo para conseguir la direccion de la sede
	public String getDireccion(){
		return direccion;
	}
	
	//Metodo para conseguir el numero de la sede
	public String getNumeroSede(){
		return numeroSede;
	}
	
	//Metodo para conseguir la ciudad de la sede
	public String getCiudad(){
		return ciudad;
	}
	
	//Metodo para asignar el nombre de la sede
	public void setNombreSede(String nomSede){
		this.nombreSede=nomSede;
	}
	
	//Metodo para asignar la direccion de la sede
	public void setDireccion(String direccion){
		this.direccion=direccion;
	}
	
	//Metodo para asignar el numero de la sede
	public void setNumeroSede(String numSede){
		this.numeroSede=numSede;
	}
	
	//Metodo para asignar la ciudad de la sede
	public void setCiudad(String ciudad){
		this.ciudad=ciudad;
	}

}
