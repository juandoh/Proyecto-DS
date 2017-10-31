package gui;
/**
 * @author juan diego ordonnez
 */

import java.awt.EventQueue;
import javax.swing.JFrame;

import controlador.ControladorPreInscripcion;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PreInscripcionGUI {

	private JFrame frmRealiza;
	
	//Se inicia el objeto ControladorModificarUsuario
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
					PreInscripcionGUI window = new PreInscripcionGUI();
					window.frmRealiza.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PreInscripcionGUI() {
		initialize();
		controladorPreInscripcion = new ControladorPreInscripcion();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRealiza = new JFrame();
		frmRealiza.setTitle("Realizar Preinscripcion");
		frmRealiza.setBounds(100, 100, 400, 260);
		frmRealiza.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRealiza.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 153, 255));
		panel.setBounds(0, 0, 384, 222);
		frmRealiza.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNonbreEvento = new JLabel("Nombre Evento:");
		lblNonbreEvento.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNonbreEvento.setBounds(53, 57, 101, 14);
		panel.add(lblNonbreEvento);
		
		campoEvento = new JTextField();
		campoEvento.setBounds(186, 55, 161, 20);
		panel.add(campoEvento);
		campoEvento.setColumns(10);
		
		JLabel lblNombreParticipante = new JLabel("Nombre Participante:");
		lblNombreParticipante.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNombreParticipante.setBounds(24, 82, 137, 14);
		panel.add(lblNombreParticipante);
		
		JLabel lblCedula = new JLabel("Cedula:");
		lblCedula.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCedula.setBounds(108, 111, 50, 14);
		panel.add(lblCedula);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFecha.setBounds(115, 136, 46, 14);
		panel.add(lblFecha);
		
		campoParticipante = new JTextField();
		campoParticipante.setBounds(186, 81, 161, 20);
		panel.add(campoParticipante);
		campoParticipante.setColumns(10);
		
		campoCedula = new JTextField();
		campoCedula.setToolTipText("Digite N\u00FAmeros");
		campoCedula.setBounds(186, 108, 161, 20);
		panel.add(campoCedula);
		campoCedula.setColumns(10);
		
		campoFecha = new JTextField();
		campoFecha.setToolTipText("El Formato de la fecha es DD-MM-AAAA, use el separador \"-\"");
		campoFecha.setBounds(186, 134, 161, 20);
		panel.add(campoFecha);
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
		panel.add(btnGuardar);
		
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
		panel.add(btnCancelar);
	}
	
	//Metodo que se encarga del evento del boton Cancelar
	private void botonCancelarActionPerformed( ActionEvent evt ){
		controladorPreInscripcion.cerrarConexionBD();
		System.out.println("Conexion cerrada...");
		System.exit(0);
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
				JOptionPane.showMessageDialog(null, "Por favor recuerde llenar todos los campos");
			} else if ( numFilas == 1 ){
				
				JOptionPane.showMessageDialog(null, "La PreInscripcion se guardado exitosamente");
				
			} else {
				JOptionPane.showMessageDialog(null, "Ocurrio un problema al guardar la PreInscripcion en el Sistema");
			}
		}
}
