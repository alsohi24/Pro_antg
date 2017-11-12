package arreglos;

import java.util.ArrayList;
import java.io.*;
import clases.Artista;

public class ArregloArtista {

	// Atributos privados
	private ArrayList<Artista> art;
	private String archivo;// copia

	// Constructor
	public ArregloArtista(String archivo) {
		art = new ArrayList<Artista>();
		this.archivo = archivo;// copia
		cargarArtista();// copia
		// art.add(new Artista("A0001", "Juan Gabriel", "25/07/1987", 0,
		// G0001));
		// art.add(new Artista("A0002", "Shakira", "24/07/1987", 0, G0001));
		// Artista(String idArtista, String nombreArtistico, String
		// fechaRegistro, int estado, Genero idGenero)
	}

	// Operaciones Publicas Basicas
	public int tamaño() {
		return art.size();
	}

	public Artista obtener(int i) {
		return art.get(i);
	}

	public void adicionar(Artista x) {
		art.add(x);
	}

	public void eliminarAlFinal() {
		art.remove(tamaño() - 1);
	}

	public void eliminarTodo() {
		art.clear();
	}

	// Operaciones públicas complementarias
	public Artista buscar(String codigo) {
		for (int i = 0; i < tamaño(); i++)
			if (obtener(i).getIdArtista() == codigo)
				return obtener(i);
		return null;
	}

	public void eliminar(Artista x) {
		art.remove(x);
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
	public void grabarArtista() {
		try {
			PrintWriter pw;
			String linea;
			Artista x;
			pw = new PrintWriter(new FileWriter(archivo));
			for (int i = 0; i < tamaño(); i++) {
				x = obtener(i);
				linea = x.getIdArtista() + ";" + x.getNombreArtistico() + ";" + x.getFechaRegistro() + ";"
						+ x.getIdGenero() + ";" + x.getEstado();
				pw.println(linea);

				// Artista(String idArtista, String nombreArtistico, String
				// fechaRegistro, int estado, Genero idGenero)

			}
			pw.close();
		}
		catch (Exception e) {
		}
	}

	public void cargarArtista() {
		try {
			BufferedReader br;
			String linea, idArtista, nombreArtistico, fechaRegistro, idGenero;
			String[] s;
			int estado;
			br = new BufferedReader(new FileReader(archivo));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				idArtista = s[0].trim();
				nombreArtistico = s[1].trim();
				fechaRegistro = s[2].trim();
				idGenero = s[3].trim();
				estado = Integer.parseInt(s[4].trim());
				adicionar(new Artista(idArtista, nombreArtistico, fechaRegistro, idGenero, estado));
				// Artista(String idArtista, String nombreArtistico, String
				// fechaRegistro, int estado, Genero idGenero)

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
