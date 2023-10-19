import javax.swing.JFrame;

public class JeromeMain {
	//public static final Dimension DIMENSIONS = new Dimension();
		public static final int FRAME_W = 1000;
		public static final int FRAME_H = 800;
		
		@SuppressWarnings("unused")
		public static void main(String[] args) {
			JFrame frame = new JFrame();
			frame.setSize(FRAME_W,FRAME_H);
			
			frame.add(new JeromeComponent());
			
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
			
		}
}
