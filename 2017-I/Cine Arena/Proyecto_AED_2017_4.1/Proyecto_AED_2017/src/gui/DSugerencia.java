package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;


import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import arreglo.ArregloSugerencia;
import clases.Sugerencia;
import clases.Usuario;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JTable;


public class DSugerencia extends JDialog implements ActionListener ,MouseListener{

	private static final int INGRESO = 0;
	private static final int CONSULTA = 1;
	private static final int MODIFICACION = 2;	
	
	
	private final JPanel contentPanel = new JPanel();
	private JTextField textCodigo;
	private JTextField textDetalle;
	private JTextField textCodigoUsuario;
	private JComboBox  cboTipoSugerencia;
	private JButton    btnIngreso;
	private JButton    btnConsulta;
	private JButton    btnEliminar;
	private JButton    btnListado ;
	private JButton    btnOk;
	private JTable table;
	private DefaultTableModel modelo = new DefaultTableModel();
	private ArregloSugerencia  as  = new ArregloSugerencia();

	private int usuarioActual;
	private int operacionActual;
	private JButton btnSalir;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DSugerencia dialog = new DSugerencia(1001);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DSugerencia(int usuarioActual) {
		
		this.usuarioActual = usuarioActual;
		
		setTitle("Reportes | Sugerencia");
		setBounds(100, 100, 501, 322);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblCodigo = new JLabel("Codigo ");
			lblCodigo.setBounds(10, 11, 46, 14);
			contentPanel.add(lblCodigo);
		}
		
		JLabel lblDetalle = new JLabel("Detalle");
		lblDetalle.setBounds(10, 42, 46, 14);
		contentPanel.add(lblDetalle);
		
		textCodigo = new JTextField();
		textCodigo.setEditable(false);
		textCodigo.setBounds(93, 8, 108, 20);
		contentPanel.add(textCodigo);
		textCodigo.setColumns(10);
		
		textDetalle = new JTextField();
		textDetalle.setBounds(93, 39, 108, 20);
		contentPanel.add(textDetalle);
		textDetalle.setColumns(10);
		
		JLabel lblTipoDeSugerencia = new JLabel("Tipo de Sugerencia ");
		lblTipoDeSugerencia.setBounds(241, 42, 94, 14);
		contentPanel.add(lblTipoDeSugerencia);
		
		cboTipoSugerencia = new JComboBox();
		cboTipoSugerencia.setModel(new DefaultComboBoxModel(new String []{Sugerencia.obtenerTipoSuegerencia(0),
	    Sugerencia.obtenerTipoSuegerencia(1),Sugerencia.obtenerTipoSuegerencia(3)}));
		cboTipoSugerencia.setBounds(358, 39, 117, 20);
		contentPanel.add(cboTipoSugerencia);
		
		JLabel lblCodigoUsuario = new JLabel("Codigo Usuario ");
		lblCodigoUsuario.setBounds(241, 11, 107, 14);
		contentPanel.add(lblCodigoUsuario);
		
		textCodigoUsuario = new JTextField();
		textCodigoUsuario.setEditable(false);
		textCodigoUsuario.setBounds(358, 8, 117, 20);
		textCodigoUsuario.setText(Usuario.PRE+usuarioActual);
		contentPanel.add(textCodigoUsuario);
		textCodigoUsuario.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 83, 465, 155);
		contentPanel.add(scrollPane);
		
		modelo.addColumn("CÓDIGO");
		modelo.addColumn("DETALLE");
		modelo.addColumn("CODIGO USUARIO");
		modelo.addColumn("TIPO SUGERENCIA");
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setModel(modelo);
		table.addMouseListener(this);
		scrollPane.setViewportView(table);
				
		btnIngreso = new JButton("Ingreso");
	    btnIngreso.setBounds(10, 249, 89, 23);
		btnIngreso.addActionListener(this);
		contentPanel.add(btnIngreso);
		
		btnConsulta= new JButton("Consulta");
		btnConsulta.setBounds(109, 249, 89, 23);
		btnConsulta.addActionListener(this);
		contentPanel.add(btnConsulta);
		
	    btnOk = new JButton("Ok");
	    btnOk.setEnabled(false);
		btnOk.setBounds(214, 249, 63, 23);
	    btnOk.addActionListener(this);
		contentPanel.add(btnOk);
		
		btnListado = new JButton("Listado");
		btnListado.setBounds(386, 249, 89, 23);
		btnListado.addActionListener(this);
		contentPanel.add(btnListado);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(287, 249, 89, 23);
		btnEliminar.addActionListener(this);
		contentPanel.add(btnEliminar);
		
		btnSalir = new JButton("Salir ");
		btnSalir.setBounds(386, 249, 89, 23);
		contentPanel.add(btnSalir);
		
		setResizable(false);
		
		modelo.setRowCount(0);
		llenarTabla();
	}
	private void llenarTabla() {
		
		
		for(int i=0;i<as.tamaño();i++){
			
	 Object[] datos = {Sugerencia.PRE+as.obtener(i).getIdSugerencia(),
					as.obtener(i).getDetalle(),
					Usuario.PRE+as.obtener(i).getIdUsuario(),
					Sugerencia.obtenerTipoSuegerencia(as.obtener(i).getTipoSugerencia())};
					
	modelo.addRow(datos);
						
		}
		
	}
	
private void llenarTabla(int indice){
		
		Object[] datos = {Sugerencia.PRE+as.obtener(indice).getIdSugerencia(),
				as.obtener(indice).getDetalle(),
				Usuario.PRE+as.obtener(indice).getIdUsuario(),
				Sugerencia.obtenerTipoSuegerencia(as.obtener(indice).getTipoSugerencia())};
						
		modelo.addRow(datos);
}

