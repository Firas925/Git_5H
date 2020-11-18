package win.main;

import java.awt.Color;
import java.awt.Graphics ; 
import java.awt.Rectangle;


public class Box extends GameObject {

	public Box(int x, int y) {
		super(x, y);
		
	}

	
	public void tick() {
		
		x += VelX;
		y += VelY;
		
		
	}

	
	public void render(Graphics g) {
		
		g.setColor(Color.blue);
		g.fillRect(x, y, 32, 32);
	}

	
	public Rectangle getBounds() {
		
		return null;
	}
	 

}
