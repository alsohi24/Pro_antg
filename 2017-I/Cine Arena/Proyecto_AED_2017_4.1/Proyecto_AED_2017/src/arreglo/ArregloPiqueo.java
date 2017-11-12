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

import clases.Piqueo;
import gui.DPiqueos;



  //ATRIBUTO PRIVADO
public class ArregloPiqueo {
	
	private String nombreArchivo = "piqueos.txt"; 
	private ArrayList<Piqueo> piq = new ArrayList<Piqueo>();
	private BufferedReader br;
	private PrintWriter pw;
	
	
	public ArregloPiqueo(){
		
		piq = new ArrayList<Piqueo>();
		
		File archivo = new File(nombreArchivo);
		
		if (!(archivo.exists())){
		
		actualizarArrayList();
				
		}
		else {
		actualizarArrayList();
		actualizarArchivo();
		}
		/*
		piq = new ArrayList<Piqueo>();
		piq.add(new Piqueo(1001, "Nombre1", 0, 12.00,0));
		piq.add(new Piqueo(1002, "Nombre2", 1, 23.00,2));
		piq.add(new Piqueo(1003, "Nombre3", 2, 33.00,1));
		piq.add(new Piqueo(1004, "Nombre4", 3, 13.00,2));
		piq.add(new Piqueo(1005, "Nombre5", 4, 14.00,1));
		*/
	}
	
	
	//OPERACIONES PUBLICAS BASICAS
	
	public int tamaño(){
		return piq.size();
	}
	public Piqueo obtener(int i){
		return piq.get(i);
	}
	public void agregar(Piqueo piqueo){
		piq.add(piqueo);
		actualizarArchivo();
		actualizarArrayList();
	}
	
	
	public void reemplazar(Piqueo piqueo, int indice){
		piq.remove(indice);
		piq.add(indice, piqueo);
		actualizarArchivo();
		actualizarArrayList();
	}
	

    public void eliminar(int indice){
    	piq.remove(indice);
    	actualizarArchivo();
    	actualizarArrayList();
    	
    }
    
  //OBTENER 
    
    public int codigoCorrelativo(){
	  
	  if (piq.size()>0){
		  return piq.get(piq.size()-1).getidPiqueo()+1;
	  }
	  else {
		  return Piqueo.COD_PRE;
	  }
  }
   
    private void actualizarArrayList() {
		
		piq = new ArrayList<Piqueo>();
		
		try{				
			br = new BufferedReader(new FileReader(nombreArchivo));
			
			String linea;	
							
			while ((linea = br.readLine()) != null){
				
			String[] datos = linea.split(";");
			
			int codigo = Integer.parseInt(datos[0]);
			
			String nombre = datos[1];
			
			int tipo = Integer.parseInt(datos[2]);
			
			double precio = Double.parseDouble(datos[3]);
			
			int estado = Integer.parseInt(datos[4]);
							
			piq.add(new Piqueo(codigo, nombre, tipo, precio, estado));
			
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
			
			for(int i=0;i<piq.size();i++){
				
				pw.println(piq.get(i).getidPiqueo()+";"+
						piq.get(i).getNombre()+";"+
						piq.get(i).getTipoPiqueo()+";"+
						piq.get(i).getPrecio()+";"+
						piq.get(i).getEstado());
				
			}
			
			pw.close();
			br.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	
    	
    }

}

