package code;

import java.awt.Canvas;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;


public class Game extends Canvas implements KeyListener{

	private static final long serialVersionUID = 1L;
	private BufferedImage spritesheet;
	private BufferStrategy strategy;
	private boolean right;
	private boolean left;
	private boolean up;
	private boolean down;
	public int MAPSIZE = 3;
	
	
	public void init(){
		try {
			URL url = Thread.currentThread().getContextClassLoader().getResource("res/spritesheet.png");
			if (url == null) {
				System.err.println("Unable to find sprite: res/sprite.gif");
				System.exit(0);
			}
			spritesheet = ImageIO.read(url);
		} catch (IOException e) {
			System.err.println("Unable to load sprite: res/sprite.gif");
			System.exit(0);
		}
		Frame frame = new Frame("Hungry Cities");
		frame.setLayout(null);
		setBounds(0,0,500,500);
		frame.add(this);
		frame.setSize(500,500);
		frame.setResizable(false);	
		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		frame.addKeyListener(this);
		addKeyListener(this);
		frame.setVisible(true);
		createBufferStrategy(2);
		strategy = getBufferStrategy();
		Map map = new Map();
		Crop crop = new Crop();
		map.gen(MAPSIZE);
		crop.init(spritesheet);
	}
		
	public void run(){
		
	}
	
	
	
	
	public void keyPressed(KeyEvent arg0) {		
	}

	public void keyReleased(KeyEvent arg0) {
		
	}

	public void keyTyped(KeyEvent arg0) {
		
	}
	

}
