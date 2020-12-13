package win.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class tresor extends GameObject{

	public tresor(int x, int y, ID id) {
		super(x, y, id);
		
	}


	public void tick() {
		/*x += VelX;
		y += VelY;*/
		
	}


	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(x, y, 32, 32);
		
		
	}

	
	public Rectangle getBounds() {
		
		return new Rectangle(x,y,32,32);
	}
	

}