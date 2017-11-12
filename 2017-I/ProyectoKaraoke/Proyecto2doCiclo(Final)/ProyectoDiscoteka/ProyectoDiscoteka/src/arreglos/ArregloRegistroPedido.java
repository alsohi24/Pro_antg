package arreglos;

import java.util.ArrayList;
import java.io.*;
import clases.RegistroPedido;


public class ArregloRegistroPedido {

	// Atributo privado
	private ArrayList<RegistroPedido> rp;
	private String archivo;// copia

	// Constructor
	public ArregloRegistroPedido(String archivo) {
		rp = new ArrayList<RegistroPedido>();
		this.archivo = archivo;// copia
		cargarRegistroPedido();// copia
	}

	// Operaciones Publicas Basicas
	public int tamaño() {
		return rp.size();
	}

	public RegistroPedido obtener(int i) {
		return rp.get(i);
	}

	public void adicionar(RegistroPedido x) {
		rp.add(x);
	}

	public void eliminarAlFinal() {
		rp.remove(tamaño() - 1);
	}

	public void eliminarTodo() {
		rp.clear();
	}

	// Operaciones públicas complementarias
	public RegistroPedido buscar(String codigo) {
		for (int i = 0; i < tamaño(); i++)
			if (obtener(i).getCodigoReserva() == codigo)
				return obtener(i);
		return null;
	}

	public void eliminar(RegistroPedido x) {
		rp.remove(x);
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
		public void grabarRegistroPedido() {
			try {
				PrintWriter pw;
				String linea;
				RegistroPedido x;
				pw = new PrintWriter(new FileWriter(archivo));
				for (int i = 0; i < tamaño(); i++) {
					x = obtener(i);
					linea = 
							x.getCodigoReserva() + ";" + 
							x.getCodigoCliente() + ";" + 
							x.getCodigoUsuario() + ";" + 
							x.getCancion() + ";" + 
							x.getBebidas() + ";" + 
							x.getPiqueos() + ";" + 
							x.getEstadoReserva();
					pw.println(linea);
				}
				pw.close();
			}
			catch (Exception e) {
			}
		}

		public void cargarRegistroPedido() {
			try {
				BufferedReader br;
				String linea, codCli, codUsu, cancion, codRes, bebida, piqueo;
				String[] s;
				int estadoRes;
				br = new BufferedReader(new FileReader(archivo));
				while ((linea = br.readLine()) != null) {
					s = linea.split(";");
					codRes = s[0].trim();
					codCli = s[1].trim();
					codUsu = s[2].trim();
					cancion = s[3].trim();
					bebida = s[4].trim();
					piqueo = s[5].trim();
					estadoRes = Integer.parseInt(s[6].trim());
					adicionar(new RegistroPedido(codRes, codCli,codUsu, cancion, bebida, piqueo, estadoRes));
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
