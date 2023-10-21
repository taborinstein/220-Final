import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		Timer timer = new Timer(16, new ActionListener() {
			double i = 0;
            @Override
            public void actionPerformed(ActionEvent ae) {
               System.out.println(i/60);
               i++;
            }
        });
		timer.start();

	}
}