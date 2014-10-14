package cities;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;

public class JGame extends Canvas {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int myX = 400;
	int myY = 400;

	public JGame() {
		setSize(new Dimension(500, 500));
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent evt) {
				moveIt(evt);
			}
		});
	}

	public void paint(Graphics g) {
		g.setColor(new Color(255, 0, 0));
		g.fillOval(myX, myY, 30, 30);
	}

	public void moveIt(KeyEvent evt) {
		switch (evt.getKeyCode()) {
		case KeyEvent.VK_UP:
			myY -= 8;
			repaint();
			break;
		case KeyEvent.VK_LEFT:
			myX -= 8;
			repaint();
			break;
		case KeyEvent.VK_RIGHT:
			myX += 8;
			repaint();
			break;
		case KeyEvent.VK_DOWN:
			myY += 8;
			repaint();
			break;
		}
	//	repaint();
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Basic Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JGame ex = new JGame();
		frame.getContentPane().add(ex);
		frame.pack();
		frame.setResizable(false);
		frame.setVisible(true);
		ex.requestFocus();
	}
}