package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import arreglos.ArregloArtista;

import javax.swing.JButton;
import javax.swing.UIManager;
import clases.Artista;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class DlgListarArtista extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private JTable tblListarArtista;
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
					DlgListarArtista dialog = new DlgListarArtista();
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
	public DlgListarArtista() {
		setTitle("Lista Artista");
		setBounds(100, 100, 600, 530);
		getContentPane().setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 452, 470);
		getContentPane().add(scrollPane);

		tblListarArtista = new JTable();
		tblListarArtista.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblListarArtista);

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
		tblListarArtista.setModel(modelo);

		listar();
		

	}

	ArregloArtista art = new ArregloArtista("Artista.txt");

	// Metodo Listar
	void listar() {
		modelo.setRowCount(0);
		for (int i = 0; i < art.tamaño(); i++) {
			Object[] fila = { 
					art.obtener(i).getIdArtista(), 
					art.obtener(i).getNombreArtistico() };
			modelo.addRow(fila);
		}
	}

	// variables globales
	public static String codigo, nombre;
	
	void editarFila() {
		if (art.tamaño() == 0)
			limpieza();
		else {
			Artista x = art.obtener(tblListarArtista.getSelectedRow());
			codigo = x.getIdArtista();
			nombre = x.getNombreArtistico();
		}
	}

	void limpieza() {
	}

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnSeleccionar) {
			actionPerformedBtnSeleccionar(arg0);
		}
	}
	
	//Boton, para que la fila seleccionada, sea la elegida
	//Luego cierra la ventana
	protected void actionPerformedBtnSeleccionar(ActionEvent arg0) {
	 editarFila();
	 DlgCancion.txtArtista.setText(codigo);
	 DlgCancion.txtArtistaNombre.setText(nombre);
	 dispose();
	 
	}
}
