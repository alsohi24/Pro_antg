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

import clases.Consumo;

  //ATRIBUTO PRIVADO
public class ArregloConsumo {
	
	private String nombreArchivo = "consumos.txt"; 
	private ArrayList<Consumo> con = new ArrayList<Consumo>();
	private BufferedReader br;
	private PrintWriter pw;
	
	
	public ArregloConsumo(){
		
		con = new ArrayList<Consumo>();
		
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
		return con.size();
	}
	public Consumo obtener(int i){
		return con.get(i);
	}
	public void agregar(Consumo consumo){
		con.add(consumo);
		actualizarArchivo();
		actualizarArrayList();
	}
	
	
	public void reemplazar(Consumo consumo, int indice){
		con.remove(indice);
		con.add(indice, consumo);
		actualizarArchivo();
		actualizarArrayList();
	}
	

    public void eliminar(int indice){
    	con.remove(indice);
    	actualizarArchivo();
    	actualizarArrayList();
    	
    }
    
  //OBTENER 
    
    public int codigoCorrelativo(){
	  
	  if (con.size()>0){
		  return con.get(con.size()-1).getCodConsumo()+1;
	  }
	  else {
		  return Consumo.COD_PRE;
	  }
  }
   
    private void actualizarArrayList() {
		
		con = new ArrayList<Consumo>();
		
		try{				
			br = new BufferedReader(new FileReader(nombreArchivo));
			
			String linea;	
							
			while ((linea = br.readLine()) != null){
				
			String[] datos = linea.split(";");
			
			int codigo = Integer.parseInt(datos[0]);
			
			int idCliente = Integer.parseInt(datos[1]);
			
			String fecha = datos[2];
			
			double total = Double.parseDouble(datos[3]);
			
			int estado = Integer.parseInt(datos[4]);
							
			con.add(new Consumo(codigo, idCliente, fecha, total, estado));
			
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
			
			for(int i=0;i<con.size();i++){
				
				pw.println(con.get(i).getCodConsumo()+";"+
						con.get(i).getIdCliente()+";"+
						con.get(i).getFecha()+";"+
						con.get(i).getTotal()+";"+
						con.get(i).getEstado());			
			}
			
			pw.close();
			br.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	
    	
    }

}
