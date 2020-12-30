package win.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Arme extends GameObject {

	private Handler handler ; 
	
	
	public Arme(int x, int y, ID id, Handler handler,int mx,int my) {
		super(x, y, id);
		this.handler = handler ; 
		VelX=(mx-x)/10 ; 
		VelY=(my-y)/10 ; 
		
		
	} 

	
	public void tick() {
		x+=VelX ; 
		y+=VelY ;
		
		
		// collision 
		 
		
		 for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i); 
			
			if(tempObject.getId() == ID.boîte) {
				if(getBounds().intersects(tempObject.getBounds())) {
					handler.removeObject(this);
				}
		
		}
		}
		
	}


	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillOval(x,y,8,8) ; 
		
		
	}


	public Rectangle getBounds() {
		
		return new Rectangle(x,y,8,8);
	}

}
