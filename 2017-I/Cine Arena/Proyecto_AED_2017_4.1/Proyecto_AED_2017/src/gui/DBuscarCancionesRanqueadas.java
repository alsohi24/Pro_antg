package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import arreglo.ArregloArtista;
import arreglo.ArregloBebida;
import arreglo.ArregloCancion;
import clases.Bebida;
import clases.Cancion;

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

public class DBuscarCancionesRanqueadas extends JDialog implements ActionListener {
	
	private static final int CIN=0;
	private static final int CUA=1;
	private static final int TRE=2;
	private static final int VEI=3;
	private static final int DIE=4;
	
	private JButton          btnSalir;
	private JComboBox<String>      cboRanqueadas;
	private JTable table;
	private DefaultTableModel modelo = new DefaultTableModel();
	private ArregloCancion ca = new ArregloCancion();
	private ArregloArtista aa = new ArregloArtista();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DBuscarCancionesRanqueadas dialog = new DBuscarCancionesRanqueadas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DBuscarCancionesRanqueadas(){
		
		if (aa.tamaño()!=0){
		
		setTitle("Reporte | Canciones más ranqueadas");
		setBounds(100, 100, 439, 303);
		getContentPane().setLayout(null);
		
		JLabel lblCancionesRan = new JLabel("Top de las Canciones. Num. Reproducciones: ");
		lblCancionesRan.setBounds(10, 11, 271, 14);
		getContentPane().add(lblCancionesRan);
		
		cboRanqueadas = new JComboBox<String>();
		cboRanqueadas.setModel(new DefaultComboBoxModel<String>(new String[] {obtenerIndiceReproducciones(0),
				obtenerIndiceReproducciones(1),obtenerIndiceReproducciones(2), obtenerIndiceReproducciones(3),
				obtenerIndiceReproducciones(4)}));
		cboRanqueadas.setBounds(316, 8, 108, 20);
		cboRanqueadas.addActionListener(this);
		cboRanqueadas.setSelectedIndex(0);
		getContentPane().add(cboRanqueadas);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 34, 414, 179);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setModel(modelo);
		scrollPane.setViewportView(table);
		
		modelo.addColumn("CODIGO");
		modelo.addColumn("NOMBRE");
		modelo.addColumn("DURACION");
		modelo.addColumn("ARTISTA");
		modelo.addColumn("ALBUM");
		modelo.addColumn("REPRODUCCIONES");
		modelo.addColumn("ESTADO");
				
	    btnSalir = new JButton("Salir");
		btnSalir.setBounds(177, 227, 89, 23);
		btnSalir.addActionListener(this);
		getContentPane().add(btnSalir);
	
		modelo.setRowCount(0);

		llenarTablaConLimite(50);
		
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
	 
	 private void llenarTablaConLimite (int limite){
	    	
		   for(int i=0 ; i<ca.tamaño(); i++){
			   			   
			   Object[]  datos ={ Cancion.PRE+ca.obtener(i).getidCancion(),
					             ca.obtener(i).getnombre(),
					             ca.obtener(i).getduracion(),
					             aa.obtener(ca.obtener(i).getidArtista()).getNombreArtistico(),
					             ca.obtener(i).getalbum(),
					             ca.obtener(i).getnumeroReproducciones(),
					             Cancion.obtenerEstado(ca.obtener(i).getestado()),
				                 };
			   
			   //Solo se mostrarán los que tengan el limite
			   if(ca.obtener(i).getnumeroReproducciones()>=limite){
				   System.out.println(ca.obtener(i).getnumeroReproducciones());
			   modelo.addRow(datos);
			   }
		  }
		    }
	 
	 private String obtenerIndiceReproducciones(int caso){
		 
		 switch(caso){
		 
		 case CIN:
			 return "50";
			 
		 case CUA:
			 return "40";
		
		 case TRE:
		 	return "30";
		 	
		 case VEI:
			 return "20";
			 
		default:
			return "10";
		 
		 }
		 
	 }
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(arg0.getSource()==cboRanqueadas){
			
			int indiceAcual = cboRanqueadas.getSelectedIndex();
			
			int limiteActual = Integer.parseInt(obtenerIndiceReproducciones(indiceAcual));
			
			modelo.setRowCount(0);
			
			llenarTablaConLimite(limiteActual);
			
		} 
		
		else {
			
			this.dispose();
			
		}
		
	}

	
	
	
	
}
