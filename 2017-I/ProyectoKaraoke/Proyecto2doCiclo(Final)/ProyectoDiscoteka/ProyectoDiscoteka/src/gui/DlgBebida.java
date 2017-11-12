package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import arreglos.ArregloBebida;

import clases.Bebida;
import javax.swing.UIManager;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class DlgBebida extends JDialog implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblImagenbebida;
	private JLabel lblCodigo;
	private JLabel lblNombre;
	private JLabel lblTipo;
	private JLabel lblMarca;
	private JLabel lblPrecio;
	private JLabel lblEstado;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JComboBox<String> cboTipoBebida;
	private JTextField txtTipoBebida;
	private JTextField txtMarca;
	private JTextField txtPrecio;
	private JComboBox<String> cboEstadoBebida;
	private JTextField txtEstado;
	private JButton btnAceptar;
	private JButton btnModificar;
	private JButton btnGrabar;
	private JScrollPane scrollPane;
	private JTable tblBebida;
	private DefaultTableModel modelo;
	private JButton btnCancelar;
	private JButton btnIngresarNuevo;

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
					DlgBebida dialog = new DlgBebida();
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
	public DlgBebida() {
		setTitle("Mantenimiento | Bebidas");
		setBounds(100, 100, 1000, 600);
		getContentPane().setLayout(null);

		lblImagenbebida = new JLabel("");
		lblImagenbebida.setIcon(new ImageIcon("imagenes/DlgBebida.png"));
		lblImagenbebida.setBounds(10, 11, 176, 166);
		getContentPane().add(lblImagenbebida);

		lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(196, 11, 115, 14);
		getContentPane().add(lblCodigo);

		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(196, 36, 115, 14);
		getContentPane().add(lblNombre);

		lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(196, 61, 115, 14);
		getContentPane().add(lblTipo);

		lblMarca = new JLabel("Marca");
		lblMarca.setBounds(196, 86, 115, 14);
		getContentPane().add(lblMarca);

		lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(196, 111, 115, 14);
		getContentPane().add(lblPrecio);

		lblEstado = new JLabel("Estado");
		lblEstado.setBounds(196, 136, 115, 14);
		getContentPane().add(lblEstado);

		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(321, 8, 176, 20);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);

		txtNombre = new JTextField();
		txtNombre.setBounds(321, 33, 176, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);

		cboTipoBebida = new JComboBox<String>();
		cboTipoBebida.addActionListener(this);
		cboTipoBebida
				.setModel(new DefaultComboBoxModel<String>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7" }));
		cboTipoBebida.setBounds(321, 58, 44, 20);
		getContentPane().add(cboTipoBebida);

		txtTipoBebida = new JTextField();
		txtTipoBebida.setEditable(false);
		txtTipoBebida.setBounds(375, 58, 122, 20);
		getContentPane().add(txtTipoBebida);
		txtTipoBebida.setColumns(10);

		txtMarca = new JTextField();
		txtMarca.setBounds(321, 83, 176, 20);
		getContentPane().add(txtMarca);
		txtMarca.setColumns(10);

		txtPrecio = new JTextField();
		txtPrecio.setBounds(321, 108, 176, 20);
		getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);

		cboEstadoBebida = new JComboBox<String>();
		cboEstadoBebida.addActionListener(this);
		cboEstadoBebida.setModel(new DefaultComboBoxModel<String>(new String[] { "0", "1" }));
		cboEstadoBebida.setBounds(321, 133, 44, 20);
		getContentPane().add(cboEstadoBebida);

		txtEstado = new JTextField();
		txtEstado.setEditable(false);
		txtEstado.setBounds(375, 133, 122, 20);
		getContentPane().add(txtEstado);
		txtEstado.setColumns(10);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(824, 11, 150, 23);
		getContentPane().add(btnAceptar);

		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(824, 107, 150, 23);
		getContentPane().add(btnModificar);

		btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(this);
		btnGrabar.setBounds(824, 154, 150, 23);
		getContentPane().add(btnGrabar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 191, 964, 359);
		getContentPane().add(scrollPane);

		tblBebida = new JTable();
		tblBebida.addMouseListener(this);
		tblBebida.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblBebida);

		modelo = new DefaultTableModel();
		modelo.addColumn("Codigo");
		modelo.addColumn("Nombre");
		modelo.addColumn("Marca");
		modelo.addColumn("Tipo");
		modelo.addColumn("Estado");
		modelo.addColumn("Precio");
		tblBebida.setModel(modelo);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(824, 36, 150, 23);
		getContentPane().add(btnCancelar);

		btnIngresarNuevo = new JButton("Ingresar Nuevo");
		btnIngresarNuevo.addActionListener(this);
		btnIngresarNuevo.setBounds(824, 82, 150, 23);
		getContentPane().add(btnIngresarNuevo);

		txtTipoBebida.setText("Cerveza");// Valores por defecto
		txtEstado.setText("Habilitado");// Valores por defecto
		txtPrecio.setText("0.00");// Valores por defecto

		habilitarEntradas(false);
		listar();// Para que al iniciar la ventana, ya muestre los datos
		editarFila();
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(arg0);
		}
		if (arg0.getSource() == btnIngresarNuevo) {
			actionPerformedBtnIngresarNuevo(arg0);
		}
		if (arg0.getSource() == cboEstadoBebida) {
			actionPerformedCboEstadoBebida(arg0);
		}
		if (arg0.getSource() == cboTipoBebida) {
			actionPerformedCboTipoBebida(arg0);
		}
		if (arg0.getSource() == btnGrabar) {
			actionPerformedBtnGrabar(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			actionPerformedBtnModificarBebida(arg0);
		}
		if (arg0.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(arg0);
		}
	}

	// *************************************************************
	ArregloBebida beb = new ArregloBebida("Bebidas.txt");

	// *************************************************************

	// BOTON: ACEPTAR
	protected void actionPerformedBtnAceptar(ActionEvent arg0) {
		String codigo = correlativoCodigo();
		String nombre = leerNombre();
		if (nombre.length() > 0) {
			String marca = leerMarca();
			if (marca.length() > 0) {
				int tipoBebida = leerTipoBebida();
				int estado = leerEstado();
				try {
					double precio = leerPrecio();
					if (precio > 0.0) {
						if (btnIngresarNuevo.isEnabled() == false) {
							Bebida nuevo = new Bebida(codigo, nombre, marca, tipoBebida, estado, precio);

							beb.adicionar(nuevo);
							btnIngresarNuevo.setEnabled(true);
							limpieza();
							txtCodigo.setText("" + correlativoCodigo());
							txtNombre.requestFocus();
						}
						if (btnModificar.isEnabled() == false) {
							// Uso la posicion de la fila seleccionada como
							// parametro para obtener la direccion de
							// memoria del arreglo
							int posFila = tblBebida.getSelectedRow();
							Bebida x = beb.obtener(posFila);
							x.setNombre(nombre);
							x.setMarca(marca);
							x.setTipoBebida(tipoBebida);
							x.setEstado(estado);
							x.setPrecio(precio);
							btnModificar.setEnabled(true);
							habilitarEntradas(false);
						}

						listar();
					} // **********
					else {
						mensaje("El precio debe ser mayor a Cero");
						txtPrecio.requestFocus();
					}
				}
				catch (Exception e) {
					mensaje("Ingrese un valor numerico");
					txtPrecio.requestFocus();
				}
			}
			else {
				mensaje("Ingrese una Marca Valida");
				txtMarca.requestFocus();
			}
		}
		else {
			mensaje("Ingrese un Nombre Valido");
			txtNombre.requestFocus();
		}
	}

	// BOTON: GRABAR
	protected void actionPerformedBtnGrabar(ActionEvent arg0) {
		/**
		 * Actualiza el archivo
		 */
		if (beb.existeArchivo()) {
			int ok = confirmar("¿ Desea actualizar \"" + beb.getArchivo() + "\" ?");
			if (ok == 0) {
				beb.grabarBebida();
				mensaje("\"" + beb.getArchivo() + "\" ha sido actualizado");
			}
			else
				mensaje("No se actualizó  \"" + beb.getArchivo() + "\"");
		}
		else {
			beb.grabarBebida();
			mensaje("\"" + beb.getArchivo() + "\" ha sido creado");
		}
		limpieza();
		habilitarEntradas(false);
		btnIngresarNuevo.setEnabled(true);
		btnModificar.setEnabled(true);

	}

	// BOTON: MODIFICAR
	protected void actionPerformedBtnModificarBebida(ActionEvent arg0) {
		habilitarEntradas(true);
		txtNombre.requestFocus();
		btnIngresarNuevo.setEnabled(true);
		btnModificar.setEnabled(false);
	}

	// BOTON: INGRESAR NUEVO
	protected void actionPerformedBtnIngresarNuevo(ActionEvent arg0) {
		limpieza();
		habilitarEntradas(true);
		txtNombre.requestFocus();
		txtCodigo.setText("" + correlativoCodigo());
		btnIngresarNuevo.setEnabled(false);
		btnModificar.setEnabled(true);
	}

	// BOTON: CANCELAR
	protected void actionPerformedBtnCancelar(ActionEvent arg0) {
		limpieza();
		habilitarEntradas(false);
		editarFila();
		btnIngresarNuevo.setEnabled(true);
		btnModificar.setEnabled(true);
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tblBebida) {
			mouseClickedTblBebida(e);
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
	protected void mouseClickedTblBebida(MouseEvent e) {
		editarFila();
		habilitarEntradas(false);
		btnIngresarNuevo.setEnabled(true);
		btnModificar.setEnabled(true);
	}

	// **************************************************************************************
	// **************************************************************************************

	// Metodo Listar
	void listar() {

		// para que al iniciar el programa, se seleccione la fila 1

		int posFila = 0;
		if (modelo.getRowCount() > 0)
			posFila = tblBebida.getSelectedRow();
		if (modelo.getRowCount() == beb.tamaño() - 1)
			posFila = beb.tamaño() - 1;
		if (posFila == beb.tamaño())
			posFila--;

		modelo.setRowCount(0);
		for (int i = 0; i < beb.tamaño(); i++) {
			Object[] fila = { beb.obtener(i).getIdBebida(), beb.obtener(i).getNombre(), beb.obtener(i).getMarca(),
					beb.obtener(i).txtTipoBebida(), beb.obtener(i).txtEstado(), beb.obtener(i).getPrecio() };
			modelo.addRow(fila);
		}
		// No sé para que es, pero completa el codigo para seleccionar la
		// primera fila

		if (beb.tamaño() > 0)
			tblBebida.getSelectionModel().setSelectionInterval(posFila, posFila);
	}

	// Bebida(String idBebida, String nombre, String marca, int tipoBebida, int
	// estado, double precio)

	// Metodos tipo void sin parametros

	String leerNombre() {
		return txtNombre.getText().trim();
	}

	String leerMarca() {
		return txtMarca.getText().trim();
	}

	int leerTipoBebida() {
		return cboTipoBebida.getSelectedIndex();

	}

	int leerEstado() {
		return cboEstadoBebida.getSelectedIndex();
	}

	double leerPrecio() {
		return Double.parseDouble(txtPrecio.getText().trim());
	}

	String correlativoCodigo() {
		int i = beb.tamaño() + 1;
		if (i < 10)
			return ("B000" + i);
		else
			return ("B00" + i);
	}

	protected void actionPerformedCboTipoBebida(ActionEvent arg0) {
		int x = cboTipoBebida.getSelectedIndex();
		switch (x) {
			case 0:
				txtTipoBebida.setText("Cerveza");
				break;
			case 1:
				txtTipoBebida.setText("Vinos");
				break;
			case 2:
				txtTipoBebida.setText("Whisky");
				break;
			case 3:
				txtTipoBebida.setText("Ron");
				break;
			case 4:
				txtTipoBebida.setText("Frutado");
				break;
			case 5:
				txtTipoBebida.setText("Combinacion preparada");
				break;
			default:
				txtTipoBebida.setText("Agua embotellada");
				break;
		}

	}

	protected void actionPerformedCboEstadoBebida(ActionEvent arg0) {
		int x = cboEstadoBebida.getSelectedIndex();
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
		txtMarca.setEditable(sino);
		cboTipoBebida.setEnabled(sino);
		cboEstadoBebida.setEnabled(sino);
		txtPrecio.setEditable(sino);
		btnAceptar.setEnabled(sino);
		btnCancelar.setEnabled(sino);
	}

	void limpieza() {
		txtCodigo.setText("");
		txtNombre.setText("");
		txtMarca.setText("");
		txtPrecio.setText("0.00");
		cboTipoBebida.setSelectedIndex(0);
		cboEstadoBebida.setSelectedIndex(0);
	}

	void editarFila() {
		if (beb.tamaño() == 0)
			limpieza();
		else {
			Bebida x = beb.obtener(tblBebida.getSelectedRow());
			txtCodigo.setText(x.getIdBebida());
			txtNombre.setText(x.getNombre());
			txtMarca.setText(x.getMarca());
			txtPrecio.setText(x.getPrecio() + "");
			cboTipoBebida.setSelectedIndex(x.getTipoBebida());
			cboEstadoBebida.setSelectedIndex(x.getEstado());

		}
	}

}
