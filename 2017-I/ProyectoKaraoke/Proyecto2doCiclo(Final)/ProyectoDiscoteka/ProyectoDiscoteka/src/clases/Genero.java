package clases;

public class Genero {

	// Atributos Privados
	private String idGenero, descripcion, procedencia;
	private int epoca, estado;

	// Constructor
	public Genero(String idGenero, String descripcion, String procedencia, int epoca, int estado) {
		this.idGenero = idGenero;
		this.descripcion = descripcion;
		this.procedencia = procedencia;
		this.epoca = epoca;
		this.estado = estado;
	}

	// operaciones publicas: set/get
	public void setIdGenero(String idGenero) {
		this.idGenero = idGenero;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setProcedencia(String procedencia) {
		this.procedencia = procedencia;
	}

	public void setEpoca(int epoca) {
		this.epoca = epoca;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getIdGenero() {
		return idGenero;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getProcedencia() {
		return procedencia;
	}

	public int getEpoca() {
		return epoca;
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
