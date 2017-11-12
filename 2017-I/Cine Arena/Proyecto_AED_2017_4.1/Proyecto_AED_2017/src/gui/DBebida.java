package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import arreglo.ArregloBebida;
import clases.Bebida;


import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ComboBoxEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import java.awt.ScrollPane;
import java.awt.Panel;
import javax.swing.JScrollPane;
import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JTable;



public class DBebida extends JDialog implements ActionListener ,  MouseListener {
	
	
	    private static final int INGRESO = 0;
		private static final int CONSULTA = 1;
		private static final int MODIFICACION = 2;
		

	private final JPanel contentPanel = new JPanel();
	private JTextField textCodigo;
	private  JComboBox cboMarca;
	private JTextField textPrecio;
	private JComboBox  cboTipoBebida;
	private JComboBox  cboEstado ;
	private JButton    btnIngresar;
	private JButton    btnConsultar;
	private JButton    btnEliminar;
	private JButton   btnOk;
	private JButton    btnListado;
	private JScrollPane scrollPane;
	private JTable table;
	private DefaultTableModel modelo = new DefaultTableModel();
	private ArregloBebida be = new ArregloBebida();
	
	private int operacionActual;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DBebida dialog = new DBebida();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DBebida() {
		setTitle("Mantenimiento | Bebidas ");
		//setType(Type.UTILITY);
		setBounds(100, 100, 648, 510);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(20, 11, 64, 21);
		contentPanel.add(lblCodigo);
		
		textCodigo = new JTextField();
		textCodigo.setEditable(false);
		textCodigo.setBounds(106, 11, 102, 20);
		contentPanel.add(textCodigo);
		textCodigo.setColumns(10);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(20, 43, 46, 14);
		contentPanel.add(lblMarca);
		
	   cboMarca = new JComboBox();
	   cboMarca.setModel(new DefaultComboBoxModel(new String[] {Bebida.obtenerMarcaBebida(0), Bebida.obtenerMarcaBebida(1),Bebida.obtenerMarcaBebida(2),
				Bebida.obtenerMarcaBebida(3),Bebida.obtenerMarcaBebida(4), Bebida.obtenerMarcaBebida(5),Bebida.obtenerMarcaBebida(6),
				Bebida.obtenerMarcaBebida(7)}));
		cboMarca.setBounds(106, 42, 102, 20);
		contentPanel.add(cboMarca);
		
		JLabel lblPrecio = new JLabel("Precio ");
		lblPrecio.setBounds(20, 76, 46, 14);
		contentPanel.add(lblPrecio);
		
		textPrecio = new JTextField();
		textPrecio.setBounds(106, 73, 102, 20);
		contentPanel.add(textPrecio);
		textPrecio.setColumns(10);
		
		JLabel lblTipoBebida = new JLabel("Tipo Bebida");
		lblTipoBebida.setBounds(319, 14, 80, 14);
		contentPanel.add(lblTipoBebida);
		
		cboTipoBebida = new JComboBox();
		cboTipoBebida.setModel(new DefaultComboBoxModel(new String[] {Bebida.obtenerTipoBebida(0),Bebida.obtenerTipoBebida(1),Bebida.obtenerTipoBebida(2),
				Bebida.obtenerTipoBebida(3), Bebida.obtenerTipoBebida(4),Bebida.obtenerTipoBebida(5), Bebida.obtenerTipoBebida(6)}));
		cboTipoBebida.setBounds(425, 11, 118, 20);
		contentPanel.add(cboTipoBebida);
		
		JLabel lblEstado = new JLabel("Estado ");
		lblEstado.setBounds(319, 48, 46, 14);
		contentPanel.add(lblEstado);
		
		cboEstado = new JComboBox();
		cboEstado.setModel(new DefaultComboBoxModel(new String[] {Bebida.obtenerEstado(0), Bebida.obtenerEstado(1),
				Bebida.obtenerEstado(2)	}));
		cboEstado.setBounds(425, 45, 118, 20);
		contentPanel.add(cboEstado);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.setBounds(20, 420, 89, 23);
		btnIngresar.addActionListener(this);
		contentPanel.add(btnIngresar);
		
        btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(135, 420, 89, 23);
		btnConsultar.addActionListener(this);
		contentPanel.add(btnConsultar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(370, 420, 89, 23);
		btnEliminar.addActionListener(this);
		contentPanel.add(btnEliminar);
		
		btnOk = new JButton("OK");
		btnOk.setBounds(251, 420, 89, 23);
		btnOk.addActionListener(this);
		btnOk.setEnabled(false);
		contentPanel.add(btnOk);
	
		btnListado = new JButton("Listado");
		btnListado.setBounds(501, 420, 89, 23);
		btnListado.addActionListener(this);
		contentPanel.add(btnListado);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 131, 602, 269);
		contentPanel.add(scrollPane);
		
		modelo.addColumn("CODIGO");
		modelo.addColumn("MARCA");
		modelo.addColumn("PRECIO");
		modelo.addColumn("TIPO");
		modelo.addColumn("ESTADO");
			
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setModel(modelo);
		table.addMouseListener(this);
		scrollPane.setViewportView(table);
		
		setResizable(false);
		
		modelo.setRowCount(0);
		llenarTabla();
		
	}

private void llenarTabla(){
	
	for( int i=0 ; i<be.tamaño(); i++){
	
	Object[] datos= {	Bebida.PRE+be.obtener(i).getIdBebida(),
						Bebida.obtenerMarcaBebida(be.obtener(i).getMarca()),
			          	be.obtener(i).getPrecio(),
			          	Bebida.obtenerTipoBebida(be.obtener(i).getTipoBebida()),
			          	Bebida.obtenerEstado(be.obtener(i).getEstado())};
	modelo.addRow(datos);
	}
}



