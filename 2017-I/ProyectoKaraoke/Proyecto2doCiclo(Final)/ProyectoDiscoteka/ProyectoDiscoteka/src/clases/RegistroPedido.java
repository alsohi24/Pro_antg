package clases;

public class RegistroPedido {
	// Atributos Privados
	private String  codigoReserva, codigoCliente, codigoUsuario, cancion, bebidas, piqueos;
	int estadoReserva;

	// Constructor
	public RegistroPedido(String codigoReserva, String codigoCliente, String codigoUsuario, String cancion, 
			String bebidas, String piqueos, int estadoReserva) {
		this.codigoReserva = codigoReserva;
		this.codigoCliente = codigoCliente;
		this.cancion = cancion;
		this.codigoUsuario=codigoUsuario;
		this.bebidas = bebidas;
		this.piqueos = piqueos;
		this.estadoReserva = estadoReserva;

	}

	// operaciones publicas: set/get
	public void setCodigoReserva(String codigoReserva) {
		this.codigoReserva = codigoReserva;
	}

	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public void setCodigoUsuario(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}
	public void setCancion(String cancion) {
		this.cancion = cancion;
	}

	public void setBebidas(String bebidas) {
		this.bebidas = bebidas;
	}

	public void setPiqueos(String piqueos) {
		this.piqueos = piqueos;
	}

	public void setEstadoReserva(int estadoReserva) {
		this.estadoReserva = estadoReserva;
	}

	public String getCodigoCliente() {
		return codigoCliente;
	}

	public String getCodigoUsuario() {
		return codigoUsuario;
	}
	public String getCancion() {
		return cancion;
	}

	public String getCodigoReserva() {
		return codigoReserva;
	}

	public String getBebidas() {
		return bebidas;
	}

	public String getPiqueos() {
		return piqueos;
	}

	public int getEstadoReserva() {
		return estadoReserva;
	}

	public String txtEstadoReserva() {
		switch (estadoReserva) {
			case 0:
				return "Libre";
			default:
				return "reservado";
		}
	}

}
