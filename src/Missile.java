
public class Missile extends GameObject{
	private final static double DEFAULT_WIDTH = 10;
	private final static double DEFAULT_HEIGHT = 10;
	
	public Missile(double ex, double why, double xV, double yV, Sprite s)
	{
		super(ex,why,DEFAULT_WIDTH,DEFAULT_HEIGHT,true,true,s,xV,yV);
	}
	
}
