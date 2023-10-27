import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;

public class Sprite {

	private HashMap<String, BufferedImage[]> frameSheet;
	private String imagePath;
	private String animationName;
	private int animationFrame;
	// private int width, height;

	public Sprite(String imagePath) {
		this.imagePath = imagePath;
		frameSheet = new HashMap<String, BufferedImage[]>();
		loadSpriteSheet();
		animationName = "idle";
	}

	private void fatal(String error) {
		System.err.println("[FATAL ERROR] " + error);
		System.exit(1);
	}

	private void loadSpriteSheet() {
		String configPath = imagePath.replace(".png", ".spritedata"); // this is bad but it works
		BufferedImage spritesheet = null;
		try {
			spritesheet = ImageIO.read(new File(imagePath));
		} catch (IOException e) {
			fatal("Could not find path: " + imagePath);
		}
		Scanner config = null;
		try {
			File configFile = new File(configPath);
			config = new Scanner(new FileReader(configFile));
			int w = 0;
			int h = 0;
			ArrayList<BufferedImage> frames = new ArrayList<BufferedImage>();
			while(config.hasNextLine())  {
				String line = config.nextLine();
				String key = line.split(":")[0].trim();
				String value = line.split(":")[1].trim();
				if (key.equals("dimensions")) {
					String[] components = value.split(" ");
					w = Integer.parseInt(components[0]);
					h = Integer.parseInt(components[1]);
					if (spritesheet.getWidth() % w > 0)
						System.err.println("[WARNING] (" + imagePath + ").getWidth() is not divisible evenly by width");
					for (int i = 0; i < spritesheet.getWidth() / w; i++) {
						frames.add(spritesheet.getSubimage(i * w, 0, w, h));
					}
				} else if (key.startsWith("frames.")) {
					if (w + h < 1)
						fatal(configPath + " should contain dimensions before any frames");
					String[] components = value.split(" ");
					String animName = key.split("\\.")[1];
					for (int i = 0; i < components.length; i++) {
						int frameNum = Integer.parseInt(components[i]);
						if (frameNum >= frames.size())
							fatal("Index " + frameNum + " in animation " + animName + " exceeds frames.size()");
						if (frameSheet.get(animName) == null)
							frameSheet.put(animName, new BufferedImage[components.length]);
						frameSheet.get(animName)[i] = frames.get(frameNum);
					}

				} else
					System.err.println("[WARNING] Invalid key in " + configFile + ": " + key);
			}

		} catch (IOException e) {
			fatal("Could not find path: " + configPath);
		}

	}
	public void setAnimation(String animName) {
		if(!animationName.equals(animName)) animationFrame = 0;
		animationName = animName;
	}
	public void drawOn(Graphics2D g, int x, int y, int w, int h) {
		BufferedImage[] animation = frameSheet.get(animationName);
		g.drawImage(animation[animationFrame], x, y, w, h, null);
		animationFrame = (animationFrame + 1) % animation.length;

	}

}
