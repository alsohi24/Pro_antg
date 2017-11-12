package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import javax.swing.table.DefaultTableModel;

import arreglo.ArregloCliente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public abstract class DConsulta extends JDialog implements ActionListener{
	
	private JPanel panel;
	private JButton btnBuscar = new JButton("Buscar");
	private JButton btnSeleccionar = new JButton("Seleccionar");
	private JButton btnListar = new JButton("Listar");
	private JButton btnCancelar = new JButton("Cancelar");
	private DefaultTableModel modelo = new DefaultTableModel();
	private DefaultComboBoxModel<String> cboModelo = new DefaultComboBoxModel<String>();
	
	protected JComboBox<String> comboBox = new JComboBox<String>(); 
	protected  JTextField textField;
	protected JTable table;

	protected int indiceSeleccionado;
	protected Object objectoArreglo;
	
	public DConsulta(Object objectoArreglo) {
		
		this.objectoArreglo = objectoArreglo;
		castArreglo();
		
		setUndecorated(true);
		//setBackground(new Color(0,0,0,0));
		setModal(true);
		setLocationRelativeTo(null);
		setBounds(100, 100, 651, 368);
		setMinimumSize(getSize());
				
		panel = (JPanel) getContentPane();
		panel.setLayout(null);
		panel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		
		textField = new JTextField();
		textField.setBounds(305, 10, 233, 22);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		btnBuscar.setBounds(548, 9, 77, 25);
		btnBuscar.addActionListener(this);
		getContentPane().add(btnBuscar);
		
		JLabel lblSegn = new JLabel("Seg\u00FAn");
		lblSegn.setBounds(10, 13, 69, 16);
		getContentPane().add(lblSegn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 70, 615, 209);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setModel(modelo);
		scrollPane.setViewportView(table);
				
		comboBox.setModel(cboModelo);
		comboBox.setBounds(93, 10, 166, 22);
		getContentPane().add(comboBox);
		
		btnSeleccionar.addActionListener(this);
		btnSeleccionar.setBounds(155, 290, 104, 23);
		getContentPane().add(btnSeleccionar);
		
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(379, 290, 104, 23);
		getContentPane().add(btnCancelar);
		
		JLabel lblSeleccioneUnRegistro = new JLabel("Seleccione un registro para continuar");
		lblSeleccioneUnRegistro.setBounds(10, 45, 473, 22);
		getContentPane().add(lblSeleccioneUnRegistro);
		
		btnListar.setBounds(265, 290, 104, 23);
		getContentPane().add(btnListar);
		
		setResizable(false);
		
		llenarModelos();
		
		llenarTabla();
		
	}
	
	private void llenarModelos(){
		
		String[] datosCombo = datosCombo();
		String[] datosColumnas = datosColumnas();
		
		//Lleno datos del comboBox
		for(String dato : datosCombo){
			
			cboModelo.addElement(dato);
			
		}
		
		//Lleno datos de las columnas de la tabla
		for(String dato : datosColumnas){
			
			modelo.addColumn(dato);
			
		}
		
	}

	private void llenarTabla(){
		
		modelo.setRowCount(0);
		
		llenarDatosTabla();
				
		}		
		
	protected void agregarRegistro(Object[] datos){
		
		modelo.addRow(datos);
		
	}
	
	protected void llenarRegistro(int indice){
		
		modelo.setRowCount(0);
		llenarDatoRegistro(indice);
		
	}
	
	
	protected abstract void castArreglo();

	protected abstract String[] datosCombo();
	
	protected abstract String[] datosColumnas();
	
	protected abstract void llenarDatosTabla();
	
	protected abstract void llenarDatoRegistro(int resultado);
	
	protected abstract int buscar(int caso);
	
	protected abstract void setIndiceSeleccionado(int indiceSeleccionado);

	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
		if(arg0.getSource()==btnBuscar){
			
			int caso = comboBox.getSelectedIndex();
			
			int resultado = buscar(caso);
			
			if (resultado!=-1){
				
				llenarRegistro(resultado);
				
			}
			
		}
		
		else if(arg0.getSource()==btnSeleccionar){
			
			int indice = table.getSelectedRow();
			
			if (indice !=-1){
				
				indiceSeleccionado = indice;
				
				setIndiceSeleccionado(indiceSeleccionado);
				
				this.dispose();
				
			} else {
				
				int respuesta = JOptionPane.showConfirmDialog(this, "No ha seleccionado registros ¿Salir?", "Qué mello!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				
				if(respuesta==JOptionPane.YES_OPTION){
									
					this.dispose();
					
				}
				
			}
						
		}
		
		else if(arg0.getSource()==btnListar){
			
			llenarTabla();
			
		}
			
		
		else{
			
			this.dispose();
			
		}
	}
}
