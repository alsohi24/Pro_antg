package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import arreglos.ArregloGenero;
import clases.Genero;

import javax.swing.SwingConstants;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class DlgGenero extends JDialog implements ActionListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;
	private JLabel lblCodigo;
	private JLabel lblGenero;
	private JLabel lblProcedencia;
	private JLabel lblEstado;
	private JTextField txtCodigo;
	private JTextField txtGenero;
	private JTextField txtProcedencia;
	private JComboBox<String> cboEstado;
	private JTextField txtEstado;
	private JScrollPane scrollPane;
	private JTable tblGenero;
	private JButton btnAceptar;
	private JButton btnModificar;
	private DefaultTableModel modelo;
	private JLabel lblEpoca;
	private JTextField txtEpoca;
	private JButton btnGrabar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgGenero dialog = new DlgGenero();
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
	public DlgGenero() {
		setTitle("Mantenimineto | Genero");
		setBounds(100, 100, 1000, 600);
		getContentPane().setLayout(null);

		lblNewLabel = new JLabel("img");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setIcon(new ImageIcon("imagenes/DlgGenero.png"));
		lblNewLabel.setBounds(10, 11, 176, 166);
		getContentPane().add(lblNewLabel);

		lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(196, 11, 87, 14);
		getContentPane().add(lblCodigo);

		lblGenero = new JLabel("Genero");
		lblGenero.setBounds(196, 36, 87, 14);
		getContentPane().add(lblGenero);

		lblProcedencia = new JLabel("Procedencia");
		lblProcedencia.setBounds(196, 61, 87, 14);
		getContentPane().add(lblProcedencia);

		lblEstado = new JLabel("Estado");
		lblEstado.setBounds(196, 112, 87, 14);
		getContentPane().add(lblEstado);

		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(293, 8, 176, 20);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);

		txtGenero = new JTextField();
		txtGenero.setBounds(293, 33, 176, 20);
		getContentPane().add(txtGenero);
		txtGenero.setColumns(10);

		txtProcedencia = new JTextField();
		txtProcedencia.setBounds(293, 58, 176, 20);
		getContentPane().add(txtProcedencia);
		txtProcedencia.setColumns(10);

		cboEstado = new JComboBox<String>();
		cboEstado.addActionListener(this);
		cboEstado.setModel(new DefaultComboBoxModel<String>(new String[] { "0", "1" }));
		cboEstado.setBounds(293, 109, 44, 20);
		getContentPane().add(cboEstado);

		txtEstado = new JTextField();
		txtEstado.setEditable(false);
		txtEstado.setBounds(347, 109, 122, 20);
		getContentPane().add(txtEstado);
		txtEstado.setColumns(10);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 188, 964, 362);
		getContentPane().add(scrollPane);

		tblGenero = new JTable();
		tblGenero.addMouseListener(this);
		tblGenero.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblGenero);

		modelo = new DefaultTableModel();
		modelo.addColumn("Codigo");
		modelo.addColumn("Genero");
		modelo.addColumn("Procedencia");
		modelo.addColumn("Epoca");
		modelo.addColumn("Estado");
		tblGenero.setModel(modelo);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(824, 11, 150, 23);
		getContentPane().add(btnAceptar);

		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(824, 108, 150, 23);
		getContentPane().add(btnModificar);

		lblEpoca = new JLabel("Epoca");
		lblEpoca.setBounds(196, 87, 46, 14);
		getContentPane().add(lblEpoca);

		txtEpoca = new JTextField();
		txtEpoca.setBounds(293, 84, 176, 20);
		getContentPane().add(txtEpoca);
		txtEpoca.setColumns(10);

		txtEpoca.setText("1900");// Valor por Defecto
		txtEstado.setText("Habilitado");// Valor por defecto

		btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(this);
		btnGrabar.setBounds(824, 140, 150, 23);
		getContentPane().add(btnGrabar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(824, 36, 150, 23);
		getContentPane().add(btnCancelar);

		btnIngresarNuevo = new JButton("Ingresar Nuevo");
		btnIngresarNuevo.addActionListener(this);
		btnIngresarNuevo.setBounds(824, 83, 150, 23);
		getContentPane().add(btnIngresarNuevo);

		habilitarEntradas(false);
		listar();// Para que al iniciar la ventana, ya muestre los datos
		editarFila();

	}

	ArregloGenero gen = new ArregloGenero("Genero.txt");
	private JButton btnCancelar;
	private JButton btnIngresarNuevo;

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnModificar) {
			actionPerformedBtnModificar(arg0);
		}
		if (arg0.getSource() == btnIngresarNuevo) {
			actionPerformedBtnIngresarNuevo(arg0);
		}
		if (arg0.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(arg0);
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
		String genero = leerGenero();
		if (genero.length() > 0) {
			String procedencia = leerProcedencia();
			if (procedencia.length() > 0) {
				int epoca = leerEpoca();
				if (epoca > 1000) {
					int estado = leerEstado();
					if (btnIngresarNuevo.isEnabled() == false) {
						Genero nuevo = new Genero(codigo, genero, procedencia, epoca, estado);
						gen.adicionar(nuevo);
						btnIngresarNuevo.setEnabled(true);
						limpieza();
						txtCodigo.setText("" + correlativoCodigo());
						txtGenero.requestFocus();
					}
					if (btnModificar.isEnabled() == false) {
						// Uso la posicion de la fila seleccionada como
						// parametro para obtener la direccion de
						// memoria del arreglo
						int posFila = tblGenero.getSelectedRow();
						Genero x = gen.obtener(posFila);
						x.setDescripcion(genero);
						x.setProcedencia(procedencia);
						x.setEpoca(epoca);
						x.setEstado(estado);
						btnModificar.setEnabled(true);
						habilitarEntradas(false);
					}
					listar();
				} // **********
				else {
					mensaje("Ingrese una epoca Valida");
					txtEpoca.requestFocus();
				}

			}
			else {
				mensaje("Ingrese una Procedencia Valida");
				txtProcedencia.requestFocus();
			}
		}
		else {
			mensaje("Ingrese un Genero Valido");
			txtGenero.requestFocus();
		}
	}

	// BOTON: GRABAR
	protected void actionPerformedBtnGrabar(ActionEvent arg0) {

		/**
		 * Actualiza el archivo
		 */
		if (gen.existeArchivo()) {
			int ok = confirmar("¿ Desea actualizar \"" + gen.getArchivo() + "\" ?");
			if (ok == 0) {
				gen.grabarGenero();
				mensaje("\"" + gen.getArchivo() + "\" ha sido actualizado");
			}
			else
				mensaje("No se actualizó  \"" + gen.getArchivo() + "\"");
		}
		else {
			gen.grabarGenero();
			mensaje("\"" + gen.getArchivo() + "\" ha sido creado");
		}
		limpieza();
		habilitarEntradas(false);
		btnIngresarNuevo.setEnabled(true);
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

	// BOTON: INGRESAR NUEVO
	protected void actionPerformedBtnIngresarNuevo(ActionEvent arg0) {
		limpieza();
		habilitarEntradas(true);
		txtGenero.requestFocus();
		txtCodigo.setText("" + correlativoCodigo());
		btnIngresarNuevo.setEnabled(false);
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
		if (e.getSource() == tblGenero) {
			mouseClickedTblGenero(e);
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
	protected void mouseClickedTblGenero(MouseEvent e) {
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
			posFila = tblGenero.getSelectedRow();
		if (modelo.getRowCount() == gen.tamaño() - 1)
			posFila = gen.tamaño() - 1;
		if (posFila == gen.tamaño())
			posFila--;

		modelo.setRowCount(0);
		for (int i = 0; i < gen.tamaño(); i++) {
			Object[] fila = { gen.obtener(i).getIdGenero(), gen.obtener(i).getDescripcion(),
					gen.obtener(i).getProcedencia(), gen.obtener(i).getEpoca(), gen.obtener(i).txtEstado(), };
			modelo.addRow(fila);
		}
		// No sé para que es, pero completa el codigo para seleccionar la
		// primera fila

		if (gen.tamaño() > 0)
			tblGenero.getSelectionModel().setSelectionInterval(posFila, posFila);
	}

	// Metodos tipo void sin parametros

	String correlativoCodigo() {
		int i = gen.tamaño() + 1;
		if (i < 10)
			return ("G000" + i);
		else
			return ("G00" + i);
	}

	String leerGenero() {
		return txtGenero.getText().trim();
	}

	String leerProcedencia() {
		return txtProcedencia.getText().trim();
	}

	int leerEpoca() {
		return Integer.parseInt(txtEpoca.getText().trim());
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

	void habilitarEntradas(boolean sino) {

		txtGenero.setEditable(sino);
		txtProcedencia.setEditable(sino);
		txtEpoca.setEditable(sino);
		cboEstado.setEnabled(sino);
		btnAceptar.setEnabled(sino);
		btnCancelar.setEnabled(sino);

	}

	void limpieza() {
		txtCodigo.setText("");
		txtGenero.setText("");
		txtProcedencia.setText("");
		txtEpoca.setText("1900");
		cboEstado.setSelectedIndex(0);
	}

	void editarFila() {
		if (gen.tamaño() == 0)
			limpieza();
		else {
			Genero x = gen.obtener(tblGenero.getSelectedRow());
			txtCodigo.setText(x.getIdGenero());
			txtGenero.setText(x.getDescripcion());
			txtProcedencia.setText(x.getProcedencia());
			txtEpoca.setText(x.getEpoca() + "");
			cboEstado.setSelectedIndex(x.getEstado());

			/*
			 * modelo.addColumn("Codigo"); modelo.addColumn("Genero");
			 * modelo.addColumn("Procedencia"); modelo.addColumn("Epoca");
			 * modelo.addColumn("Estado");
			 */

		}
	}

}
