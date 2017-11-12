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
import clases.Cliente;

//AP
public class ArregloCliente {
	
	private String nombreArchivo = "clientes.txt";
	private ArrayList<Cliente> cli = new ArrayList<Cliente>();
	private BufferedReader br;
	private PrintWriter pw;
	
	public ArregloCliente(){
		
		cli = new ArrayList<Cliente>();
		
		File archivo = new File(nombreArchivo);
		
		if (!(archivo.exists())){
			
			actualizarArraylist();
			
		}
		else {
		actualizarArraylist();
		actualizarArchivo();
		}
	}
	
	//operaciones publicas basicas
	public int tamaño(){
		return cli.size();
	}
	public Cliente obtener(int i){
		return cli.get(i);
	}
	public void agregar(Cliente cliente){
		cli.add(cliente);
		actualizarArchivo();
		actualizarArraylist();
	}
	public void reemplazar(Cliente cliente, int indice){
		cli.remove(indice);
		cli.add(indice, cliente);
		actualizarArchivo();
		actualizarArraylist();
	}
	public void eliminar(int indice){
		cli.remove(indice);
		actualizarArchivo();
		actualizarArraylist();
	}
	
	//obtener
	
	public int codigoCorrelativo(){
		
		if(cli.size()>0){
			return cli.get(cli.size()-1).getIdCliente()+1;
		}
		else {
			return Cliente.COD_PRE;
		}
	}
	
	private void actualizarArraylist(){
		
		cli = new ArrayList<Cliente>();
		
		try{
			br = new BufferedReader(new FileReader(nombreArchivo));
			
			String linea;
			
			while((linea = br.readLine()) !=null){
				
			String[] datos = linea.split(";");
			
			int idCli = Integer.parseInt(datos[0]);
			
			String appat = datos [1];
			
			String apmat = datos [2];
			
			String nomb = datos [3];
			
			String dir = datos [4];
			
			String fechnac = datos [5];
			
			String fechafili = datos [6];
			
			int estciv = Integer.parseInt(datos [7]);
			
			String telef = datos [8];
			
			String dni = datos [9];
			
			int tipo = Integer.parseInt(datos[10]);
			
			String usu = datos [11];
			
			cli.add(new Cliente(idCli, appat, apmat, nomb, dir, fechnac, fechafili, estciv, telef, dni, tipo, usu));
			
			}
			
			br.close();
			
			} catch (Exception e) {
				
				try {
					pw = new PrintWriter(new FileWriter(nombreArchivo));
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
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
			for(int i=0;i<cli.size();i++){
				
				pw.println(cli.get(i).getIdCliente()+";"+
							cli.get(i).getApellidoPaterno()+";"+
							cli.get(i).getApellidoMaterno()+";"+
							cli.get(i).getNombres()+";"+
							cli.get(i).getDireccion()+";"+
							cli.get(i).getFechaNacimiento()+";"+
							cli.get(i).getFechaAfiliacion()+";"+
							cli.get(i).getEstadoCivil()+";"+
							cli.get(i).getTelefono()+";"+
							cli.get(i).getDni()+";"+
							cli.get(i).getTipoDeCliente()+";"+
							cli.get(i).getUsuario());
			}
			
			pw.close();
			br.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	

}//final de arreglo
