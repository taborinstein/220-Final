import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.Timer;
import javax.swing.JFrame;

public class JeromeMain {
	// public static final Dimension DIMENSIONS = new Dimension();
	public static final int FRAME_W = 1000;
	public static final int FRAME_H = 800;

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(FRAME_W, FRAME_H);
		JeromeComponent jeromeComponent = new JeromeComponent();
		frame.add(jeromeComponent);
		frame.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e)
			{
				jeromeComponent.keyDown(e);
			}
			
			public void keyReleased(KeyEvent e)
			{
				jeromeComponent.keyReleased(e);
			}
		});
		//frame.addComponentListener();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setFocusable(true);
		Timer timer = new Timer(16, new ActionListener() {
			double i = 0;
            @Override
            public void actionPerformed(ActionEvent ae) {
            	jeromeComponent.update();
            	jeromeComponent.repaint();
            	//System.out.println("q");
            }
        });
		timer.start();

		
	}
}