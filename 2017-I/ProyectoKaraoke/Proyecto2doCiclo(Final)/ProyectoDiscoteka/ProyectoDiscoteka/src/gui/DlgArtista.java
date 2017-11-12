package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import arreglos.ArregloArtista;
import clases.Artista;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class DlgArtista extends JDialog implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblImgartista;
	private JLabel lblCodigo;
	private JLabel lblNombreArtistico;
	private JLabel lblGenero;
	private JLabel lblFechaRegistro;
	private JLabel lblEstado;
	private JTextField txtCodigo;
	private JTextField txtNombreArtistico;
	public static JTextField txtGenero;
	private JTextField txtFechaRegistro;
	private JComboBox<String> cboEstado;
	private JTextField txtEstado;
	private JButton btnAceptar;
	private JButton btnModificar;
	private JScrollPane scrollPane;
	private JTable tblArtista;
	private DefaultTableModel modelo;
	private JButton btnGrabar;
	public static JTextField txtGeneroNombre;
	private JButton btnBuscar;
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
					DlgArtista dialog = new DlgArtista();
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
	public DlgArtista() {
		setTitle("Mantemiento | Artista");
		setBounds(100, 100, 1000, 600);
		getContentPane().setLayout(null);

		lblImgartista = new JLabel("ImgArtista");
		lblImgartista.setIcon(new ImageIcon("imagenes/DlgArtista1.png"));
		lblImgartista.setBounds(10, 11, 176, 166);
		getContentPane().add(lblImgartista);

		lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(196, 11, 87, 14);
		getContentPane().add(lblCodigo);

		lblNombreArtistico = new JLabel("Nombre Artistico");
		lblNombreArtistico.setBounds(196, 36, 87, 14);
		getContentPane().add(lblNombreArtistico);

		lblGenero = new JLabel("Genero");
		lblGenero.setBounds(196, 61, 87, 14);
		getContentPane().add(lblGenero);

		lblFechaRegistro = new JLabel("Fecha Registro");
		lblFechaRegistro.setBounds(196, 112, 87, 14);
		getContentPane().add(lblFechaRegistro);

		lblEstado = new JLabel("Estado");
		lblEstado.setBounds(196, 137, 87, 14);
		getContentPane().add(lblEstado);

		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(293, 8, 176, 20);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);

		txtNombreArtistico = new JTextField();
		txtNombreArtistico.setBounds(293, 33, 176, 20);
		getContentPane().add(txtNombreArtistico);
		txtNombreArtistico.setColumns(10);

		txtGenero = new JTextField();
		txtGenero.setEditable(false);
		txtGenero.setBounds(293, 58, 176, 20);
		getContentPane().add(txtGenero);
		txtGenero.setColumns(10);

		txtFechaRegistro = new JTextField();
		txtFechaRegistro.setBounds(293, 109, 176, 20);
		getContentPane().add(txtFechaRegistro);
		txtFechaRegistro.setColumns(10);

		cboEstado = new JComboBox<String>();
		cboEstado.addActionListener(this);
		cboEstado.setModel(new DefaultComboBoxModel<String>(new String[] { "0", "1" }));
		cboEstado.setBounds(292, 134, 44, 20);
		getContentPane().add(cboEstado);

		txtEstado = new JTextField();
		txtEstado.setEditable(false);
		txtEstado.setBounds(346, 134, 122, 20);
		getContentPane().add(txtEstado);
		txtEstado.setColumns(10);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(824, 11, 150, 23);
		getContentPane().add(btnAceptar);

		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(824, 108, 150, 23);
		getContentPane().add(btnModificar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 188, 964, 362);
		getContentPane().add(scrollPane);

		tblArtista = new JTable();
		tblArtista.addMouseListener(this);
		tblArtista.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblArtista);

		modelo = new DefaultTableModel();
		modelo.addColumn("Artista");
		modelo.addColumn("Nom. Artistico");
		modelo.addColumn("Fecha de Registro");
		modelo.addColumn("Genero");
		modelo.addColumn("Estado");
		tblArtista.setModel(modelo);

		txtEstado.setText("Habilitado");

		btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(this);
		btnGrabar.setBounds(824, 154, 150, 23);
		getContentPane().add(btnGrabar);

		txtGeneroNombre = new JTextField();
		txtGeneroNombre.setEditable(false);
		txtGeneroNombre.setBounds(293, 84, 176, 20);
		getContentPane().add(txtGeneroNombre);
		txtGeneroNombre.setColumns(10);

		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(479, 57, 89, 23);
		getContentPane().add(btnBuscar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(824, 36, 150, 23);
		getContentPane().add(btnCancelar);

		btnIngresarNuevo = new JButton("Ingresar Nuevo");
		btnIngresarNuevo.addActionListener(this);
		btnIngresarNuevo.setBounds(824, 83, 150, 23);
		getContentPane().add(btnIngresarNuevo);

		ajustarAnchoColumnas();
		habilitarEntradas(false);
		listar();// Para que al iniciar la ventana, ya muestre los datos
		editarFila();

	}

	ArregloArtista art = new ArregloArtista("Artista.txt");

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnModificar) {
			actionPerformedBtnModificar(arg0);
		}
		if (arg0.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(arg0);
		}
		if (arg0.getSource() == btnIngresarNuevo) {
			actionPerformedBtnIngresarNuevo(arg0);
		}
		if (arg0.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(arg0);
		}
		if (arg0.getSource() == btnGrabar) {
			actionPerformedBtnGrabar(arg0);
		}
		if (arg0.getSource() == cboEstado) {
			actionPerformedCboEstado(arg0);
		}
		if (arg0.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(arg0);
		}
	}

	// BOTON: ACEPTAR
	protected void actionPerformedBtnAceptar(ActionEvent arg0) {

		String codigo = correlativoCodigo();
		String nombre = leerNombre();
		if (nombre.length() > 0) {
			String fecha = leerFecha();
			if (fecha.length() == 10) {
				String idGenero = leerGenero();
				if (idGenero.length() > 0) {
					int estado = leerEstado();
					if (btnIngresarNuevo.isEnabled() == false) {
						Artista nuevo = new Artista(codigo, nombre, fecha, idGenero, estado);

						art.adicionar(nuevo);
						btnIngresarNuevo.setEnabled(true);
						limpieza();
						txtCodigo.setText("" + correlativoCodigo());
						txtNombreArtistico.requestFocus();
					}
					if (btnModificar.isEnabled() == false) {
						// Uso la posicion de la fila seleccionada como
						// parametro para obtener la direccion de
						// memoria del arreglo
						int posFila = tblArtista.getSelectedRow();
						Artista x = art.obtener(posFila);
						x.setNombreArtistico(nombre);
						x.setFechaRegistro(fecha);
						x.setIdGenero(idGenero);
						x.setEstado(estado);
						btnModificar.setEnabled(true);
						habilitarEntradas(false);
					}
					listar();
				} // **********

				else {
					mensaje("Seleccione un Genero");
					btnBuscar.requestFocusInWindow();
				}
			}
			else {
				mensaje("El formato de fecha debe ser dd/mm/aaaa");
				txtFechaRegistro.requestFocus();
			}
		}
		else {
			mensaje("Ingrese un Nombre Valido");
			txtNombreArtistico.requestFocus();
		}

	}

	// BOTON: GRABAR
	protected void actionPerformedBtnGrabar(ActionEvent arg0) {

		/**
		 * Actualiza el archivo
		 */
		if (art.existeArchivo()) {
			int ok = confirmar("¿ Desea actualizar \"" + art.getArchivo() + "\" ?");
			if (ok == 0) {
				art.grabarArtista();
				mensaje("\"" + art.getArchivo() + "\" ha sido actualizado");
			}
			else
				mensaje("No se actualizó  \"" + art.getArchivo() + "\"");
		}
		else {
			art.grabarArtista();
			mensaje("\"" + art.getArchivo() + "\" ha sido creado");
		}
		limpieza();
		habilitarEntradas(false);
		btnIngresarNuevo.setEnabled(true);
		btnModificar.setEnabled(true);
	}

	// BOTON: BUSCAR
	protected void actionPerformedBtnBuscar(ActionEvent arg0) {
		DlgListarGenero dc = new DlgListarGenero();
		dc.setLocationRelativeTo(this);
		dc.setVisible(true);
	}

	// BOTON: INGRESAR NUEVO
	protected void actionPerformedBtnIngresarNuevo(ActionEvent arg0) {
		limpieza();
		habilitarEntradas(true);
		txtNombreArtistico.requestFocus();
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

	// BOTON: MODIFICAR
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		habilitarEntradas(true);
		txtGenero.requestFocus();
		btnIngresarNuevo.setEnabled(true);
		btnModificar.setEnabled(false);
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tblArtista) {
			mouseClickedTblArtista(e);
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
	protected void mouseClickedTblArtista(MouseEvent e) {
		editarFila();
		habilitarEntradas(false);
		btnIngresarNuevo.setEnabled(true);
		btnModificar.setEnabled(true);
	}

	// ***********************************************************************
	// Metodo Listar
	void listar() {

		// para que al iniciar el programa, se seleccione la fila 1

		int posFila = 0;
		if (modelo.getRowCount() > 0)
			posFila = tblArtista.getSelectedRow();
		if (modelo.getRowCount() == art.tamaño() - 1)
			posFila = art.tamaño() - 1;
		if (posFila == art.tamaño())
			posFila--;

		modelo.setRowCount(0);
		for (int i = 0; i < art.tamaño(); i++) {
			Object[] fila = { art.obtener(i).getIdArtista(), art.obtener(i).getNombreArtistico(),
					art.obtener(i).getFechaRegistro(), art.obtener(i).getIdGenero(), art.obtener(i).txtEstado(), };
			modelo.addRow(fila);

		}
		// No sé para que es, pero completa el codigo para seleccionar la
		// primera fila

		if (art.tamaño() > 0)
			tblArtista.getSelectionModel().setSelectionInterval(posFila, posFila);
	}

	// Metodos tipo void sin parametros

	String correlativoCodigo() {
		int i = art.tamaño() + 1;
		if (i < 10)
			return ("A000" + i);
		else
			return ("A00" + i);
	}

	String leerNombre() {
		return txtNombreArtistico.getText().trim();
	}

	String leerGenero() {
		return txtGeneroNombre.getText().trim();
	}

	String leerFecha() {
		return txtFechaRegistro.getText().trim();
	}

	int leerEstado() {
		return cboEstado.getSelectedIndex();
	}

	protected void actionPerformedCboEstado(ActionEvent arg0) {
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

	private int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}

	private void ajustarAnchoColumnas() {
		TableColumnModel tcm = tblArtista.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(6)); // codigo
		tcm.getColumn(1).setPreferredWidth(anchoColumna(28)); // nombre Artista
		tcm.getColumn(2).setPreferredWidth(anchoColumna(20)); // Fecha de
																// registro
		tcm.getColumn(3).setPreferredWidth(anchoColumna(26)); // Genero
		tcm.getColumn(4).setPreferredWidth(anchoColumna(20)); // Estado

	}

	void habilitarEntradas(boolean sino) {

		txtNombreArtistico.setEditable(sino);
		txtFechaRegistro.setEditable(sino);
		cboEstado.setEnabled(sino);
		btnAceptar.setEnabled(sino);
		btnCancelar.setEnabled(sino);

	}

	void limpieza() {
		txtCodigo.setText("");
		txtNombreArtistico.setText("");
		txtFechaRegistro.setText("");
		txtGeneroNombre.setText("");
		txtGenero.setText("");
		cboEstado.setSelectedIndex(0);
	}

	void editarFila() {
		if (art.tamaño() == 0)
			limpieza();
		else {
			Artista x = art.obtener(tblArtista.getSelectedRow());
			txtCodigo.setText(x.getIdArtista());
			txtNombreArtistico.setText(x.getNombreArtistico());
			txtFechaRegistro.setText(x.getFechaRegistro());
			txtGeneroNombre.setText(x.getIdGenero());
			cboEstado.setSelectedIndex(x.getEstado());

		}
	}

}
