package win.main;


import java.awt.Canvas ;
import java.awt.Color;
import java.awt.Font;
//import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
//import java.awt.Menu;
//import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
//import java.awt.image.BufferedImage;

//import win.main.Game.STATE;


public class Game extends  Canvas implements Runnable {
	
	
	private static final long serialVersionUID = 1L;	
	private boolean isRunning = false ;
	
	private Thread thread ; 
	private Camera camera;
	private Handler handler ; 
	private SpriteSheet ss;
	
	
	public static  int ptvieH = 100 ;
	
	public static int ptvieM = 100 ;
	
	public static int l = 1;    //level
	
	
	public int okhero = 0 ;
	public int okmonstre = 0 ;
	public int oktresor = 0 ;
	public static int trA=0;
	
	
	
	public static int balle = 100 ;
	
	
	
	
	/*public int getPtvieH() {
		return ptvieH;
	}

	public void setPtvieH(int ptvieH) {
		this.ptvieH = ptvieH;
	}*/
	
	
	private BufferedImage level = null;
	private BufferedImage sprite_sheet = null;
	private BufferedImage floor = null;
	
	
	
   private Menu menu;
   
	
	/*public enum STATE {
		Menu(),
		/*Help,
		init,
		GameOver,
		Pause,
		win,
		Finish,
		Game()
	}; */
	
	public STATE gameState=STATE.Menu;

	public Game () { 
		
		menu = new Menu(this,handler);
		new Window(1000,700,"5H_Game",this) ;
		
		start() ;
		this.addMouseListener(menu);
		handler = new Handler () ;
		camera = new Camera(0,0) ;
		
	//	if(gameState==STATE.Game) {
		this.addKeyListener(new KeyInput(handler));
		
		
	
		BufferedImageLoader loader  = new BufferedImageLoader();
		level = loader.loadImage("/lvltest9.png");
		sprite_sheet = loader.loadImage("/wizard_images.png");
		
		ss = new SpriteSheet(sprite_sheet);
		
		floor = ss.grabImage(4, 2, 32, 32);
		
		this.addMouseListener(new MouseInput(handler,camera,this, ss));
		
		loadLevel(level);// }
		gameState=STATE.Menu ;
	
	}  
	
	
	
	
	private void start () {
		isRunning = true ; 
		thread = new Thread(this) ;
		thread.start();
	}
	private void stop () {
		
		isRunning = false ; 
		try {
		thread.join() ; }
		catch (InterruptedException e) { e.printStackTrace(); }
		
	
		
	
	}
		
	
	public void run() {
		
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(isRunning) {
			long now = System.nanoTime();
			delta += (now - lastTime)/ns;
			lastTime = now;
			while(delta>=1) {
				tick();
				delta--;
			}
			render();
			frames++;
			if(System.currentTimeMillis() - timer > 1000) {
				timer+= 1000;
				frames = 0;
				
			}
		
		}
		stop() ;
	} 
	
