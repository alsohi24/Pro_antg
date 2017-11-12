package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import arreglo.ArregloGenero;
import clases.Genero;
import clases.Piqueo;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import arreglo.ArregloGenero;



public class DGenero extends JDialog implements ActionListener , MouseListener{
	
	private static final int INGRESO = 0;
	private static final int CONSULTA = 1;
	private static final int MODIFICACION = 2;

	private final JPanel contentPanel = new JPanel();
	private JTextField textCodigo;
	private JTextField textDescripcion;
	private JTextField textProcedencia;
	private JTextField textEpoca;
	private JComboBox  cboEstado ;
	private JButton    btnIngreso;
	private JButton    btnConsulta;
	private JButton   btnEliminar;
	private JButton   btnListado ;
	private JButton  btnOk;
	private JTable table;
	
    private DefaultTableModel modelo = new DefaultTableModel();
	private ArregloGenero pe= new ArregloGenero();
	
		
	   private int operacionActual;
	   private JButton btnListar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DGenero dialog = new DGenero();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DGenero() {
		setTitle("Mantenimiento | Genero");
		setBounds(100, 100, 800, 600);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Genero");
		lblCodigo.setBounds(10, 11, 46, 14);
		contentPanel.add(lblCodigo);
		
		textCodigo = new JTextField();
		textCodigo.setEditable(false);
		textCodigo.setBounds(133, 8, 139, 20);
		contentPanel.add(textCodigo);
		textCodigo.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(10, 36, 68, 16);
		contentPanel.add(lblDescripcion);
		
		textDescripcion = new JTextField();
		textDescripcion.setBounds(133, 34, 139, 20);
		textDescripcion.setColumns(10);
		contentPanel.add(textDescripcion);
		
		JLabel lblProcedencia = new JLabel("Procedencia");
		lblProcedencia.setBounds(10, 61, 72, 16);
		contentPanel.add(lblProcedencia);
		
		textProcedencia = new JTextField();
		textProcedencia.setBounds(134, 59, 139, 20);
		textProcedencia.setColumns(10);
		contentPanel.add(textProcedencia);
		
		JLabel lblEpoca = new JLabel("Epoca");
		lblEpoca.setBounds(396, 11, 46, 14);
		contentPanel.add(lblEpoca);
		
		textEpoca = new JTextField();
		textEpoca.setBounds(478, 8, 111, 20);
		textEpoca.setColumns(10);
		contentPanel.add(textEpoca);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setBounds(396, 36, 46, 14);
		contentPanel.add(lblEstado);
		
		cboEstado = new JComboBox();
		cboEstado.setBounds(478, 34, 111, 20);
		cboEstado.setModel(new DefaultComboBoxModel(new String[] {Genero.obtenerEstado(0),Genero.obtenerEstado(1)}));
		contentPanel.add(cboEstado);
		
		
		btnIngreso = new JButton("Ingreso");
		btnIngreso.setBounds(23, 511, 89, 23);
		btnIngreso.addActionListener(this);
		contentPanel.add(btnIngreso);
		
		btnConsulta = new JButton("Consultar");
		btnConsulta.setBounds(122, 511, 89, 23);
		btnConsulta.addActionListener(this);
		contentPanel.add(btnConsulta);
		
		btnOk = new JButton("Ok");
		btnOk.setBounds(221, 511, 89, 23);
		btnOk.addActionListener(this);
		contentPanel.add(btnOk);
		
		btnEliminar = new JButton("Eliminar ");
		btnEliminar.setBounds(320, 511, 89, 23);
		btnEliminar.addActionListener(this);
		contentPanel.add(btnEliminar);
		
		btnListar = new JButton("Listar ");
		btnListar.setBounds(672, 513, 89, 21);
		contentPanel.add(btnListar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 109, 738, 393);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		table.setModel(modelo);
		table.setFillsViewportHeight(true);
		table.addMouseListener(this);
		scrollPane.setViewportView(table);
		
		modelo.addColumn("CODIGO");
		modelo.addColumn("DESCRIPCION");
		modelo.addColumn("PROCEDENCIA");
		modelo.addColumn("EPOCA");
		modelo.addColumn("ESTADO");
	
		setResizable(false);
	
		modelo.setRowCount(0);
		llenarTabla();
		
	}
	
