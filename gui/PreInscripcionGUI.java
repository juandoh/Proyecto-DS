package gui;
/**
 * @author juan diego ordonnez
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorPreInscripcion;

import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class PreInscripcionGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	
	ControladorPreInscripcion controladorPreInscripcion;

	private JTextField campoEvento;
	private JTextField campoParticipante;
	private JTextField campoCedula;
	private JTextField campoFecha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PreInscripcionGUI frame = new PreInscripcionGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PreInscripcionGUI() {
		
		controladorPreInscripcion = new ControladorPreInscripcion();
		
		setTitle("Realizar Preinscripcion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNonbreEvento = new JLabel("Nombre Evento:");
		lblNonbreEvento.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNonbreEvento.setBounds(53, 57, 101, 14);
		contentPane.add(lblNonbreEvento);
		
		campoEvento = new JTextField();
		campoEvento.setBounds(186, 55, 161, 20);
		contentPane.add(campoEvento);
		campoEvento.setColumns(10);
		
		JLabel lblNombreParticipante = new JLabel("Nombre Participante:");
		lblNombreParticipante.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNombreParticipante.setBounds(24, 82, 137, 14);
		contentPane.add(lblNombreParticipante);
		
		JLabel lblCedula = new JLabel("Cedula:");
		lblCedula.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCedula.setBounds(108, 111, 50, 14);
		contentPane.add(lblCedula);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFecha.setBounds(115, 136, 46, 14);
		contentPane.add(lblFecha);
		
		campoParticipante = new JTextField();
		campoParticipante.setBounds(186, 81, 161, 20);
		contentPane.add(campoParticipante);
		campoParticipante.setColumns(10);
		
		campoCedula = new JTextField();
		campoCedula.setToolTipText("Digite N\u00FAmeros");
		campoCedula.setBounds(186, 108, 161, 20);
		contentPane.add(campoCedula);
		campoCedula.setColumns(10);
		
		campoFecha = new JTextField();
		campoFecha.setToolTipText("El Formato de la fecha es DD-MM-AAAA, use el separador \"-\"");
		campoFecha.setBounds(186, 134, 161, 20);
		contentPane.add(campoFecha);
		campoFecha.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				botonGuardarActionPerformed(evt);
			}
		});
		
		btnGuardar.setBackground(new Color(0, 0, 0));
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnGuardar.setMnemonic('G');
		btnGuardar.setForeground(new Color(255, 255, 255));
		btnGuardar.setBounds(104, 170, 89, 23);
		contentPane.add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				botonCancelarActionPerformed(evt);
			}
		});
		
		btnCancelar.setBackground(new Color(0, 0, 0));
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancelar.setMnemonic('C');
		btnCancelar.setForeground(new Color(255, 255, 255));
		btnCancelar.setBounds(220, 170, 89, 23);
		contentPane.add(btnCancelar);
	}
	
	//Metodo que se encarga del evento del boton Cancelar
	private void botonCancelarActionPerformed( ActionEvent evt ){
		controladorPreInscripcion.cerrarConexionBD();
		System.out.println("Conexion cerrada...");
		System.exit(0);
	}
	
	//Metodo que se encarga de validar si el parametro de entrada es un numero
	public static boolean isNumeric(String str) {
		
        return (str.matches("[+-]?\\d*(\\.\\d+)?") && str.equals("")==false);
        
    }
    
	//Metodo que se encarga de validar si el parametro de entrada sigue el formato de fecha
	public static boolean isValidDate(String inDate) {
		
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    dateFormat.setLenient(false);
    
    try {
    	dateFormat.parse(inDate.trim());
    	} catch (ParseException pe) {
    		return false;
    		}
    return true;
    }
		
	//Metodo que se encarga del evento del boton Ingresar
	private void botonGuardarActionPerformed (ActionEvent evt ){
			String nombreEvento, nombreParticipante, cedula, fecha;
				
			nombreEvento = campoEvento.getText();
			nombreParticipante = campoParticipante.getText();
			cedula = campoCedula.getText();
			fecha = campoFecha.getText();
				
			int numFilas = controladorPreInscripcion.insertarPreInscripcion(nombreEvento, nombreParticipante, cedula, fecha);
				
			if (nombreEvento.isEmpty() || nombreParticipante.isEmpty() || cedula.isEmpty() || fecha.isEmpty()){
					JOptionPane.showMessageDialog(null, "Por favor recuerde llenar todos los campos", "Campos_Vacios", JOptionPane.WARNING_MESSAGE);
			
			} else  if ( isNumeric(cedula)== false){
				JOptionPane.showMessageDialog(null, "Por favor ingrese un numero de cedula valido", "Dato_Invalido", JOptionPane.WARNING_MESSAGE);
				
			} else  if ( isValidDate(fecha)== false){
					
				JOptionPane.showMessageDialog(null, "Por favor digite una fecha valida del tipo  DD-MM-YYYY", "Dato_Invalido", JOptionPane.WARNING_MESSAGE);
					
				} else if ( numFilas == 1 ){
					
				JOptionPane.showMessageDialog(null, "La PreInscripcion se ha guardado exitosamente", "Proceso_Exitoso", JOptionPane.PLAIN_MESSAGE);
					
			} else {
					JOptionPane.showMessageDialog(null, "Ocurrio un problema al guardar la PreInscripcion en el Sistema", "Error de Conexion", JOptionPane.ERROR_MESSAGE);
			}
		}

}
