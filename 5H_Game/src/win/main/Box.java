package win.main;

import java.awt.Color;
import java.awt.Graphics ; 
import java.awt.Rectangle;
import java.awt.image.BufferedImage;


public class Box extends GameObject {
	
	private BufferedImage block_image;

	public Box(int x, int y, ID id, SpriteSheet ss) {
		super(x, y, id, ss);
		
		block_image = ss.grabImage(5, 2, 32, 32);
		
	}

	
	public void tick() {
		
		/*x += VelX;
		y += VelY;*/
		
		
	}

	
	public void render(Graphics g) {
		
		g.drawImage(block_image, x, y, null);
	}

	
	public Rectangle getBounds() {
		return new Rectangle(x,y,32,32);
	}
	 

}
