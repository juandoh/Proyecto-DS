package logica;
/**
 * 
 * @author juan diego ordonnez
 *
 */

public class Pago {
	
	String nombreEvento;
	String nombreParticipante;
	String cedula;
	String formaPago;
	String valor;
	String fecha;

	//Constructor
	public Pago() {
		// TODO Auto-generated constructor stub
	}
	
	public String getNombreEvento(){
		return nombreEvento;
	}
	
	public String getNombreParticipante(){
		return nombreParticipante;
	}
	
	public String getCedula(){
		return cedula;
	}
	
	public String getFormaPago(){
		return formaPago;
	}
	
	public String getValor(){
		return valor;
	}
	
	public String getFecha(){
		return fecha;
	}
	
	public void setNombreEvento(String nomEvento){
		this.nombreEvento = nomEvento;
	}
	
	public void setNombreParticipante(String nomParticipante){
		this.nombreParticipante = nomParticipante;
	}
	
	public void setCedula(String cedula){
		this.cedula = cedula;
	}
	
	public void setFormaPago(String formaPago){
		this.formaPago = formaPago;
	}
	
	public void setValor(String valor){
		this.valor = valor;
	}
	
	public void setFecha(String fecha){
		this.fecha = fecha;
	}

}//Fin de la clase Pago
