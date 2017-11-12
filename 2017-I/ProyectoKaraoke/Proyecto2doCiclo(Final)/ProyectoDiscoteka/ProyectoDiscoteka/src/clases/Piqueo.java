package clases;

public class Piqueo {

	// Atributos privados
	private String idPiqueo, nombre;
	private int tipoPiqueo, estado;
	double precio;

	// Constructor
	public Piqueo(String idPiqueo, String nombre, int tipoPiqueo, int estado, double precio) {
		this.idPiqueo = idPiqueo;
		this.nombre = nombre;
		this.tipoPiqueo = tipoPiqueo;
		this.estado = estado;
		this.precio = precio;

	}

	// Operaciones publicas
	public void setIdBebida(String idPiqueo) {
		this.idPiqueo = idPiqueo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setTipoBebida(int tipoPiqueo) {
		this.tipoPiqueo = tipoPiqueo;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getIdPiqueo() {
		return idPiqueo;
	}

	public String getNombre() {
		return nombre;
	}

	public int getTipoPiqueo() {
		return tipoPiqueo;
	}

	public int getEstado() {
		return estado;
	}

	public double getPrecio() {
		return precio;
	}

	// Operaciones publicas complementarias
	public String txtTipoPiqueo() {
		switch (tipoPiqueo) {
			case 0:
				return "Frios";
			case 1:
				return "Calientes";
			default:
				return "Snacks";

		}
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
