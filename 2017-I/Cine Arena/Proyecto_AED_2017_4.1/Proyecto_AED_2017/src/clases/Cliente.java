package clases;

public class Cliente {
	
	public static final int SOL=0;
	public static final int CAS=1;
	public static final int VIU=2;
	public static final int DIV=3;
	public static final int NE=4;
	
	public static final int EST=0;
	public static final int BRO=1;
	public static final int PLA=2;
	public static final int ORO=3;
	public static final int DIA=4;
	
	public static final String PRE = "CLI";
	public static final int COD_PRE = 1001;
	
	private int idCliente;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String nombres;
	private String direccion;
	private String fechaNacimiento;
	private String fechaAfiliacion;
	private int estadoCivil;
	private String telefono;
	private String dni;
	private int tipoDeCliente;
	private String usuario;
	
	
	
	
	public Cliente(int idCliente, String apellidoPaterno, String apellidoMaterno, String nombres, String direccion,
			String fechaNacimiento, String fechaAfiliacion, int estadoCivil, String telefono, String dni,
			int tipoDeCliente, String usuario) {
		
		this.idCliente = idCliente;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.nombres = nombres;
		this.direccion = direccion;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaAfiliacion = fechaAfiliacion;
		this.estadoCivil = estadoCivil;
		this.telefono = telefono;
		this.dni = dni;
		this.tipoDeCliente = tipoDeCliente;
		this.usuario = usuario;
	}
	
	
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
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
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getFechaAfiliacion() {
		return fechaAfiliacion;
	}
	public void setFechaAfiliacion(String fechaAfiliacion) {
		this.fechaAfiliacion = fechaAfiliacion;
	}
	public int getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(int estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public int getTipoDeCliente() {
		return tipoDeCliente;
	}
	public void setTipoDeCliente(int tipoDeCliente) {
		this.tipoDeCliente = tipoDeCliente;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	
	
	public static String obtenerEstadoCivil(int tipo){
		
		switch(tipo){
		
		case SOL:
			return "Solero";
		case CAS:
			return "Casado";
		case VIU:
			return "Viudo";
		case DIV:
			return "Divorciado";
		default:
			return "No especifica";
		
		}
		
	}
	
	public static String obtenerTipo(int tipo){
		
		switch(tipo){
		
		case EST:
			return "Estándar";
		case BRO:
			return "Bronce";
		case PLA:
			return "Plata";
		case ORO:
			return "Oro";
		default:
			return "Diamante";
		
		}
		
	}
	
	
	
	
	
	
	
	
}
