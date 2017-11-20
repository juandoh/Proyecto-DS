package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import controlador.ControladorDiploma;
import controlador.ControladorEvento;
import controlador.ControladorInscripcion;
import controlador.ControladorUsuario;
import logica.Diploma;
import logica.Usuario;

public class GenerarDiplomaGUI extends JFrame{
	
	ControladorEvento controladorEvento;
	ControladorDiploma controladorDiploma;
	
	private JPanel contentPane;
	private JLabel lblNombreE;
	private JTextField campoNombreP, campoCedula, campoHoras;
	private JDateChooser campoFecha;
	private JComboBox campoTipo;
	private JComboBox campoEvento;
	private JButton limpiar, btnImprimir;
	private String[] itemsNavegador, tipos={"De Asistencia", "De Certificacion"};
	private int switchNavegador;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GenerarDiplomaGUI frame = new GenerarDiplomaGUI();
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

	public GenerarDiplomaGUI() {
		
		controladorEvento = new ControladorEvento();
		controladorDiploma = new ControladorDiploma();
		
		setBackground(new Color(255, 255, 255));
		setResizable(false);
		setTitle("Generar Diploma");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(180, 0, 150));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		switchNavegador = 1;
		
		//----------------------------Etiquetas de la interfaz---------------------------
		//Se establece la JLabel para el titulo
		JLabel lblTitulo = new JLabel("Generar Diploma.");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTitulo.setBounds(160, 5, 260, 40);
		contentPane.add(lblTitulo);
		
		//Se establece la JLabel para el nombre del participante
		JLabel lblNombreP = new JLabel("Nombre del participante:");
		lblNombreP.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNombreP.setBounds(23, 60, 200, 30);
		contentPane.add(lblNombreP);
		
		//Se establece la JLabel para la cedula
		JLabel lblCedula = new JLabel("Cedula:");
		lblCedula.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCedula.setBounds(23, 90, 150, 30);
		contentPane.add(lblCedula);
		
		//Se establece la JLabel para la fecha
		JLabel lblFecha = new JLabel("Fecha generacion diploma:");
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFecha.setBounds(23, 120, 200, 30);
		contentPane.add(lblFecha);
		
		//Se establece la JLabel para el nombre del evento
		lblNombreE = new JLabel("Seleccione ciudad de evento: -->");
		lblNombreE.setFont(new Font("Arial", Font.ITALIC, 14));
		lblNombreE.setBounds(20, 165, 250, 30);
		contentPane.add(lblNombreE);
		
		//Se establece la JLabel para las horas
		JLabel lblHoras = new JLabel("Horas de participacion:");
		lblHoras.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblHoras.setBounds(23, 210, 150, 30);
		contentPane.add(lblHoras);
		
		//Se establece la JLabel para tipo de diploma
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTipo.setBounds(23, 240, 150, 30);
		contentPane.add(lblTipo);
		//--------------------------------------------------------------------------------------
		//---------------------------------Campos de Texto--------------------------------------
		//Se determina el campo del nombre del participante
		campoNombreP = new JTextField();
		campoNombreP.setBounds(200, 60, 200, 20);
		contentPane.add(campoNombreP);
		campoNombreP.setColumns(10);
		campoNombreP.setEditable(false);
		
		//Se determina el campo de la cedula
		campoCedula = new JTextField();
		campoCedula.setBounds(200, 90, 200, 20);
		contentPane.add(campoCedula);
		campoCedula.setColumns(10);
		
		//Se determina el campo de la fecha
		campoFecha = new JDateChooser();
		campoFecha.setDateFormatString("d-MM-yyyy");
		campoFecha.setBounds(200, 120, 200, 20);
		contentPane.add(campoFecha);
		
		//Se determina el campo de las horas
		campoHoras = new JTextField();
		campoHoras.setBounds(200, 210, 200, 20);
		contentPane.add(campoHoras);
		campoHoras.setColumns(10);
		//--------------------------------------------------------------------------------------
		//--------------------------------------ComboBox-------------------------------------
		//Se determina la caja de opciones del tipo
		campoTipo = new JComboBox(tipos);
		campoTipo.setForeground(new Color(0, 0, 0));
		campoTipo.setBackground(new Color(204, 255, 255));
		campoTipo.setBounds(200, 240, 200, 20);
		contentPane.add(campoTipo);
		
