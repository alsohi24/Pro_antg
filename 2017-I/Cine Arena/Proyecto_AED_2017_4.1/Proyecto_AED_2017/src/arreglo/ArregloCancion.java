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

import clases.Cancion;
import clases.Usuario;


  //ATRIBUTO PRIVADO
public class ArregloCancion {
	
	private String nombreArchivo = "canciones.txt"; 
	private ArrayList<Cancion> can = new ArrayList<Cancion>();
	private BufferedReader br;
	private PrintWriter pw;
	
	
	public ArregloCancion(){
		
		can = new ArrayList<Cancion>();
		
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
		return can.size();
	}
	public Cancion obtener(int i){
		return can.get(i);
	}
	public void agregar(Cancion cancion){
		can.add(cancion);
		actualizarArchivo();
		actualizarArrayList();
	}
	
	
	public void reemplazar(Cancion cancion, int indice){
		can.remove(indice);
		can.add(indice, cancion);
		actualizarArchivo();
		actualizarArrayList();
	}
	

    public void eliminar(int indice){
    	can.remove(indice);
    	actualizarArchivo();
    	actualizarArrayList();
    	
    }
    
  //OBTENER 
    
    public int codigoCorrelativo(){
	  
	  if (can.size()>0){
		  return can.get(can.size()-1).getidCancion() +1 ;
	  }
	  else {
		  return Cancion.COD_PRE;
	  }
  }
   
    private void actualizarArrayList() {
		
		can = new ArrayList<Cancion>();
		
		try{				
			br = new BufferedReader(new FileReader(nombreArchivo));
			
			String linea;	
							
			while ((linea = br.readLine()) != null){
				
			String[] datos = linea.split(";");
			
			int codigo = Integer.parseInt(datos[0]);
			
			String nombre = datos[1];
			
			String duracion =datos[2];
			
			int idArtista = Integer.parseInt(datos[3]);
			
			String Album = datos[4];
			
			int numeroReproduccion = Integer.parseInt(datos[5]);
			
			int estado =Integer.parseInt(datos[6]);
							
			can.add(new Cancion(codigo, nombre, duracion , idArtista, Album, numeroReproduccion, estado));
			
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
			
			for(int i=0;i<can.size();i++){
				
				pw.println(can.get(i).getidCancion()+";"+
						can.get(i).getnombre()+";"+
						can.get(i).getduracion()+";"+
						can.get(i).getidArtista()+";"+
						can.get(i).getalbum()+";"+
						can.get(i).getnumeroReproducciones()+";"+
						can.get(i).getestado());
				
			}
			
			pw.close();
			br.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	
    	
    }

}