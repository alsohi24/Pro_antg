package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import arreglo.ArregloCliente;
import arreglo.ArregloConsumo;
import arreglo.ArregloUsuario;
import clases.Cliente;
import clases.Consumo;
import clases.Genero;
import clases.Pedido;
import clases.Usuario;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class DPagoConsumo extends JDialog implements ActionListener, MouseListener {
	
	private static final int CODCON=0;
	private static final int CODCLI=1;
	
	private final JPanel contentPanel = new JPanel();
	private JLabel lblDonde;
	private JComboBox<String> cboFiltrarPor;
	private JComboBox<String> cboCodigo;
	private JButton btnPagoEfectivo;
	private JButton btnPagoTarjeta;
	private JButton btnImprimir;
	private JButton btnRegistrarSugerencia;
	private JTable table;
	private DefaultTableModel modelo = new DefaultTableModel();
	
	private ArregloUsuario au = new ArregloUsuario();
	private ArregloConsumo ac = new ArregloConsumo();
	private ArregloCliente acl = new ArregloCliente();
	
	private String[] idConsumos;
	private String[] idClientes;
	
	private int usuarioActual;
	private boolean estado=true;
	private ArrayList<Integer> idsSeleccionados;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DPagoConsumo dialog = new DPagoConsumo(1001);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DPagoConsumo(int usuarioActual) {
		
		this.usuarioActual = usuarioActual;
		
		setTitle("Modulo | Pago Consumo ");
		setBounds(100, 100, 673, 387);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
				
			JLabel lblFiltrarPor = new JLabel("Filtrar por");
			lblFiltrarPor.setBounds(25, 27, 123, 14);
			contentPanel.add(lblFiltrarPor);
		
			cboFiltrarPor= new JComboBox<String>();
			cboFiltrarPor.setBounds(124, 24, 123, 20);
			cboFiltrarPor.setModel(new DefaultComboBoxModel<String>(new String[]{"Código consumo", "Código cliente"}));
			cboFiltrarPor.addActionListener(this);
			contentPanel.add(cboFiltrarPor);
			
			cboCodigo = new JComboBox<String>();
			cboCodigo.setBounds(354, 24, 123, 20);
			cboCodigo.addActionListener(this);
			contentPanel.add(cboCodigo);
		
			btnPagoEfectivo = new JButton("Pago con efectivo");
			btnPagoEfectivo.addActionListener(this);
			btnPagoEfectivo.setBounds(25, 311, 146, 23);
			btnPagoEfectivo.setEnabled(false);
			contentPanel.add(btnPagoEfectivo);
		
			btnPagoTarjeta = new JButton("Pago con tarjeta");
			btnPagoTarjeta.addActionListener(this);
			btnPagoTarjeta.setBounds(181, 311, 146, 23);
			btnPagoTarjeta.setEnabled(false);
			contentPanel.add(btnPagoTarjeta);
		
			btnImprimir = new JButton("Imprimir");
			btnImprimir.addActionListener(this);
			btnImprimir.setBounds(337, 311, 146, 23);
			contentPanel.add(btnImprimir);
		
			btnRegistrarSugerencia = new JButton("Registrar Sugerencia ");
			btnRegistrarSugerencia.addActionListener(this);
			btnRegistrarSugerencia.setBounds(493, 311, 146, 23);
			contentPanel.add(btnRegistrarSugerencia);
		
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(26, 71, 606, 229);
			contentPanel.add(scrollPane);
			
			modelo.addColumn("CODIGO");
			modelo.addColumn("CODIGO CLIENTE");
			modelo.addColumn("FECHA");
			modelo.addColumn("TOTAL");
			modelo.addColumn("ESTADO");
			
			table = new JTable();
			table.setFillsViewportHeight(true);
			table.setModel(modelo);
			table.addMouseListener(this);
			scrollPane.setViewportView(table);
				
			lblDonde = new JLabel("Donde");
			lblDonde.setBounds(283, 27, 119, 14);
			contentPanel.add(lblDonde);
			
			llenarIds();
			
			llenarCombos();
			
			setResizable(false);
			
			modelo.setRowCount(0);
			
			llenarPorIdConsumo();
			
	}
	
	 private void llenarTabla (int i){
	     	
	      	    	   
	    	   Object[]  datos ={ Consumo.PRE+ac.obtener(i).getCodConsumo(),
	    			             Cliente.PRE+acl.obtener(ac.obtener(i).getIdCliente()).getIdCliente(),
	    			             ac.obtener(i).getFecha(),
	    			             ac.obtener(i).getTotal(),
	    			             Consumo.obtenerEstado(ac.obtener(i).getEstado()), 
	    	                     };
	    	
	    	   modelo.addRow(datos);
	      
	 }
	      	
	
	private void llenarPorIdConsumo() {
		
		idsSeleccionados = new ArrayList<Integer>();
		
		int indiceConsumo = cboCodigo.getSelectedIndex();
		
		idsSeleccionados.add(indiceConsumo);
		
		modelo.setRowCount(0);
		
		//Verifico que esté pendiente
		
		if (ac.obtener(indiceConsumo).getEstado()==Consumo.PEN){
		
			llenarTabla(indiceConsumo);
		
		} else {
		
			estado=false;
			
			llenarTabla(indiceConsumo);
			
		}
		
	}
	
	private void llenarPorIdCliente() {
		
				
		int indiceCliente = cboCodigo.getSelectedIndex();
		
		idsSeleccionados = new ArrayList<Integer>();
		
		modelo.setRowCount(0);
		
		//Simplemente obtengo los indices de clientes que tienen asociado un consumo 
			for (int i=0;i<ac.tamaño();i++){
				
				if (ac.obtener(i).getIdCliente()==indiceCliente){
					
					idsSeleccionados.add(i);

				}
				
			}

		//Verifico que haya pedidos asociados. Si no, retorna
			if(idsSeleccionados.size()>0){
				
				for (int i=0;i<idsSeleccionados.size();i++){
					
					llenarTabla(idsSeleccionados.get(i));
					
				}
				
			} else {
				
				estado=false;
				
			}
		
	}
	 
	private void llenarIds() {
		
		
		idConsumos = new String[ac.tamaño()];
		
		for(int i=0;i<ac.tamaño();i++){
			
			idConsumos[i] = Consumo.PRE+ac.obtener(i).getCodConsumo();
			
		}
		
		idClientes = new String[acl.tamaño()];
				
		for(int i=0;i<acl.tamaño();i++){
					
			idClientes[i] = Cliente.PRE+acl.obtener(i).getIdCliente();
					
		}
		
	}

	private void llenarCombos() {
		
		int indice = cboFiltrarPor.getSelectedIndex();
		switch (indice){
			
			case CODCON:
				
				cboCodigo.setModel(new DefaultComboBoxModel<String>(idConsumos));
				cboCodigo.setSelectedIndex(0);
				return;
			
			default:
				
				cboCodigo.setModel(new DefaultComboBoxModel<String>(idClientes));
				cboCodigo.setSelectedIndex(0);
		}
		
	}

	public void actionPerformed(ActionEvent arg0) {
		
		if(arg0.getSource()==cboFiltrarPor){
					
			llenarCombos();
			
		}
		
		else if(arg0.getSource()==cboCodigo){
			
			estado=true;
			
			int indice = cboFiltrarPor.getSelectedIndex();
			
			switch (indice){
				
				case CODCON:
					llenarPorIdConsumo();
					return;
				
				default:
					llenarPorIdCliente();
			}
			
		}
						
		else if (arg0.getSource() == btnImprimir) {
			
			int indice = table.getSelectedRow();
			
			if (indice>-1){
			
				int indiceSeleccionado = idsSeleccionados.get(indice);
			
				DBoleta dialog = new DBoleta();
				
				dialog.escribir("");
				dialog.escribir("Código consumo: "+Consumo.PRE+ac.obtener(indiceSeleccionado).getCodConsumo());
				dialog.escribir("Cliente : "+acl.obtener(ac.obtener(indiceSeleccionado).getIdCliente()).getNombres()+" "+
						acl.obtener(ac.obtener(indiceSeleccionado).getIdCliente()).getApellidoPaterno()+" "+
						acl.obtener(ac.obtener(indiceSeleccionado).getIdCliente()).getApellidoMaterno());
				dialog.escribir("Fecha : "+ac.obtener(indiceSeleccionado).getFecha());
				dialog.escribir("Total : S/."+ac.obtener(indiceSeleccionado).getTotal());
				dialog.escribir("Estado : "+Consumo.obtenerEstado(ac.obtener(indiceSeleccionado).getEstado()));
				dialog.setLocationRelativeTo(this);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setModal(true);
				dialog.setVisible(true);
				
			}
			
		}
		
		else if (arg0.getSource() == btnPagoTarjeta) {
		
			int indice = table.getSelectedRow();
			
		//Registro el pago
			if (indice>-1){
			
				int indiceSeleccionado = idsSeleccionados.get(indice);
			
				Consumo consumo = ac.obtener(indiceSeleccionado);
				
				consumo.setEstado(Consumo.PAG);
				
				ac.reemplazar(consumo, indiceSeleccionado);
								
			}
			
			//Vuelvo a llenar la tabla con los estados actualizados
			modelo.setRowCount(0);
			
			for (int i=0;i<idsSeleccionados.size();i++){
				
				llenarTabla(idsSeleccionados.get(i));
				
			}
			
		}
			
		else if (arg0.getSource() == btnPagoEfectivo) {
		
			int indice = table.getSelectedRow();
			
		//Registro el pago
			if (indice>-1){
			
				int indiceSeleccionado = idsSeleccionados.get(indice);
			
				Consumo consumo = ac.obtener(indiceSeleccionado);
				
				consumo.setEstado(Consumo.PAG);
				
				ac.reemplazar(consumo, indiceSeleccionado);
				
			}
			
			//Vuelvo a llenar la tabla con los estados actualizados
			modelo.setRowCount(0);
			
			for (int i=0;i<idsSeleccionados.size();i++){
				
				llenarTabla(idsSeleccionados.get(i));
				
			}
		}
		
		else {
			
			this.dispose();
			DSugerencia dialog = new DSugerencia(usuarioActual);
			dialog.setLocationRelativeTo(this);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setModal(true);
			dialog.setVisible(true);
			
		}
		
	}
	

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		int indice = table.getSelectedRow();
		
		if (indice>-1){
			
			int indiceConsumo = idsSeleccionados.get(indice);
			
			if(ac.obtener(indiceConsumo).getEstado()==Consumo.PEN){
				
				btnPagoEfectivo.setEnabled(true);
				btnPagoTarjeta.setEnabled(true);
				
			} else {
				
				btnPagoEfectivo.setEnabled(false);
				btnPagoTarjeta.setEnabled(false);
				
			}
			
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
