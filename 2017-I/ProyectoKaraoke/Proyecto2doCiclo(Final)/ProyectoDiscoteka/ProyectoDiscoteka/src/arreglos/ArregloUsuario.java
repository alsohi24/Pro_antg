package arreglos;

import java.util.ArrayList;
import java.io.*;

import clases.Usuario;

public class ArregloUsuario {

	// Atributos privados
	private ArrayList<Usuario> usu;
	private String archivo;// copia

	// Constructor
	public ArregloUsuario(String archivo) {
		usu = new ArrayList<Usuario>();
		this.archivo = archivo;// copia
		cargarUsuario();// copia

	}

	// Operaciones Publicas Basicas
	public int tamaño() {
		return usu.size();
	}

	public Usuario obtener(int i) {
		return usu.get(i);
	}

	public void adicionar(Usuario x) {
		usu.add(x);
	}

	public void eliminarAlFinal() {
		usu.remove(tamaño() - 1);
	}

	public void eliminarTodo() {
		usu.clear();
	}

	// Operaciones públicas complementarias
	public Usuario buscar(String codigo) {
		Usuario x;
		for (int i = 0; i < tamaño(); i++) {
			x = obtener(i);
			if (x.getIdUsuario() == codigo)
				return x;
		}
		return null;
	}

	public void eliminar(Usuario x) {
		usu.remove(x);
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
	public void grabarUsuario() {
		try {
			PrintWriter pw;
			String linea;
			Usuario x;
			pw = new PrintWriter(new FileWriter(archivo));
			for (int i = 0; i < tamaño(); i++) {
				x = obtener(i);
				linea = x.getIdUsuario() + ";" + x.getNombres() + ";" + x.getApellidoPaterno() + ";"
						+ x.getApellidoMaterno() + ";" + x.getLogin() + ";" + x.getPasword() + ";" + x.getTipoEmpleado()
						+ ";" + x.getTurno();
				pw.println(linea);

			}
			pw.close();
		}
		catch (Exception e) {
		}
	}

	public void cargarUsuario() {
		try {
			BufferedReader br;
			String linea, IdUsuario, apellidoPaterno, apellidoMaterno, nombres, login, pasword;
			String[] s;
			int tipoEmpleado, turno;
			br = new BufferedReader(new FileReader(archivo));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				IdUsuario = s[0].trim();
				nombres = s[1].trim();
				apellidoPaterno = s[2].trim();
				apellidoMaterno = s[3].trim();
				login = s[4].trim();
				pasword = s[5].trim();
				tipoEmpleado = Integer.parseInt(s[6].trim());
				turno = Integer.parseInt(s[7].trim());
				adicionar(new Usuario(IdUsuario, nombres, apellidoPaterno, apellidoMaterno, login, pasword,
						tipoEmpleado, turno));
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
