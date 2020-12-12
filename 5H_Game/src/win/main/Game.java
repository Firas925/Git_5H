package win.main;


import java.awt.Canvas ;
import java.awt.Color;
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
	public int pointDeVie = 100;
	
	
	/*public int getPtvieH() {
		return ptvieH;
	}




	public void setPtvieH(int ptvieH) {
		this.ptvieH = ptvieH;
	}*/
	public int ptvieM = 100 ;
	
	private BufferedImage level = null;
	
	

	public Game () { 
		new Window(1000,700,"5H_Game",this) ;
		start() ;
		
		handler = new Handler () ;
		camera = new Camera(0,0) ;
		this.addKeyListener(new KeyInput(handler));
		
		BufferedImageLoader loader  = new BufferedImageLoader();
		level = loader.loadImage("/lvltest8.png");
		
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
				
				if ((red == 50) & (green == 50 ) & (blue == 50))
					handler.addObject(new piege(xx*32,yy*32, ID.piege));
				
				if ((red > 200) & (green > 200) & (blue  < 10))
					handler.addObject(new Fantome(xx*32,yy*32, ID.fantome,handler));
			
				if (red ==0 & green == 0 & blue == 0)
					handler.addObject(new Box(xx*32,yy*32, ID.bo�te));
				
				if (green == 255)
					handler.addObject(new Monstre(xx*32,yy*32, ID.monstre, handler));
				
				if ( blue == 255 )
					handler.addObject(new hero(xx*32,yy*32, ID.joueur, handler,this));
				if(yellow=255)
					handler.addObject(new Bonus(xx*32, yy*32, ID.bonus));
				

			
				
			}
		}
			
			
	}
	public static void main(String[] args) {
		
		Game game = new Game() ; 
		
		
		
	
		
		

	}




	
}