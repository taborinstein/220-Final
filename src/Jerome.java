
public class Jerome extends GameObject {
	public static final double JEROME_WIDTH = 42*2;
	public static final double JEROME_HEIGHT = 58*2;
	public static final double X_SPEED = 4;
	public static final double Y_SPEED = 4;
	public static final double GRAVITY = 6;
	
	public Jerome(double posX, double posY, Sprite s) {
		super(posX, posY, JEROME_WIDTH, JEROME_HEIGHT, false, false, s);
		
	}
	public void update(String input) {
		if(input.contains("d"))
			velX = X_SPEED;
		else if(input.contains("a"))
			velX = -X_SPEED;
		else {
			velX = 0;
		}
		if(input.contains("w"))
			velY = -Y_SPEED;
		else {
			velY = GRAVITY;
		}
		super.update();
		//do stuff
	}
	
}
