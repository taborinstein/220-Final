import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite {
	
	private BufferedImage image;
	//private int width, height;
	
	public Sprite(String imagePath)
	{
		try {
			image = ImageIO.read(new File(imagePath));
		} catch (IOException e) {
			System.out.println("path doesn't exist ):<");
//			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
	}

	public void drawOn(Graphics2D g, int x, int y, int w, int h) {
		g.drawImage(image,x,y,w,h,null);
		
	}

}
