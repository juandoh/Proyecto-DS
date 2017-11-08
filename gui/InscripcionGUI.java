package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorInscripcion;
import controlador.ControladorPreInscripcion;
import logica.Usuario;
import logica.preInscripcion;

import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author David Mera
 */



public class InscripcionGUI extends JFrame {
	
	private JPanel contentPane;
	
	ControladorInscripcion controladorInscripcion;

	private JTextField campoEvento;
	private JTextField campoParticipante;
	private JTextField campoCedula;
	private JTextField campoFechaPre;
	private JTextField campoFechaIns;
	private JTextField campoFormaPago;
	private JTextField campoValor;
	private JTextField campoTelefono;
	private JTextField campoEmail;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InscripcionGUI frame = new InscripcionGUI();
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
	public InscripcionGUI() {
		
		controladorInscripcion = new ControladorInscripcion();
		
		setTitle("Realizar Inscripcion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Realizacion de Inscripcion.");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTitulo.setBounds(23, 11, 260, 23);
		contentPane.add(lblTitulo);
		
		
		JLabel lblNonbreEvento = new JLabel("Nombre Evento:");
		lblNonbreEvento.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNonbreEvento.setBounds(53, 57, 101, 14);
		contentPane.add(lblNonbreEvento);
		
		campoEvento = new JTextField();
		campoEvento.setBounds(186, 53, 161, 20);
		contentPane.add(campoEvento);
		campoEvento.setColumns(10);
		campoEvento.setEnabled(false);
		
		JLabel lblNombreParticipante = new JLabel("Nombre Participante:");
		lblNombreParticipante.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNombreParticipante.setBounds(24, 82, 137, 14);
		contentPane.add(lblNombreParticipante);
		
		campoParticipante = new JTextField();
		campoParticipante.setBounds(186, 81, 161, 20);
		contentPane.add(campoParticipante);
		campoParticipante.setColumns(10);
		campoParticipante.setEnabled(false);
		
		JLabel lblCedula = new JLabel("Cedula:");
		lblCedula.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCedula.setBounds(108, 111, 50, 14);
		contentPane.add(lblCedula);
		
		campoCedula = new JTextField();
		campoCedula.setToolTipText("Digite N\u00FAmeros");
		campoCedula.setBounds(186, 108, 161, 20);
		contentPane.add(campoCedula);
		campoCedula.setColumns(10);
		
		JLabel lblFechaPre = new JLabel("Fecha Pre-inscripcion:");
		lblFechaPre.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFechaPre.setBounds(22, 136, 160, 14);
		contentPane.add(lblFechaPre);
		
		campoFechaPre = new JTextField();
		campoFechaPre.setToolTipText("El Formato de la fecha es DD-MM-AAAA, use el separador \"-\"");
		campoFechaPre.setBounds(186, 136, 161, 20);
		contentPane.add(campoFechaPre);
		campoFechaPre.setColumns(10);
		campoFechaPre.setEnabled(false);
		
		JLabel lblFechaIns = new JLabel("Fecha de Inscripcion:");
		lblFechaIns.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFechaIns.setBounds(24, 164, 160, 14);
		contentPane.add(lblFechaIns);
		
		campoFechaIns = new JTextField();
		campoFechaIns.setToolTipText("El Formato de la fecha es DD-MM-AAAA, use el separador \"-\"");
		campoFechaIns.setBounds(186, 164, 161, 20);
		contentPane.add(campoFechaIns);
		campoFechaIns.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTelefono.setBounds(94, 194, 160, 14);
		contentPane.add(lblTelefono);
		
		campoTelefono = new JTextField();
		campoTelefono.setBounds(186, 194, 161, 20);
		contentPane.add(campoTelefono);
		campoTelefono.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEmail.setBounds(115, 224, 160, 14);
		contentPane.add(lblEmail);
		
		campoEmail = new JTextField();
		campoEmail.setBounds(186, 224, 161, 20);
		contentPane.add(campoEmail);
		campoEmail.setColumns(10);
		
		//-----Boton consultar-----
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				botonConsultarActionPerformed(evt);
			}
		});
				
		btnConsultar.setBackground(new Color(0, 0, 0));
		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnConsultar.setMnemonic('C');
		btnConsultar.setForeground(new Color(255, 255, 255));
		btnConsultar.setBounds(360, 108, 90, 23);
		contentPane.add(btnConsultar);
				
		//-----Boton guardar-----
		JButton btnGuardar = new JButton();
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				botonGuardarActionPerformed(evt);
			}
		});
		
		ImageIcon aux = new ImageIcon(getClass().getResource("/imagen/savetheapplication_guardar_2958.png"));
		ImageIcon temp = new ImageIcon(aux.getImage().getScaledInstance(70, -1, Image.SCALE_DEFAULT));
		btnGuardar.setIcon(temp);
		
		btnGuardar.setBackground(new Color(0, 0, 0));
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnGuardar.setMnemonic('G');
		btnGuardar.setForeground(new Color(255, 255, 255));
		
		btnGuardar.setBounds(104, 270, 80, 80);
		contentPane.add(btnGuardar);
		
		//-----Boton cancelar-----
		JButton btnCancelar = new JButton();
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				botonCancelarActionPerformed(evt);
			}
		});
		ImageIcon aux2 = new ImageIcon(getClass().getResource("/imagen/cancel_botton.png"));
		ImageIcon temp2 = new ImageIcon(aux2.getImage().getScaledInstance(70, -1, Image.SCALE_DEFAULT));
		btnCancelar.setIcon(temp2);
		
		btnCancelar.setBackground(new Color(0, 0, 0));
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancelar.setMnemonic('C');
		btnCancelar.setForeground(new Color(255, 255, 255));
		btnCancelar.setBounds(220, 270, 80, 80);
		contentPane.add(btnCancelar);
	}
	
	
	private void botonConsultarActionPerformed( ActionEvent evt ){
		String cedula;
		cedula = campoCedula.getText();
		
		preInscripcion pre;
		
		pre = controladorInscripcion.consultarPreinscripcion(cedula);
		if ( pre.getCedula() == null ) {
			JOptionPane.showMessageDialog(null, "La pre-inscripcion no existe.", "No Encontrado", JOptionPane.INFORMATION_MESSAGE);
		} else {
			campoEvento.setText(pre.getNombreEvento());
			campoParticipante.setText(pre.getNombreParticipante());
			campoFechaPre.setText(pre.getfecha());
		}
	}
	
	//Metodo que se encarga del evento del boton Cancelar
	private void botonCancelarActionPerformed( ActionEvent evt ){
		controladorInscripcion.cerrarConexionBD();
		System.out.println("Conexion cerrada...");
		System.exit(0);
	}
	
	
	//Metodo que se encarga del evento del boton Ingresar
	private void botonGuardarActionPerformed (ActionEvent evt ){
		String nombre_evento, nombre_participante, cedula, fecha, telefono, email;
		
		nombre_evento = campoEvento.getText();
		nombre_participante = campoParticipante.getText();
		cedula = campoCedula.getText();
		fecha = campoFechaIns.getText();
		telefono = campoTelefono.getText();
		email = campoEmail.getText();
		
				
		if ( campoFechaIns.getText().equals("") || campoTelefono.getText().equals("") || campoEmail.getText().equals("") )
		{
			JOptionPane.showMessageDialog(null, "Por favor llenar todos los campos");
		} else if (campoParticipante.getText().equals("") || campoEvento.getText().equals("") || campoFechaPre.getText().equals("")){
			JOptionPane.showMessageDialog(null, "La Contraseña no coincide con la Confirmación, digite de nuevo", "Contraseña Invalida", JOptionPane.ERROR_MESSAGE);
		} else if (controladorInscripcion.comprobarNoInscrito(cedula) == true) {
			JOptionPane.showMessageDialog(null, "Ya se ha realizado una inscripcion con el numero de cedula indicado. No se puede realizar una inscripcion otra vez.", "Inscripcion Existente", JOptionPane.ERROR_MESSAGE);
		} else {
			controladorInscripcion.insertarInscripcion(nombre_evento, nombre_participante, cedula, fecha, telefono, email);
			JOptionPane.showMessageDialog(null, "Inscripcion realizada para: " + nombre_participante);
		}
	}

}
