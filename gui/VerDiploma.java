package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import logica.Diploma;

import java.awt.Dimension;
import java.awt.Graphics;

public class VerDiploma extends JFrame{
	
	private JPanel contentPane;
	private JLabel labelNombreP, labelCedula, labelFecha, labelNombreE, labelHoras, labelTipo;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VerDiploma frame = new VerDiploma();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//-------------------------------------------------------------------------------------------
	//Clase para poner fondo a la interfaz principal.
	public class PanelImagen extends javax.swing.JPanel {
	 public PanelImagen() {
	  this.setSize(400, 280);
	 }

	 @Override
	 public void paintComponent(Graphics g) {
	  Dimension tamanio = getSize();
	  ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/imagen/diploma_plantilla.jpg"));
	  g.drawImage(imagenFondo.getImage(), 0, 0, tamanio.width, tamanio.height, null);
	  setOpaque(false);
	  super.paintComponent(g);
	 }
	}
	//-------------------------------------------------------------------------------------------

	/**
	 * Create the frame.
	 */
	public VerDiploma() {
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		PanelImagen p = new PanelImagen();
		p.setLayout(null);
		setContentPane(p);
		
		JLabel labelTitulo = new JLabel("CERTIFICADO");
		labelTitulo.setFont(new Font("Algerian", Font.BOLD, 50));
		labelTitulo.setBounds(180, 65, 340, 50);
		labelTitulo.setHorizontalAlignment(JLabel.CENTER);
		labelTitulo.setVerticalAlignment(JLabel.CENTER);
		add(labelTitulo);
		
		JLabel labelOtorgadoa = new JLabel("Otorgado a:");
		labelOtorgadoa.setFont(new Font("Monotype Corsiva", Font.PLAIN, 14));
		labelOtorgadoa.setBounds(230, 110, 235, 24);
		labelOtorgadoa.setHorizontalAlignment(JLabel.CENTER);
		labelOtorgadoa.setVerticalAlignment(JLabel.CENTER);
		add(labelOtorgadoa);
		
		labelNombreP = new JLabel("");
		labelNombreP.setFont(new Font("Monotype Corsiva", Font.BOLD, 30));
		labelNombreP.setBounds(190, 130, 300, 35);
		labelNombreP.setHorizontalAlignment(JLabel.CENTER);
		labelNombreP.setVerticalAlignment(JLabel.CENTER);
		add(labelNombreP);
		
		JLabel labelConcedula = new JLabel("Con cedula:");
		labelConcedula.setFont(new Font("Monotype Corsiva", Font.PLAIN, 14));
		labelConcedula.setBounds(230, 160, 235, 24);
		labelConcedula.setHorizontalAlignment(JLabel.CENTER);
		labelConcedula.setVerticalAlignment(JLabel.CENTER);
		add(labelConcedula);
		
		labelCedula = new JLabel("");
		labelCedula.setFont(new Font("Monotype Corsiva", Font.BOLD, 40));
		labelCedula.setBounds(230, 185, 235, 28);
		labelCedula.setHorizontalAlignment(JLabel.CENTER);
		labelCedula.setVerticalAlignment(JLabel.CENTER);
		add(labelCedula);
		
		JLabel labelTipoDiploma = new JLabel("Otorgado...");
		labelTipoDiploma.setFont(new Font("Monotype Corsiva", Font.PLAIN, 14));
		labelTipoDiploma.setBounds(230, 220, 235, 24);
		labelTipoDiploma.setHorizontalAlignment(JLabel.CENTER);
		labelTipoDiploma.setVerticalAlignment(JLabel.CENTER);
		add(labelTipoDiploma);
		
		labelTipo = new JLabel("");
		labelTipo.setFont(new Font("Algerian", Font.BOLD, 40));
		labelTipo.setBounds(150, 240, 400, 50);
		labelTipo.setHorizontalAlignment(JLabel.CENTER);
		labelTipo.setVerticalAlignment(JLabel.CENTER);
		add(labelTipo);
		
		JLabel labelPorasistir = new JLabel("Por asistir al evento:");
		labelPorasistir.setFont(new Font("Monotype Corsiva", Font.PLAIN, 14));
		labelPorasistir.setBounds(60, 300, 235, 24);
		labelPorasistir.setHorizontalAlignment(JLabel.CENTER);
		labelPorasistir.setVerticalAlignment(JLabel.CENTER);
		add(labelPorasistir);
		
		labelNombreE = new JLabel("");
		labelNombreE.setFont(new Font("Monotype Corsiva", Font.BOLD, 40));
		labelNombreE.setBounds(30, 320, 300, 40);
		labelNombreE.setHorizontalAlignment(JLabel.CENTER);
		labelNombreE.setVerticalAlignment(JLabel.CENTER);
		add(labelNombreE);
		
		JLabel labelDurante = new JLabel("Durante:");
		labelDurante.setFont(new Font("Monotype Corsiva", Font.PLAIN, 14));
		labelDurante.setBounds(400, 300, 235, 24);
		labelDurante.setHorizontalAlignment(JLabel.CENTER);
		labelDurante.setVerticalAlignment(JLabel.CENTER);
		add(labelDurante);
		
		labelHoras = new JLabel("");
		labelHoras.setFont(new Font("Monotype Corsiva", Font.BOLD, 40));
		labelHoras.setBounds(360, 320, 300, 40);
		labelHoras.setHorizontalAlignment(JLabel.CENTER);
		labelHoras.setVerticalAlignment(JLabel.CENTER);
		add(labelHoras);
		
		JLabel labelEnfecha = new JLabel("En la fecha:");
		labelEnfecha.setFont(new Font("Monotype Corsiva", Font.PLAIN, 14));
		labelEnfecha.setBounds(230, 385, 235, 24);
		labelEnfecha.setHorizontalAlignment(JLabel.CENTER);
		labelEnfecha.setVerticalAlignment(JLabel.CENTER);
		add(labelEnfecha);
		
		labelFecha = new JLabel("");
		labelFecha.setFont(new Font("Monotype Corsiva", Font.BOLD, 22));
		labelFecha.setBounds(225, 405, 235, 24);
		labelFecha.setHorizontalAlignment(JLabel.CENTER);
		labelFecha.setVerticalAlignment(JLabel.CENTER);
		add(labelFecha);
	}
	
	public void asignarDatos(String nombre_participante, String cedula, String fecha, String nombre_evento, String horas, String tipo){
		labelNombreP.setText(nombre_participante);
		labelCedula.setText(cedula);
		labelFecha.setText(fecha);
		labelNombreE.setText(nombre_evento);
		labelHoras.setText(horas + " Horas");
		labelTipo.setText(tipo);
	}
}