    private void llenarTabla(int i){
	
	Object[] datos= {	Bebida.PRE+be.obtener(i).getIdBebida(),
						Bebida.obtenerMarcaBebida(be.obtener(i).getMarca()),
						be.obtener(i).getPrecio(),
						Bebida.obtenerTipoBebida(be.obtener(i).getTipoBebida()),
						Bebida.obtenerEstado(be.obtener(i).getEstado())};
	modelo.addRow(datos);
	
}

private void llenarTxt(int indice){
	if(indice>=0){
	textCodigo.setText(Bebida.PRE+be.obtener(indice).getIdBebida());
	textPrecio.setText(""+be.obtener(indice).getPrecio());
	cboMarca.setSelectedIndex(be.obtener(indice).getMarca());
	cboTipoBebida.setSelectedIndex(be.obtener(indice).getTipoBebida());
	cboEstado.setSelectedIndex(be.obtener(indice).getEstado());
	}
		
}

private void vaciartxt(){
	textCodigo.setText("");
	textPrecio.setText("");
	cboMarca.setSelectedIndex(0);
	cboTipoBebida.setSelectedIndex(0);
	cboEstado.setSelectedIndex(0);
	
}


@Override
public void actionPerformed(ActionEvent arg0) {
	
	if(arg0.getSource()==btnIngresar){
		
		textCodigo.setEditable(false);
		vaciartxt();
		//llenarTabla();
		textCodigo.setText(Bebida.PRE+be.codigoCorrelativo());
		textPrecio.requestFocus();
		btnOk.setEnabled(true);
		operacionActual=DBebida.INGRESO;
	}
	
	else if(arg0.getSource()==btnIngresar){
		vaciartxt();
		textCodigo.setEditable(true);
		textCodigo.requestFocus();
		btnOk.setEnabled(true);
		
		operacionActual=DBebida.CONSULTA;
		
	}
	
	 else if(arg0.getSource()==btnEliminar){
			
			//Valido si es mayor o igual que cero para mostrar el mensaje apropiado
			int indice = table.getSelectedRow();
			
			if(indice>=0){
			
			int respuesta = JOptionPane.showConfirmDialog(this, "¿Desea borrar el registro "+(indice+1)+"?",
					"¿Lo tumbo?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			
			if (respuesta==JOptionPane.YES_OPTION){
				
				be.eliminar(indice);
				
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
				
				case DBebida.INGRESO:
					okIngreso();
					break;
				case DBebida.CONSULTA:
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

private int consultarRegistro() {

	//Consulta según todos los campos. Si coincide un valor devuelve el primer registro		
	if (!(textCodigo.getText().equals(""))){
		
		//Si contiene el prefijo intento convertirlo a un número
		if(textCodigo.getText().contains(Bebida.PRE)){
			
			try{
				
				int codigoBebida = Integer.parseInt(textCodigo.getText().replace(Bebida.PRE, ""));
				
				for	(int i=0;i<be.tamaño();i++){
					
					if(be.obtener(i).getIdBebida()==codigoBebida){
						return i;
					}
					
				}
				
			} catch (Exception e){
				
				e.printStackTrace();
			}
			
			
		}
		
	} 
		
	if (!(textPrecio.getText().equals(""))){
		
		double valor = Double.parseDouble(textPrecio.getText());
		
		for	(int i=0;i<be.tamaño();i++){
			
			if(be.obtener(i).getPrecio()==valor){
				return i;
			}
			
		}
		
	}
	
	else{
		
		int tipoMarca=cboMarca.getSelectedIndex();
		
		for	(int i=0;i<be.tamaño();i++){
			
			if(be.obtener(i).getMarca()==tipoMarca){
				return i;
			}
		
		}
		
		int tipoBebida=cboTipoBebida.getSelectedIndex();
		
		for	(int i=0;i<be.tamaño();i++){
			
			if(be.obtener(i).getTipoBebida()==tipoBebida ){
				return i;
			}
		
		}
	}
	return -1;
}


private void okModifcacion() {
	
	if(		textPrecio.getText().equals("")){
			
		
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
		
		llenarTxt(registro);
		
		modelo.setRowCount(0);
		
		llenarTabla(registro);
		
	} else {
		
		JOptionPane.showMessageDialog(this, "No se encontraron registros "
				+ "con los criterios de búsqueda", "No encontrado", JOptionPane.INFORMATION_MESSAGE);
		
	}
	
}
        private void ingresarRegistro (){
		
		be.agregar(new Bebida   (be.codigoCorrelativo(),
			                	cboMarca.getSelectedIndex(),
							    Double.parseDouble(textPrecio.getText()),
							    cboTipoBebida.getSelectedIndex(),
								cboEstado.getSelectedIndex()));
		
	}
	
	private void reemplazarRegistro(int indice) {
		
		if (indice>=0){
		
		be.reemplazar(new Bebida(be.obtener(indice).getIdBebida(),
				                 cboMarca.getSelectedIndex(),
								 Double.parseDouble(textPrecio.getText()),
								 cboTipoBebida.getSelectedIndex(),
								 cboEstado.getSelectedIndex()), indice);
		}
	}

	
	private void okIngreso() {
		
		if(		textPrecio.getText().equals(""))	{
			
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
		
		if(be.tamaño()==table.getRowCount()){
		
		textCodigo.setEditable(false);
		
		btnOk.setEnabled(true);
		
		llenarTxt(table.getSelectedRow());
	
		operacionActual = DBebida.MODIFICACION;
		
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