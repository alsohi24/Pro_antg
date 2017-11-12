package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import arreglo.ArregloUsuario;
import clases.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JPasswordField;


public class DUsuario extends JDialog implements ActionListener, MouseListener {

	private static final int INGRESO = 0;
	private static final int CONSULTA = 1;
	private static final int MODIFICACION = 2;
	
	private final JPanel contentPanel = new JPanel();
	private JTextField textNombres;
	private JTextField textApPat;
	private JTextField textApMat;
	private JTextField textCodigo;
	private JComboBox cboTipo;
	private JComboBox cboTurno;
	private JButton btnIngreso;
	private JButton btnConsulta;
	private JButton btnElimina;
	private JButton btnListado;
	private JButton btnOk;
	private DefaultTableModel modelo = new DefaultTableModel();
	private ArregloUsuario au = new ArregloUsuario();
	
	private int operacionActual;
	private JTable table;
	private JLabel lblLogin;
	private JLabel lblContrasea;
	private JTextField txtLogin;
	private JPasswordField txtContraseña;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DUsuario dialog = new DUsuario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DUsuario() {
		setTitle("Mantenimiento | Usuario");
		setBounds(100, 100, 791, 611);
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
		
		textNombres = new JTextField();
		textNombres.setBounds(154, 51, 125, 20);
		getContentPane().add(textNombres);
		textNombres.setColumns(10);
		
		JLabel lblApellidoPaterno = new JLabel("Apellido paterno");
		lblApellidoPaterno.setBounds(21, 79, 108, 14);
		getContentPane().add(lblApellidoPaterno);
		
		textApPat = new JTextField();
		textApPat.setBounds(154, 76, 125, 20);
		getContentPane().add(textApPat);
		textApPat.setColumns(10);
		
		JLabel lblApellidoMaterno = new JLabel("Apellido materno");
		lblApellidoMaterno.setBounds(21, 104, 108, 14);
		getContentPane().add(lblApellidoMaterno);
		
		textApMat = new JTextField();
		textApMat.setBounds(154, 101, 125, 20);
		getContentPane().add(textApMat);
		textApMat.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(427, 29, 108, 14);
		getContentPane().add(lblTipo);
		
		cboTipo = new JComboBox();
		cboTipo.setModel(new DefaultComboBoxModel(new String[] {Usuario.obtenerTipo(0),Usuario.obtenerTipo(1), 
				Usuario.obtenerTipo(2)}));
		cboTipo.setBounds(602, 26, 125, 20);
		getContentPane().add(cboTipo);
		
		JLabel lblTurno = new JLabel("Turno");
		lblTurno.setBounds(427, 54, 108, 14);
		getContentPane().add(lblTurno);
		
		cboTurno = new JComboBox();
		cboTurno.setModel(new DefaultComboBoxModel(new String[] {Usuario.obtenerTurno(0),
				Usuario.obtenerTurno(1)}));
		cboTurno.setBounds(602, 51, 125, 20);
		getContentPane().add(cboTurno);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 136, 743, 379);
		getContentPane().add(scrollPane);
		
		modelo.addColumn("CÓDIGO");
		modelo.addColumn("APELLIDO PATERNO");
		modelo.addColumn("APELLIDO MATERNO");
		modelo.addColumn("NOMBRES");
		modelo.addColumn("TIPO EMPLEADO");
		modelo.addColumn("TURNO");
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setModel(modelo);
		table.addMouseListener(this);
		scrollPane.setViewportView(table);
		
		btnIngreso = new JButton("Ingreso");
		btnIngreso.setBounds(21, 526, 102, 24);
		btnIngreso.addActionListener(this);
		getContentPane().add(btnIngreso);
		
		btnConsulta = new JButton("Consulta");
		btnConsulta.setBounds(245, 526, 108, 23);
		btnConsulta.addActionListener(this);
		getContentPane().add(btnConsulta);
		
		btnElimina = new JButton("Elimina");
		btnElimina.setBounds(363, 526, 113, 23);
		btnElimina.addActionListener(this);
		getContentPane().add(btnElimina);
		
