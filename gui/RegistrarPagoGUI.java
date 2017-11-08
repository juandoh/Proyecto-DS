package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Rectangle;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrarPagoGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarPagoGUI frame = new RegistrarPagoGUI();
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
	public RegistrarPagoGUI() {
		setResizable(false);
		setTitle("Registrar Pago");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRegistroDePaagos = new JLabel("Registro de Pagos");
		lblRegistroDePaagos.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblRegistroDePaagos.setBounds(23, 11, 167, 23);
		contentPane.add(lblRegistroDePaagos);
		
		JLabel lblNombreDelEvento = new JLabel("Nombre del Evento");
		lblNombreDelEvento.setBounds(23, 45, 121, 14);
		contentPane.add(lblNombreDelEvento);
		
		JLabel lblNombreDelParticipante = new JLabel("Nombre del Participante");
		lblNombreDelParticipante.setBounds(23, 91, 139, 14);
		contentPane.add(lblNombreDelParticipante);
		
		textField = new JTextField();
		textField.setBounds(23, 58, 139, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(23, 106, 139, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblCedula = new JLabel("Cedula");
		lblCedula.setBounds(23, 137, 56, 14);
		contentPane.add(lblCedula);
		
		textField_2 = new JTextField();
		textField_2.setBounds(23, 151, 139, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(220, 45, 56, 14);
		contentPane.add(lblValor);
		
		JLabel lblFecha = new JLabel("fecha");
		lblFecha.setBounds(220, 91, 56, 14);
		contentPane.add(lblFecha);
		
		JLabel lblFormaDePago = new JLabel("Forma de Pago");
		lblFormaDePago.setBounds(220, 137, 101, 14);
		contentPane.add(lblFormaDePago);
		
		textField_3 = new JTextField();
		textField_3.setBounds(220, 58, 115, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(220, 106, 139, 20);
		contentPane.add(dateChooser);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(0, 0, 0));
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 11));
		comboBox.setForeground(new Color(255, 255, 255));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Cheque", "Efectivo", "Tarjeta de cr\u00E9dito", "Tarjeta d\u00E9bito"}));
		comboBox.setMaximumRowCount(4);
		comboBox.setBounds(220, 151, 115, 20);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton();
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				botonGuardarPago();
			}
		});
		//btnNewButton.setIcon(new ImageIcon(RegistrarPagoGUI.class.getResource("/imagen/savetheapplication_guardar_2958.png")));
		ImageIcon aux = new ImageIcon(getClass().getResource("/imagen/savetheapplication_guardar_2958.png"));
		ImageIcon temp = new ImageIcon(aux.getImage().getScaledInstance(70, -1, Image.SCALE_DEFAULT));
		btnNewButton.setIcon(temp);
		btnNewButton.setSize(new Dimension(70, 70));
		btnNewButton.setPreferredSize(new Dimension(70, 70));
		btnNewButton.setBounds(335, 190, 80, 70);
		contentPane.add(btnNewButton);
	}
	
	//Metodo que se encargar del evento del boton consultar
	private void botonGuardarPago(){
		//comboBox.setSelectedItem("Efectivo");
		
	}
	
}
