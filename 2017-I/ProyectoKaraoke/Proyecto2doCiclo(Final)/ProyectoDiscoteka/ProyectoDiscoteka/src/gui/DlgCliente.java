package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import arreglos.ArregloCliente;
import clases.Cliente;

import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;

public class DlgCliente extends JDialog implements ActionListener, MouseListener, WindowListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtTipoCliente;
	private JComboBox<String> cboTipoCliente;
	private JTextField txtTelefonoCliente;
	private JLabel lblTipoCliente;
	private JLabel lblTelefonoCliente;
	private JLabel lblEstadoCivilCliente;
	private JComboBox<Object> cboEstadoCivilCliente;
	private JTextField txtEstadoCivilCliente;
	private JTextField txtFecAfilCliente;
	private JLabel lblFecAfiCliente;
	private JLabel lblFecNacCliente;
	private JTextField txtFecNacCliente;
	private JLabel lblDireccionCliente;
	private JTextField txtDireccionCliente;
	private JLabel lblDNIcliente;
	private JTextField txtDniCliente;
	private JLabel lblApMCliente;
	private JTextField txtApMaternoCliente;
	private JLabel lblApPCliente;
	private JTextField txtApPaternoCliente;
	private JLabel lblNombreCliente;
	private JTextField txtNombreCliente;
	private JScrollPane scrollPane;
	private JButton btnAceptar;
	private JTable tblTablaClientes;
	private DefaultTableModel modelo;
	private JLabel lblUsuario;
	public static JTextField txtUsuario;
	public static JTextField txtUsuarioNombre;
	private JButton btnBuscar;
	private JButton btnIngresarNuevo;
	private JButton btnCancelar;
	private JButton btnModificar;
	private JButton btnGrabar;
	private JLabel lblCodigo;
	private JTextField txtCodigo;
	private JLabel lblImagenCliente;

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
					DlgCliente dialog = new DlgCliente();
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
	public DlgCliente() {
		addWindowListener(this);
		setTitle("Mantenimiento | Clientes");
		setBounds(100, 100, 1000, 600);
		getContentPane().setLayout(null);

		lblNombreCliente = new JLabel("Nombre");
		lblNombreCliente.setBounds(223, 34, 95, 14);
		getContentPane().add(lblNombreCliente);

		lblApPCliente = new JLabel("Ap. Paterno");
		lblApPCliente.setBounds(223, 59, 95, 14);
		getContentPane().add(lblApPCliente);

		lblApMCliente = new JLabel("Ap. Materno");
		lblApMCliente.setBounds(223, 84, 95, 14);
		getContentPane().add(lblApMCliente);

		lblDNIcliente = new JLabel("DNI");
		lblDNIcliente.setBounds(223, 109, 95, 14);
		getContentPane().add(lblDNIcliente);

		lblDireccionCliente = new JLabel("Direccion");
		lblDireccionCliente.setBounds(223, 131, 95, 14);
		getContentPane().add(lblDireccionCliente);

		lblFecNacCliente = new JLabel("Fec. Nacimiento");
		lblFecNacCliente.setBounds(514, 11, 95, 14);
		getContentPane().add(lblFecNacCliente);

		lblEstadoCivilCliente = new JLabel("Estado Civil");
		lblEstadoCivilCliente.setBounds(514, 61, 95, 14);
		getContentPane().add(lblEstadoCivilCliente);

		lblTelefonoCliente = new JLabel("Telefono");
		lblTelefonoCliente.setBounds(514, 86, 95, 14);
		getContentPane().add(lblTelefonoCliente);

		lblFecAfiCliente = new JLabel("Fec. Afiliacion");
		lblFecAfiCliente.setBounds(514, 36, 95, 14);
		getContentPane().add(lblFecAfiCliente);

		lblTipoCliente = new JLabel("Tipo Cliente");
		lblTipoCliente.setBounds(514, 111, 95, 14);
		getContentPane().add(lblTipoCliente);

		txtNombreCliente = new JTextField();
		txtNombreCliente.setColumns(10);
		txtNombreCliente.setBounds(328, 28, 176, 20);
		getContentPane().add(txtNombreCliente);

		txtApPaternoCliente = new JTextField();
		txtApPaternoCliente.setColumns(10);
		txtApPaternoCliente.setBounds(328, 53, 176, 20);
		getContentPane().add(txtApPaternoCliente);

		txtApMaternoCliente = new JTextField();
		txtApMaternoCliente.setColumns(10);
		txtApMaternoCliente.setBounds(328, 78, 176, 20);
		getContentPane().add(txtApMaternoCliente);

		txtDniCliente = new JTextField();
		txtDniCliente.setColumns(10);
		txtDniCliente.setBounds(328, 103, 176, 20);
		getContentPane().add(txtDniCliente);

		txtDireccionCliente = new JTextField();
		txtDireccionCliente.setColumns(10);
		txtDireccionCliente.setBounds(328, 128, 176, 20);
		getContentPane().add(txtDireccionCliente);

		txtFecNacCliente = new JTextField();
		txtFecNacCliente.setColumns(10);
		txtFecNacCliente.setBounds(619, 8, 176, 20);
		getContentPane().add(txtFecNacCliente);

		cboEstadoCivilCliente = new JComboBox<Object>();
		cboEstadoCivilCliente.addActionListener(this);
		cboEstadoCivilCliente.setModel(new DefaultComboBoxModel<Object>(new String[] { "S", "C", "V", "D", "N" }));
		cboEstadoCivilCliente.setToolTipText("");
		cboEstadoCivilCliente.setBounds(619, 58, 44, 20);
		getContentPane().add(cboEstadoCivilCliente);

		txtEstadoCivilCliente = new JTextField();
		txtEstadoCivilCliente.setEditable(false);
		txtEstadoCivilCliente.setColumns(10);
		txtEstadoCivilCliente.setBounds(673, 58, 122, 20);
		getContentPane().add(txtEstadoCivilCliente);

		txtTelefonoCliente = new JTextField();
		txtTelefonoCliente.setColumns(10);
		txtTelefonoCliente.setBounds(619, 83, 176, 20);
		getContentPane().add(txtTelefonoCliente);

		txtFecAfilCliente = new JTextField();
		txtFecAfilCliente.setColumns(10);
		txtFecAfilCliente.setBounds(619, 33, 176, 20);
		getContentPane().add(txtFecAfilCliente);

		cboTipoCliente = new JComboBox<String>();
		cboTipoCliente.addActionListener(this);
		cboTipoCliente.setModel(new DefaultComboBoxModel<String>(new String[] { "0", "1", "2", "3", "4" }));
		cboTipoCliente.setToolTipText("");
		cboTipoCliente.setBounds(619, 108, 44, 20);
		getContentPane().add(cboTipoCliente);

		txtTipoCliente = new JTextField();
		txtTipoCliente.setEditable(false);
		txtTipoCliente.setColumns(10);
		txtTipoCliente.setBounds(673, 108, 122, 20);
		getContentPane().add(txtTipoCliente);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 222, 964, 328);
		getContentPane().add(scrollPane);

		tblTablaClientes = new JTable();
		tblTablaClientes.addMouseListener(this);
		tblTablaClientes.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblTablaClientes);

		modelo = new DefaultTableModel();
		modelo.addColumn("Codigo");
		modelo.addColumn("Nombre");
		modelo.addColumn("Ap. Paterno");
		modelo.addColumn("Ap. Materno");
		modelo.addColumn("DNI");
		modelo.addColumn("Direccion");
		modelo.addColumn("Fec. Nac.");
		modelo.addColumn("Fec. Afil.");
		modelo.addColumn("Est. Civil");
		modelo.addColumn("Telefono");
		modelo.addColumn("Tipo Cliente");
		modelo.addColumn("Usuario");
		tblTablaClientes.setModel(modelo);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setEnabled(false);
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(823, 14, 150, 23);
		getContentPane().add(btnAceptar);

		txtEstadoCivilCliente.setText("Soltero");
		txtTipoCliente.setText("Estándar");

		btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(this);
		btnGrabar.setBounds(823, 179, 151, 23);
		getContentPane().add(btnGrabar);

		lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(223, 9, 95, 14);
		getContentPane().add(lblCodigo);

		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(328, 5, 176, 20);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);

		lblImagenCliente = new JLabel("");
		lblImagenCliente.setIcon(new ImageIcon("imagenes/DlgCliente2.png"));
		lblImagenCliente.setBounds(10, 11, 176, 166);
		getContentPane().add(lblImagenCliente);

		lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(223, 156, 95, 14);
		getContentPane().add(lblUsuario);

		txtUsuario = new JTextField();
		txtUsuario.setEditable(false);
		txtUsuario.setBounds(328, 154, 176, 20);
		getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);

		txtUsuarioNombre = new JTextField();
		txtUsuarioNombre.setEditable(false);
		txtUsuarioNombre.setBounds(328, 180, 176, 20);
		getContentPane().add(txtUsuarioNombre);
		txtUsuarioNombre.setColumns(10);

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(514, 152, 89, 23);
		getContentPane().add(btnBuscar);

		btnIngresarNuevo = new JButton("Ingresar Nuevo");
		btnIngresarNuevo.addActionListener(this);
		btnIngresarNuevo.setBounds(823, 105, 151, 23);
		getContentPane().add(btnIngresarNuevo);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(823, 42, 151, 23);
		getContentPane().add(btnCancelar);

		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(823, 131, 151, 23);
		getContentPane().add(btnModificar);

		ajustarAnchoColumnas();
		habilitarEntradas(false);
		listar();// Para que al iniciar la ventana, ya muestre los datos
		editarFila();
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnModificar) {
			actionPerformedBtnModificar(arg0);
		}
		if (arg0.getSource() == btnIngresarNuevo) {
			actionPerformedBtnIngresarnuevo(arg0);
		}
		if (arg0.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(arg0);
		}
		if (arg0.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(arg0);
		}
		if (arg0.getSource() == btnGrabar) {
			actionPerformedBtnGrabar(arg0);
		}

		if (arg0.getSource() == cboTipoCliente) {
			actionPerformedCboTipoCliente(arg0);
		}
		if (arg0.getSource() == cboEstadoCivilCliente) {
			actionPerformedCboEstadoCivilCliente(arg0);
		}
		if (arg0.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(arg0);
		}

	}

	ArregloCliente cli = new ArregloCliente("Clientes.txt");

	// BOTON: ACEPTAR
	protected void actionPerformedBtnAceptar(ActionEvent arg0) {

		String codigo = correlativoCodigo();
		String nombre = leerNombre();
		if (nombre.length() > 0) {
			String apPaterno = leerApPaterno();
			if (apPaterno.length() > 0) {
				String apMaterno = leerApMaterno();
				if (apMaterno.length() > 0) {
					String dni = leerdni();
					if (dni.length() == 8) {
						String direccion = leerdireccion();
						if (direccion.length() > 0) {
							String fecNac = leerfecNac();
							if (fecNac.length() == 10) {
								String fecAfi = leerAfi();
								if (fecAfi.length() == 10) {
									int tipoestadoCivil = leerEstadoCivil();
									String telefono = leertelefono();
									if (telefono.length() > 6) {
										int tipoCliente = leerTipocliente();
										String usuario = leerUsuario();
										if (usuario.length() > 0) {
											if (btnIngresarNuevo.isEnabled() == false) {
												Cliente nuevo = new Cliente(codigo, nombre, apPaterno, apMaterno,
														direccion, telefono, dni, fecNac, fecAfi, tipoestadoCivil,
														tipoCliente, usuario);

												cli.adicionar(nuevo);
												btnIngresarNuevo.setEnabled(true);
												limpieza();
												txtCodigo.setText("" + correlativoCodigo());
												txtNombreCliente.requestFocus();

											}

											if (btnModificar.isEnabled() == false) {
												// Uso la posicion de la fila
												// seleccionada como
												// parametro para obtener la
												// direccion de
												// memoria del arreglo
												int posFila = tblTablaClientes.getSelectedRow();
												Cliente x = cli.obtener(posFila);
												x.setNombre(nombre);
												x.setApPaterno(apPaterno);
												x.setApMaterno(apMaterno);
												x.setDireccion(direccion);
												x.setTelefono(telefono);
												x.setDni(dni);
												x.setFechaNacimiento(fecNac);
												x.setFechaAfiliacion(fecAfi);
												x.setEstadoCivil(tipoestadoCivil);
												x.setTipoDeCliente(tipoCliente);
												x.setUsuario(usuario);

												btnModificar.setEnabled(true);
												habilitarEntradas(false);

											}

											listar();
										} // ****************
										else {
											mensaje("Seleccione un Usuario");
											btnBuscar.requestFocusInWindow();
										}
									}
									else {
										mensaje("El Telefono debe tener 7 digitos como mínimo");
										txtTelefonoCliente.requestFocus();
									}
								}
								else {
									mensaje("El formato de fecha debe ser dd/mm/aaaa");
									txtFecAfilCliente.requestFocus();
								}
							}
							else {
								mensaje("El formato de fecha debe ser dd/mm/aaaa");
								txtFecNacCliente.requestFocus();
							}
						}
						else {
							mensaje("Ingrese una direccion Valida");
							txtDireccionCliente.requestFocus();
						}
					}
					else {
						mensaje("El DNI debe tener 8 digitos");
						txtDniCliente.requestFocus();
					}
				}
				else {
					mensaje("Ingrese un Apellido Valido");
					txtApMaternoCliente.requestFocus();
				}
			}
			else {
				mensaje("Ingrese un Apellido Valido");
				txtApPaternoCliente.requestFocus();
			}
		}
		else {
			mensaje("Ingrese un Nombre Valido");
			txtNombreCliente.requestFocus();
		}

	}

	// BOTON: BUSCAR
	protected void actionPerformedBtnBuscar(ActionEvent arg0) {
		DlgListarUsuario dc = new DlgListarUsuario();
		dc.setLocationRelativeTo(this);
		dc.setVisible(true);

	}

	// BOTON: GRABAR
	protected void actionPerformedBtnGrabar(ActionEvent arg0) {

		/**
		 * Actualiza el archivo
		 */
		if (cli.existeArchivo()) {
			int ok = confirmar("¿ Desea actualizar \"" + cli.getArchivo() + "\" ?");
			if (ok == 0) {
				cli.grabarCliente();
				mensaje("\"" + cli.getArchivo() + "\" ha sido actualizado");
			}
			else
				mensaje("No se actualizó  \"" + cli.getArchivo() + "\"");
		}
		else {
			cli.grabarCliente();
			mensaje("\"" + cli.getArchivo() + "\" ha sido creado");
		}
		limpieza();
		habilitarEntradas(false);
		btnIngresarNuevo.setEnabled(true);

	}

	// BOTON: INGRESAR NUEVO
	protected void actionPerformedBtnIngresarnuevo(ActionEvent arg0) {
		limpieza();
		habilitarEntradas(true);
		txtNombreCliente.requestFocus();
		txtCodigo.setText("" + correlativoCodigo());
		btnIngresarNuevo.setEnabled(false);
		btnModificar.setEnabled(true);
	}

	// BOTON: CANCELAR
	protected void actionPerformedBtnCancelar(ActionEvent arg0) {
		limpieza();
		habilitarEntradas(false);
		btnIngresarNuevo.setEnabled(true);
		btnModificar.setEnabled(true);
	}

	// BOTON: MODIFICAR
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		habilitarEntradas(true);
		txtNombreCliente.requestFocus();
		btnIngresarNuevo.setEnabled(true);
		btnModificar.setEnabled(false);
	}

	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == tblTablaClientes) {
			mouseClickedTblTablaClientes(arg0);
		}
	}

	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}

	public void mousePressed(MouseEvent arg0) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	// EVENTO CLICK EN LAS FILAS DE LA TABLA
	protected void mouseClickedTblTablaClientes(MouseEvent arg0) {
		editarFila();
		habilitarEntradas(false);
		btnIngresarNuevo.setEnabled(true);
		btnModificar.setEnabled(true);
	}

	// EVENTOS QUE OCURREN CON LA VENTANA DLGCLIENTE
	public void windowActivated(WindowEvent arg0) {
	}

	public void windowClosed(WindowEvent arg0) {
		if (arg0.getSource() == this) {
			windowClosedThis(arg0);
		}
	}

	public static int DlgClienteVisible;

	public void windowClosing(WindowEvent arg0) {
		DlgClienteVisible = 0;
		// al cerrar la ventana, esta variable global
		// toma el valor de cero, se usa para que la opcion de ListarUsuario
		// se pueda usar tanto con la venta cliente como con la ventana
		// sugerencias
	}

	public void windowDeactivated(WindowEvent arg0) {
	}

	public void windowDeiconified(WindowEvent arg0) {
	}

	public void windowIconified(WindowEvent arg0) {
	}

	public void windowOpened(WindowEvent arg0) {
		DlgClienteVisible = 1;
	}

	protected void windowClosedThis(WindowEvent arg0) {
	}

	// ***************************************************************************
	private int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}

	private void ajustarAnchoColumnas() {
		TableColumnModel tcm = tblTablaClientes.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(6)); // codigo
		tcm.getColumn(1).setPreferredWidth(anchoColumna(10)); // nombre
		tcm.getColumn(2).setPreferredWidth(anchoColumna(10)); // Paterno
		tcm.getColumn(3).setPreferredWidth(anchoColumna(10)); // Materno
		tcm.getColumn(4).setPreferredWidth(anchoColumna(6)); // DNI
		tcm.getColumn(5).setPreferredWidth(anchoColumna(10)); // Direccion
		tcm.getColumn(6).setPreferredWidth(anchoColumna(10)); // Fec. Nac.
		tcm.getColumn(7).setPreferredWidth(anchoColumna(10)); // Fec. Afil.
		tcm.getColumn(8).setPreferredWidth(anchoColumna(6)); // Est. Civil
		tcm.getColumn(9).setPreferredWidth(anchoColumna(8)); // Telefono
		tcm.getColumn(10).setPreferredWidth(anchoColumna(7)); // Tipo Cliente
		tcm.getColumn(11).setPreferredWidth(anchoColumna(7)); // Usuario

	}

	// Metodo Listar

	void listar() {
		// para que al iniciar el programa, se seleccione la fila 1

		int posFila = 0;
		if (modelo.getRowCount() > 0)
			posFila = tblTablaClientes.getSelectedRow();
		if (modelo.getRowCount() == cli.tamaño() - 1)
			posFila = cli.tamaño() - 1;
		if (posFila == cli.tamaño())
			posFila--;

		modelo.setRowCount(0);
		for (int i = 0; i < cli.tamaño(); i++) {
			Object[] fila = { cli.obtener(i).getCliente(), cli.obtener(i).getNombre(), cli.obtener(i).getApPateno(),
					cli.obtener(i).getApMaterno(), cli.obtener(i).getDni(), cli.obtener(i).getDireccion(),
					cli.obtener(i).getFechaDeNacimiento(), cli.obtener(i).getFechaDeAfiliacion(),
					cli.obtener(i).txtTipoEstadoCivil(), cli.obtener(i).getTelefono(), cli.obtener(i).txtTipoCliente(),
					cli.obtener(i).getUsuario() };
			modelo.addRow(fila);
		}

		// No sé para que es, pero completa el codigo para seleccionar la
		// primera fila

		if (cli.tamaño() > 0)
			tblTablaClientes.getSelectionModel().setSelectionInterval(posFila, posFila);

	}

	// Metodos tipo void sin parametros

	String correlativoCodigo() {
		int i = cli.tamaño() + 1;
		if (i < 10)
			return ("Cli000" + i);
		else
			return ("Cli00" + i);
	}

	String leerNombre() {
		return txtNombreCliente.getText().trim();
	}

	String leerApPaterno() {
		return txtApPaternoCliente.getText().trim();
	}

	String leerApMaterno() {
		return txtApMaternoCliente.getText().trim();

	}

	String leerdni() {
		return txtDniCliente.getText().trim();
	}

	String leerUsuario() {
		return txtUsuarioNombre.getText().trim();
	}

	String leerdireccion() {
		return txtDireccionCliente.getText().trim();
	}

	String leerfecNac() {
		return txtFecNacCliente.getText().trim();
	}

	String leerAfi() {
		return txtFecAfilCliente.getText().trim();
	}

	int leerEstadoCivil() {
		return cboEstadoCivilCliente.getSelectedIndex();
	}

	String leertelefono() {
		return txtTelefonoCliente.getText().trim();
	}

	int leerTipocliente() {
		return cboTipoCliente.getSelectedIndex();
	}

	protected void actionPerformedCboEstadoCivilCliente(ActionEvent arg0) {
		int x = cboEstadoCivilCliente.getSelectedIndex();
		switch (x) {
			case 0:
				txtEstadoCivilCliente.setText("Soltero");
				break;
			case 1:
				txtEstadoCivilCliente.setText("Casado");
				break;
			case 2:
				txtEstadoCivilCliente.setText("Viudo");
				break;
			case 3:
				txtEstadoCivilCliente.setText("Divorciado");
				break;
			default:
				txtEstadoCivilCliente.setText("No especifica");
				break;
		}
	}

	private void actionPerformedCboTipoCliente(ActionEvent arg0) {
		int x = cboTipoCliente.getSelectedIndex();
		switch (x) {
			case 0:
				txtTipoCliente.setText("Estandar");
				break;
			case 1:
				txtTipoCliente.setText("Bronce");
				break;
			case 2:
				txtTipoCliente.setText("Plata");
				break;
			case 3:
				txtTipoCliente.setText("Oro");
				break;
			default:
				txtTipoCliente.setText("Diamante");
				break;
		}
	}

	// Métodos que retornan valor con parámetros
	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s);
	}

	// Métodos tipo void con parámetros
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}

	void habilitarEntradas(boolean sino) {

		txtNombreCliente.setEditable(sino);
		txtApPaternoCliente.setEditable(sino);
		txtApMaternoCliente.setEditable(sino);
		txtDniCliente.setEditable(sino);
		txtDireccionCliente.setEditable(sino);
		txtFecNacCliente.setEditable(sino);
		txtFecAfilCliente.setEditable(sino);
		cboEstadoCivilCliente.setEnabled(sino);
		txtTelefonoCliente.setEditable(sino);
		cboTipoCliente.setEnabled(sino);
		btnAceptar.setEnabled(sino);
		btnBuscar.setEnabled(sino);
		btnCancelar.setEnabled(sino);

	}

	void limpieza() {
		txtCodigo.setText("");
		txtNombreCliente.setText("");
		txtApPaternoCliente.setText("");
		txtApMaternoCliente.setText("");
		txtDniCliente.setText("");
		txtDireccionCliente.setText("");
		txtFecNacCliente.setText("");
		txtFecAfilCliente.setText("0");
		cboEstadoCivilCliente.setSelectedIndex(0);
		txtTelefonoCliente.setText("0");
		cboTipoCliente.setSelectedIndex(0);
		txtUsuario.setText("");
		txtUsuarioNombre.setText("");

	}

	void editarFila() {
		if (cli.tamaño() == 0)
			limpieza();
		else {
			Cliente x = cli.obtener(tblTablaClientes.getSelectedRow());
			txtCodigo.setText(x.getCliente());
			txtNombreCliente.setText(x.getNombre());
			txtApPaternoCliente.setText(x.getApPateno());
			txtApMaternoCliente.setText(x.getApMaterno());
			txtDniCliente.setText(x.getDni());
			txtDireccionCliente.setText(x.getDireccion());
			txtFecNacCliente.setText(x.getFechaDeNacimiento());
			txtFecAfilCliente.setText(x.getFechaDeAfiliacion());
			txtDireccionCliente.setText(x.getDireccion());
			cboEstadoCivilCliente.setSelectedIndex(x.getTipoEstadoCivil());
			txtTelefonoCliente.setText(x.getTelefono());
			cboTipoCliente.setSelectedIndex(x.getTipoDeCliente());

		}
	}

}
