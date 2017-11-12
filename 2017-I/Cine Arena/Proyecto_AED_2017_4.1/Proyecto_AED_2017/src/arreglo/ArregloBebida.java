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
import clases.Piqueo;
import clases.Usuario;
import gui.DPiqueos;



  //ATRIBUTO PRIVADO
public class ArregloBebida {
	
	private String nombreArchivo = "bebidas.txt"; 
	private ArrayList<Bebida> beb = new ArrayList<Bebida>();
	private BufferedReader br;
	private PrintWriter pw;
	
	
	public ArregloBebida(){
		
		beb = new ArrayList<Bebida>();
		
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
		return beb.size();
	}
	public Bebida obtener(int i){
		return beb.get(i);
	}
	public void agregar(Bebida bebida){
		beb.add(bebida);
		actualizarArchivo();
		actualizarArrayList();
	}
	
	
	public void reemplazar(Bebida bebida, int indice){
		beb.remove(indice);
		beb.add(indice, bebida);
		actualizarArchivo();
		actualizarArrayList();
	}
	

    public void eliminar(int indice){
    	beb.remove(indice);
    	actualizarArchivo();
    	actualizarArrayList();
    	
    }
    
  //OBTENER 
    
    public int codigoCorrelativo(){
	  
	  if (beb.size()>0){
		  return beb.get(beb.size()-1).getIdBebida()+1;
	  }
	  else {
		  return Bebida.COD_PRE;
	  }
  }
   
    private void actualizarArrayList() {
		
		beb = new ArrayList<Bebida>();
		
		try{				
			br = new BufferedReader(new FileReader(nombreArchivo));
			
			String linea;	
							
			while ((linea = br.readLine()) != null){
				
			String[] datos = linea.split(";");
			
			int codigo = Integer.parseInt(datos[0]);
			
			int marca = Integer.parseInt(datos[1]);
			
			double precio = Double.parseDouble(datos[2]);
			
			int tipo = Integer.parseInt(datos[3]);
			
			int estado = Integer.parseInt(datos[4]);
							
			beb.add(new Bebida(codigo, marca, precio, tipo, estado));
			
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
			
			for(int i=0;i<beb.size();i++){
				
				pw.println(beb.get(i).getIdBebida()+";"+
						beb.get(i).getMarca()+";"+
						beb.get(i).getPrecio()+";"+
						beb.get(i).getTipoBebida()+";"+
						beb.get(i).getEstado());			
			}
			
			pw.close();
			br.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	
    	
    }

}
