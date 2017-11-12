package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloBebida;
import arreglos.ArregloConsumo;
import arreglos.ArregloPiqueo;
import arreglos.ArregloRegistroPedido;
import clases.Consumo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class DlgRegistroConsumo extends JDialog implements ActionListener, WindowListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblImg;
	private JLabel lblCodigo;
	private JTextField txtCodigo;
	private JLabel lblCliente;
	public static JTextField txtCliente;
	public static JTextField txtClienteNombre;
	private JButton btnBuscarCliente;
	private JLabel lblUsuario;
	public static JTextField txtUsuario;
	public static JTextField txtUsuarioNombre;
	private JButton btnBuscarUsuario;
	private JLabel lblFechaConsumo;
	private JTextField txtFecha;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JButton btnIngresarNuevo;
	private JButton btnModificar;
	private JButton btnGrabar;
	private JScrollPane scrollPane_1;
	private JTable tblConsumo;
	private JScrollPane scrollPane;
	private JTable tblPedidos;
	private JLabel lblPedidos;
	private JLabel lblConsumos;
	private DefaultTableModel modelo;
	private DefaultTableModel modelox;

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
					DlgRegistroConsumo dialog = new DlgRegistroConsumo();
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
	public DlgRegistroConsumo() {
		addWindowListener(this);
		setTitle("Registro | Consumo");
		setBounds(100, 100, 1000, 600);
		getContentPane().setLayout(null);

		lblImg = new JLabel("img");
		lblImg.setIcon(new ImageIcon("imagenes/DlgRegistroConsumo.png"));
		lblImg.setBounds(10, 11, 176, 166);
		getContentPane().add(lblImg);

		lblCodigo = new JLabel("Codigo Consumo");
		lblCodigo.setBounds(225, 11, 87, 14);
		getContentPane().add(lblCodigo);

		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(322, 8, 176, 20);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);

		lblCliente = new JLabel("Cliente");
		lblCliente.setBounds(225, 40, 87, 14);
		getContentPane().add(lblCliente);

		txtCliente = new JTextField();
		txtCliente.setEditable(false);
		txtCliente.setBounds(322, 37, 176, 20);
		getContentPane().add(txtCliente);
		txtCliente.setColumns(10);

		txtClienteNombre = new JTextField();
		txtClienteNombre.setEditable(false);
		txtClienteNombre.setBounds(322, 60, 176, 20);
		getContentPane().add(txtClienteNombre);
		txtClienteNombre.setColumns(10);

		btnBuscarCliente = new JButton("Buscar");
		btnBuscarCliente.addActionListener(this);
		btnBuscarCliente.setBounds(508, 36, 89, 23);
		getContentPane().add(btnBuscarCliente);

		lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(225, 94, 87, 14);
		getContentPane().add(lblUsuario);

		txtUsuario = new JTextField();
		txtUsuario.setEditable(false);
		txtUsuario.setBounds(322, 91, 176, 20);
		getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);

		txtUsuarioNombre = new JTextField();
		txtUsuarioNombre.setEditable(false);
		txtUsuarioNombre.setBounds(322, 114, 176, 20);
		getContentPane().add(txtUsuarioNombre);
		txtUsuarioNombre.setColumns(10);

		btnBuscarUsuario = new JButton("Buscar ");
		btnBuscarUsuario.addActionListener(this);
		btnBuscarUsuario.setBounds(508, 90, 89, 23);
		getContentPane().add(btnBuscarUsuario);

		lblFechaConsumo = new JLabel("Fecha Consumo");
		lblFechaConsumo.setBounds(225, 150, 87, 14);
		getContentPane().add(lblFechaConsumo);

		txtFecha = new JTextField();
		txtFecha.setEditable(false);
		txtFecha.setBounds(322, 144, 176, 20);
		getContentPane().add(txtFecha);
		txtFecha.setColumns(10);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(824, 7, 150, 23);
		getContentPane().add(btnAceptar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(824, 32, 150, 23);
		getContentPane().add(btnCancelar);

		btnIngresarNuevo = new JButton("Ingresar Nuevo");
		btnIngresarNuevo.addActionListener(this);
		btnIngresarNuevo.setBounds(824, 83, 150, 23);
		getContentPane().add(btnIngresarNuevo);

		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(824, 109, 150, 23);
		getContentPane().add(btnModificar);

		btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(this);
		btnGrabar.setBounds(824, 143, 150, 23);
		getContentPane().add(btnGrabar);

		lblPedidos = new JLabel("Pedidos");
		lblPedidos.setBounds(10, 188, 53, 14);
		getContentPane().add(lblPedidos);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(73, 184, 901, 144);
		getContentPane().add(scrollPane);

		tblPedidos = new JTable();
		tblPedidos.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblPedidos);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(73, 370, 901, 180);
		getContentPane().add(scrollPane_1);

		tblConsumo = new JTable();
		tblConsumo.setFillsViewportHeight(true);
		scrollPane_1.setViewportView(tblConsumo);

		lblConsumos = new JLabel("Consumos");
		lblConsumos.setBounds(10, 371, 53, 14);
		getContentPane().add(lblConsumos);

		modelo = new DefaultTableModel();
		modelo.addColumn("Código Reserva");
		modelo.addColumn("Código Cliente");
		modelo.addColumn("Usuario");
		modelo.addColumn("Bebidas");
		modelo.addColumn("Cantidad");
		modelo.addColumn("Precio");
		modelo.addColumn("Piqueos");
		modelo.addColumn("Cantidad");
		modelo.addColumn("Precio");
		modelo.addColumn("Subtotal");
		tblPedidos.setModel(modelo);

		modelox = new DefaultTableModel();
		modelox.addColumn("Código Consumo");
		modelox.addColumn("Código Cliente");
		modelox.addColumn("Código Usuario");
		modelox.addColumn("Fecha");
		modelox.addColumn("Total a Pagar");
		modelox.addColumn("Estado");
		tblConsumo.setModel(modelox);

		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(this);
		btnFiltrar.setBounds(508, 143, 89, 23);
		getContentPane().add(btnFiltrar);

		lblTotal = new JLabel("Total:");
		lblTotal.setBounds(728, 339, 46, 14);
		getContentPane().add(lblTotal);

		txtTotal = new JTextField();
		txtTotal.setEditable(false);
		txtTotal.setBounds(824, 336, 150, 20);
		getContentPane().add(txtTotal);
		txtTotal.setColumns(10);

		lblEstado = new JLabel("Estado");
		lblEstado.setBounds(617, 11, 46, 14);
		getContentPane().add(lblEstado);

		cboEstado = new JComboBox<String>();
		cboEstado.setModel(new DefaultComboBoxModel<String>(new String[] { "0", "1" }));
		cboEstado.setBounds(673, 8, 86, 20);
		getContentPane().add(cboEstado);

		txtEstado = new JTextField();
		txtEstado.setEditable(false);
		txtEstado.setBounds(673, 33, 86, 20);
		getContentPane().add(txtEstado);
		txtEstado.setColumns(10);

		listarPedido();
		habilitarEntradas(false);
		listarConsumo();

	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnFiltrar) {
			actionPerformedBtnFiltrar(arg0);
		}
		if (arg0.getSource() == btnBuscarUsuario) {
			actionPerformedBtnBuscarUsuario(arg0);
		}
		if (arg0.getSource() == btnBuscarCliente) {
			actionPerformedBtnBuscarCliente(arg0);
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

	// *********************************************************************************
	ArregloRegistroPedido registro = new ArregloRegistroPedido("RegistroPedido.txt");
	ArregloBebida beb = new ArregloBebida("Bebidas.txt");
	ArregloPiqueo piq = new ArregloPiqueo("Piqueos.txt");
	ArregloConsumo con = new ArregloConsumo("Consumo.txt");
	// *********************************************************************************

	// BOTON: ACEPTAR
	protected void actionPerformedBtnAceptar(ActionEvent arg0) {
		String codigo = correlativoCodigo();
		String codCliente = leerCodCliente();
		if (codCliente.length() > 0) {
			String codUsuario = leerCodUsuario();
			if (codUsuario.length() > 0) {
				String fecha = leerFecha();
				if (fecha.length() == 10) {
					double total = leerTotal();
					int estado = leerEstado();
					Consumo nuevo = new Consumo(codigo, codCliente, codUsuario, fecha, total, estado);
					con.adicionar(nuevo);
					listarConsumo();
				}
				else {
					mensaje("El formato de Fecha debe ser dd/mm/aaaa");
					txtFecha.requestFocus();
				}
			}
			else {
				mensaje("Seleccione un Usuario");
				btnBuscarUsuario.requestFocusInWindow();
			}
		}
		else {
			mensaje("Seleccione un Cliente");
			btnBuscarCliente.requestFocusInWindow();
		}
	}

	// BOTON: CANCELAR
	protected void actionPerformedBtnCancelar(ActionEvent arg0) {
		listarPedido();
		limpieza();
		habilitarEntradas(false);
		btnIngresarNuevo.setEnabled(true);
		btnModificar.setEnabled(true);
	}

	// BOTON: INGRESAR NUEVO
	protected void actionPerformedBtnIngresarNuevo(ActionEvent arg0) {
		limpieza();
		habilitarEntradas(true);
		btnBuscarCliente.requestFocusInWindow();
		txtCodigo.setText("" + correlativoCodigo());
		btnIngresarNuevo.setEnabled(false);
		btnModificar.setEnabled(true);
	}

	// BOTON: MODIFICAR
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		habilitarEntradas(true);
		btnBuscarCliente.requestFocusInWindow();
		btnIngresarNuevo.setEnabled(true);
		btnModificar.setEnabled(false);
	}

	// BOTON: GRABAR
	protected void actionPerformedBtnGrabar(ActionEvent arg0) {

		/**
		 * Actualiza el archivo
		 */
		if (con.existeArchivo()) {
			int ok = confirmar("¿ Desea actualizar \"" + con.getArchivo() + "\" ?");
			if (ok == 0) {
				con.grabarConsumo();
				mensaje("\"" + con.getArchivo() + "\" ha sido actualizado");
			}
			else
				mensaje("No se actualizó  \"" + con.getArchivo() + "\"");
		}
		else {
			con.grabarConsumo();
			mensaje("\"" + con.getArchivo() + "\" ha sido creado");
		}
		limpieza();
		habilitarEntradas(false);
		btnIngresarNuevo.setEnabled(true);
		btnModificar.setEnabled(true);

	}

	// BOTON: BUSCAR CLIENTE
	protected void actionPerformedBtnBuscarCliente(ActionEvent arg0) {
		DlgListarCodigoCliente dc = new DlgListarCodigoCliente();
		dc.setLocationRelativeTo(this);
		dc.setVisible(true);
	}

	// BOTON: BUSCAR USUARIO
	protected void actionPerformedBtnBuscarUsuario(ActionEvent arg0) {
		DlgListarUsuario dc = new DlgListarUsuario();
		dc.setLocationRelativeTo(this);
		dc.setVisible(true);
	}

	// BOTON: FILTRAR
	protected void actionPerformedBtnFiltrar(ActionEvent arg0) {
		filtrarPorCliente();
	}

	public void windowActivated(WindowEvent arg0) {
	}

	public void windowClosed(WindowEvent arg0) {
		if (arg0.getSource() == this) {
			windowClosedThis(arg0);
		}
	}

	public static int DlgConsumoVisible;
	private JButton btnFiltrar;
	private JLabel lblTotal;
	private JTextField txtTotal;
	private JLabel lblEstado;
	private JComboBox<String> cboEstado;
	private JTextField txtEstado;

	public void windowClosing(WindowEvent arg0) {
		DlgConsumoVisible = 0;
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
		DlgConsumoVisible = 1;
	}

	protected void windowClosedThis(WindowEvent arg0) {
	}

	// *********************************************************************************
	// *********************************************************************************

	void listarPedido() {
		txtTotal.setText("");

		modelo.setRowCount(0);
		for (int i = 0; i < registro.tamaño(); i++) {
			// Para obtener el precio de las bebidas*****
			String[] s;
			int n;
			s = registro.obtener(i).getBebidas().split("B");
			// dia = Integer.parseInt(s[0].trim());
			n = (Integer.parseInt(s[1].trim()) - 1);
			// *******************************************

			// Para obtener el precio de las Piqueos*****
			String[] p;
			int m;
			p = registro.obtener(i).getPiqueos().split("P");
			// dia = Integer.parseInt(s[0].trim());
			m = (Integer.parseInt(p[1].trim()) - 1);
			// *******************************************

			Object[] fila = { registro.obtener(i).getCodigoReserva(), registro.obtener(i).getCodigoCliente(),
					registro.obtener(i).getCodigoUsuario(), registro.obtener(i).getBebidas(), 1,
					beb.obtener(n).getPrecio(), registro.obtener(i).getPiqueos(), 1, piq.obtener(m).getPrecio(),
					(beb.obtener(n).getPrecio() + piq.obtener(m).getPrecio()) };
			modelo.addRow(fila);
		}
	}

	void filtrarPorCliente() {
		txtTotal.setText("");
		double totalFinal = 0.0;

		String[] d;// para obtener nro de cliente del txtCliente
		int filtrocliente;
		d = txtCliente.getText().split("Cli");
		filtrocliente = Integer.parseInt(d[1].trim());

		modelo.setRowCount(0);
		for (int i = 0; i < registro.tamaño(); i++) {
			// Para obtener el precio de las bebidas*****
			String[] s;
			int n;
			s = registro.obtener(i).getBebidas().split("B");
			// dia = Integer.parseInt(s[0].trim());
			n = (Integer.parseInt(s[1].trim()) - 1);
			// *******************************************

			// Para obtener el precio de las Piqueos*****
			String[] p;
			int m;
			p = registro.obtener(i).getPiqueos().split("P");
			// dia = Integer.parseInt(s[0].trim());
			m = (Integer.parseInt(p[1].trim()) - 1);
			// *******************************************

			Object[] fila = { registro.obtener(i).getCodigoReserva(), registro.obtener(i).getCodigoCliente(),
					registro.obtener(i).getCodigoUsuario(), registro.obtener(i).getBebidas(), 1,
					beb.obtener(n).getPrecio(), registro.obtener(i).getPiqueos(), 1, piq.obtener(m).getPrecio(),
					(beb.obtener(n).getPrecio() + piq.obtener(m).getPrecio()) };

			String[] r;// para obtener el cliente de cada fila de la tabla
			// y poder compararlo con el cliente del txtCliente
			int nrocliente;
			r = registro.obtener(i).getCodigoCliente().split("Cli");
			nrocliente = Integer.parseInt(r[1].trim());

			if (nrocliente == filtrocliente) {
				modelo.addRow(fila);

				// Para sumar el total:
				double total = (beb.obtener(n).getPrecio() + piq.obtener(m).getPrecio());

				totalFinal = total + totalFinal;

			}
			txtTotal.setText("" + totalFinal);
		}
	}

	void listarConsumo() {
		// para que al iniciar el programa, se seleccione la fila 1
		int posFila = 0;
		if (modelox.getRowCount() > 0)
			posFila = tblConsumo.getSelectedRow();
		if (modelox.getRowCount() == con.tamaño() - 1)
			posFila = con.tamaño() - 1;
		if (posFila == con.tamaño())
			posFila--;

		modelox.setRowCount(0);
		for (int i = 0; i < con.tamaño(); i++) {
			Object[] fila = { con.obtener(i).getCodigoConsumo(), con.obtener(i).getCodigoCliente(),
					con.obtener(i).getCodigoUsuario(), con.obtener(i).getFechaConsumo(),
					con.obtener(i).getImportePagar(), con.obtener(i).getEstado() };
			modelox.addRow(fila);
		}
		// primera fila

		if (con.tamaño() > 0)
			tblConsumo.getSelectionModel().setSelectionInterval(posFila, posFila);
	}

	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}

	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s);
	}

	String leerCodCliente() {
		return txtCliente.getText().trim();
	}

	String leerCodUsuario() {
		return txtUsuario.getText().trim();
	}

	String leerFecha() {
		return txtFecha.getText().trim();
	}

	Double leerTotal() {
		return Double.parseDouble(txtTotal.getText().trim());
	}

	int leerEstado() {
		return cboEstado.getSelectedIndex();
	}

	String correlativoCodigo() {
		int i = con.tamaño() + 1;
		if (i < 10)
			return ("Con100" + i);
		else
			return ("Con10" + i);
	}

	void habilitarEntradas(boolean sino) {

		txtFecha.setEditable(sino);
		cboEstado.setEnabled(sino);
		btnAceptar.setEnabled(sino);
		btnCancelar.setEnabled(sino);
		btnBuscarCliente.setEnabled(sino);
		btnBuscarUsuario.setEnabled(sino);
		btnFiltrar.setEnabled(sino);

	}

	void limpieza() {
		txtCodigo.setText("");
		txtCliente.setText("");
		txtClienteNombre.setText("");
		txtUsuario.setText("");
		txtUsuarioNombre.setText("");
		txtFecha.setText("");
		cboEstado.setSelectedIndex(0);

	}

	void editarFila() {
		if (con.tamaño() == 0)
			limpieza();
		else {
			Consumo x = con.obtener(tblConsumo.getSelectedRow());
			txtCodigo.setText("" + x.getCodigoConsumo());
			cboEstado.setSelectedIndex(x.getEstado());

		}
	}

}
