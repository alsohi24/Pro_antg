package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import arreglos.ArregloConsumo;
import clases.Consumo;
import arreglos.ArregloRegistroPedido;
import clases.RegistroPedido;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgConsumo extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblBuscar;
	private JButton btnBuscar;
	private JTextField txtconsumo;
	private JTable tblTabla;
	private JScrollPane scrollPane;
	private JButton btnlistar;
	private JButton btnsalir;
	private JScrollPane scrollPane_1;
	private JTextArea txtS;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgConsumo dialog = new DlgConsumo();
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
	public DlgConsumo() {
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		lblBuscar = new JLabel("Buscar");
		lblBuscar.setBounds(10, 18, 46, 14);
		contentPanel.add(lblBuscar);

		btnBuscar = new JButton("Detalle Consumo");
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(222, 11, 176, 23);
		contentPanel.add(btnBuscar);

		txtconsumo = new JTextField();
		txtconsumo.setColumns(10);
		txtconsumo.setBounds(96, 15, 86, 20);
		contentPanel.add(txtconsumo);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 43, 626, 198);
		contentPanel.add(scrollPane);

		tblTabla = new JTable();
		scrollPane.setViewportView(tblTabla);
		tblTabla.setFillsViewportHeight(true);

		modelo = new DefaultTableModel();
		modelo.addColumn("código Consumo");
		modelo.addColumn("Codigo Cliente");
		modelo.addColumn("Fecha de Consumo");
		modelo.addColumn("Importe a pagar");
		modelo.addColumn("Estado");
		tblTabla.setModel(modelo);

		btnlistar = new JButton("Listar");
		btnlistar.addActionListener(this);
		btnlistar.setBounds(665, 14, 89, 23);
		contentPanel.add(btnlistar);

		btnsalir = new JButton("Salir");
		btnsalir.addActionListener(this);
		btnsalir.setBounds(665, 40, 89, 23);
		contentPanel.add(btnsalir);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 252, 626, 285);
		contentPanel.add(scrollPane_1);

		txtS = new JTextArea();
		txtS.setFont(new Font("Monospaced", Font.PLAIN, 13));
		scrollPane_1.setViewportView(txtS);
		listar();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnsalir) {
			actionPerformedBtnsalir(e);
		}
		if (e.getSource() == btnBuscar) {
			actionPerformedBtnBuscar(e);
		}
		if (e.getSource() == btnlistar) {
			actionPerformedBtnListar(e);
		}
	}

	
	ArregloRegistroPedido registro = new ArregloRegistroPedido("RegistroPedido.txt");
	ArregloConsumo aa = new ArregloConsumo("Consumotxt");
	
	void listar() {
		modelo.setRowCount(0);
		for (int i = 0; i < aa.tamaño(); i++) {
			Object[] fila = { aa.obtener(i).getCodigoConsumo(), aa.obtener(i).getCodigoCliente(),
					aa.obtener(i).getFechaConsumo(), aa.obtener(i).getImportePagar(), aa.obtener(i).getEstado() };
			modelo.addRow(fila);
		}

	}



	protected void actionPerformedBtnListar(ActionEvent e) {

	}

	protected void actionPerformedBtnBuscar(ActionEvent e) {
		txtS.setText("");

		Consumo x = aa.buscar(leerCodigo());
		RegistroPedido o = registro.buscar(leerCodigo());
		if (x != null) {
			imprimir("....................................................");
			imprimir(" Codigo Consumo            : " + x.getCodigoConsumo());
			imprimir(" Codigo Cliente            : " + x.getCodigoCliente());
			imprimir(" Fecha de Consumo          : " + x.getFechaConsumo());
			imprimir("....................................................");
			imprimir(" tipo de Consumo            ");
			imprimir("....................................................");

			imprimir("   : " + o.getBebidas());
			imprimir("                  : " + o.getPiqueos());

		}
		else
			mensaje("no existe codigo");
		txtconsumo.setText("");
		txtconsumo.requestFocus();
	}

	void imprimir(String s) {
		txtS.append(s + "\n");
	}

	String leerCodigo() {
		return txtconsumo.getText();
	}

	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}

	String correlativoCodigo() {
		int i = aa.tamaño() + 1;
		if (i < 10)
			return ("Can100" + i);
		else
			return ("Can10" + i);
	}

	protected void actionPerformedBtnsalir(ActionEvent e) {

	}
}
