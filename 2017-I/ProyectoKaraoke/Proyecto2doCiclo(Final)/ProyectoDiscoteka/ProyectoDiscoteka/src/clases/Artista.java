package clases;



public class Artista {
	// Atributos Privados
	private String idArtista, nombreArtistico, fechaRegistro, idGenero;
	private int estado;
	

	// Constructor
	public Artista(String idArtista, String nombreArtistico, String fechaRegistro, String idGenero, int estado) {

		this.idArtista = idArtista;
		this.nombreArtistico = nombreArtistico;
		this.fechaRegistro = fechaRegistro;
		this.estado = estado;
		this.idGenero = idGenero;
	}

	// operaciones publicas: set/get
	public void setIdArtista(String idArtista) {
		this.idArtista = idArtista;
	}

	public void setNombreArtistico(String nombreArtistico) {
		this.nombreArtistico = nombreArtistico;
	}

	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public void setIdGenero(String idGenero) {
		this.idGenero = idGenero;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getIdArtista() {
		return idArtista;
	}

	public String getNombreArtistico() {
		return nombreArtistico;
	}

	public String getFechaRegistro() {
		return fechaRegistro;
	}

	public String getIdGenero() {
		return idGenero;
	}

	public int getEstado() {
		return estado;
	}

	public String txtEstado() {
		switch (estado) {
			case 0:
				return "Habilitado";
			default:
				return "Inhabilitado";
		}
	}

}
