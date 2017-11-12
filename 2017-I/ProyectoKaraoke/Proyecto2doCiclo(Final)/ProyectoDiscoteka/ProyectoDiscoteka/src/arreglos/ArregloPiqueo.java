package arreglos;

import java.io.*;
import java.util.ArrayList;
import clases.Piqueo;

public class ArregloPiqueo {

	// Atributos privados
	private ArrayList<Piqueo> piq;
	private String archivo;// copia

	// Constructor
	public ArregloPiqueo(String archivo) {
		piq = new ArrayList<Piqueo>();
		this.archivo = archivo;// copia
		cargarPiqueo();// copia

		// Piqueo(String idPiqueo, String nombre, int tipoPiqueo, int estado,
		// double precio)
	}

	// Operaciones publicas basicas
	public int tamaño() {
		return piq.size();
	}

	public Piqueo obtener(int i) {
		return piq.get(i);
	}

	public void adicionar(Piqueo x) {
		piq.add(x);
	}

	public void eliminarAlFinal() {
		piq.remove(tamaño() - 1);
	}

	public void eliminarTodo() {
		piq.clear();
	}

	// Operaciones Publicas complementarias
	public Piqueo buscar(String codigo) {
		for (int i = 0; i < tamaño(); i++)
			if (obtener(i).getIdPiqueo() == codigo)
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
	public void grabarPiqueo() {
		try {
			PrintWriter pw;
			String linea;
			Piqueo x;
			pw = new PrintWriter(new FileWriter(archivo));
			for (int i = 0; i < tamaño(); i++) {
				x = obtener(i);
				linea = x.getIdPiqueo() + ";" + 
						x.getNombre() + ";" + 
						x.getTipoPiqueo() + ";" + 
						x.getEstado() + ";"	+ 
						x.getPrecio();
				pw.println(linea);
				// Piqueo(String idPiqueo, String nombre, int tipoPiqueo, int estado, double precio)
			}
			pw.close();
		}
		catch (Exception e) {
		}
	}

	public void cargarPiqueo() {
		try {
			BufferedReader br;
			String linea, idPiqueo, nombre;
			String[] s;
			int tipoPiqueo, estado;
			double precio;
			br = new BufferedReader(new FileReader(archivo));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				idPiqueo = s[0].trim();
				nombre = s[1].trim();
				tipoPiqueo = Integer.parseInt(s[2].trim());
				estado = Integer.parseInt(s[3].trim());
				precio = Double.parseDouble(s[4].trim());
				adicionar(new Piqueo(idPiqueo, nombre, tipoPiqueo, estado, precio));
				// Piqueo(String idPiqueo, String nombre, int tipoPiqueo, int estado, double precio)
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
