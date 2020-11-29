package win.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
	
	Handler handler ; // on fait pas handler = new handler car on va créer une nvll liste 
	
	
	public KeyInput (Handler handler) {
		this.handler = handler ;
		
		
	}
	
	
	public void keyPressed (KeyEvent e) {
		
		 int key= e.getKeyCode();
		  for (int i =0 ; i<handler.object.size(); i++) {
			  GameObject tempObject = handler.object.get(i) ;
			  
			  if (tempObject.getId() == ID.joueur) { //chercher hero 
				
				  //deplacer hero
				  
				  if (key ==KeyEvent.VK_UP)
					  handler.setUp(true) ;
					  
				  if (key ==KeyEvent.VK_DOWN) // oui 
					  handler.setDown(true) ;
				  
				  if (key ==KeyEvent.VK_LEFT)  // oui 
					  handler.setLeft(true) ;
				  
				  if (key ==KeyEvent.VK_RIGHT)
					  handler.setRight(true) ;
				  
					
			  }
		  }
		
	}
	
	public void keyReleased (KeyEvent e) {
		
		
		 int key= e.getKeyCode();
		  for (int i =0 ; i<handler.object.size(); i++) {
			  GameObject tempObject = handler.object.get(i) ;
			  
			  if (tempObject.getId() == ID.joueur) { //chercher hero 
				
				  
				  if (key ==KeyEvent.VK_UP)
					  handler.setUp(false) ;
					  
				  if (key ==KeyEvent.VK_DOWN)
					  handler.setDown(false) ;
				  
				  if (key ==KeyEvent.VK_LEFT)
					  handler.setLeft(false) ;
				  
				  if (key ==KeyEvent.VK_RIGHT)
					  handler.setRight(false) ;
				  
					
			  }
		  }
		
		
	}
}
