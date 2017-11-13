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
import java.text.SimpleDateFormat;
import java.util.Date;

public class GenerarEscarapelaGUI extends JFrame {

	private JPanel contentPane;
	private JTextField CampoParticipante;
	private JTextField CampoCedula;
	private JTextField campoEvento;
	private JLabel lblFoto, lblImagen;
	private JLabel lblParticipante;
	private JLabel lblGenerarEscarapela;
	private JLabel lblCedula;
	private JDateChooser dateChooser;
	
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
		setBackground(new Color(255, 255, 255));
		setResizable(false);
		setTitle("Generar Escarapela");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 520, 308);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 140, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblParticipante = new JLabel("Participante:");
		lblParticipante.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblParticipante.setBounds(23, 62, 111, 30);
		contentPane.add(lblParticipante);
		
		lblGenerarEscarapela = new JLabel("Generar Escarapela");
		lblGenerarEscarapela.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblGenerarEscarapela.setBounds(10, 10, 180, 45);
		contentPane.add(lblGenerarEscarapela);
		
		lblCedula = new JLabel("Cedula:");
		lblCedula.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCedula.setBounds(23, 98, 111, 30);
		contentPane.add(lblCedula);
		
		JLabel lblFechaValidez = new JLabel("Fecha de Validez:");
		lblFechaValidez.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFechaValidez.setBounds(23, 140, 111, 30);
		contentPane.add(lblFechaValidez);
		
		JLabel lblEvento = new JLabel("Evento:");
		lblEvento.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEvento.setBounds(23, 176, 111, 30);
		contentPane.add(lblEvento);
		
		CampoParticipante = new JTextField();
		CampoParticipante.setBounds(144, 67, 131, 20);
		contentPane.add(CampoParticipante);
		CampoParticipante.setColumns(10);
		
		CampoCedula = new JTextField();
		CampoCedula.setBounds(144, 103, 131, 20);
		contentPane.add(CampoCedula);
		CampoCedula.setColumns(10);
		
		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("d-MM-yyyy");
		dateChooser.setBounds(144, 145, 111, 20);
		contentPane.add(dateChooser);
		
		campoEvento = new JTextField();
		campoEvento.setBounds(144, 181, 131, 20);
		contentPane.add(campoEvento);
		campoEvento.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.YELLOW);
		separator.setBackground(Color.BLACK);
		separator.setBounds(315, 48, 2, 157);
		contentPane.add(separator);
		
		lblFoto = new JLabel("Foto");
		lblFoto.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFoto.setBounds(400, 36, 40, 30);
		contentPane.add(lblFoto);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBackground(new Color(0, 0, 0));
		btnGuardar.setForeground(new Color(255, 255, 255));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
			}
		});
		btnGuardar.setBounds(23, 228, 89, 31);
		contentPane.add(btnGuardar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(new Color(0, 0, 0));
		btnCancelar.setForeground(new Color(255, 255, 255));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				dispose();
			}
		});
		btnCancelar.setBounds(122, 228, 89, 31);
		contentPane.add(btnCancelar);
		
		JButton btnNewButton = new JButton("Examinar...");
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				botonExaminar();
			}
		});
		btnNewButton.setBounds(366, 228, 112, 31);
		contentPane.add(btnNewButton);
		
		lblImagen = new JLabel("");
		lblImagen.setBounds(344, 67, 150, 150);
		contentPane.add(lblImagen);
		
		JButton btnImprimir = new JButton("Imprimir");
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				botonImprimirActionPerformed(evt);
			}
		});
		btnImprimir.setBackground(new Color(0, 0, 0));
		btnImprimir.setForeground(new Color(255, 255, 255));
		btnImprimir.setBounds(228, 228, 89, 31);
		contentPane.add(btnImprimir);
	}
	
	//Metodo para conseguir el JFrame de la Ventana Principal
	private JFrame getFrame(){
		return this;
	}
	
	//Metodo que se encarga de Imprimir la escarapela
	private void botonImprimirActionPerformed( ActionEvent evt ){
		VerEscarapela aplicacion1 = new VerEscarapela(){
			public void dispose(){
				getFrame().setVisible(true);
				super.dispose();
			}
		};
		SimpleDateFormat sdf = new SimpleDateFormat("d/MM/yyyy");
		aplicacion1.setVisible(true);
		aplicacion1.asignarDatos(CampoParticipante.getText(), CampoCedula.getText(), sdf.format(dateChooser.getDate()).toString(), campoEvento.getText());
		dispose();
	}
	
	private String toString(Date date) {
		// TODO Auto-generated method stub
		return null;
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
