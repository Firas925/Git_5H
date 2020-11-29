package win.main;

import java.awt.Dimension;

import java.awt.Canvas ;

import javax.swing.JFrame ;


public class Window  extends Canvas{

	private static final long serialVersionUID = 1L;

		public Window (int width , int height , String titre , Game game ) {
			
			JFrame frame = new JFrame(titre) ; 
			frame.setPreferredSize(new Dimension (width, height));
			frame.setMaximumSize(new Dimension(width, height));
			frame.setMinimumSize(new Dimension(width, height));
			
			frame.add(game) ; 
			frame.setResizable(false);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			
			
			
			
			
		}
	
}
