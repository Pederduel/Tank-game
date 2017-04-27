package game;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.event.KeyListener;

@SuppressWarnings("serial")
public class SpillProsjekt extends PlayerObject{

	public SpillProsjekt() {
        addKeyListener((KeyListener) this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        loadImages();
        loadWalls();
        loadStars();
    }
	
    public static void main(String args[]) throws InterruptedException {
        JFrame frame = new JFrame("Tank Trouble");
        Board Dim = new Board();
        Information(Dim);
        SpillProsjekt spill = new SpillProsjekt();
        frame.add(spill);
        frame.setSize(frameWidth,frameHeight);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        spill.gameLoop(spill);
    } 
    
    public static void Information(ITextDimensions text){
    	text.frameDimension();
    	text.wallInfo();
    	text.starInfo();
    	text.boardSize();
    }
}