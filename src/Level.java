import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.awt.Graphics2D;
import java.io.File;
import java.io.FileNotFoundException;

public class Level {
	private ArrayList<Barrier> barriers;
	private ArrayList<GameObject> gameObjects;
	private Scanner scanner;
	
	public Level(String fileName,HashMap<String,Sprite> sprites)
	{
		barriers = new ArrayList<>();
		gameObjects = new ArrayList<>();
		try {
			scanner = new Scanner(new File(fileName));
			while(scanner.hasNext())
			{
				String objectType = scanner.next();
				switch (objectType)
				{
				case "Missile": gameObjects.add(new Missile(scanner.nextDouble(),scanner.nextDouble(),scanner.nextDouble(),scanner.nextDouble(),sprites.get(objectType)));
				break;
				case "Coin" :   gameObjects.add(new Coin(scanner.nextDouble(),scanner.nextDouble(),sprites.get(objectType)));
				break;
				case "Barrier": barriers.add(new Barrier(
						new Line(scanner.nextDouble(),scanner.nextDouble(),scanner.nextDouble(),scanner.nextDouble(),scanner.nextDouble(),scanner.nextDouble()),
						scanner.nextDouble(),
						scanner.nextDouble(),
						sprites.get(objectType)));
				break;
				}
			}
			scanner.close();
			
		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(fileName+" wasn't found /:");
		}
		
	}
	
	public boolean playerCollidesWithBarriers(GameObject player)
	{
		boolean collides = false;
		for(Barrier b : barriers)
			collides = collides||b.isIntersecting(player);
		return collides;
	}
	
	public void update()
	{
		for(Barrier b : barriers)
			b.update();
		for(GameObject q : gameObjects)
			q.update();
	}
	
	public void drawOn(Graphics2D g)
	{
		for(Barrier b : barriers)
			b.drawOn(g);
		for(GameObject q : gameObjects)
			q.drawOn(g);
	}
	
//	private void handleLine(String )
//	{
//		
//	}
}
