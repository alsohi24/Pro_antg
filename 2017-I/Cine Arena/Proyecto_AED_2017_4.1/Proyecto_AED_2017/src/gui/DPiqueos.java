package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import arreglo.ArregloPiqueo;
import clases.Piqueo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import java.awt.ScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;

public class DPiqueos extends JDialog implements ActionListener, MouseListener {
	
	

    private static final int INGRESO = 0;
	private static final int CONSULTA = 1;
	private static final int MODIFICACION = 2;

	private final JPanel contentPanel = new JPanel();
	private JTextField textCodigo;
	private JTextField textNombre;
	private JTextField textPrecio;
	private JComboBox  cboTipoPiqueo;
	private JComboBox  cboEstado;
	private JButton    btnIngreso;
	private JButton    btnConsulta ;
	private JButton btnEliminar;
	private JButton btnListado;
	private JButton    btnOk;
    private DefaultTableModel modelo = new DefaultTableModel();
    private ArregloPiqueo pi = new ArregloPiqueo();
    
    private int operacionActual;
    private JTable table;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DPiqueos dialog = new DPiqueos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DPiqueos() {
		setTitle("Mantenimiento | Piqueos");
		setBounds(100, 100, 574, 485);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(10, 11, 46, 14);
		contentPanel.add(lblCodigo);
		
		textCodigo = new JTextField();
		textCodigo.setEditable(false);
		textCodigo.setBounds(112, 8, 127, 20);
		contentPanel.add(textCodigo);
		textCodigo.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 51, 46, 14);
		contentPanel.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setBounds(112, 48, 127, 20);
		contentPanel.add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblTipoPiqueo = new JLabel("Tipo Piqueo");
		lblTipoPiqueo.setBounds(10, 82, 77, 14);
		contentPanel.add(lblTipoPiqueo);
		
		cboTipoPiqueo = new JComboBox();
		cboTipoPiqueo.setModel(new DefaultComboBoxModel(new String[] {"Caramelos", "Galletas", "Chocolate", "Emparedados", "Chips", "Frutos Secos", "Teque\u00F1os"}));
		cboTipoPiqueo.setBounds(112, 79, 127, 20);
		contentPanel.add(cboTipoPiqueo);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(291, 11, 72, 14);
		contentPanel.add(lblPrecio);
		
		textPrecio = new JTextField();
		textPrecio.setBounds(375, 8, 102, 20);
		contentPanel.add(textPrecio);
		textPrecio.setColumns(10);
				
		JLabel lblEstado = new JLabel("Estado ");
		lblEstado.setBounds(291, 51, 72, 14);
		contentPanel.add(lblEstado);
		
