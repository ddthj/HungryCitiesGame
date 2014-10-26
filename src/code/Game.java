package code;

import java.awt.Canvas;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Game extends Canvas implements KeyListener{

	private static final long serialVersionUID = 1L;
	private static BufferedImage spritesheet;
	private BufferStrategy strategy;
	private boolean right;
	private boolean left;
	private boolean up;
	private boolean down;
	public static int MAPSIZE = 3;
	
	public BufferedImage getImage(String path){
		try {
			return ImageIO.read(new FileInputStream(path));
		} catch(IOException e){
			System.err.println("Unable to find spritesheet");
			System.exit(0);
		}
		return null;
		
	}
	
	public Game(){
		BufferedImage spritesheet = getImage("spritesheet.png");
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
	public static void main(String[] args){
		new Game();
	}
	
	
	
	public void keyPressed(KeyEvent arg0) {		
	}

	public void keyReleased(KeyEvent arg0) {
		
	}

	public void keyTyped(KeyEvent arg0) {
		
	}

}
