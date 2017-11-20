package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import accesoDatos.DaoDiploma;
import accesoDatos.DaoSede;
import controlador.ControladorDiploma;
import controlador.ControladorSede;
import logica.Diploma;
import logica.Sede;

public class ListarDiplomasGUI extends JFrame{
	private JPanel contentPane;
	private JTable table;
	private JScrollPane miScroll;
	
	ControladorDiploma controladorDiploma;
	
	private JButton btnSalir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListarDiplomasGUI frame = new ListarDiplomasGUI();
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
	public ListarDiplomasGUI() {
		
		setTitle("Lista de Diplomas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 351);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(200, 0, 50));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Se establece el Scroll
		miScroll = new JScrollPane();
		miScroll.setBounds(20, 50, 600, 106);
		contentPane.add(miScroll);
		
		//Se establece la Tabla
		construirTabla();
		
		//Label's
		JLabel lblTitulo = new JLabel("Diplomas Guardados.");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTitulo.setBounds(20, 10, 200, 29);
		contentPane.add(lblTitulo);
		
		//Button's
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setMnemonic('A');
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				construirTabla();
			}
		});
		btnActualizar.setForeground(Color.WHITE);
		btnActualizar.setBackground(Color.BLACK);
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnActualizar.setBounds(200, 200, 111, 35);
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
		btnSalir.setBounds(320, 200, 111, 35);
		contentPane.add(btnSalir);	
	}
	
	//Metodo para contruir la tabla
	private void construirTabla(){
		String titulos[] = {
				"Nombre Participante", "Cedula", "Fecha", "Nombre Evento", "Horas", "Tipo"
		};
		String informacion[][] = obtenerMatriz();
		
		table = new JTable(informacion, titulos);
		table.getColumnModel().getColumn(0).setPreferredWidth(120);
		table.getColumnModel().getColumn(1).setPreferredWidth(90);
		table.getColumnModel().getColumn(2).setPreferredWidth(93);
		table.getColumnModel().getColumn(3).setPreferredWidth(110);
		table.getColumnModel().getColumn(4).setPreferredWidth(50);
		table.getColumnModel().getColumn(5).setPreferredWidth(110);
		miScroll.setViewportView(table);
		
	}
	
	//Metodo para obtener una matriz con informacion de las sedes para llenar la tabla
	private String[][] obtenerMatriz(){
		
		DaoDiploma daoDiploma = new DaoDiploma();
		ArrayList<Diploma>miLista = daoDiploma.consultarDiplomas();
		
		String matrizInfo[][] = new String[miLista.size()][6];
		
		for (int i=0; i<miLista.size(); i++) {
			matrizInfo[i][0] = miLista.get(i).getNombre_participante();
			matrizInfo[i][1] = miLista.get(i).getCedula();
			matrizInfo[i][2] = miLista.get(i).getFecha();
			matrizInfo[i][3] = miLista.get(i).getNombre_evento();
			matrizInfo[i][4] = miLista.get(i).getHoras();
			matrizInfo[i][5] = miLista.get(i).getTipo();
			//System.out.println(miLista.get(i).getNombreSede());
		}

		daoDiploma.cerrarConexionBD();
		return matrizInfo;
	}
	
	//Metodo que se encarga del evento del boton Cancelar
	private void botonSalirActionPerformed( ActionEvent evt ){
		dispose();
	}
}
