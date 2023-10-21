public class Coin extends GameObject{
	private static final double COIN_WIDTH = 50;
	private static final double COIN_HEIGHT = 50;
	
	public Coin(int x, int y, Sprite s)
	{
		super(x,y,COIN_WIDTH,COIN_HEIGHT,true,false,s);
	}
}