	 private void llenarTabla (){
     	
	       for(int i=0 ; i<pe.tamaño(); i++){
	    	   
	    	   Object[]  datos ={ Genero.PRE+pe.obtener(i).getidGenero(),
	    			             pe.obtener(i).getdescripcion(),
	    			             pe.obtener(i).getprocedencia(),
	    			             pe.obtener(i).getepoca(),
	    			             Genero.obtenerEstado(pe.obtener(i).getestado()), 
	    	                     };
	    	   modelo.addRow(datos);
	             }
	        }
	    		
	        
	       private void llenarTabla (int indice){
	               	   
	         	   Object[]  datos ={ Genero.PRE+pe.obtener(indice).getidGenero(),
	         			             pe.obtener(indice).getdescripcion(),
	         			             pe.obtener(indice).getprocedencia(),
	         			             pe.obtener(indice).getepoca(),
	         			             Genero.obtenerEstado(pe.obtener(indice).getestado()),
	         	                     };
	         	   modelo.addRow(datos);
	                  }
	        
	        
	        private void llenartxt(int indice){
	        	if(indice>=0){
	        		textCodigo.setText(Genero.PRE+pe.obtener(indice).getidGenero());
	        		textDescripcion.setText(pe.obtener(indice).getdescripcion());
	        		textProcedencia.setText(pe.obtener(indice).getprocedencia());
	        		textEpoca.setText(pe.obtener(indice).getepoca());
	        		cboEstado.setSelectedIndex(pe.obtener(indice).getestado());        		
	        		
	        	}
	          }
	        
	        private void vaciartxt(){
	        	textCodigo.setText("");
	        	textDescripcion.setText("");
	        	textProcedencia.setText("");
	        	textEpoca.setText("");;
	        	cboEstado.setSelectedIndex(0);
	        }
	
	        
	        

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(arg0.getSource()==btnIngreso){
			
			textCodigo.setEditable(false);
			vaciartxt();
			//llenarTabla();
			textCodigo.setText(Genero.PRE+pe.codigoCorrelativo());
			textDescripcion.requestFocus();
			btnOk.setEnabled(true);
			operacionActual=DGenero.INGRESO;
		}
		
		else if(arg0.getSource()==btnConsulta){
			vaciartxt();
			textCodigo.setEditable(true);
			textCodigo.requestFocus();
			btnOk.setEnabled(true);
			
			operacionActual=DGenero.CONSULTA;
		}
        else if(arg0.getSource()==btnEliminar){
			
			//Valido si es mayor o igual que cero para mostrar el mensaje apropiado
			int indice = table.getSelectedRow();
			
			if(indice>=0){
			
			int respuesta = JOptionPane.showConfirmDialog(this, "¿Desea borrar el registro "+(indice+1)+"?",
					"¿Lo tumbo?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			
			if (respuesta==JOptionPane.YES_OPTION){
				
				pe.eliminar(indice);
				
				modelo.setRowCount(0);
				
				vaciartxt();
				
				llenarTabla();
				
			}
			
			
			} else {
				
			JOptionPane.showMessageDialog(this, "No ha seleccionado registro", "Cuidado, mucho cuidado",
					JOptionPane.INFORMATION_MESSAGE);
				
			}
		}
		
		else if(arg0.getSource()==btnListado){
			
			vaciartxt();
			
			modelo.setRowCount(0);
			
			llenarTabla();
			
		}
		
	else if(arg0.getSource()==btnOk){
		
		try{
			
			switch(operacionActual){
			
			case DGenero.INGRESO:
				okIngreso();
				break;
			case DGenero.CONSULTA:
				okConsulta();
				break;
			default:
				okModifcacion();
				
			}
		}
		catch (Exception e){
			JOptionPane.showMessageDialog(this, "Ha introducido un dato no válido", "Cuidado, mucho cuidado", JOptionPane.ERROR_MESSAGE);
		}
	}
			
		}		
		

