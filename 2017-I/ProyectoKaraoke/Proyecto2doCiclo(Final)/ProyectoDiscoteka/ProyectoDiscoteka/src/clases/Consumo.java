package clases;

public class Consumo {
	// Atributos privados
	private String codigoConsumo, codigoCliente, codigoUsuario, fechaConsumo;
	private double importePagar;
	private int estado;

	// Constructor
	public Consumo(String codigoConsumo, String codigoCliente, String codigoUsuario, String fechaConsumo, double importePagar, int estado) {
		this.codigoConsumo = codigoConsumo;
		this.codigoCliente = codigoCliente;
		this.codigoUsuario = codigoUsuario;
		this.fechaConsumo = fechaConsumo;
		this.importePagar = importePagar;
		this.estado = estado;
	}

	// operaciones publicas: set/get
	public void setCodigoConsumo(String codigoConsumo) {
		this.codigoConsumo = codigoConsumo;
	}

	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	
	public void setCodigoUsuario(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public void setFechaConsumo(String fechaConsumo) {
		this.fechaConsumo = fechaConsumo;
	}

	public void setImportePagar(double importePagar) {
		this.importePagar = importePagar;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public String getCodigoConsumo() {
		return codigoConsumo;
	}

	public String getCodigoCliente() {
		return codigoCliente;
	}
	
	public String getCodigoUsuario() {
		return codigoUsuario;
	}

	public String getFechaConsumo() {
		return fechaConsumo;
	}

	public double getImportePagar() {
		return importePagar;
	}

	public int getEstado() {
		return estado;
	}
}
