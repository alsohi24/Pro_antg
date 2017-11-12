package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import arreglos.ArregloCancion;
import clases.Cancion;

import java.awt.SystemColor;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;

public class DlgCancion extends JDialog implements ActionListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblImagenCancion;
	private JLabel lblCodigo;
	private JLabel lblNombre;
	private JLabel lblDuracion;
	private JLabel lblArtista;
	private JLabel lblFechaDeRegistro;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtDuracion;
	public static JTextField txtArtista;
	private JTextField txtFechaRegistro;
	private JLabel lblNroDeReproducciones;
	private JLabel lblEstado;
	private JTextField txtNumeroReproducciones;
	private JComboBox<String> cboEstado;
	private JTextField txtEstado;
	private JButton btnAceptar;
	private JScrollPane scrollPane;
	private JTable tblCancion;
	private DefaultTableModel modelo;
	private JLabel lblAlbum;
	private JTextField txtAlbum;
	private JButton btnGrabar;
	public static JTextField txtArtistaNombre;
	private JButton btnBuscar;
	private JButton btnIngresarNuevo;
	private JButton btnCancelar;
	private JButton btnModificar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgCancion dialog = new DlgCancion();
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
	public DlgCancion() {
		getContentPane().setBackground(SystemColor.control);
		setTitle("Mantenimiento | Cancion");
		setBounds(100, 100, 1000, 600);
		getContentPane().setLayout(null);

		lblImagenCancion = new JLabel("Imagen Cancion");
		lblImagenCancion.setIcon(new ImageIcon("imagenes/DLGcancion1.png"));
		lblImagenCancion.setBounds(10, 11, 176, 166);
		getContentPane().add(lblImagenCancion);

		lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(209, 11, 87, 14);
		getContentPane().add(lblCodigo);

		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(209, 36, 87, 14);
		getContentPane().add(lblNombre);

		lblDuracion = new JLabel("Duracion");
		lblDuracion.setBounds(209, 61, 87, 14);
		getContentPane().add(lblDuracion);

		lblArtista = new JLabel("Artista");
		lblArtista.setBounds(209, 87, 87, 14);
		getContentPane().add(lblArtista);

		lblFechaDeRegistro = new JLabel("Fecha Registro");
		lblFechaDeRegistro.setBounds(518, 8, 78, 14);
		getContentPane().add(lblFechaDeRegistro);

		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(306, 8, 176, 20);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);

		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setBounds(306, 33, 176, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);

		txtDuracion = new JTextField();
		txtDuracion.setEditable(false);
		txtDuracion.setBounds(306, 58, 176, 20);
		getContentPane().add(txtDuracion);
		txtDuracion.setColumns(10);

		txtArtista = new JTextField();
		txtArtista.setEditable(false);
		txtArtista.setBounds(306, 84, 176, 20);
		getContentPane().add(txtArtista);
		txtArtista.setColumns(10);

		txtFechaRegistro = new JTextField();
		txtFechaRegistro.setEditable(false);
		txtFechaRegistro.setBounds(612, 5, 140, 20);
		getContentPane().add(txtFechaRegistro);
		txtFechaRegistro.setColumns(10);

		lblNroDeReproducciones = new JLabel("Nro. de Reprod.");
		lblNroDeReproducciones.setBounds(518, 33, 84, 14);
		getContentPane().add(lblNroDeReproducciones);

		lblEstado = new JLabel("Estado");
		lblEstado.setBounds(518, 58, 84, 14);
		getContentPane().add(lblEstado);

		txtNumeroReproducciones = new JTextField();
		txtNumeroReproducciones.setEditable(false);
		txtNumeroReproducciones.setBounds(612, 30, 140, 20);
		getContentPane().add(txtNumeroReproducciones);
		txtNumeroReproducciones.setColumns(10);

		cboEstado = new JComboBox<String>();
		cboEstado.addActionListener(this);
		cboEstado.setModel(new DefaultComboBoxModel<String>(new String[] { "0", "1" }));
		cboEstado.setBounds(612, 55, 44, 20);
		getContentPane().add(cboEstado);

		txtEstado = new JTextField();
		txtEstado.setEditable(false);
		txtEstado.setBounds(666, 55, 86, 20);
		getContentPane().add(txtEstado);
		txtEstado.setColumns(10);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(824, 7, 150, 23);
		getContentPane().add(btnAceptar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 187, 964, 363);
		getContentPane().add(scrollPane);

		tblCancion = new JTable();
		tblCancion.addMouseListener(this);
		tblCancion.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblCancion);

		modelo = new DefaultTableModel();
		modelo.addColumn("Codigo");
		modelo.addColumn("Nombre");
		modelo.addColumn("Duracion");
		modelo.addColumn("Artista");
		modelo.addColumn("Album");
		modelo.addColumn("Fecha Regis.");
		modelo.addColumn("Num. Reproduc.");
		modelo.addColumn("Estado");
		tblCancion.setModel(modelo);

		lblAlbum = new JLabel("Album");
		lblAlbum.setBounds(209, 137, 46, 14);
		getContentPane().add(lblAlbum);

		txtAlbum = new JTextField();
		txtAlbum.setEditable(false);
		txtAlbum.setBounds(306, 134, 176, 20);
		getContentPane().add(txtAlbum);
		txtAlbum.setColumns(10);

		txtEstado.setText("Habilitado");
		txtNumeroReproducciones.setText("0");

		btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(this);
		btnGrabar.setBounds(824, 153, 150, 23);
		getContentPane().add(btnGrabar);

		txtArtistaNombre = new JTextField();
		txtArtistaNombre.setEditable(false);
		txtArtistaNombre.setBounds(306, 109, 176, 20);
		getContentPane().add(txtArtistaNombre);
		txtArtistaNombre.setColumns(10);

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(518, 83, 89, 23);
		getContentPane().add(btnBuscar);

		btnIngresarNuevo = new JButton("Ingresar Nuevo");
		btnIngresarNuevo.addActionListener(this);
		btnIngresarNuevo.setBounds(824, 83, 150, 23);
		getContentPane().add(btnIngresarNuevo);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(824, 32, 150, 23);
		getContentPane().add(btnCancelar);

		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(824, 108, 150, 23);
		getContentPane().add(btnModificar);

		listar();// Para que al iniciar la ventana, ya muestre los datos
		ajustarAnchoColumnas();
		habilitarEntradas(false);
		editarFila();

	}

	ArregloCancion can = new ArregloCancion("Cancion.txt");

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == btnIngresarNuevo) {
			actionPerformedBtnIngresarNuevo(e);
		}
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
		if (e.getSource() == btnGrabar) {
			actionPerformedBtnCancion(e);
		}
		if (e.getSource() == cboEstado) {
			actionPerformedCboEstado(e);
		}
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnNuevaCancion(e);
		}
	}

	// BOTON: ACEPTAR
	protected void actionPerformedBtnNuevaCancion(ActionEvent e) {

		String codigo = correlativoCodigo();
		String nombre = leerNombre();
		if (nombre.length() > 0) {
			String duracion = leerDuracion();
			if (duracion.length() > 0) {
				String artista = leerArtista();
				if (artista.length() > 0) {
					String album = leerAlbum();
					if (album.length() > 0) {
						String Registro = leerRegistro();
						if (Registro.length() == 10) {
							try {
								int numeroRep = leerNumeroRep();
								if (numeroRep > 0) {
									int estado = leerEstado();
									if (btnIngresarNuevo.isEnabled() == false) {
										Cancion nuevo = new Cancion(codigo, nombre, duracion, artista, album, Registro,
												numeroRep, estado);
										can.adicionar(nuevo);
										limpieza();
										txtCodigo.setText("" + correlativoCodigo());
										txtNombre.requestFocus();
									}
									if (btnModificar.isEnabled() == false) {
										// Uso la posicion de la fila
										// seleccionada como
										// parametro para obtener la direccion
										// de
										// memoria del arreglo
										int posFila = tblCancion.getSelectedRow();
										Cancion x = can.obtener(posFila);
										x.setNombre(nombre);
										x.setDuracion(duracion);
										x.setIdArtista(artista);
										x.setFechaRegistro(Registro);
										x.setNumeroReproducciones(numeroRep);
										x.setEstado(estado);
										btnModificar.setEnabled(true);
										habilitarEntradas(false);
									}
									listar();
								}
								else {
									mensaje("Ingrese un valor mayor a cero");
									txtNumeroReproducciones.requestFocus();
								}
							}
							catch (Exception e1) {
								mensaje("Ingrese un valor numerico");
								txtNumeroReproducciones.requestFocus();
							}
						}
						else {
							mensaje("El formato de fecha debe ser dd/mm/aaaa");
							txtFechaRegistro.requestFocus();
						}
					}
					else {
						mensaje("Ingrese un Album Valido");
						txtAlbum.requestFocus();
					}
				}
				else {
					mensaje("Seleccione un Artista");
					btnBuscar.requestFocusInWindow();
				}
			}
			else {
				mensaje("Ingrese Duracion Valida");
				txtDuracion.requestFocus();
			}
		}
		else {
			mensaje("Ingrese un Nombre Valido");
			txtNombre.requestFocus();
		}
	}

	// BOTON: GRABAR
	protected void actionPerformedBtnCancion(ActionEvent e) {

		/**
		 * Actualiza el archivo
		 */
		if (can.existeArchivo()) {
			int ok = confirmar("¿ Desea actualizar \"" + can.getArchivo() + "\" ?");
			if (ok == 0) {
				can.grabarCancion();
				mensaje("\"" + can.getArchivo() + "\" ha sido actualizado");
			}
			else
				mensaje("No se actualizó  \"" + can.getArchivo() + "\"");
		}
		else {
			can.grabarCancion();
			mensaje("\"" + can.getArchivo() + "\" ha sido creado");
		}
		limpieza();
		habilitarEntradas(false);
		btnIngresarNuevo.setEnabled(true);
		btnModificar.setEnabled(true);
	}

	// BOTON: BUSCAR
	protected void actionPerformedBtnBuscar(ActionEvent e) {
		DlgListarArtista dc = new DlgListarArtista();
		dc.setLocationRelativeTo(this);
		dc.setVisible(true);

	}

	// BOTON: INGRESAR NUEVO
	protected void actionPerformedBtnIngresarNuevo(ActionEvent e) {
		limpieza();
		habilitarEntradas(true);
		txtNombre.requestFocus();
		txtCodigo.setText("" + correlativoCodigo());
		btnIngresarNuevo.setEnabled(false);
		btnModificar.setEnabled(true);

	}

	// BOTON: CANCELAR
	protected void actionPerformedBtnCancelar(ActionEvent e) {
		limpieza();
		habilitarEntradas(false);
		btnIngresarNuevo.setEnabled(true);
		btnModificar.setEnabled(true);
	}

	// BOTON: MODIFICAR
	protected void actionPerformedBtnModificar(ActionEvent e) {
		habilitarEntradas(true);
		txtNombre.requestFocus();
		btnIngresarNuevo.setEnabled(true);
		btnModificar.setEnabled(false);
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tblCancion) {
			mouseClickedTblCancion(e);
		}
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	// EVENTO CLICK EN LAS FILAS DE LA TABLA
	protected void mouseClickedTblCancion(MouseEvent e) {
		editarFila();
		habilitarEntradas(false);
		btnIngresarNuevo.setEnabled(true);
		btnModificar.setEnabled(true);
	}

	// ***********************************************************************

	private int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}

	private void ajustarAnchoColumnas() {
		TableColumnModel tcm = tblCancion.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(6)); // codigo
		tcm.getColumn(1).setPreferredWidth(anchoColumna(18)); // nombre
		tcm.getColumn(2).setPreferredWidth(anchoColumna(10)); // duracion
		tcm.getColumn(3).setPreferredWidth(anchoColumna(16)); // artista
		tcm.getColumn(4).setPreferredWidth(anchoColumna(14)); // album
		tcm.getColumn(5).setPreferredWidth(anchoColumna(12)); // fecha Regis
		tcm.getColumn(6).setPreferredWidth(anchoColumna(14)); // Num.
																// reproduciones
		tcm.getColumn(7).setPreferredWidth(anchoColumna(10)); // Estado
	}

	// Metodo Listar
	void listar() {

		// para que al iniciar el programa, se seleccione la fila 1
		int posFila = 0;
		if (modelo.getRowCount() > 0)
			posFila = tblCancion.getSelectedRow();
		if (modelo.getRowCount() == can.tamaño() - 1)
			posFila = can.tamaño() - 1;
		if (posFila == can.tamaño())
			posFila--;

		modelo.setRowCount(0);
		for (int i = 0; i < can.tamaño(); i++) {
			Object[] fila = { can.obtener(i).getIdCancion(), can.obtener(i).getNombre(), can.obtener(i).getDuracion(),
					can.obtener(i).getIdArtista(), can.obtener(i).getAlbum(), can.obtener(i).getFechaRegistro(),
					can.obtener(i).getNumeroReproducciones(), can.obtener(i).txtEstadoCancion(), };
			modelo.addRow(fila);
		}
		// primera fila

		if (can.tamaño() > 0)
			tblCancion.getSelectionModel().setSelectionInterval(posFila, posFila);
	}

	// Metodos tipo void sin parametros

	String leerNombre() {
		return txtNombre.getText().trim();
	}

	String leerDuracion() {
		return txtDuracion.getText().trim();
	}

	String leerArtista() {
		return txtArtistaNombre.getText().trim();
	}

	String leerAlbum() {
		return txtAlbum.getText().trim();
	}

	String leerRegistro() {
		return txtFechaRegistro.getText().trim();
	}

	int leerNumeroRep() {
		return Integer.parseInt(txtNumeroReproducciones.getText().trim());
	}

	int leerEstado() {
		return cboEstado.getSelectedIndex();
	}

	String correlativoCodigo() {
		int i = can.tamaño() + 1;
		if (i < 10)
			return ("Can100" + i);
		else
			return ("Can10" + i);
	}

	protected void actionPerformedCboEstado(ActionEvent e) {
		int x = cboEstado.getSelectedIndex();
		switch (x) {
			case 0:
				txtEstado.setText("Habilitado");
				break;
			default:
				txtEstado.setText("Inhabilitado");
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
		txtNombre.setEditable(sino);
		txtDuracion.setEditable(sino);
		txtAlbum.setEditable(sino);
		txtFechaRegistro.setEditable(sino);
		txtNumeroReproducciones.setEditable(sino);
		cboEstado.setEnabled(sino);
		btnBuscar.setEnabled(sino);
		btnAceptar.setEnabled(sino);
		btnCancelar.setEnabled(sino);

	}

	void limpieza() {
		txtCodigo.setText("");
		txtNombre.setText("");
		txtDuracion.setText("");
		txtArtista.setText("");
		txtArtistaNombre.setText("");
		txtAlbum.setText("");
		txtFechaRegistro.setText("");
		txtNumeroReproducciones.setText("0");
		cboEstado.setSelectedIndex(0);

	}

	void editarFila() {
		if (can.tamaño() == 0)
			limpieza();
		else {
			Cancion x = can.obtener(tblCancion.getSelectedRow());
			txtCodigo.setText("" + x.getIdCancion());
			txtNombre.setText(x.getNombre());
			txtDuracion.setText(x.getDuracion());
			txtAlbum.setText(x.getAlbum());
			txtFechaRegistro.setText(x.getFechaRegistro());
			txtNumeroReproducciones.setText(x.getNumeroReproducciones() + "");
			cboEstado.setSelectedIndex(x.getEstado());
			txtArtistaNombre.setText(x.getIdArtista());

		}
	}

}
