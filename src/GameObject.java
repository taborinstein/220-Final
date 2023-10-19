
public class GameObject {
	private Sprite sprite;
	private double x,y,w,h,velX,velY;
	private boolean collidesWithPlayer;
	
	public GameObject(double ex, double why, double width, double height, boolean cWP)
	{
		x = ex;
		y = why;
		w = width;
		h = height;
		collidesWithPlayer = cWP;
	}
}
