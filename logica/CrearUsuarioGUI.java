package gui;

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

import controlador.ControladorUsuario;
import java.awt.Dimension;
import java.awt.Font;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

import logica.Login;
import logica.Usuario;

/**
 * 
 * @author David Mera
 *
 */

public class CrearUsuarioGUI {
	private JFrame frmAccesoAlSistema;
	private JTextField campoUsuario, campoNombres,campoApellidos,campoCedula,campoTelefono,campoEmail;
    private JComboBox tipoUsuario,tipoEstado;
	private JPasswordField campoPassword;
	private JButton botonActualizar;
	private JButton botonCancelar;
	        String[] opcionesTipoU = {"Gerente", "Operador"};
                  String[] opcionesEstado = {"Activo", "Inactivo"};
                  
    
    //Se inicia el objeto ControladorModificarUsuario
    ControladorUsuario controladorUsuario;
	private Login usuarioLogeado;
    
    
	//Iniciar la aplicación
	 public static void main(String[] args) {
	  EventQueue.invokeLater(new Runnable() {
	  	public void run() {
	  		try {
	  			CrearUsuarioGUI window = new CrearUsuarioGUI();
	  		window.frmAccesoAlSistema.setVisible(true);
	  		} catch (Exception e) {
	  			e.printStackTrace();
	  		}
	  	}
	  });
	 }

	 public CrearUsuarioGUI() {
			// TODO Auto-generated constructor stub
			initialize();
			controladorUsuario = new ControladorUsuario();
		}
	 
