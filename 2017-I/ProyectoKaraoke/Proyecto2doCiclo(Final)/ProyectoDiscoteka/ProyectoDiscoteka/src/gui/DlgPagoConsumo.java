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

import arreglos.ArregloConsumo;
import clases.Consumo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class DlgPagoConsumo extends JDialog implements ActionListener, WindowListener, MouseListener {

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
	private JButton btnCancelar;
	private JButton btnGrabar;
	private JScrollPane scrollPane_1;
	private JTable tblConsumo;
	private DefaultTableModel modelox;
	private JButton btnPagar;
	private JButton btnFiltrar;
	private JButton btnUsarFiltros;

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
					DlgPagoConsumo dialog = new DlgPagoConsumo();
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
	public DlgPagoConsumo() {
		addWindowListener(this);
		setTitle("Registro | Consumo");
		setBounds(100, 100, 1000, 600);
		getContentPane().setLayout(null);

		lblImg = new JLabel("");
		lblImg.setIcon(new ImageIcon("imagenes/DlgPagoConsumo.png"));
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

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(824, 32, 150, 23);
		getContentPane().add(btnCancelar);

		btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(this);
		btnGrabar.setBounds(824, 143, 150, 23);
		getContentPane().add(btnGrabar);

		btnPagar = new JButton("Pagar");
		btnPagar.addActionListener(this);
		btnPagar.setBounds(824, 7, 150, 23);
		getContentPane().add(btnPagar);

		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(this);
		btnFiltrar.setBounds(508, 143, 89, 23);
		getContentPane().add(btnFiltrar);

		btnUsarFiltros = new JButton("Usar Filtros");
		btnUsarFiltros.addActionListener(this);
		btnUsarFiltros.setBounds(508, 7, 89, 23);
		getContentPane().add(btnUsarFiltros);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(20, 206, 954, 344);
		getContentPane().add(scrollPane_1);

		tblConsumo = new JTable();
		tblConsumo.addMouseListener(this);
		tblConsumo.setFillsViewportHeight(true);
		scrollPane_1.setViewportView(tblConsumo);

		modelox = new DefaultTableModel();
		modelox.addColumn("Código Consumo");
		modelox.addColumn("Código Cliente");
		modelox.addColumn("Código Usuario");
		modelox.addColumn("Fecha");
		modelox.addColumn("Total a Pagar");
		modelox.addColumn("Estado");
		tblConsumo.setModel(modelox);

		lblConsumosPendientesDe = new JLabel("Consumos Pendientes de Pago:");
		lblConsumosPendientesDe.setBounds(20, 188, 176, 14);
		getContentPane().add(lblConsumosPendientesDe);

		listarConsumo();
		editarFila();
		habilitarEntradas(false);

	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnFiltrar) {
			actionPerformedBtnFiltrar(arg0);
		}
		if (arg0.getSource() == btnUsarFiltros) {
			actionPerformedBtnUsarFiltros(arg0);
		}
		if (arg0.getSource() == btnPagar) {
			actionPerformedBtnPagar(arg0);
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
		if (arg0.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(arg0);
		}
	}

	// *********************************************************************************
	ArregloConsumo con = new ArregloConsumo("Consumo.txt");
	// *********************************************************************************

	// BOTON: CANCELAR
	protected void actionPerformedBtnCancelar(ActionEvent arg0) {
		listarConsumo();
		limpieza();
		habilitarEntradas(false);

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

	// BOTON: PAGAR
	protected void actionPerformedBtnPagar(ActionEvent arg0) {
		int posFila = tblConsumo.getSelectedRow();
		int estado = 1;
		Consumo x = con.obtener(posFila);
		String codigo = con.obtener(posFila).getCodigoConsumo();
		mensaje("Se cambiara el estado al Consumo Nro: " + codigo);
		x.setEstado(estado);
		listarConsumo();

	}

	// BOTON: USAR FILTROS
	protected void actionPerformedBtnUsarFiltros(ActionEvent arg0) {
		limpieza();
		habilitarEntradas(true);
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

	public static int DlgPagoVisible;
	private JLabel lblConsumosPendientesDe;

	public void windowClosing(WindowEvent arg0) {
		DlgPagoVisible = 0;
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
		DlgPagoVisible = 1;
	}

	protected void windowClosedThis(WindowEvent arg0) {
	}

	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == tblConsumo) {
			mouseClickedTblConsumo(arg0);
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

	// EVENTO AL HACER CLICK EN LA TABLA
	protected void mouseClickedTblConsumo(MouseEvent arg0) {
		editarFila();
		habilitarEntradas(false);
	}

	// *********************************************************************************
	// *********************************************************************************

	void filtrarPorCliente() {

		String[] d;// para obtener nro de cliente del txtCliente
		int filtrocliente;
		d = txtCliente.getText().split("Cli");
		filtrocliente = Integer.parseInt(d[1].trim());

		modelox.setRowCount(0);
		for (int i = 0; i < con.tamaño(); i++) {

			Object[] fila = { con.obtener(i).getCodigoConsumo(), con.obtener(i).getCodigoCliente(),
					con.obtener(i).getCodigoUsuario(), con.obtener(i).getFechaConsumo(),
					con.obtener(i).getImportePagar(), con.obtener(i).getEstado() };

			String[] r;// para obtener el cliente de cada fila de la tabla
			// y poder compararlo con el cliente del txtCliente
			int nrocliente;
			r = con.obtener(i).getCodigoCliente().split("Cli");
			nrocliente = Integer.parseInt(r[1].trim());

			if (nrocliente == filtrocliente) {
				modelox.addRow(fila);

			}

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

	String correlativoCodigo() {
		int i = con.tamaño() + 1;
		if (i < 10)
			return ("Con100" + i);
		else
			return ("Con10" + i);
	}

	void habilitarEntradas(boolean sino) {
		btnCancelar.setEnabled(sino);
		btnBuscarCliente.setEnabled(sino);
		btnBuscarUsuario.setEnabled(sino);

	}

	void limpieza() {
		txtCodigo.setText("");
		txtCliente.setText("");
		txtClienteNombre.setText("");
		txtUsuario.setText("");
		txtUsuarioNombre.setText("");

	}

	void editarFila() {
		if (con.tamaño() == 0)
			limpieza();
		else {
			Consumo x = con.obtener(tblConsumo.getSelectedRow());
			txtCodigo.setText("" + x.getCodigoConsumo());
			txtCliente.setText("" + x.getCodigoCliente());
			txtUsuario.setText("" + x.getCodigoUsuario());

		}
	}
}
