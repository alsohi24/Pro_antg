package clases;

public class Cliente {

	// Atributos privados
	private String cliente, apMaterno, apPaterno, nombre, direccion, telefono, dni, fechaNacimiento, fechaAfiliacion,
			idUsuario;
	private int tipoDeCliente, tipoestadoCivil;

	// Constructor
	public Cliente(String cliente, String nombre, String apPaterno, String apMaterno, String direccion, String telefono,
			String dni, String fechaNacimiento, String fechaAfiliacion, int tipoestadoCivil, int tipoDeCliente,
			String idUsuario) {
		this.cliente = cliente;
		this.nombre = nombre;
		this.apPaterno = apPaterno;
		this.apMaterno = apMaterno;
		this.direccion = direccion;
		this.telefono = telefono;
		this.dni = dni;
		this.idUsuario = idUsuario;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaAfiliacion = fechaAfiliacion;
		this.tipoestadoCivil = tipoestadoCivil;
		this.tipoDeCliente = tipoDeCliente;
	}

	// operaciones publicas: set/get
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public void setApMaterno(String apMaterno) {
		this.apMaterno = apMaterno;
	}

	public void setApPaterno(String apPaterno) {
		this.apPaterno = apPaterno;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public void setFechaAfiliacion(String fechaAfiliacion) {
		this.fechaAfiliacion = fechaAfiliacion;
	}

	public void setEstadoCivil(int tipoestadoCivil) {
		this.tipoestadoCivil = tipoestadoCivil;
	}

	public void setTipoDeCliente(int tipoDeCliente) {
		this.tipoDeCliente = tipoDeCliente;
	}

	public String getCliente() {
		return cliente;
	}

	public String getApMaterno() {
		return apMaterno;
	}

	public String getApPateno() {
		return apPaterno;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getDni() {
		return dni;
	}

	public String getUsuario() {
		return idUsuario;
	}

	public String getFechaDeNacimiento() {
		return fechaNacimiento;
	}

	public String getFechaDeAfiliacion() {
		return fechaAfiliacion;
	}

	public int getTipoEstadoCivil() {
		return tipoestadoCivil;
	}

	public int getTipoDeCliente() {
		return tipoDeCliente;
	}

	public String txtTipoCliente() {
		switch (tipoDeCliente) {
			case 0:
				return "Estandar";
			case 1:
				return "Bronce";
			case 2:
				return "Plata";
			case 3:
				return "Oro";
			default:
				return "Diamante";
		}
	}

	public String txtTipoEstadoCivil() {
		switch (tipoestadoCivil) {
			case 0:
				return "Soltero";
			case 1:
				return "Casado";
			case 2:
				return "Viudo";
			case 3:
				return "Divorciado";
			default:
				return "No especifica";
		}
	}

}
