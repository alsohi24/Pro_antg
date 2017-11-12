package clases;

public class Bebida {

	// Atributos privados
	private String idBebida, nombre, marca;
	private int tipoBebida, estado;
	double precio;
	
	//Constructor
	public Bebida(String idBebida, String nombre, String marca, int tipoBebida, int estado, double precio){
		this.idBebida=idBebida;
		this.nombre=nombre;
		this.marca=marca;
		this.tipoBebida=tipoBebida;
		this.estado=estado;
		this.precio=precio;
		
	}
	
	//Operaciones publicas
	public void setIdBebida (String idBebida){
		this.idBebida=idBebida;
	}
	
	public void setNombre(String nombre){
		this.nombre=nombre;
	}
	
	public void setMarca (String marca){
		this.marca=marca;
	}
	
	public void setTipoBebida(int tipoBebida){
		this.tipoBebida=tipoBebida;
	}
	
	public void setEstado(int estado){
		this.estado=estado;
	}
	
	public void setPrecio(double precio){
		this.precio=precio;
	}
	
	public String getIdBebida (){
		return idBebida;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public String getMarca(){
		return marca;
	}
	
	public int getTipoBebida(){
		return tipoBebida;
	}
	
	public int getEstado(){
		return estado;
	}
	
	public double getPrecio(){
		return precio;
	}
	
	//Operaciones publicas complementarias
	public String txtTipoBebida() {
		switch (tipoBebida) {
			case 0:	return "Cerveza";
			case 1:	return "Vinos";
			case 2:	return "Whisky";
			case 3:	return "Ron";
			case 4:	return "Frutado";
			case 5:	return "Combinacion preparada";
			default:return "Agua embotellada";
			
		}
	}

	public String txtEstado() {
		switch (estado) {
			case 0:	return "Habilitado";
			default:return "Inhabilitado";
		}
	}
}
