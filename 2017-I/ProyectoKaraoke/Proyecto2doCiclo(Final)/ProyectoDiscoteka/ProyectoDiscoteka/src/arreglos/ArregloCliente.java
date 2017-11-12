package arreglos;

import java.util.ArrayList;
import java.io.*;

import clases.Cliente;


public class ArregloCliente {

	// Atributo privado
	private ArrayList<Cliente> cli;
	private String archivo;// copia
	
	// Constructor
	public ArregloCliente(String archivo) {
		cli = new ArrayList<Cliente>();
		this.archivo = archivo;// copia
		cargarCliente();// copia
	}

	// Operaciones Publicas Basicas
	public int tamaño() {
		return cli.size();
	}

	public Cliente obtener(int i) {
		return cli.get(i);
	}

	public void adicionar(Cliente x) {
		cli.add(x);
	}

	public void eliminarAlFinal() {
		cli.remove(tamaño() - 1);
	}

	public void eliminarTodo() {
		cli.clear();
	}

	// Operaciones públicas complementarias
	public Cliente buscar(String codigo) {
		for (int i = 0; i < tamaño(); i++)
			if (obtener(i).getCliente() == codigo)
				return obtener(i);
		return null;
	}

	public void eliminar(Cliente x) {
		cli.remove(x);
	}

	// Operaciones para Archivo
		public void setArchivo(String archivo) {
			this.archivo = archivo;
		}

		public String getArchivo() {
			return archivo;
		}
		// ***********************
		
		
		// para trabajar archivo*************************************
		public void grabarCliente() {
			try {
				PrintWriter pw;
				String linea;
				Cliente x;
				pw = new PrintWriter(new FileWriter(archivo));
				for (int i = 0; i < tamaño(); i++) {
					x = obtener(i);
					linea = x.getCliente() + ";" +
							x.getNombre() + ";" + 
							x.getApPateno() + ";" +
							x.getApMaterno() + ";" + 
							x.getDireccion() + ";" + 
							x.getTelefono() + ";" + 
							x.getDni() + ";" +
							x.getFechaDeNacimiento() + ";" +
							x.getFechaDeAfiliacion() + ";" +
							x.getTipoEstadoCivil() + ";" +
							x.getTipoDeCliente()+ ";" +
							x.getUsuario() ;
					pw.println(linea);

					/*
					 * Cli0001;
					 * Anthony;
					 * Villavicencio;
					 * Caro;
						ucyana - Carabayllo;
						972031481;
						43798379;
						Anthony;
						25/07/1986;
						01/07/2017;
						asado;

					 * 
					 * 
					 * */

				}
				pw.close();
			}
			catch (Exception e) {
			}
		}

		public void cargarCliente() {
			try {
				BufferedReader br;
				String linea, cliente, apMaterno, apPaterno, nombre, direccion, telefono, dni, fechaNacimiento,
				fechaAfiliacion, idUsuario;
				String[] s;
				int tipoDeCliente, tipoestadoCivil;
				
				// Cliente(String cliente, String nombre, String apPaterno, String apMaterno, String direccion, String telefono,
				// String dni, String usuario, String fechaNacimiento, String fechaAfiliacion, String estadoCivil,
				// int tipoDeCliente)
				
				
				br = new BufferedReader(new FileReader(archivo));
				while ((linea = br.readLine()) != null) {
					s = linea.split(";");
					cliente = s[0].trim();
					apMaterno = s[1].trim();
					apPaterno = s[2].trim();
					nombre = s[3].trim();
					direccion = s[4].trim();
					telefono = s[5].trim();
					dni = s[6].trim();
					fechaNacimiento = s[7].trim();
					fechaAfiliacion = s[8].trim();
					tipoestadoCivil = Integer.parseInt(s[9].trim());
					tipoDeCliente = Integer.parseInt(s[10].trim());
					idUsuario = s[11].trim();
					adicionar(new Cliente(cliente, apMaterno, apPaterno, nombre, direccion, telefono, dni, fechaNacimiento,
							fechaAfiliacion, tipoestadoCivil, tipoDeCliente, idUsuario));
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
