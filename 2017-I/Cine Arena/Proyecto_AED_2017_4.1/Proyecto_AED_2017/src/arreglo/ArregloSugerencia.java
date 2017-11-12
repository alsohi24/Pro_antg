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
import clases.Sugerencia;



//ATRIBUTO PRIVADO
public class ArregloSugerencia {
	
	private String nombreArchivo ="sugerencia.txt";
	private ArrayList<Sugerencia> sug= new ArrayList<Sugerencia>();
	private BufferedReader br;
	private PrintWriter pw;
	
	public ArregloSugerencia(){
		
	sug = new ArrayList<Sugerencia>();
		File archivo = new File(nombreArchivo);
		
		if (!(archivo.exists())){
		
		insertarPredeterminado();
		actualizarArrayList();
		
		}
		else {
		actualizarArrayList();
		//actualizarArchivo();
		}
		
		
	}
	
	//operaciones publicas basicas
	public int tamaño(){
		return sug.size();
	}
	public Sugerencia obtener(int i){
		return sug.get(i);
	}
	public void agregar(Sugerencia sugerencia){
		sug.add(sugerencia);
		actualizarArchivo();
		actualizarArrayList();
	}
	
	
	public void reemplazar(Sugerencia sugerencia, int indice){
		sug.remove(indice);
		sug.add(indice, sugerencia);
		actualizarArchivo();
		actualizarArrayList();
	}
	

    public void eliminar(int indice){
    	sug.remove(indice);
    	actualizarArchivo();
    	actualizarArrayList();
    	
    }



    //OBTENER 
       
       public int codigoCorrelativo(){
   	  
   	  if (sug.size()>0){
   		  return sug.get(sug.size()-1).getIdSugerencia()+1;
   	  }
   	  else {
   		  return Sugerencia.COD_PRE;
   	  }
     }
      
       private void actualizarArrayList() {
   		
   		sug = new ArrayList<Sugerencia>();
   		
   		try{				
   			br = new BufferedReader(new FileReader(nombreArchivo));
   			
   			String linea;	
   							
   			while ((linea = br.readLine()) != null){
   				
   			String[] datos = linea.split(";");
   			
   			int codigo = Integer.parseInt(datos[0]);
   			
   			String detalle = datos[1];
   			   				
   			int idUsuario = Integer.parseInt(datos[2]);
   						
   			int tipoSugerencia = Integer.parseInt(datos[3]);
   							
   			sug.add(new Sugerencia(codigo,detalle, idUsuario,tipoSugerencia));
   			
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
   			
   			for(int i=0;i<sug.size();i++){
   				
   				pw.println(sug.get(i).getIdUsuario()+";"+
   						sug.get(i).getDetalle()+";"+
   						sug.get(i).getIdUsuario()+";"+
   						sug.get(i).getTipoSugerencia());
   						
   			}
   			
   			pw.close();
   			br.close();
   			
   			
   		} catch (IOException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}
       
       	}
       	
   	private void insertarPredeterminado(){

   		try {
   			pw = new PrintWriter(new FileWriter(nombreArchivo));
   			pw.println(Sugerencia.COD_PRE+";rojas;rojas;arena;arena;bella;0;0");
   		} catch (IOException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}
   		
   		pw.close();
   	}
}