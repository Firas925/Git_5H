import static org.junit.jupiter.api.Assertions.*;


import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import win.main.*; 

import org.junit.jupiter.api.Test;

class tests {

	@Test
	void testHerosDown() {
		
	     	Game game = new Game(); 
			Handler handler = new Handler();
			int x = 50;
			int y = 50;
			Camera camera = new Camera(x,y);
			BufferedImageLoader loader  = new BufferedImageLoader();
			BufferedImage image = loader.loadImage("/wizard_images.png");
			SpriteSheet ss = new SpriteSheet(image);
			hero Heros = new hero(x,y,ID.joueur,handler, game,camera,ss);
			handler.setDown(true);
			Heros.tick();
			handler.setDown(false);
			assertEquals(Heros.getX(),x);
			assertTrue(Heros.getY()<y);
		}
	

	// le hÃ©ros ne traverse pas les murs
	@SuppressWarnings("unused")
	@Test
	public void testMurHeros() {

		Game game = new Game(); 
		Handler handler = new Handler();
		Camera camera = new Camera(50,50);
		BufferedImageLoader loader  = new BufferedImageLoader();
		BufferedImage image = loader.loadImage("/wizard_images.png");
		SpriteSheet ss = new SpriteSheet(image);
		hero heros = new hero(50,50, ID.joueur ,handler, game,camera,ss);
		int y = heros.getY();
		Box box = new Box(50,53,ID.boîte,ss);
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
		BufferedImageLoader loader  = new BufferedImageLoader();
		BufferedImage image = loader.loadImage("/wizard_images.png");
		SpriteSheet ss = new SpriteSheet(image);
		Monstre Monstre = new Monstre(50,50, ID.monstre ,handler, game,ss);
		int y = Monstre.getY();
		Box box = new Box(50,53,ID.boîte,ss);
		handler.setUp(true);
		Monstre.tick();
		assertEquals(y,Monstre.getY());
	}
	
	// les fantÃ´mes traversent les murs
	@Test
	public void testMurFantome() {

		Game game = new Game(); 
		Handler handler = new Handler();
		BufferedImageLoader loader  = new BufferedImageLoader();
		BufferedImage image = loader.loadImage("/wizard_images.png");
		SpriteSheet ss = new SpriteSheet(image);
		Fantome fantome = new Fantome(50,50, ID.fantome ,handler, game,ss);
		int y = fantome.getY();
		Box box = new Box(50,53,ID.boîte,ss);
		while(fantome.getY()<=box.getY()) {
			handler.setUp(true);
			fantome.tick();
		}
		handler.setUp(false);
		assertTrue(y<fantome.getY());
	}
	
	
	// le hÃ©ros perd des points de vie lorsqu'il marche sur une case piÃ¨ge
	
	@Test
	public void testPertePVPiege() {
		Game game = new Game(); 
		Handler handler = new Handler();
		Camera camera = new Camera(80,80);
		BufferedImageLoader loader  = new BufferedImageLoader();
		BufferedImage image = loader.loadImage("/wizard_images.png");
		SpriteSheet ss = new SpriteSheet(image);
		hero Heros = new hero(80,80,ID.joueur,handler,game,camera,ss);
		int pv = 100; 
		magique Magique = new magique(46, 72, ID.magique,ss);
		while (Heros.getX()>16) {
			handler.setLeft(true);
			Heros.tick();
		}
		handler.setLeft(false);
		assertTrue(win.main.Game.ptvieH<pv);
	}
	
	// le hÃ©ros gagne des points de vie lorsqu'il marche sur une case magique
	@Test
	public void testGainPVMagique() {
		Game game = new Game(); 
		Handler handler = new Handler();
		Camera camera = new Camera(80,80);
		BufferedImageLoader loader  = new BufferedImageLoader();
		BufferedImage image = loader.loadImage("/wizard_images.png");
		SpriteSheet ss = new SpriteSheet(image);
		hero Heros = new hero(80,80,ID.joueur,handler,game,camera,ss);
		int pv = 100; 
		magique Magique = new magique(46, 72, ID.magique,ss);
		while (Heros.getX()>16) {
			handler.setLeft(true);
			Heros.tick();
		}
		handler.setLeft(false);
		assertTrue(win.main.Game.ptvieH>pv);
	}
	
	// le monstre perd des points de vie lorsque le hÃ©ros l'attaque
	@Test
	public void testPertePVMonstre() {
		Game game = new Game(); 
		Handler handler = new Handler();
		BufferedImageLoader loader  = new BufferedImageLoader();
		BufferedImage image = loader.loadImage("/wizard_images.png");
		SpriteSheet ss = new SpriteSheet(image);
		
		Monstre Monstre = new Monstre(50,50, ID.monstre ,handler, game,ss);
		int pv = Game.ptvieM; 
		int balle = Game.balle;
		Monstre.tick();
		assertTrue(Game.ptvieM<pv);
		// trop compliquÃ© Ã  tester car pour attaquer, le joueur doit cliquer sur la souris et les balles ont une trajectoire trop alÃ©atoire
		
	}
}
	
	