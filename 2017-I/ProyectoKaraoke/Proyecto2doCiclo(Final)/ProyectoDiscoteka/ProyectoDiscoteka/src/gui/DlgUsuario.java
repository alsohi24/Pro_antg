package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import arreglos.ArregloUsuario;
import clases.Usuario;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class DlgUsuario extends JDialog implements ActionListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblCodigo;
	private JLabel lblNombres;
	private JLabel lblApellidoPaterno;
	private JLabel lblApellidoMaterno;
	private JTextField txtCodigoUsuario;
	private JTextField txtNombreUsuario;
	private JTextField txtApUsuario;
	private JTextField txtAmUsuario;
	private JLabel lblLogin;
	private JLabel lblPasword;
	private JTextField txtLogin;
	private JTextField txtPasword;
	private JLabel lblTipoEmplado;
	private JComboBox<Object> cboTipoEmpleado;
	private JTextField txtTipoEmpleado;
	private JLabel lblTurno;
	private JComboBox<String> cboTurno;
	private JTextField txtTurno;
	private JButton btnAceptar;
	private JScrollPane scrollPane;
	private JTable tblUsuario;
	private DefaultTableModel modelo;
	private JLabel lblimagenUsuario;
	private JButton btnGrabar;
	private JButton btnCancelar;
	private JButton btnIngresarNuevo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgUsuario dialog = new DlgUsuario();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public DlgUsuario() {
		setTitle("Mantenimiento | Usuario");
		setBounds(100, 100, 1000, 600);
		getContentPane().setLayout(null);

		lblimagenUsuario = new JLabel("");
		lblimagenUsuario.setBackground(Color.GRAY);
		lblimagenUsuario.setIcon(new ImageIcon("imagenes/DLGusuario1.png"));
		lblimagenUsuario.setBounds(10, 10, 176, 166);
		getContentPane().add(lblimagenUsuario);

		lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(213, 10, 115, 14);
		getContentPane().add(lblCodigo);

		lblNombres = new JLabel("Nombres");
		lblNombres.setBounds(213, 35, 115, 14);
		getContentPane().add(lblNombres);

		lblApellidoPaterno = new JLabel("Apellido Paterno");
		lblApellidoPaterno.setBounds(213, 60, 115, 14);
		getContentPane().add(lblApellidoPaterno);

		lblApellidoMaterno = new JLabel("Apellido Materno");
		lblApellidoMaterno.setBounds(213, 88, 115, 14);
		getContentPane().add(lblApellidoMaterno);

		txtCodigoUsuario = new JTextField();
		txtCodigoUsuario.setEditable(false);
		txtCodigoUsuario.setBounds(327, 7, 176, 20);
		getContentPane().add(txtCodigoUsuario);
		txtCodigoUsuario.setColumns(10);

		txtNombreUsuario = new JTextField();
		txtNombreUsuario.setBounds(327, 32, 176, 20);
		getContentPane().add(txtNombreUsuario);
		txtNombreUsuario.setColumns(10);

		txtApUsuario = new JTextField();
		txtApUsuario.setBounds(327, 57, 176, 20);
		getContentPane().add(txtApUsuario);
		txtApUsuario.setColumns(10);

		txtAmUsuario = new JTextField();
		txtAmUsuario.setBounds(327, 85, 176, 20);
		getContentPane().add(txtAmUsuario);
		txtAmUsuario.setColumns(10);

		lblLogin = new JLabel("Login");
		lblLogin.setBounds(554, 10, 80, 14);
		getContentPane().add(lblLogin);

		lblPasword = new JLabel("Pasword");
		lblPasword.setBounds(554, 38, 80, 14);
		getContentPane().add(lblPasword);

		txtLogin = new JTextField();
		txtLogin.setBounds(638, 7, 176, 20);
		getContentPane().add(txtLogin);
		txtLogin.setColumns(10);

		txtPasword = new JTextField();
		txtPasword.setBounds(638, 32, 176, 20);
		getContentPane().add(txtPasword);
		txtPasword.setColumns(10);

		lblTipoEmplado = new JLabel("Tipo Emplado");
		lblTipoEmplado.setBounds(213, 113, 80, 14);
		getContentPane().add(lblTipoEmplado);

		cboTipoEmpleado = new JComboBox<Object>();
		cboTipoEmpleado.addActionListener(this);
		cboTipoEmpleado.setModel(new DefaultComboBoxModel<Object>(new String[] { "0", "1", "2" }));
		cboTipoEmpleado.setBounds(327, 110, 44, 20);
		getContentPane().add(cboTipoEmpleado);

		txtTipoEmpleado = new JTextField();
		txtTipoEmpleado.setEditable(false);
		txtTipoEmpleado.setBounds(381, 110, 122, 20);
		getContentPane().add(txtTipoEmpleado);
		txtTipoEmpleado.setColumns(10);

		lblTurno = new JLabel("Turno");
		lblTurno.setBounds(213, 138, 46, 14);
		getContentPane().add(lblTurno);

		cboTurno = new JComboBox<String>();
		cboTurno.addActionListener(this);
		cboTurno.setModel(new DefaultComboBoxModel<String>(new String[] { "0", "1" }));
		cboTurno.setBounds(327, 137, 44, 20);
		getContentPane().add(cboTurno);

		txtTurno = new JTextField();
		txtTurno.setEditable(false);
		txtTurno.setBounds(381, 137, 122, 20);
		getContentPane().add(txtTurno);
		txtTurno.setColumns(10);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(824, 7, 150, 23);
		getContentPane().add(btnAceptar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 203, 964, 347);
		getContentPane().add(scrollPane);

		tblUsuario = new JTable();
		tblUsuario.addMouseListener(this);
		tblUsuario.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblUsuario);

		modelo = new DefaultTableModel();
		modelo.addColumn("Codigo");
		modelo.addColumn("Nombres");
		modelo.addColumn("Ap. Paterno");
		modelo.addColumn("Ap. Materno");
		modelo.addColumn("Login");
		modelo.addColumn("Pasword");
		modelo.addColumn("Tipo Empleado");
		modelo.addColumn("Turno");
		tblUsuario.setModel(modelo);

		txtTipoEmpleado.setText("Administrador");
		txtTurno.setText("Tarde(3am-9pm)");

		btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(this);
		btnGrabar.setBounds(824, 153, 150, 23);
		getContentPane().add(btnGrabar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(824, 31, 150, 23);
		getContentPane().add(btnCancelar);

		btnIngresarNuevo = new JButton("Ingresar Nuevo");
		btnIngresarNuevo.addActionListener(this);
		btnIngresarNuevo.setBounds(824, 84, 150, 23);
		getContentPane().add(btnIngresarNuevo);

		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(824, 109, 150, 23);
		getContentPane().add(btnModificar);

		ajustarAnchoColumnas();
		habilitarEntradas(false);
		listar();// Para que al iniciar la ventana, ya muestre los datos
		editarFila();

	}

	ArregloUsuario usu = new ArregloUsuario("Usuarios.txt");
	private JButton btnModificar;

	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnModificar) {
			actionPerformedBtnModificar(arg0);
		}
		if (arg0.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(arg0);
		}
		if (arg0.getSource() == btnIngresarNuevo) {
			actionPerformedBtnIngresarNuevo(arg0);
		}
		if (arg0.getSource() == btnGrabar) {
			actionPerformedBtnGrabar(arg0);
		}
		if (arg0.getSource() == cboTurno) {
			actionPerformedCboTurno(arg0);
		}
		if (arg0.getSource() == cboTipoEmpleado) {
			actionPerformedCboTipoEmpleado(arg0);
		}
		if (arg0.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(arg0);
		}
	}

	// BOTON: ACEPTAR
	protected void actionPerformedBtnAceptar(ActionEvent arg0) {
		String codigo = correlativoCodigo();
		String nombre = leerNombre();
		if (nombre.length() > 0) {
			String apPaterno = leerApPaterno();
			if (apPaterno.length() > 0) {
				String apMaterno = leerApMaterno();
				if (apMaterno.length() > 0) {
					String login = leerLogin();
					if (login.length() > 0) {
						String pasword = leerPasword();
						if (pasword.length() == 8) {
							int tipoEmpleado = leerTipoEmpleado();
							int turno = leerTurno();
							if (btnIngresarNuevo.isEnabled() == false) {
								Usuario nuevo = new Usuario(codigo, nombre, apPaterno, apMaterno, login, pasword,
										tipoEmpleado, turno);

								usu.adicionar(nuevo);
								btnIngresarNuevo.setEnabled(true);
								limpieza();
								txtCodigoUsuario.setText("" + correlativoCodigo());
								txtNombreUsuario.requestFocus();
							}

							if (btnModificar.isEnabled() == false) {
								// Uso la posicion de la fila seleccionada como
								// parametro para obtener la direccion de
								// memoria del arreglo
								int posFila = tblUsuario.getSelectedRow();
								Usuario x = usu.obtener(posFila);
								x.setNombres(nombre);
								x.setApellidoPaterno(apPaterno);
								x.setApellidoMaterno(apMaterno);
								x.setLogin(login);
								x.setPasword(pasword);
								x.setTipoEmpleado(tipoEmpleado);
								x.setTurno(turno);
								btnModificar.setEnabled(true);
								habilitarEntradas(false);
							}

							listar();
							
						} // ******
						else {
							mensaje("El pasword debe tener 8 digitos como minimo");
							txtPasword.requestFocus();
						}
					}
					else {
						mensaje("Ingrese un Login Valido");
						txtLogin.requestFocus();
					}
				}
				else {
					mensaje("Ingrese un Apellido Valido");
					txtAmUsuario.requestFocus();
				}
			}
			else {
				mensaje("Ingrese un Apellido Valido");
				txtApUsuario.requestFocus();
			}
		}
		else {
			mensaje("Ingrese un Nombre Valido");
			txtNombreUsuario.requestFocus();
		}
	}

	// BOTON: GRABAR
	protected void actionPerformedBtnGrabar(ActionEvent arg0) {
		/**
		 * Actualiza el archivo
		 */
		if (usu.existeArchivo()) {
			int ok = confirmar("¿ Desea actualizar \"" + usu.getArchivo() + "\" ?");
			if (ok == 0) {
				usu.grabarUsuario();
				mensaje("\"" + usu.getArchivo() + "\" ha sido actualizado");
			}
			else
				mensaje("No se actualizó  \"" + usu.getArchivo() + "\"");
		}
		else {
			usu.grabarUsuario();
			mensaje("\"" + usu.getArchivo() + "\" ha sido creado");
		}
		limpieza();
		habilitarEntradas(false);
		btnIngresarNuevo.setEnabled(true);
		btnModificar.setEnabled(true);
	}

	// BOTON: INGRESAR NUEVO
	protected void actionPerformedBtnIngresarNuevo(ActionEvent arg0) {
		limpieza();
		habilitarEntradas(true);
		txtNombreUsuario.requestFocus();
		txtCodigoUsuario.setText("" + correlativoCodigo());
		btnIngresarNuevo.setEnabled(false);
		btnModificar.setEnabled(true);
	}

	// BOTON: CANCELAR
	protected void actionPerformedBtnCancelar(ActionEvent arg0) {
		limpieza();
		habilitarEntradas(false);
		editarFila();
		btnIngresarNuevo.setEnabled(true);
		btnModificar.setEnabled(true);

	}

	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == tblUsuario) {
			mouseClickedTblUsuario(arg0);
		}
	}

	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}

	public void mousePressed(MouseEvent arg0) {
	}

	public void mouseReleased(MouseEvent arg0) {
	}

	// EVENTO CLICK EN LAS FILAS DE LA TABLA
	protected void mouseClickedTblUsuario(MouseEvent arg0) {
		editarFila();
		habilitarEntradas(false);
		btnIngresarNuevo.setEnabled(true);
		btnModificar.setEnabled(true);
	}

	// BOTON: MODIFICAR
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		habilitarEntradas(true);
		txtNombreUsuario.requestFocus();
		btnIngresarNuevo.setEnabled(true);
		btnModificar.setEnabled(false);
	}

	// ***********************************************************************

	private int anchoColumna(int porcentaje) {
		return porcentaje * scrollPane.getWidth() / 100;
	}

	private void ajustarAnchoColumnas() {
		TableColumnModel tcm = tblUsuario.getColumnModel();
		tcm.getColumn(0).setPreferredWidth(anchoColumna(6)); // codigo
		tcm.getColumn(1).setPreferredWidth(anchoColumna(16)); // Nombres
		tcm.getColumn(2).setPreferredWidth(anchoColumna(16)); // Ap. Paterno
		tcm.getColumn(3).setPreferredWidth(anchoColumna(16)); // Ap. Materno
		tcm.getColumn(4).setPreferredWidth(anchoColumna(10)); // Login
		tcm.getColumn(5).setPreferredWidth(anchoColumna(12)); // Pasword
		tcm.getColumn(6).setPreferredWidth(anchoColumna(12)); // Tipo Empleado
		tcm.getColumn(7).setPreferredWidth(anchoColumna(12)); // Turno
	}

	// Metodo Listar
	void listar() {
		// para que al iniciar el programa, se seleccione la fila 1

		int posFila = 0;
		if (modelo.getRowCount() > 0)
			posFila = tblUsuario.getSelectedRow();
		if (modelo.getRowCount() == usu.tamaño() - 1)
			posFila = usu.tamaño() - 1;
		if (posFila == usu.tamaño())
			posFila--;

		modelo.setRowCount(0);
		for (int i = 0; i < usu.tamaño(); i++) {
			Object[] fila = { usu.obtener(i).getIdUsuario(), usu.obtener(i).getNombres(),
					usu.obtener(i).getApellidoPaterno(), usu.obtener(i).getApellidoMaterno(), usu.obtener(i).getLogin(),
					usu.obtener(i).getPasword(), usu.obtener(i).txtTipoEmpleado(), usu.obtener(i).txtTurno(), };
			modelo.addRow(fila);
		}
		// No sé para que es, pero completa el codigo para seleccionar la
		// primera fila

		if (usu.tamaño() > 0)
			tblUsuario.getSelectionModel().setSelectionInterval(posFila, posFila);

	}

	// Metodos tipo void sin parametros

	String leerNombre() {
		return txtNombreUsuario.getText().trim();
	}

	String leerApPaterno() {
		return txtApUsuario.getText().trim();
	}

	String leerApMaterno() {
		return txtAmUsuario.getText().trim();

	}

	String leerLogin() {
		return txtLogin.getText().trim();
	}

	String leerPasword() {
		return txtPasword.getText().trim();
	}

	int leerTipoEmpleado() {
		return cboTipoEmpleado.getSelectedIndex();
	}

	int leerTurno() {
		return cboTurno.getSelectedIndex();
	}

	String correlativoCodigo() {
		int i = usu.tamaño() + 1;
		if (i < 10)
			return ("U000" + i);
		else
			return ("U00" + i);
	}

	protected void actionPerformedCboTipoEmpleado(ActionEvent arg0) {
		int x = cboTipoEmpleado.getSelectedIndex();
		switch (x) {
			case 0:
				txtTipoEmpleado.setText("Administrador");
				break;
			case 1:
				txtTipoEmpleado.setText("Supervisor");
				break;
			default:
				txtTipoEmpleado.setText("Mozo");
				break;
		}

	}

	protected void actionPerformedCboTurno(ActionEvent arg0) {
		int x = cboTurno.getSelectedIndex();
		switch (x) {
			case 0:
				txtTurno.setText("Tarde (3am-9pm)");
				break;
			default:
				txtTurno.setText("Noche (9pm-3am)");
				break;
		}

	}

	// Métodos que retornan valor con parámetros
	int confirmar(String s) {
		return JOptionPane.showConfirmDialog(this, s);
	}

	// Métodos tipo void con parámetros
	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}

	void habilitarEntradas(boolean sino) {
		// btnAceptar.setEnabled(sino);
		txtNombreUsuario.setEditable(sino);
		txtApUsuario.setEditable(sino);
		txtAmUsuario.setEditable(sino);
		txtLogin.setEditable(sino);
		txtPasword.setEditable(sino);
		cboTipoEmpleado.setEnabled(sino);
		cboTurno.setEnabled(sino);
		btnAceptar.setEnabled(sino);
		btnCancelar.setEnabled(sino);

	}

	void limpieza() {
		txtCodigoUsuario.setText("");
		txtNombreUsuario.setText("");
		txtApUsuario.setText("");
		txtAmUsuario.setText("");
		txtLogin.setText("");
		txtPasword.setText("");
		cboTipoEmpleado.setSelectedIndex(0);
		cboTurno.setSelectedIndex(0);

	}

	void editarFila() {
		if (usu.tamaño() == 0)
			limpieza();
		else {
			Usuario x = usu.obtener(tblUsuario.getSelectedRow());
			txtCodigoUsuario.setText(x.getIdUsuario());
			txtNombreUsuario.setText(x.getNombres());
			txtApUsuario.setText(x.getApellidoPaterno());
			txtAmUsuario.setText(x.getApellidoMaterno());
			txtLogin.setText(x.getLogin());
			txtPasword.setText(x.getPasword());
			cboTipoEmpleado.setSelectedIndex(x.getTipoEmpleado());
			cboTurno.setSelectedIndex(x.getTurno());

		}
	}

}
