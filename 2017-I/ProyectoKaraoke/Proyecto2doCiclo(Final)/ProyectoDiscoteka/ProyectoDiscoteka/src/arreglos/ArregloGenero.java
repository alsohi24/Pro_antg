package arreglos;

import java.util.ArrayList;
import java.io.*;
import clases.Genero;


public class ArregloGenero {

	// Atributos privados
	private ArrayList<Genero> gen;
	private String archivo;// copia

	// Constructor
	public ArregloGenero(String archivo) {
		gen = new ArrayList<Genero>();
		this.archivo = archivo;// copia
		cargarGenero();// copia

		
		
		//gen.add(new Genero("G0001", "ROCK", "EUROPA", 1980, 0));
		//gen.add(new Genero("G0002", "POP", "EUROPA", 1990, 0));
		// Genero(String idGenero, String descripcion, String procedencia, int
		// epoca, int estado)
	}

	// Operaciones Publicas Basicas
	public int tamaño() {
		return gen.size();
	}

	public Genero obtener(int i) {
		return gen.get(i);
	}

	public void adicionar(Genero x) {
		gen.add(x);
	}

	public void eliminarAlFinal() {
		gen.remove(tamaño() - 1);
	}

	public void eliminarTodo() {
		gen.clear();
	}

	// Operaciones públicas complementarias
	public Genero buscar(String codigo) {
		for (int i = 0; i < tamaño(); i++)
			if (obtener(i).getIdGenero() == codigo)
				return obtener(i);
		return null;
	}

	public void eliminar(Genero x) {
		gen.remove(x);
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
		public void grabarGenero() {
			try {
				PrintWriter pw;
				String linea;
				Genero x;
				pw = new PrintWriter(new FileWriter(archivo));
				for (int i = 0; i < tamaño(); i++) {
					x = obtener(i);
					linea = x.getIdGenero() + ";" + 
							x.getDescripcion() + ";" + 
							x.getProcedencia() + ";" + 
							x.getEpoca() + ";" + 
							x.getEstado();
					pw.println(linea);
				}
				pw.close();
			}
			catch (Exception e) {
			}
		}

		public void cargarGenero() {
			try {
				BufferedReader br;
				String linea, idGenero, descripcion, procedencia;
				String[] s;
				int epoca, estado;
							
				
				br = new BufferedReader(new FileReader(archivo));
				while ((linea = br.readLine()) != null) {
					s = linea.split(";");
					idGenero = s[0].trim();
					descripcion = s[1].trim();
					procedencia = s[2].trim();
					epoca = Integer.parseInt(s[3].trim());
					estado = Integer.parseInt(s[4].trim());
					adicionar(new Genero(idGenero, descripcion, procedencia, epoca, estado));
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
