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
import arreglos.ArregloPiqueo;

import clases.Piqueo;
import javax.swing.UIManager;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class DlgPiqueo extends JDialog implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblImagenPiqueo;
	private JLabel lblCodigo;
	private JLabel lblNombre;
	private JLabel lblTipo;
	private JLabel lblPrecio;
	private JLabel lblEstado;
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JComboBox<String> cboTipoPiqueo;
	private JTextField txtTipoPiqueo;
	private JTextField txtPrecio;
	private JComboBox<String> cboEstadoPiqueo;
	private JTextField txtEstado;
	private JButton btnAceptar;
	private JButton btnModificar;
	private JButton btnGrabar;
	private JScrollPane scrollPane;
	private JTable tblPiqueo;
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
					DlgPiqueo dialog = new DlgPiqueo();
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
	public DlgPiqueo() {
		setTitle("Mantenimiento | Piqueos");
		setBounds(100, 100, 1000, 600);
		getContentPane().setLayout(null);

		lblImagenPiqueo = new JLabel("");
		lblImagenPiqueo.setIcon(new ImageIcon("imagenes/DlgPiqueo.png"));
		lblImagenPiqueo.setBounds(10, 11, 176, 166);
		getContentPane().add(lblImagenPiqueo);

		lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(196, 11, 115, 14);
		getContentPane().add(lblCodigo);

		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(196, 36, 115, 14);
		getContentPane().add(lblNombre);

		lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(196, 61, 115, 14);
		getContentPane().add(lblTipo);

		lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(196, 86, 115, 14);
		getContentPane().add(lblPrecio);

		lblEstado = new JLabel("Estado");
		lblEstado.setBounds(196, 111, 115, 14);
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

		cboTipoPiqueo = new JComboBox<String>();
		cboTipoPiqueo.addActionListener(this);
		cboTipoPiqueo.setModel(new DefaultComboBoxModel<String>(new String[] { "0", "1", "2" }));
		cboTipoPiqueo.setBounds(321, 58, 44, 20);
		getContentPane().add(cboTipoPiqueo);

		txtTipoPiqueo = new JTextField();
		txtTipoPiqueo.setEditable(false);
		txtTipoPiqueo.setBounds(375, 58, 122, 20);
		getContentPane().add(txtTipoPiqueo);
		txtTipoPiqueo.setColumns(10);

		txtPrecio = new JTextField();
		txtPrecio.setBounds(321, 83, 176, 20);
		getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);

		cboEstadoPiqueo = new JComboBox<String>();
		cboEstadoPiqueo.addActionListener(this);
		cboEstadoPiqueo.setModel(new DefaultComboBoxModel<String>(new String[] { "0", "1" }));
		cboEstadoPiqueo.setBounds(321, 108, 44, 20);
		getContentPane().add(cboEstadoPiqueo);

		txtEstado = new JTextField();
		txtEstado.setEditable(false);
		txtEstado.setBounds(375, 108, 122, 20);
		getContentPane().add(txtEstado);
		txtEstado.setColumns(10);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(824, 11, 150, 23);
		getContentPane().add(btnAceptar);

		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(824, 111, 150, 23);
		getContentPane().add(btnModificar);

		btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(this);
		btnGrabar.setBounds(824, 154, 150, 23);
		getContentPane().add(btnGrabar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 191, 964, 359);
		getContentPane().add(scrollPane);

		tblPiqueo = new JTable();
		tblPiqueo.addMouseListener(this);
		tblPiqueo.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblPiqueo);

		modelo = new DefaultTableModel();
		modelo.addColumn("Codigo");
		modelo.addColumn("Nombre");
		modelo.addColumn("Tipo");
		modelo.addColumn("Estado");
		modelo.addColumn("Precio");
		tblPiqueo.setModel(modelo);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(824, 36, 150, 23);
		getContentPane().add(btnCancelar);

		btnIngresarNuevo = new JButton("Ingresar Nuevo");
		btnIngresarNuevo.addActionListener(this);
		btnIngresarNuevo.setBounds(824, 86, 150, 23);
		getContentPane().add(btnIngresarNuevo);

		txtTipoPiqueo.setText("Frios");// Valores por defecto
		txtEstado.setText("Habilitado");// Valores por defecto
		txtPrecio.setText("10.00");// Valores por defecto

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
		if (arg0.getSource() == cboEstadoPiqueo) {
			actionPerformedCboEstadoPiqueo(arg0);
		}
		if (arg0.getSource() == cboTipoPiqueo) {
			actionPerformedCboTipoPiqueo(arg0);
		}
		if (arg0.getSource() == btnGrabar) {
			actionPerformedBtnGrabar(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			actionPerformedBtnModificarPiqueo(arg0);
		}
		if (arg0.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(arg0);
		}
	}

	// *************************************************************
	ArregloPiqueo piq = new ArregloPiqueo("Piqueos.txt");

	// *************************************************************

	// BOTON: ACEPTAR
	protected void actionPerformedBtnAceptar(ActionEvent arg0) {
		String codigo = correlativoCodigo();
		String nombre = leerNombre();
		if (nombre.length() > 0) {
			int tipoPiqueo = leerTipoPiqueo();
			int estado = leerEstado();
			try {
				double precio = leerPrecio();
				if (precio > 0.0) {
					if (btnIngresarNuevo.isEnabled() == false) {
						Piqueo nuevo = new Piqueo(codigo, nombre, tipoPiqueo, estado, precio);

						piq.adicionar(nuevo);
						btnIngresarNuevo.setEnabled(true);
						limpieza();
						txtCodigo.setText("" + correlativoCodigo());
						txtNombre.requestFocus();
					}
					if (btnModificar.isEnabled() == false) {
						// Uso la posicion de la fila seleccionada como
						// parametro para obtener la direccion de
						// memoria del arreglo
						int posFila = tblPiqueo.getSelectedRow();
						Piqueo x = piq.obtener(posFila);
						x.setNombre(nombre);
						x.setTipoBebida(tipoPiqueo);
						x.setEstado(estado);
						x.setPrecio(precio);
						btnModificar.setEnabled(true);
						habilitarEntradas(false);
					}

					listar();
				}
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
			mensaje("Ingrese un Nombre Valido");
			txtNombre.requestFocus();
		}
	}

	// BOTON: GRABAR
	protected void actionPerformedBtnGrabar(ActionEvent arg0) {
		/**
		 * Actualiza el archivo
		 */
		if (piq.existeArchivo()) {
			int ok = confirmar("¿ Desea actualizar \"" + piq.getArchivo() + "\" ?");
			if (ok == 0) {
				piq.grabarPiqueo();
				mensaje("\"" + piq.getArchivo() + "\" ha sido actualizado");
			}
			else
				mensaje("No se actualizó  \"" + piq.getArchivo() + "\"");
		}
		else {
			piq.grabarPiqueo();
			mensaje("\"" + piq.getArchivo() + "\" ha sido creado");
		}
		limpieza();
		habilitarEntradas(false);
		btnIngresarNuevo.setEnabled(true);
		btnModificar.setEnabled(true);

	}

	// BOTON: MODIFICAR
	protected void actionPerformedBtnModificarPiqueo(ActionEvent arg0) {
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
		if (e.getSource() == tblPiqueo) {
			mouseClickedTblPiqueo(e);
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
	protected void mouseClickedTblPiqueo(MouseEvent e) {
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
			posFila = tblPiqueo.getSelectedRow();
		if (modelo.getRowCount() == piq.tamaño() - 1)
			posFila = piq.tamaño() - 1;
		if (posFila == piq.tamaño())
			posFila--;

		modelo.setRowCount(0);
		for (int i = 0; i < piq.tamaño(); i++) {
			Object[] fila = { piq.obtener(i).getIdPiqueo(), piq.obtener(i).getNombre(), piq.obtener(i).txtTipoPiqueo(),
					piq.obtener(i).txtEstado(), piq.obtener(i).getPrecio() };
			modelo.addRow(fila);
		}
		// No sé para que es, pero completa el codigo para seleccionar la
		// primera fila

		if (piq.tamaño() > 0)
			tblPiqueo.getSelectionModel().setSelectionInterval(posFila, posFila);
	}

	// Metodos tipo void sin parametros

	String leerNombre() {
		return txtNombre.getText().trim();
	}

	int leerTipoPiqueo() {
		return cboTipoPiqueo.getSelectedIndex();

	}

	int leerEstado() {
		return cboEstadoPiqueo.getSelectedIndex();
	}

	double leerPrecio() {
		return Double.parseDouble(txtPrecio.getText().trim());
	}

	String correlativoCodigo() {
		int i = piq.tamaño() + 1;
		if (i < 10)
			return ("P000" + i);
		else
			return ("P00" + i);
	}

	protected void actionPerformedCboTipoPiqueo(ActionEvent arg0) {
		int x = cboTipoPiqueo.getSelectedIndex();
		switch (x) {
			case 0:
				txtTipoPiqueo.setText("Frios");
				break;
			case 1:
				txtTipoPiqueo.setText("Calientes");
				break;
			default:
				txtTipoPiqueo.setText("Snacks");
				break;
		}

	}

	protected void actionPerformedCboEstadoPiqueo(ActionEvent arg0) {
		int x = cboEstadoPiqueo.getSelectedIndex();
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
		cboTipoPiqueo.setEnabled(sino);
		cboEstadoPiqueo.setEnabled(sino);
		txtPrecio.setEditable(sino);
		btnAceptar.setEnabled(sino);
		btnCancelar.setEnabled(sino);
	}

	void limpieza() {
		txtCodigo.setText("");
		txtNombre.setText("");
		txtPrecio.setText("0.00");
		cboTipoPiqueo.setSelectedIndex(0);
		cboEstadoPiqueo.setSelectedIndex(0);
	}

	void editarFila() {
		if (piq.tamaño() == 0)
			limpieza();
		else {
			Piqueo x = piq.obtener(tblPiqueo.getSelectedRow());
			txtCodigo.setText(x.getIdPiqueo());
			txtNombre.setText(x.getNombre());
			txtPrecio.setText(x.getPrecio() + "");
			cboTipoPiqueo.setSelectedIndex(x.getTipoPiqueo());
			cboEstadoPiqueo.setSelectedIndex(x.getEstado());

		}
	}

}
