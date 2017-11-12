package clases;

public class Usuario {

	public static final int ADM = 0;
	public static final int SUP = 1;
	public static final int MOZ = 2;
	
	public static final int TAR = 0;
	public static final int NOC = 1;
	
	public static final String PRE = "USU";
	public static final int COD_PRE = 1001;
	
	private int idUsuario;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String nombres;
	private int tipoEmpleado;
	private String login;
	private String  password;
	private int turno;
	
	
	
	
	public Usuario(int idUsuario, String apellidoPaterno, String apellidoMaterno, String nombres,
			String login, String password, int tipoEmpleado,int turno) {
	
		this.idUsuario = idUsuario;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.nombres = nombres;
		this.login = login;
		this.password = password;
		this.tipoEmpleado = tipoEmpleado;
		this.turno = turno;
	}
	
	
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public int getTipoEmpleado() {
		return tipoEmpleado;
	}
	public void setTipoEmpleado(int tipoEmpleado) {
		this.tipoEmpleado = tipoEmpleado;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getTurno() {
		return turno;
	}
	public void setTurno(int turno) {
		this.turno = turno;
	}
	
	
	//Obtener
	public static String obtenerTipo(int tipo){
		
		switch(tipo){
		
		case ADM:
			return "Administrador";
		case SUP:
			return "Supervisor";
		default:
			return "Mozo";
		
		}
		
	}
	
	public static String obtenerTurno(int turno){
		
		switch(turno){
		
		case TAR:
			return "Tarde";
		default:
			return "Noche";
		
		}
		
	}
	
	
}
