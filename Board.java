package game;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Color;

@SuppressWarnings("serial")
public class Board extends Movement implements ITextDimensions{
	
 	int map0[][] = {
			 {0, 0, 0, 1, 1, 1, 1, 1, 1, 1,},
			 {0, 0, 0, 0, 1, 2, 0, 0, 0, 1,},
			 {0, 0, 0, 0, 1, 1, 1, 1, 0, 1,},
			 {1, 0, 0, 0, 0, 0, 0, 0, 0, 1,},
			 {1, 0, 0, 0, 1, 0, 0, 1, 1, 1,},
			 {1, 0, 0, 0, 1, 0, 0, 0, 0, 1,},
			 {1, 0, 0, 0, 1, 0, 1, 0, 0, 1,},
			 {1, 0, 0, 0, 1, 0, 1, 1, 0, 1,},
			 {1, 0, 0, 0, 1, 0, 1, 0, 0, 1,},
			 {1, 1, 1, 1, 1, 1, 1, 1, 1, 1,}
	 };
	
	final static int frameWidth = 1000;
	final static int frameHeight = 1000;
	
	Image[] star = new Image[1];
	
    double starWidth = frameWidth/map0[0].length;
    double starHeight = frameHeight/map0.length;
	
	Image[] wall = new Image[1];

    double wallWidth = frameWidth/map0[0].length;
    double wallHeight = frameHeight/map0.length;
	
 	
	public void loadStars(){
	 	ImageIcon stars = new ImageIcon("Images/Star.gif", "Star");
	 	Image image = stars.getImage();
	 	star[0] = image.getScaledInstance((int)starWidth, (int)starHeight,  java.awt.Image.SCALE_SMOOTH);
}
	
	public void loadWalls(){
	 	ImageIcon walls = new ImageIcon("Images/Wall.png", "Wall");
	 	Image image = walls.getImage();
	 	wall[0] = image.getScaledInstance((int)wallWidth, (int)wallHeight,  java.awt.Image.SCALE_SMOOTH);
    }
	
	public void paintMap(Graphics g){
		for (int x = 0; x < map0.length; x++) {
	        for (int y = 0; y < map0[x].length; y++) {
	            if(map0[x][y] == 1){
	            	g.drawImage(wall[0], (int)wallWidth*y, (int)wallHeight*x, null);
	            	g.setColor(new Color(100,100,100,100));
	        		g.fillRect((int)(wallWidth*y), (int)(wallHeight*x), (int)wallWidth, (int)wallHeight);
	            }
	            else if(map0[x][y] == 2){
	        		g.drawImage(star[0], (int)(starWidth*y), (int)(starHeight*x), null);
	        		g.setColor(new Color(100,100,100,100));
	        		g.fillRect((int)(starWidth*y), (int)(starHeight*x), (int)starWidth, (int)starHeight);
	        	}
	        }
	    }
	}
	
	public void wallInfo() {
	 	System.out.println("Wall width: " + wallWidth + ". Wall height: " + wallHeight);
	}

	public void starInfo() {
	 	System.out.println("Star width: " + starWidth + ". Star height: " + starHeight);
	}

	public void frameDimension() {
		System.out.println("Frame width: " + frameWidth + ". Frame height: " + frameHeight);
	}
	
	public void boardSize(){
		System.out.println("Board size: " + map0[0].length + "x" + map0.length + " blocks");
	}
}