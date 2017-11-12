package gui;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import arreglo.ArregloCliente;
import clases.Cliente;
import clases.Piqueo;

public class DConsultaCliente extends DConsulta{

	private DRegistroPedido dialog;
	private ArregloCliente arreglo;
	
	public DConsultaCliente(ArregloCliente objetoArreglo, DRegistroPedido dialog) {
			
		super(objetoArreglo);

		this.dialog=dialog;
						
	}
	
	protected void castArreglo() {
		
		arreglo = (ArregloCliente) objectoArreglo;
		
	}

	protected String[] datosCombo() {
		
		return new String[]{	"Código",
								"Apellido paterno",
								"Apellido materno",
								"Nombres",
								"Dirección",
								"DNI",
								"Teléfono"};
		
	}

	protected String[] datosColumnas() {
		
		return new String[]{	"Código",
								"Apellido paterno",
								"Apellido materno",
								"Nombres",
								"Dirección",
								"Fecha nacimiento",
								"Fecha afiliación",
								"Estado civil",
								"Teléfono",
								"DNI",
								"Tipo"};
		
	}
		
	protected int buscar(int caso){
		
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
								
				if(arreglo.obtener(i).getIdCliente()==codigo){
					
					return i;
					
					}
					
				}
				return -1;
		
		case 1:
			
			String ap = textField.getText();
			
			for(int i=0;i<arreglo.tamaño();i++){
				
				if(arreglo.obtener(i).getApellidoPaterno().contains(ap)){
					
					return i;
					
					}
					
				}
				return -1;
		
		
		case 2:
			
			String am = textField.getText();
			
			for(int i=0;i<arreglo.tamaño();i++){
				
				if(arreglo.obtener(i).getApellidoMaterno().contains(am)){
					
					return i;
					
					}
					
				}
				return -1;	
				
		case 3:
			
			String nm = textField.getText();
			
			for(int i=0;i<arreglo.tamaño();i++){
				
				if(arreglo.obtener(i).getNombres().contains(nm)){
					
					return i;
					
					}
					
				}
				return -1;
		
		case 4:
			
			String dr = textField.getText();
			
			for(int i=0;i<arreglo.tamaño();i++){
				
				if(arreglo.obtener(i).getDireccion().contains(dr)){
					
					return i;
					
					}
					
				}
				return -1;
				
		case 5:
			
			String dni = textField.getText();
			
			for(int i=0;i<arreglo.tamaño();i++){
				
				if(arreglo.obtener(i).getDni().contains(dni)){
					
					return i;
					
					}
					
				}
				return -1;
				
		default:
			
			String tel = textField.getText();
			
			for(int i=0;i<arreglo.tamaño();i++){
				
				if(arreglo.obtener(i).getTelefono().contains(tel)){
					
					return i;
					
					}
					
				}
				return -1;
		}		
		
	}

	protected void llenarDatosTabla(){
					
		for (int i=0;i<arreglo.tamaño();i++){
			
			Object[]  datos ={ Cliente.PRE+arreglo.obtener(i).getIdCliente(),
		             arreglo.obtener(i).getApellidoPaterno(),
		             arreglo.obtener(i).getApellidoMaterno(),
		             arreglo.obtener(i).getNombres(),
		             arreglo.obtener(i).getDireccion(),
		             arreglo.obtener(i).getFechaNacimiento(),
		             arreglo.obtener(i).getFechaAfiliacion(),
		             Cliente.obtenerEstadoCivil(arreglo.obtener(i).getEstadoCivil()),
		             arreglo.obtener(i).getTelefono(),
		             arreglo.obtener(i).getDni(),
		             Cliente.obtenerTipo(arreglo.obtener(i).getTipoDeCliente())		            
                     };

			agregarRegistro(datos);
			
		}
		
	}
	
	protected void llenarDatoRegistro(int i){
		
			Object[]  datos ={ Cliente.PRE+arreglo.obtener(i).getIdCliente(),
		             arreglo.obtener(i).getApellidoPaterno(),
		             arreglo.obtener(i).getApellidoMaterno(),
		             arreglo.obtener(i).getNombres(),
		             arreglo.obtener(i).getDireccion(),
		             arreglo.obtener(i).getFechaNacimiento(),
		             arreglo.obtener(i).getFechaAfiliacion(),
		             Cliente.obtenerEstadoCivil(arreglo.obtener(i).getEstadoCivil()),
		             arreglo.obtener(i).getTelefono(),
		             arreglo.obtener(i).getDni(),
		             Cliente.obtenerTipo(arreglo.obtener(i).getTipoDeCliente())		            
	                };
			
				agregarRegistro(datos);
			
	}
	
	protected void setIndiceSeleccionado(int indiceSeleccionado){
		
		dialog.clienteActual = indiceSeleccionado;
		dialog.cboCliente.setSelectedIndex(indiceSeleccionado);
		dialog.mostrarNombresCliente(indiceSeleccionado);
				
	}

		
}
