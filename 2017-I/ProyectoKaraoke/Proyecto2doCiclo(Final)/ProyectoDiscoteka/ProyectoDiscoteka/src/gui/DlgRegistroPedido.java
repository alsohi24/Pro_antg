package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import arreglos.ArregloRegistroPedido;
import clases.RegistroPedido;
import java.awt.Insets;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;

public class DlgRegistroPedido extends JDialog implements ActionListener, ItemListener, MouseListener, WindowListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblCodigo;
	private JLabel lblNombres;
	private JLabel lblApellidoPaterno;
	private JLabel lblApellidoMaterno;
	public static JTextField txtCodigoCliente;
	public static JTextField txtCancion;
	private JTextField txtCodigoReserva;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JButton btn_bebidas;
	private JScrollPane scrollPane;
	private JTable tblUsuario;
	private DefaultTableModel modelo;
	private JLabel lblimagenUsuario;
	private JButton btnPiqueos;
	private JButton btnBuscar;
	private JButton btnNuevoCliente;
	private JComboBox<Object> cboEstadoReserva;
	public static JTextField txtBebidas;
	public static JTextField txtPiqueos;
	private JScrollPane scrollPane_1;
	private JTextField txtReserva;
	private JButton btnGrabar;
	private JButton btnIngresarNuevo;
	private JButton btnModificar;
	private JLabel lblSelecione;
	private JLabel lblSeleccionePiqueo;
	private JLabel lblUsuario;
	public static JTextField txtUsuario;
	public static JTextField txtNombreUsuario;
	private JButton btnBuscarUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgRegistroPedido dialog = new DlgRegistroPedido();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public DlgRegistroPedido() {
		addWindowListener(this);
		setTitle("Registro Pedido");
		setBounds(100, 100, 1000, 600);
		getContentPane().setLayout(null);

		lblimagenUsuario = new JLabel("");
		lblimagenUsuario.setBounds(10, 10, 176, 166);
		lblimagenUsuario.setBackground(Color.GRAY);
		lblimagenUsuario.setIcon(new ImageIcon("imagenes/DLGusuario1.png"));
		getContentPane().add(lblimagenUsuario);

		lblCodigo = new JLabel("Codigo de Cliente");
		lblCodigo.setBounds(213, 84, 102, 14);
		getContentPane().add(lblCodigo);

		lblNombres = new JLabel("Nombre de Cancion");
		lblNombres.setBounds(213, 168, 102, 14);
		getContentPane().add(lblNombres);

		lblApellidoPaterno = new JLabel("C\u00F3digo de Reserva");
		lblApellidoPaterno.setBounds(215, 13, 102, 14);
		getContentPane().add(lblApellidoPaterno);

		lblApellidoMaterno = new JLabel("Reserva");
		lblApellidoMaterno.setBounds(215, 41, 102, 14);
		getContentPane().add(lblApellidoMaterno);

		txtCodigoCliente = new JTextField();
		txtCodigoCliente.setEditable(false);
		txtCodigoCliente.addMouseListener(this);
		txtCodigoCliente.setEnabled(false);
		txtCodigoCliente.addActionListener(this);
		txtCodigoCliente.setBounds(327, 81, 89, 20);
		getContentPane().add(txtCodigoCliente);
		txtCodigoCliente.setColumns(10);

		txtCancion = new JTextField();
		txtCancion.setEditable(false);
		txtCancion.setEnabled(false);
		txtCancion.setBounds(327, 165, 89, 20);
		getContentPane().add(txtCancion);
		txtCancion.setColumns(10);

		txtCodigoReserva = new JTextField();
		txtCodigoReserva.setEditable(false);
		txtCodigoReserva.setBounds(327, 10, 89, 20);
		getContentPane().add(txtCodigoReserva);
		txtCodigoReserva.setColumns(10);
		txtCodigoReserva.setText(" " + correlativoCodigo());

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(824, 7, 150, 23);
		btnAceptar.addActionListener(this);
		getContentPane().add(btnAceptar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(824, 32, 150, 23);
		getContentPane().add(btnCancelar);

		btn_bebidas = new JButton("Bebidas");
		btn_bebidas.setBounds(660, 11, 101, 23);
		btn_bebidas.addActionListener(this);
		getContentPane().add(btn_bebidas);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 213, 964, 326);
		getContentPane().add(scrollPane);

		tblUsuario = new JTable();
		tblUsuario.addMouseListener(this);
		tblUsuario.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblUsuario);

		modelo = new DefaultTableModel();
		modelo.addColumn("Código Reserva");
		modelo.addColumn("Código Cliente");
		modelo.addColumn("Código Usuario");
		modelo.addColumn("Canción");
		modelo.addColumn("Bebidas");
		modelo.addColumn("Piqueos");
		modelo.addColumn("Estado Reserva");
		tblUsuario.setModel(modelo);

		btnPiqueos = new JButton("Piqueos");
		btnPiqueos.addActionListener(this);
		btnPiqueos.setBounds(660, 80, 101, 23);
		getContentPane().add(btnPiqueos);

		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(435, 164, 101, 23);
		btnBuscar.addActionListener(this);
		getContentPane().add(btnBuscar);

		btnNuevoCliente = new JButton("Nuevo Cliente");
		btnNuevoCliente.setBounds(435, 80, 101, 23);
		btnNuevoCliente.addActionListener(this);
		btnNuevoCliente.setMargin(new Insets(2, 3, 2, 3));
		getContentPane().add(btnNuevoCliente);

		cboEstadoReserva = new JComboBox<Object>();
		cboEstadoReserva.addItemListener(this);
		cboEstadoReserva.setBounds(327, 38, 89, 20);
		cboEstadoReserva.setModel(new DefaultComboBoxModel<Object>(new String[] { "1", "0" }));
		getContentPane().add(cboEstadoReserva);

		txtBebidas = new JTextField();
		txtBebidas.setEditable(false);
		txtBebidas.setBounds(660, 38, 101, 20);
		getContentPane().add(txtBebidas);
		txtBebidas.setColumns(10);

		txtPiqueos = new JTextField();
		txtPiqueos.setEditable(false);
		txtPiqueos.setBounds(660, 106, 101, 20);
		getContentPane().add(txtPiqueos);
		txtPiqueos.setColumns(10);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(396, 492, 2, 2);
		getContentPane().add(scrollPane_1);

		txtReserva = new JTextField();
		txtReserva.setEditable(false);
		txtReserva.setBounds(435, 38, 101, 20);
		getContentPane().add(txtReserva);
		txtReserva.setColumns(10);
		txtReserva.setText("Libre");

		btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(this);
		btnGrabar.setBounds(824, 164, 150, 23);
		getContentPane().add(btnGrabar);

		btnIngresarNuevo = new JButton("Ingresar Nuevo");
		btnIngresarNuevo.addActionListener(this);
		btnIngresarNuevo.setBounds(824, 104, 150, 23);
		getContentPane().add(btnIngresarNuevo);

		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(824, 130, 150, 23);
		getContentPane().add(btnModificar);

		lblSelecione = new JLabel("Selecione Bebida");
		lblSelecione.setBounds(561, 13, 89, 14);
		getContentPane().add(lblSelecione);

		lblSeleccionePiqueo = new JLabel("Seleccione Piqueo");
		lblSeleccionePiqueo.setBounds(561, 84, 89, 14);
		getContentPane().add(lblSeleccionePiqueo);

		lblUsuario = new JLabel("Codigo Usuario");
		lblUsuario.setBounds(213, 113, 102, 14);
		getContentPane().add(lblUsuario);

		txtUsuario = new JTextField();
		txtUsuario.setEditable(false);
		txtUsuario.setBounds(327, 110, 89, 20);
		getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);

		txtNombreUsuario = new JTextField();
		txtNombreUsuario.setEditable(false);
		txtNombreUsuario.setBounds(327, 133, 89, 20);
		getContentPane().add(txtNombreUsuario);
		txtNombreUsuario.setColumns(10);

		btnBuscarUsuario = new JButton("Buscar");
		btnBuscarUsuario.addActionListener(this);
		btnBuscarUsuario.setEnabled(false);
		btnBuscarUsuario.setBounds(435, 109, 101, 23);
		getContentPane().add(btnBuscarUsuario);

		listarRegistroPedido();// Para que al iniciar la ventana, ya muestre los
								// datos
		// ajustarAnchoColumnas();
		habilitarEntradas(false);
		editarFila();

	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnBuscarUsuario) {
			actionPerformedBtnBuscarUsuario(arg0);
		}
		if (arg0.getSource() == btnIngresarNuevo) {
			actionPerformedBtnIngresarNuevo(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			actionPerformedBtnModificar(arg0);
		}
		if (arg0.getSource() == btnGrabar) {
			actionPerformedBtnGrabar(arg0);
		}
		if (arg0.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(arg0);
		}
		if (arg0.getSource() == btnPiqueos) {
			actionPerformedBtnPiqueos(arg0);
		}
		if (arg0.getSource() == btnBuscar) {
			actionPerformedBtnBuscar_Cancion(arg0);
		}
		if (arg0.getSource() == btnNuevoCliente) {
			actionPerformedBtnNuevoCliente(arg0);
		}
		if (arg0.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(arg0);
		}
		if (arg0.getSource() == btn_bebidas) {
			actionPerformedBtnBebidas(arg0);
		}
	}

	ArregloRegistroPedido registro = new ArregloRegistroPedido("RegistroPedido.txt");

	// BOTON: BUSCAR BEBIDAS
	protected void actionPerformedBtnBebidas(ActionEvent arg0) {
		DlgListarBebidas lb = new DlgListarBebidas();
		lb.setLocationRelativeTo(this);
		lb.setVisible(true);
	}

	// BOTON: NUEVO CLIENTE
	protected void actionPerformedBtnNuevoCliente(ActionEvent arg0) {
		DlgCliente dc = new DlgCliente();
		dc.setLocationRelativeTo(this);
		dc.setVisible(true);
	}

	// BOTON: BUSCAR CANCION
	protected void actionPerformedBtnBuscar_Cancion(ActionEvent arg0) {
		DlgListarCancion lc = new DlgListarCancion();
		lc.setLocationRelativeTo(this);
		lc.setVisible(true);
	}

	// BOTON: BUSCAR PIQUEOS
	protected void actionPerformedBtnPiqueos(ActionEvent arg0) {
		DlgListarPiqueos lp = new DlgListarPiqueos();
		lp.setLocationRelativeTo(this);
		lp.setVisible(true);
	}

	// BOTON: ACEPTAR
	protected void actionPerformedBtnAceptar(ActionEvent arg0) {
		String codigoRe = correlativoCodigo();
		String codigoCli = leerCodigoCliente();
		if (codigoCli.length() > 0) {
			String codigoUsuario = leerCodigoUsuario();
			if (codigoUsuario.length() > 0) {
				String cancion = leerCancion();
				if (cancion.length() > 0) {
					String bebidas = leerBebidas();
					if (bebidas.length() > 0) {
						String piqueos = leerPiqueos();
						if (piqueos.length() > 0) {
							int estadoReserva = leerEstadoReserva();
							if (btnIngresarNuevo.isEnabled() == false) {
								RegistroPedido nuevo = new RegistroPedido(codigoRe, codigoCli, codigoUsuario, cancion,
										bebidas, piqueos, estadoReserva);
								registro.adicionar(nuevo);
							}

							if (btnModificar.isEnabled() == false) {
								// Uso la posicion de la fila
								// seleccionada como
								// parametro para obtener la direccion
								// de
								// memoria del arreglo
								int posFila = tblUsuario.getSelectedRow();
								RegistroPedido x = registro.obtener(posFila);
								x.setCodigoCliente(codigoCli);
								x.setCodigoUsuario(codigoUsuario);
								x.setCancion(cancion);
								x.setBebidas(bebidas);
								x.setPiqueos(piqueos);
								x.setEstadoReserva(estadoReserva);
								btnModificar.setEnabled(true);
								habilitarEntradas(false);
							}

							listarRegistroPedido();
						}
						else {
							mensaje("Seleccione un Piqueo");
							btnPiqueos.requestFocusInWindow();
						}
					}
					else {
						mensaje("Seleccione una Bebidas");
						btn_bebidas.requestFocusInWindow();
					}
				}
				else {
					mensaje("Seleccione una Cancion");
					btnBuscar.requestFocusInWindow();
				}
			}
			else {
				mensaje("Seleccione un Usuario");
				btnBuscarUsuario.requestFocusInWindow();
			}

		}
		else {
			mensaje("Seleccione un Cliente");
			txtCodigoCliente.setText("Click aqui");
		}
	}

	// BOTON: GRABAR
	protected void actionPerformedBtnGrabar(ActionEvent arg0) {
		/**
		 * Actualiza el archivo
		 */
		if (registro.existeArchivo()) {
			int ok = confirmar("¿ Desea actualizar \"" + registro.getArchivo() + "\" ?");
			if (ok == 0) {
				registro.grabarRegistroPedido();
				mensaje("\"" + registro.getArchivo() + "\" ha sido actualizado");
			}
			else
				mensaje("No se actualizó  \"" + registro.getArchivo() + "\"");
		}
		else {
			registro.grabarRegistroPedido();
			mensaje("\"" + registro.getArchivo() + "\" ha sido creado");
		}
		limpieza();
		habilitarEntradas(false);
		btnAceptar.setEnabled(true);
	}

	// BOTON: MODIFICAR
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		habilitarEntradas(true);
		btnIngresarNuevo.setEnabled(true);
		btnModificar.setEnabled(false);
	}

	// BOTON: INGRESAR NUEVO
	protected void actionPerformedBtnIngresarNuevo(ActionEvent arg0) {
		limpieza();
		habilitarEntradas(true);
		// txtCodigoCliente.setText("click aqui");
		txtCodigoReserva.setText("" + correlativoCodigo());
		btnIngresarNuevo.setEnabled(false);
		btnModificar.setEnabled(true);

	}

	// BOTON: CANCELAR
	protected void actionPerformedBtnCancelar(ActionEvent arg0) {
		limpieza();
		habilitarEntradas(false);
		btnIngresarNuevo.setEnabled(true);
		btnModificar.setEnabled(true);
		editarFila();
	}

	// BOTON: BUSCAR USUARIO
	protected void actionPerformedBtnBuscarUsuario(ActionEvent arg0) {
		DlgListarUsuario lc = new DlgListarUsuario();
		lc.setLocationRelativeTo(this);
		lc.setVisible(true);
	}

	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == tblUsuario) {
			mouseClickedTblUsuario(arg0);
		}
		if (arg0.getSource() == txtCodigoCliente) {
			mouseClickedTxtCodigoCliente(arg0);
		}
	}

	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}

	public void mousePressed(MouseEvent arg0) {
	}

	public void mouseReleased(MouseEvent arg0) {
	}

	// EVENTO CLICK EN LA CASILLA DEL CLIENTE
	protected void mouseClickedTxtCodigoCliente(MouseEvent arg0) {
		DlgListarCodigoCliente lc = new DlgListarCodigoCliente();
		lc.setVisible(true);
		lc.setLocationRelativeTo(this);
	}

	// EVENTO CLICK EN LA TABLA REGISTROS
	protected void mouseClickedTblUsuario(MouseEvent arg0) {
		editarFila();
		habilitarEntradas(false);
		btnIngresarNuevo.setEnabled(true);
		btnModificar.setEnabled(true);
	}

	public void windowActivated(WindowEvent e) {
		if (e.getSource() == this) {
			windowActivatedThis(e);
		}
	}

	public static int DlgPedidoVisible;

	public void windowClosed(WindowEvent e) {
		DlgPedidoVisible = 0;
		// al cerrar la ventana, esta variable global
		// toma el valor de cero, se usa para que la opcion de ListarUsuario
		// se pueda usar tanto con la venta cliente como con la ventana
		// sugerencias
	}

	public void windowClosing(WindowEvent e) {
	}

	public void windowDeactivated(WindowEvent e) {
	}

	public void windowDeiconified(WindowEvent e) {
	}

	public void windowIconified(WindowEvent e) {
	}

	public void windowOpened(WindowEvent e) {
		DlgPedidoVisible = 1;
	}

	protected void windowActivatedThis(WindowEvent e) {
	}

	// ********************************************************************************
	// ********************************************************************************

	// Metodo Listar

	void listarRegistroPedido() {

		// para que al iniciar el programa, se seleccione la fila 1
		int posFila = 0;
		if (modelo.getRowCount() > 0)
			posFila = tblUsuario.getSelectedRow();
		if (modelo.getRowCount() == registro.tamaño() - 1)
			posFila = registro.tamaño() - 1;
		if (posFila == registro.tamaño())
			posFila--;

		modelo.setRowCount(0);
		for (int i = 0; i < registro.tamaño(); i++) {
			Object[] fila = { registro.obtener(i).getCodigoReserva(), registro.obtener(i).getCodigoCliente(),
					registro.obtener(i).getCodigoUsuario(), registro.obtener(i).getCancion(),
					registro.obtener(i).getBebidas(), registro.obtener(i).getPiqueos(),
					registro.obtener(i).txtEstadoReserva() };
			modelo.addRow(fila);
		}
		// primera fila

		if (registro.tamaño() > 0)
			tblUsuario.getSelectionModel().setSelectionInterval(posFila, posFila);

	}

	public void itemStateChanged(ItemEvent arg0) {
		if (arg0.getSource() == cboEstadoReserva) {
			itemStateChangedCboEstadoReserva(arg0);
		}
	}

	protected void itemStateChangedCboEstadoReserva(ItemEvent arg0) {
		int codigo;
		codigo = cboEstadoReserva.getSelectedIndex();
		switch (codigo) {
			case 0:
				txtReserva.setText("Libre");
				break;
			default:
				txtReserva.setText("Reservado");
		}
	}

	// Metodos tipo void sin parametros

	String leerCodigoCliente() {
		return txtCodigoCliente.getText().trim();
	}

	String leerCodigoUsuario() {
		return txtUsuario.getText().trim();
	}

	String leerCancion() {
		return txtCancion.getText().trim();
	}

	String leerBebidas() {
		return txtBebidas.getText().trim();
	}

	String leerPiqueos() {
		return txtPiqueos.getText().trim();
	}

	int leerEstadoReserva() {
		return cboEstadoReserva.getSelectedIndex();
	}

	String correlativoCodigo() {
		int i = registro.tamaño() + 1;
		if (i < 10)
			return ("Res100" + i);
		else
			return ("Res10" + i);
	}

	// Métodos que retornan valor con parámetros
	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s);
	}

	// Métodos tipo void con parámetros
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}

	void limpieza() {
		txtCodigoCliente.setText("");
		txtUsuario.setText("");
		txtCancion.setText("");
		txtBebidas.setText("");
		txtPiqueos.setText("");
		txtReserva.setText("Libre");
		cboEstadoReserva.setSelectedIndex(0);
	}

	void habilitarEntradas(boolean sino) {

		txtCodigoCliente.setEnabled(sino);
		txtUsuario.setEnabled(sino);
		txtCancion.setEnabled(sino);
		txtBebidas.setEnabled(sino);
		txtPiqueos.setEnabled(sino);
		txtReserva.setEnabled(sino);
		cboEstadoReserva.setEnabled(sino);
		btnBuscar.setEnabled(sino);
		btnAceptar.setEnabled(sino);
		btnCancelar.setEnabled(sino);
		btn_bebidas.setEnabled(sino);
		btnNuevoCliente.setEnabled(sino);
		btnPiqueos.setEnabled(sino);
		btnBuscarUsuario.setEnabled(sino);

	}

	void editarFila() {

		if (registro.tamaño() == 0)
			limpieza();
		else {
			RegistroPedido x = registro.obtener(tblUsuario.getSelectedRow());

			txtCodigoReserva.setText("" + x.getCodigoReserva());
			txtCodigoCliente.setText(x.getCodigoCliente());
			txtUsuario.setText(x.getCodigoCliente());
			txtCancion.setText(x.getCancion());
			txtBebidas.setText(x.getBebidas());
			txtPiqueos.setText(x.getPiqueos());

		}

	}

}
