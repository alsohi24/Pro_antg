package clases;

public class Piqueo {
	
	
	public static final int CAR=0;
	public static final int GAL=1;
	public static final int CHO=2;
	public static final int EMP=3;
	public static final int CHI=4;
	public static final int FRU=5;
	public static final int TEQ=6;
	
	
	public static final int BUE = 0;
	public static final int MAL = 1;
	public static final int REG = 2; 
	
	
	public static final String PRE = "PIQ";
	public static final int COD_PRE = 1001;
	
	
	 //ATRIBUTOS PRIVADO
	 private int  idPiqueo ;
	 private String nombre ;
	 private int tipoPiqueo ;
	 private double precio ;
	 private int estado ;
	
	
	   //CONSTRUCTOR
	 public Piqueo(int idPiqueo , String nombre, int tipoPiqueo ,  double precio, int estado ) {
       this.idPiqueo=idPiqueo;
       this.nombre=nombre;
       this.tipoPiqueo=tipoPiqueo;
       this.precio=precio ;
       this.estado=estado;
     
	}
		
	  //METODOS DE ACCESO PUBLICO SET /GET 
	 public void setidPiqueo( int idPiqueo){
		  this.idPiqueo=idPiqueo;
	}
	 public void setNombre( String nombre){
		  this.nombre=nombre;
	 }
	 public void setTipoPiqueo(int tipoPiqueo){
		  this.tipoPiqueo=tipoPiqueo;
	 }
	 public void setEstado(int estado ){
		  this.estado=estado;
	 }
	 public void setidPrecio(double precio){
		  this.precio=precio;
	 }
	 
	 public int getidPiqueo(){
		 return idPiqueo;
	 }
	 public String getNombre(){
		 return nombre;
	 }
	 public int getTipoPiqueo(){
		 return tipoPiqueo;
	 }
	 public int getEstado(){
		 return estado;
	 }
	 public double getPrecio(){
		 return precio;
	 }
	 
	 
	 // OBTENER
	 
	 public static String obtenerTipoPiqueos(int piqueos){
			
			switch(piqueos){
			
			case CAR:
				return "Caramelos";
			case GAL:
				return "Galletas";
			case CHO:
				return "Chocolate";
			case EMP:
				return "Emparedados";
			case CHI:
				return "Chips";
			case FRU:
				return "Frutos Secos";
			default:
			      return "Tequeños";
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