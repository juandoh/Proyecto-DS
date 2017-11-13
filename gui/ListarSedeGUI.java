package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.ScrollPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;

import accesoDatos.DaoSede;

import java.awt.Font;
import java.util.ArrayList;

import logica.Sede;
import javax.swing.JButton;

import controlador.ControladorSede;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListarSedeGUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane miScroll;
	
	ControladorSede controladorSede;
	private JButton btnSalir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarSedeGUI frame = new ListarSedeGUI();
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
	public ListarSedeGUI() {
		controladorSede = new ControladorSede();
		
		setTitle("Listar Sedes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 493, 351);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(50, 205, 50));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Se establece el Scroll
		miScroll = new JScrollPane();
		miScroll.setBounds(20, 50, 436, 106);
		contentPane.add(miScroll);
		
		//Se establece la Tabla
		construirTabla();
		/*DefaultTableModel modelo = new DefaultTableModel();
		table = new JTable(modelo);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Nombre Sede", "Direcci\u00F3n", "N\u00FAmero de Sede", "Ciudad"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(120);
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		table.getColumnModel().getColumn(2).setPreferredWidth(93);
		table.getColumnModel().getColumn(3).setPreferredWidth(110);
		scrollPane.setViewportView(table);*/
		
		JLabel lblSedesRegistradas = new JLabel("Sedes Registradas");
		lblSedesRegistradas.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblSedesRegistradas.setBounds(10, 10, 200, 29);
		contentPane.add(lblSedesRegistradas);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setMnemonic('A');
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				obtenerMatriz();
			}
		});
		btnActualizar.setForeground(Color.WHITE);
		btnActualizar.setBackground(Color.BLACK);
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnActualizar.setBounds(71, 249, 111, 35);
		contentPane.add(btnActualizar);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				botonSalirActionPerformed(evt);
			}
		});
		btnSalir.setMnemonic('S');
		btnSalir.setBackground(new Color(0, 0, 0));
		btnSalir.setForeground(new Color(255, 255, 255));
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSalir.setBounds(284, 249, 111, 35);
		contentPane.add(btnSalir);
	}
	
	//Metodo para contruir la tabla
	private void construirTabla(){
		String titulos[] = {
				"Nombre Sede", "Direcci\u00F3n", "N\u00FAmero de Sede", "Ciudad"
		};
		String informacion[][] = obtenerMatriz();
		
		table = new JTable(informacion, titulos);
		table.getColumnModel().getColumn(0).setPreferredWidth(120);
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		table.getColumnModel().getColumn(2).setPreferredWidth(93);
		table.getColumnModel().getColumn(3).setPreferredWidth(110);
		miScroll.setViewportView(table);
		
	}
	
	//Metodo para obtener una matriz con informacion de las sedes para llenar la tabla
	private String[][] obtenerMatriz(){
		
		DaoSede daoSede = new DaoSede();
		ArrayList<Sede>miLista = daoSede.consultarSedesConMatriz();
		
		String matrizInfo[][] = new String[miLista.size()][4];
		
		for (int i=0; i<miLista.size(); i++) {
			matrizInfo[i][0] = miLista.get(i).getNombreSede();
			matrizInfo[i][1] = miLista.get(i).getDireccion();
			matrizInfo[i][2] = miLista.get(i).getNumeroSede();
			matrizInfo[i][3] = miLista.get(i).getCiudad();
			//System.out.println(miLista.get(i).getNombreSede());
		}
		
		return matrizInfo;
	}
	
	//Metodo que se encarga del evento del boton Cancelar
	private void botonSalirActionPerformed( ActionEvent evt ){
		controladorSede.cerrarConexionBD();
		System.out.println("Conexion cerrada...");
		dispose();
	}
}
