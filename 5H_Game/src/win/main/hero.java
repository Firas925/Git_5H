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
		
		// déplacement 
		
		if (handler.isUp())
			VelY = -3 ;
		else if (!(handler.isDown()))
			VelY =0 ; 
		
		
		if (handler.isDown())
			VelY = 3 ;
		else if (!(handler.isUp()))
			VelY =0 ; 
		
		
		if (handler.isRight())
			VelX = +3 ; 
		else if (!(handler.isLeft()))
			VelX = 0 ;
		
		

		if (handler.isLeft())
			VelX = -3 ; 
		else if (!(handler.isRight()))
			VelX = 0;
		
	
		
		
	}

	
	public void render(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, 32, 48);
	
		
	}

	
	public Rectangle getBounds() {
		
		return new Rectangle(x, y, 32, 48);
	}
	
	

}
