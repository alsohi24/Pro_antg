package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloPiqueo;

import javax.swing.JButton;
import javax.swing.UIManager;
import clases.Piqueo;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class DlgListarPiqueos extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private JTable tblListarPiqueos;
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
					DlgListarPiqueos dialog = new DlgListarPiqueos();
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
	public DlgListarPiqueos() {
		setTitle("Lista Artista");
		setBounds(100, 100, 600, 530);
		getContentPane().setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 452, 470);
		getContentPane().add(scrollPane);

		tblListarPiqueos = new JTable();
		tblListarPiqueos.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblListarPiqueos);

		btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.addActionListener(this);
		btnSeleccionar.setBounds(485, 8, 89, 23);
		getContentPane().add(btnSeleccionar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(485, 42, 89, 23);
		getContentPane().add(btnCancelar);

		modelo = new DefaultTableModel();
		modelo.addColumn("Nombre");
		modelo.addColumn("Tipo de Piqueo");
		modelo.addColumn("Precio");
		tblListarPiqueos.setModel(modelo);

		listarPiqueos();

	}

	ArregloPiqueo ap = new ArregloPiqueo("Piqueos.txt");

	// Metodo Listar
	
	void listarPiqueos() {
		modelo.setRowCount(0);
		for (int i = 0; i < ap.tamaño(); i++) {
			Object[] fila = { ap.obtener(i).getNombre(), ap.obtener(i).getTipoPiqueo(),
								ap.obtener(i).getPrecio(), };
			modelo.addRow(fila);
		}
	}

	// variables globales
	public static String codigo, nombre;
	public static int marca;
	public static double precio;
	
	void editarFila() {
		if (ap.tamaño() == 0)
			limpieza();
		else {
			Piqueo x = ap.obtener(tblListarPiqueos.getSelectedRow());
			codigo = x.getIdPiqueo();
			nombre = x.getNombre();
			marca = x.getTipoPiqueo();
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
	 DlgRegistroPedido.txtPiqueos.setText(codigo);
	 dispose();
	 
	}
}
