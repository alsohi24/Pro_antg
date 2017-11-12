package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import arreglo.ArregloBebida;
import arreglo.ArregloCancion;
import arreglo.ArregloCliente;
import arreglo.ArregloConsumo;
import arreglo.ArregloPedido;
import arreglo.ArregloPiqueo;
import clases.Bebida;
import clases.Cliente;
import clases.Consumo;
import clases.Pedido;
import clases.Piqueo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;

public class DRegistroConsumo extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField txtFecha;
	private JTextField txtTotal;
	private JTextField txtCodigo;
	private JComboBox<String> cboIdCliente;
	private JButton btnRegistrar;
	private JButton btnCancelar;
	private JTextArea textArea;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yy hh:mm");
	private String fecha = dateFormat.format(new Date());
	private ArregloConsumo ac = new ArregloConsumo();
	private ArregloCliente acl = new ArregloCliente();
	private ArregloPedido ap = new ArregloPedido();
	private ArregloCancion aca = new ArregloCancion();
	private ArregloPiqueo api = new ArregloPiqueo();
	private ArregloBebida ab = new ArregloBebida();
	
	ArrayList<Integer> idPedidosActuales;
	private String[] nombresIdClientes = new String[acl.tamaño()]; 
	private int idClienteActual=0;
	private double totalActual=0;
	private boolean estado=true;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DRegistroConsumo dialog = new DRegistroConsumo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DRegistroConsumo() {
		setTitle("Registro | Consumo");
		setBounds(100, 100, 612, 206);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		llenarComboIdCliente();
		
		{
			JLabel lblCodigo = new JLabel("Codigo ");
			lblCodigo.setBounds(10, 17, 126, 14);
			contentPanel.add(lblCodigo);
		}
		{
			JLabel lblCodigoCliente = new JLabel("Codigo Cliente");
			lblCodigoCliente.setBounds(10, 42, 126, 14);
			contentPanel.add(lblCodigoCliente);
		}
				
		{
			JLabel lblFecha = new JLabel("Fecha ");
			lblFecha.setBounds(10, 67, 126, 14);
			contentPanel.add(lblFecha);
		}
		
		{
			JLabel lblTotal = new JLabel("Total");
			lblTotal.setBounds(10, 93, 126, 14);
			contentPanel.add(lblTotal);
		}
		
			txtCodigo = new JTextField();
			txtCodigo.setEditable(false);
			txtCodigo.setBounds(146, 14, 121, 20);
			txtCodigo.setText(Consumo.PRE+ac.codigoCorrelativo());
			contentPanel.add(txtCodigo);
			txtCodigo.setColumns(10);
			
			cboIdCliente = new JComboBox<String>();
			cboIdCliente.setBounds(146, 39, 121, 20);
			cboIdCliente.setModel(new DefaultComboBoxModel<String>(nombresIdClientes));
			cboIdCliente.addActionListener(this);
			contentPanel.add(cboIdCliente);
			
			txtFecha = new JTextField();
			txtFecha.setEditable(false);
			txtFecha.setBounds(146, 64, 121, 20);
			txtFecha.setText(fecha);
			contentPanel.add(txtFecha);
			txtFecha.setColumns(10);
		
			txtTotal = new JTextField();
			txtTotal.setEditable(false);
			txtTotal.setBounds(146, 90, 121, 20);
			txtTotal.setText("0");
			contentPanel.add(txtTotal);
			txtTotal.setColumns(10);
		
			btnRegistrar = new JButton("Registrar Consumo");
			btnRegistrar.setBounds(140, 133, 158, 23);
			btnRegistrar.addActionListener(this);
			contentPanel.add(btnRegistrar);
				
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setBounds(308, 133, 158, 23);
			btnCancelar.addActionListener(this);
			contentPanel.add(btnCancelar);
				
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(279, 11, 307, 100);
			contentPanel.add(scrollPane);
			
			textArea = new JTextArea();
			textArea.setEditable(false);
			scrollPane.setViewportView(textArea);
			
			setResizable(false);
			
			mostrarPedidos();
	}

	private void llenarComboIdCliente() {
			
		for(int i=0;i<acl.tamaño();i++){
			
			nombresIdClientes[i] = Cliente.PRE+acl.obtener(i).getIdCliente();
			
		}
		
	}
	
	private void escribir(String mensaje){
		
		textArea.append(mensaje+"\n");
		
	}
	
	private void limpiar(){
		
		textArea.setText("");
		
	}
	
	private void mostrarPedidos(){
		
		estado=true;
		
		limpiar();
		
		double precioActual = 0;
		
		idPedidosActuales = new ArrayList<Integer>();
		
		idClienteActual = cboIdCliente.getSelectedIndex();

		//Simplemente obtengo los indices de clientes que tienen asociado un pedido 
			for (int i=0;i<ap.tamaño();i++){
				
				if (ap.obtener(i).getIdCliente()==idClienteActual){
					
					idPedidosActuales.add(i);

				}
				
			}

		//Verifico que haya pedidos asociados. Si no, retorna
			if(idPedidosActuales.size()>0){
			
			escribir(	"Pedidos pendientes de "+acl.obtener(idClienteActual).getNombres()+" "+
						acl.obtener(idClienteActual).getApellidoPaterno()+" "+
						acl.obtener(idClienteActual).getApellidoMaterno()+" :");
			
			int contadorPedidos = 0;
		//Recorro todos los pedidos no atendidos asociados a un cliente
			for(int i=0;i<idPedidosActuales.size();i++){
					
				//Verifico los pedidos que no hayan sido atendidos (RESERVADO)
					if (ap.obtener(idPedidosActuales.get(i)).getEstado()==Pedido.RES){
					
							escribir("");
							escribir(	"Código de pedido : "+Pedido.PRE+ap.obtener(idPedidosActuales.get(i)).getIdPedido());
							
							ArrayList<Integer> canciones = ap.obtener(idPedidosActuales.get(i)).getCanciones();
							ArrayList<Integer> bebidas = ap.obtener(idPedidosActuales.get(i)).getBebidas();
							ArrayList<Integer> piqueos = ap.obtener(idPedidosActuales.get(i)).getPiqueos();
																						
							escribir("");
							escribir("Bebidas :");
							
							//Obtengo los precios de las bebidas
								if (bebidas.size()>0){
								
								for(int a=0;a<bebidas.size();a++){
									
									escribir(	Bebida.obtenerTipoBebida(ab.obtener(bebidas.get(a)).getTipoBebida()) + " " +
												Bebida.obtenerMarcaBebida(ab.obtener(bebidas.get(a)).getMarca()) + ". Precio: S/." +
												ab.obtener(bebidas.get(a)).getPrecio());
									
									//Acumulo el precio
									precioActual+=ab.obtener(bebidas.get(a)).getPrecio();
									
								}
								
								escribir("");
								escribir("Piqueos :");
								} else {
									
									escribir ("No hay pedidos pendientes de bebidas.");
									
								}
							
							//Obtengo los precios de los piqueos
								if (piqueos.size()>0){
							
								for(int a=0;a<piqueos.size();a++){
										
									escribir(	Piqueo.obtenerTipoPiqueos(api.obtener(piqueos.get(a)).getTipoPiqueo()) + " " +
												api.obtener(piqueos.get(a)).getNombre()+". Precio: S/." +
												api.obtener(piqueos.get(a)).getPrecio());
									
									//Acumulo el precio
									precioActual+=api.obtener(piqueos.get(a)).getPrecio();
									
								}
								
								escribir("");
								escribir("Canciones :");
								} else {
									
									escribir ("No hay pedidos pendientes de piqueos.");
									
								}
														
							//Obtengo los detalles de las canciones
								if(canciones.size()>0){
								
								for(int a=0; a<canciones.size(); a++){
										
									escribir(	aca.obtener(canciones.get(a)).getnombre()+". Duración: "+
												aca.obtener(canciones.get(a)).getduracion());
								
									//No tiene precio
									
								}
								} else {
									
									escribir ("No hay pedidos pendientes de canciones.");
									
								}
						} else {
							
							contadorPedidos++;
							
						}
			}
			
			//Verifico si los pedidos han sido atendidos. Uso contadorPedidos
			if (contadorPedidos==idPedidosActuales.size()){
				
				estado=false;
				escribir("Las reservas para este cliente ya han sido atendidas.");
				
			} else {
			
			totalActual=precioActual;
			escribir("");
			escribir("Total : S/." +precioActual);
			txtTotal.setText(""+precioActual);
			textArea.setCaretPosition(0);
			
			}
			
		} else {
			
			estado=false;
			escribir(	"No hay registros asociados a "+
						acl.obtener(idClienteActual).getNombres()+" "+
						acl.obtener(idClienteActual).getApellidoPaterno()+" "+
						acl.obtener(idClienteActual).getApellidoMaterno());
			
			txtTotal.setText("0");
			
		}
	
		
	}
	
	private void establecerPedidosAtendidos(){
		
		if(idPedidosActuales.size()>0){
			
			//Recorro todos los pedidos no atendidos asociados a un cliente
				for(int i=0;i<idPedidosActuales.size();i++){
					
					int idPedidoActual = idPedidosActuales.get(i);
					
				//Verifico los pedidos que no hayan sido atendidos (RESERVADO)
					if (ap.obtener(idPedidoActual).getEstado()==Pedido.RES){

						//Les asigno el estado atendidos (ATENDIDO). Debo reemplazarlo en el ArregloPedido
							Pedido pedido = ap.obtener(idPedidoActual);
							pedido.setEstado(Pedido.RAT);
						
							ap.reemplazar(pedido, idPedidoActual);
					
					}
				}
												
			}
			
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if	(arg0.getSource()==cboIdCliente){
			
			mostrarPedidos();
			
		}
		
		else if (arg0.getSource()==btnRegistrar){
			
			establecerPedidosAtendidos();
			
			if(estado){
				
			ac.agregar(new Consumo(ac.codigoCorrelativo(), idClienteActual, fecha, totalActual, Consumo.PEN));
			
			this.dispose();
			
			} else {
				
				JOptionPane.showMessageDialog(this, "No hay pedidos asociado a este cliente o ya han sido atendidos", "¿Qué es esto?", JOptionPane.ERROR_MESSAGE);
				
			}
			
		}
		
		else {
			
			int respuesta = JOptionPane.showConfirmDialog(this, "¿Salir?", "Qué horror", JOptionPane.YES_NO_OPTION);
						
			if (respuesta == JOptionPane.YES_OPTION){
						
				this.dispose();
			
		}
	}
 }
}
