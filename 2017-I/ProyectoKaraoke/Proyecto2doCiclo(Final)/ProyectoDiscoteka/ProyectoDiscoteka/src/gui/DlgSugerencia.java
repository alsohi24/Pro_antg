package gui;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import arreglos.ArregloSugerencia;
import clases.Sugerencia;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class DlgSugerencia extends JDialog implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblCodigo;
	private JTextField txtCodigo;
	private JLabel lblImg;
	private JLabel lblUsuario;
	public static JTextField txtUsuario;
	public static JTextField txtNombreUsuario;
	private JLabel lblTipo;
	private JComboBox<String> cboTipo;
	private JTextField txtTipo;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JButton btnIngresarNuevo;
	private JButton btnModificar;
	private JButton btnGrabar;
	private JScrollPane scrollPane;
	private JButton btnBuscar;
	private JTable tblSugerencias;
	private JLabel lblSugerencia;
	private DefaultTableModel modelo;
	private JScrollPane scrollPane_1;
	private JTextArea txtS;
	private JLabel lblFecha;
	private JTextField txtFecha;

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
		try {
			DlgSugerencia dialog = new DlgSugerencia();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgSugerencia() {
		setTitle("Registro | Sugerencia");
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(null);

		lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(196, 11, 66, 14);
		getContentPane().add(lblCodigo);

		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(272, 8, 223, 20);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);

		lblImg = new JLabel("");
		lblImg.setIcon(new ImageIcon("imagenes/DlgCliente2.png"));
		lblImg.setBounds(10, 11, 176, 166);
		getContentPane().add(lblImg);

		lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(196, 36, 66, 14);
		getContentPane().add(lblUsuario);

		txtUsuario = new JTextField();
		txtUsuario.setEditable(false);
		txtUsuario.setBounds(272, 33, 148, 20);
		getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);

		lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(196, 85, 66, 14);
		getContentPane().add(lblTipo);

		cboTipo = new JComboBox<String>();
		cboTipo.addActionListener(this);
		cboTipo.setModel(new DefaultComboBoxModel<String>(new String[] { "0", "1", "2", "3", "4" }));
		cboTipo.setBounds(272, 82, 44, 20);
		getContentPane().add(cboTipo);

		txtTipo = new JTextField();
		txtTipo.setEditable(false);
		txtTipo.setBounds(324, 82, 171, 20);
		getContentPane().add(txtTipo);
		txtTipo.setColumns(10);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(624, 8, 150, 23);
		getContentPane().add(btnAceptar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(624, 33, 150, 23);
		getContentPane().add(btnCancelar);

		btnIngresarNuevo = new JButton("Ingresar Nuevo");
		btnIngresarNuevo.addActionListener(this);
		btnIngresarNuevo.setBounds(624, 81, 150, 23);
		getContentPane().add(btnIngresarNuevo);

		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(624, 106, 150, 23);
		getContentPane().add(btnModificar);

		btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(this);
		btnGrabar.setBounds(624, 154, 150, 23);
		getContentPane().add(btnGrabar);

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(430, 32, 65, 23);
		getContentPane().add(btnBuscar);

		txtNombreUsuario = new JTextField();
		txtNombreUsuario.setEditable(false);
		txtNombreUsuario.setBounds(272, 58, 223, 20);
		getContentPane().add(txtNombreUsuario);
		txtNombreUsuario.setColumns(10);

		lblSugerencia = new JLabel("Comentario / Sugerencia:");
		lblSugerencia.setBounds(196, 145, 150, 14);
		getContentPane().add(lblSugerencia);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 222, 764, 228);
		getContentPane().add(scrollPane);

		tblSugerencias = new JTable();
		tblSugerencias.addMouseListener(this);
		tblSugerencias.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblSugerencias);

		modelo = new DefaultTableModel();
		modelo.addColumn("Codigo");
		modelo.addColumn("Usuario");
		modelo.addColumn("Tipo Sugerencia");
		modelo.addColumn("Fecha");
		modelo.addColumn("Detalle");
		tblSugerencias.setModel(modelo);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(196, 161, 418, 54);
		getContentPane().add(scrollPane_1);

		txtS = new JTextArea();
		scrollPane_1.setViewportView(txtS);

		lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(196, 110, 66, 14);
		getContentPane().add(lblFecha);

		txtFecha = new JTextField();
		txtFecha.setEditable(false);
		txtFecha.setBounds(272, 107, 223, 20);
		getContentPane().add(txtFecha);
		txtFecha.setColumns(10);

		ajustarAnchoColumnas();
		habilitarEntradas(false);
		listar();// Para que al iniciar la ventana, ya muestre los datos
		editarFila();

	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == cboTipo) {
			actionPerformedcboTipo(arg0);
		}
		if (arg0.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(arg0);
		}
		if (arg0.getSource() == btnGrabar) {
			actionPerformedBtnGrabar(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			actionPerformedBtnModificar(arg0);
		}
		if (arg0.getSource() == btnIngresarNuevo) {
			actionPerformedBtnIngresarNuevo(arg0);
		}
		if (arg0.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(arg0);
		}
		if (arg0.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(arg0);
		}
	}

	// *************************************************************
	ArregloSugerencia sug = new ArregloSugerencia("Sugerencia.txt");
	// *************************************************************

	// BOTON: ACEPTAR
	protected void actionPerformedBtnAceptar(ActionEvent arg0) {
		String codigo = correlativoCodigo();

		String usuario = leerUsuario();
		if (usuario.length() > 0) {
			int tipo = leerTipoSugerencia();
			String fecha = leerFecha();
			if (fecha.length() == 10) {
				String detalle = leerDetalle();
				if (detalle.length() > 0) {
					if (btnIngresarNuevo.isEnabled() == false) {
						Sugerencia nuevo = new Sugerencia(codigo, usuario, tipo, fecha, detalle);
						sug.adicionar(nuevo);
						btnIngresarNuevo.setEnabled(true);
						limpieza();
						txtCodigo.setText("" + correlativoCodigo());
						btnBuscar.requestFocusInWindow();
					}
					if (btnModificar.isEnabled() == false) {
						// Uso la posicion de la fila
						// seleccionada como
						// parametro para obtener la
						// direccion de
						// memoria del arreglo
						int posFila = tblSugerencias.getSelectedRow();
						Sugerencia x = sug.obtener(posFila);
						x.setIdUsuario(usuario);
						x.setTipoSugerencia(tipo);
						x.setFecha(fecha);
						x.setDetalle(detalle);

						btnModificar.setEnabled(true);
						habilitarEntradas(false);

					}

					listar();
				}
				else {
					mensaje("Escriba sus Sugerencias");
					txtS.requestFocus();

				}

			}
			else {
				mensaje("El formato de fecha debe ser dd/mm/aaaa");
				txtFecha.requestFocus();
			}
		}
		else {
			mensaje("Seleccione un Usuario");
			btnBuscar.requestFocusInWindow();
		}
	}

	// BOTON: GRABAR
	protected void actionPerformedBtnGrabar(ActionEvent arg0) {

		/**
		 * Actualiza el archivo
		 */
		if (sug.existeArchivo()) {
			int ok = confirmar("¿ Desea actualizar \"" + sug.getArchivo() + "\" ?");
			if (ok == 0) {
				sug.grabarSugerencia();
				mensaje("\"" + sug.getArchivo() + "\" ha sido actualizado");
			}
			else
				mensaje("No se actualizó  \"" + sug.getArchivo() + "\"");
		}
		else {
			sug.grabarSugerencia();
			mensaje("\"" + sug.getArchivo() + "\" ha sido creado");
		}
		limpieza();
		habilitarEntradas(false);
		btnIngresarNuevo.setEnabled(true);

	}

	// BOTON: CANCELAR
	protected void actionPerformedBtnCancelar(ActionEvent arg0) {
		limpieza();
		habilitarEntradas(false);
		btnIngresarNuevo.setEnabled(true);
		btnModificar.setEnabled(true);
	}

	// BOTON: INGRESAR NUEVO
	protected void actionPerformedBtnIngresarNuevo(ActionEvent arg0) {
		limpieza();
		habilitarEntradas(true);
		btnBuscar.requestFocusInWindow();
		txtCodigo.setText("" + correlativoCodigo());
		btnIngresarNuevo.setEnabled(false);
		btnModificar.setEnabled(true);

	}

	// BOTON: MODIFICAR
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		habilitarEntradas(true);
		btnBuscar.requestFocusInWindow();
		btnIngresarNuevo.setEnabled(true);
		btnModificar.setEnabled(false);
	}

	// BOTON: BUSCAR
	protected void actionPerformedBtnBuscar(ActionEvent arg0) {
		DlgListarUsuario dc = new DlgListarUsuario();
		dc.setLocationRelativeTo(this);
		dc.setVisible(true);
	}

	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == tblSugerencias) {
			mouseClickedTblSugerencias(arg0);
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

	// EVENTO CLICK EN LAS FILAS DE LA TABLA
	protected void mouseClickedTblSugerencias(MouseEvent arg0) {
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
			posFila = tblSugerencias.getSelectedRow();
		if (modelo.getRowCount() == sug.tamaño() - 1)
			posFila = sug.tamaño() - 1;
		if (posFila == sug.tamaño())
			posFila--;

		modelo.setRowCount(0);
		for (int i = 0; i < sug.tamaño(); i++) {
			Object[] fila = { sug.obtener(i).getIdSugerencia(), sug.obtener(i).getIdUsuario(),
					sug.obtener(i).txtTipoSugerencia(), sug.obtener(i).getFecha(), sug.obtener(i).getDetalle() };
			modelo.addRow(fila);
		}
		// No sé para que es, pero completa el codigo para seleccionar la
		// primera fila

		if (sug.tamaño() > 0)
			tblSugerencias.getSelectionModel().setSelectionInterval(posFila, posFila);
	}

	// Metodos tipo void sin parametros

	String leerUsuario() {
		return txtUsuario.getText().trim();
	}

	String leerDetalle() {
		return txtS.getText().trim();
	}

	String leerFecha() {
		return txtFecha.getText().trim();
	}

	int leerTipoSugerencia() {
		return cboTipo.getSelectedIndex();

	}

	String correlativoCodigo() {
		int i = sug.tamaño() + 1;
		if (i < 10)
			return ("Sug00" + i);
		else
			return ("Sug0" + i);
	}

	protected void actionPerformedcboTipo(ActionEvent arg0) {
		int x = cboTipo.getSelectedIndex();
		switch (x) {
			case 0:
				txtTipo.setText("Calidad de Atención");
				break;
			case 1:
				txtTipo.setText("Calidad/Variedad de las Canciones");
				break;
			case 2:
				txtTipo.setText("Calidad/Variedad de las bebidas");
				break;
			case 3:
				txtTipo.setText("Calidad/Variedad de los Piqueos");
				break;
			default:
				txtTipo.setText("Calidad del local");
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

	private int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}

	private void ajustarAnchoColumnas() {
		TableColumnModel tcm = tblSugerencias.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(10)); // codigo
		tcm.getColumn(1).setPreferredWidth(anchoColumna(10)); // usuario
		tcm.getColumn(2).setPreferredWidth(anchoColumna(25)); // tipo
		tcm.getColumn(3).setPreferredWidth(anchoColumna(10)); // fecha
		tcm.getColumn(4).setPreferredWidth(anchoColumna(45)); // Detalle

	}

	void habilitarEntradas(boolean sino) {

		// txtCodigo.setEditable(sino);
		txtS.setEditable(sino);
		txtFecha.setEditable(sino);
		cboTipo.setEnabled(sino);
		btnAceptar.setEnabled(sino);
		btnCancelar.setEnabled(sino);
		btnBuscar.setEnabled(sino);
	}

	void limpieza() {
		txtCodigo.setText("");
		txtUsuario.setText("");
		txtNombreUsuario.setText("");
		txtFecha.setText("");
		txtS.setText("");
		cboTipo.setSelectedIndex(0);

	}

	void editarFila() {
		if (sug.tamaño() == 0)
			limpieza();
		else {
			Sugerencia x = sug.obtener(tblSugerencias.getSelectedRow());
			txtCodigo.setText(x.getIdSugerencia());
			txtUsuario.setText(x.getIdUsuario());
			txtFecha.setText(x.getFecha());
			txtS.setText(x.getDetalle());
			cboTipo.setSelectedIndex(x.getTipoSugerencia());

		}
	}
}
