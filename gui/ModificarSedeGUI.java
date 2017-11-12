package gui;
/**
 * @author juan diego ordonnez
 */

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

import controlador.ControladorSede;

import java.awt.Color;

import logica.Sede;

public class ModificarSedeGUI extends JFrame {

	private JPanel contentPane;
	private JTextField campoNombre;
	private JTextField CampoDireccion;
	private JTextField campoNumero;
	private JTextField CampoCuidad;
	private JButton btnActualizar;
	
	ControladorSede controladorSede;

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
		contentPane.setBackground(new Color(123, 104, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIngreseLosNuevos = new JLabel("Ingrese Los Nuevos Datos De La Sede");
		lblIngreseLosNuevos.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblIngreseLosNuevos.setBounds(10, 8, 342, 30);
		contentPane.add(lblIngreseLosNuevos);
		
		JLabel lblNombreSede = new JLabel("Nombre Sede:");
		lblNombreSede.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNombreSede.setBounds(42, 70, 116, 30);
		contentPane.add(lblNombreSede);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n:");
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDireccion.setBounds(42, 107, 116, 30);
		contentPane.add(lblDireccion);
		
		JLabel lblNumeroDeSede = new JLabel("N\u00FAmero de Sede:");
		lblNumeroDeSede.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNumeroDeSede.setBounds(42, 143, 116, 30);
		contentPane.add(lblNumeroDeSede);
		
		JLabel lblCiudad = new JLabel("Ciudad:");
		lblCiudad.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCiudad.setBounds(42, 176, 116, 30);
		contentPane.add(lblCiudad);
		
		campoNombre = new JTextField();
		campoNombre.setBounds(168, 75, 100, 20);
		contentPane.add(campoNombre);
		campoNombre.setColumns(10);
		
		CampoDireccion = new JTextField();
		CampoDireccion.setBounds(168, 112, 100, 20);
		contentPane.add(CampoDireccion);
		CampoDireccion.setColumns(10);
		
		campoNumero = new JTextField();
		campoNumero.setBounds(168, 148, 100, 20);
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
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setEnabled(false);
		btnActualizar.setMnemonic('A');
		btnActualizar.setBackground(new Color(0, 0, 0));
		btnActualizar.setForeground(new Color(255, 255, 255));
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				botonActualizarActionPerformed(evt);
			}
		});
		btnActualizar.setBounds(20, 227, 116, 34);
		contentPane.add(btnActualizar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setMnemonic('n');
		btnCancelar.setForeground(new Color(255, 255, 255));
		btnCancelar.setBackground(new Color(0, 0, 0));
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				botonCancelarActionPerformed(evt);
			}
		});
		btnCancelar.setBounds(318, 227, 104, 34);
		contentPane.add(btnCancelar);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				botonConsultarActionPerformed(evt);
			}
		});
		btnConsultar.setForeground(new Color(255, 255, 255));
		btnConsultar.setBackground(new Color(0, 0, 0));
		btnConsultar.setMnemonic('C');
		btnConsultar.setBounds(168, 227, 121, 34);
		contentPane.add(btnConsultar);
		
		JLabel lblNota = new JLabel("Nota: antes de modificar, consultar la sede por el nombre y ciudad.");
		lblNota.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 9));
		lblNota.setBounds(10, 49, 342, 14);
		contentPane.add(lblNota);
	}
	
	//Metodo que se encarga del evento del boton Cancelar
	private void botonCancelarActionPerformed( ActionEvent evt ){
		dispose();
	}
	
	//Metodo que se encarga del evento del boton Actualizar
	private void botonActualizarActionPerformed( ActionEvent evt ){
		String nombre, direccion, numeroSede, ciudad;
		
		nombre = campoNombre.getText();
		direccion = CampoDireccion.getText();
		numeroSede = campoNumero.getText();
		ciudad = CampoCuidad.getText();
		
		int numFilas = controladorSede.modificarSede(nombre, direccion, numeroSede, ciudad);
		
		System.out.println ("Filas "+ numFilas);
		
		if ( campoNombre.getText().equals("") || CampoDireccion.getText().equals("") ||
				campoNumero.getText().equals("") || CampoCuidad.getText().equals("")){
			
			JOptionPane.showMessageDialog(null, "Por favor llenar todos los campos", "Campos Vacios", JOptionPane.WARNING_MESSAGE);
		} else if (numFilas == 1){
			JOptionPane.showMessageDialog(null, "La Sede se ha modificado!", "Modificación Exitosa", JOptionPane.INFORMATION_MESSAGE);
			
		}else{
			JOptionPane.showMessageDialog(null, "Ocurrio un problema al modificar la Sede en el Sistema", "Fallo en la Modificación", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	//
	private void botonConsultarActionPerformed( ActionEvent evt ){
		String nombre, ciudad;
		
		nombre = campoNombre.getText();
		ciudad = CampoCuidad.getName();
		
		Sede s;
		
		s = controladorSede.consultarSede(nombre, ciudad);
		if ( campoNombre.getText().equals("") || CampoCuidad.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Por favor llenar todos los campos", "Campos Vacios", JOptionPane.WARNING_MESSAGE);
		} else if (s.equals(null)){
			JOptionPane.showMessageDialog(null, "La Sede no se encuentra registrada en el Sistema", "No Encontrada", JOptionPane.INFORMATION_MESSAGE);
		} else{
			CampoDireccion.setText(s.getDireccion());
			campoNumero.setText(s.getNumeroSede());
			btnActualizar.setEnabled(true);
		}
	}
}
