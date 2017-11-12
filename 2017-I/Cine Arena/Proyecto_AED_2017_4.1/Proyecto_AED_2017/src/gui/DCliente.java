package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

import arreglo.ArregloCliente;
import clases.Cliente;

public class DCliente extends JDialog implements ActionListener, MouseListener {
	
	private static final int INGRESO = 0;
	private static final int CONSULTA = 1;
	private static final int MODIFICACION = 2;

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombres;
	private JTextField txtApPat;
	private JTextField txtApMat;
	private JTextField txtDireccion;
	private JTextField txtFecNac;
	private JTextField txtFecAfi;
	private JTextField txtDNI;
	private JTextField txtTelefono;
	private JTextField txtCodigo;
	private JTextField txtUsuario;
	private JComboBox cboTipCli;
	private JComboBox cboEstCiv;
	private JButton btnIngreso;
	private JButton btnConsulta;
	private JButton btnEliminacion;
	private JButton btnListado;
	private JButton btnOk;
	private JTable table;
	private DefaultTableModel modelo = new DefaultTableModel();
	private ArregloCliente ac = new ArregloCliente();
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yy hh:mm");
	private String fecha = dateFormat.format(new Date());
	
	private int operacionActual;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DCliente dialog = new DCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DCliente() {
		setTitle("Mantenimiento | Cliente");
		setBounds(100, 100, 863, 600);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 260, 434, 1);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setBounds(21, 29, 108, 14);
		getContentPane().add(lblCdigo);
		
		JLabel lblNombres = new JLabel("Nombres");
		lblNombres.setBounds(21, 54, 108, 14);
		getContentPane().add(lblNombres);
		
		JLabel lblApellidoPaterno = new JLabel("Apellido paterno");
		lblApellidoPaterno.setBounds(21, 79, 108, 14);
		getContentPane().add(lblApellidoPaterno);
		
		JLabel lblApellidoMaterno = new JLabel("Apellido materno");
		lblApellidoMaterno.setBounds(21, 104, 108, 14);
		getContentPane().add(lblApellidoMaterno);
		
		JLabel lblTelefono = new JLabel("Tel\u00E9fono");
		lblTelefono.setBounds(588, 29, 108, 14);
		getContentPane().add(lblTelefono);
		
		JLabel lblDireccion = new JLabel("Direcci\u00F3n");
		lblDireccion.setBounds(312, 29, 108, 14);
		getContentPane().add(lblDireccion);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha nacimiento");
		lblFechaNacimiento.setBounds(312, 54, 108, 14);
		getContentPane().add(lblFechaNacimiento);
		
		JLabel lblFechaAfiliacin = new JLabel("Fecha afiliaci\u00F3n");
		lblFechaAfiliacin.setBounds(312, 79, 108, 14);
		getContentPane().add(lblFechaAfiliacin);
		
		JLabel lblEstadoCivil = new JLabel("Estado civil");
		lblEstadoCivil.setBounds(312, 104, 108, 14);
		getContentPane().add(lblEstadoCivil);
		
		JLabel lblDNI = new JLabel("DNI");
		lblDNI.setBounds(588, 54, 108, 14);
		getContentPane().add(lblDNI);
		
		JLabel lblTIpCli = new JLabel("Tipo cliente");
		lblTIpCli.setBounds(588, 79, 108, 14);
		getContentPane().add(lblTIpCli);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(588, 104, 108, 14);
		getContentPane().add(lblUsuario);
		
		txtNombres = new JTextField();
		txtNombres.setBounds(154, 51, 125, 20);
		getContentPane().add(txtNombres);
		txtNombres.setColumns(10);
		
		txtApPat = new JTextField();
		txtApPat.setBounds(154, 76, 125, 20);
		getContentPane().add(txtApPat);
		txtApPat.setColumns(10);
		
		txtApMat = new JTextField();
		txtApMat.setBounds(154, 101, 125, 20);
		getContentPane().add(txtApMat);
		txtApMat.setColumns(10);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(430, 26, 125, 20);
		getContentPane().add(txtDireccion);
		txtDireccion.setColumns(10);
		
		txtFecNac = new JTextField();
		txtFecNac.setBounds(430, 51, 125, 20);
		getContentPane().add(txtFecNac);
		txtFecNac.setColumns(10);
		
		txtFecAfi = new JTextField();
		txtFecAfi.setBounds(430, 76, 125, 20);
		txtFecAfi.setEditable(false);
		getContentPane().add(txtFecAfi);
		txtFecAfi.setColumns(10);
		
