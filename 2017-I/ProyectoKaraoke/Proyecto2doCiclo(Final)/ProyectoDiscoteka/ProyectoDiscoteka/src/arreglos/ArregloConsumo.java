package arreglos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import clases.Consumo;

public class ArregloConsumo {
	ArrayList<Consumo> con;
	private String archivo;

	public ArregloConsumo(String archivo) {

		con = new ArrayList<Consumo>();
		this.archivo = archivo;
		cargarConsumo();
	}

	public int tamaño() {
		return con.size();
	}

	public Consumo obtener(int a) {
		return con.get(a);
	}

	public void adicionar(Consumo p) {
		con.add(p);
	}

	public Consumo buscar(String codigo) {
		Consumo x;
		for (int i = 0; i < tamaño(); i++) {
			x = obtener(i);
			if (x.getCodigoCliente().equals(codigo))
				return x;
		}
		return null;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

	public String getArchivo() {
		return archivo;
	}

	public void grabarConsumo() {
		try {
			PrintWriter pw;
			String linea;
			Consumo x;
			pw = new PrintWriter(new FileWriter(archivo));
			for (int i = 0; i < tamaño(); i++) {
				x = obtener(i);
				linea = x.getCodigoConsumo() + ";" + x.getCodigoCliente() + ";" + x.getCodigoUsuario() + ";"
						+ x.getFechaConsumo() + ";" + x.getImportePagar() + ";" + x.getEstado();
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
		}
	}

	public void cargarConsumo() {
		try {
			BufferedReader br;
			String linea, CodigoConsumo, CodigoCliente, CodigoUsuario, FechaConsumo;
			String[] s;
			double ImportePagar;
			int Estado;
			br = new BufferedReader(new FileReader(archivo));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				CodigoConsumo = s[0].trim();
				CodigoCliente = s[1].trim();
				CodigoUsuario = s[2].trim();
				FechaConsumo = s[3].trim();
				ImportePagar = Double.parseDouble(s[4].trim());
				Estado = Integer.parseInt(s[5].trim());
				adicionar(new Consumo(CodigoConsumo, CodigoCliente, CodigoUsuario, FechaConsumo, ImportePagar, Estado));
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
