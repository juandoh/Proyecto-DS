package logica;

public class Diploma {
	private String nombre_participante, cedula, fecha, nombre_evento, horas, tipo;
	
	public Diploma() {
	}

	public String getHoras() {
		return horas;
	}

	public void setHoras(String horas) {
		this.horas = horas;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNombre_participante() {
		return nombre_participante;
	}

	public void setNombre_participante(String nombre_participante) {
		this.nombre_participante = nombre_participante;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre_evento() {
		return nombre_evento;
	}

	public void setNombre_evento(String nombre_evento) {
		this.nombre_evento = nombre_evento;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

}
