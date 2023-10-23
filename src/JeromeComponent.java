import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JComponent;

public class JeromeComponent extends JComponent {

	//private ArrayList<GameObject> gameObjects;
	//private ArrayList<Barrier> barriers;
	private Level tempLevel;
	private Scanner scanner;
	private Jerome player;
	private String pressedChars;
	
	public JeromeComponent()
	{
		pressedChars = "";
		try {
			scanner = new Scanner(new File("src/textures.txt"));
			HashMap<String, Sprite> sprites = new HashMap<>();
			//
			while(scanner.hasNext())
				sprites.put(scanner.next(),new Sprite("src/"+scanner.next()));
			//}
			player = new Jerome(0,0,sprites.get("Jerome"));
			tempLevel = new Level("src/level1.txt",sprites);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//gameObjects = new ArrayList<>();
		//barriers = new ArrayList<>();
//		gameObjects.add(new Jerome(0,0,null));
//		gameObjects.add(new Coin(100,100,null));
//		gameObjects.add(new Missile(500,500,-10,0,null));
//		barriers.add(new Barrier(new Line(100,100,300,200,200,150),10,0.1));
		//barriers.add(new Barrier(new Line(100,700,700,700),30));
	}
	
	//public void 
	
	@Override
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		Graphics2D g = (Graphics2D) graphics;
		drawOn(g);
		//GameObject temp = new GameObject(100,500,400,50,false,false,null);
		//temp.drawOn(g);
	}
	public void update() {
		//repaint();
		Line line1 = new Line(100,0,100,100);
		Line line2 = new Line(0,50,50,50);
		System.out.println((1<0)==(1>3));
		//System.out.println(line1.isIntersecting(line2));
		tempLevel.update();
		double currX = player.getX();
		double currY = player.getY();
		player.update(pressedChars);
		//System.out.println(tempLevel.playerCollidesWithBarriers(player));
		if(tempLevel.playerCollidesWithBarriers(player))
		{
			player.setX(currX);
			player.setY(currY);
		}
			
		
//		for(GameObject q : gameObjects)
//		{
//			q.update();
//		}
//		for(Barrier b : barriers)
//		{
//			b.update();
//		}
	}
	
	public void keyDown(KeyEvent e)
	{
		pressedChars+=e.getKeyChar();
//		System.out.println("iekhe");
//		if(player.getVelX()==0)
//		{
//		if(e.getKeyCode()==KeyEvent.VK_D)
//		{
//			player.setVelX(2);
//		}
//		else if(e.getKeyChar()=='a')
//			player.setVelX(-2);
//		}
//		else {
//			//player.setVelX(0);
//		}
		//System.out.println(player.getX());
	}
	
	public void keyReleased(KeyEvent e)
	{
		String tempString = "";
		for(int q = 0; q<pressedChars.length(); q++)
		{
			if(pressedChars.charAt(q)!=e.getKeyChar())
			{
				tempString+=pressedChars.charAt(q);
			}
		}
		pressedChars = tempString;
//		if(player.getVelX()==2)
//		{
//			player
//		}
//		if(e.getKeyCode()==KeyEvent.VK_D)
//		{
//			player.velX-=2;
//		}
//		else if(e.getKeyCode()==KeyEvent.VK_A)
//			player.velX+=2;
		//player.velX = 0;
	}
	
	public void drawOn(Graphics2D g)
	{
		tempLevel.drawOn(g);
		player.drawOn(g);
//		for(GameObject q : gameObjects)
//		{
//			q.drawOn(g);
//		}
//		for(Barrier b : barriers)
//		{
//			b.drawOn(g);
//		}
	}

//	@Override
//	public void keyTyped(KeyEvent e) {
//		// TODO Auto-generated method stub
//		//if(e.getKeyChar();
//	}
//
//	@Override
//	public void keyPressed(KeyEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void keyReleased(KeyEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
}
