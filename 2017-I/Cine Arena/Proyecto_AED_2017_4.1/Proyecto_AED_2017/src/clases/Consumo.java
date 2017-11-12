package clases;

public class Consumo {
	
	    //ATRIBUTOS PRIVADO
	public static final int PEN=0;
	public static final int PAG=1;
	
	public static final String PRE = "CON";
	public static final int COD_PRE = 1001;
	
	 private int codConsumo;
	 private int idCliente;
	 private String fecha;
	 private double total;
	 private int estado;
	    
    public Consumo(int codConsumo, int idCliente, String fecha, double total, int estado) {
		
		this.codConsumo = codConsumo;
		this.idCliente = idCliente;
		this.fecha = fecha;
		this.total = total;
		this.estado = estado;
	}


	public int getCodConsumo() {
		return codConsumo;
	}


	public void setCodConsumo(int codConsumo) {
		this.codConsumo = codConsumo;
	}


	public int getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}


	public int getEstado() {
		return estado;
	}


	public void setEstado(int estado) {
		this.estado = estado;
	}

	
	public static String obtenerEstado(int estados){
	
		switch(estados){
	
		case PEN:
			return "Pendiente";
		default:
			return "Pagado";
     }
}
    
    
  	
	
}