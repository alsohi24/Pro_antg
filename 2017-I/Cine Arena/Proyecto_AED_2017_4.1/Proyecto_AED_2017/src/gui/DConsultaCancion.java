package gui;

import javax.swing.JOptionPane;

import arreglo.ArregloArtista;
import arreglo.ArregloCancion;
import arreglo.ArregloCliente;
import clases.Bebida;
import clases.Cancion;
import clases.Piqueo;

public class DConsultaCancion extends DConsulta{
	
	private DRegistroPedido dialog;
	private ArregloCancion arreglo;
	private ArregloArtista aa = new ArregloArtista();
	
	public DConsultaCancion(ArregloCancion objectoArreglo, ArregloArtista aa, DRegistroPedido dialog) {
		super(objectoArreglo);
		
		this.dialog=dialog;
		
		//this.aa=aa;
				
	}

	@Override
	protected void castArreglo() {
		
		arreglo = (ArregloCancion) objectoArreglo;
		
	}

	@Override
	protected String[] datosCombo() {
		
		return new String[]{	"Código",
				"Nombre",
				"Duración",
				//"Artista",
				"Álbum",
				"Reproducciones",
				"Estado"};
		
	}

	@Override
	protected String[] datosColumnas() {
		
		return new String[]{	"Código",
				"Nombre",
				"Duración",
				//"Artista",
				"Álbum",
				"Reproducciones",
				"Estado"};
	}

	@Override
	protected void llenarDatosTabla() {
		
		for (int i=0;i<arreglo.tamaño();i++){

			Object[]  datos ={ 	Cancion.PRE+arreglo.obtener(i).getidCancion(),
		             arreglo.obtener(i).getnombre(),
		             arreglo.obtener(i).getduracion(),
		             //aa.obtener(arreglo.obtener(i).getidArtista()).getNombreArtistico(),
		             arreglo.obtener(i).getalbum(),
		             arreglo.obtener(i).getnumeroReproducciones(),
		             Cancion.obtenerEstado(arreglo.obtener(i).getestado()),
						      };

			agregarRegistro(datos);		
			}
		
	}

	@Override
	protected void llenarDatoRegistro(int i) {
		
		Object[]  datos ={ 	Cancion.PRE+arreglo.obtener(i).getidCancion(),
	             arreglo.obtener(i).getnombre(),
	             arreglo.obtener(i).getduracion(),
	            // aa.obtener(arreglo.obtener(i).getidArtista()).getNombreArtistico(),
	             arreglo.obtener(i).getalbum(),
	             arreglo.obtener(i).getnumeroReproducciones(),
	             Cancion.obtenerEstado(arreglo.obtener(i).getestado()),
		      };

			agregarRegistro(datos);	
		
	}

	@Override
	protected int buscar(int caso) {
		
		switch(caso){
		
		case 0:
			
			int codigo;
			
				try{
				codigo= Integer.parseInt(textField.getText());
				}catch(Exception e){
				JOptionPane.showMessageDialog(this, "Código no válido", "Cuidado, mucho cuidado", JOptionPane.ERROR_MESSAGE);
				return -1;
				}
			
				for(int i=0;i<arreglo.tamaño();i++){
								
				if(arreglo.obtener(i).getidCancion()==codigo){
					
					return i;
					
					}
					
				}
				return -1;
		
		case 1:
			
				String nombre;
							
				nombre = textField.getText();
							
			for(int i=0;i<arreglo.tamaño();i++){
				
				if(arreglo.obtener(i).getnombre().contains(nombre)){
					
					return i;
					
					}
					
				}
				return -1;
		
		
		case 2:
			
				String duracion;
			
				duracion = textField.getText();
			
			for(int i=0;i<arreglo.tamaño();i++){
				
				if(arreglo.obtener(i).getduracion().contains(duracion)){
					
					return i;
					
					}
					
				}
				return -1;
				
		case 3:
			
			String artista;
		
			artista = textField.getText();
		
			for(int i=0;i<arreglo.tamaño();i++){
			
			if(aa.obtener(arreglo.obtener(i).getidArtista()).getNombreArtistico().contains(artista)){
				
				return i;
				
				}
				
			}
			return -1;	
			
		case 4:
			
			String album;
		
			album = textField.getText();
		
			for(int i=0;i<arreglo.tamaño();i++){
			
			if(arreglo.obtener(i).getalbum().contains(album)){
				
				return i;
				
				}
				
			}
			return -1;
						
				
		default:
			
			int reproducciones;
			
				try{
				reproducciones = Integer.parseInt(textField.getText());
				}catch(Exception e){
				JOptionPane.showMessageDialog(this, "Número de reproducciones no válido", "Cuidado, mucho cuidado", JOptionPane.ERROR_MESSAGE);
				return -1;
				}
				
			for(int i=0;i<arreglo.tamaño();i++){
				
				if(arreglo.obtener(i).getnumeroReproducciones()==reproducciones){
					
					return i;
					
					}
					
				}
				return -1;	
									
			}		
		
	}

	@Override
	protected void setIndiceSeleccionado(int indiceSeleccionado) {
		
		dialog.cancionesSeleccionadas.add(indiceSeleccionado);
		dialog.agregarCanciones(arreglo.obtener(indiceSeleccionado).getnombre());
				
	}

}
