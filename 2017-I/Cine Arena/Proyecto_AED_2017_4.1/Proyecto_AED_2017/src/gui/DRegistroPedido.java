package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import arreglo.ArregloArtista;
import arreglo.ArregloBebida;
import arreglo.ArregloCancion;
import arreglo.ArregloCliente;
import arreglo.ArregloPedido;
import arreglo.ArregloPiqueo;
import clases.Cliente;
import clases.Pedido;
import clases.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class DRegistroPedido extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodigoPedido;
	private JTextField textFecha;
	private JTextField txtCodigoUsuario;
	private JButton btnBsquedaAvanzada;
	private JButton btnAgregarBebida;
	private JButton btnAgregarPiqueo;
	private JButton btnAgregarCancion;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yy hh:mm");
	private String fecha = dateFormat.format(new Date());
	private ArregloCliente acl = new ArregloCliente();
	private ArregloBebida ab = new ArregloBebida();
	private ArregloPiqueo api = new ArregloPiqueo();
	private ArregloCancion aca = new ArregloCancion();
	private ArregloArtista aa = new ArregloArtista();
	private ArregloPedido ap = new ArregloPedido();
	
	private String[] nombresIdClientes;
	private ArrayList<JButton> botonesBebidas = new ArrayList<JButton>();
	private ArrayList<JPanel> panelesBebidas = new ArrayList<JPanel>();
		
	private ArrayList<JButton> botonesPiqueos = new ArrayList<JButton>();
	private ArrayList<JPanel> panelesPiqueos = new ArrayList<JPanel>();
	
	private ArrayList<JButton> botonesCanciones = new ArrayList<JButton>();
	private ArrayList<JPanel> panelesCanciones = new ArrayList<JPanel>();
	
	//Modificables
	JComboBox<String> cboCliente;
	JLabel lblDatosCliente;
	JPanel panelBebidas;
	JPanel panelPiqueos;
	JPanel panelCanciones;
		
	//Seleccionados
	private int usuarioActual;
	int clienteActual;
	ArrayList<Integer> bebidasSeleccionadas = new ArrayList<Integer>();
	ArrayList<Integer> piqueosSeleccionados = new ArrayList<Integer>();
	ArrayList<Integer> cancionesSeleccionadas = new ArrayList<Integer>();
	
	
	int codigoCorrelativo=ap.codigoCorrelativo();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DRegistroPedido dialog = new DRegistroPedido(1001);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DRegistroPedido(int usuarioActual) {
			
			//Valido que existan bebidas, piqueos y canciones
			if (ab.tamaño()!=0 && api.tamaño()!=0 && aca.tamaño()!=0){
		
			this.usuarioActual=usuarioActual;
		
			setTitle("Registro | Pedido");
			setBounds(100, 100, 728, 345);
			getContentPane().setLayout(new BorderLayout());
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(contentPanel, BorderLayout.CENTER);
			contentPanel.setLayout(null);
		
			llenarComboIdClientes();
			
			JLabel lblCodigoPedido = new JLabel("Codigo pedido");
			lblCodigoPedido.setBounds(10, 23, 89, 14);
			contentPanel.add(lblCodigoPedido);
		
			JLabel label = new JLabel("Fecha");
			label.setBounds(481, 23, 55, 14);
			contentPanel.add(label);
			
			txtCodigoPedido = new JTextField();
			txtCodigoPedido.setEditable(false);
			txtCodigoPedido.setBounds(109, 20, 100, 20);
			txtCodigoPedido.setColumns(10);
			txtCodigoPedido.setText(Pedido.PRE+codigoCorrelativo);
			contentPanel.add(txtCodigoPedido);
			
			txtCodigoUsuario = new JTextField();
			txtCodigoUsuario.setEditable(false);
			txtCodigoUsuario.setColumns(10);
			txtCodigoUsuario.setBounds(341, 20, 100, 20);
			txtCodigoUsuario.setText(Usuario.PRE+usuarioActual);
			contentPanel.add(txtCodigoUsuario);
		
			textFecha = new JTextField();
			textFecha.setEditable(false);
			textFecha.setBounds(546, 20, 103, 20);
			textFecha.setText(fecha);
			contentPanel.add(textFecha);
			textFecha.setColumns(10);
		
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setBounds(293, 272, 118, 23);
			btnCancelar.addActionListener(this);
			contentPanel.add(btnCancelar);
		
			btnAceptar = new JButton("Aceptar");
			btnAceptar.setBounds(183, 272, 100, 23);
			btnAceptar.addActionListener(this);
			contentPanel.add(btnAceptar);
				
			JPanel panelCliente = new JPanel();
			panelCliente.setBounds(10, 64, 693, 96);
			panelCliente.setBorder(BorderFactory.createTitledBorder("Cliente"));
			contentPanel.add(panelCliente);
			panelCliente.setLayout(null);
			
			cboCliente = new JComboBox<String>();
			cboCliente.setModel(new DefaultComboBoxModel<String>(nombresIdClientes));
			cboCliente.setBounds(95, 29, 140, 20);
			cboCliente.addActionListener(this);
			panelCliente.add(cboCliente);
						
			btnBsquedaAvanzada = new JButton("B\u00FAsqueda avanzada");
			btnBsquedaAvanzada.setBounds(343, 28, 159, 23);
			btnBsquedaAvanzada.addActionListener(this);
			panelCliente.add(btnBsquedaAvanzada);
			
			lblDatosCliente = new JLabel();
			lblDatosCliente.setBounds(95, 62, 588, 23);
			lblDatosCliente.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
			panelCliente.add(lblDatosCliente);
			
			JScrollPane scrollPaneBebidas = new JScrollPane();
			scrollPaneBebidas.setBounds(10, 165, 222, 96);
			scrollPaneBebidas.setBorder(BorderFactory.createTitledBorder("Bebidas"));
			contentPanel.add(scrollPaneBebidas);
			
			panelBebidas = new JPanel();
			panelBebidas.setLayout(new BoxLayout(panelBebidas, BoxLayout.Y_AXIS));
			scrollPaneBebidas.setViewportView(panelBebidas);
			
			JPanel panelBtnAgregarBebidas = new JPanel();
			panelBtnAgregarBebidas.setLayout(new FlowLayout());
			//panelBtnAgregarBebidas.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
			panelBebidas.add(panelBtnAgregarBebidas);
			
			btnAgregarBebida = new JButton("Agregar Bebida");
			btnAgregarBebida.addActionListener(this);
			panelBtnAgregarBebidas.add(btnAgregarBebida);
							
			JScrollPane scrollPanePiqueos = new JScrollPane();
			scrollPanePiqueos.setBounds(242, 165, 222, 96);
			scrollPanePiqueos.setBorder(BorderFactory.createTitledBorder("Piqueos"));
			contentPanel.add(scrollPanePiqueos);
			
			panelPiqueos = new JPanel();
			panelPiqueos.setLayout(new BoxLayout(panelPiqueos, BoxLayout.Y_AXIS));
			scrollPanePiqueos.setViewportView(panelPiqueos);
			
			JPanel panelBtnAgregarPiqueos = new JPanel();
			panelBtnAgregarPiqueos.setLayout(new FlowLayout());
			//panelBtnAgregarPiqueos.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
			panelPiqueos.add(panelBtnAgregarPiqueos);
						
			btnAgregarPiqueo = new JButton("Agregar Piqueos ");
			btnAgregarPiqueo.addActionListener(this);
			panelBtnAgregarPiqueos.add(btnAgregarPiqueo);
			
			JScrollPane scrollPaneCanciones = new JScrollPane();
			scrollPaneCanciones.setBorder(BorderFactory.createTitledBorder("Canciones"));
			scrollPaneCanciones.setBounds(481, 165, 222, 96);
			contentPanel.add(scrollPaneCanciones);
			
			panelCanciones = new JPanel();
			panelCanciones.setLayout(new BoxLayout(panelCanciones, BoxLayout.Y_AXIS));
			scrollPaneCanciones.setViewportView(panelCanciones);
			
			JPanel panelBtnAgregarCanciones = new JPanel();
			panelBtnAgregarCanciones.setLayout(new FlowLayout());
			panelCanciones.add(panelBtnAgregarCanciones);
			
			btnAgregarCancion = new JButton("Agregar Canciones");
			btnAgregarCancion.addActionListener(this);
			panelBtnAgregarCanciones.add(btnAgregarCancion);
		
			JLabel lblCodigoUsuario = new JLabel("Codigo usuario");
			lblCodigoUsuario.setBounds(242, 23, 89, 14);
			contentPanel.add(lblCodigoUsuario);
								
			mostrarNombresCliente(cboCliente.getSelectedIndex());
			
			setResizable(false);
			setLocationRelativeTo(this);
			setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			setModal(true);
			setVisible(true);			
			
			} else {
				
				this.dispose();

				JOptionPane.showMessageDialog(this, "Necesita tener como mínimo una bebida, un piqueo y una canción", "Cuidado, mucho cuidado",
						JOptionPane.ERROR_MESSAGE);
				
			}
			
	}

	private void llenarComboIdClientes() {
		
		nombresIdClientes = new String[acl.tamaño()];
		
		for(int i=0;i<acl.tamaño();i++){
			
			nombresIdClientes[i] = Cliente.PRE+acl.obtener(i).getIdCliente();
			
		}
						
	}
	
	void mostrarNombresCliente(int selectedIndex) {
		
		String datos = 	acl.obtener(selectedIndex).getNombres()+" "+
						acl.obtener(selectedIndex).getApellidoPaterno()+" "+
						acl.obtener(selectedIndex).getApellidoMaterno();
		
		lblDatosCliente.setText(datos);
		
	}
	
	void agregarBebidas(String datosBebida){
		
		//Agrego el panel con el botón eliminar
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.add(new JLabel(datosBebida));
		panel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		panelesBebidas.add(panel);
		
		//Agrego el boton al ArrayList
		JButton boton = new JButton();
		boton.setIcon(new ImageIcon(DRegistroPedido.class.getResource("/imagenes/eliminar.png")));
		boton.addActionListener(this);
		botonesBebidas.add(boton);
		
		panel.add(boton);
				
		panelBebidas.add(panel);
		validate();

	}
	
	void agregarPiqueos(String datosPiqueo){
		
		//Agrego el panel con el botón eliminar
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.add(new JLabel(datosPiqueo));
		panel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		panelesPiqueos.add(panel);
		
		//Agrego el boton al ArrayList
		JButton boton = new JButton();
		boton.setIcon(new ImageIcon(DRegistroPedido.class.getResource("/imagenes/eliminar.png")));
		boton.addActionListener(this);
		botonesPiqueos.add(boton);
		
		panel.add(boton);
		
		panelPiqueos.add(panel);
		validate();

	}
	
	void agregarCanciones(String datosCancion){
		
		//Agrego el panel con el botón eliminar
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.add(new JLabel(datosCancion));
		panel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		panelesCanciones.add(panel);
		
		//Agrego el boton al ArrayList
		JButton boton = new JButton();
		boton.setIcon(new ImageIcon(DRegistroPedido.class.getResource("/imagenes/eliminar.png")));
		boton.addActionListener(this);
		botonesCanciones.add(boton);
		
		panel.add(boton);
		
		panelCanciones.add(panel);
		validate();

	}	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if (arg0.getSource()==cboCliente){
			
			//Método para mostrar los datos del cliente en un JLabel
			clienteActual = cboCliente.getSelectedIndex();
					
			mostrarNombresCliente(clienteActual);
			
		}
				
		else if (arg0.getSource()==btnBsquedaAvanzada){
			
			DConsultaCliente dialog = new DConsultaCliente(acl, this);
			dialog.setLocationRelativeTo(this);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setModal(true);
			dialog.setVisible(true);
						
		}
		
		else if(arg0.getSource()==btnAgregarBebida){
			DConsultaBebida dialog = new DConsultaBebida(ab, this);
			dialog.setLocationRelativeTo(this);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setModal(true);
			dialog.setVisible(true);
		}
		
		else if(arg0.getSource()==btnAgregarPiqueo){
			DConsultaPiqueo dialog = new DConsultaPiqueo(api, this);
			dialog.setLocationRelativeTo(this);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setModal(true);
			dialog.setVisible(true);
		}
		
		else if(arg0.getSource()==btnAgregarCancion){
			
			DConsultaCancion dialog = new DConsultaCancion(aca, aa, this);
			dialog.setLocationRelativeTo(this);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setModal(true);
			dialog.setVisible(true);			
		}
		
		//Control de eliminación
		else if(botonesBebidas.contains(arg0.getSource())){
			
			int indice = botonesBebidas.indexOf(arg0.getSource());
			
			int respuesta = JOptionPane.showConfirmDialog(this, "¿Quieres borrar la bebida "+(indice+1)+"?", "¿En serio?", JOptionPane.YES_NO_OPTION);
			
			if (respuesta == JOptionPane.YES_OPTION){
			bebidasSeleccionadas.remove(indice);
			
			panelesBebidas.remove(indice);
			
			botonesBebidas.remove(indice);
			
			panelBebidas.remove(indice+1);
			
			validate();
			}
		}
		
		else if(botonesPiqueos.contains(arg0.getSource())){
			
			int indice = botonesPiqueos.indexOf(arg0.getSource());
			
			int respuesta = JOptionPane.showConfirmDialog(this, "¿Quieres borrar el piqueo "+(indice+1)+"?", "¿En serio?", JOptionPane.YES_NO_OPTION);
			
			if (respuesta == JOptionPane.YES_OPTION){
			piqueosSeleccionados.remove(indice);
			
			panelesPiqueos.remove(indice);
			
			botonesPiqueos.remove(indice);
			
			panelPiqueos.remove(indice+1);
			
			validate();
			}
		}
		
		else if(botonesCanciones.contains(arg0.getSource())){
			
			int indice = botonesCanciones.indexOf(arg0.getSource());
			
			int respuesta = JOptionPane.showConfirmDialog(this, "¿Quieres borrar la canción "+(indice+1)+"?", "¿En serio?", JOptionPane.YES_NO_OPTION);
			
			if (respuesta == JOptionPane.YES_OPTION){
			cancionesSeleccionadas.remove(indice);
			
			panelesCanciones.remove(indice);
			
			botonesCanciones.remove(indice);
			
			panelCanciones.remove(indice+1);
			
			validate();
			}
		}
		
		else if(arg0.getSource()==btnAceptar){
			
			ap.agregar(new Pedido(codigoCorrelativo, fecha, usuarioActual, clienteActual, cancionesSeleccionadas, bebidasSeleccionadas, piqueosSeleccionados, Pedido.RES));
			
			this.dispose();
			
			}
		
		else {
			
			int respuesta = JOptionPane.showConfirmDialog(this, "¿Salir?", "Qué horror", JOptionPane.YES_NO_OPTION);
			
			if (respuesta == JOptionPane.YES_OPTION){
			
			this.dispose();
			
			}
					
	}
}
}