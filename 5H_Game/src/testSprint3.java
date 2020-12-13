import static org.junit.jupiter.api.Assertions.*;
import win.main.*; 

import org.junit.jupiter.api.Test;

class testSprint3 {

	@Test
	void testDown() {
		
	     	Game game = new Game(); 
			Handler handler = new Handler();
			//hero = new hero(50,50,ID.joueur,handler, game);
			handler.setDown(true);
			assertTrue(handler.isDown());
		}
	

	@Test
	void testUp() {
		
	     	Game game = new Game(); 
			Handler handler = new Handler();
			//hero = new hero(50,50,ID.joueur,handler, game);
			handler.setUp(true);
			assertTrue(handler.isUp());
		} 
	
	
	
	
	
	@Test
	void testRight() {
		
	     	Game game = new Game(); 
			Handler handler = new Handler();
			//hero = new hero(50,50,ID.joueur,handler, game);
			handler.setRight(true);
			assertTrue(handler.isRight());
		} 
	
	
	@Test
	void testLeft() {
		
	     	Game game = new Game(); 
			Handler handler = new Handler();
			//hero = new hero(50,50,ID.joueur,handler, game);
			handler.setLeft(true);
			assertTrue(handler.isLeft());
		} 

}
	
	




