package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloGenero;

import javax.swing.JButton;
import javax.swing.UIManager;
import clases.Genero;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class DlgListarGenero extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private JTable tblListarGenero;
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
					DlgListarGenero dialog = new DlgListarGenero();
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
	public DlgListarGenero() {
		setTitle("Lista Genero");
		setBounds(100, 100, 600, 530);
		getContentPane().setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 452, 470);
		getContentPane().add(scrollPane);

		tblListarGenero = new JTable();
		tblListarGenero.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblListarGenero);

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
		tblListarGenero.setModel(modelo);

		listar();

	}

	ArregloGenero gen = new ArregloGenero("Genero.txt");

	// Metodo Listar
	void listar() {
		modelo.setRowCount(0);
		for (int i = 0; i < gen.tamaño(); i++) {
			Object[] fila = { 
					gen.obtener(i).getIdGenero(), 
					gen.obtener(i).getDescripcion() };
			modelo.addRow(fila);
		}
	}

	// variables globales
	public static String codigo, nombre;
	
	void editarFila() {
		

		if (gen.tamaño() == 0)
			limpieza();
		else {
			Genero x = gen.obtener(tblListarGenero.getSelectedRow());
			codigo = x.getIdGenero();
			nombre = x.getDescripcion();

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
	 DlgArtista.txtGenero.setText(codigo);
	 DlgArtista.txtGeneroNombre.setText(nombre);
	 dispose();
	 
	}
}
