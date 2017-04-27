package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class PlayerObject extends Board{
	
	Image[] images = new Image[8];
//	Rectangle[] rect = new Rectangle[8];
	
	double scale = 0.3;
	int[] width = new int[8];
	int[] length = new int[8];
	
//	public void rectanglePaint(Graphics g){
//		super.paint(g);
//		int rectNr = (direction+2)%8;
//		g.setColor(new Color(100,100,100,100));
//		g.fillRect((int)(x-width[rectNr]/2), (int)(y-length[rectNr]/2), width[rectNr], length[rectNr]);
//		paintMap(g);
//	}
	
	@Override
	public void paint(Graphics g){
		super.paint(g);
		int spriteNr = (direction+2)%8;
		g.drawImage(images[spriteNr], (int)(x-width[spriteNr]/2), (int)(y-length[spriteNr]/2), null);
		g.setColor(new Color(100,100,100,100));
		g.fillRect((int)(x-width[spriteNr]/2), (int)(y-length[spriteNr]/2), width[spriteNr], length[spriteNr]);
		paintMap(g);
	}
	
    public void loadImages(){
    	for (int i = 0; i < images.length; i++) {
		 	ImageIcon g2d = new ImageIcon("Images/Tank"+i+".png", "Tank");
//		 	Rectangle r = new Rectangle();
		 	Image image = g2d.getImage();
	        width[i] = (int)(g2d.getIconWidth()*scale);
	        length[i] = (int)(g2d.getIconHeight()*scale);
		 	images[i] = image.getScaledInstance(width[i], length[i],  java.awt.Image.SCALE_SMOOTH);
		 	
	        if(i == 0){
	        	x = (int)(g2d.getIconWidth()*scale/2);
	        	y = (int)(g2d.getIconHeight()*scale/2);
	        }
    	}
    }

}
