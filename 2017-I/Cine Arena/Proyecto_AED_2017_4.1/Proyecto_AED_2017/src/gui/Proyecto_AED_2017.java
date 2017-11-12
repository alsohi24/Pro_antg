package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import arreglo.ArregloUsuario;

import javax.swing.JLabel;
import java.awt.Font;

public class Proyecto_AED_2017 extends JFrame implements ActionListener {

	private JPanelConFondo contentPane;
	private JMenuBar menuBar = new JMenuBar();
	private JMenu mnArchivo = new JMenu("Archivo");
	private JMenu mnMantenimiento = new JMenu("Mantenimiento");
	private JMenu mnRegistro = new JMenu("Registro");
	private JMenu mnModulo = new JMenu("Módulo");
	private JMenu mnReportes = new JMenu("Reportes");
	
	private JMenuItem itSalir = new JMenuItem("Salir");
	private JMenuItem itUsuario = new JMenuItem("Usuario");
	private JMenuItem itCliente = new JMenuItem("Cliente");
	private JMenuItem itCancion = new JMenuItem("Canción");
	private JMenuItem itGenero = new JMenuItem("Género");
	private JMenuItem itArtista = new JMenuItem("Artista");
	private JMenuItem itBebida = new JMenuItem("Bebida");
	private JMenuItem itPiqueo = new JMenuItem("Piqueo");
	private JMenuItem itRegPed = new JMenuItem("Registro de pedido");
	private JMenuItem itRegCon = new JMenuItem("Registro de consumo");
	private JMenuItem itPagCon = new JMenuItem("Pago de consumo");
	private JMenuItem itBPedCli = new JMenuItem("Buscar pedidos por cliente");
	private JMenuItem itCanRan = new JMenuItem("Canciones más ranqueadas");
	private JMenuItem itUsuMasPed = new JMenuItem("Usuarios con más pedidos");
	private JMenuItem itComSug = new JMenuItem("Comentarios/Sugerencias");
	
	int usuarioActual =1001;
	private JLabel lblBienvenido = new JLabel("Bienvenido!");
	/** 	
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Proyecto_AED_2017 frame = new Proyecto_AED_2017(1001);
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
	public Proyecto_AED_2017(int usuarioActual) {
		
		this.usuarioActual=usuarioActual;
		
		setTitle("CinemArena");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		menuBar.add(mnArchivo);
		menuBar.add(mnMantenimiento);
		menuBar.add(mnRegistro);
		menuBar.add(mnModulo);
		menuBar.add(mnReportes);
		
		mnArchivo.add(itSalir);
		mnArchivo.setIcon(new ImageIcon(Proyecto_AED_2017.class.getResource("/imagenes/archivo.png")));
		
		mnMantenimiento.add(itUsuario);
		mnMantenimiento.add(itCliente);
		mnMantenimiento.add(itCancion);
		mnMantenimiento.add(itGenero);
		mnMantenimiento.add(itArtista);
		mnMantenimiento.add(itBebida);
		mnMantenimiento.add(itPiqueo);
		mnMantenimiento.setIcon(new ImageIcon(Proyecto_AED_2017.class.getResource("/imagenes/mantenimiento.png")));		
		
		mnRegistro.add(itRegPed);
		mnRegistro.add(itRegCon);
		mnRegistro.setIcon(new ImageIcon(Proyecto_AED_2017.class.getResource("/imagenes/registro.png")));
		
		mnModulo.add(itPagCon);
		mnModulo.setIcon(new ImageIcon(Proyecto_AED_2017.class.getResource("/imagenes/modulo.png")));
		
		mnReportes.add(itBPedCli);
		mnReportes.add(itCanRan);
		mnReportes.add(itUsuMasPed);
		mnReportes.add(itComSug);
		mnReportes.setIcon(new ImageIcon(Proyecto_AED_2017.class.getResource("/imagenes/reportes.png")));
		
		itSalir.addActionListener(this);
		itUsuario.addActionListener(this);
		itArtista.addActionListener(this);
		itBebida.addActionListener(this);
		itBPedCli.addActionListener(this);
		itCancion.addActionListener(this);
		itCanRan.addActionListener(this);
		itCliente.addActionListener(this);
		itComSug.addActionListener(this);
		itGenero.addActionListener(this);
		itPagCon.addActionListener(this);
		itPiqueo.addActionListener(this);
		itRegCon.addActionListener(this);
		itRegPed.addActionListener(this);
		itUsuMasPed.addActionListener(this);
		
		
		setJMenuBar(menuBar);
		setBounds(100, 100, 1024, 800);
		contentPane = new JPanelConFondo("/imagenes/cinefondo.png");	
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		lblBienvenido.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblBienvenido.setBounds(10, 11, 446, 76);
		lblBienvenido.setText("Bienvenido! "+new ArregloUsuario().obtenerPorCodigo(usuarioActual).getNombres());
		contentPane.add(lblBienvenido);
	
		}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getSource() == itSalir){
			
			System.exit(0);		
			
		}
		
		else if(arg0.getSource() == itUsuario) {
			
			DUsuario dialog = new DUsuario();
			dialog.setLocationRelativeTo(this);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setModal(true);
			dialog.setVisible(true);
			
		}
		
		else if(arg0.getSource() == itArtista) {
			
			DArtista dialog = new DArtista();
						
		}
		
		else if(arg0.getSource() == itBebida) {
			
			DBebida dialog = new DBebida();
			dialog.setLocationRelativeTo(this);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setModal(true);
			dialog.setVisible(true);
			
		}
		
		else if(arg0.getSource() == itCancion) {
			
			DCancion dialog = new DCancion();
						
		}
		
		else if(arg0.getSource() == itCliente) {
			
			DCliente dialog = new DCliente();
			dialog.setLocationRelativeTo(this);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setModal(true);
			dialog.setVisible(true);
			
		}
		
		else if(arg0.getSource() == itGenero) {
			
			DGenero dialog = new DGenero();
			dialog.setLocationRelativeTo(this);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setModal(true);
			dialog.setVisible(true);
			
		}
		
				
		else if(arg0.getSource() == itPiqueo) {
			
			DPiqueos dialog = new DPiqueos();
			dialog.setLocationRelativeTo(this);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setModal(true);
			dialog.setVisible(true);
			
		}
		
		else if(arg0.getSource() == itRegPed) {
			
			DRegistroPedido dialog = new DRegistroPedido(usuarioActual);
						
		}
		
		else if(arg0.getSource() == itRegCon) {
			
			DRegistroConsumo dialog = new DRegistroConsumo();
			dialog.setLocationRelativeTo(this);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setModal(true);
			dialog.setVisible(true);
			
		}	
		
		else if(arg0.getSource() == itPagCon) {
			
			DPagoConsumo dialog = new DPagoConsumo(1001);
			dialog.setLocationRelativeTo(this);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setModal(true);
			dialog.setVisible(true);
			
		}	
		
		else if(arg0.getSource() == itBPedCli) {
			
			DBuscarPedidoCliente dialog = new DBuscarPedidoCliente();
						
		}
			
		
		else if(arg0.getSource() == itCanRan) {
			
			DBuscarCancionesRanqueadas dialog = new DBuscarCancionesRanqueadas();
						
		}
		
		else if(arg0.getSource() == itUsuMasPed) {
	
			DBuscarRegistrosMasPedidos dialog = new DBuscarRegistrosMasPedidos();
				
		}
		
		else {
			
			DSugerencia dialog = new DSugerencia(usuarioActual);
			dialog.setLocationRelativeTo(this);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setModal(true);
			dialog.setVisible(true);
			
		}
		
		
		
		
		
	}

}
