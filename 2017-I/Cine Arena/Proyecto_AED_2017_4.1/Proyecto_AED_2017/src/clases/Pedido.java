package clases;

import java.util.ArrayList;

public class Pedido {
	
	public static final int BIC = 0;
	public static final int MER = 1;
	public static final int AYM = 2;
	public static final int AFA = 3;
	public static final int DES = 4;
	
    public static final int RES=0;
    public static final int RAT=1;
      
	public static final String PRE = "PED";
	public static final int COD_PRE = 1001;
	

	private int idPedido;
	private String fechaPedido;
	private int  idUsuario;
	private int idCliente;
	private ArrayList<Integer>  canciones;
	private ArrayList<Integer>  bebidas;
	private ArrayList<Integer> piqueos;
	private int estado;
	
	
	public Pedido(int idPedido, String fechaPedido, int idUsuario, int idCliente, ArrayList<Integer> canciones, ArrayList<Integer> bebidas, ArrayList<Integer> piqueos,
			int estado) {
	
		this.idPedido = idPedido;
		this.fechaPedido = fechaPedido;
		this.idUsuario = idUsuario;
		this.idCliente = idCliente;
		this.canciones= canciones;
		this.bebidas=bebidas;
		this.piqueos=piqueos;
		this.estado = estado;
	}
	
	//   SET/ GET	
	
	public int getIdPedido() {
		return idPedido;
	}	
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	
	
	public String getFechaPedido() {
		return fechaPedido;
	}
    public void setFechaPedido(String fechaPedido) {
		this.fechaPedido = fechaPedido;
		
		
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	public ArrayList<Integer> getCanciones() {
		return canciones;
	}
	public void setCanciones(ArrayList<Integer> canciones) {
		this.canciones = canciones;
	}

	
	public ArrayList<Integer> getBebidas() {
		return bebidas;
	}
    public void setBebidas(ArrayList<Integer> bebidas) {
		this.bebidas = bebidas;
	}

    
	public ArrayList<Integer> getPiqueos() {
		return piqueos;
	}
    public void setPiqueos(ArrayList<Integer> piqueos) {
		this.piqueos = piqueos;
	}

    public int getEstado() {
		return estado;
	}
    public void setEstado(int estado) {
		this.estado = estado;
	}

		//OBTENER
		public static String obtenerCanciones(int canciones){
			
			switch(canciones){
			
			case BIC:
				return "La Bicicleta";
			case MER:
				return " Me Rehuso";
			case AYM:
				return "Ay mi dios";
			case AFA:
				return "Al filo de tu amor";
			default:
			      return "Despacito ";
		     }
	    }
	
      
  	public static String obtenerEstado(int estados){
		
		switch(estados){
		
		case RES:
			return "Reservado";
		default:
			return "Reserva Atendida";
		
	     }
    }
			
	
	
}
