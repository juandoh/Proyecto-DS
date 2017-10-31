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
		frmAccesoAlSistema.setBounds(100, 100, 450, 300);
		frmAccesoAlSistema.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAccesoAlSistema.getContentPane().setLayout(null);
		
		//Campo texto del Usuario
		campoUsuario = new JTextField();
		campoUsuario.setForeground(new Color(0, 0, 0));
		campoUsuario.setBackground(new Color(204, 255, 255));
		campoUsuario.setBounds(193, 89, 122, 20);
		frmAccesoAlSistema.getContentPane().add(campoUsuario);
		campoUsuario.setColumns(10);
		
		//Se establece la etiqueta Usuario
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(101, 92, 59, 14);
		frmAccesoAlSistema.getContentPane().add(lblUsuario);
		
		//Se establece la etiqueta contrasenna
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(101, 123, 72, 14);
		frmAccesoAlSistema.getContentPane().add(lblContrasea);
		
		//Se establece el campo de texto Contrasenna
		campoPassword = new JPasswordField();
		campoPassword.setBackground(new Color(204, 255, 255));
		campoPassword.setBounds(193, 120, 122, 20);
		frmAccesoAlSistema.getContentPane().add(campoPassword);
		
		//Se establece el boton Ingresar
		botonIngresar = new JButton("Ingresar");
		botonIngresar.setForeground(new Color(255, 255, 255));
		botonIngresar.setMnemonic('I');
		botonIngresar.setToolTipText("");
		botonIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				botonIngresarActionPerformed(evt);
			}
		});
		botonIngresar.setBackground(new Color(0, 0, 0));
		botonIngresar.setBounds(111, 176, 97, 33);
		frmAccesoAlSistema.getContentPane().add(botonIngresar);
		
		//Se establece el boton Cancelar
		botonCancelar = new JButton("Cancelar");
		botonCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				botonCancelarActionPerformed(evt);
			}
		});
		botonCancelar.setMnemonic('C');
		botonCancelar.setForeground(new Color(255, 255, 255));
		botonCancelar.setBackground(new Color(0, 0, 0));
		botonCancelar.setBounds(218, 176, 97, 33);
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
			JOptionPane.showMessageDialog(null, "Usuario o Contraseña inconrrecta");
		} else {//Codigo para abrir la aplicacion dependiendo del perfil del usuario
			tipo = l.getTipo();
			if ( tipo.equals("administrador") ){
				
			} else if ( tipo.equals("gerente") ){
				
			} else if (tipo.equals("operador")){
				
			}
		}
		
	}

}
