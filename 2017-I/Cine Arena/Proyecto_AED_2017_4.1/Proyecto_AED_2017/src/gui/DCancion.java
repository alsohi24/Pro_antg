package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import arreglo.ArregloArtista;
import arreglo.ArregloCancion;
import clases.Cancion;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class DCancion extends JDialog implements ActionListener , MouseListener{

	private static final int CONSULTA = 0;
	private static final int INGRESO = 1;
	private static final int MODIFICACION = 2;
	
	private final JPanel contentPanel = new JPanel();
	private JTextField textCodigo;
	private JTextField textNombre;
	private JTextField textDuracion;
	private JComboBox  cboNombreArtista;
	private JTextField textAlbum;
	private JTextField textNumeroReproducciones;
    private JComboBox  cboEstado;

	private JButton    btnIngreso;
	private JButton    btnOk;
	private JButton    btnConsulta;
	private JButton    btnEliminar;
	private JButton    btnListado;
	private JTable table;
	private DefaultTableModel modelo = new DefaultTableModel();
	private ArregloCancion ca = new ArregloCancion();
	private ArregloArtista aa = new ArregloArtista();
	
	private int operacionActual;
	private String[] stringArtistas = new String[aa.tamaño()];
	
	public static void main(String[] args) {
		try {
			DCancion dialog = new DCancion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DCancion() {
		
		//Valido que haya al menos un género registrado
		if (aa.tamaño()!=0){
							
		setTitle("Mantenimiento | Cancion");
		setBounds(100, 100, 800, 589);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
			JLabel lblDuracion = new JLabel("Duracion");
			lblDuracion.setBounds(10, 64, 104, 16);
			contentPanel.add(lblDuracion);
		
			JLabel lblNombre = new JLabel("Nombre");
			lblNombre.setBounds(10, 39, 104, 16);
			contentPanel.add(lblNombre);
		
			JLabel lblCodigo = new JLabel("Codigo");
			lblCodigo.setBounds(11, 13, 104, 16);
			contentPanel.add(lblCodigo);
		
			textDuracion = new JTextField();
			textDuracion.setColumns(10);
			textDuracion.setBounds(125, 62, 119, 20);
			contentPanel.add(textDuracion);
		
			textNombre = new JTextField();
			textNombre.setColumns(10);
			textNombre.setBounds(125, 36, 119, 20);
			contentPanel.add(textNombre);
		
			textCodigo = new JTextField();
			textCodigo.setEditable(false);
			textCodigo.setColumns(10);
			textCodigo.setBounds(125, 11, 119, 20);
			contentPanel.add(textCodigo);
		
			JLabel lblAlbum = new JLabel("Album");
			lblAlbum.setBounds(291, 39, 96, 16);
			contentPanel.add(lblAlbum);
		
			JLabel lblNombreDeArtista = new JLabel("Artista");
			lblNombreDeArtista.setBounds(291, 13, 96, 16);
			contentPanel.add(lblNombreDeArtista);
		
			JLabel lblEstado = new JLabel("Estado");
			lblEstado.setBounds(662, 14, 46, 14);
			contentPanel.add(lblEstado);
		
			JLabel lblNumeroReproducciones = new JLabel("Reproducciones");
			lblNumeroReproducciones.setBounds(291, 65, 131, 14);
			contentPanel.add(lblNumeroReproducciones);
		
			textAlbum = new JTextField();
			textAlbum.setColumns(10);
			textAlbum.setBounds(465, 37, 119, 20);
			contentPanel.add(textAlbum);
		
			textNumeroReproducciones = new JTextField();
			textNumeroReproducciones.setBounds(465, 62, 119, 20);
			contentPanel.add(textNumeroReproducciones);
			textNumeroReproducciones.setColumns(10);
	
			cboEstado = new JComboBox();
			cboEstado.setModel(new DefaultComboBoxModel(new String[] {Cancion.obtenerEstado(0), Cancion.obtenerEstado(1)}));
			cboEstado.setBounds(634, 37, 119, 20);
			contentPanel.add(cboEstado);
		
			//LLeno el combo con String de genero
			for(int i=0;i<aa.tamaño();i++){
				
				stringArtistas[i] = aa.obtener(i).getNombreArtistico();
				
			}			
			
			cboNombreArtista = new JComboBox();
			cboNombreArtista.setModel(new DefaultComboBoxModel(stringArtistas));
			cboNombreArtista.setBounds(465, 11, 119, 20);
			contentPanel.add(cboNombreArtista);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 112, 764, 391);
		contentPanel.add(scrollPane);
			
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setModel(modelo);
		table.addMouseListener(this);
		scrollPane.setViewportView(table);
				
		modelo.addColumn("CODIGO");
		modelo.addColumn("NOMBRE");
		modelo.addColumn("DURACION");
		modelo.addColumn("ARTISTA");
		modelo.addColumn("ALBUM");
		modelo.addColumn("REPRODUCCIONES");
		modelo.addColumn("ESTADO");
					
		btnIngreso = new JButton("Ingreso");
		btnIngreso.setBounds(10, 514, 119, 23);
		btnIngreso.addActionListener(this);
		contentPanel.add(btnIngreso);
		
		btnOk = new JButton("Ok");
		btnOk.setEnabled(false);
		btnOk.setBounds(139, 514, 119, 23);
		btnOk.addActionListener(this);
		contentPanel.add(btnOk);
		
		btnConsulta = new JButton("Consulta");
		btnConsulta.setBounds(268, 514, 119, 23);
		btnConsulta.addActionListener(this);
		contentPanel.add(btnConsulta);
		
		btnEliminar = new JButton("Eliminar ");
		btnEliminar.setBounds(397, 514, 119, 23);
		btnEliminar.addActionListener(this);
		contentPanel.add(btnEliminar);
		
		btnListado = new JButton("Listado");
		btnListado.setBounds(655, 514, 119, 23);
		btnListado.addActionListener(this);
		contentPanel.add(btnListado);
		
		modelo.setRowCount(0);
		
		llenarTabla();
		
		setResizable(false);
		setLocationRelativeTo(this);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		setVisible(true);
					
		} else {
					
			this.dispose();

			JOptionPane.showMessageDialog(this, "Necesita registrar al menos un artista", "Cuidado, mucho cuidado",
					JOptionPane.ERROR_MESSAGE);
			
		}
	
	}
	

    private void llenarTabla (){
    	
   for(int i=0 ; i<ca.tamaño(); i++){
	   
	   Object[]  datos ={ Cancion.PRE+ca.obtener(i).getidCancion(),
			             ca.obtener(i).getnombre(),
			             ca.obtener(i).getduracion(),
			             aa.obtener(ca.obtener(i).getidArtista()).getNombreArtistico(),
			             ca.obtener(i).getalbum(),
			             ca.obtener(i).getnumeroReproducciones(),
			             Cancion.obtenerEstado(ca.obtener(i).getestado()),
		                 };
	   modelo.addRow(datos);
         }
    }
		
    
    private void llenarTabla (int indice){
           	   
     	   Object[]  datos ={ Cancion.PRE+ca.obtener(indice).getidCancion(),
     			     ca.obtener(indice).getnombre(),
		             ca.obtener(indice).getduracion(),
		             aa.obtener(ca.obtener(indice).getidArtista()).getNombreArtistico(),
		             ca.obtener(indice).getalbum(),
		             ca.obtener(indice).getnumeroReproducciones(),
		             Cancion.obtenerEstado(ca.obtener(indice).getestado()),
     	                     };
     	   modelo.addRow(datos);
              }
    
    
    private void llenartxt(int indice){
    	if(indice>=0){
    		textCodigo.setText(Cancion.PRE+ca.obtener(indice).getidCancion());
    		textDuracion.setText(ca.obtener(indice).getduracion());
    		textAlbum.setText(ca.obtener(indice).getalbum());
    		textNumeroReproducciones.setText(""+ca.obtener(indice).getnumeroReproducciones());
    		textNombre.setText(ca.obtener(indice).getnombre());
    	    
    	}
      }
    
    private void vaciartxt(){
    	textCodigo.setText("");
    	textNombre.setText("");
        textDuracion.setText("");
        cboNombreArtista.setSelectedIndex(0);
        textAlbum.setText("");
        textNumeroReproducciones.setText("");
    	cboEstado.setSelectedIndex(0);
    }
      

@Override
public void actionPerformed(ActionEvent arg0) {
	
	if(arg0.getSource()==btnIngreso){
		
		textCodigo.setEditable(false);
		vaciartxt();
		//llenarTabla();
		textCodigo.setText(Cancion.PRE+ca.codigoCorrelativo());
		textNombre.requestFocus();
	
		btnOk.setEnabled(true);
		operacionActual=DCancion.INGRESO;
	}
	
	else if(arg0.getSource()==btnConsulta){
		vaciartxt();
		textCodigo.setEditable(true);
		textCodigo.requestFocus();
		btnOk.setEnabled(true);
		
		operacionActual=DCancion.CONSULTA;
	}
    else if(arg0.getSource()==btnEliminar){
		
		//Valido si es mayor o igual que cero para mostrar el mensaje apropiado
		int indice = table.getSelectedRow();
		
		if(indice>=0){
		
		int respuesta = JOptionPane.showConfirmDialog(this, "¿Desea borrar el registro "+(indice+1)+"?",
				"¿Lo tumbo?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		
		if (respuesta==JOptionPane.YES_OPTION){
			
			ca.eliminar(indice);
			
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
		
		case DCancion.INGRESO:
			okIngreso();
			break;
		case DCancion.CONSULTA:
			okConsulta();
			break;
		default:
			okModifcacion();
			
		}
	}
	catch (Exception e){
		JOptionPane.showMessageDialog(this, "Ha introducido un dato no válido", "Cuidado, mucho cuidado", 
				JOptionPane.ERROR_MESSAGE);
	}
}
		
	}		
	

private void ingresarRegistro() {
	
	ca.agregar(new Cancion( ca.codigoCorrelativo(),
							textNombre.getText(),
							textDuracion.getText(),
						    cboNombreArtista.getSelectedIndex(),
							textAlbum.getText(),
							Integer.parseInt(textNumeroReproducciones.getText()),
					        cboEstado.getSelectedIndex()));
	
};

private void reemplazarRegistro(int indice) {
	
	if (indice>=0){
	
	ca.reemplazar(new  Cancion(	ca.obtener(indice).getidCancion(),
							    textNombre.getText(),
								textDuracion.getText(),
								cboNombreArtista.getSelectedIndex(),
								textAlbum.getText(),
								Integer.parseInt(textNumeroReproducciones.getText()),
							    cboEstado.getSelectedIndex()),indice);
	}
}

private int consultarRegistro() {

	//Consulta según todos los campos. Si coincide un valor devuelve el primer registro		
	if (!(textCodigo.getText().equals(""))){
		
		//Si contiene el prefijo intento convertirlo a un número
		if(textCodigo.getText().contains(Cancion.PRE)){
			
			try{
				
				int codigoCancion = Integer.parseInt(textCodigo.getText().replace(Cancion.PRE, ""));
				
				for	(int i=0;i<ca.tamaño();i++){
					
					if(ca.obtener(i).getidCancion()==codigoCancion){
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
		
		for	(int i=0;i<ca.tamaño();i++){
			
			if(ca.obtener(i).getnombre().contains(valor)){
				return i;
			}
			
		}
		
	}
	
	if (!(textDuracion.getText().equals(""))){
		
		String valor = textDuracion.getText();
		
		for	(int i=0;i<ca.tamaño();i++){
			
		if(ca.obtener(i).getduracion().contains(valor)){
				return i;
			}
			
		}
		
	}

if (!(textAlbum.getText().equals(""))){
	
	String valor = textAlbum.getText();
	
	for	(int i=0;i<ca.tamaño();i++){
		
		if(ca.obtener(i).getalbum().contains(valor)){
			return i;
		}
		
	}
	
}
if (!(textNumeroReproducciones.getText().equals(""))){
	
	int  valor =Integer.parseInt(textNumeroReproducciones.getText());
	
	for	(int i=0;i<ca.tamaño();i++){
		
		if(ca.obtener(i).getnumeroReproducciones()==valor){
			return i;
		}
		
	}
	
}

	else{
		

		
		int estado=cboEstado.getSelectedIndex();
		
		for	(int i=0;i<ca.tamaño();i++){
			
			if(ca.obtener(i).getestado()==estado ){
				return i;
			}
		
		}
				
	}
	return -1;
}

	

private void okModifcacion() {
	
	if(		textNombre.getText().equals("") ||
			textDuracion.getText().equals("") ||
			textAlbum.getText().equals("") ||
			textNumeroReproducciones.getText().equals("")){
			
		
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
			textDuracion.getText().equals("") ||
			textAlbum.getText().equals("") ||
			textNumeroReproducciones.getText().equals("")){
		
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
	
			if(ca.tamaño()==table.getRowCount()){
			
			textCodigo.setEditable(false);
			
			btnOk.setEnabled(true);
			
			llenartxt(table.getSelectedRow());
		
			operacionActual = DCancion.MODIFICACION;
			
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