		cboEstado = new JComboBox();
		cboEstado.setModel(new DefaultComboBoxModel(new String[] {Piqueo.obtenerEstado(0), Piqueo.obtenerEstado(1),
				Piqueo.obtenerEstado(2)}));
		cboEstado.setBounds(373, 48, 104, 20);
		contentPanel.add(cboEstado);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 119, 538, 275);
		contentPanel.add(scrollPane);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setModel(modelo);
		table.addMouseListener(this);
		scrollPane.setViewportView(table);
		
		modelo.addColumn("CODIGO");
		modelo.addColumn("NOMBRE ");
		modelo.addColumn("PRECIO");
		modelo.addColumn("TIPO PIQUEO");
		modelo.addColumn("ESTADO");
			
		btnIngreso = new JButton("Ingreso");
		btnIngreso.setBounds(20, 405, 89, 23);
		btnIngreso.addActionListener(this);
		contentPanel.add(btnIngreso);
		
		btnConsulta = new JButton("Consulta");
		btnConsulta.setBounds(218, 405, 89, 23);
		btnConsulta.addActionListener(this);
		contentPanel.add(btnConsulta);
		
		btnOk = new JButton("OK");
		btnOk.setBounds(119, 405, 89, 23);
		btnOk.addActionListener(this);
		btnOk.setEnabled(false);
		contentPanel.add(btnOk);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(317, 405, 89, 23);
		btnEliminar.addActionListener(this);
		contentPanel.add(btnEliminar);
		
		btnListado = new JButton("Listado");
		btnListado.setBounds(459, 405, 89, 23);
		btnListado.addActionListener(this);
		contentPanel.add(btnListado);
		
		setResizable(false);
		
		modelo.setRowCount(0);
		llenarTabla();
		
		
	}

        private void llenarTabla (){
        	
       for(int i=0 ; i<pi.tamaño(); i++){
    	   
    	   Object[]  datos ={ Piqueo.PRE+pi.obtener(i).getidPiqueo(),
    			             pi.obtener(i).getNombre(),
    			             pi.obtener(i).getPrecio(),
    			             Piqueo.obtenerTipoPiqueos(pi.obtener(i).getTipoPiqueo()),
    			             Piqueo.obtenerEstado(pi.obtener(i).getEstado()),
    	                     };
    	   modelo.addRow(datos);
             }
        }
    		
        
        
        private void llenarTabla (int indice){
               	   
         	   Object[]  datos ={ Piqueo.PRE+pi.obtener(indice).getidPiqueo(),
         			             pi.obtener(indice).getNombre(),
         			             pi.obtener(indice).getPrecio(),
         			             Piqueo.obtenerTipoPiqueos(pi.obtener(indice).getTipoPiqueo()),
         			             Piqueo.obtenerEstado(pi.obtener(indice).getEstado()),
         	                     };
         	   modelo.addRow(datos);
                  }
        
        
        private void llenartxt(int indice){
        	if(indice>=0){
        		textCodigo.setText(Piqueo.PRE+pi.obtener(indice).getidPiqueo());
        		textNombre.setText(pi.obtener(indice).getNombre());
        		textPrecio.setText(""+pi.obtener(indice).getPrecio());
        		cboTipoPiqueo.setSelectedIndex(pi.obtener(indice).getTipoPiqueo());
        		cboEstado.setSelectedIndex(pi.obtener(indice).getEstado());        		
        		
        	}
          }
        
        private void vaciartxt(){
        	textCodigo.setText("");
        	textNombre.setText("");
        	textPrecio.setText("");
        	cboTipoPiqueo.setSelectedIndex(0);
        	cboEstado.setSelectedIndex(0);
        }
          



        @Override
        public void actionPerformed(ActionEvent arg0) {
		
		if(arg0.getSource()==btnIngreso){
			
			textCodigo.setEditable(false);
			vaciartxt();
			//llenarTabla();
			textCodigo.setText(Piqueo.PRE+pi.codigoCorrelativo());
			textNombre.requestFocus();
			btnOk.setEnabled(true);
			operacionActual=DPiqueos.INGRESO;
		}
		
		else if(arg0.getSource()==btnConsulta){
			vaciartxt();
			textCodigo.setEditable(true);
			textCodigo.requestFocus();
			btnOk.setEnabled(true);
			
			operacionActual=DPiqueos.CONSULTA;
		}
        else if(arg0.getSource()==btnEliminar){
			
			//Valido si es mayor o igual que cero para mostrar el mensaje apropiado
			int indice = table.getSelectedRow();
			
			if(indice>=0){
			
			int respuesta = JOptionPane.showConfirmDialog(this, "¿Desea borrar el registro "+(indice+1)+"?",
					"¿Lo tumbo?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			
			if (respuesta==JOptionPane.YES_OPTION){
				
				pi.eliminar(indice);
				
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
			
			case DPiqueos.INGRESO:
				okIngreso();
				break;
			case DPiqueos.CONSULTA:
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
		
		pi.agregar(new Piqueo( pi.codigoCorrelativo(),
								textNombre.getText(),
								cboTipoPiqueo.getSelectedIndex(),
								Double.parseDouble(textPrecio.getText()),
						       cboEstado.getSelectedIndex()));
		
	}
	
	private void reemplazarRegistro(int indice) {
		
		if (indice>=0){
		
		pi.reemplazar(new Piqueo (	pi.obtener(indice).getidPiqueo(),
										textNombre.getText(),
										cboTipoPiqueo.getSelectedIndex(),
										Double.parseDouble(textPrecio.getText()),
								       cboEstado.getSelectedIndex()), indice);
		}
	}

	private int consultarRegistro() {
	
		//Consulta según todos los campos. Si coincide un valor devuelve el primer registro		
		if (!(textCodigo.getText().equals(""))){
			
			//Si contiene el prefijo intento convertirlo a un número
			if(textCodigo.getText().contains(Piqueo.PRE)){
				
				try{
					
					int codigoPiqueo = Integer.parseInt(textCodigo.getText().replace(Piqueo.PRE, ""));
					
					for	(int i=0;i<pi.tamaño();i++){
						
						if(pi.obtener(i).getidPiqueo()==codigoPiqueo){
							return i;
						}
						
					}
					
				} catch (Exception e){
					
					e.printStackTrace();
				}
				
				
			}
			
		} 
		
		if (!(textNombre.getText().equals(""))){
			
			String valor =textNombre.getText();
			
			for	(int i=0;i<pi.tamaño();i++){
				
				if(pi.obtener(i).getNombre().contains(valor)){
					return i;
				}
				
			}
			
		}
		
		if (!(textPrecio.getText().equals(""))){
			
			double valor = Double.parseDouble(textPrecio.getText());
			
			for	(int i=0;i<pi.tamaño();i++){
				
				if(pi.obtener(i).getPrecio()==valor){
					return i;
				}
				
			}
			
		}
		
		else{
			
			int tipoPiqueo=cboTipoPiqueo.getSelectedIndex();
			
			for	(int i=0;i<pi.tamaño();i++){
				
				if(pi.obtener(i).getTipoPiqueo()==tipoPiqueo){
					return i;
				}
			
			}
			
			int estado=cboEstado.getSelectedIndex();
			
			for	(int i=0;i<pi.tamaño();i++){
				
				if(pi.obtener(i).getEstado()==estado ){
					return i;
				}
			
			}
		}
		return -1;
	}
	
		
	
	private void okModifcacion() {
		
		if(		textNombre.getText().equals("") ||
				textPrecio.getText().equals("")){
				
			
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
		
		if(		textNombre.getText().equals("") ||
				textPrecio.getText().equals("") ){
			
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
		//Se va a modificar solo si aparecen todas las tablas registradas
		
				if(pi.tamaño()==table.getRowCount()){
				
				textCodigo.setEditable(false);
				
				btnOk.setEnabled(true);
				
				llenartxt(table.getSelectedRow());
			
				operacionActual = DPiqueos.MODIFICACION;
				
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
     	   
    	   