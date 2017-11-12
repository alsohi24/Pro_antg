package clases;

public class Cancion {
	
	public static final int DIS = 0;
	public static final int NODIS = 1;
	
	public static final String PRE = "CAN";
	public static final int COD_PRE = 1001;
	
	//AP
		private int idCancion;
		private String nombre;
		private String duracion;
		private int idArtista;
		private String album;
		private int numeroReproducciones;
		private int estado;
		
	//constructor
		public Cancion(int idCancion, String nombre, String duracion, int idArtista, String album, int numeroReproducciones, int estado ){
			this.idCancion = idCancion;
			this.nombre = nombre;
			this.duracion = duracion;
			this.idArtista = idArtista;
			this.album = album;
			this.numeroReproducciones = numeroReproducciones;
			this.estado = estado;
		}
	//Metodo set/get
		public void setidCancion(int idCancion){
			this.idCancion = idCancion;
		}
		public void setnombre(String nombre){
			this.nombre = nombre;
		}
		public void setduracion(String duracion){
			this.duracion = duracion;
		}
		public void setidArtista(int idArtista){
			this.idArtista = idArtista;
		}
		public void setalbum(String album){
			this.album = album;
		}
		
		public void setnumeroReproducciones(int numeroReproducciones){
			this.numeroReproducciones = numeroReproducciones;
		}
		public void setestado(int estado){
			this.estado = estado;
		}
		
		public int getidCancion(){
			return idCancion;
		}
		public String getnombre(){
			return nombre;
		}
		public String getduracion(){
			return duracion;
		}
		public int getidArtista(){
			return idArtista;
		}
		public String getalbum(){
			return album;
		}

		public int getnumeroReproducciones(){
			return numeroReproducciones;
		}
		public int getestado(){
			return estado;
		}
		
		//obtener
		
		public static String obtenerEstado(int estado){
			
			switch(estado){
			
			case DIS:
				return "Disponible";
			default:
				return "No disponible";
			}
		}

}