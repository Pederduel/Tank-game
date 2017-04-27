package game;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class Movement extends Direction implements ActionListener, KeyListener{
	
	double x = 0;
	double y = 0;
	double speed = 3;
	double diagSpeed = 1.375;
	
    public void gameLoop(SpillProsjekt spill) throws InterruptedException{
    	while(true){
    		if((keys[0] == 1) && (keys[1] == 1) && (keys[2] == 0) && (keys[3] == 0)){
    			x -= speed/diagSpeed;
    			y -= speed/diagSpeed;
    		}
    		if((keys[3] == 1) && (keys[0] == 1) && (keys[1] == 0) && (keys[2] == 0)){
    			x -= speed/diagSpeed;
    			y += speed/diagSpeed;
    		}
    		if((keys[1] == 1) && (keys[2] == 1) && (keys[0] == 0) && (keys[3] == 0)){
    			x += speed/diagSpeed;
    			y -= speed/diagSpeed;
    		}
    		if((keys[2] == 1) && (keys[3] == 1) && (keys[1] == 0) && (keys[0] == 0)){
    			x += speed/diagSpeed;
    			y += speed/diagSpeed;
    		}
        	if((keys[1] == 1) && (keys[3] == 0) && (keys[2] == 0) && (keys[0] == 0)){
        		y -= speed;
        	}
        	if((keys[3] == 1) && (keys[1] == 0) && (keys[2] == 0) && (keys[0] == 0)){
        		y += speed;
        	}
        	if((keys[2] == 1) && (keys[3] == 0) && (keys[1] == 0) && (keys[0] == 0)){
        		x += speed;
        	}
        	if((keys[0] == 1) && (keys[3] == 0) && (keys[2] == 0) && (keys[1] == 0)){
        		x -= speed;
        	}
        	spill.repaint();
        	Thread.sleep(10);
    	}
    }
    
	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if(code >= 37 && code <= 40){
			keys[code-37] = 1;
			setDirection(code-37, false);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		if(code >= 37 && code <= 40){
			keys[code-37] = 0;
			setDirection(code-37, true);
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
