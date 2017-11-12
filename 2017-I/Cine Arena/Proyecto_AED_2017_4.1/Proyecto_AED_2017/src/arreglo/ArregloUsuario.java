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
import clases.Usuario;

//ATRIBUTO PRIVADO
public class ArregloUsuario {
	
	private String nombreArchivo = "usuarios.txt"; 
	private ArrayList<Usuario> usu = new ArrayList<Usuario>();
	private BufferedReader br;
	private PrintWriter pw;
	
	
	public ArregloUsuario(){
		
		usu = new ArrayList<Usuario>();
		
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
	
	
	//OPERACIONES PUBLICAS BASICAS
	
	public int tamaño(){
		return usu.size();
	}
	public Usuario obtener(int i){
		return usu.get(i);
	}
	public Usuario obtenerPorCodigo(int codigo){
		
		for(int i=0;i<tamaño();i++){
			
			if(obtener(i).getIdUsuario()==codigo){
				
				return obtener(i);
				
			}
			
		}
		
		return null;
		
	}
	public void agregar(Usuario usuario){
		usu.add(usuario);
		actualizarArchivo();
		actualizarArrayList();
	}
	
	
	public void reemplazar(Usuario usuario, int indice){
		usu.remove(indice);
		usu.add(indice, usuario);
		actualizarArchivo();
		actualizarArrayList();
	}
	

    public void eliminar(int indice){
    	usu.remove(indice);
    	actualizarArchivo();
    	actualizarArrayList();
    	
    }
    
  //OBTENER 
    
    public int codigoCorrelativo(){
	  
	  if (usu.size()>0){
		  return usu.get(usu.size()-1).getIdUsuario()+1;
	  }
	  else {
		  return Usuario.COD_PRE;
	  }
  }
   
    private void actualizarArrayList() {
		
		usu = new ArrayList<Usuario>();
		
		try{				
			br = new BufferedReader(new FileReader(nombreArchivo));
			
			String linea;	
							
			while ((linea = br.readLine()) != null){
				
			String[] datos = linea.split(";");
			
			int codigo = Integer.parseInt(datos[0]);
			
			String appat = datos[1];
			
			String apmat = datos[2];
			
			String nombres = datos[3];
			
			String login = datos[4];
			
			String pass = datos[5];
			
			int tipo = Integer.parseInt(datos[6]);
						
			int turno = Integer.parseInt(datos[7]);
							
			usu.add(new Usuario(codigo, appat, apmat, nombres, login, pass, tipo, turno));
			
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
			
			for(int i=0;i<usu.size();i++){
				
				pw.println(usu.get(i).getIdUsuario()+";"+
						usu.get(i).getApellidoPaterno()+";"+
						usu.get(i).getApellidoMaterno()+";"+
						usu.get(i).getNombres()+";"+
						usu.get(i).getLogin()+";"+
						usu.get(i).getPassword()+";"+
						usu.get(i).getTipoEmpleado()+";"+
						usu.get(i).getTurno());				
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
			pw.println(Usuario.COD_PRE+";rojas;rojas;arena;arena;bella;0;0");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		pw.close();
		
    }
	
}


