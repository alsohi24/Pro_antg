package arreglos;

import java.util.ArrayList;
import java.io.*;
import clases.Cancion;


public class ArregloCancion {

	// Atributo privado
	private ArrayList<Cancion> can;
	private String archivo;// copia

	// Constructor
	public ArregloCancion(String archivo) {
		can = new ArrayList<Cancion>();
		this.archivo = archivo;// copia
		cargarCancion();// copia
	}

	// Operaciones Publicas Basicas
	public int tamaño() {
		return can.size();
	}

	public Cancion obtener(int i) {
		return can.get(i);
	}

	public void adicionar(Cancion x) {
		can.add(x);
	}

	public void eliminarAlFinal() {
		can.remove(tamaño() - 1);
	}

	public void eliminarTodo() {
		can.clear();
	}

	// Operaciones públicas complementarias
	public Cancion buscar(String codigo) {
		for (int i = 0; i < tamaño(); i++)
			if (obtener(i).getIdCancion() == codigo)
				return obtener(i);
		return null;
	}

	public void eliminar(Cancion x) {
		can.remove(x);
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
		public void grabarCancion() {
			try {
				PrintWriter pw;
				String linea;
				Cancion x;
				pw = new PrintWriter(new FileWriter(archivo));
				for (int i = 0; i < tamaño(); i++) {
					x = obtener(i);
					linea = x.getIdCancion() + ";" + 
							x.getNombre() + ";" + 
							x.getDuracion() + ";" + 
							x.getIdArtista() + ";" + 
							x.getAlbum() + ";" + 
							x.getFechaRegistro() + ";" + 
							x.getNumeroReproducciones() + ";"+ 
							x.getEstado();
					pw.println(linea);
				}
				pw.close();
			}
			catch (Exception e) {
			}
		}

		public void cargarCancion() {
			try {
				BufferedReader br;
				String linea, idCancion, nombre, duracion, idArtista, album, fechaRegistro;
				String[] s;
				int numeroReproducciones, estado;
				br = new BufferedReader(new FileReader(archivo));
				while ((linea = br.readLine()) != null) {
					s = linea.split(";");
					idCancion = s[0].trim();
					nombre = s[1].trim();
					duracion = s[2].trim();
					idArtista = s[3].trim();
					album = s[4].trim();
					fechaRegistro = s[5].trim();
					numeroReproducciones = Integer.parseInt(s[6].trim());
					estado = Integer.parseInt(s[7].trim());
					adicionar(new Cancion(idCancion, nombre, duracion, idArtista, album, fechaRegistro,
							numeroReproducciones, estado));
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
