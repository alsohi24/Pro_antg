package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import arreglo.ArregloArtista;
import arreglo.ArregloGenero;
import arreglo.ArregloUsuario;
import clases.Artista;
import clases.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class DArtista extends JDialog implements ActionListener, MouseListener{
	
	private static final int INGRESO = 0;
	private static final int CONSULTA = 1;
	private static final int MODIFICACION = 2;
	
	private final JPanel contentPanel = new JPanel();
	private JTextField textNombres;
	private JTextField textCodigo;
	private JButton btnIngreso;
	private JButton btnOk;
	private JButton btnConsulta;
	private JButton btnElimina;
	private JButton btnListado;
	private JTextField txtFecha;
	private JComboBox cboEstado;
	private JComboBox cboGenero;
	private JTable table;
	private DefaultTableModel modelo = new DefaultTableModel();
	private ArregloArtista au = new ArregloArtista();
	private ArregloGenero ag = new ArregloGenero();
	
	private int operacionActual;
	private SimpleDateFormat formato = new SimpleDateFormat("dd/MM/YY");
	private String fecha = formato.format(new Date());
	private String[] stringGeneros = new String[ag.tamaño()];
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DArtista dialog = new DArtista();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DArtista() {
		
		//Valido que haya al menos un género registrado
		if (ag.tamaño()!=0){
							
		setTitle("Mantenimiento | Artista");
		setBounds(100, 100, 796, 579);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 561, 784, 1);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JLabel lblGenero = new JLabel("Genero");
			lblGenero.setBounds(10, 64, 140, 14);
			getContentPane().add(lblGenero);
		}
		{
			JLabel lblNombreArtistico = new JLabel("Nombre Artistico");
			lblNombreArtistico.setBounds(10, 39, 140, 14);
			getContentPane().add(lblNombreArtistico);
		}
		{
			JLabel lblCodArtista = new JLabel("C\u00F3digo");
			lblCodArtista.setBounds(10, 14, 140, 14);
			getContentPane().add(lblCodArtista);
		}
		{
			textNombres = new JTextField();
			textNombres.setColumns(10);
			textNombres.setBounds(160, 36, 139, 20);
			getContentPane().add(textNombres);
		}
		{
			textCodigo = new JTextField();
			textCodigo.setEditable(false);
			textCodigo.setColumns(10);
			textCodigo.setBounds(160, 11, 139, 20);
			getContentPane().add(textCodigo);
		}
		{
			JLabel lblEstado = new JLabel("Estado");
			lblEstado.setBounds(344, 39, 97, 14);
			getContentPane().add(lblEstado);
		}
		{
			JLabel lblFecha = new JLabel("Fecha");
			lblFecha.setBounds(344, 14, 97, 14);
			getContentPane().add(lblFecha);
		}
	
		cboEstado = new JComboBox();
		cboEstado.setModel(new DefaultComboBoxModel(new String[] {Artista.obtenerEstadoCivil(0),Artista.obtenerEstadoCivil(1),Artista.obtenerEstadoCivil(2),Artista.obtenerEstadoCivil(3),Artista.obtenerEstadoCivil(4)}));
		cboEstado.setBounds(451, 36, 148, 20);
		getContentPane().add(cboEstado);
		
		//LLeno el combo con String de genero
		for(int i=0;i<ag.tamaño();i++){
			
			stringGeneros[i] = ag.obtener(i).getdescripcion();
			
		}
		
		cboGenero = new JComboBox();
		cboGenero.setBounds(160, 61, 139, 20);
		cboGenero.setModel(new DefaultComboBoxModel(stringGeneros));
		getContentPane().add(cboGenero);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 109, 764, 385);
		getContentPane().add(scrollPane);
		
		modelo.addColumn("CÓDIGO");
		modelo.addColumn("NOMBRE ARTÍSTICO");
		modelo.addColumn("GÉNERO");
		modelo.addColumn("FECHA REGISTRO");
		modelo.addColumn("ESTADO");
				
		table= new JTable();
		table.setFillsViewportHeight(true);
		table.setModel(modelo);
		table.addMouseListener(this);
		scrollPane.setViewportView(table);		
		
		btnIngreso = new JButton("Ingreso");
		btnIngreso.setBounds(10, 505, 89, 23);
		btnIngreso.addActionListener(this);
		getContentPane().add(btnIngreso);
		
		btnOk = new JButton("Ok");
		btnOk.setBounds(109, 505, 89, 23);
		btnOk.addActionListener(this);
		getContentPane().add(btnOk);
		
		btnConsulta = new JButton("Consulta");
		btnConsulta.setBounds(208, 505, 89, 23);
		btnConsulta.addActionListener(this);
		getContentPane().add(btnConsulta);
		
		btnElimina = new JButton("Elimina");
		btnElimina.setBounds(307, 505, 89, 23);
		btnElimina.addActionListener(this);
		getContentPane().add(btnElimina);
		
		btnListado = new JButton("Listado");
		btnListado.setBounds(685, 505, 89, 23);
		btnListado.addActionListener(this);
		getContentPane().add(btnListado);
		
		txtFecha = new JTextField();
		txtFecha.setEditable(false);
		txtFecha.setBounds(451, 11, 148, 20);
		txtFecha.setText(fecha);
		getContentPane().add(txtFecha);
		txtFecha.setColumns(10);
		
		modelo.setRowCount(0);
		
		llenarTabla();
		
		setResizable(false);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		setVisible(true);
		
		} else {
			
			this.dispose();

			JOptionPane.showMessageDialog(this, "Necesita registrar al menos un género", "Cuidado, mucho cuidado",
					JOptionPane.ERROR_MESSAGE);
		
		
		}			
		
	}
	
	private void llenarTabla() {
		
		
		for(int i=0;i<au.tamaño();i++){
			
			Object[] datos = {Artista.PRE+au.obtener(i).getidArtista(),
					au.obtener(i).getNombreArtistico(),
					ag.obtener(au.obtener(i).getidGenero()).getdescripcion(),
					au.obtener(i).getfechaRegistroCatalogo(),
					Artista.obtenerEstadoCivil(au.obtener(i).getestado()),
					};
			
			modelo.addRow(datos);
			
			}
				
		}
		
	private void llenarTabla(int i){
			
		Object[] datos = {Artista.PRE+au.obtener(i).getidArtista(),
				au.obtener(i).getNombreArtistico(),
				ag.obtener(au.obtener(i).getidGenero()).getdescripcion(),
				au.obtener(i).getfechaRegistroCatalogo(),
				Artista.obtenerEstadoCivil(au.obtener(i).getestado()),
				};
			
			modelo.addRow(datos);
			
		}
	
	private void llenarTxt(int indice) {
			
			if(indice>=0){
	
			textCodigo.setText(Artista.PRE+au.obtener(indice).getidArtista());
			textNombres.setText(au.obtener(indice).getNombreArtistico());
			cboGenero.setSelectedIndex(au.obtener(indice).getidGenero());
			txtFecha.setText(au.obtener(indice).getfechaRegistroCatalogo());
			cboEstado.setSelectedIndex(au.obtener(indice).getestado());
						
			}		
		}
	
	private void vaciarTxt() {
		
		textCodigo.setText("");
		textNombres.setText("");
		cboGenero.setSelectedIndex(0);
		txtFecha.setText("");
		cboEstado.setSelectedIndex(0);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(arg0.getSource()==btnIngreso){
			
			textCodigo.setEditable(false);
			vaciarTxt();
			//llenarTabla();
			textCodigo.setText(Artista.PRE+au.codigoCorrelativo());
			txtFecha.setText(fecha);
			textNombres.requestFocus();
			btnOk.setEnabled(true);
			
			operacionActual=DArtista.INGRESO;
		}
		
		else if(arg0.getSource()==btnConsulta){
			vaciarTxt();
			textCodigo.setEditable(true);
			textCodigo.requestFocus();
			btnOk.setEnabled(true);
			
			operacionActual=DArtista.CONSULTA;
			
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
			
			case DArtista.INGRESO:
				okIngreso();
				break;
			case DArtista.CONSULTA:
				okConsulta();
				break;
			default:
				okModifcacion();
				
			}
			
		}
		
		
	}
	
	private void ingresarRegistro() {
			
			au.agregar(new Artista(	au.codigoCorrelativo(),
									textNombres.getText(),
									cboGenero.getSelectedIndex(),
									txtFecha.getText(),
									cboEstado.getSelectedIndex()));
			
		}
	
	private void reemplazarRegistro(int indice) {
			
			if (indice>=0){
			
			au.reemplazar(new Artista(	au.obtener(indice).getidArtista(),
					textNombres.getText(),
					cboGenero.getSelectedIndex(),
					txtFecha.getText(),
					cboEstado.getSelectedIndex()), indice);
			}
		}
	
	private int consultarRegistro() {
		
		//Consulta según todos los campos. Si coincide un valor devuelve el primer registro		
		if (!(textCodigo.getText().equals(""))){
			
			//Si contiene el prefijo intento convertirlo a un número
			if(textCodigo.getText().contains(Artista.PRE)){
				
				try{
					
					int codigo = Integer.parseInt(textCodigo.getText().replace(Usuario.PRE, ""));
					
					for	(int i=0;i<au.tamaño();i++){
						
						if(au.obtener(i).getidArtista()==codigo){
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
				
				if(au.obtener(i).getNombreArtistico().contains(valor)){
					return i;
				}
				
			}
			
		}
				
		else {
			
			int genero=cboGenero.getSelectedIndex();
			
			for	(int i=0;i<au.tamaño();i++){
				
				if(au.obtener(i).getidGenero()==genero){
					return i;
				}
			
			}
			
			int estado=cboEstado.getSelectedIndex();
			
			for	(int i=0;i<au.tamaño();i++){
				
				if(au.obtener(i).getestado()==estado){
					return i;
				}
			
			}
		}
		return -1;
	}
	
	private void okModifcacion() {
		
		if (textNombres.getText().equals("")){
			
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
		
		if(		textNombres.getText().equals("")
			){
			
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
			
				operacionActual = DArtista.MODIFICACION;
				
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
