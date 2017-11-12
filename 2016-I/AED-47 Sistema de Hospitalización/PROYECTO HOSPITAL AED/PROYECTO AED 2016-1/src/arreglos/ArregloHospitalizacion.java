package arreglos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import clases.Hospitalizacion;

public class ArregloHospitalizacion {

	// Atributo privado
	private ArrayList<Hospitalizacion> hos;
	private String archivo;

	// Constructor
	public ArregloHospitalizacion(String archivo) {
		hos = new ArrayList<Hospitalizacion>();
		this.archivo = archivo;
		cargarHospitalizacion();
	}

	// Operaciones públicas
	public void adicionar(Hospitalizacion h) {
		hos.add(h);
	}

	public Hospitalizacion obtener(int pos) {
		return hos.get(pos);
	}

	public int tamaño() {
		return hos.size();
	}

	public void eliminar(Hospitalizacion x) {
		hos.remove(x);
	}

	public Hospitalizacion buscar(int CodHosp) {
		Hospitalizacion x;
		for (int i = 0; i < tamaño(); i++) {
			x = obtener(i);
			if (x.getCodHosp() == CodHosp)
				return x;
		}
		return null;
	}

	public int codigoCorrelativo() {
		if (tamaño() == 0)
			return 1000001;
		else
			return obtener(tamaño() - 1).getCodHosp() + 1;
	}

	public String getArchivo() {
		return archivo;
	}

	public void eliminarAlFinal() {
		if (tamaño() > 0)
			hos.remove(tamaño() - 1);
	}

	public void eliminarTodo() {
		if (tamaño() > 0)
			hos.clear();
	}

	public void grabarHospitalizacion() {
		try {
			PrintWriter pw;
			String linea;
			Hospitalizacion x;
			pw = new PrintWriter(new FileWriter(archivo));
			for (int i = 0; i < tamaño(); i++) {
				x = obtener(i);
				linea = x.getCodHosp() + ";" + x.getCodPaci() + ";" + x.getCodEmpl() + ";" + x.getNumCama() + ";"
						+ x.getFecLleg() + ";" + x.getHorLleg() + ";" + x.getFecSali() + ";" + x.getHorSali() + ";"
						+ x.getEstado();
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
		}
	}

	public void cargarHospitalizacion() {
		try {
			BufferedReader br;

			String linea, s[];
			int CodHosp, CodPaci, CodEmpl, NumCama, FecLleg, HorLleg, FecSali, HorSali, Estado;

			Hospitalizacion nuevo;
			br = new BufferedReader(new FileReader(archivo));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				CodHosp = Integer.parseInt(s[0].trim());
				CodPaci = Integer.parseInt(s[1].trim());
				CodEmpl = Integer.parseInt(s[2].trim());
				NumCama = Integer.parseInt(s[3].trim());
				FecLleg = Integer.parseInt(s[4].trim());
				HorLleg = Integer.parseInt(s[5].trim());
				FecSali = Integer.parseInt(s[6].trim());
				HorSali = Integer.parseInt(s[7].trim());
				Estado = Integer.parseInt(s[8].trim());

				nuevo = new Hospitalizacion(CodHosp, CodPaci, CodEmpl, NumCama, FecLleg, HorLleg, FecSali, HorSali,
						Estado);
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
