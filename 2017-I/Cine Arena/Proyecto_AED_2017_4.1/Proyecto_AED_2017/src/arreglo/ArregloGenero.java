package arreglo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import clases.Bebida;
import clases.Genero;
import clases.Piqueo;
import gui.DPiqueos;



  //ATRIBUTO PRIVADO
public class ArregloGenero {
	
	private String nombreArchivo = "generos.txt"; 
	private ArrayList<Genero> gen = new ArrayList<Genero>();
	private BufferedReader br;
	private PrintWriter pw;
	
	
	public ArregloGenero(){
		
		gen = new ArrayList<Genero>();
		
		File archivo = new File(nombreArchivo);
		
		if (!(archivo.exists())){
		
		actualizarArrayList();
				
		}
		else {
		actualizarArrayList();
		actualizarArchivo();
		}
	
	}
	
	
	//OPERACIONES PUBLICAS BASICAS
	
	public int tamaño(){
		return gen.size();
	}
	public Genero obtener(int i){
		return gen.get(i);
	}
	public void agregar(Genero genero){
		gen.add(genero);
		actualizarArchivo();
		actualizarArrayList();
	}
	
	
	public void reemplazar(Genero genero, int indice){
		gen.remove(indice);
		gen.add(indice, genero);
		actualizarArchivo();
		actualizarArrayList();
	}
	

    public void eliminar(int indice){
    	gen.remove(indice);
    	actualizarArchivo();
    	actualizarArrayList();
    	
    }
    
  //OBTENER 
    
    public int codigoCorrelativo(){
	  
	  if (gen.size()>0){
		  return gen.get(gen.size()-1).getidGenero()+1;
	  }
	  else {
		  return Genero.COD_PRE;
	  }
  }
   
    private void actualizarArrayList() {
		
		gen = new ArrayList<Genero>();
		
		try{				
			br = new BufferedReader(new FileReader(nombreArchivo));
			
			String linea;	
							
			while ((linea = br.readLine()) != null){
				
			String[] datos = linea.split(";");
			
			int codigo = Integer.parseInt(datos[0]);
			
			String descripcion = datos[1];
			
			String procedencia = datos[2];
			
			String epoca = datos[3];
			
			int estado = Integer.parseInt(datos[4]);
							
			gen.add(new Genero(codigo, descripcion, procedencia, epoca, estado));
			
			}
			
			br.close();
							
			} catch (Exception e) {
				
				try {
					pw = new PrintWriter(new FileWriter(nombreArchivo));
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		
	}
    
    private void actualizarArchivo(){
    	
    	try {
			pw = new PrintWriter(new FileWriter(nombreArchivo));
			br = new BufferedReader(new FileReader(nombreArchivo));
			
			while(br.readLine()!=null){
				
				pw.println("");
				
			}
			
			for(int i=0;i<gen.size();i++){
				
				pw.println(gen.get(i).getidGenero()+";"+
						gen.get(i).getdescripcion()+";"+
						gen.get(i).getprocedencia()+";"+
						gen.get(i).getepoca()+";"+
						gen.get(i).getestado());			
			}
			
			pw.close();
			br.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	
    	
    }

}
