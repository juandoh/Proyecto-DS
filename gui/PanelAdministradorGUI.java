package gui;
/**
 * @author juan diego ordonnez
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelAdministradorGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelAdministradorGUI frame = new PanelAdministradorGUI();
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
	public PanelAdministradorGUI() {
		setTitle("Panel De  Usuario Administrador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 51, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenido Usuario Administrador");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(52, 22, 246, 21);
		contentPane.add(lblNewLabel);
		
		JButton btnCrearUsuario = new JButton("Crear usuario");
		btnCrearUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				botonCrearUsuarioActionPerformed(evt);
			}
		});
		btnCrearUsuario.setForeground(new Color(255, 255, 255));
		btnCrearUsuario.setBackground(new Color(0, 0, 0));
		btnCrearUsuario.setBounds(87, 76, 144, 23);
		contentPane.add(btnCrearUsuario);
		
		JButton btnModificarUsuario = new JButton("Modificar usuario");
		btnModificarUsuario.setBackground(new Color(0, 0, 0));
		btnModificarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				botonModificarUsuarioActionPerformed(evt);
			}
		});
		btnModificarUsuario.setForeground(new Color(255, 255, 255));
		btnModificarUsuario.setBounds(87, 121, 144, 23);
		contentPane.add(btnModificarUsuario);
		
		JButton btnVerUsuario = new JButton("Ver usuarios");
		btnVerUsuario.setForeground(new Color(255, 255, 255));
		btnVerUsuario.setBackground(new Color(0, 0, 0));
		btnVerUsuario.setBounds(87, 165, 144, 23);
		contentPane.add(btnVerUsuario);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setForeground(new Color(255, 255, 255));
		btnSalir.setBackground(new Color(0, 0, 0));
		btnSalir.setBounds(115, 217, 96, 23);
		contentPane.add(btnSalir);
	}
	
	//Metodo que se encarga del evento del boton Cancelar
	private void botonCrearUsuarioActionPerformed( ActionEvent evt ){
		CrearUsuarioGUI aplicacion1 = new CrearUsuarioGUI();
		aplicacion1.setVisible(true);
		aplicacion1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	//Metodo que se encarga del evento del boton Cancelar
	private void botonModificarUsuarioActionPerformed( ActionEvent evt ){
		ModificarUsuarioGUI aplicacion1 = new ModificarUsuarioGUI();
		aplicacion1.setVisible(true);
		aplicacion1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
