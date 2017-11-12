package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import arreglo.ArregloArtista;
import arreglo.ArregloBebida;
import arreglo.ArregloCancion;
import arreglo.ArregloPedido;
import arreglo.ArregloUsuario;
import clases.Bebida;
import clases.Cancion;
import clases.Pedido;
import clases.Usuario;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.CSS;

import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JTable;

public class DBuscarRegistrosMasPedidos extends JDialog implements ActionListener {
	
	private static final int CIN=0;
	private static final int CUA=1;
	private static final int TRE=2;
	private static final int VEI=3;
	private static final int DIE=4;
	
	private JButton          btnSalir;
	private JTable table;
	private DefaultTableModel modelo = new DefaultTableModel();
	private ArregloUsuario aa = new ArregloUsuario();
	private ArregloPedido ap = new ArregloPedido();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DBuscarRegistrosMasPedidos dialog = new DBuscarRegistrosMasPedidos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DBuscarRegistrosMasPedidos(){
		
		if (ap.tamaño()!=0){
		
		setTitle("Reporte | Buscar usuarios y pedidos");
		setBounds(100, 100, 439, 303);
		getContentPane().setLayout(null);
		
		JLabel lblCancionesRan = new JLabel("Usuarios según pedidos");
		lblCancionesRan.setBounds(10, 11, 271, 14);
		getContentPane().add(lblCancionesRan);
				
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 34, 414, 179);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setModel(modelo);
		scrollPane.setViewportView(table);
		
		modelo.addColumn("CODIGO USUARIO");
		modelo.addColumn("PEDIDO");
				
	    btnSalir = new JButton("Salir");
		btnSalir.setBounds(177, 227, 89, 23);
		btnSalir.addActionListener(this);
		getContentPane().add(btnSalir);
	
		modelo.setRowCount(0);
		
		llenarTabla();
		
		setResizable(false);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		setVisible(true);
		
		} else {
			
			this.dispose();

			JOptionPane.showMessageDialog(this, "Necesita registrar al menos un pedido", "Cuidado, mucho cuidado",
					JOptionPane.ERROR_MESSAGE);
	
		}
	}
		
	
	 private void llenarTabla (){
	    	
		   for(int i=0 ; i<ap.tamaño(); i++){
			   		   
			   
			   Object[]  datos ={ 	Usuario.PRE+ap.obtener(i).getIdUsuario(),
					   				Pedido.PRE+ap.obtener(i).getIdPedido()
					   				};
				                 
			   modelo.addRow(datos);
		         }
		    }
	 
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(arg0.getSource()==btnSalir){
			
			this.dispose();
			
		} 
		
	}

	
	
	
	
}
