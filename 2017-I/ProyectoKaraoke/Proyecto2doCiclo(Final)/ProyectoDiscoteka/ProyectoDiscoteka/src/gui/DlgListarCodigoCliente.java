package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloCliente;

import javax.swing.JButton;
import javax.swing.UIManager;
import clases.Cliente;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgListarCodigoCliente extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private JTable tblListarCodigoCliente;
	private JButton btnSeleccionar;
	private JButton btnCancelar;
	private DefaultTableModel modelo;

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
					DlgListarCodigoCliente dialog = new DlgListarCodigoCliente();
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
	public DlgListarCodigoCliente() {
		setTitle("Lista Artista");
		setBounds(100, 100, 600, 530);
		getContentPane().setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 452, 470);
		getContentPane().add(scrollPane);

		tblListarCodigoCliente = new JTable();
		tblListarCodigoCliente.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblListarCodigoCliente);

		btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.addActionListener(this);
		btnSeleccionar.setBounds(485, 8, 89, 23);
		getContentPane().add(btnSeleccionar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(485, 42, 89, 23);
		getContentPane().add(btnCancelar);

		modelo = new DefaultTableModel();
		modelo.addColumn("Codigo");
		modelo.addColumn("Nombre Cliente");
		tblListarCodigoCliente.setModel(modelo);

		listar();

	}

	ArregloCliente acli = new ArregloCliente("Clientes.txt");

	// Metodo Listar
	void listar() {
		modelo.setRowCount(0);
		for (int i = 0; i < acli.tamaño(); i++) {
			Object[] fila = { acli.obtener(i).getCliente(), acli.obtener(i).getNombre() };
			modelo.addRow(fila);
		}
	}

	// variables globales
	public static String codigo, nombre;

	void editarFila() {
		if (acli.tamaño() == 0)
			limpieza();
		else {
			Cliente x = acli.obtener(tblListarCodigoCliente.getSelectedRow());
			nombre = x.getNombre();
			codigo = x.getCliente();

		}
	}

	void limpieza() {
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(arg0);
		}
		if (arg0.getSource() == btnSeleccionar) {
			actionPerformedBtnSeleccionar(arg0);
		}
	}

	protected void actionPerformedBtnSeleccionar(ActionEvent arg0) {
		if (DlgRegistroPedido.DlgPedidoVisible == 1) {

			editarFila();
			DlgRegistroPedido.txtCodigoCliente.setText(codigo);
			dispose();
		}
		else if (DlgRegistroConsumo.DlgConsumoVisible == 1) {

			editarFila();
			DlgRegistroConsumo.txtCliente.setText(codigo);
			DlgRegistroConsumo.txtClienteNombre.setText(nombre);
			dispose();
		}
		else if (DlgReportarUsuCli.DlgConsumoVisible == 1) {

			editarFila();
			DlgReportarUsuCli.txtReserva.setText(codigo);
			dispose();
		}

		else {
			editarFila();
			DlgSugerencia.txtUsuario.setText(codigo);
			DlgSugerencia.txtNombreUsuario.setText(nombre);
			dispose();
		}

	}

	protected void actionPerformedBtnCancelar(ActionEvent arg0) {
		dispose();
	}
}
