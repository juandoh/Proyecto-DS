package gui;
/**
 *@author juan diego ordonnez
 */

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;

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
import java.awt.event.FocusListener;

import logica.Login;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import java.awt.Toolkit;
import java.awt.Frame;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.SystemColor;

public class LoginGUI {

	private JFrame frmAccesoAlSistema;
	private JTextField campoUsuario;
	private JPasswordField campoPassword;
	private JButton botonIngresar;
	private JButton botonCancelar;
	
	ControladorLogin controladorLogin;
	private JLabel lblNewLabel;

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
		frmAccesoAlSistema.setResizable(false);
		frmAccesoAlSistema.setIconImage(Toolkit.getDefaultToolkit().getImage(LoginGUI.class.getResource("/imagen/ruedas-dentadas-icono-plana.png")));
		frmAccesoAlSistema.getContentPane().setBackground(new Color(0, 153, 255));
		frmAccesoAlSistema.setForeground(new Color(30, 144, 255));
		frmAccesoAlSistema.setTitle("ACCESO AL SISTEMA");
		frmAccesoAlSistema.setBackground(new Color(30, 144, 255));
		frmAccesoAlSistema.setBounds(100, 100, 407, 283);
		frmAccesoAlSistema.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAccesoAlSistema.getContentPane().setLayout(null);
		
		//Campo texto del Usuario
		campoUsuario = new JTextField("");
		campoUsuario.setSelectionColor(new Color(124, 252, 0));
		campoUsuario.setCaretColor(new Color(255, 255, 0));
		campoUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		//PromptSupport.setPrompt();
		campoUsuario.setForeground(Color.WHITE);
		campoUsuario.setBackground(new Color(0, 0, 0));
		campoUsuario.setBounds(179, 108, 122, 20);
		frmAccesoAlSistema.getContentPane().add(campoUsuario);
		campoUsuario.setColumns(10);
		
		//Se establece la etiqueta Usuario
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUsuario.setBounds(86, 110, 59, 14);
		frmAccesoAlSistema.getContentPane().add(lblUsuario);
		
		//Se establece la etiqueta contrasenna
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblContrasea.setBounds(86, 140, 83, 14);
		frmAccesoAlSistema.getContentPane().add(lblContrasea);
		
		//Se establece el campo de texto Contrasenna
		campoPassword = new JPasswordField();
		campoPassword.setSelectionColor(new Color(124, 252, 0));
		campoPassword.setCaretColor(new Color(255, 255, 0));
		campoPassword.setDisabledTextColor(new Color(128, 128, 128));
		campoPassword.setForeground(Color.WHITE);
		campoPassword.setBackground(new Color(0, 0, 0));
		campoPassword.setBounds(179, 138, 122, 20);
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
		botonIngresar.setBounds(97, 190, 97, 33);
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
		botonCancelar.setBounds(204, 190, 97, 33);
		frmAccesoAlSistema.getContentPane().add(botonCancelar);
		
		lblNewLabel = new JLabel("New label");
		ImageIcon aux = new ImageIcon(getClass().getResource("/imagen/admin-button-icon-md.png"));
		//ImageIcon aux = new ImageIcon(getClass().getResource("/imagen/images.jpg"));
		ImageIcon temp = new ImageIcon(aux.getImage().getScaledInstance(100, -1, Image.SCALE_DEFAULT));
		lblNewLabel.setIcon(temp);
		lblNewLabel.setBounds(155, 5, 170, 134);
		lblNewLabel.setSize(new Dimension(100, 100));
		lblNewLabel.setPreferredSize(new Dimension(100, 100));
		frmAccesoAlSistema.getContentPane().add(lblNewLabel);
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
			JOptionPane.showMessageDialog(null, "Por favor llene los campos", "Campos_Vacios", JOptionPane.WARNING_MESSAGE);
		} else if ( l.equals(null) ){
			JOptionPane.showMessageDialog(null, "Usuario o Contraseña inconrrecta");
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
				JOptionPane.showMessageDialog(null, "Usuario o Contraseña inconrrecta", "Datos_Invalidos", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
}
