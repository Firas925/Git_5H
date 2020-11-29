package win.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class Monstre  extends GameObject {
	
	private Handler handler ;
	
	Random r = new Random() ;
	int choose = 0 ; 
	int hp=100 ;
	

	public Monstre(int x, int y, ID id , Handler handler) {
		super(x, y, id);
		this.handler=handler ;
	}

	
	public void tick() {
		x+=VelX;
		y+=VelY ;
		
		choose = r.nextInt(5) ;
		for(int i = 0 ;i<handler.object.size();i++ ) {
			
			  GameObject tempObject =handler.object.get(i) ;
			  if(tempObject.getId()==ID.boîte ) {
				  
				  if(getBoundsBig().intersects(tempObject.getBounds())) {
					  VelX+= VelX*2 -1 ;
					  VelY+= VelY*2 -1 ; 
					  VelX *= -0.60;
					  VelY *= -0.60 ;
					  
				  } else if (choose ==0) {
						VelX=(r.nextInt(4 - -4)+ -4) ;
						VelY=(r.nextInt(4 - -4)+ -4) ;
					  
			  }
		 } 
	
		}
	}

	
	public void render(Graphics g) {
		g.setColor(Color.red) ;
		g.fillRect(x, y, 32, 32);
		
		
		
		 
		
		
	}

	
	public Rectangle getBounds() {
		
		return new Rectangle(x,y,32,32);
	}
	
	
	public Rectangle getBoundsBig() {
		
		return new Rectangle(x-20,y-20,64,64);
	} 

}

