package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloCancion;

import javax.swing.JButton;
import javax.swing.UIManager;
import clases.Cancion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class DlgListarCancion extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private JTable tblListarCancion;
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
					DlgListarCancion dialog = new DlgListarCancion();
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
	public DlgListarCancion() {
		setTitle("Lista Artista");
		setBounds(100, 100, 600, 530);
		getContentPane().setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 452, 470);
		getContentPane().add(scrollPane);

		tblListarCancion = new JTable();
		tblListarCancion.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblListarCancion);

		btnSeleccionar = new JButton("Seleccionar");
		btnSeleccionar.addActionListener(this);
		btnSeleccionar.setBounds(485, 8, 89, 23);
		getContentPane().add(btnSeleccionar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(485, 42, 89, 23);
		getContentPane().add(btnCancelar);

		modelo = new DefaultTableModel();
		modelo.addColumn("Nombre Cancion");
		modelo.addColumn("Nombre Artista");
		tblListarCancion.setModel(modelo);

		listar();

	}

	ArregloCancion acan = new ArregloCancion("Cancion.txt");

	// Metodo Listar
	void listar() {
		modelo.setRowCount(0);
		for (int i = 0; i < acan.tamaño(); i++) {
			Object[] fila = { 
					acan.obtener(i).getNombre(), 
					acan.obtener(i).getIdArtista() };
			modelo.addRow(fila);
		}
	}

	// variables globales
	public static String nomArtista, nombre;
	
	void editarFila() {
		if (acan.tamaño() == 0)
			limpieza();
		else {
			Cancion x = acan.obtener(tblListarCancion.getSelectedRow());
			nombre = x.getNombre();
			nomArtista = x.getIdArtista();

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
	 editarFila();
	 DlgRegistroPedido.txtCancion.setText(nombre);
	 dispose();
	 
	}
	protected void actionPerformedBtnCancelar(ActionEvent arg0) {
		dispose();
	}
}
