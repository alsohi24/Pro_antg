package clases;

public class Sugerencia {

	// Atributos Privados
	private String idSugerencia, detalle, idUsuario, fecha;
	private int tipoSugerencia;

	// Constructor
	public Sugerencia(String idSugerencia, String idUsuario, int tipoSugerencia, String fecha, String detalle) {
		this.idSugerencia = idSugerencia;
		this.idUsuario = idUsuario;
		this.tipoSugerencia = tipoSugerencia;
		this.fecha=fecha;
		this.detalle = detalle;
		
		
	}

	// operaciones publicas: set/get
	public void setIdSugerencia(String idSugerencia) {
		this.idSugerencia = idSugerencia;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public void setTipoSugerencia(int tipoSugerencia) {
		this.tipoSugerencia = tipoSugerencia;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;

	}

	public void setFecha(String fecha) {
		this.fecha = fecha;

	}
	public String getIdSugerencia() {
		return idSugerencia;
	}

	public String getDetalle() {
		return detalle;
	}

	public int getTipoSugerencia() {
		return tipoSugerencia;
	}

	public String getIdUsuario() {
		return idUsuario;
	}
	
	public String getFecha() {
		return fecha;
	}

	public String txtTipoSugerencia() {
		switch (tipoSugerencia) {
			case 0:
				return "Calidad de Atención";
			case 1:
				return "Calidad/Variedad de las Canciones";
			case 2:
				return "Calidad/Variedad de las bebidas";
			case 3:
				return "Calidad/Variedad de los Piqueos";
			default:
				return "Calidad del local";
		}
	}

}
