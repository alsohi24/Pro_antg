package clases;

public class Bebida {
	
	    //ATRIBUTOS PRIVADO
	public static final int CIE = 0;
	public static final int SPR = 1;
	public static final int INC = 2;
	public static final int PES = 3;
	public static final int COC = 4;
	public static final int SUP = 5;
	public static final int FAN = 6;
	public static final int CON = 7;
	
	public static final int AGU = 0;
	public static final int ALC = 1; 	
	public static final int GAS = 2;
	public static final int CAL = 3;
	public static final int DEP = 4;
	public static final int EST = 5;
	public static final int ENE = 6; 
	
	public static final int BUE = 0;
	public static final int MAL = 1;
	public static final int REG = 2; 
	
	public static final String PRE = "BEB";
	public static final int COD_PRE = 1001;
	
	 private int  idBebida ;
	 private int  marca;
	 private double  precio;
	 private int   tipoBebida;
	 private int    estado;
	
	
		//CONSTRUCTOR
	public Bebida(int   idBebida ,int  marca , double precio, int tipobebida, int estado  ){
		this.idBebida=idBebida;
	    this.marca=marca;
	    this.precio=precio;
	    this.tipoBebida= tipobebida;
	    this.estado=estado;
	}

	   //METODOS DE ACCESO PUBLICO SET /GET 
	

	public int getIdBebida() {
		return idBebida;
	}
    public void setIdBebida(int idBebida) {
		this.idBebida = idBebida;
	}


	public int getMarca() {
		return marca;
	}
	public void setMarca(int marca) {
		this.marca = marca;
	}


	public double getPrecio() {
		return precio;
	}
    public void setPrecio(double precio) {
		this.precio = precio;
	}


	public int getTipoBebida() {
		return tipoBebida;
	}

    public void setTipoBebida(int tipoBebida) {
		this.tipoBebida = tipoBebida;
	}


	public int getEstado() {
		return estado;
	}
    public void setEstado(int estado) {
		this.estado = estado;
	}
	
	//OBTENER
    
    public static String obtenerMarcaBebida(int bebidas){
		
		switch(bebidas){
		
		case CIE:
			return "Cielito";
		case SPR:
			return "Sprite";
		case INC:
			return "Inca kola";
		case PES:
			return "Pepsi";
		case COC:
			return  "Coca Cola";
		case SUP:
			return "7up";
		case FAN:
			return "Fanta";
		default:
		      return "Concordia";
	     }
    }
	
    
public static String obtenerTipoBebida(int tipobebidas){
		
		switch(tipobebidas){
		
		case AGU:
			return "Agua";
		case ALC:
			return "Alcoholica";
		case GAS:
			return "Gaseosa";
		case CAL:
			return "Calientes";
		case DEP:
			return "Deportivas o Isotónicas";
		case EST:
			return  "Estimulantes";
		default:
		      return "Energeticos o Hipertónicas";
	     }
    }


public static String obtenerEstado(int estados){
	
	switch(estados){
	
	case BUE:
		return "Bueno";
	case MAL:
		return "Malo";
	default:
	      return "Regular";
     }
}
    
    
  	
	
}