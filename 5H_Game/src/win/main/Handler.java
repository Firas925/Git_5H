package win.main;

import java.util.ArrayList;
import java.util.LinkedList ; 
import java.awt.Graphics;
import java.awt.image.BufferedImage; 




public class Handler {
	
	
	
	
	ArrayList <GameObject> object = new ArrayList <GameObject> () ;
	
	private boolean up = false, down = false, right = false, left = false;


	public void tick() {
		for (int i = 0 ; i<object.size() ; i++) {
			GameObject tempObject = object.get(i) ;
			tempObject.tick();
			
		}
		
	}
	
	
	public void render (Graphics g) {
		
		for (int i = 0 ; i<object.size() ; i++) {
			GameObject tempObject = object.get(i) ;
			tempObject.render(g);
			
		}
		
	}
	
	
	 public void addObject (GameObject tempObject) {
		 
		 object.add(tempObject) ;
	 }
	
	 
public void removeObject (GameObject tempObject) {
		 
		 object.remove(tempObject) ;
	 }


public boolean isUp() {

	return up;
}


public boolean isDown() {
	return down;
}


public boolean isRight() {
		return right;
}


public boolean isLeft() {
	return left;
}

public void setUp(boolean up) {
	this.up = up;
}


public void setDown(boolean down) {
	this.down = down;
}


public void setRight(boolean right) {
	this.right = right;
}


public void setLeft(boolean left) {
	this.left = left;
}

public  void clearLevel() {
	
	object.clear();
	
}
//loading the level

	

}