	private void ingresarRegistro() {
		
		pe.agregar (new Genero ( pe.codigoCorrelativo(),
								textDescripcion.getText(),
								textProcedencia.getText(),
								textEpoca.getText(),
								cboEstado.getSelectedIndex()));
								
	}
	
	private void reemplazarRegistro(int indice) {
		
		if (indice>=0){
		
		pe.reemplazar (new Genero (	pe.obtener(indice).getidGenero(),
				                   textDescripcion.getText(),
				                   textProcedencia.getText(),
				                   textEpoca.getText(),
				                   cboEstado.getSelectedIndex()), indice);
		}
	}

	private int consultarRegistro() {
	
		//Consulta según todos los campos. Si coincide un valor devuelve el primer registro		
		if (!(textCodigo.getText().equals(""))){
			
			//Si contiene el prefijo intento convertirlo a un número
			if(textCodigo.getText().contains(Genero.PRE)){
				
				try{
					
					int codigoGenero = Integer.parseInt(textCodigo.getText().replace(Genero.PRE, ""));
					
					for	(int i=0;i<pe.tamaño();i++){
						
						if(pe.obtener(i).getidGenero()==codigoGenero){
							return i;
						}
						
					}
					
				} catch (Exception e){
					
					e.printStackTrace();
				}
				
				
			}
			
		} 
		
		if (!(textDescripcion.getText().equals(""))){
			
			String valor =textDescripcion.getText();
			
			for	(int i=0;i<pe.tamaño();i++){
				
				if(pe.obtener(i).getdescripcion().contains(valor)){
					return i;
				}
				
			}
			
		}
		
		if (!(textProcedencia.getText().equals(""))){
			
			String valor = textDescripcion.getText();
			
			for	(int i=0;i<pe.tamaño();i++){
				
				if(pe.obtener(i).getprocedencia().contains(valor)){
					return i;
				}
				
			}
			
		}
		
        if (!(textEpoca.getText().equals(""))){
			
			String valor = textEpoca.getText();
			
			for	(int i=0;i<pe.tamaño();i++){
				
				if(pe.obtener(i).getprocedencia().contains(valor)){
					return i;
				}
				
			}
			
		}
		
		
		
		
		else{
			
			int estado =cboEstado.getSelectedIndex();
			
			for	(int i=0;i<pe.tamaño();i++){
				
				if(pe.obtener(i).getestado()==estado){
					return i;
				}
			
			}
			
		}
		return -1;
	}
	
		
	
	private void okModifcacion() {
		
		if(		textDescripcion.getText().equals("") ||
				textProcedencia.getText().equals("") ||
				textEpoca.getText().equals("")){
				
			
			JOptionPane.showMessageDialog(	this,
											"Hay espacios en blanco",
											"Cuidado, mucho cuidado",
											JOptionPane.ERROR_MESSAGE);			
			
		}
		
		else{
			
			reemplazarRegistro(table.getSelectedRow());
			
			modelo.setRowCount(0);
			
			llenarTabla();
			
			btnOk.setEnabled(false);
			
		}
		
	}

	private void okConsulta() {
		
		int registro = consultarRegistro();
		
		if(registro !=-1){
			
			llenartxt(registro);
			
			modelo.setRowCount(0);
			
			llenarTabla(registro);
			
		} else {
			
			JOptionPane.showMessageDialog(this, "No se encontraron registros "
					+ "con los criterios de búsqueda", "No encontrado", JOptionPane.INFORMATION_MESSAGE);
			
		}
		
	}

	private void okIngreso() {
		
		if(		textDescripcion.getText().equals("") ||
				textProcedencia.getText().equals("") ||
				textEpoca.getText().equals("") ){
			
			JOptionPane.showMessageDialog(	this,
											"Hay espacios en blanco",
											"Cuidado, mucho cuidado",
											JOptionPane.ERROR_MESSAGE);			
			
		}
		
		else{
			
			ingresarRegistro();
			
			modelo.setRowCount(0);
			llenarTabla();
			btnOk.setEnabled(false);
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		if(pe.tamaño()==table.getRowCount()){
			
			textCodigo.setEditable(false);
			
			btnOk.setEnabled(true);
			
			llenartxt(table.getSelectedRow());
		
			operacionActual = DGenero.MODIFICACION;
			
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