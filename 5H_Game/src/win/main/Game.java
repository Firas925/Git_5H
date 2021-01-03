package win.main;


import java.awt.Canvas ;
import java.awt.Color;
import java.awt.Font;
//import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
//import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
//import java.awt.image.BufferedImage;


public class Game extends  Canvas implements Runnable {
	
	
	private static final long serialVersionUID = 1L;	
	private boolean isRunning = false ;
	
	private Thread thread ; 
	private Camera camera;
	private Handler handler ; 

	public static  int ptvieH = 100 ;
	
	public static int ptvieM = 100 ;
	
	
	
	
	public int okhero = 0 ;
	public int okmonstre = 0 ;
	public int oktresor = 0 ;
	
	
	
	public static int balle = 100 ;
	
	
	
	
	/*public int getPtvieH() {
		return ptvieH;
	}

	public void setPtvieH(int ptvieH) {
		this.ptvieH = ptvieH;
	}*/
	
	
	private BufferedImage level = null;
	
	

	public Game () { 
		
		new Window(1000,700,"5H_Game",this) ;
		start() ;
		
		handler = new Handler () ;
		camera = new Camera(0,0) ;
		this.addKeyListener(new KeyInput(handler));
		this.addMouseListener(new MouseInput(handler,camera,this));
		
		
		
		BufferedImageLoader loader  = new BufferedImageLoader();
		level = loader.loadImage("/lvltest9.png");
		
		loadLevel(level);
	
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
		for(int i = 0; i<handler.object.size();i++) {
			if(handler.object.get(i).getId() == ID.joueur) {
				camera.tick(handler.object.get(i));
			}
		}
			
		handler.tick() ;
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
		 
		 g.setColor(Color.cyan);
		 g.fillRect(0, 0, 1000, 700); 
		 
		 g2d.translate(-camera.getX(), -camera.getY());
		 
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
					handler.addObject(new passage(xx*32,yy*32, ID.passage));
				
				

				if ((red==255) & (green ==149 ) & (blue == 0)) {
					handler.addObject(new tresor(xx*32,yy*32, ID.tresor)); 
					oktresor = 1 ;}

				if ((red==153) & (green == 153 ) & (blue ==153))
					handler.addObject(new tresor(xx*32,yy*32, ID.tresor));

				
				if ((red == 50) & (green == 50 ) & (blue == 50))
					handler.addObject(new piege(xx*32,yy*32, ID.piege));
				
				if((red==150) & (green ==0 ) & (blue == 80))
					handler.addObject(new magique(xx*32, yy*32, ID.magique));
				
							
				
				if ((red > 200) & (green > 200) & (blue  < 10))
					handler.addObject(new Fantome(xx*32,yy*32, ID.fantome,handler,this));
			
				if (red ==0 & green == 0 & blue == 0)
					handler.addObject(new Box(xx*32,yy*32, ID.boîte));
				
				if (green == 255) {
					handler.addObject(new Monstre(xx*32,yy*32, ID.monstre, handler,this));
					okmonstre = 1 ;}

				
				if ( blue == 255 & red==0 & green==0) {
					handler.addObject(new hero(xx*32,yy*32, ID.joueur, handler,this)); 
				    okhero = 1 ;}
					
					
				
				
			
				
			}
		}
	}
	
	/*public void validLabyrinth() {
		
		
		
	}*/
			
	
	public static void main(String[] args) {
		
		
		Game game = new Game() ; 
		
		if (game.okhero == 0) 
			System.out.print("hero n'existe pas") ;
			
		if (game.okmonstre == 0) 
			System.out.print("monstre n'existe pas") ;
		
		if (game.oktresor == 0) 
			System.out.print("tresor n'existe pas") ;
			
		
		
	
		
		

	}




	
}