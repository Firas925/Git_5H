
package win.main;

import java.awt.Color;
import java.awt.Graphics ;
import java.awt.Rectangle ;

public class hero extends GameObject {

	 
	
	public static int tr; 
	Handler handler ; 
	Game game ;
	public static int BS = 0;
	
	public hero(int x, int y, ID id , Handler handler, Game game) {
		super(x, y, id);
		this.handler = handler ;
		this.game=game ;
	
	}

	




	public void tick() {
		x+=VelX ; // evolution de la postion  
		y+=VelY ;
		
		collision() ;
		
		// d�placement 
		
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
				
				if(tempObject.getId() == ID.bo�te) {
					if(getBounds().intersects(tempObject.getBounds())) {
						x+=VelX*-1;
						y+= VelY*-1;
					}
				}
				
				
				
				if(tempObject.getId() == ID.passage) {
					if(getBounds().intersects(tempObject.getBounds())) {
						handler.removeObject(tempObject);
						handler.removeObject(this);
						handler.addObject(new hero(170,180, ID.joueur, handler,game));
						
					
					}}
				
				
				if(tempObject.getId() == ID.piege) {
					if(getBounds().intersects(tempObject.getBounds())) {
						
						Game.ptvieH -=5 ;
						handler.removeObject(tempObject);}}
						
				if(tempObject.getId() == ID.magique) {
					if(getBounds().intersects(tempObject.getBounds())) {
						
						if(BS==0) {
						Game.ptvieH +=5;
						handler.removeObject(tempObject);
						BS=1;
						}
						else {
							Game.balle +=30;
							handler.removeObject(tempObject);
							BS=0;
							
						}
				}}
				
				
				if(tempObject.getId() == ID.tresor) {
					if(getBounds().intersects(tempObject.getBounds())) {
						
						handler.removeObject(tempObject);
						tr = 1 ;
						System.out.println("Vous avez atteint la case tr�sor, le joueur a gagn�! ");
						
					} 
				}
				
				if(tempObject.getId() == ID.monstre) {
					if(getBounds().intersects(tempObject.getBounds())) {
						
						Game.ptvieH-- ;
						}
		
		}
				if(tempObject.getId() == ID.fantome) {
					if(getBounds().intersects(tempObject.getBounds())) {
						
						Game.ptvieH-- ;
						}
		
		}
					
					
				}
		if (Game.ptvieH<=0) {
			game.okhero = -1;
			handler.removeObject(this);
			System.out.print("Votre h�ro est mort. GAME OVER !") ;
		}
		}
		
		
	
	public static int getTr() {
		return tr;
	}






	public static void setTr(int tr) {
		hero.tr = tr;
	}






	public void render(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, 32, 48);
	
		
	}

	
	public Rectangle getBounds() {
		
		return new Rectangle(x, y, 32, 48);
	}
	
	

}

