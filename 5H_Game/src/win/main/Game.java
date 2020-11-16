package win.main;

import java.awt.Canvas ;


public class Game extends  Canvas implements Runnable {
	
	
	
	private boolean isRunning = false ; 
	private Thread thread ; 
	
	private static final long serialVersionUID = 1L;


	public Game () { 
		new Window(1000,700,"5H_Game",this) ;
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
		
		
	}
	
    
	public static void main(String[] args) {
		
		new Game () ; 

	}




	
}
