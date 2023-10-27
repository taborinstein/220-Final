
public class Jerome extends GameObject {
	public static final double JEROME_WIDTH = 42*1.5;
	public static final double JEROME_HEIGHT = 58*1.5;
	public static final double X_SPEED = 10;
	public static final double Y_SPEED = 10;
	public static final double GRAVITY = 10;
	
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
		if(input.contains("w")) {
			sprite.setAnimation("flying");
			velY = -Y_SPEED;
		}
		else {
			sprite.setAnimation("idle");
			velY = GRAVITY;
		}
		if(y > JeromeMain.FRAME_H - JEROME_HEIGHT * 3 / 2) {
			y = JeromeMain.FRAME_H - JEROME_HEIGHT  * 3 / 2;
			sprite.setAnimation("idle");
		}
		if(y < 0) {
			y = 0;
		}
		super.update();
		//do stuff
	}
	
}
