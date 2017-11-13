package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class VerEscarapela extends JFrame {

	private JPanel contentPane;
	JLabel lblNombreParticipante;
	JLabel lblCedula;
	JLabel lblFecha;
	JLabel lblTemp;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VerEscarapela frame = new VerEscarapela();
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
	public VerEscarapela() {
		setBackground(new Color(255, 255, 255));
		setTitle("Escarapela");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 530);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(32, 178, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBackground(new Color(255, 255, 255));
		ImageIcon aux = new ImageIcon(getClass().getResource("/imagen/plantillaEscarapela.png"));
		ImageIcon temp = new ImageIcon(aux.getImage().getScaledInstance(300, -1, Image.SCALE_DEFAULT));
		
		lblFecha = new JLabel("Fecha");
		lblFecha.setHorizontalAlignment(SwingConstants.CENTER);
		lblFecha.setBounds(139, 309, 163, 30);
		contentPane.add(lblFecha);
		
		lblCedula = new JLabel("Cedula");
		lblCedula.setHorizontalAlignment(SwingConstants.CENTER);
		lblCedula.setBounds(142, 273, 157, 30);
		contentPane.add(lblCedula);
		
		lblNombreParticipante = new JLabel("Nombre Participante");
		lblNombreParticipante.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreParticipante.setBounds(128, 110, 184, 30);
		contentPane.add(lblNombreParticipante);
		
		lblTemp = new JLabel("Nombre del evento");
		lblTemp.setHorizontalAlignment(SwingConstants.CENTER);
		lblTemp.setBounds(132, 360, 177, 30);
		contentPane.add(lblTemp);
		label.setIcon(temp);
		label.setSize(new Dimension(300, 360));
		label.setPreferredSize(new Dimension(300, 360));
		label.setBounds(70, 65, 301, 360);
		contentPane.add(label);
	}
	
	public void asignarDatos( String nombre, String cedula, String fecha, String nomEvento){
		lblNombreParticipante.setText(nombre);
		lblCedula.setText(cedula);
		lblFecha.setText(fecha);
		lblTemp.setText(nomEvento);
	}
}
