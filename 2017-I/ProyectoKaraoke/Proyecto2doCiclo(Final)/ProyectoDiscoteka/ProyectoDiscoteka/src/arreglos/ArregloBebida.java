package arreglos;
import java.io.*;
import java.util.ArrayList;
import clases.Bebida;

public class ArregloBebida {

	//Atributos privados
	private ArrayList<Bebida> beb;
	private String archivo;// copia
	
	//Constructor
	public ArregloBebida(String archivo){
		beb= new ArrayList<Bebida>();
		this.archivo = archivo;// copia
		cargarBebida();// copia

		
		//Bebida(String idBebida, String nombre, String marca, int tipoBebida, int estado, double precio)
	}
		
	//Operaciones publicas basicas
	public int tamaño(){
		return beb.size();
	}

	public Bebida obtener(int i){
		return beb.get(i);
	}
	
	public void adicionar(Bebida x){
		beb.add(x);
	}
	
	public void eliminarAlFinal(){
		beb.remove(tamaño()-1);
	}
	
	public void eliminarTodo(){
		beb.clear();
	}

	//Operaciones Publicas complementarias
	public Bebida buscar(String codigo){
		for (int i=0; i<tamaño();i++)
			if(obtener(i).getIdBebida()==codigo )
				return obtener(i);
		return null;
	}
	
	// Operaciones para Archivo*************
			public void setArchivo(String archivo) {
				this.archivo = archivo;
			}

			public String getArchivo() {
				return archivo;
			}
			// ***********************
		
		
		// para trabajar archivo*************************************
		public void grabarBebida() {
			try {
				PrintWriter pw;
				String linea;
				Bebida x;
				pw = new PrintWriter(new FileWriter(archivo));
				for (int i = 0; i < tamaño(); i++) {
					x = obtener(i);
					linea = x.getIdBebida() + ";" + 
							x.getNombre() + ";" + 
							x.getMarca() + ";" + 
							x.getTipoBebida() + ";" + 
							x.getEstado() + ";" + 
							x.getPrecio();
					pw.println(linea);
//	Bebida(String idBebida, String nombre, String marca, int tipoBebida, int estado, double precio)
					

				}
				pw.close();
			}
			catch (Exception e) {
			}
		}

		public void cargarBebida() {
			try {
				BufferedReader br;
				String linea, idBebida, nombre, marca;
				String[] s;
				int tipoBebida, estado;
				double precio;
				br = new BufferedReader(new FileReader(archivo));
				while ((linea = br.readLine()) != null) {
					s = linea.split(";");
					idBebida= s[0].trim();
					nombre = s[1].trim();
					marca = s[2].trim();
					tipoBebida = Integer.parseInt(s[3].trim());
					estado = Integer.parseInt(s[4].trim());
					precio = Double.parseDouble(s[5].trim());
					adicionar(new Bebida(idBebida, nombre, marca, tipoBebida, estado, precio));
//					Bebida(String idBebida, String nombre, String marca, int tipoBebida, int estado, double precio)				
				}
				br.close();
			}
			catch (Exception e) {
			}
		}

		public boolean existeArchivo() {
			File f = new File(archivo);
			return f.exists();
		}
	
	

}
