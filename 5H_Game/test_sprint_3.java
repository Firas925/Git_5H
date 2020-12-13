import static org.junit.Assert.*;
import win.main.*;

import org.junit.Test;

public class test_sprint_3 {

	@Test
	public void testDownHeros() {
		
		Game game = new Game(); 
		Handler handler = new Handler();
		heros = new hero(50,50, joueur() ,handler, game);
		handler.down = true;
		assertTrue(handler.isDown());
	}
	
	@Test
	public void testMurHeros()

}
