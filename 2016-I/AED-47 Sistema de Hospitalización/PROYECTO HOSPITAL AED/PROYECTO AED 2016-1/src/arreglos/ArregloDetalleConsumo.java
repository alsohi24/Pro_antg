package arreglos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.DetalleConsumo;

public class ArregloDetalleConsumo {

	private ArrayList<DetalleConsumo> det;
	private String archivo;

	public ArregloDetalleConsumo(String archivo) {
		det = new ArrayList<DetalleConsumo>();
		this.archivo = archivo;
		cargarDetalleConsumo();
	}

	public void adicionar(DetalleConsumo d) {
		det.add(d);
	}

	public int tamaño() {
		return det.size();
	}

	public DetalleConsumo obtener(int i) {
		return det.get(i);
	}

	public void eliminar(DetalleConsumo d) {
		det.remove(d);
	}

	public DetalleConsumo buscar(int codigo) {
		DetalleConsumo c;
		for (int i = 0; i < tamaño(); i++) {
			c = obtener(i);
			if (c.getCodConsumo() == codigo)
				return c;
		}
		return null;
	}

	public String getArchivo() {
		return archivo;
	}

	public void eliminarAlFinal() {
		if (tamaño() > 0)
			det.remove(tamaño() - 1);
	}

	public void eliminarTodo() {
		if (tamaño() > 0)
			det.clear();
	}

	public void grabarDetalleConsumo() {
		try {
			PrintWriter pw;
			String linea;
			DetalleConsumo x;
			pw = new PrintWriter(new FileWriter(archivo));
			for (int i = 0; i < tamaño(); i++) {
				x = obtener(i);
				linea = x.getCodConsumo() + ";" + x.getCodProducto() + ";" + x.getCantidad() + ";"
						+ x.getPrecioUnitario() + ";" + x.getSubtotal();
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
		}
	}

	public void cargarDetalleConsumo() {
		try {
			BufferedReader br;
			String linea, s[];
			int codConsumo, codProducto, cantidad;
			double precioUnitario, subtotal;
			DetalleConsumo nuevo;
			br = new BufferedReader(new FileReader(archivo));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codConsumo = Integer.parseInt(s[0].trim());
				codProducto = Integer.parseInt(s[1].trim());
				cantidad = Integer.parseInt(s[2].trim());
				precioUnitario = Double.parseDouble(s[3].trim());
				subtotal = Double.parseDouble(s[4].trim());

				nuevo = new DetalleConsumo(codConsumo, codProducto, cantidad, precioUnitario, subtotal);
				adicionar(nuevo);
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
