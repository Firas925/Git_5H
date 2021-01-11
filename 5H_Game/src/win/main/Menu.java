package win.main;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//import win.main.Game.STATE;

public class Menu extends MouseAdapter {
	private Game game ;
	private Handler handler ;
	
	
	
	

	public Menu(Game game, Handler handler) {
		this.game=game;
		this.handler=handler;
		
	}

	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my =e.getY();
		
		
		if (mouseOver(mx, my,370,200,200,64)) {	
			game.gameState=STATE.Game;
		}
		
	/*	if (mouseOver(mx, my,370,270, 200, 64)) {	
			game.gameState=STATE.Help;
		} */
		
		if (mouseOver(mx, my,370,340, 200, 64)) {	
			System.exit(1) ;
		}
		
		
		
	}
	
public void mouseReleased(MouseEvent e) {
		
	}
	

   private boolean mouseOver(int mx , int my,int x  , int y , int width , int height) {
	   
	   if((mx > x) &&(mx<mx+width)) {
		   if((my > y) &&(my<my+height)) { 
			   return true ;
		   }   
	   }
	   return false ;  
   } 
	
	
	public void tick() {}
	
	public void render(Graphics g) {
		g.drawRect(100,100, 100, 64);
	}

}
