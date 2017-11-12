package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import arreglos.ArregloRegistroPedido;
import arreglos.ArregloCancion;
import arreglos.ArregloCliente;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import java.awt.event.WindowListener;
import java.awt.event.WindowEvent;

public class DlgReportarUsuCli extends JDialog implements ActionListener, ItemListener, MouseListener, WindowListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblreserva;
	public static JTextField txtReserva;
	private JButton btnReportar;
	private JButton btnCancelar;
	private JScrollPane scrollPane;
	private JTable tblUsuario;
	private DefaultTableModel modelo;
	private JLabel lblimagenUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgReportarUsuCli dialog = new DlgReportarUsuCli();
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
	public DlgReportarUsuCli() {
		addWindowListener(this);
		setIconImage(Toolkit.getDefaultToolkit().getImage("imagenes/microfono.png"));
		setTitle("Reportar");
		setBounds(100, 100, 1000, 510);
		getContentPane().setLayout(null);

		lblimagenUsuario = new JLabel("");
		lblimagenUsuario.setBounds(10, 10, 110, 100);
		lblimagenUsuario.setBackground(Color.GRAY);
		lblimagenUsuario.setIcon(new ImageIcon("imagenes/DLGusuario1.png"));
		getContentPane().add(lblimagenUsuario);

		lblreserva = new JLabel("");
		lblreserva.setBounds(210, 72, 115, 14);
		getContentPane().add(lblreserva);

		txtReserva = new JTextField();
		txtReserva.setVisible(false);
		txtReserva.addMouseListener(this);
		txtReserva.setEnabled(false);
		txtReserva.addActionListener(this);
		txtReserva.setBounds(335, 69, 89, 20);
		getContentPane().add(txtReserva);
		txtReserva.setColumns(10);

		btnReportar = new JButton("Reportar");
		btnReportar.setVisible(false);
		btnReportar.setBounds(603, 30, 150, 23);
		btnReportar.addActionListener(this);
		getContentPane().add(btnReportar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(603, 66, 150, 23);
		getContentPane().add(btnCancelar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 150, 964, 315);
		getContentPane().add(scrollPane);

		tblUsuario = new JTable();
		tblUsuario.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblUsuario);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(396, 492, 2, 2);
		getContentPane().add(scrollPane_1);
		
		lblReservapor = new JLabel("Reserva por :");
		lblReservapor.setBounds(210, 34, 89, 14);
		getContentPane().add(lblReservapor);
		
		cboReserva = new JComboBox<Object>();
		cboReserva.addItemListener(this);
		cboReserva.setModel(new DefaultComboBoxModel<Object>(new String[] {"--", "Cliente", "Usuario", "Rango de Fecha"}));
		cboReserva.setBounds(335, 31, 89, 20);
		getContentPane().add(cboReserva);
		
		cboDesde = new JComboBox<String>();
		cboDesde.setModel(new DefaultComboBoxModel<String>(new String[] {"2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", 
				"2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", 
				"1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", 
				"1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", 
				"1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", 
				"1953", "1952", "1951", "1950"}));
		cboDesde.setBounds(335, 69, 63, 20);
		getContentPane().add(cboDesde);
		
		cboHasta = new JComboBox<String>();
		cboHasta.setModel(new DefaultComboBoxModel<String>(new String[] {"2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", 
				"2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", 
				"1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", 
				"1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", 
				"1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", 
				"1953", "1952", "1951", "1950"}));
		cboHasta.setBounds(460, 69, 63, 20);
		getContentPane().add(cboHasta);
		cboDesde.setVisible(false);
		cboHasta.setVisible(false);

	}
	
	ArregloRegistroPedido registro = new ArregloRegistroPedido("RegistroPedido.txt");
	ArregloCancion acan = new ArregloCancion("Cancion.txt");
	ArregloCliente acli = new ArregloCliente("Clientes.txt");
	private JScrollPane scrollPane_1;
	private JLabel lblReservapor;
	private JComboBox<Object> cboReserva;
	private int cod;
	public static int DlgConsumoVisible;
	private JComboBox<String> cboDesde;
	private JComboBox<String> cboHasta;
	
	
	//listarRegistroPedido();
	

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(arg0);
		}
		if (arg0.getSource() == btnReportar) {
			actionPerformedBtnIngresarUsuario(arg0);
		}
	}
	public void itemStateChanged(ItemEvent arg0) {
		if (arg0.getSource() == cboReserva) {
			itemStateChangedComboBox(arg0);
		}
	}
	//Boton Ingresar
	protected void actionPerformedBtnIngresarUsuario(ActionEvent arg0) {
		//listarRegistroPedido();
		cod = cboReserva.getSelectedIndex();
		switch(cod){
			case 0 : 	break;
			case 1 : 	filtrarPorCliente(); break;
			case 2 :  	filtrarPorUsuario(); break;
			default : 	filtrarPorFecha();
		}
	}
	
	// Metodos tipo void sin parametros

	String leerCodigoCliente() {
		return txtReserva.getText().trim();
	}

	
	//FILTRO POR CLIENTE
	void filtrarPorCliente(){
		String[] r;// para obtener nro de cliente del txtReserva
		int filtrocliente;
		r = txtReserva.getText().split("Cli");
		filtrocliente = Integer.parseInt(r[1].trim());

		modelo.setRowCount(0);
		for (int i = 0; i < registro.tamaño(); i++){
			Object[] fila = { registro.obtener(i).getCodigoCliente(), registro.obtener(i).getCodigoReserva(), 
					registro.obtener(i).getCancion(), registro.obtener(i).getBebidas(),
					registro.obtener(i).getPiqueos(), registro.obtener(i).getEstadoReserva() };

			String[] c;// para obtener el cliente de cada fila de la tabla
			// y poder compararlo con el cliente del txtCliente
			int nrocliente;
			c = registro.obtener(i).getCodigoCliente().split("Cli");
			nrocliente = Integer.parseInt(c[1].trim());
			if (nrocliente == filtrocliente) {
				modelo.addRow(fila);
			}
		}
	}
	
	void filtrarPorUsuario(){
		String[] r;// para obtener nro de cliente del txtReserva
		int filtrocliente;
		r = txtReserva.getText().split("U");
		filtrocliente = Integer.parseInt(r[1].trim());

		modelo.setRowCount(0);
		for (int i = 0; i < registro.tamaño(); i++){
			Object[] fila = { registro.obtener(i).getCodigoUsuario(), registro.obtener(i).getCodigoReserva(), 
					registro.obtener(i).getCancion(), registro.obtener(i).getBebidas(),
					registro.obtener(i).getPiqueos(), registro.obtener(i).getEstadoReserva() };

			String[] c;// para obtener el cliente de cada fila de la tabla
			// y poder compararlo con el cliente del txtCliente
			int nrocliente;
			c = registro.obtener(i).getCodigoUsuario().split("U");
			nrocliente = Integer.parseInt(c[1].trim());
			if (nrocliente == filtrocliente) {
				modelo.addRow(fila);
			}
		}
	}
	
	void filtrarPorFecha(){
		int desde = Integer.parseInt((String) cboDesde.getSelectedItem());
		int hasta = Integer.parseInt((String) cboHasta.getSelectedItem());
		int año;
		
		modelo.setRowCount(0);
		for (int i = 0; i < registro.tamaño(); i++) {
			Object[] fila = { registro.obtener(i).getCodigoReserva(), 
					registro.obtener(i).getCancion(), registro.obtener(i).getBebidas(),
					registro.obtener(i).getPiqueos(), registro.obtener(i).getEstadoReserva() };

			String[] s;//para obtener el año de cada fila de la tabla
			//y poder compararlo con los años de los combo box
			s = acli.obtener(i).getFechaDeAfiliacion().split("/");
			//dia = Integer.parseInt(s[0].trim());
			//mes = Integer.parseInt(s[1].trim());
			año = Integer.parseInt(s[2].trim());
			if ((año >= desde) && (año <= hasta)) {
				modelo.addRow(fila);
			}

		}
	}

	protected void actionPerformedBtnCancelar(ActionEvent arg0) {
		dispose();
	}
	
	//Eventos de MOUSE
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == txtReserva) {
			mouseClickedTxtCodigoCliente(arg0);
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
	protected void mouseClickedTxtCodigoCliente(MouseEvent arg0) {
		cod = cboReserva.getSelectedIndex();
		switch(cod){
			case 0: break;
			case 1:	DlgListarCodigoCliente lc = new DlgListarCodigoCliente();
					lc.setVisible(true);
					lc.setLocationRelativeTo(this);
					break;
			case 2:	DlgListarUsuario lu = new DlgListarUsuario();
					lu.setVisible(true);
					lu.setLocationRelativeTo(this);
					break;
			default : ;
		}
		
	}
	
	//CAMBIA EL CBO
	protected void itemStateChangedComboBox(ItemEvent arg0) {

		cod = cboReserva.getSelectedIndex();
		switch(cod){
			case 0: lblreserva.setText("");
					txtReserva.setVisible(false);
					btnReportar.setVisible(false);
					scrollPane.setViewportView(null);
					break;
			case 1: lblreserva.setText("Código de Cliente :");
					txtReserva.setVisible(true);
					txtReserva.setText("");
					btnReportar.setVisible(true);
					this.setTitle(" Reporte | Cliente");
					scrollPane.setViewportView(tblUsuario);
					modelo = new DefaultTableModel();
					modelo.addColumn("Código Cliente");
					modelo.addColumn("Código Reserva");
					modelo.addColumn("Nombres");
					modelo.addColumn("Bebidas");
					modelo.addColumn("Piqueos");
					modelo.addColumn("Estado Reserva");
					tblUsuario.setModel(modelo);
					break;
			case 2: lblreserva.setText("Código de Usuario :");
					txtReserva.setVisible(true);
					txtReserva.setText("");
					btnReportar.setVisible(true);
					this.setTitle(" Reporte | Usuario");
					scrollPane.setViewportView(tblUsuario);
					modelo = new DefaultTableModel();
					modelo.addColumn("Código Usuario");
					modelo.addColumn("Código Reserva");
					modelo.addColumn("Nombres");
					modelo.addColumn("Bebidas");
					modelo.addColumn("Piqueos");
					modelo.addColumn("Estado Reserva");
					tblUsuario.setModel(modelo);
					break;
			default:lblreserva.setText("Fecha :");
					txtReserva.setVisible(false);
					txtReserva.setText("");
					btnReportar.setVisible(true);
					this.setTitle(" Reporte | Fecha");
					cboDesde.setVisible(true);
					cboHasta.setVisible(true);
					scrollPane.setViewportView(tblUsuario);
					modelo = new DefaultTableModel();
					modelo.addColumn("Fecha Ingresada");
					modelo.addColumn("Código Reserva");
					modelo.addColumn("Nombres");
					modelo.addColumn("Bebidas");
					modelo.addColumn("Piqueos");
					modelo.addColumn("Estado Reserva");
					tblUsuario.setModel(modelo);
		}
	}
	
	// EVENTOS DE VENTANA
	public void windowActivated(WindowEvent arg0) {
	}
	public void windowClosed(WindowEvent arg0) {
		DlgConsumoVisible = 0;
	}
	public void windowClosing(WindowEvent arg0) {
	}
	public void windowDeactivated(WindowEvent arg0) {
	}
	public void windowDeiconified(WindowEvent arg0) {
	}
	public void windowIconified(WindowEvent arg0) {
	}
	public void windowOpened(WindowEvent arg0) {
		if (arg0.getSource() == this) {
			windowOpenedThis(arg0);
		}
	}
	protected void windowOpenedThis(WindowEvent arg0) {
		DlgConsumoVisible = 1;
	}
}
