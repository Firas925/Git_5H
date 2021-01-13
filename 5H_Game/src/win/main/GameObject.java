package win.main;

import java.awt.Graphics;
import java.awt.Rectangle ;
 
public abstract class GameObject {
	
	 protected int x , y ;  //coordonnées 
	 protected float VelX =0 , VelY = 0 ; // vitesse
	 public ID id;
	 protected SpriteSheet ss;
	 
	 public GameObject(int x , int y, ID id, SpriteSheet ss ) {
		 this.x=x;
		 this.y=y;
		 this.id = id;
		 this.ss = ss;
	 }

	 


	public abstract void tick() ;
	public abstract void render (Graphics g) ;
	public abstract Rectangle getBounds() ;
	 
	 public ID getId() {
			return id;
		}

		public void setId(ID id) {
			this.id = id;
		}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public float getVelX() {
		return VelX;
	}

	public void setVelX(float velX) {
		this.VelX = velX;
	}

	public float getVelY() {
		return VelY;
	}

	public void setVelY(float velY) {
		VelY = velY;
	}
	 
	  

}
