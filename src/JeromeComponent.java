import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

public class JeromeComponent extends JComponent{

	@Override
	protected void paintComponent(Graphics graphics)
	{
		super.paintComponent(graphics);
		Graphics2D g2 = (Graphics2D) graphics;
	}
}
