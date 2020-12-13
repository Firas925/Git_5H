import static org.junit.Assert.*;
import win.main.*;

import org.junit.Test;

public class test_sprint_3 {

	@Test
	public void testDownHeros() {
		
		Game game = new Game(); 
		Handler handler = new Handler();
		heros = new hero(50,50, ID.joueur ,handler, game);
		handler.down = true;
		assertTrue(handler.isDown());
	}
	
	@Test
	public void testUpHeros() {
		
		Game game = new Game(); 
		Handler handler = new Handler();
		heros = new hero(50,50, ID.joueur ,handler, game);
		handler.up = true;
		assertTrue(handler.isUp());
	}
	
	@Test
	public void testLeftHeros() {
		
		Game game = new Game(); 
		Handler handler = new Handler();
		heros = new hero(50,50, ID.joueur ,handler, game);
		handler.left = true;
		assertTrue(handler.isLeft());
	}
	
	@Test
	public void testRightHeros() {
		
		Game game = new Game(); 
		Handler handler = new Handler();
		heros = new hero(50,50, ID.joueur ,handler, game);
		handler.right = true;
		assertTrue(handler.isRight());
	}
	
	@Test
	public void testMurHeros() {

		Game game = new Game(); 
		Handler handler = new Handler();
		heros = new hero(50,50, ID.joueur ,handler, game);
		box = new Box(50,70,ID.boîte);
		handler.down = true;
		assertFalse(box.getBounds().intersects(heros.getBounds()));
		assertTrue(heros.y<box.y);
	}
	
	@Test
	public void testMurMonstre() {

		Game game = new Game(); 
		Handler handler = new Handler();
		monstre = new Monstre(50,50, ID.monstre ,handler, game);
		box = new Box(50,70,ID.boîte);
		handler.down = true;
		assertFalse(box.getBounds().intersects(monstre.getBounds()));
		assertTrue(monstre.y<box.y);
	}
	
	@Test
	public void testMurFantome() {

		Game game = new Game(); 
		Handler handler = new Handler();
		fantome = new Fantome(50,50, ID.fantome ,handler, game);
		box = new Box(50,70,ID.boîte);
		handler.down = true;
		assertTrue(box.getBounds().intersects(fantome.getBounds()));
		assertTrue(fantome.y>=box.y);
	}
	
	
	

@Test
public void testDownMonstre() {
	
	Game game = new Game(); 
	Handler handler = new Handler();
	monstre = new Monstre(50,50, ID.monstre ,handler, game);
	handler.down = true;
	assertTrue(handler.isDown());
}

@Test
public void testUpMonstre() {
	
	Game game = new Game(); 
	Handler handler = new Handler();
	monstre = new Monstre(50,50, ID.monstre ,handler, game);
	handler.up = true;
	assertTrue(handler.isUp());
}

@Test
public void testLeftMonstre() {
	
	Game game = new Game(); 
	Handler handler = new Handler();
	monstre = new Monstre(50,50, ID.monstre ,handler, game);
	handler.left = true;
	assertTrue(handler.isLeft());
}

@Test
public void testRightMonstre() {
	
	Game game = new Game(); 
	Handler handler = new Handler();
	monstre = new Monstre(50,50, ID.monstre ,handler, game);
	handler.right = true;
	assertTrue(handler.isRight());
}
}

