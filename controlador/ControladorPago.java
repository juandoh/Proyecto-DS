package controlador;

import logica.Pago;
import accesoDatos.DaoPago;

/**
 * 
 * @author juan diego ordonnez
 *
 */

public class ControladorPago {
	
	DaoPago daoPago;

	//Constructor
	public ControladorPago() {
		// TODO Auto-generated constructor stub
		daoPago = new DaoPago();
	}
	
	//Metodo que se encarga de Insentar los datos del pago en la base de datos
	public int insertarPago(String nomEvento, String nomParticipante, String cedula, String formaPago, String valor, String fecha){
		Pago pa = new Pago();
		
		pa.setNombreEvento(nomEvento);
		pa.setNombreParticipante(nomParticipante);
		pa.setCedula(cedula);
		pa.setFormaPago(formaPago);
		pa.setValor(valor);
		pa.setFecha(fecha);
		
		//Se llama al dao para guardar
        System.out.println("Se va a insertar un Pago");
        
        int result = daoPago.guardarPago(pa);
        
        System.out.println("Se inserto un nuevo Pago");
        
        return result;
		
	}
	
	//Metodo para cerrar la conexion a la base de datos
		public void cerrarConexionBD(){
	        daoPago.cerrarConexionBD();
	    }

}