		btnListado = new JButton("Listado");
		btnListado.addActionListener(this);
		btnListado.setBounds(659, 526, 94, 23);
		btnListado.addActionListener(this);
		getContentPane().add(btnListado);
		
		textCodigo =new JTextField();
		textCodigo.setBounds(153, 26, 126, 20);
		getContentPane().add(textCodigo);
		textCodigo.setColumns(10);
		//
		textCodigo.setEditable(false);
		
		btnOk = new JButton("OK");
		btnOk.setBounds(133, 527, 102, 23);
		btnOk.addActionListener(this);
		btnOk.setEnabled(false);
		getContentPane().add(btnOk);
		
		lblLogin = new JLabel("Login");
		lblLogin.setBounds(427, 79, 108, 14);
		getContentPane().add(lblLogin);
		
		lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(427, 104, 108, 14);
		getContentPane().add(lblContrasea);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(602, 76, 125, 20);
		getContentPane().add(txtLogin);
		txtLogin.setColumns(10);
		
		txtContraseña = new JPasswordField();
		txtContraseña.setBounds(602, 101, 125, 20);
		getContentPane().add(txtContraseña);
		
		setResizable(false);
		
		modelo.setRowCount(0);
		llenarTabla();
		
	}
	
	private void llenarTabla() {
		
				
		for(int i=0;i<au.tamaño();i++){
			
			Object[] datos = {Usuario.PRE+au.obtener(i).getIdUsuario(),
					au.obtener(i).getApellidoPaterno(),
					au.obtener(i).getApellidoMaterno(),
					au.obtener(i).getNombres(),
					Usuario.obtenerTipo(au.obtener(i).getTipoEmpleado()),
					Usuario.obtenerTurno(au.obtener(i).getTurno())};
			
			modelo.addRow(datos);
						
		}
		
	}
	
	private void llenarTabla(int indice){
		
		Object[] datos = {Usuario.PRE+au.obtener(indice).getIdUsuario(),
				au.obtener(indice).getApellidoPaterno(),
				au.obtener(indice).getApellidoMaterno(),
				au.obtener(indice).getNombres(),
				Usuario.obtenerTipo(au.obtener(indice).getTipoEmpleado()),
				Usuario.obtenerTurno(au.obtener(indice).getTurno())};
		
		modelo.addRow(datos);
		
	}
	
	private void llenarTxt(int indice) {
		
		if(indice>=0){

		textCodigo.setText(Usuario.PRE+au.obtener(indice).getIdUsuario());
		textApPat.setText(au.obtener(indice).getApellidoPaterno());
		textApMat.setText(au.obtener(indice).getApellidoMaterno());
		textNombres.setText(au.obtener(indice).getNombres());
		txtLogin.setText("...");
		txtContraseña.setText("...");
		cboTipo.setSelectedIndex(au.obtener(indice).getTipoEmpleado());
		cboTurno.setSelectedIndex(au.obtener(indice).getTurno());
		
		}		
	}
	
	private void vaciarTxt() {
		textCodigo.setText("");
		textApPat.setText("");
		textApMat.setText("");
		textNombres.setText("");
		txtLogin.setText("");
		txtContraseña.setText("");
		cboTipo.setSelectedIndex(0);
		cboTurno.setSelectedIndex(0);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(arg0.getSource()==btnIngreso){
			
			textCodigo.setEditable(false);
			vaciarTxt();
			//llenarTabla();
			textCodigo.setText(Usuario.PRE+au.codigoCorrelativo());
			textNombres.requestFocus();
			btnOk.setEnabled(true);
			
			operacionActual=DUsuario.INGRESO;
		}
		
		else if(arg0.getSource()==btnConsulta){
			vaciarTxt();
			textCodigo.setEditable(true);
			textCodigo.requestFocus();
			btnOk.setEnabled(true);
			
			operacionActual=DUsuario.CONSULTA;
			
		}
		
		else if(arg0.getSource()==btnElimina){
			
			//Valido si es mayor o igual que cero para mostrar el mensaje apropiado
			int indice = table.getSelectedRow();
			
			if(indice>=0){
				
				if(table.getRowCount()>1){
			
					int respuesta = JOptionPane.showConfirmDialog(this, "¿Desea borrar el registro "+(indice+1)+"?",
					"¿Lo tumbo?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			
					if (respuesta==JOptionPane.YES_OPTION){
				
						au.eliminar(indice);
				
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
			
			case DUsuario.INGRESO:
				okIngreso();
				break;
			case DUsuario.CONSULTA:
				okConsulta();
				break;
			default:
				okModifcacion();
				
			}
			
		}
				
	}

	private void ingresarRegistro() {
		
		au.agregar(new Usuario(	au.codigoCorrelativo(),
								textApPat.getText(),
								textApMat.getText(),
								textNombres.getText(),
								txtLogin.getText(),
								String.valueOf(txtContraseña.getPassword()),
								cboTipo.getSelectedIndex(),
								cboTurno.getSelectedIndex()));
		
	}
	
	private void reemplazarRegistro(int indice) {
		
		if (indice>=0){
		
		au.reemplazar(new Usuario(	au.codigoCorrelativo(),
								textApPat.getText(),
								textApMat.getText(),
								textNombres.getText(),
								txtLogin.getText(),
								String.valueOf(txtContraseña.getPassword()),
								cboTipo.getSelectedIndex(),
								cboTurno.getSelectedIndex()), indice);
		}
	}

	private int consultarRegistro() {
	
		//Consulta según todos los campos. Si coincide un valor devuelve el primer registro		
		if (!(textCodigo.getText().equals(""))){
			
			//Si contiene el prefijo intento convertirlo a un número
			if(textCodigo.getText().contains(Usuario.PRE)){
				
				try{
					
					int codigoUsuario = Integer.parseInt(textCodigo.getText().replace(Usuario.PRE, ""));
					
					for	(int i=0;i<au.tamaño();i++){
						
						if(au.obtener(i).getIdUsuario()==codigoUsuario){
							return i;
						}
						
					}
					
				} catch (Exception e){
					
					e.printStackTrace();
				}
				
				
			}
			
		} 
		
		if (!(textNombres.getText().equals(""))){
			
			String valor = textNombres.getText();
			
			for	(int i=0;i<au.tamaño();i++){
				
				if(au.obtener(i).getNombres().contains(valor)){
					return i;
				}
				
			}
			
		}
		
		if (!(textApPat.getText().equals(""))){
			
			String valor = textApPat.getText();
			
			for	(int i=0;i<au.tamaño();i++){
				
				if(au.obtener(i).getApellidoPaterno().contains(valor)){
					return i;
				}
				
			}
			
		}
		
		if (!(textApMat.getText().equals(""))){
			
			String valor = textApMat.getText();
			
			for	(int i=0;i<au.tamaño();i++){
				
				if(au.obtener(i).getApellidoMaterno().contains(valor)){
					return i;
				}
				
			}
			
		}
		
		else{
			
			int tipo=cboTipo.getSelectedIndex();
			
			for	(int i=0;i<au.tamaño();i++){
				
				if(au.obtener(i).getTipoEmpleado()==tipo){
					return i;
				}
			
			}
			
			int turno=cboTurno.getSelectedIndex();
			
			for	(int i=0;i<au.tamaño();i++){
				
				if(au.obtener(i).getTurno()==turno){
					return i;
				}
			
			}
		}
		return -1;
	}
	
		
	
	private void okModifcacion() {
		
		if(		textNombres.getText().equals("") ||
				textApPat.getText().equals("") ||
				textApMat.getText().equals("")){
			
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
		
		if(		textNombres.getText().equals("") ||
				textApPat.getText().equals("") ||
				textApMat.getText().equals("") ||
				txtLogin.getText().equals("") ||
				String.valueOf(txtContraseña.getPassword()).equals("")){
			
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
		
		if(au.tamaño()==table.getRowCount()){
		
		textCodigo.setEditable(false);
		
		btnOk.setEnabled(true);
		
		llenarTxt(table.getSelectedRow());
	
		operacionActual = DUsuario.MODIFICACION;
		
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
