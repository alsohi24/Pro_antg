package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloUsuario;

import javax.swing.JButton;
import javax.swing.UIManager;
import clases.Usuario;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgListarUsuario extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private JTable tblListarUsuario;
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
					DlgListarUsuario dialog = new DlgListarUsuario();
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
	public DlgListarUsuario() {
		setTitle("Lista Usuario");
		setBounds(100, 100, 600, 530);
		getContentPane().setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 452, 470);
		getContentPane().add(scrollPane);

		tblListarUsuario = new JTable();
		tblListarUsuario.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblListarUsuario);

		btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.addActionListener(this);
		btnSeleccionar.setBounds(485, 8, 89, 23);
		getContentPane().add(btnSeleccionar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(485, 42, 89, 23);
		getContentPane().add(btnCancelar);

		modelo = new DefaultTableModel();
		modelo.addColumn("Codigo");
		modelo.addColumn("Nombre");
		tblListarUsuario.setModel(modelo);

		listar();

	}

	ArregloUsuario usu = new ArregloUsuario("Usuarios.txt");

	// Metodo Listar
	void listar() {
		modelo.setRowCount(0);
		for (int i = 0; i < usu.tamaño(); i++) {
			Object[] fila = { usu.obtener(i).getIdUsuario(), usu.obtener(i).getNombres() };
			modelo.addRow(fila);
		}
	}

	// variables globales
	public static String codigo, nombre;

	void editarFila() {

		if (usu.tamaño() == 0)
			limpieza();
		else {
			Usuario x = usu.obtener(tblListarUsuario.getSelectedRow());
			codigo = x.getIdUsuario();
			nombre = x.getNombres();

		}
	}

	void limpieza() {
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnSeleccionar) {
			actionPerformedBtnSeleccionar(arg0);
		}
	}

	protected void actionPerformedBtnSeleccionar(ActionEvent arg0) {
		if (DlgCliente.DlgClienteVisible == 1) {

			editarFila();
			DlgCliente.txtUsuario.setText(codigo);
			DlgCliente.txtUsuarioNombre.setText(nombre);
			dispose();
		}
		else if (DlgRegistroPedido.DlgPedidoVisible == 1) {

			editarFila();
			DlgRegistroPedido.txtUsuario.setText(codigo);
			DlgRegistroPedido.txtNombreUsuario.setText(nombre);
			dispose();
		}
		else if (DlgRegistroConsumo.DlgConsumoVisible == 1) {

			editarFila();
			DlgRegistroConsumo.txtUsuario.setText(codigo);
			DlgRegistroConsumo.txtUsuarioNombre.setText(nombre);
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
}
