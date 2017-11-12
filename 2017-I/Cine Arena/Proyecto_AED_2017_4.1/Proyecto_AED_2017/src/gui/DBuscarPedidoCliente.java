package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import arreglo.ArregloCliente;
import arreglo.ArregloPedido;
import clases.Artista;
import clases.Cliente;
import clases.Pedido;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class DBuscarPedidoCliente extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private	JComboBox<String> cboClientes;
	private JButton btnSalir;
	
	private ArregloCliente ac = new ArregloCliente();
	private ArregloPedido ap = new ArregloPedido();
	private String[] stringClientes = new String[ac.tamaño()];
	private JTable table;
	private DefaultTableModel modelo = new DefaultTableModel();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DBuscarPedidoCliente dialog = new DBuscarPedidoCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DBuscarPedidoCliente() {
		
		if (ac.tamaño()!=0){
		
		setTitle("Reportes | Buscar pedidos por cliente");
		setBounds(100, 100, 456, 388);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		//LLeno el combo con String de genero
		for(int i=0;i<ac.tamaño();i++){
				
			stringClientes[i] = Cliente.PRE+ac.obtener(i).getIdCliente();
				
		}
		
		cboClientes = new JComboBox<String>();
		cboClientes.setBounds(10, 45, 420, 20);
		cboClientes.setModel(new DefaultComboBoxModel<>(stringClientes));
		cboClientes.addActionListener(this);
		cboClientes.setSelectedIndex(0);
		contentPanel.add(cboClientes);
		
		JLabel lblSeleccioneUnCliente = new JLabel("Seleccione un cliente");
		lblSeleccioneUnCliente.setBounds(10, 20, 420, 14);
		contentPanel.add(lblSeleccioneUnCliente);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 76, 420, 226);
		contentPanel.add(scrollPane);
		
		modelo.addColumn("CÓDIGO");
		modelo.addColumn("CÓDIGO CLIENTE");
		modelo.addColumn("FECHA");
		modelo.addColumn("ESTADO");
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setModel(modelo);
		scrollPane.setViewportView(table);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(165, 313, 89, 23);
		btnSalir.addActionListener(this);
		contentPanel.add(btnSalir);
		
		modelo.setRowCount(0);
		
		llenarTabla(cboClientes.getSelectedIndex());
		
		setResizable(false);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		setVisible(true);	
			
		} else {
			
			this.dispose();

			JOptionPane.showMessageDialog(this, "Necesita registrar al menos un cliente", "Cuidado, mucho cuidado",
					JOptionPane.ERROR_MESSAGE);
		
		
		}		

	}

	private void llenarTabla(int cliente) {
		
		
		for(int i=0;i<ap.tamaño();i++){
			
			Object[] datos = {Pedido.PRE+ap.obtener(i).getIdPedido(),
					Cliente.PRE+ac.obtener(ap.obtener(i).getIdCliente()).getIdCliente(),
					ap.obtener(i).getFechaPedido(),
					Pedido.obtenerEstado(ap.obtener(i).getEstado())
					};
			
			//Valido que sea el cliente
			if (ap.obtener(i).getIdCliente()==cliente){
			modelo.addRow(datos);
			}
			}
				
		}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==cboClientes){
			
			modelo.setRowCount(0);
			
			llenarTabla(cboClientes.getSelectedIndex());
			
		} else {
			
			this.dispose();
			
		}
		
	}
}
