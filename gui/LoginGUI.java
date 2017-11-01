package gui;
/**
 *@author juan diego ordonnez
 */

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Window.Type;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import controlador.ControladorLogin;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import logica.Login;
import java.awt.Font;

public class LoginGUI {

	private JFrame frmAccesoAlSistema;
	private JTextField campoUsuario;
	private JPasswordField campoPassword;
	private JButton botonIngresar;
	private JButton botonCancelar;
	
	ControladorLogin controladorLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI window = new LoginGUI();
					window.frmAccesoAlSistema.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * Contructor
	 */
	public LoginGUI() {
		initialize();
		controladorLogin = new ControladorLogin();
	}

	/**
	 * Inicializa los componentes de la aplicacion.
	 */
	private void initialize() {
		frmAccesoAlSistema = new JFrame();
		frmAccesoAlSistema.getContentPane().setBackground(new Color(0, 153, 255));
		frmAccesoAlSistema.setForeground(new Color(30, 144, 255));
		frmAccesoAlSistema.setTitle("ACCESO AL SISTEMA");
		frmAccesoAlSistema.setBackground(new Color(30, 144, 255));
		frmAccesoAlSistema.setBounds(100, 100, 407, 283);
		frmAccesoAlSistema.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAccesoAlSistema.getContentPane().setLayout(null);
		
		//Campo texto del Usuario
		campoUsuario = new JTextField();
		campoUsuario.setForeground(new Color(0, 0, 0));
		campoUsuario.setBackground(new Color(204, 255, 255));
		campoUsuario.setBounds(180, 90, 122, 20);
		frmAccesoAlSistema.getContentPane().add(campoUsuario);
		campoUsuario.setColumns(10);
		
		//Se establece la etiqueta Usuario
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUsuario.setBounds(87, 92, 59, 14);
		frmAccesoAlSistema.getContentPane().add(lblUsuario);
		
		//Se establece la etiqueta contrasenna
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblContrasea.setBounds(87, 122, 83, 14);
		frmAccesoAlSistema.getContentPane().add(lblContrasea);
		
		//Se establece el campo de texto Contrasenna
		campoPassword = new JPasswordField();
		campoPassword.setBackground(new Color(204, 255, 255));
		campoPassword.setBounds(180, 120, 122, 20);
		frmAccesoAlSistema.getContentPane().add(campoPassword);
		
		//Se establece el boton Ingresar
		botonIngresar = new JButton("Ingresar");
		botonIngresar.setFont(new Font("Tahoma", Font.BOLD, 11));
		botonIngresar.setForeground(new Color(255, 255, 255));
		botonIngresar.setMnemonic('I');
		botonIngresar.setToolTipText("");
		botonIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				botonIngresarActionPerformed(evt);
			}
		});
		botonIngresar.setBackground(new Color(0, 0, 0));
		botonIngresar.setBounds(98, 176, 97, 33);
		frmAccesoAlSistema.getContentPane().add(botonIngresar);
		
		//Se establece el boton Cancelar
		botonCancelar = new JButton("Cancelar");
		botonCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		botonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				botonCancelarActionPerformed(evt);
			}
		});
		botonCancelar.setMnemonic('C');
		botonCancelar.setForeground(new Color(255, 255, 255));
		botonCancelar.setBackground(new Color(0, 0, 0));
		botonCancelar.setBounds(205, 176, 97, 33);
		frmAccesoAlSistema.getContentPane().add(botonCancelar);
	}
	
	//Metodo que se encarga del evento del boton Cancelar
	private void botonCancelarActionPerformed( ActionEvent evt ){
		controladorLogin.cerrarConexionBD();
		System.out.println("Conexion cerrada...");
		System.exit(0);
	}
	
	//Metodo que se encarga del evento del boton Ingresar
	private void botonIngresarActionPerformed (ActionEvent evt ){
		String nick, contra, tipo;
		
		nick = campoUsuario.getText();
		contra = String.valueOf(campoPassword.getPassword());
		
		Login l;
		
		l = controladorLogin.consultarLogin(nick, contra);
		if ( campoUsuario.getText().equals("") || (String.valueOf(campoPassword.getPassword())).equals("") ){
			JOptionPane.showMessageDialog(null, "Por favor llene los campos");
		} else if ( l.equals(null) ){
			JOptionPane.showMessageDialog(null, "Usuario o Contraseņa inconrrecta");
		} else {//Codigo para abrir la aplicacion dependiendo del perfil del usuario
			tipo = l.getTipo();
			
			if ( (tipo!=null) && tipo.equals("administrador") ){
				PanelAdministradorGUI aplicacion1 = new PanelAdministradorGUI();
				aplicacion1.setVisible(true);
				aplicacion1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			} else if ( (tipo!=null) && tipo.equals("gerente") ){
				//CreaUsuarioGUI aplicacion1 = new CreaUsuarioGUI;
				//aplicacion1.setVisible(true);
				//aplicacion1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			} else if ((tipo!=null) && tipo.equals("operador")){
				PanelOperadorGUI aplicacion1 = new PanelOperadorGUI();
				aplicacion1.setVisible(true);
				aplicacion1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			} else if ( (tipo==null) ){
				JOptionPane.showMessageDialog(null, "Usuario o Contraseņa inconrrecta");
			}
		}
		
	}

}