	 private void initialize() {
			frmAccesoAlSistema = new JFrame();
	        frmAccesoAlSistema.setBounds(100, 100, 450, 480);
			frmAccesoAlSistema.getContentPane().setBackground(new Color(0, 153, 255));
			frmAccesoAlSistema.setForeground(new Color(30, 144, 255));
			frmAccesoAlSistema.setTitle("Crear Usuario");
			frmAccesoAlSistema.setBackground(new Color(30, 144, 255));
			
			frmAccesoAlSistema.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frmAccesoAlSistema.getContentPane().setLayout(null);
		
	                
	        JLabel Modifique = new JLabel("Crear un usuario:");
			Modifique.setBounds(101, 30, 300, 50);
	        Modifique.setFont(new Font("Serif", Font.BOLD, 17));
	                    
	                
			frmAccesoAlSistema.getContentPane().add(Modifique);
	               
	                
			//Campo texto del Usuario
			campoUsuario = new JTextField();
			campoUsuario.setForeground(new Color(0, 0, 0));
			campoUsuario.setBackground(new Color(204, 255, 255));
			campoUsuario.setBounds(193, 89, 122, 20);
			frmAccesoAlSistema.getContentPane().add(campoUsuario);
			campoUsuario.setColumns(10);
			
	        //Se establece la etiqueta Usuario
			JLabel lblUsuario = new JLabel("Usuario:");
			lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblUsuario.setBounds(101, 92, 59, 14);
			frmAccesoAlSistema.getContentPane().add(lblUsuario);
	                
			//Se establece la etiqueta contrasenna
			JLabel lblContrasea = new JLabel("Contraseña:");
			lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblContrasea.setBounds(101, 123, 82, 14);
			frmAccesoAlSistema.getContentPane().add(lblContrasea);
			
			//Se establece el campo de texto Contrasenna
			campoPassword = new JPasswordField();
			campoPassword.setBackground(new Color(204, 255, 255));
			campoPassword.setBounds(193, 120, 122, 20);
			frmAccesoAlSistema.getContentPane().add(campoPassword);
			
	                
	                 
	        //Se establece la etiqueta nombres
			JLabel lblnombres = new JLabel("Nombres:");
			lblnombres.setBounds(101, 152, 72, 14);
			lblnombres.setFont(new Font("Tahoma", Font.BOLD, 12));
			frmAccesoAlSistema.getContentPane().add(lblnombres);
			
	        //Campo texto de nombres
			campoNombres = new JTextField();
			campoNombres.setForeground(new Color(0, 0, 0));
			campoNombres.setBackground(new Color(204, 255, 255));
			campoNombres.setBounds(193, 150, 122, 20);
			frmAccesoAlSistema.getContentPane().add(campoNombres);
			campoUsuario.setColumns(10);
			
	                
	        //Se establece la etiqueta apellidos
			JLabel lblApellidos = new JLabel("Apellidos:");
			lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblApellidos.setBounds(101, 182, 72, 14);
			frmAccesoAlSistema.getContentPane().add(lblApellidos);
			
	        //Campo texto de nombres
			campoApellidos = new JTextField();
			campoApellidos.setForeground(new Color(0, 0, 0));
			campoApellidos.setBackground(new Color(204, 255, 255));
			campoApellidos.setBounds(193, 180, 122, 20);
			frmAccesoAlSistema.getContentPane().add(campoApellidos);
			campoApellidos.setColumns(10);
			

			//OpcionesTipoU
	        //Se establece el tipo de Usuario 
			JLabel lblTipo = new JLabel("Tipo:");
			lblTipo.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblTipo.setBounds(101, 213, 72, 14);
			frmAccesoAlSistema.getContentPane().add(lblTipo);

			//comboBox tipo de usuario 
			tipoUsuario = new JComboBox(opcionesTipoU);
			tipoUsuario.setForeground(new Color(0, 0, 0));
			tipoUsuario.setBackground(new Color(204, 255, 255));
			tipoUsuario.setBounds(193, 210, 122, 20);
			frmAccesoAlSistema.getContentPane().add(tipoUsuario);
	                
	        //Se establece el estado  de Usuario 
			JLabel lblEstado = new JLabel("Estado:");
			lblEstado.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblEstado.setBounds(101, 239, 72, 14);
			frmAccesoAlSistema.getContentPane().add(lblEstado);
	        
			//comboBox estado de usuario 
			tipoEstado = new JComboBox(opcionesEstado);
			tipoEstado.setForeground(new Color(0, 0, 0));
			tipoEstado.setBackground(new Color(204, 255, 255));
			tipoEstado.setBounds(193, 237, 122, 20);
			frmAccesoAlSistema.getContentPane().add(tipoEstado);
	                
	        //Se establece la etiqueta  cedula
			JLabel lblCedula = new JLabel("Cedula :");
			lblCedula.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblCedula.setBounds(101, 267, 72, 14);
			frmAccesoAlSistema.getContentPane().add(lblCedula);

			//Campo texto de cedula
			campoCedula = new JTextField();
			campoCedula.setForeground(new Color(0, 0, 0));
			campoCedula.setBackground(new Color(204, 255, 255));
			campoCedula.setBounds(193, 265, 122, 20);
			frmAccesoAlSistema.getContentPane().add(campoCedula);
			campoCedula.setColumns(10);
			        
	        //Se establece la etiqueta  Email
			JLabel lblEmail = new JLabel("Email :");
			lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblEmail.setBounds(101, 295, 72, 14);
			frmAccesoAlSistema.getContentPane().add(lblEmail);
	        
			//Campo texto de email
			campoEmail = new JTextField();
			campoEmail.setForeground(new Color(0, 0, 0));
			campoEmail.setBackground(new Color(204, 255, 255));
			campoEmail.setBounds(193, 293, 122, 20);
			frmAccesoAlSistema.getContentPane().add(campoEmail);
			campoEmail.setColumns(10);
			
			//Se establece la etiqueta  telefono
			JLabel lblTelefono = new JLabel("Telefono :");
			lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblTelefono.setBounds(101, 327, 72, 14);
			frmAccesoAlSistema.getContentPane().add(lblTelefono);
			
			//Campo texto de telefono
			campoTelefono = new JTextField();
			campoTelefono.setForeground(new Color(0, 0, 0));
			campoTelefono.setBackground(new Color(204, 255, 255));
			campoTelefono.setBounds(193, 325, 122, 20);
			frmAccesoAlSistema.getContentPane().add(campoTelefono);
			campoTelefono.setColumns(10);
			       
			//Se establece el boton Ingresar
			botonActualizar = new JButton("Crear");
			botonActualizar.setFont(new Font("Tahoma", Font.BOLD, 12));
			botonActualizar.setForeground(new Color(255, 255, 255));
			botonActualizar.setMnemonic('A');
			botonActualizar.setToolTipText("");
			botonActualizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					botonCrearActionPerformed(evt);
				}
			});
			
			botonActualizar.setBackground(new Color(0, 0, 0));
			botonActualizar.setBounds(111, 355, 97, 33);
			frmAccesoAlSistema.getContentPane().add(botonActualizar);
			
			//Se establece el boton Cancelar
			botonCancelar = new JButton("Cancelar");
			botonCancelar.setFont(new Font("Tahoma", Font.BOLD, 12));
			botonCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					botonCancelarActionPerformed(evt);
				}
			});
			
			botonCancelar.setMnemonic('C');
			botonCancelar.setForeground(new Color(255, 255, 255));
			botonCancelar.setBackground(new Color(0, 0, 0));
			botonCancelar.setBounds(218, 355, 97, 33);
			frmAccesoAlSistema.getContentPane().add(botonCancelar);
	                
	             
		}
		
		//Metodo que se encarga del evento del boton Cancelar
		private void botonCancelarActionPerformed( ActionEvent evt ){
			controladorUsuario.cerrarConexionBD();
			System.out.println("Conexion cerrada...");
			System.exit(0);
		}
		
		//Metodo que se encarga del evento del boton Ingresar
		private void botonCrearActionPerformed (ActionEvent evt ){
			String nick, contra, nombre, apellido, tipo, estado, cedula, email, telefono;
			
			nick = campoUsuario.getText();
			contra = String.valueOf(campoPassword.getPassword());
			nombre = campoNombres.getText();
			apellido = campoApellidos.getText();
			cedula = campoCedula.getText();
			email = campoEmail.getText();
			tipo = (String) tipoUsuario.getSelectedItem();
			estado = (String) tipoEstado.getSelectedItem();
			telefono = campoTelefono.getText();
			
			
			if ( campoUsuario.getText().equals("") || (String.valueOf(campoPassword.getPassword())).equals("") ||
					campoNombres.getText().equals("") || campoApellidos.getText().equals("") || 
					campoCedula.getText().equals("") || campoEmail.getText().equals("") || 
					campoTelefono.getText().equals("")){
				JOptionPane.showMessageDialog(null, "Por favor llenar todos los campos");
			} else {
				controladorUsuario.insertarUsuario(nombre, apellido, cedula, nick, contra, telefono, tipo, estado, email);
				JOptionPane.showMessageDialog(null, "Usuario registrado como " + tipo);
				
			}
			
		}
}
