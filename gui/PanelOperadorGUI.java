package gui;
/**
 * @author juan diego
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class PanelOperadorGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelOperadorGUI frame = new PanelOperadorGUI();
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
	public PanelOperadorGUI() {
		setResizable(false);
		setTitle("Panel De Usuario Operador");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 417, 300);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBackground(new Color(0, 102, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titulo = new JLabel("Bienvenido Operador");
		titulo.setFont(new Font("Tahoma", Font.BOLD, 17));
		titulo.setBounds(37, 11, 197, 21);
		contentPane.add(titulo);
		
		//Se establece Boton Preinscripcion
		JButton btnPreInscripcion = new JButton("Preinscripci\u00F3n");
		btnPreInscripcion.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnPreInscripcion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				botonPreInscripcionActionPerformed(evt);
			}
		});
		btnPreInscripcion.setBackground(Color.BLACK);
		btnPreInscripcion.setForeground(new Color(255, 255, 255));
		btnPreInscripcion.setBounds(62, 43, 149, 23);
		contentPane.add(btnPreInscripcion);
		
		//Se establece Boton Inscripcion
		JButton btnInscripcion = new JButton("Inscripci\u00F3n");
		btnInscripcion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				botonInscripcionActionPerformed(evt);
			}
		});
		btnInscripcion.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnInscripcion.setBackground(Color.BLACK);
		btnInscripcion.setForeground(new Color(255, 255, 255));
		btnInscripcion.setBounds(62, 70, 149, 23);
		contentPane.add(btnInscripcion);
		
		//Se establece Boton Registrar Pagos
		JButton btnRegistrarPago = new JButton("Registrar Pagos");
		btnRegistrarPago.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				botonRegistrarPagoActionPerformed(evt);
			}
		});
		btnRegistrarPago.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRegistrarPago.setBackground(Color.BLACK);
		btnRegistrarPago.setForeground(new Color(255, 255, 255));
		btnRegistrarPago.setBounds(62, 99, 149, 23);
		contentPane.add(btnRegistrarPago);
		
		//Se establece Boton Generar Esacarapelas
		JButton btnGenerarEscarapelas = new JButton("Generar Escarapelas");
		btnGenerarEscarapelas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				botonGenerarEscarapelaActionPerformed(evt);
			}
		});
		btnGenerarEscarapelas.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGenerarEscarapelas.setBackground(Color.BLACK);
		btnGenerarEscarapelas.setForeground(new Color(255, 255, 255));
		btnGenerarEscarapelas.setBounds(62, 127, 149, 23);
		contentPane.add(btnGenerarEscarapelas);
		
		//Se establece Boton Diplomas
		JButton btnGenerarDiploma = new JButton("Generar Diplomas");
		btnGenerarDiploma.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnGenerarDiploma.setBackground(Color.BLACK);
		btnGenerarDiploma.setForeground(new Color(255, 255, 255));
		btnGenerarDiploma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
			}
		});
		btnGenerarDiploma.setBounds(62, 156, 149, 23);
		contentPane.add(btnGenerarDiploma);
		
		//Se establece Boton Ver Reportes
		JButton btnReporte = new JButton("Ver Reportes");
		btnReporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
			}
		});
		
		btnReporte.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnReporte.setBackground(Color.BLACK);
		btnReporte.setForeground(new Color(255, 255, 255));
		btnReporte.setBounds(62, 186, 149, 23);
		contentPane.add(btnReporte);
		
		//Se establece Boton Salir
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				botonSalirActionPerformed(evt);
			}
		});
		btnSalir.setBackground(Color.DARK_GRAY);
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSalir.setForeground(new Color(255, 255, 255));
		btnSalir.setBounds(101, 220, 70, 23);
		contentPane.add(btnSalir);
		
		JLabel lblNewLabel = new JLabel("New label");
		//lblNewLabel.setIcon(new ImageIcon(PanelOperadorGUI.class.getResource("/imagen/icono-de-perfil-m-dico.png")));
		ImageIcon aux = new ImageIcon(getClass().getResource("/imagen/icono-de-perfil-m-dico.png"));
		ImageIcon temp = new ImageIcon(aux.getImage().getScaledInstance(140, -1, Image.SCALE_DEFAULT));
		lblNewLabel.setIcon(temp);
		lblNewLabel.setSize(new Dimension(140, 140));
		lblNewLabel.setPreferredSize(new Dimension(140, 140));
		lblNewLabel.setBounds(237, 57, 140, 140);
		contentPane.add(lblNewLabel);
	}
	
	//Metodo para conseguir el JFrame de la Ventana Principal
	private JFrame getFrame(){
		return this;
	}
	
	//Metodo que se encarga del evento del boton Inscripcion
	private void botonPreInscripcionActionPerformed( ActionEvent evt ){
		PreInscripcionGUI aplicacion1 = new PreInscripcionGUI(){
			public void dispose(){
				getFrame().setVisible(true);
				super.dispose();
			}
		};
		aplicacion1.setVisible(true);
		aplicacion1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		dispose();
	}
	
	//Metodo que se encarga del evento del boton Preinscripcion
	private void botonInscripcionActionPerformed( ActionEvent evt ){
		InscripcionGUI aplicacion1 = new InscripcionGUI(){
			public void dispose(){
				getFrame().setVisible(true);
				super.dispose();
			}
		};
		aplicacion1.setVisible(true);
		aplicacion1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		dispose();
	}
	
	//Metodo que se encarga del evento del boton Generar Escarapela
	private void botonGenerarEscarapelaActionPerformed( ActionEvent evt){
		GenerarEscarapelaGUI aplicacion1 = new GenerarEscarapelaGUI(){
			public void dispose(){
				getFrame().setVisible(true);
				super.dispose();
			}
		};
		aplicacion1.setVisible(true);
		aplicacion1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		dispose();
	}
	
	//Metodo que se encarga del evento del boton Registrar Pago
	private void botonRegistrarPagoActionPerformed( ActionEvent evt ){
		RegistrarPagoGUI aplicacion1 = new RegistrarPagoGUI(){
			public void dispose(){
				getFrame().setVisible(true);
				super.dispose();
			}
		};
		aplicacion1.setVisible(true);
		aplicacion1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		dispose();
	}
	
	
	//Metodo que se encarga del evento del boton Salir
	private void botonSalirActionPerformed( ActionEvent evt ){
		System.out.println("Conexion cerrada...");
		dispose();
		
	}
}
