package win.main;

import java.awt.Color;
import java.awt.Graphics ;
import java.awt.Rectangle ;

public class hero extends GameObject {

	
	Handler handler ; 
	
	public hero(int x, int y, ID id , Handler handler) {
		super(x, y, id);
		this.handler = handler ;
	
	}

	
	public void tick() {
		x+=VelX ; // evolution de la postion  
		y+=VelY ;
		
		collision() ;
		
		// déplacement 
		
		if (handler.isUp())
			VelY = -5 ;
		else if (!(handler.isDown()))
			VelY =0 ; 
		
		
		if (handler.isDown())
			VelY = 5 ;
		else if (!(handler.isUp()))
			VelY =0 ; 
		
		
		if (handler.isRight())
			VelX = +5 ; 
		else if (!(handler.isLeft()))
			VelX = 0 ;
		
		

		if (handler.isLeft())
			VelX = -5 ; 
		else if (!(handler.isRight()))
			VelX = 0;
		
	
		
		
	}

	private void collision() {
		for(int i = 0; i < handler.object.size(); i++) {
				GameObject tempObject = handler.object.get(i);
				if(tempObject.getId() == ID.boîte) {
					if(getBounds().intersects(tempObject.getBounds())) {
						x+=VelX*-1;
						y+= VelY*-1;
					}
				}
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, 32, 48);
	
		
	}

	
	public Rectangle getBounds() {
		
		return new Rectangle(x, y, 32, 48);
	}
	
	

}
