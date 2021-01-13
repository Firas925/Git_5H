package win.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class magique extends GameObject{
	
	private BufferedImage case_magique;
	
	
	

	public magique(int x, int y, ID id, SpriteSheet ss) {
		super(x, y, id, ss);
		
		case_magique = ss.grabImage(6, 2, 32, 32);
	}


	public void tick() {
		/*x += VelX;
		y += VelY;*/
		
	}


	public void render(Graphics g) {
		g.drawImage(case_magique, x, y, null);		
		
	}

	
	public Rectangle getBounds() {
		
		return new Rectangle(x,y,32,32);
	}
	

}