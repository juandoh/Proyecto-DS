package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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

import controlador.ControladorEvento;
import controlador.ControladorInscripcion;
import logica.Evento;
import logica.preInscripcion;

public class CancelarEventoGUI extends JFrame {
	
	ControladorEvento controladorEvento;

	private JPanel contentPane;
	private JTextField campoFecha;
	private JTextField campoCosto;
	private JTextField campoEstado;
	private JComboBox campoCiudades, campoNombres;
	private String[] listaCiudades, listaNombres;
	private JLabel Nota;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CancelarEventoGUI frame = new CancelarEventoGUI();
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
	public CancelarEventoGUI() {
		setResizable(false);
		
		controladorEvento = new ControladorEvento();
		
		setTitle("Cancelar Evento");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 487, 350);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 200, 50));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Se establece la JLabel para el titulo
		JLabel lblTitulo = new JLabel("Cancelar Evento.");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTitulo.setBounds(23, 11, 260, 23);
		contentPane.add(lblTitulo);
		
		//Se establece la JLabel lblNonbreEvento
		JLabel lblNonbreEvento = new JLabel("Nombre Evento:");
		lblNonbreEvento.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNonbreEvento.setBounds(47, 56, 123, 14);
		contentPane.add(lblNonbreEvento);
		
		//Se establece la JLabel lblNonbreEvento
		JLabel lblFecha = new JLabel("Fecha evento:");
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFecha.setBounds(47, 84, 152, 14);
		contentPane.add(lblFecha);
		
		//Se establece el JTextField campoEvento

		campoFecha = new JTextField();
		campoFecha.setBounds(186, 81, 161, 20);
		contentPane.add(campoFecha);
		campoFecha.setColumns(10);
		campoFecha.setEditable(false);
		
		//Se establece la JLabel lblNonbreEvento
		JLabel lblCiudad = new JLabel("Ciudad evento:");
		lblCiudad.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCiudad.setBounds(47, 111, 152, 14);
		contentPane.add(lblCiudad);
		
		//Se establece la JLabel lblNonbreEvento
		JLabel lblCosto = new JLabel("Costo evento:");
		lblCosto.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCosto.setBounds(47, 139, 162, 14);
		contentPane.add(lblCosto);
		
		//Se establece el JTextField campoEvento
		campoCosto = new JTextField();
		campoCosto.setBounds(186, 138, 161, 20);
		contentPane.add(campoCosto);
		campoCosto.setColumns(10);
		campoCosto.setEditable(false);
		
		//Se establece la JLabel lblNonbreEvento
		JLabel lblEstado = new JLabel("Estado evento:");
		lblEstado.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEstado.setBounds(47, 167, 152, 14);
		contentPane.add(lblEstado);
		
		//Se establece el JTextField campoEvento
		campoEstado = new JTextField();
		campoEstado.setBounds(186, 166, 161, 20);
		contentPane.add(campoEstado);
		campoEstado.setColumns(10);
		campoEstado.setEditable(false);
		
		//Se pone una nota en la interfaz
		Nota = new JLabel();
		ImageIcon help = new ImageIcon(getClass().getResource("/imagen/help_button.png"));
		ImageIcon temp_help = new ImageIcon(help.getImage().getScaledInstance(70, -1, Image.SCALE_DEFAULT));
		Nota.setIcon(temp_help);
		Nota.setBounds(400, 5, 80, 80);
		Nota.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(null, "Para cancelar un evento primero debe seleccionar la ciudad del evento a cancelar.\nDespues debera seleccionar el nombre del mismo.\nAsi podra consultar los datos del evento deseado, dando click en el boton CONSULTAR.\nFinalmente haga click en el boton GUARDAR para finalizar.", "Ayuda.", JOptionPane.INFORMATION_MESSAGE);	
			}
			public void mouseEntered(MouseEvent arg0) {
			}
			public void mouseExited(MouseEvent arg0) {
			}
			public void mousePressed(MouseEvent arg0) {
			}
			public void mouseReleased(MouseEvent arg0) {
			}
		});
		contentPane.add(Nota);
		
		//Se pone un separador en la interfaz
		JSeparator separator = new JSeparator();
		separator.setBounds(31, 200, 375, 2);
		contentPane.add(separator);
		
		
		//comboBox para ciudades
		campoCiudades = new JComboBox();
		campoCiudades.setForeground(new Color(0, 0, 0));
		campoCiudades.setBackground(new Color(204, 255, 255));
		campoCiudades.setBounds(186, 110, 161, 20);
		campoCiudades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				listaCiudadesActioner(evt);
			}
		});
		contentPane.add(campoCiudades);
		
		this.listaCiudades = controladorEvento.consultarCiudades();
		DefaultComboBoxModel model = new DefaultComboBoxModel( listaCiudades );
		campoCiudades.setModel( model );
		
		
		//comboBox para nombres de los eventos
		campoNombres = new JComboBox();
		campoNombres.setForeground(new Color(0, 0, 0));
		campoNombres.setBackground(new Color(204, 255, 255));
		campoNombres.setBounds(186, 53, 161, 20);
		campoNombres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				listaNombresActioner(evt);
			}
		});
		contentPane.add(campoNombres);
		
		
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
		
		btnGuardar.setToolTipText("Confirmar cancelacion de evento.");
		btnGuardar.setBackground(new Color(0, 0, 0));
		btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnGuardar.setMnemonic('G');
		btnGuardar.setForeground(new Color(255, 255, 255));
		
		btnGuardar.setBounds(123, 220, 80, 80);
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
		
		btnConsultar.setToolTipText("Consulte los datos sobre el evento que desea cancelar.");
		btnConsultar.setBackground(new Color(0, 0, 0));
		btnConsultar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnConsultar.setMnemonic('C');
		btnConsultar.setForeground(new Color(255, 255, 255));
		btnConsultar.setBounds(360, 108, 80, 80);
		contentPane.add(btnConsultar);
		
		//-----Boton cancelar-----
		JButton btnCancelar = new JButton();
		btnCancelar.setToolTipText("Descartar y salir.");
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
		btnCancelar.setBounds(239, 220, 80, 80);
		contentPane.add(btnCancelar);
		
	}
	//-------------------------------------------------------------------------------------------
	
	private void listaCiudadesActioner(ActionEvent e)
	{
		this.listaNombres = controladorEvento.consultarEventosEnCiudad((String) campoCiudades.getSelectedItem());
		DefaultComboBoxModel model = new DefaultComboBoxModel( this.listaNombres );
		campoNombres.setModel( model );
		limpiarCampos();
		JOptionPane.showMessageDialog(null, "Se han consultado los eventos que hay en la ciudad indicada.");
		
	}
	//-------------------------------------------------------------------------------------------
	
	private void listaNombresActioner(ActionEvent e){
		limpiarCampos();
	}
	//-------------------------------------------------------------------------------------------
	
	private void limpiarCampos(){//hace que todos los campos de la interfaz excepto los combobox queden vacios
		this.campoFecha.setText("");
		this.campoCosto.setText("");
		this.campoEstado.setText("");
	}
	//-------------------------------------------------------------------------------------------
	
	public void botonGuardarActionPerformed( ActionEvent evento){
		String nombre_evt, fecha_evt, ciudad_evt, costo_evt, estado_evt;
		
		nombre_evt = (String) campoNombres.getSelectedItem();
		fecha_evt = campoFecha.getText();
		ciudad_evt = (String) campoCiudades.getSelectedItem();
		costo_evt = campoCosto.getText();
		estado_evt = campoEstado.getText();
		
		if (costo_evt.equals("") || estado_evt.equals("") || fecha_evt.equals("")){
			JOptionPane.showMessageDialog(null, "Por favor llenar todos los campos");
		} else if ( estado_evt.equals("cancelado") ) {
			JOptionPane.showMessageDialog(null, "El evento que ha consultado ya se encuentra cancelado.", "Accion no valida.", JOptionPane.INFORMATION_MESSAGE);
		} else {
			controladorEvento.cancelarEvento(nombre_evt, fecha_evt);
			controladorEvento.cerrarConexionBD();
			System.out.println("Conexion cerrada...");
			dispose();
		}
	}
	//-------------------------------------------------------------------------------------------
	
	public void botonCancelarActionPerformed( ActionEvent evt){
		controladorEvento.cerrarConexionBD();
		System.out.println("Conexion cerrada...");
		dispose();
	}
	//-------------------------------------------------------------------------------------------
	
	public void botonConsultarActionPerformed( ActionEvent evento){
		String nombre_evento, ciudad_evento;
		String[] lista_eventos;
		nombre_evento = (String) campoNombres.getSelectedItem();
		ciudad_evento = (String) campoCiudades.getSelectedItem();
		
		Evento evt;
		
		evt = controladorEvento.consultarEvento(nombre_evento, ciudad_evento);
		if ( evt.getFecha() == null || evt.getFecha().equals("")) {
			JOptionPane.showMessageDialog(null, "El evento consultado no existe.", "No Encontrado", JOptionPane.INFORMATION_MESSAGE);
		} else {
			campoFecha.setText(evt.getFecha());
			campoCosto.setText(evt.getCosto());
			campoEstado.setText(evt.getEstado());
			JOptionPane.showMessageDialog(null, "Ya se ha capturado el evento requerido. Si esta seguro de cancelar el evento, haga click en el boton GUARDAR.", "Advertencia.", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	//-------------------------------------------------------------------------------------------

}
