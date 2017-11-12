package clases;

public class Cancion {

	// Atributos Privados
	private String idCancion, nombre, duracion, idArtista, album, fechaRegistro;
	private int numeroReproducciones, estado;

	// Constructor
	public Cancion(String idCancion, String nombre, String duracion, String idArtista, String album,
			String fechaRegistro, int numeroReproducciones, int estado) {
		this.idCancion = idCancion;
		this.nombre = nombre;
		this.duracion = duracion;
		this.idArtista = idArtista;
		this.album = album;
		this.fechaRegistro = fechaRegistro;
		this.numeroReproducciones = numeroReproducciones;
		this.estado = estado;
	}

	// Operaciones publicas: set/get
	public void setIdCancion(String idCancion) {
		this.idCancion = idCancion;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public void setIdArtista(String idArtista) {
		this.idArtista = idArtista;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public void setNumeroReproducciones(int numeroReproducciones) {
		this.numeroReproducciones = numeroReproducciones;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getIdCancion() {
		return idCancion;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDuracion() {
		return duracion;
	}

	public String getIdArtista() {
		return idArtista;
	}

	public String getAlbum() {
		return album;
	}

	public String getFechaRegistro() {
		return fechaRegistro;
	}

	public int getNumeroReproducciones() {
		return numeroReproducciones;
	}

	public int getEstado() {
		return estado;
	}

	public String txtEstadoCancion() {
		switch (estado) {
			case 0:
				return "Habilitado";
			default:
				return "Inhabilitado";
		}
	}
}
