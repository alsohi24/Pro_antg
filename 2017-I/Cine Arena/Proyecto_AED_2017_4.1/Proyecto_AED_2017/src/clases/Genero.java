package clases;

public class Genero {
	//AP
	
	public static final int RES=0;
	public static final int NOR=1;
	
	
	public static final String PRE = "GEN";
	public static final int COD_PRE = 1001;
	
	
	
		private int idGenero;
		private String descripcion;
		private String procedencia;
		private String  epoca;
		private int estado;
		
		//Constructor
		public Genero(int idGenero, String descripcion, String procedencia, String epoca, int estado){
			this.idGenero = idGenero;
			this.descripcion = descripcion;
			this.procedencia = procedencia;
			this.epoca = epoca;
			this.estado = estado;
		}
		
		//metodo set/get
		public void setidGenero(int idGenero){
			this.idGenero = idGenero;
		}
		public void setdescripcion(String descripcion){
			this.descripcion = descripcion;
		}
		public void setprocedencia(String procedencia){
			this.procedencia = procedencia;
		}
		public void setepoca(String epoca){
			this.epoca = epoca;
		}
		public void setestado(int estado){
			this.estado = estado;
		}
		
		public int  getidGenero(){
			return idGenero;
		}
		public String getdescripcion(){
			return descripcion;
		}
		public String getprocedencia(){
			return procedencia;
		}
		public String getepoca(){
			return epoca;
		}
		public int getestado(){
			return estado;
		}
		

		//OBTENER 
		
		 public static String obtenerEstado(int genero){
				
				switch(genero){
				
				case RES:
					return "Reservado";
				default :
					return "No Reservado ";	
		
				}
		 }
	
	}

