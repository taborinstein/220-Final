import java.awt.Graphics2D;

public class Coin extends GameObject{
	private static final double COIN_WIDTH = 50;
	private static final double COIN_HEIGHT = 50;
	
	public Coin(double x, double y, Sprite s)
	{
		super(x,y,COIN_WIDTH,COIN_HEIGHT,true,false,s);
	}
	
//	public void drawOn(Graphics2D g)
//	{
//		sprite.drawOn();
//	}
}
