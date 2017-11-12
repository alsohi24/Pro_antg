package clases;

public class Usuario {

	// Atributos Privados
	private String IdUsuario, apellidoPaterno, apellidoMaterno, nombres, login, pasword;
	private int tipoEmpleado, turno;

	// Constructor
	public Usuario(String IdUsuario, String nombres, String apellidoPaterno, String apellidoMaterno, String login,
			String pasword, int tipoEmpleado, int turno) {
		this.IdUsuario = IdUsuario;
		this.nombres = nombres;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.login = login;
		this.pasword = pasword;
		this.tipoEmpleado = tipoEmpleado;
		this.turno = turno;
	}

	// operaciones publicas: set/get
	public void setIdUsuario(String IdUsuario) {
		this.IdUsuario = IdUsuario;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPasword(String pasword) {
		this.pasword = pasword;
	}

	public void setTipoEmpleado(int tipoEmpleado) {
		this.tipoEmpleado = tipoEmpleado;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}

	public String getIdUsuario() {
		return IdUsuario;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public String getNombres() {
		return nombres;
	}

	public String getLogin() {
		return login;
	}

	public String getPasword() {
		return pasword;
	}

	public int getTipoEmpleado() {
		return tipoEmpleado;
	}

	public int getTurno() {
		return turno;
	}

	public String txtTipoEmpleado() {
		switch (tipoEmpleado) {
			case 0:
				return "Administrador";
			case 1:
				return "Supervisor";
			default:
				return "Mozo";
		}
	}

	public String txtTurno() {
		switch (turno) {
			case 0:
				return "Tarde (3am-9pm)";
			default:
				return "Noche (9pm-3am)";
		}
	}
}