		//Se determina la caja de opciones del tipo
		campoEvento = new JComboBox();
		campoEvento.setForeground(new Color(0, 0, 0));
		campoEvento.setBackground(new Color(204, 255, 255));
		campoEvento.setBounds(240, 170, 160, 20);
		campoEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				navegadorEvento(evt);
			}
		});
		contentPane.add(campoEvento);
		//Se agregan las ciudades al combobox
		this.itemsNavegador = controladorEvento.consultarCiudades();
		DefaultComboBoxModel model = new DefaultComboBoxModel( itemsNavegador );
		campoEvento.setModel( model );
		//--------------------------------------------------------------------------------------
		//--------------------------------------Separadores-------------------------------------
		//Se pone un separador en la interfaz
		JSeparator separator = new JSeparator();
		separator.setBounds(31, 200, 375, 2);
		contentPane.add(separator);
		
		//Se pone un separador en la interfaz
		JSeparator separator2 = new JSeparator();
		separator2.setBounds(31, 160, 375, 2);
		contentPane.add(separator2);
		//--------------------------------------------------------------------------------------
		//---------------------------------------Botones----------------------------------------
		//-----Boton limpiar-----
		limpiar = new JButton("Limpiar");
		limpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				botonLimpiarActionPerformed(evt);
			}
		});
		limpiar.setToolTipText("Confirmar generacion de diploma.");
		limpiar.setBackground(new Color(0, 200, 0));
		limpiar.setFont(new Font("Tahoma", Font.BOLD, 12));
		limpiar.setMnemonic('L');
		limpiar.setForeground(new Color(255, 255, 255));
		limpiar.setBounds(420, 170, 80, 20);
		contentPane.add(limpiar);
		limpiar.setVisible(false);
		
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
				
		btnGuardar.setToolTipText("Confirmar generacion de diploma.");
		btnGuardar.setBackground(new Color(0, 255, 0));
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnGuardar.setMnemonic('G');
		btnGuardar.setForeground(new Color(255, 255, 255));
		btnGuardar.setBounds(200, 280, 80, 80);
		contentPane.add(btnGuardar);
				
		//-----Boton Consultar-----
		JButton btnConsultar = new JButton();
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				botonConsultarActionPerformed(evt);
			}
		});
		ImageIcon aux3 = new ImageIcon(getClass().getResource("/imagen/ruedas-dentadas-icono-de-lupa.png"));
		ImageIcon temp3 = new ImageIcon(aux3.getImage().getScaledInstance(70, -1, Image.SCALE_DEFAULT));
		btnConsultar.setIcon(temp3);
				
		btnConsultar.setToolTipText("Consulte los datos del participante segun su cedula.");
		btnConsultar.setBackground(new Color(0, 0, 255));
		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnConsultar.setMnemonic('C');
		btnConsultar.setForeground(new Color(255, 255, 255));
		btnConsultar.setBounds(420, 60, 80, 80);
		contentPane.add(btnConsultar);
		
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
		
		btnCancelar.setToolTipText("Descartar y salir.");		
		btnCancelar.setBackground(new Color(255, 0, 0));
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancelar.setMnemonic('C');
		btnCancelar.setForeground(new Color(255, 255, 255));
		btnCancelar.setBounds(300, 280, 80, 80);
		contentPane.add(btnCancelar);
		
		//-----Boton imprimir-----
		btnImprimir = new JButton();
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				botonImprimirActionPerformed(evt);
			}
		});
		ImageIcon aux4 = new ImageIcon(getClass().getResource("/imagen/boton_imprimir.png"));
		ImageIcon temp4 = new ImageIcon(aux4.getImage().getScaledInstance(70, -1, Image.SCALE_DEFAULT));
		btnImprimir.setIcon(temp4);
		
		btnImprimir.setToolTipText("Imprimir diploma generado.");		
		btnImprimir.setBackground(new Color(180, 0, 130));
		btnImprimir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnImprimir.setMnemonic('C');
		btnImprimir.setForeground(new Color(255, 255, 255));
		btnImprimir.setBounds(450, 280, 80, 80);
		contentPane.add(btnImprimir);
		btnImprimir.setEnabled(false);
		
	}
	//--------------------------------------------------------------------------------------
	
	private void navegadorEvento(ActionEvent evt){
		switch(switchNavegador){//caso 1, el navegador tiene las ciudades y obtiene los eventos; caso 2, el navegador obtiene las ciudades
		case 1:
			this.itemsNavegador = controladorEvento.consultarEventosEnCiudad((String) campoEvento.getSelectedItem());
			DefaultComboBoxModel model = new DefaultComboBoxModel( this.itemsNavegador );
			campoEvento.setModel( model );
			JOptionPane.showMessageDialog(null, "Si desea volver a escoger la ciudad y seleccionar otro evento haga click en LIMPIAR.");
			switchNavegador = 2;
			limpiar.setVisible(true);
			lblNombreE.setText("Seleccione un evento: -->");
		break;
		case 2:
			JOptionPane.showMessageDialog(null, "Recuerde que si desea volver a escoger la ciudad y seleccionar otro evento haga click en LIMPIAR.");
		break;
		}
		
	}
	//--------------------------------------------------------------------------------------
	
	private void botonLimpiarActionPerformed(ActionEvent evt){
		this.itemsNavegador = controladorEvento.consultarCiudades();
		DefaultComboBoxModel model = new DefaultComboBoxModel( itemsNavegador );
		campoEvento.setModel( model );
		limpiar.setVisible(false);
		switchNavegador = 1;
		lblNombreE.setText("Seleccione ciudad de evento: -->");
	}
	//--------------------------------------------------------------------------------------
	
	private void botonGuardarActionPerformed(ActionEvent evt){
		String nombre_participante, cedula, fecha, nombre_evento, horas, tipo;
		boolean diplomaInexistente, participanteParticipaEvento;
		
		nombre_participante = campoNombreP.getText();
		cedula = campoCedula.getText();
		String formato = campoFecha.getDateFormatString();
		Date date = (Date) campoFecha.getDate();
		SimpleDateFormat sdf = new SimpleDateFormat(formato);
		if(campoFecha.getDate() != null){
			fecha = String.valueOf(sdf.format(date));
		}else{fecha="";}
		
		nombre_evento = (String) campoEvento.getSelectedItem();
		horas = campoHoras.getText();
		tipo = (String) campoTipo.getSelectedItem();
		
		diplomaInexistente = controladorDiploma.comprobarDiplomaInexistente(cedula, nombre_evento);
		participanteParticipaEvento = controladorDiploma.comprobarParticipanteParticipaEvento(cedula, nombre_evento);
		
		if(switchNavegador == 1){
			JOptionPane.showMessageDialog(null, "Seleccione una ciudad y luego un evento para poder continuar.");
		}else if(fecha.equals("") || horas.equals("") || cedula.equals("") || nombre_participante.equals(null) || nombre_participante.equals("")){
			JOptionPane.showMessageDialog(null, "Por favor, asegurese de llenar todos los campos.");
		}else if(diplomaInexistente == false){
			JOptionPane.showMessageDialog(null, "El diploma que desea generar ya existe.", "Diploma existente", JOptionPane.INFORMATION_MESSAGE);
		}else if(participanteParticipaEvento == false){
			JOptionPane.showMessageDialog(null, "El participante indicado no se inscribio al evento seleccionado.", "Participacion nula", JOptionPane.INFORMATION_MESSAGE);
		}else{
			int result = controladorDiploma.generarDiploma(nombre_participante, cedula, fecha, nombre_evento, horas, tipo);
			
			if(result == 1){
			campoHoras.setEditable(false);
			campoFecha.setEnabled(false);
			campoCedula.setEditable(false);
			campoTipo.setEditable(false);
			campoEvento.setEditable(false);
			btnImprimir.setEnabled(true);}
			else{
				controladorDiploma.cerrarConexionBD();
				System.out.println("Conexion cerrada...");}
			
		}
		
	}
	//--------------------------------------------------------------------------------------
	
	private void botonConsultarActionPerformed(ActionEvent evt){
		String cedula = campoCedula.getText();
		String usu;
		
		usu = controladorDiploma.obtenerNombreParticipante(cedula);
		
		if ( usu == null ) {
			JOptionPane.showMessageDialog(null, "El usuario indicado no se inscribio a ningun evento.", "No Encontrado", JOptionPane.INFORMATION_MESSAGE);
		} else {
			campoNombreP.setText(usu);
		}
	}
	//--------------------------------------------------------------------------------------
	
	private void botonCancelarActionPerformed(ActionEvent evt){
		controladorDiploma.cerrarConexionBD();
		System.out.println("Conexion cerrada...");
		dispose();
	}
	//--------------------------------------------------------------------------------------
	
	private void botonImprimirActionPerformed(ActionEvent evt){
		String nombre_participante, cedula, fecha, nombre_evento, horas, tipo;
		nombre_participante = campoNombreP.getText();
		cedula = campoCedula.getText();
		
		String formato = campoFecha.getDateFormatString();
		Date date = (Date) campoFecha.getDate();
		SimpleDateFormat sdf = new SimpleDateFormat(formato);
		fecha = String.valueOf(sdf.format(date));
		
		nombre_evento = (String) campoEvento.getSelectedItem();
		horas = campoHoras.getText();
		tipo = (String) campoTipo.getSelectedItem();
		
		VerDiploma aplicacion1 = new VerDiploma(){
			public void dispose(){
				getFrame().setVisible(true);
				super.dispose();
			}
		};
		aplicacion1.setVisible(true);
		aplicacion1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		aplicacion1.asignarDatos(nombre_participante, cedula, fecha, nombre_evento, horas, tipo);
		//dispose();//noooo
	}
	//--------------------------------------------------------------------------------------

	//Metodo para conseguir el JFrame de la Ventana Principal
	private JFrame getFrame(){
		return this;
	}
	//--------------------------------------------------------------------------------------
}