private void llenarTxt(int indice) {
	
	if(indice>=0){

	textCodigo.setText(Sugerencia.PRE+as.obtener(indice).getIdSugerencia());
	textDetalle.setText(as.obtener(indice).getDetalle());
	cboTipoSugerencia.setSelectedIndex(as.obtener(indice).getTipoSugerencia());
	
	}		
}
private void vaciarTxt() {
	textCodigo.setText("");
	textDetalle.setText("");
	cboTipoSugerencia.setSelectedIndex(0);
}
	
@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(arg0.getSource()==btnIngreso){
			
			textCodigo.setEditable(false);
			vaciarTxt();
			//llenarTabla();
			textCodigo.setText(Sugerencia.PRE+as.codigoCorrelativo());
			textDetalle.requestFocus();
			btnOk.setEnabled(true);
			
			operacionActual=DSugerencia.INGRESO;
		}
		
		else if(arg0.getSource()==btnConsulta){
			vaciarTxt();
			textCodigo.setEditable(true);
			textCodigo.requestFocus();
			btnOk.setEnabled(true);
			
			operacionActual=DSugerencia.CONSULTA;
			
		}
		
		else if(arg0.getSource()==btnEliminar){
			
			//Valido si es mayor o igual que cero para mostrar el mensaje apropiado
			int indice = table.getSelectedRow();
			
			if(indice>=0){
				
				if(table.getRowCount()>1){
			
					int respuesta = JOptionPane.showConfirmDialog(this, "¿Desea borrar el registro "+(indice+1)+"?",
					"¿Lo tumbo?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			
					if (respuesta==JOptionPane.YES_OPTION){
				
						as.eliminar(indice);
				
						modelo.setRowCount(0);
				
						vaciarTxt();
				
						llenarTabla();
				
					} } else {
						
						JOptionPane.showMessageDialog(this, "Debe haber al menos un usuario", "Qué jesto!", JOptionPane.ERROR_MESSAGE);
						
					}
			
			
			} else {
				
			JOptionPane.showMessageDialog(this, "No ha seleccionado registro", "Cuidado, mucho cuidado",
					JOptionPane.INFORMATION_MESSAGE);
				
			}
		}
		
		else if(arg0.getSource()==btnListado){
			
			vaciarTxt();
			
			modelo.setRowCount(0);
			
			llenarTabla();
			
		}
		
		else if(arg0.getSource()==btnOk){
			
			switch(operacionActual){
			
			case DSugerencia.INGRESO:
				okIngreso();
				break;
			case DSugerencia.CONSULTA:
				okConsulta();
				break;
			default:
				okModifcacion();
				
			}
		}
     }


private void ingresarRegistro() {
	
	as.agregar(new Sugerencia(	 as.codigoCorrelativo(),
							     textDetalle.getText(),
							     usuarioActual,
							      cboTipoSugerencia.getSelectedIndex()));
	
}

private void reemplazarRegistro(int indice) {
	
	if (indice>=0){
	
	as.reemplazar(new Sugerencia(as.obtener(indice).getIdSugerencia(),
			                    textDetalle.getText(),
			                    usuarioActual,
			                    cboTipoSugerencia.getSelectedIndex()), indice);
	}
}




private int consultarRegistro() {
	
	//Consulta según todos los campos. Si coincide un valor devuelve el primer registro		
	if (!(textCodigo.getText().equals(""))){
		
		//Si contiene el prefijo intento convertirlo a un número
		if(textCodigo.getText().contains(Sugerencia.PRE)){
			
			try{
				
				int codigo = Integer.parseInt(textCodigo.getText().replace(Sugerencia.PRE, ""));
				
				for	(int i=0;i<as.tamaño();i++){
					
					if(as.obtener(i).getIdSugerencia()==codigo){
						return i;
					}
					
				}
				
			} catch (Exception e){
				
				e.printStackTrace();
			}
			
			
		}
		
	} 
	
	if (!(textDetalle.getText().equals(""))){
		
		String valor = textDetalle.getText();
		
		for	(int i=0;i<as.tamaño();i++){
			
			if(as.obtener(i).getDetalle().contains(valor)){
				return i;
			}
			
		}
		
	}
	
	else{
		
				
		int tipoSugerenca=cboTipoSugerencia.getSelectedIndex();
		
		for	(int i=0;i<as.tamaño();i++){
			
			if(as.obtener(i).getTipoSugerencia()==tipoSugerenca){
				return i;
			}
		
		}
	}
	return -1;
}



private void okModifcacion() {
	
	if(		textDetalle.getText().equals("")){
			
		
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
       
	
	private void okIngreso() {
		
		if(		textDetalle.getText().equals(""))	{
			
			JOptionPane.showMessageDialog(	this,
											"Hay espacios en blanco",
											"Cuidado, mucho cuidado",
											JOptionPane.ERROR_MESSAGE);			
			
		}
		
		else{
			
			ingresarRegistro();;
			
			modelo.setRowCount(0);
			llenarTabla();
			btnOk.setEnabled(false);
		}
		
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		//Se va a modificar solo si aparecen todas las tablas registradas
		
		if(as.tamaño()==table.getRowCount()){
		
		textCodigo.setEditable(false);
		
		btnOk.setEnabled(true);
		
		llenarTxt(table.getSelectedRow());
	
		operacionActual = DSugerencia.MODIFICACION;
		
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