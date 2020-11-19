package win.main;


import java.awt.Canvas ;
import java.awt.Color;
//import java.awt.Font;
import java.awt.Graphics;
//import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
//import java.awt.image.BufferedImage;



public class Game extends  Canvas implements Runnable {
	
	
	
	private boolean isRunning = false ; 
	private Thread thread ; 
	
	private static final long serialVersionUID = 1L;
	private Handler handler ; 
	
	

	public Game () { 
		new Window(1000,700,"5H_Game",this) ;
		start() ;
		
		handler = new Handler () ;
	//	int j =0 ; 
	//	for (int i=100 ; i<1000 ; i+=100) {
    //handler.addObject(new Box(100,100,ID.obstacle));
	//	j=j+22 ;}
	  
		 
		this.addKeyListener(new KeyInput (handler));  // listening key input 
		
		handler.addObject(new hero(100 , 100 , ID.joueur, handler));
		
		
		
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
		
		handler.tick() ;
	}
    
	
	public  void render () {
		BufferStrategy bs ;
		bs = this.getBufferStrategy() ;
		if(bs == null) {
			this.createBufferStrategy(3);
			return; }
		
		 
		 Graphics g = bs.getDrawGraphics() ;
		
		 g.setColor(Color.CYAN);
		// g.drawRect (0,0 , 1000, 700);
		 g.fillRect(0, 0, 1000, 700); 
		 
		 
	    handler.render(g);
		 
		 g.dispose();
		 bs.show() ; 
			
	}
	public static void main(String[] args) {
		
		Game game = new Game() ; 
		
	
		
		

	}




	
}