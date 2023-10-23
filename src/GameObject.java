import java.awt.Graphics2D;

public class GameObject {
	protected Sprite sprite;
	protected double x,y,w,h,velX,velY;
	protected boolean collidesWithPlayer;
	protected boolean damagesPlayer;
	
	public GameObject(double ex, double why, double width, double height, boolean cWP, boolean dP, Sprite s)
	{
		x = ex;
		y = why;
		w = width;
		h = height;
		collidesWithPlayer = cWP;
		damagesPlayer = dP;
		sprite = s;
		//velX = 0;
		//velY = 0;
	}
	public GameObject(double ex, double why, double width, double height, boolean cWP, boolean dP, Sprite s,double vX, double vY)
	{
		this(ex,why,width,height,cWP,dP,s);
		//System.out.println(vX);
		this.velX = vX;
		this.velY = vY;
	}

	public void drawOn(Graphics2D g) {
		// sprite.drawOn(g);
		//g.fillRect((int) x, (int) y, (int) w, (int) h);
		sprite.drawOn(g,(int)x,(int)y,(int)w,(int)h);
	}

	public void update() {
		//System.out.println(x+" "+velX+" "+y+" "+velY);
		x += velX;
		y += velY;
		//System.out.println(x+" "+y+"\n");
	}

	public boolean overlapsWith(GameObject other) {
		return other.getX() + other.getW() >= x && other.getX() <= x + w && other.getY() + other.getH() >= y
				&& other.getY() <= y + h;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getW() {
		return w;
	}

	public void setW(double w) {
		this.w = w;
	}

	public double getH() {
		return h;
	}

	public void setH(double h) {
		this.h = h;
	}

	public double getVelX() {
		return velX;
	}

	public void setVelX(double velX) {
		this.velX = velX;
	}

	public double getVelY() {
		return velY;
	}

	public void setVelY(double velY) {
		this.velY = velY;
	}

	public boolean isCollidesWithPlayer() {
		return collidesWithPlayer;
	}

	public void setCollidesWithPlayer(boolean collidesWithPlayer) {
		this.collidesWithPlayer = collidesWithPlayer;
	}

}
