import static org.junit.jupiter.api.Assertions.*;


import java.awt.event.MouseEvent;

import win.main.*; 

import org.junit.jupiter.api.Test;

class testSprint3 {

	@Test
	void testHerosDown() {
		
	     	Game game = new Game(); 
			Handler handler = new Handler();
			int x = 50;
			int y = 50;
			hero Heros = new hero(x,y,ID.joueur,handler, game);
			
			handler.setDown(true);
			Heros.tick();
			handler.setDown(false);
			assertEquals(Heros.getX(),x);
			assertTrue(Heros.getY()<y);
		}
	

	// le héros ne traverse pas les murs
	@SuppressWarnings("unused")
	@Test
	public void testMurHeros() {

		Game game = new Game(); 
		Handler handler = new Handler();
		hero heros = new hero(50,50, ID.joueur ,handler, game);
		int y = heros.getY();
		Box box = new Box(50,53,ID.boîte);
		handler.setUp(true);
		heros.tick();
		assertEquals(y,heros.getY());
	}
	
	// les monstres ne traversent pas les murs
	@SuppressWarnings("unused")
	@Test
	public void testMurMonstre() {

		Game game = new Game(); 
		Handler handler = new Handler();
		Monstre Monstre = new Monstre(50,50, ID.monstre ,handler, game);
		int y = Monstre.getY();
		Box box = new Box(50,53,ID.boîte);
		handler.setUp(true);
		Monstre.tick();
		assertEquals(y,Monstre.getY());
	}
	
	// les fantômes traversent les murs
	@Test
	public void testMurFantome() {

		Game game = new Game(); 
		Handler handler = new Handler();
		Fantome fantome = new Fantome(50,50, ID.fantome ,handler, game);
		int y = fantome.getY();
		Box box = new Box(50,53,ID.boîte);
		while(fantome.getY()<=box.getY()) {
			handler.setUp(true);
			fantome.tick();
		}
		handler.setUp(false);
		assertTrue(y<fantome.getY());
	}
	
	
	// le héros perd des points de vie lorsqu'il marche sur une case piège
	
	@Test
	public void testPertePVPiege() {
		Game game = new Game(); 
		Handler handler = new Handler();
		hero Heros = new hero(80,80,ID.joueur,handler,game);
		int pv = 100; 
		magique Magique = new magique(46, 72, ID.magique);
		while (Heros.getX()>16) {
			handler.setLeft(true);
			Heros.tick();
		}
		handler.setLeft(false);
		assertTrue(win.main.Game.ptvieH<pv);
	}
	
	// le héros gagne des points de vie lorsqu'il marche sur une case magique
	@Test
	public void testGainPVMagique() {
		Game game = new Game(); 
		Handler handler = new Handler();
		hero Heros = new hero(80,80,ID.joueur,handler,game);
		int pv = 100; 
		magique Magique = new magique(46, 72, ID.magique);
		while (Heros.getX()>16) {
			handler.setLeft(true);
			Heros.tick();
		}
		handler.setLeft(false);
		assertTrue(win.main.Game.ptvieH>pv);
	}
	
	// le monstre perd des points de vie lorsque le héros l'attaque
	@Test
	public void testPertePVMonstre() {
		Game game = new Game(); 
		Handler handler = new Handler();
		
		Monstre Monstre = new Monstre(50,50, ID.monstre ,handler, game);
		int pv = Game.ptvieM; 
		int balle = Game.balle;
		Monstre.tick();
		assertTrue(Game.ptvieM<pv);
		// trop compliqué à tester car pour attaquer, le joueur doit cliquer sur la souris et les balles ont une trajectoire trop aléatoire
		
	}
}
	
	





	