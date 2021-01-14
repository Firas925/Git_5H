package win.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Monstre  extends GameObject {
	
	private Handler handler ;
	
	Random r = new Random() ;
	int choose = 0 ; 
	int hp=100 ;
	
	private BufferedImage monster_image;
	Game game ;

	

	public Monstre(int x, int y, ID id , Handler handler , Game game, SpriteSheet ss) {
		super(x, y, id, ss);
		this.handler=handler ;
		this.game=game ;
		
		monster_image = ss.grabImage(4, 1, 32, 32);
	}

	
	public void tick() {
		x+=VelX;
		y+=VelY ;
		
		choose = r.nextInt(5) ;
		for(int i = 0 ;i<handler.object.size();i++ ) {
			
			  GameObject tempObject =handler.object.get(i) ;
			  if((tempObject.getId()==ID.boîte ) || (tempObject.getId()==ID.piege ) || (tempObject.getId()==ID.magique) || (tempObject.getId()==ID.passage) || (tempObject.getId()==ID.tresor) ){
				  
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
			  if(tempObject.getId() == ID.balle) { 
				  if(getBounds().intersects(tempObject.getBounds())) {
				  hp-=50 ; 
				  handler.removeObject(tempObject);
				  }
			  }
			  	  
		}
		
		
		if(hp<=0) {handler.removeObject(this);
					Game.ptvieM -=25 ;}
		
		if(Game.ptvieM<=0) {
			System.out.println("Félicitations, vous avez gagné !");
		}
	}

	
	public void render(Graphics g) {
		g.drawImage(monster_image,x, y, null);
		
		
		
		 
		
		
	}

	
	public Rectangle getBounds() {
		
		return new Rectangle(x,y,32,32);
	}
	
	
	public Rectangle getBoundsBig() {
		
		return new Rectangle(x-20,y-20,64,64);
	} 
	
	 private boolean intersection 	(int i) {return true ;}
}
