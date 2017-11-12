package gui;
 
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
 
public class JPanelConFondo extends JPanel {
 
	private URL url;
    Image image;

    public JPanelConFondo(String ruta){
    	
    	url = getClass().getResource(ruta);
    	image = new ImageIcon(url).getImage();
    	
    }
    
    @Override
    public void paint(Graphics g){
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
        super.paint(g);
    }
}