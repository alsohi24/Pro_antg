package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.JLabel;

public class Principal extends JFrame implements ActionListener {
	/**
	 *
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenuBar menuProyecto;
	private JMenu mnArchivo;
	private JMenuItem mntmSalir;
	private JMenu mnMantenimiento;
	private JMenu mnPedidos;
	private JMenu mnRegistroDeConsumo;
	private JMenu mnPago;
	private JMenu mnReportes;
	private JMenuItem mntmUsuario;
	private JMenuItem mntmCliente;
	private JMenuItem mntmCancion;
	private JMenuItem mntmGenero;
	private JMenuItem mntmArtista;
	private JMenuItem mntmPedido;
	private JMenuItem mntmBebidas;
	private JMenuItem mntmPiqueos;

	private JMenuItem mntmAgregarPedido;
	private JMenuItem mntmReportarUsuCli;
	private JMenuItem mntmReportarCanciones;
	private JMenuItem mntmReportarUsuPed;
	private JMenuItem mntmReportarComSug;

	private JLabel lblFondo;
	private JMenuItem mntmRegistrarSugerencia;
	private JMenuItem mntmRegistrarConsumo;
	private JMenuItem mntmRegistrarPago;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setTitle("Proyecto | Karaoke");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);

		menuProyecto = new JMenuBar();
		setJMenuBar(menuProyecto);

		mnArchivo = new JMenu("Archivo");
		mnArchivo.setIcon(new ImageIcon("imagenes/archivo.png"));
		menuProyecto.add(mnArchivo);

		mntmSalir = new JMenuItem("Salir");
		mntmSalir.setIcon(new ImageIcon("imagenes/salir.png"));
		mntmSalir.addActionListener(this);
		mnArchivo.add(mntmSalir);

		mnMantenimiento = new JMenu("Mantenimiento");
		mnMantenimiento.setIcon(new ImageIcon("imagenes/mantenimiento.png"));
		menuProyecto.add(mnMantenimiento);

		mntmUsuario = new JMenuItem("Usuario");
		mntmUsuario.addActionListener(this);
		mntmUsuario.setIcon(new ImageIcon("imagenes/usuarios.png"));
		mnMantenimiento.add(mntmUsuario);

		mntmCliente = new JMenuItem("Cliente");
		mntmCliente.addActionListener(this);
		mntmCliente.setIcon(new ImageIcon("imagenes/clientes.png"));
		mnMantenimiento.add(mntmCliente);

		mntmCancion = new JMenuItem("Cancion");
		mntmCancion.addActionListener(this);
		mntmCancion.setIcon(new ImageIcon("imagenes/cancion.png"));
		mnMantenimiento.add(mntmCancion);

		mntmGenero = new JMenuItem("Genero");
		mntmGenero.addActionListener(this);
		mntmGenero.setIcon(new ImageIcon("imagenes/genero.png"));
		mnMantenimiento.add(mntmGenero);

		mntmArtista = new JMenuItem("Artista");
		mntmArtista.addActionListener(this);
		mntmArtista.setIcon(new ImageIcon("imagenes/artista4.png"));
		mnMantenimiento.add(mntmArtista);

		mntmPedido = new JMenuItem("Pedido");
		mntmPedido.addActionListener(this);
		mntmPedido.setIcon(new ImageIcon("imagenes/pedido.png"));
		mnMantenimiento.add(mntmPedido);

		mntmBebidas = new JMenuItem("Bebidas");
		mntmBebidas.addActionListener(this);
		mntmBebidas.setIcon(new ImageIcon("imagenes/bebida.png"));
		mnMantenimiento.add(mntmBebidas);

		mntmPiqueos = new JMenuItem("Piqueos");
		mntmPiqueos.addActionListener(this);
		mntmPiqueos.setIcon(new ImageIcon("imagenes/piqueo.png"));
		mnMantenimiento.add(mntmPiqueos);

		mnPedidos = new JMenu("Registro de Pedidos");
		mnPedidos.setIcon(new ImageIcon("imagenes/registrar.png"));
		menuProyecto.add(mnPedidos);

		mnRegistroDeConsumo = new JMenu("Registro de Consumo");
		mnRegistroDeConsumo.setIcon(new ImageIcon("imagenes/registro.png"));
		menuProyecto.add(mnRegistroDeConsumo);

		mntmRegistrarConsumo = new JMenuItem("Registrar Consumo");
		mntmRegistrarConsumo.addActionListener(this);
		mntmRegistrarConsumo.setIcon(new ImageIcon("imagenes/registro.png"));
		mnRegistroDeConsumo.add(mntmRegistrarConsumo);

		mnPago = new JMenu("Pago de Consumo");
		mnPago.setIcon(new ImageIcon("imagenes/control.png"));
		menuProyecto.add(mnPago);

		mntmRegistrarPago = new JMenuItem("Registrar Pago");
		mntmRegistrarPago.addActionListener(this);
		mntmRegistrarPago.setIcon(new ImageIcon("imagenes/control.png"));
		mnPago.add(mntmRegistrarPago);

		mntmRegistrarSugerencia = new JMenuItem("Registrar Sugerencia");
		mntmRegistrarSugerencia.addActionListener(this);
		mntmRegistrarSugerencia.setIcon(new ImageIcon("imagenes/pedido.png"));
		mnPago.add(mntmRegistrarSugerencia);

		mnReportes = new JMenu("Reportes");
		mnReportes.setIcon(new ImageIcon("imagenes/reportes.png"));
		menuProyecto.add(mnReportes);

		mntmAgregarPedido = new JMenuItem("Agregar Pedido");
		mntmAgregarPedido.addActionListener(this);
		mntmAgregarPedido.setIcon(new ImageIcon("imagenes/pedido.png"));
		mnPedidos.add(mntmAgregarPedido);

		mntmReportarUsuCli = new JMenuItem("Reportar Usuarios/Clientes");
		mntmReportarUsuCli.addActionListener(this);
		mntmReportarUsuCli.setIcon(new ImageIcon("imagenes/pedido.png"));
		mnReportes.add(mntmReportarUsuCli);

		mntmReportarCanciones = new JMenuItem("Reportar Canciones");
		mntmReportarCanciones.addActionListener(this);
		mntmReportarCanciones.setIcon(new ImageIcon("imagenes/pedido.png"));
		mnReportes.add(mntmReportarCanciones);

		mntmReportarUsuPed = new JMenuItem("Reportar Usuarios con más pedidos");
		mntmReportarUsuPed.addActionListener(this);
		mntmReportarUsuPed.setIcon(new ImageIcon("imagenes/pedido.png"));
		mnReportes.add(mntmReportarUsuPed);

		mntmReportarComSug = new JMenuItem("Reportar Comentarios/Sugerencias");
		mntmReportarComSug.addActionListener(this);
		mntmReportarComSug.setIcon(new ImageIcon("imagenes/pedido.png"));
		mnReportes.add(mntmReportarComSug);
		getContentPane().setLayout(null);

		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon("imagenes/fondo.jpg"));
		lblFondo.setBounds(0, 0, 984, 540);
		getContentPane().add(lblFondo);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == mntmRegistrarPago) {
			actionPerformedMntmRegistrarPago(arg0);
		}
		if (arg0.getSource() == mntmRegistrarConsumo) {
			actionPerformedMntmRegistrarConsumo(arg0);
		}
		if (arg0.getSource() == mntmRegistrarSugerencia) {
			actionPerformedMntmRegistrarSugerencia(arg0);
		}
		if (arg0.getSource() == mntmPedido) {
			actionPerformedMntmPedido(arg0);
		}
		if (arg0.getSource() == mntmPiqueos) {
			actionPerformedMntmPiqueos(arg0);
		}
		if (arg0.getSource() == mntmBebidas) {
			actionPerformedMntmBebidas(arg0);
		}
		if (arg0.getSource() == mntmArtista) {
			actionPerformedMntmArtista(arg0);
		}
		if (arg0.getSource() == mntmGenero) {
			actionPerformedMntmGenero(arg0);
		}
		if (arg0.getSource() == mntmCancion) {
			actionPerformedMntmCancion(arg0);
		}
		if (arg0.getSource() == mntmUsuario) {
			actionPerformedMntmUsuario(arg0);
		}
		if (arg0.getSource() == mntmCliente) {
			actionPerformedMntmCliente(arg0);
		}
		if (arg0.getSource() == mntmSalir) {
			actionPerformedMntmSalir(arg0);
		}
		if (arg0.getSource() == mntmReportarComSug) {
			actionPerformedMntmReportarComSug(arg0);
		}
		if (arg0.getSource() == mntmReportarUsuPed) {
			actionPerformedMntmReportarUsuPed(arg0);
		}
		if (arg0.getSource() == mntmReportarCanciones) {
			actionPerformedMntmReportarCanciones(arg0);
		}
		if (arg0.getSource() == mntmReportarUsuCli) {
			actionPerformedMntmReportarUsuCli(arg0);
		}
		if (arg0.getSource() == mntmAgregarPedido) {
			actionPerformedMntmAgregarPedido(arg0);
		}

	}

	protected void actionPerformedMntmSalir(ActionEvent arg0) {
		System.exit(0);
	}

	// Variable globlal para evaluar si la ventana cliente esta en ejecucion

	protected void actionPerformedMntmCliente(ActionEvent arg0) {
		DlgCliente dc = new DlgCliente();
		dc.setLocationRelativeTo(this);
		dc.setVisible(true);

	}

	protected void actionPerformedMntmUsuario(ActionEvent arg0) {
		DlgUsuario dc = new DlgUsuario();
		dc.setLocationRelativeTo(this);
		dc.setVisible(true);
	}

	protected void actionPerformedMntmCancion(ActionEvent arg0) {
		DlgCancion dc = new DlgCancion();
		dc.setLocationRelativeTo(this);
		dc.setVisible(true);
	}

	protected void actionPerformedMntmGenero(ActionEvent arg0) {
		DlgGenero dc = new DlgGenero();
		dc.setLocationRelativeTo(this);
		dc.setVisible(true);
	}

	protected void actionPerformedMntmArtista(ActionEvent arg0) {
		DlgArtista dc = new DlgArtista();
		dc.setLocationRelativeTo(this);
		dc.setVisible(true);

	}

	protected void actionPerformedMntmBebidas(ActionEvent arg0) {
		DlgBebida dc = new DlgBebida();
		dc.setLocationRelativeTo(this);
		dc.setVisible(true);

	}

	protected void actionPerformedMntmPiqueos(ActionEvent arg0) {
		DlgPiqueo dc = new DlgPiqueo();
		dc.setLocationRelativeTo(this);
		dc.setVisible(true);

	}

	protected void actionPerformedMntmAgregarPedido(ActionEvent arg0) {
		DlgRegistroPedido rp = new DlgRegistroPedido();
		rp.setLocationRelativeTo(this);
		rp.setVisible(true);
	}

	protected void actionPerformedMntmReportarUsuCli(ActionEvent arg0) {
		DlgReportarUsuCli uc = new DlgReportarUsuCli();
		uc.setLocationRelativeTo(this);
		uc.setVisible(true);
	}

	protected void actionPerformedMntmReportarCanciones(ActionEvent arg0) {
		DlgReportarCanciones rc = new DlgReportarCanciones();
		rc.setLocationRelativeTo(this);
		rc.setVisible(true);
	}

	protected void actionPerformedMntmReportarUsuPed(ActionEvent arg0) {
		DlgReporteUsuPedidos rup = new DlgReporteUsuPedidos();
		rup.setLocationRelativeTo(this);
		rup.setVisible(true);
	}

	protected void actionPerformedMntmReportarComSug(ActionEvent arg0) {
		DlgReporteComSug rcs = new DlgReporteComSug();
		rcs.setLocationRelativeTo(this);
		rcs.setVisible(true);
	}

	protected void actionPerformedMntmPedido(ActionEvent arg0) {
		DlgRegistroPedido rcs = new DlgRegistroPedido();
		rcs.setLocationRelativeTo(this);
		rcs.setVisible(true);
	}

	protected void actionPerformedMntmRegistrarSugerencia(ActionEvent arg0) {
		DlgSugerencia rcs = new DlgSugerencia();
		rcs.setLocationRelativeTo(this);
		rcs.setVisible(true);
	}

	protected void actionPerformedMntmRegistrarConsumo(ActionEvent arg0) {
		DlgRegistroConsumo rcs = new DlgRegistroConsumo();
		rcs.setLocationRelativeTo(this);
		rcs.setVisible(true);
	}

	protected void actionPerformedMntmRegistrarPago(ActionEvent arg0) {
		DlgPagoConsumo rcs = new DlgPagoConsumo();
		rcs.setLocationRelativeTo(this);
		rcs.setVisible(true);

	}
}
