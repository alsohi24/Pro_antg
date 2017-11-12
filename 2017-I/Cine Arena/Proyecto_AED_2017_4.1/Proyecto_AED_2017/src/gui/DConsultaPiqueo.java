package gui;

import javax.swing.JOptionPane;

import arreglo.ArregloCliente;
import arreglo.ArregloPiqueo;
import clases.Bebida;
import clases.Piqueo;

public class DConsultaPiqueo extends DConsulta{
	
	private DRegistroPedido dialog;
	private ArregloPiqueo arreglo;
	
	public DConsultaPiqueo(ArregloPiqueo objectoArreglo, DRegistroPedido dialog) {
		
		super(objectoArreglo);
		
		this.dialog = dialog;
		
	}

	@Override
	protected void castArreglo() {
		
		arreglo = (ArregloPiqueo) objectoArreglo;
		
	}

	@Override
	protected String[] datosCombo() {
		
		return new String[]{	"Código",
				"Nombre",
				"Tipo",
				"Precio",
				};		
	}

	@Override
	protected String[] datosColumnas() {
		
		return new String[]{	"Código",
				"Nombre",
				"Tipo",
				"Precio",
				"Estado"
				};		
	}

	@Override
	protected void llenarDatosTabla() {
		
		for (int i=0;i<arreglo.tamaño();i++){
			
			Object[]  datos ={ 	Piqueo.PRE+arreglo.obtener(i).getidPiqueo(),
								arreglo.obtener(i).getNombre(),
								Piqueo.obtenerTipoPiqueos(arreglo.obtener(i).getTipoPiqueo()),
								arreglo.obtener(i).getPrecio(),
								Piqueo.obtenerEstado(arreglo.obtener(i).getEstado())
								};

			agregarRegistro(datos);		
			}
	}
		

	@Override
	protected void llenarDatoRegistro(int i) {

		Object[]  datos ={ 	Piqueo.PRE+arreglo.obtener(i).getidPiqueo(),
				arreglo.obtener(i).getNombre(),
				Piqueo.obtenerTipoPiqueos(arreglo.obtener(i).getTipoPiqueo()),
				arreglo.obtener(i).getPrecio(),
				Piqueo.obtenerEstado(arreglo.obtener(i).getEstado())
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
								
				if(arreglo.obtener(i).getidPiqueo()==codigo){
					
					return i;
					
					}
					
				}
				return -1;
		
		case 1:
			
			String nombre;
			
				nombre = textField.getText();
							
			for(int i=0;i<arreglo.tamaño();i++){
				
				if(arreglo.obtener(i).getNombre().contains(nombre)){
					
					return i;
					
					}
					
				}
				return -1;
		
		
		case 2:
			
				String tipo;
							
				tipo = textField.getText();
								
			for(int i=0;i<arreglo.tamaño();i++){
				
				if(Piqueo.obtenerTipoPiqueos(arreglo.obtener(i).getTipoPiqueo()).contains(tipo)){
					
					return i;
					
					}
					
				}
				return -1;	
				
		default:
			
			String estado;
			
				
				estado = textField.getText();
								
			for(int i=0;i<arreglo.tamaño();i++){
				
				if(Piqueo.obtenerEstado(arreglo.obtener(i).getEstado()).contains(estado)){
					
					return i;
					
					}
					
				}
				return -1;	
									
			}		
			
	}

	@Override
	protected void setIndiceSeleccionado(int indiceSeleccionado) {
		
		dialog.piqueosSeleccionados.add(indiceSeleccionado);
		dialog.agregarPiqueos(arreglo.obtener(indiceSeleccionado).getNombre());
		
	}

}
