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
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

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
		setResizable(false);
		setTitle("Panel De  Usuario Administrador");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		btnCrearUsuario.setMnemonic('C');
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
		btnModificarUsuario.setMnemonic('M');
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
		btnVerUsuario.setMnemonic('V');
		btnVerUsuario.setForeground(new Color(255, 255, 255));
		btnVerUsuario.setBackground(new Color(0, 0, 0));
		btnVerUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				botonVerUsuarioActionPerformed(evt);
			}
		});
		btnVerUsuario.setBounds(87, 165, 144, 23);
		contentPane.add(btnVerUsuario);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				dispose();
			}
		});
		btnSalir.setMnemonic('S');
		btnSalir.setForeground(new Color(255, 255, 255));
		btnSalir.setBackground(new Color(0, 0, 0));
		btnSalir.setBounds(115, 217, 96, 23);
		contentPane.add(btnSalir);
		
		JLabel lblNewLabel_1 = new JLabel("");
		ImageIcon aux = new ImageIcon(getClass().getResource("/imagen/41f9B0mX7fL.png"));
		ImageIcon temp = new ImageIcon(aux.getImage().getScaledInstance(140, -1, Image.SCALE_DEFAULT));
		lblNewLabel_1.setIcon(temp);
		lblNewLabel_1.setSize(new Dimension(140, 150));
		lblNewLabel_1.setPreferredSize(new Dimension(140, 140));
		lblNewLabel_1.setBounds(261, 65, 140, 140);
		contentPane.add(lblNewLabel_1);
	}
	
	//Metodo para conseguir el JFrame de la Ventana Principal
	private JFrame getFrame(){
		return this;
	}
	
	//Metodo que se encarga del evento del boton Cancelar
	private void botonCrearUsuarioActionPerformed( ActionEvent evt ){
		CrearUsuarioGUI aplicacion1 = new CrearUsuarioGUI(){
			public void dispose(){
				getFrame().setVisible(true);
				super.dispose();
			}
		};
		
		aplicacion1.setVisible(true);
		dispose();
	}
	
	//Metodo que se encarga del evento del boton Cancelar
	private void botonModificarUsuarioActionPerformed( ActionEvent evt ){
		ModificarUsuarioGUI aplicacion1 = new ModificarUsuarioGUI(){
			public void dispose(){
				getFrame().setVisible(true);
				super.dispose();
			}
		};
		aplicacion1.setVisible(true);
		dispose();
	}
	
	//Metodo que se encarga del evento del boton VerUsuario
	private void botonVerUsuarioActionPerformed(ActionEvent evt){
		ListarUsuarioGUI aplicacion1 = new ListarUsuarioGUI(){
			public void dispose(){
				getFrame().setVisible(true);
				super.dispose();
			}
		};
		aplicacion1.setVisible(true);
		dispose();
	}
}
