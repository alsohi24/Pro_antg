package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import java.awt.Color;

import arreglos.ArregloRegistroPedido;
import arreglos.ArregloUsuario;


import java.awt.Toolkit;

public class DlgReporteUsuPedidos extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblreserva;
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
					DlgReporteUsuPedidos dialog = new DlgReporteUsuPedidos();
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
	public DlgReporteUsuPedidos() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("imagenes/microfono.png"));
		setTitle("Reportar");
		setBounds(100, 100, 780, 510);
		getContentPane().setLayout(null);

		lblimagenUsuario = new JLabel("");
		lblimagenUsuario.setBounds(10, 10, 110, 100);
		lblimagenUsuario.setBackground(Color.GRAY);
		lblimagenUsuario.setIcon(new ImageIcon("imagenes/DLGusuario1.png"));
		getContentPane().add(lblimagenUsuario);

		lblreserva = new JLabel("");
		lblreserva.setBounds(210, 72, 115, 14);
		getContentPane().add(lblreserva);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 150, 743, 315);
		getContentPane().add(scrollPane);

		tblUsuario = new JTable();
		tblUsuario.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblUsuario);

		modelo = new DefaultTableModel();
		modelo.addColumn("Código Usuario");
		modelo.addColumn("Nombre Usuario");
		modelo.addColumn("Apellido Usuario");
		modelo.addColumn("Tipo Usuario");
		tblUsuario.setModel(modelo);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(396, 492, 2, 2);
		getContentPane().add(scrollPane_1);
		
		// LISTAR
		filtrarPorUsuario();

	}
	
	private JScrollPane scrollPane_1;
	ArregloRegistroPedido registro = new ArregloRegistroPedido("RegistroPedido.txt");
	ArregloUsuario au = new ArregloUsuario("Usuarios.txt");
	
	// Metodo Listar
	void listarRegistroPedido() {
		modelo.setRowCount(0);
		for (int i = 0; i < registro.tamaño(); i++) {
			Object[] fila = { registro.obtener(i).getCodigoCliente(), registro.obtener(i).getCancion(),
							registro.obtener(i).getCodigoReserva(), registro.obtener(i).getBebidas(),
							registro.obtener(i).getPiqueos(),registro.obtener(i).getEstadoReserva(), };
			modelo.addRow(fila);
		}
	}
	
	
	void filtrarPorUsuario(){
		String[] r;// para obtener nro de cliente del txtReserva
		String nomUsu,apUsu;
		int filtroUsu, tipoUsu;

		modelo.setRowCount(0);
		for (int i = 0; i < registro.tamaño(); i++){
			r = registro.obtener(i).getCodigoUsuario().split("U");
			filtroUsu = Integer.parseInt(r[1]);
			nomUsu = au.obtener(filtroUsu).getNombres();
			apUsu = au.obtener(filtroUsu).getApellidoPaterno() + " " + au.obtener(filtroUsu).getApellidoMaterno();
			tipoUsu = au.obtener(filtroUsu).getTipoEmpleado();
			
			Object[] fila = { registro.obtener(i).getCodigoUsuario(), nomUsu, 
					apUsu, tipoUsu };
			
			modelo.addRow(fila);
		}
	}
	

}
