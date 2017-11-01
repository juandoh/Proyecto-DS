package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
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
		setTitle("Panel De Usuario Operador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 417, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titulo = new JLabel("Bienvenido Operador");
		titulo.setFont(new Font("Swis721 Lt BT", Font.BOLD, 14));
		titulo.setBounds(51, 11, 177, 21);
		contentPane.add(titulo);
		
		JButton btnPreInscripcion = new JButton("Preinscripci\u00F3n");
		btnPreInscripcion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				botonPreInscripcionActionPerformed(evt);
			}
		});
		btnPreInscripcion.setBackground(Color.BLACK);
		btnPreInscripcion.setForeground(Color.WHITE);
		btnPreInscripcion.setBounds(75, 43, 131, 23);
		contentPane.add(btnPreInscripcion);
		
		JButton btnInscripcion = new JButton("Inscripci\u00F3n");
		btnInscripcion.setBackground(Color.BLACK);
		btnInscripcion.setForeground(Color.WHITE);
		btnInscripcion.setBounds(75, 70, 131, 23);
		contentPane.add(btnInscripcion);
		
		JButton btnRegistrarPago = new JButton("Registrar Pagos");
		btnRegistrarPago.setBackground(Color.BLACK);
		btnRegistrarPago.setForeground(Color.WHITE);
		btnRegistrarPago.setBounds(75, 99, 131, 23);
		contentPane.add(btnRegistrarPago);
		
		JButton btnGenerarEscarapelas = new JButton("Generar Escarapelas");
		btnGenerarEscarapelas.setBackground(Color.BLACK);
		btnGenerarEscarapelas.setForeground(Color.WHITE);
		btnGenerarEscarapelas.setBounds(75, 127, 131, 23);
		contentPane.add(btnGenerarEscarapelas);
		
		JButton btnGenerarDiploma = new JButton("Generar Diplomas");
		btnGenerarDiploma.setBackground(Color.BLACK);
		btnGenerarDiploma.setForeground(Color.WHITE);
		btnGenerarDiploma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evy) {
				
			}
		});
		btnGenerarDiploma.setBounds(75, 156, 131, 23);
		contentPane.add(btnGenerarDiploma);
		
		JButton btnReporte = new JButton("Ver reportes");
		btnReporte.setBackground(Color.BLACK);
		btnReporte.setForeground(Color.WHITE);
		btnReporte.setBounds(75, 186, 131, 23);
		contentPane.add(btnReporte);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				botonSalirActionPerformed(evt);
			}
		});
		btnSalir.setBackground(Color.DARK_GRAY);
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setBounds(104, 220, 70, 23);
		contentPane.add(btnSalir);
	}
	
	//Metodo que se encarga del evento del boton Preinscripcion
	private void botonPreInscripcionActionPerformed( ActionEvent evt ){
		PreInscripcionGUI aplicacion1 = new PreInscripcionGUI();
		aplicacion1.setVisible(true);
		aplicacion1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	//Metodo que se encarga del evento del boton Salir
	private void botonSalirActionPerformed( ActionEvent evt ){
		//controladorOperador.cerrarConexionBD();
		System.out.println("Conexion cerrada...");
		System.exit(0);
		
	}
}
