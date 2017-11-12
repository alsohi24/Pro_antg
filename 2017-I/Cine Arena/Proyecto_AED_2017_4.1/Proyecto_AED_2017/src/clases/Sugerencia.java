package clases;

public class Sugerencia {
	
	public static final int BUE =0;
	public static final int MAL=1;
	public static final int REG=2;
	
	public static final String PRE = "SUG";
	public static final int COD_PRE = 1001;
	
	
	 private int    idSugerencia;
	 private String detalle ;
	 private int    idUsuario ;
	 private int    tipoSugerencia;
	
	//CONSTRUCTOR
	 
	 public Sugerencia (int idSugerencia , String detalle,
			  int idUsuario , int tipoSugerencia ){
		
		 this.idSugerencia=idSugerencia;
		 this.detalle=detalle;
		 this.idUsuario=idUsuario;
		 this.tipoSugerencia=tipoSugerencia;
		 
     }
			
			  
	//METODOS DE ACCESO PUBLICO SET /GET 
	 public void setIdSugerencia(int idSugerencia){
		  this.idSugerencia=idSugerencia;
	  }
	  public void setDetalle(String detalle){
		  this.detalle=detalle;
	  }
	
	  public void setIdUsuario(int idUsuario){
		 this.idUsuario=idUsuario;
	  }
	  public void setTipoSugerecia(int tipoSugerencia){
		  this.tipoSugerencia=tipoSugerencia;
	  }	
	  
	  public int  getIdSugerencia(){
		  return idSugerencia;
	  }
	  
	  public String getDetalle(){
		 return detalle;
	 }
	 public int  getIdUsuario(){
		 return idUsuario;
	 }
	 public int getTipoSugerencia(){
		 return tipoSugerencia;
	 }
	//OBTENER 
	 
	 public static String obtenerTipoSuegerencia(int tipoSugerencia){
		 switch(tipoSugerencia){
		 case BUE:
			 return "Buena";
		 case MAL:
			 return "Mala";
	     default :
	    	 return "Regular";
		 }
	 }


}