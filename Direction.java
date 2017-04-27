package game;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Direction extends JPanel{
	
	int direction = 6;
	static int[] keys = new int[4];
	
    public void setDirection(int lastInput, boolean release){
    	if(keys[0] == 1 && keys[3] == 1 && keys[1] == 0 && keys[2] == 0){
    		direction = 7;
    		return;
    	}
    	int keySum = 0;
    	int counter = 0;
    	for (int i = 0; i < keys.length; i++) {
    		if(keys[(i + 2) % 4] == 1){
	    		continue;
    		}
    		if(keys[i] == 1){
    			keySum += i*2;
    			counter++;
    		}
		}
    	if(counter > 0){
    		direction = keySum/counter;
    	}
    }
}
