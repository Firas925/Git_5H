package win.main;

public class Camera {
	private float x,y;
	
	public Camera(float x,float y) {
		this.x = x;
		this.y = y;
		
	}
		
	public void tick(GameObject object) {
		
		//x = object.getX() - 1000/2;
		//y = object.getY() - 1000/2;
		x += ((object.getX() - x - 1000/2))*0.05f;
		y += ((object.getY() - y - 700/2))*0.05f;	
		if(x<=0) x = 0;
		if (x>=1032+1170) x = 1032+1170;
		if(y<=0) y = 0;
		if(y>= 700+1820) y = 700+1820;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
}
