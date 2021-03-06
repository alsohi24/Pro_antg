package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.event.MouseListener;

import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import javax.swing.UIManager;
import javax.swing.JTextPane;

import javax.swing.JSeparator;
import arreglos.ArregloCancion;

public class DlgReportarCanciones extends JDialog implements ActionListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnReportar;
	private JButton btnCancelar;
	private JScrollPane scrollPane;
	private JTable tblReporteCancion;
	private DefaultTableModel modelo;
	private JLabel lblimagenUsuario;
	private JLabel lblPeriodo;
	private JComboBox<String> cboDesde;
	private JLabel lblHasta;
	private JComboBox<String> cboHasta;
	private JTextPane txtpnParaSeleccionarLas;
	private JSeparator separator;
	private JSeparator separator_1;

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
					DlgReportarCanciones dialog = new DlgReportarCanciones();
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
	public DlgReportarCanciones() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("imagenes/microfono.png"));
		setTitle("Reporte Canciones");
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(null);

		lblimagenUsuario = new JLabel("");
		lblimagenUsuario.setBounds(10, 10, 176, 166);
		lblimagenUsuario.setBackground(Color.GRAY);
		lblimagenUsuario.setIcon(new ImageIcon("imagenes/DLGcancion1.png"));
		getContentPane().add(lblimagenUsuario);

		btnReportar = new JButton("Reportar");
		btnReportar.setBounds(624, 10, 150, 23);
		btnReportar.addActionListener(this);
		getContentPane().add(btnReportar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(624, 38, 150, 23);
		getContentPane().add(btnCancelar);

		lblPeriodo = new JLabel("Desde:");
		lblPeriodo.setBounds(218, 87, 52, 14);
		getContentPane().add(lblPeriodo);

		cboDesde = new JComboBox<String>();
		cboDesde.setModel(new DefaultComboBoxModel<String>(new String[] { "2017", "2016", "2015", "2014", "2013",
				"2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000",
				"1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987",
				"1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974",
				"1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961",
				"1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950" }));
		cboDesde.setBounds(280, 84, 60, 20);
		getContentPane().add(cboDesde);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 187, 764, 363);
		getContentPane().add(scrollPane);

		tblReporteCancion = new JTable();
		tblReporteCancion.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblReporteCancion);

		modelo = new DefaultTableModel();
		modelo.addColumn("Codigo");
		modelo.addColumn("Nombre");
		modelo.addColumn("Artista");
		modelo.addColumn("Album");
		modelo.addColumn("Fecha Regis.");
		modelo.addColumn("Num. Reproduc.");
		tblReporteCancion.setModel(modelo);

		lblHasta = new JLabel("Hasta:");
		lblHasta.setBounds(392, 87, 52, 14);
		getContentPane().add(lblHasta);

		cboHasta = new JComboBox<String>();
		cboHasta.setModel(new DefaultComboBoxModel<String>(new String[] { "2017", "2016", "2015", "2014", "2013",
				"2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000",
				"1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987",
				"1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974",
				"1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961",
				"1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950" }));
		cboHasta.setBounds(454, 84, 60, 20);
		getContentPane().add(cboHasta);

		separator = new JSeparator();
		separator.setBounds(218, 10, 310, 14);
		getContentPane().add(separator);

		txtpnParaSeleccionarLas = new JTextPane();
		txtpnParaSeleccionarLas.setText(
				"Para seleccionar las canciones mas escuchadas en un rango de tiempo determinado seleccione los periodos que desea, usando las siguientes opciones:\r\n");
		txtpnParaSeleccionarLas.setEnabled(false);
		txtpnParaSeleccionarLas.setBounds(218, 12, 296, 49);
		getContentPane().add(txtpnParaSeleccionarLas);

		separator_1 = new JSeparator();
		separator_1.setBounds(218, 70, 310, 14);
		getContentPane().add(separator_1);

		listar();

	}

	// ***********************************************************************
	ArregloCancion can = new ArregloCancion("Cancion.txt");
	// ***********************************************************************

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(arg0);
		}
		if (arg0.getSource() == btnReportar) {
			actionPerformedBtnReportar(arg0);
		}
	}

	protected void actionPerformedBtnReportar(ActionEvent arg0) {
		reportar();
	}

	protected void actionPerformedBtnCancelar(ActionEvent arg0) {
		listar();
	}

	public void mouseClicked(MouseEvent arg0) {
	}

	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}

	public void mousePressed(MouseEvent arg0) {
	}

	public void mouseReleased(MouseEvent arg0) {
	}

	// ***********************************************************************
	// ***********************************************************************

	// Metodo Listar
	void listar() {
		modelo.setRowCount(0);
		for (int i = 0; i < can.tama�o(); i++) {
			Object[] fila = { can.obtener(i).getIdCancion(), can.obtener(i).getNombre(), can.obtener(i).getIdArtista(),
					can.obtener(i).getAlbum(), can.obtener(i).getFechaRegistro(),
					can.obtener(i).getNumeroReproducciones() };
			modelo.addRow(fila);
		}
	}

	void reportar() {
		
		//capturo las fechas de los combo box y los convierto en numero
		int desde = Integer.parseInt((String) cboDesde.getSelectedItem());
		int hasta = Integer.parseInt((String) cboHasta.getSelectedItem());
		//int dia;
		//int mes;
		int a�o;
		

		modelo.setRowCount(0);
		for (int i = 0; i < can.tama�o(); i++) {
			Object[] fila = { can.obtener(i).getIdCancion(), can.obtener(i).getNombre(), can.obtener(i).getIdArtista(),
					can.obtener(i).getAlbum(), can.obtener(i).getFechaRegistro(),
					can.obtener(i).getNumeroReproducciones() };

			String[] s;//para obtener el a�o de cada fila de la tabla
			//y poder compararlo con los a�os de los combo box
			s = can.obtener(i).getFechaRegistro().split("/");
			//dia = Integer.parseInt(s[0].trim());
			//mes = Integer.parseInt(s[1].trim());
			a�o = Integer.parseInt(s[2].trim());

			if ((a�o >= desde) && (a�o <= hasta)) {
				modelo.addRow(fila);
			}

		}
	}

	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}

	void habilitarEntradas(boolean sino) {
		cboDesde.setEnabled(sino);
		cboHasta.setEnabled(sino);
		btnReportar.setEnabled(sino);
		btnCancelar.setEnabled(sino);

	}

	void limpieza() {
		cboDesde.setSelectedIndex(0);
		cboHasta.setSelectedIndex(0);

	}

}
