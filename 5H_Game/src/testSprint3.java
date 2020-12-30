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

	
/*	@Test
	public void testMurHeros() {

		Game game = new Game(); 
		Handler handler = new Handler();
		GameObject gameObject = new GameObject(50,50,ID.bo�te) ;
		
		assertFalse(gameObject.getBounds().intersects(gameObject.getBounds()));
		assertTrue(heros.y<bo�te.y);
	}
	
	@Test
	public void testMurMonstre() {

		Game game = new Game(); 
		Handler handler = new Handler();
		Monstre = new Monstre(50,50, ID.monstre ,handler, game);
		Box = new Box(50,70,ID.bo�te);
		handler.setDown = true;
		assertFalse(bo�te.getBounds().intersects(monstre.getBounds()));
		assertTrue(monstre.y<bo�te.y);
	}
	
	@Test
	public void testMurFantome() {

		Game game = new Game(); 
		Handler handler = new Handler();
		fantome = new Fantome(50,50, ID.fantome ,handler, game);
		bo�te = new Box(50,70,ID.bo�te);
		handler.down = true;
		assertTrue(bo�te.getBounds().intersects(fantome.getBounds()));
		assertTrue(fantome.y>=bo�te.y);
	}
	*/
	
}
	
	




