package arreglos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.Sugerencia;

public class ArregloSugerencia {

	// Atributos Privados
	private ArrayList<Sugerencia> sug;
	private String archivo;// copia

	// Constructor
	public ArregloSugerencia(String archivo) {
		sug = new ArrayList<Sugerencia>();
		this.archivo = archivo;// copia
		cargarSugerencia();// copia

	}

	// Operaciones Publicas Basicas
	public int tamaño() {
		return sug.size();
	}

	public Sugerencia obtener(int i) {
		return sug.get(i);
	}

	public void adicionar(Sugerencia x) {
		sug.add(x);
	}

	public void eliminarAlFinal() {
		sug.remove(tamaño() - 1);
	}

	public void eliminarTodo() {
		sug.clear();
	}

	// Operaciones públicas complementarias
	public Sugerencia buscar(String codigo) {
		for (int i = 0; i < tamaño(); i++)
			if (obtener(i).getIdSugerencia() == codigo)
				return obtener(i);
		return null;
	}

	public void eliminar(Sugerencia x) {
		sug.remove(x);
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
	public void grabarSugerencia() {
		try {
			PrintWriter pw;
			String linea;
			Sugerencia x;
			pw = new PrintWriter(new FileWriter(archivo));
			for (int i = 0; i < tamaño(); i++) {
				x = obtener(i);
				linea = x.getIdSugerencia() + ";" + 
						x.getIdUsuario() + ";"+
						x.getTipoSugerencia() + ";" +
						x.getFecha() + ";" +
						x.getDetalle();
				pw.println(linea);

			}
			pw.close();
		}
		catch (Exception e) {
		}
	}

	public void cargarSugerencia() {
		try {
			BufferedReader br;
			String linea, idSugerencia, idUsuario, fecha, detalle;
			String[] s;
			int tipoSugerencia;
			br = new BufferedReader(new FileReader(archivo));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				idSugerencia = s[0].trim();
				idUsuario = s[1].trim();
				tipoSugerencia = Integer.parseInt(s[2].trim());
				fecha = s[3].trim();
				detalle = s[4].trim();

				adicionar(new Sugerencia(idSugerencia, idUsuario, tipoSugerencia, fecha, detalle));
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
