package gui;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;

public class GenerarEscarapelaGUI extends JFrame {

	private JPanel contentPane;
	private JTextField CampoParticipante;
	private JTextField CampoCedula;
	private JTextField textField;
	private JLabel lblFoto, lblImagen;
	
	private JFileChooser fc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GenerarEscarapelaGUI frame = new GenerarEscarapelaGUI();
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
	public GenerarEscarapelaGUI() {
		setTitle("Generar Escarapela");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 495, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblParticipante = new JLabel("Participante:");
		lblParticipante.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblParticipante.setBounds(23, 61, 111, 30);
		contentPane.add(lblParticipante);
		
		JLabel lblGenerarEscarapela = new JLabel("Generar Escarapela");
		lblGenerarEscarapela.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblGenerarEscarapela.setBounds(10, 10, 180, 45);
		contentPane.add(lblGenerarEscarapela);
		
		JLabel lblCedula = new JLabel("Cedula:");
		lblCedula.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCedula.setBounds(23, 97, 111, 30);
		contentPane.add(lblCedula);
		
		JLabel lblFechaValidez = new JLabel("Fecha de Validez:");
		lblFechaValidez.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFechaValidez.setBounds(23, 135, 111, 30);
		contentPane.add(lblFechaValidez);
		
		JLabel lblNewLabel = new JLabel("Evento:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(23, 175, 111, 30);
		contentPane.add(lblNewLabel);
		
		CampoParticipante = new JTextField();
		CampoParticipante.setBounds(144, 67, 101, 20);
		contentPane.add(CampoParticipante);
		CampoParticipante.setColumns(10);
		
		CampoCedula = new JTextField();
		CampoCedula.setBounds(144, 103, 101, 20);
		contentPane.add(CampoCedula);
		CampoCedula.setColumns(10);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(144, 145, 101, 20);
		contentPane.add(dateChooser);
		
		textField = new JTextField();
		textField.setBounds(144, 181, 101, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.YELLOW);
		separator.setBackground(Color.BLACK);
		separator.setBounds(271, 48, 2, 157);
		contentPane.add(separator);
		
		lblFoto = new JLabel("Foto");
		lblFoto.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFoto.setBounds(358, 36, 40, 30);
		contentPane.add(lblFoto);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
			}
		});
		btnGuardar.setBounds(23, 228, 89, 23);
		contentPane.add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
			}
		});
		btnCancelar.setBounds(122, 228, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnNewButton = new JButton("Examinar...");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				botonExaminar();
			}
		});
		btnNewButton.setBounds(335, 228, 89, 23);
		contentPane.add(btnNewButton);
		
		lblImagen = new JLabel("New label");
		lblImagen.setBounds(302, 67, 150, 150);
		contentPane.add(lblImagen);
	}
	
	//Metodo que se encarga del evento del boton Examinar
	private void botonExaminar(){
		
		fc = new JFileChooser();
		
		//Se indica lo que se puede seleccionar, en este caso solo archivos
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		
		//Creamos un filtro para solo archivos con formato de imagenes
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.jpg", "jpg");
		
		//Se le asigana el filtro al JFileChooser
		fc.setFileFilter(filtro);
		
		//Abre la ventana y se guarda la opcion selecionada por el Usuario
		int seleccion = fc.showOpenDialog(contentPane);
		
		if ( seleccion==fc.APPROVE_OPTION ) {
			
			//Se selecciona el fichero
			File archivo = fc.getSelectedFile();
			
			ImageIcon aux = new ImageIcon(archivo.getAbsolutePath());
			ImageIcon temp = new ImageIcon(aux.getImage().getScaledInstance(150, -1, Image.SCALE_DEFAULT));
			lblImagen.setIcon(temp);
			lblImagen.setSize(new Dimension(150, 150));
			lblImagen.setPreferredSize(new Dimension(150, 150));
		} else if ( seleccion == fc.CANCEL_OPTION){
			JOptionPane.showMessageDialog(null, "No se ha seleccionado la fotografia para la escarapela", "Ninguna Imagen", JOptionPane.WARNING_MESSAGE);
		} else if ( seleccion == fc.ERROR_OPTION) {
			JOptionPane.showMessageDialog(null, "Error al buscar y cargar la imagen", "Error en la imagen", JOptionPane.ERROR_MESSAGE);
		}
	}
	
}
