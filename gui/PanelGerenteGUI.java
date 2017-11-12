package gui;
/**
 * @author juan diego ordonnez
 */

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelGerenteGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelGerenteGUI frame = new PanelGerenteGUI();
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
	public PanelGerenteGUI() {
		setResizable(false);
		setTitle("Panel De Usuario Gerente");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 415, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(210, 105, 30));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBienvenidoGerente = new JLabel("Bienvenido Gerente");
		lblBienvenidoGerente.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblBienvenidoGerente.setBounds(37, 11, 190, 29);
		contentPane.add(lblBienvenidoGerente);
		
		JButton btnRegistrarSede = new JButton("Registrar Sede");
		btnRegistrarSede.setMnemonic('R');
		btnRegistrarSede.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				CrearSedeGUI aplicacion1 = new CrearSedeGUI(){
					public void dispose(){
						getFrame().setVisible(true);
						super.dispose();
				}
			};
			aplicacion1.setVisible(true);
			aplicacion1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnRegistrarSede.setBackground(new Color(0, 0, 0));
		btnRegistrarSede.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRegistrarSede.setForeground(new Color(255, 255, 255));
		btnRegistrarSede.setBounds(60, 51, 135, 23);
		contentPane.add(btnRegistrarSede);
		
		JButton btnModificarSede = new JButton("Modificar Sede");
		btnModificarSede.setMnemonic('M');
		btnModificarSede.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				ModificarSedeGUI aplicacion1 = new ModificarSedeGUI(){
					public void dispose(){
						getFrame().setVisible(true);
						super.dispose();
					}
				};
				aplicacion1.setVisible(true);
				dispose();
			}
		});
		btnModificarSede.setBackground(new Color(0, 0, 0));
		btnModificarSede.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnModificarSede.setForeground(new Color(255, 255, 255));
		btnModificarSede.setBounds(60, 85, 135, 23);
		contentPane.add(btnModificarSede);
		
		JButton btnListarSedes = new JButton("Listar Sedes");
		btnListarSedes.setMnemonic('L');
		btnListarSedes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				ListarSedeGUI aplicacion1 = new ListarSedeGUI(){
					public void dispose(){
						getFrame().setVisible(true);
						super.dispose();
					}
				};
				aplicacion1.setVisible(true);
				dispose();
			}
		});
		btnListarSedes.setBackground(new Color(0, 0, 0));
		btnListarSedes.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnListarSedes.setForeground(new Color(255, 255, 255));
		btnListarSedes.setBounds(60, 119, 135, 23);
		contentPane.add(btnListarSedes);
		
		JButton btnCrearEvento = new JButton("Crear Evento");
		btnCrearEvento.setMnemonic('e');
		btnCrearEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				CrearEventoGUI aplicacion1 = new CrearEventoGUI(){
					public void dispose(){
						getFrame().setVisible(true);
						super.dispose();
					}
				};
				aplicacion1.setVisible(true);
				dispose();
			}
		});
		btnCrearEvento.setBackground(new Color(0, 0, 0));
		btnCrearEvento.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCrearEvento.setForeground(new Color(255, 255, 255));
		btnCrearEvento.setBounds(60, 153, 135, 23);
		contentPane.add(btnCrearEvento);
		
		JButton btnCancelarEvento = new JButton("Cancelar Evento");
		btnCancelarEvento.setMnemonic('a');
		btnCancelarEvento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				CancelarEventoGUI aplicacion1 = new CancelarEventoGUI(){
					public void dispose(){
						getFrame().setVisible(true);
						super.dispose();
					}
				};
				aplicacion1.setVisible(true);
				dispose();
			}
		});
		btnCancelarEvento.setBackground(new Color(0, 0, 0));
		btnCancelarEvento.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelarEvento.setForeground(new Color(255, 255, 255));
		btnCancelarEvento.setBounds(60, 187, 135, 23);
		contentPane.add(btnCancelarEvento);
		
		JButton btnNewButton = new JButton("Salir");
		btnNewButton.setMnemonic('S');
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(88, 221, 79, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		//ImageIcon aux = new ImageIcon(getClass().getResource("/imagen/icono-de-la-sombra-de-usuario.png"));
		ImageIcon aux = new ImageIcon(getClass().getResource("/imagen/icono-de-perfil-m-dico.png"));
		ImageIcon temp = new ImageIcon(aux.getImage().getScaledInstance(140, -1, Image.SCALE_DEFAULT));
		lblNewLabel.setIcon(temp);
		lblNewLabel.setSize(new Dimension(140, 140));
		lblNewLabel.setPreferredSize(new Dimension(140, 140));
		lblNewLabel.setBounds(232, 70, 140, 140);
		contentPane.add(lblNewLabel);
	}
	
	//Metodo para conseguir el JFrame de la Ventana Principal
	private JFrame getFrame(){
		return this;
	}
}
