package clases;

public class Artista {
	
	public static final int SOL=0;
	public static final int CAS=1;
	public static final int VIU=2;
	public static final int DIV=3;
	public static final int NES=4;
	
	public static final String PRE = "ART";
	public static final int COD_PRE = 1001;
	
	//AP
	private int idArtista;
	private String NombreArtistico;
	private int idGenero;
	private String fechaRegistroCatalogo;
	private int estado;
	
	//Constructor
	public Artista(int idArtista, String NombreArtistico, int idGenero, String fechaRegistroCatalogo, int estado){
		this.idArtista = idArtista;
		this.NombreArtistico = NombreArtistico;
		this.idGenero = idGenero;
		this.fechaRegistroCatalogo = fechaRegistroCatalogo;
		this.estado = estado;
	}
	
	//metodo set/get
	public void setidArtista(int idArtista){
		this.idArtista = idArtista;
	}
	public void setNombreArtistico(String NombreArtistico){
		this.NombreArtistico = NombreArtistico;
	}
	public void setidGenero(int idGenero){
		this.idGenero = idGenero;
	}
	public void setfechaRegistroCatalogo(String fechaRegistroCatalogo){
		this.fechaRegistroCatalogo = fechaRegistroCatalogo;
	}
	public void setestado(int estado){
		this.estado = estado;
	}
	
	public int getidArtista(){
		return idArtista;
	}
	public String getNombreArtistico(){
		return NombreArtistico;
	}
	public int getidGenero(){
		return idGenero;
	}
	public String getfechaRegistroCatalogo(){
		return fechaRegistroCatalogo;
	}
	public int getestado(){
		return estado;
	}
	
	public static String obtenerEstadoCivil(int caso){
		
		switch(caso){
		
		case SOL:
			return "Soltero";
		case CAS:
			return "Casado";
		case VIU:
			return "Viudo";
		case DIV:
			return "Divorciado";
		default:
			return "No especifica";
		
		
		}
		
	}
	

	
}
