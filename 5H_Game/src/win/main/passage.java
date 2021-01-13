package win.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class passage extends GameObject{

	public passage (int x, int y, ID id, SpriteSheet ss) {
		super(x, y, id, ss);
		
	}


	public void tick() {
		/*x += VelX;
		y += VelY;*/
		
	}


	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(x, y, 32, 32);
		
		
	}

	
	public Rectangle getBounds() {
		
		return new Rectangle(x,y,32,32);
	}
	

}