	public void tick() {   // to update everything in the game 
		if(gameState==STATE.Game) {
		for(int i = 0; i<handler.object.size();i++) {
			if(handler.object.get(i).getId() == ID.joueur) {
				camera.tick(handler.object.get(i));
			}
		}
			
		handler.tick() ;
			
		
		  if (ptvieH <= 0) {	
			gameState = STATE.GameOver ; }
		  if (ptvieM<=0)
			  gameState = STATE.pasPTVIEM ;
		  if (trA==1)
			  gameState = STATE.Tresorr ;
			
		}
		
		}

	
    
	
	public  void render () {
		BufferStrategy bs ;
		bs = this.getBufferStrategy() ;
		if(bs == null) {
			this.createBufferStrategy(3);
			return; 
			
		}
		
		
		 Graphics g = bs.getDrawGraphics() ;
		 Graphics2D g2d = (Graphics2D) g;
		 /////////////////////////////////
		 if(gameState==STATE.Game) {
			 
		 
		 g2d.translate(-camera.getX(), -camera.getY());
		 
		 for(int xx=0; xx<32*100; xx+=32) {
			   for(int yy=0; yy<32*100; yy+=32) {
				   g.drawImage(floor,xx,yy,null);
			   }
		   }
		 handler.render(g);
	    
	   
	    
	    g2d.translate(camera.getX(), camera.getY());
	    
	    
	     g.setColor(Color.gray);
		 g.fillRect(50, 20, 200, 32); 
	     g.setColor(Color.green);
		 g.fillRect(50, 20, 2*ptvieH, 32); 
	     g.setColor(Color.black);
		 g.drawRect(50, 20, 200, 32); 
		 g.setColor(Color.white);
		 g.drawString(" hero " , 50 , 20 );
	    
		 
	     g.setColor(Color.gray);
		 g.fillRect(750, 20, 200, 32); 
	     g.setColor(Color.red);
		 g.fillRect(750, 20, 2*ptvieM, 32); 
	     g.setColor(Color.black);
		 g.drawRect(750, 20, 200, 32);
		 g.setColor(Color.white);
		 g.drawString(" monstre " , 750 , 20 );
	    
			Font fnt = new Font("Courier",1,20);
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Balle "+ balle ,400,20);
		 
		
		 for(int i = 0; i<handler.object.size();i++) {
				if(handler.object.get(i).getId() == ID.joueur) { 
					
					GameObject temp =  handler.object.get(i);
					 hero h = (hero) temp  ;
					if(h.getTr() == 1) {
						 g.setColor(Color.yellow);
						 g.drawRect(50, 750, 200, 32);
						 g.setColor(Color.yellow);
						 g.drawString(" Vous avez gagné " , 50 , 750 );
						
						
					}
						
				}
					
		   
		   
		   
	   } /********* definition menu*********/
	    }
		 else if (gameState==STATE.Menu)
	    	
	    	
	        {
	        Font fnt= new Font("arial",1,50);
	        Font fnt2= new Font("arial",1,30);
	        
	        
	    	g.setFont(fnt);
	    	g.drawString("MENU", 400, 100);
	    	
	    	
	    	g.setFont(fnt2);
	    	g.drawString("START", 420, 240);
	    	g.drawString("HELP", 430, 310);
	    	g.drawString("QUIT", 430, 380);
	    	
	    	
	    	g.drawRect(370,200,200, 64);
	        g.drawRect(370,270, 200, 64);
	        g.drawRect(370,340, 200, 64);}
		 
		 else if (gameState==STATE.Help)	
	        {
			 Font fnt= new Font("arial",1,20);

			 g.setFont(fnt);
			 g.drawString("utiliser les flèches pour le déplacement", 200, 500);
			 g.drawString("cliquer sur la souris pour activer les armes", 200, 530);
			 g.drawString("Case magique : vous gagnez des armes et des points de vie", 200, 560);
			 g.drawString("Case Passage : couleur verte :  téléportation de l'héro", 200, 590);
			 g.drawString("Case Piège : couleur jaune : perdre des points de vie", 200, 620);
			 g.drawString("Case trésor : couleur grise : vous gagnez", 200, 650);
			 gameState=STATE.Menu ;
			
			 
			 
	        }
		 
		 
		 
		 else if (gameState==STATE.GameOver)	
	        {
			 Font fnt3= new Font("arial",1,60);
			 g.setColor(Color.yellow);
			 g.setFont(fnt3);
			 g.drawString("GAME OVER", 350, 400);
			 
	        }
		 else if (gameState==STATE.Tresorr)	
	        {
			 Font fnt3= new Font("arial",1,40);
			 g.setColor(Color.yellow);
			 g.setFont(fnt3);
			 g.drawString("Case trésor atteinte,Vous a gagné !", 30, 400);
			// gameState=STATE.Game ;
			// g.drawString("Niveau 2", 30, 400);
			 
			 
			 
	        }
		 else if (gameState==STATE.pasPTVIEM)	
	        {
			 Font fnt3= new Font("arial",1,60);
			 g.setColor(Color.yellow);
			 g.setFont(fnt3);
			 g.drawString("Vous avez gagné !", 350, 400);
			 
	        }
		 
		 
		 
		 
	    
	    /////////////////////////////////
		 
		 g.dispose();
		 bs.show() ;
			
	}
	
	//loading the level
	private void loadLevel(BufferedImage image) {
		int w = image.getWidth();
		int h = image.getHeight();
		for(int xx=0; xx < w; xx++ ) {
			for( int yy=0; yy< h; yy++) {
				int pixel = image.getRGB(xx, yy);
				// >> operator is the right shift operator int(32 bits)
				// & with 0xff applies a bitmask (conservs only last 8 bits of pixel, setting the other values to 0
				int red = (pixel >> 16) & 0xff; 
				int green = (pixel >> 8) & 0xff;// 
				int blue = (pixel) & 0xff;
				
				
				if ((red==0) & (green ==150 ) & (blue == 150))
					handler.addObject(new passage(xx*32,yy*32, ID.passage, ss));
				
				

				if ((red==255) & (green ==149 ) & (blue == 0)) {
					handler.addObject(new tresor(xx*32,yy*32, ID.tresor, ss)); 
					oktresor = 1 ;}

				if ((red==153) & (green == 153 ) & (blue ==153))
					handler.addObject(new tresor(xx*32,yy*32, ID.tresor, ss));

				
				if ((red == 50) & (green == 50 ) & (blue == 50))
					{handler.addObject(new piege(xx*32,yy*32, ID.piege, ss)) ;
					System.out.println("xx"+xx+"yy"+yy) ;
					
					}
				
				if((red==150) & (green ==0 ) & (blue == 80))
					handler.addObject(new magique(xx*32, yy*32, ID.magique, ss));
				
							
				
				if ((red > 200) & (green > 200) & (blue  < 10))
					handler.addObject(new Fantome(xx*32,yy*32, ID.fantome,handler,this, ss));
			
				if (red ==0 & green == 0 & blue == 0)
					handler.addObject(new Box(xx*32,yy*32, ID.boîte, ss));
				
				if (green == 255) {
					handler.addObject(new Monstre(xx*32,yy*32, ID.monstre, handler,this, ss));
					okmonstre = 1 ;}

				
				if ( blue == 255 & red==0 & green==0) {
					handler.addObject(new hero(xx*32,yy*32, ID.joueur, handler,this,camera, ss)); 

				    okhero = 1 ;}
			}
			}
		
		
		
	}
	
 private	int CalculPointdeVie (int i)
	 {return (ptvieM-i) ;}
 
 private	int CAlculBalle (int i)
 {return (balle+i) ;}
 
 
	public static void main(String[] args) {
		
		
		Game game = new Game() ; 
		
		if (game.okhero == 0) 
			System.out.print("hero n'existe pas \n") ;
		
		else if (game.okhero == -1) {
			game.stop();
		}
		
		if (Game.ptvieM<=0)
			game.stop();
			
		if (game.okmonstre == 0) 
			System.out.print("monstre n'existe pas") ;
		
		if (game.oktresor == 0) 
			System.out.print("tresor n'existe pas") ;
		
		

	}




	
}