import java.awt.Graphics2D;

public class GameObject {
	protected Sprite sprite;
	protected double x, y, w, h, velX, velY;
	protected boolean collidesWithPlayer;

	public GameObject(double posX, double posY, double width, double height, boolean cWP, Sprite s) {
		x = posX;
		y = posY;
		w = width;
		h = height;
		collidesWithPlayer = cWP;
	}

	public GameObject(double posX, double posY, double width, double height, boolean cWP, Sprite s, double vX,
			double vY) {
		this(posX, posY, width, height, cWP, s);
		velX = vY;
		velY = vY;
	}

	public void drawOn(Graphics2D g) {
		// sprite.drawOn(g);
		g.fillRect((int) x, (int) y, (int) w, (int) h);
	}

	public void update() {
		x += velX;
		y += velY;
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
