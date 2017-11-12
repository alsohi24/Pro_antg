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

import clases.Artista;
import clases.Piqueo;
import clases.Usuario;
import gui.DPiqueos;



  //ATRIBUTO PRIVADO
public class ArregloArtista {
	
	private String nombreArchivo = "artistas.txt"; 
	private ArrayList<Artista> art = new ArrayList<Artista>();
	private BufferedReader br;
	private PrintWriter pw;
	
	
	public ArregloArtista(){
		
		art = new ArrayList<Artista>();
		
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
		return art.size();
	}
	public Artista obtener(int i){
		return art.get(i);
	}
	public void agregar(Artista artista){
		art.add(artista);
		actualizarArchivo();
		actualizarArrayList();
	}
	
	
	public void reemplazar(Artista artista, int indice){
		art.remove(indice);
		art.add(indice, artista);
		actualizarArchivo();
		actualizarArrayList();
	}
	

    public void eliminar(int indice){
    	art.remove(indice);
    	actualizarArchivo();
    	actualizarArrayList();
    	
    }
    
  //OBTENER 
    
    public int codigoCorrelativo(){
	  
	  if (art.size()>0){
		  return art.get(art.size()-1).getidArtista()+1;
	  }
	  else {
		  return Artista.COD_PRE;
	  }
  }
   
    private void actualizarArrayList() {
		
		art = new ArrayList<Artista>();
		
		try{				
			br = new BufferedReader(new FileReader(nombreArchivo));
			
			String linea;	
							
			while ((linea = br.readLine()) != null){
				
			String[] datos = linea.split(";");
			
			int codigo = Integer.parseInt(datos[0]);
			
			String nombreArtistico = datos[1];
			
			int idGenero = Integer.parseInt(datos[2]);
			
			String fechaRegistro = datos[3];
			
			int estado = Integer.parseInt(datos[4]);
							
			art.add(new Artista(codigo, nombreArtistico, idGenero, fechaRegistro, estado));
			
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
			
			for(int i=0;i<art.size();i++){
				
				pw.println(art.get(i).getidArtista()+";"+
						art.get(i).getNombreArtistico()+";"+
						art.get(i).getidGenero()+";"+
						art.get(i).getfechaRegistroCatalogo()+";"+
						art.get(i).getestado());			
			}
			
			pw.close();
			br.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	
    	
    }

}
