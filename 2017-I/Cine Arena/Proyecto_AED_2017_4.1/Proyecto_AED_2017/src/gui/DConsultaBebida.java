package gui;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import arreglo.ArregloBebida;
import arreglo.ArregloCliente;
import clases.Bebida;
import clases.Cliente;

public class DConsultaBebida extends DConsulta{
	
	private DRegistroPedido dialog;
	private ArregloBebida arreglo;
	
	public DConsultaBebida(ArregloBebida objectoArreglo, DRegistroPedido dialog) {
		
		super(objectoArreglo);
		
		this.dialog = dialog;
		
	}

	@Override
	protected void castArreglo() {

		arreglo = (ArregloBebida) objectoArreglo;
		
	}

	@Override
	protected String[] datosCombo() {
		
		return new String[]{	"Código",
								"Marca",
								"Precio",
								"Tipo",
								};
		
	}

	@Override
	protected String[] datosColumnas() {
		
		return new String[]{	"Código",
								"Marca",
								"Precio",
								"Tipo",
								"Estado",
							};
		
	}

	@Override
	protected void llenarDatosTabla() {
		
		for (int i=0;i<arreglo.tamaño();i++){
					
					Object[]  datos ={ Bebida.PRE+arreglo.obtener(i).getIdBebida(),
				             Bebida.obtenerMarcaBebida(arreglo.obtener(i).getMarca()),
				             arreglo.obtener(i).getPrecio(),
				             Bebida.obtenerTipoBebida(arreglo.obtener(i).getTipoBebida()),
				             Bebida.obtenerEstado(arreglo.obtener(i).getEstado()),
				             };
		
					agregarRegistro(datos);		
					}
			}

	@Override
	protected void llenarDatoRegistro(int i) {
		
					Object[]  datos ={ Bebida.PRE+arreglo.obtener(i).getIdBebida(),
				             Bebida.obtenerMarcaBebida(arreglo.obtener(i).getMarca()),
				             arreglo.obtener(i).getPrecio(),
				             Bebida.obtenerTipoBebida(arreglo.obtener(i).getTipoBebida()),
				             Bebida.obtenerEstado(arreglo.obtener(i).getEstado()),
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
									
					if(arreglo.obtener(i).getIdBebida()==codigo){
						
						return i;
						
						}
						
					}
					return -1;
			
			case 1:
				
				String marca;
									
					marca = textField.getText();
									
				for(int i=0;i<arreglo.tamaño();i++){
					
					if(Bebida.obtenerMarcaBebida(arreglo.obtener(i).getMarca()).contains(marca)){
						
						return i;
						
						}
						
					}
					return -1;
			
			
			case 2:
				
				double precio;
				
					try{
					precio = Double.parseDouble(textField.getText());
					}catch(Exception e){
					JOptionPane.showMessageDialog(this, "Precio no válido", "Cuidado, mucho cuidado", JOptionPane.ERROR_MESSAGE);
					return -1;
					}
					
				for(int i=0;i<arreglo.tamaño();i++){
					
					if(arreglo.obtener(i).getPrecio() == precio){
						
						return i;
						
						}
						
					}
					return -1;	
					
			default:
				
					String tipo;
										
					tipo = textField.getText();
									
				for(int i=0;i<arreglo.tamaño();i++){
					
					if(Bebida.obtenerTipoBebida(arreglo.obtener(i).getTipoBebida()).contains(tipo)){
						
						return i;
						
						}
						
					}
					return -1;
					
								
				}		
		
		
	}

	@Override
	protected void setIndiceSeleccionado(int indiceSeleccionado) {

		dialog.bebidasSeleccionadas.add(indiceSeleccionado);
		dialog.agregarBebidas(Bebida.obtenerMarcaBebida(arreglo.obtener(indiceSeleccionado).getMarca()));
		
	}

}
