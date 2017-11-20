package logica;

public class Evento {
	private String nombre, fecha, ciudad, costo, estado;
	
	public Evento() {
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public void setFecha(String fecha){
		this.fecha = fecha;
	}
	
	public void setCiudad(String ciudad){
		this.ciudad = ciudad;
	}
	
	public void setCosto(String costo){
		this.costo = costo;
	}
	
	public void setEstado(String estado){
		this.estado = estado;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public String getFecha(){
		return fecha;
	}
	
	public String getCiudad(){
		return ciudad;
	}
	
	public String getCosto(){
		return costo;
	}
	
	public String getEstado(){
		return estado;
	}

}