		txtDNI = new JTextField();
		txtDNI.setBounds(702, 51, 125, 20);
		getContentPane().add(txtDNI);
		txtDNI.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(702, 26, 125, 20);
		getContentPane().add(txtTelefono);
		txtTelefono.setColumns(10);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(154, 26, 125, 20);
		getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		txtCodigo.setEditable(false);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(702, 101, 125, 20);
		getContentPane().add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 146, 806, 369);
		getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		cboEstCiv = new JComboBox();
		cboEstCiv.setModel(new DefaultComboBoxModel(new String[] {"Soltero(a)", "Casado(a)", "Viudo(a)", "Divorciado(a)", "No especifica"}));
		cboEstCiv.setBounds(430, 101, 125, 20);
		getContentPane().add(cboEstCiv);
		
		cboTipCli = new JComboBox();
		cboTipCli.setModel(new DefaultComboBoxModel(new String[] {"Est\u00E1ndar", "Bronce", "Plata", "Oro", "Diamante"}));
		cboTipCli.setBounds(702, 76, 125, 20);
		getContentPane().add(cboTipCli);
		
		modelo.addColumn("ID CLIENTE");
		modelo.addColumn("APELLIDO PATERNO");
		modelo.addColumn("APPELLIDO MATERNO");
		modelo.addColumn("NOMBRES");
		modelo.addColumn("DIRECCION");
		modelo.addColumn("FECHA DE NACIMIENTO");
		modelo.addColumn("FECHA DE AFILIACION");
		modelo.addColumn("ESTADO CIVIL");
		modelo.addColumn("TELEFONO");
		modelo.addColumn("DNI");
		modelo.addColumn("TIPO DE CLIENTE");
		modelo.addColumn("USUARIO");
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setModel(modelo);
		table.addMouseListener(this);
		scrollPane.setViewportView(table);
		
		btnIngreso = new JButton("Ingreso");
		btnIngreso.addActionListener(this);
		btnIngreso.setBounds(31, 525, 112, 24);
		btnIngreso.addActionListener(this);
		getContentPane().add(btnIngreso);
		
		btnConsulta = new JButton("Consulta");
		btnConsulta.setBounds(289, 526, 124, 23);
		btnConsulta.addActionListener(this);
		getContentPane().add(btnConsulta);
		
		btnEliminacion = new JButton("Eliminaci\u00F3n");
		btnEliminacion.setBounds(430, 526, 109, 23);
		btnEliminacion.addActionListener(this);
		getContentPane().add(btnEliminacion);
		
		btnListado = new JButton("Listado");
		btnListado.addActionListener(this);
		btnListado.setBounds(713, 526, 101, 23);
		btnListado.addActionListener(this);
		getContentPane().add(btnListado);
		
		btnOk = new JButton("OK");
		btnOk.setEnabled(false);
		btnOk.addActionListener(this);
		btnOk.setBounds(154, 526, 125, 23);
		getContentPane().add(btnOk);
		
		setResizable(false);
		
		modelo.setRowCount(0);
		llenarTabla();
		
	}
	
	private void llenarTabla() {
		
		for(int i=0; i<ac.tamaño();i++){
		Object[] datos = {Cliente.PRE+ac.obtener(i).getIdCliente(),
				ac.obtener(i).getApellidoPaterno(),
				ac.obtener(i).getApellidoMaterno(),
				ac.obtener(i).getNombres(),
				ac.obtener(i).getDireccion(),
				ac.obtener(i).getFechaNacimiento(),
				ac.obtener(i).getFechaAfiliacion(),
				Cliente.obtenerEstadoCivil(ac.obtener(i).getEstadoCivil()),
				ac.obtener(i).getTelefono(),
				ac.obtener(i).getDni(),
				Cliente.obtenerTipo(ac.obtener(i).getTipoDeCliente()),
				ac.obtener(i).getUsuario(),};
		modelo.addRow(datos);
		}
	}//final llenarTabla
	
	private void llenarTabla(int indice) {
		
		for(int i=0; i<ac.tamaño();i++){
		Object[] datos = {Cliente.PRE+ac.obtener(indice).getIdCliente(),
				ac.obtener(indice).getApellidoPaterno(),
				ac.obtener(indice).getApellidoMaterno(),
				ac.obtener(indice).getNombres(),
				ac.obtener(indice).getDireccion(),
				ac.obtener(indice).getFechaNacimiento(),
				ac.obtener(indice).getFechaAfiliacion(),
				Cliente.obtenerEstadoCivil(ac.obtener(indice).getEstadoCivil()),
				ac.obtener(indice).getTelefono(),
				ac.obtener(indice).getDni(),
				Cliente.obtenerTipo(ac.obtener(indice).getTipoDeCliente()),
				ac.obtener(indice).getUsuario()};
		modelo.addRow(datos);
		}
	}//final llenarTabla 2
	
	private void llenarTxt(int indice){
		
		if(indice>=0){
			txtCodigo.setText(Cliente.PRE+ac.obtener(indice).getIdCliente());
			txtApPat.setText(ac.obtener(indice).getApellidoPaterno());
			txtApMat.setText(ac.obtener(indice).getApellidoMaterno());
			txtNombres.setText(ac.obtener(indice).getNombres());
			txtDireccion.setText(ac.obtener(indice).getDireccion());
			txtFecNac.setText(ac.obtener(indice).getFechaNacimiento());
			txtFecAfi.setText(ac.obtener(indice).getFechaAfiliacion());
			cboEstCiv.setSelectedIndex(ac.obtener(indice).getEstadoCivil());
			txtTelefono.setText(ac.obtener(indice).getTelefono());
			txtDNI.setText(ac.obtener(indice).getDni());
			cboTipCli.setSelectedIndex(ac.obtener(indice).getTipoDeCliente());
			txtUsuario.setText(ac.obtener(indice).getUsuario());
			
		}
	}//final llenartxt
	
	private void vaciarTxt() {
		
		txtCodigo.setText("");
		txtApPat.setText("");
		txtApMat.setText("");
		txtNombres.setText("");
		txtDireccion.setText("");
		txtFecNac.setText("");
		txtFecAfi.setText("");
		cboEstCiv.setSelectedIndex(0);
		txtTelefono.setText("");
		txtDNI.setText("");
		cboTipCli.setSelectedIndex(0);
		txtUsuario.setText("");
	}//final vaciartxt


	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(arg0.getSource()==btnIngreso){
			
			txtCodigo.setEditable(false);
			vaciarTxt();
			txtCodigo.setText(Cliente.PRE+ac.codigoCorrelativo());
			txtFecAfi.setText(fecha);
			txtNombres.requestFocus();
			btnOk.setEnabled(true);
			
			operacionActual=DCliente.INGRESO;
		}
		else if(arg0.getSource()==btnConsulta){
			vaciarTxt();
			txtCodigo.setEditable(true);
			txtCodigo.requestFocus();
			btnOk.setEnabled(true);
			
			operacionActual=DCliente.CONSULTA;
		}
		else if(arg0.getSource()==btnEliminacion){
			
			int indice = table.getSelectedRow();
			
			if(indice>=0){
				
				int respuesta = JOptionPane.showConfirmDialog(this, "Desea borrar el registro "+(indice+1)+"?",
						"Seguro?",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				
				if(respuesta == JOptionPane.YES_OPTION){
					ac.eliminar(indice);
					
					modelo.setRowCount(0);
					
					vaciarTxt();
					
					llenarTabla();
				}
				
			} else {
				
				JOptionPane.showConfirmDialog(this, "No ha seleccionado registro", "Mucho cuidado",
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
			
			case DCliente.INGRESO:
				okIngreso();
				break;
			case DCliente.CONSULTA:
				okConsulta();
				break;
			default:
				okModifcacion();
				
			}
			
		}
		
	}//final actionPerformed
	
	private void ingresarRegistro() {
		
		ac.agregar(new Cliente( ac.codigoCorrelativo(),  
				txtApPat.getText(), 
				txtApMat.getText(), 
				txtNombres.getText(), 
				txtDireccion.getText(), 
				txtFecNac.getText(), 
				txtFecAfi.getText(),
				cboEstCiv.getSelectedIndex(), 
				txtTelefono.getText(), 
				txtDNI.getText(), 
				cboTipCli.getSelectedIndex(), 
				txtUsuario.getText()));
	}
	
	private void reemplazarRegistro(int indice) {
		
		if (indice>=0){
		
		ac.reemplazar(new Cliente(	ac.obtener(indice).getIdCliente(),
				txtApPat.getText(), 
				txtApMat.getText(), 
				txtNombres.getText(), 
				txtDireccion.getText(), 
				txtFecNac.getText(),
				txtFecAfi.getText(),
				cboEstCiv.getSelectedIndex(), 
				txtTelefono.getText(), 
				txtDNI.getText(), 
				cboTipCli.getSelectedIndex(),
				txtUsuario.getText()), indice);
		}
	}
	
	private int consultarRegistro() {
		
		//Consulta según todos los campos. Si coincide un valor devuelve el primer registro		
		if (!(txtCodigo.getText().equals(""))){
			
			//Si contiene el prefijo intento convertirlo a un número
			if(txtCodigo.getText().contains(Cliente.PRE)){
				
				try{
					
					int codigoCliente = Integer.parseInt(txtCodigo.getText().replace(Cliente.PRE, ""));
					
					for	(int i=0;i<ac.tamaño();i++){
						
						if(ac.obtener(i).getIdCliente()==codigoCliente){
							return i;
						}
						
					}
					
				} catch (Exception e){
					
					e.printStackTrace();
				}
				
				
			}
			
		}
		
		if (!(txtApPat.getText().equals(""))){
			
			String valor = txtApPat.getText();
			
			for	(int i=0;i<ac.tamaño();i++){
				
				if(ac.obtener(i).getApellidoPaterno().contains(valor)){
					return i;
				}
				
			}
			
		}
		
		if (!(txtApMat.getText().equals(""))){
			
			String valor = txtApMat.getText();
			
			for	(int i=0;i<ac.tamaño();i++){
				
				if(ac.obtener(i).getApellidoMaterno().contains(valor)){
					return i;
				}
				
			}
			
		}
		
		if (!(txtNombres.getText().equals(""))){
			
			String valor = txtNombres.getText();
			
			for	(int i=0;i<ac.tamaño();i++){
				
				if(ac.obtener(i).getNombres().contains(valor)){
					return i;
				}
				
			}
			
		}
		
		if (!(txtDireccion.getText().equals(""))){
			
			String valor = txtDireccion.getText();
			
			for	(int i=0;i<ac.tamaño();i++){
				
				if(ac.obtener(i).getDireccion().contains(valor)){
					return i;
				}
				
			}
			
		}
		
		if (!(txtFecNac.getText().equals(""))){
			
			String valor = txtFecNac.getText();
			
			for	(int i=0;i<ac.tamaño();i++){
				
				if(ac.obtener(i).getFechaNacimiento().contains(valor)){
					return i;
				}
				
			}
			
		}
		
		if (!(txtFecAfi.getText().equals(""))){
			
			String valor = txtFecAfi.getText();
			
			for	(int i=0;i<ac.tamaño();i++){
				
				if(ac.obtener(i).getFechaAfiliacion().contains(valor)){
					return i;
				}
				
			}
			
		}
		
		if (!(txtTelefono.getText().equals(""))){
			
			String valor = txtTelefono.getText();
			
			for	(int i=0;i<ac.tamaño();i++){
				
				if(ac.obtener(i).getTelefono().contains(valor)){
					return i;
				}
				
			}
			
		}
		
		if (!(txtDNI.getText().equals(""))){
			
			String valor = txtDNI.getText();
			
			for	(int i=0;i<ac.tamaño();i++){
				
				if(ac.obtener(i).getDni().contains(valor)){
					return i;
				}
				
			}
			
		}
		
		if (!(txtUsuario.getText().equals(""))){
			
			String valor = txtUsuario.getText();
			
			for	(int i=0;i<ac.tamaño();i++){
				
				if(ac.obtener(i).getUsuario().contains(valor)){
					return i;
				}
				
			}
			
		}
		
		else{
			
			int tipo=cboTipCli.getSelectedIndex();
			
			for	(int i=0;i<ac.tamaño();i++){
				
				if(ac.obtener(i).getTipoDeCliente()==tipo){
					return i;
				}
			
			}
			
			int turno=cboEstCiv.getSelectedIndex();
			
			for	(int i=0;i<ac.tamaño();i++){
				
				if(ac.obtener(i).getEstadoCivil()==turno){
					return i;
				}
			
			}
		}
		return -1;
	}
		
		private void okModifcacion() {
			
			if(		txtApPat.getText().equals("") ||
					txtApMat.getText().equals("") ||
					txtNombres.getText().equals("") ||
					txtDireccion.getText().equals("") ||
					txtTelefono.getText().equals("") ||
					txtFecNac.getText().equals("") ||
					txtFecAfi.getText().equals("") ||					
					txtDNI.getText().equals("") ||
					txtUsuario.getText().equals("")
					){
				
				JOptionPane.showMessageDialog(	this,
												"Hay espacios en blanco",
												"Tenga cuidado",
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
			
			if(		txtApPat.getText().equals("") ||
					txtApMat.getText().equals("") ||
					txtNombres.getText().equals("") ||
					txtDireccion.getText().equals("") ||
					txtTelefono.getText().equals("") ||
					txtFecNac.getText().equals("") ||
					txtFecAfi.getText().equals("") ||
					txtDNI.getText().equals("") ||
					txtUsuario.getText().equals("")){
				
				JOptionPane.showMessageDialog(	this,
												"Hay espacios en blanco",
												"tenga cuidado",
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
	public void mouseClicked(MouseEvent e) {
		
		if(ac.tamaño()==table.getRowCount()){
			
		txtCodigo.setEditable(false);
		
		btnOk.setEnabled(true);
		
		llenarTxt(table.getSelectedRow());
	
		operacionActual = DCliente.MODIFICACION;
		
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
