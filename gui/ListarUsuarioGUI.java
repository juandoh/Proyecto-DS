package gui;

/**
 * @author Fabian Ovalle
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import controlador.ControladorUsuario;

import java.awt.Font;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

import logica.Login;
import logica.Usuario;
import java.awt.Cursor;
import java.awt.ComponentOrientation;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;

public class ListarUsuarioGUI extends JFrame {

	private JPanel contentPane;
	private JTextField campoUsuario, campoNombres,campoApellidos,campoCedula,campoTelefono,campoEmail;
    private JComboBox tipoUsuario,tipoEstado;
	private JButton botonActualizar;
	private JButton botonCancelar;
	        String[] opcionesTipoU = {"GERENTE", "OPERADOR"};
                  String[] opcionesEstado = {"ACTIVO", "INACTIVO"};
               
    //Se inicia el objeto ControladorModificarUsuario
    ControladorUsuario controladorUsuario;
    private Login usuarioLogeado;
    private JPasswordField campoConfirmacion;
    private JLabel lblConfirmacion;
    private JPasswordField campoPassword;
    private JSeparator separator;
    private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarUsuarioGUI frame = new ListarUsuarioGUI();
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
	public ListarUsuarioGUI() {
		setResizable(false);
		
		controladorUsuario = new ControladorUsuario();
		
		setTitle("Listar Usuario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 488, 480);
		setBackground(new Color(0, 153, 255));
		setForeground(new Color(30, 144, 255));
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		JLabel Modifique = new JLabel("Lista de usuarios:");
		Modifique.setBounds(15, 11, 300, 50);
        Modifique.setFont(new Font("Tahoma", Font.BOLD, 18));
        
        contentPane.add(Modifique);
        
        //Se establece la etiqueta Titulos
        String resultadoEt = controladorUsuario.ListarUsuario();
        JLabel titulos = new JLabel("Nick              Tipo              Estado           Correo");
                      
      	titulos.setFont(new Font("Tahoma", Font.BOLD, 12));
      	titulos.setBounds(70, 25, 500, 100);
        titulos.setForeground(Color.WHITE);
        contentPane.add(titulos);
                     
                     
      	JLabel lblUsuario = new JLabel("<html>"+"<div id='div1>'"+"<TABLE BORDER='5'    WIDTH='50%'   CELLPADDING='4' CELLSPACING='3'>"+resultadoEt+"</TABLE>"+"</div>"+"</html>"+"#div1{overflow-y:scroll; height:200px; widht:500px;}");
                      
      	lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
      	lblUsuario.setBounds(40, 75, 500, 300);
      	contentPane.add(lblUsuario);
                      
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
	  botonCancelar.setBounds(281, 385, 97, 33);
	  contentPane.add(botonCancelar);
	
	}
	
	//Metodo que se encarga del evento del boton Cancelar
		private void botonCancelarActionPerformed( ActionEvent evt ){
			controladorUsuario.cerrarConexionBD();
			System.out.println("Conexion cerrada...");
			System.exit(0);		
		}
}

