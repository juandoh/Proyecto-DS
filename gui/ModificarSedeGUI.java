package gui;
/**
 * @author juan diego ordonnez
 */

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class ModificarSedeGUI extends JFrame {

	private JPanel contentPane;
	private JTextField campoNombre;
	private JTextField CampoDireccion;
	private JTextField campoNumero;
	private JTextField CampoCuidad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarSedeGUI frame = new ModificarSedeGUI();
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
	public ModificarSedeGUI() {
		setResizable(false);
		setTitle("Modificar Sede");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIngreseLosNuevos = new JLabel("Ingrese Los Nuevos Datos De La Sede");
		lblIngreseLosNuevos.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblIngreseLosNuevos.setBounds(10, 10, 342, 30);
		contentPane.add(lblIngreseLosNuevos);
		
		JLabel lblNombreSede = new JLabel("Nombre Sede:");
		lblNombreSede.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNombreSede.setBounds(42, 62, 116, 30);
		contentPane.add(lblNombreSede);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n:");
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDireccion.setBounds(42, 100, 116, 30);
		contentPane.add(lblDireccion);
		
		JLabel lblNumeroDeSede = new JLabel("N\u00FAmero de Sede:");
		lblNumeroDeSede.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNumeroDeSede.setBounds(42, 138, 116, 30);
		contentPane.add(lblNumeroDeSede);
		
		JLabel lblCiudad = new JLabel("Ciudad:");
		lblCiudad.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCiudad.setBounds(42, 176, 116, 30);
		contentPane.add(lblCiudad);
		
		campoNombre = new JTextField();
		campoNombre.setBounds(168, 68, 100, 20);
		contentPane.add(campoNombre);
		campoNombre.setColumns(10);
		
		CampoDireccion = new JTextField();
		CampoDireccion.setBounds(168, 106, 100, 20);
		contentPane.add(CampoDireccion);
		CampoDireccion.setColumns(10);
		
		campoNumero = new JTextField();
		campoNumero.setBounds(168, 144, 100, 20);
		contentPane.add(campoNumero);
		campoNumero.setColumns(10);
		
		CampoCuidad = new JTextField();
		CampoCuidad.setBounds(168, 182, 100, 20);
		contentPane.add(CampoCuidad);
		CampoCuidad.setColumns(10);
		
		JLabel Imagen = new JLabel();
		ImageIcon aux = new ImageIcon(getClass().getResource("/imagen/notas-de-la-tabla-de-registro-m-dico-.png"));
		ImageIcon temp = new ImageIcon(aux.getImage().getScaledInstance(130, -1, Image.SCALE_DEFAULT));
		Imagen.setIcon(temp);
		Imagen.setSize(new Dimension(130, 130));
		Imagen.setPreferredSize(new Dimension(130, 130));
		Imagen.setBounds(292, 70, 130, 130);
		contentPane.add(Imagen);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				botonActualizarActionPerformed(evt);
			}
		});
		btnActualizar.setBounds(61, 227, 116, 23);
		contentPane.add(btnActualizar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				botonCancelarActionPerformed(evt);
			}
		});
		btnCancelar.setBounds(259, 227, 104, 23);
		contentPane.add(btnCancelar);
	}
	
	//Metodo que se encarga del evento del boton Cancelar
	private void botonCancelarActionPerformed( ActionEvent evt ){
		dispose();
	}
	
	//Metodo que se encarga del evento del boton Actualizar
	private void botonActualizarActionPerformed( ActionEvent evt ){
		
	}
}
