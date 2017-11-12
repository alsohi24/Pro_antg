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

import clases.Pedido;
import clases.Piqueo;
import clases.Pedido;
import gui.DPiqueos;



  //ATRIBUTO PRIVADO
public class ArregloPedido {
	
	private String nombreArchivo = "pedidos.txt"; 
	private ArrayList<Pedido> ped = new ArrayList<Pedido>();
	private BufferedReader br;
	private PrintWriter pw;
		
	public ArregloPedido(){
		
		ped = new ArrayList<Pedido>();
				
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
		return ped.size();
	}
	public Pedido obtener(int i){
		return ped.get(i);
	}
	public void agregar(Pedido pedido){
		ped.add(pedido);
		actualizarArchivo();
		actualizarArrayList();
	}
	
	
	public void reemplazar(Pedido pedido, int indice){
		ped.remove(indice);
		ped.add(indice, pedido);
		actualizarArchivo();
		actualizarArrayList();
	}
	

    public void eliminar(int indice){
    	ped.remove(indice);
    	actualizarArchivo();
    	actualizarArrayList();
    	
    }
    
  //OBTENER 
    
    public int codigoCorrelativo(){
	  
	  if (ped.size()>0){
		  return ped.get(ped.size()-1).getIdPedido()+1;
	  }
	  else {
		  return Pedido.COD_PRE;
	  }
  }
   
    private void actualizarArrayList() {
		
		ped = new ArrayList<Pedido>();
		
		try{				
			br = new BufferedReader(new FileReader(nombreArchivo));
			
			String linea;	
							
			while ((linea = br.readLine()) != null){
				
			String[] datos = linea.split(";");
			
			int codigo = Integer.parseInt(datos[0]);
			
			String fecha = datos[1];
			
			int idUsuario = Integer.parseInt(datos[2]);
			
			int idCliente = Integer.parseInt(datos[3]);
			
			int numCanciones = Integer.parseInt(datos[4]);
			
			ArrayList<Integer> canciones = new ArrayList<Integer>();
			
			//Obtengo las canciones
			for(int i=0;i<numCanciones;i++){
				
				canciones.add(Integer.parseInt(datos[5+i]));				
				
			}
			
			int numBebidas = Integer.parseInt(datos[5+numCanciones]);
			
			ArrayList<Integer> bebidas = new ArrayList<Integer>();
			
			//Obtengo las bebidas
			for(int i=0;i<numBebidas;i++){
				
				bebidas.add(Integer.parseInt(datos[6+numCanciones+i]));				
				
			}
			
			int numPiqueos = Integer.parseInt(datos[6+numCanciones+numBebidas]);
			
			ArrayList<Integer> piqueos = new ArrayList<Integer>();
			
			//Obtengo los piqueos
			for(int i=0;i<numPiqueos;i++){
				
				piqueos.add(Integer.parseInt(datos[7+numCanciones+numBebidas+i]));				
				
			}
			
			int estado = Integer.parseInt(datos[7+numCanciones+numBebidas+numPiqueos]);
			//System.out.println(codigo +";"+ fecha+";"+ idUsuario+";" +idCliente+";"+ canciones+";"+ bebidas+";"+ piqueos+";"+ estado);
			//System.out.println(numCanciones+";"+numBebidas+";"+numPiqueos);
			ped.add(new Pedido(codigo, fecha, idUsuario, idCliente, canciones, bebidas, piqueos, estado));
			
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
			//Los archivos tendrán esta estructura:
			//idPedido;fechaPedido;idUsuario;numeroCanciones;cancion[1-n];numeroBebidas...
			for(int i=0;i<ped.size();i++){
				
				//Obtengo las canciones
				StringBuilder canciones = new StringBuilder();
				for(int a=0;a<ped.get(i).getCanciones().size();a++){
					canciones.append((ped.get(i).getCanciones().get(a)));
					canciones.append(";");
				}
				
				//Obtengo las bebidas
				StringBuilder bebidas = new StringBuilder();
				for(int a=0;a<ped.get(i).getBebidas().size();a++){
					bebidas.append((ped.get(i).getBebidas().get(a)));
					bebidas.append(";");
				}
				
				//Obtengo los piqueos
				StringBuilder piqueos = new StringBuilder();
				for(int a=0;a<ped.get(i).getPiqueos().size();a++){
					piqueos.append((ped.get(i).getPiqueos().get(a)));					
					piqueos.append(";");
				}
				
				pw.println(ped.get(i).getIdPedido()+";"+
						ped.get(i).getFechaPedido()+";"+
						ped.get(i).getIdUsuario()+";"+
						ped.get(i).getIdCliente()+";"+
						ped.get(i).getCanciones().size()+";"+
						canciones.toString()+
						ped.get(i).getBebidas().size()+";"+
						bebidas.toString()+
						ped.get(i).getPiqueos().size()+";"+
						piqueos.toString()+
						ped.get(i).getEstado());			
				}
			
			pw.close();
			br.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	
    	
    }

}
