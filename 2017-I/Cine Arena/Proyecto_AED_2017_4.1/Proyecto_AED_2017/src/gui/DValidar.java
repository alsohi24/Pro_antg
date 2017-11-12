package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import arreglo.ArregloUsuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JPasswordField;

public class DValidar extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField txtUsuario;
	private JPasswordField txtContraseña;
	private JButton btnIngresar;
	private JButton btnCancelar;
	private JPanel panel;
	
	private ArregloUsuario arregloUsuario = new ArregloUsuario();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			
			UIManager.setLookAndFeel(
		            "com.seaglasslookandfeel.SeaGlassLookAndFeel");
				
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			
			try {
				UIManager.setLookAndFeel(
				        UIManager.getSystemLookAndFeelClassName());
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
					| UnsupportedLookAndFeelException e2){
				
				try {
					UIManager.setLookAndFeel(
					        UIManager.getCrossPlatformLookAndFeelClassName());
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e3) {

					e1.printStackTrace();
				}
				
			
			}
						
			
		}
		
		DValidar dialog = new DValidar();
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setResizable(false);
		dialog.setVisible(true);
	}

	/**
	 * Create the dialog.
	 */
	public DValidar() {
		
		panel = (JPanel) getContentPane();
		panel.setLayout(null);
		panel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		
		setLocationRelativeTo(null);
		setUndecorated(true);
		setBounds(100, 100, 330, 191);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(34, 32, 83, 14);
		contentPanel.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(34, 76, 83, 14);
		contentPanel.add(lblContrasea);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(173, 29, 86, 20);
		contentPanel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.setBounds(55, 136, 89, 23);
		btnIngresar.addActionListener(this);
		contentPanel.add(btnIngresar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(154, 136, 89, 23);
		btnCancelar.addActionListener(this);
		contentPanel.add(btnCancelar);
		
		txtContraseña = new JPasswordField();
		txtContraseña.setBounds(173, 73, 86, 20);
		contentPanel.add(txtContraseña);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if (arg0.getSource()==btnIngresar){
			
			for(int i=0;i<arregloUsuario.tamaño();i++){
				
				//Verifico login
				if(txtUsuario.getText().equals(arregloUsuario.obtener(i).getLogin())){
					//Verifico contraseña
					if(String.valueOf(txtContraseña.getPassword()).equals(arregloUsuario.obtener(i).getPassword())){
						Proyecto_AED_2017 frame = new Proyecto_AED_2017(arregloUsuario.obtener(i).getIdUsuario());
						frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
						frame.setVisible(true);
						this.dispose();
						return;
					} else {
					JOptionPane.showMessageDialog(this, "Contraseña incorrecta", "Qué mello!", JOptionPane.ERROR_MESSAGE);
					return;
					
					} 
					
				}
				
			}
			
			JOptionPane.showMessageDialog(this, "Datos inválidos", "Qué mello!", JOptionPane.ERROR_MESSAGE);
			
			
		} else {
			
			System.exit(0);
			
		}
		
	}
}
