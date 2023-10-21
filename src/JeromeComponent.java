import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class JeromeComponent extends JComponent {

	@Override
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		Graphics2D g = (Graphics2D) graphics;
		GameObject temp = new GameObject(100,500,400,50,false,false,null);
		temp.drawOn(g);
	}
	public void update() {
		repaint();
		
	}
}
