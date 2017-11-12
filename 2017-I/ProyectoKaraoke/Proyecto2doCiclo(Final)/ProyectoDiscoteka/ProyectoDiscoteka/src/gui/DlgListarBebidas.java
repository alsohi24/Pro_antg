package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloBebida;

import javax.swing.JButton;
import javax.swing.UIManager;
import clases.Bebida;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class DlgListarBebidas extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private JTable tblListarBebidas;
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
					DlgListarBebidas dialog = new DlgListarBebidas();
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
	public DlgListarBebidas() {
		setTitle("Lista Artista");
		setBounds(100, 100, 600, 530);
		getContentPane().setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 452, 470);
		getContentPane().add(scrollPane);

		tblListarBebidas = new JTable();
		tblListarBebidas.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblListarBebidas);

		btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.addActionListener(this);
		btnSeleccionar.setBounds(485, 8, 89, 23);
		getContentPane().add(btnSeleccionar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(485, 42, 89, 23);
		getContentPane().add(btnCancelar);

		modelo = new DefaultTableModel();
		modelo.addColumn("Nombre");
		modelo.addColumn("Marca");
		modelo.addColumn("Tipo de Bebida");
		modelo.addColumn("Precio");
		tblListarBebidas.setModel(modelo);

		listarBebidas();

	}

	ArregloBebida ab = new ArregloBebida("Bebidas.txt");

	// Metodo Listar
	
	void listarBebidas() {
		modelo.setRowCount(0);
		for (int i = 0; i < ab.tamaño(); i++) {
			Object[] fila = { ab.obtener(i).getNombre(), ab.obtener(i).getMarca(), ab.obtener(i).getTipoBebida(),
								ab.obtener(i).getPrecio(), };
			modelo.addRow(fila);
		}
	}

	// variables globales
	public static String codigo, nombre, marca;
	public static double precio;
	
	void editarFila() {
		if (ab.tamaño() == 0)
			limpieza();
		else {
			Bebida x = ab.obtener(tblListarBebidas.getSelectedRow());
			codigo = x.getIdBebida();
			nombre = x.getNombre();
			marca = x.getMarca();
			precio = x.getPrecio();

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
	 editarFila();
	 DlgRegistroPedido.txtBebidas.setText(codigo);
	 dispose();
	 
	}
}

