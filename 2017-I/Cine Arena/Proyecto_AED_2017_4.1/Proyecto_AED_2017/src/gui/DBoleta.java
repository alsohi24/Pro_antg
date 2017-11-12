package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DBoleta extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();

	private JTextArea textArea;
	private JButton btnListo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DBoleta dialog = new DBoleta("Boleta:");
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DBoleta(){
		
		this("Boleta virtual: ");
		
	}
	
	public DBoleta(String mensaje) {
		
		setUndecorated(true);
		setBounds(100, 100, 197, 313);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 161, 218);
		contentPanel.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setText(mensaje);
		scrollPane.setViewportView(textArea);
		
		btnListo = new JButton("Listo");
		btnListo.setBounds(47, 240, 89, 23);
		btnListo.addActionListener(this);
		contentPanel.add(btnListo);
		
		setResizable(false);
		
	}
	
	void escribir(String mensaje){
		
		textArea.append(mensaje+"\n");
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(arg0.getSource()==btnListo){
			
			this.dispose();
			
		}
		
	}
	
}
