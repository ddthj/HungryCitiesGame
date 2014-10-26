package code;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics2D;
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
	public int[][] gamemap;
	public int MAPSIZE = 9;
	public Map map = new Map();
	
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
		gamemap = map.gen(MAPSIZE);
		crop.init(spritesheet);
		run(gamemap);
	}
		
	public void run(int[][]gamemap){
		boolean gameRunning = true;
		long last = System.nanoTime();
		while(gameRunning){
			Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
			g.setColor(Color.black);
			g.fillRect(0, 0, 500, 500);
			//g.translate(500, 500);
			map.render(MAPSIZE,gamemap,g);
			
		}
	}
	public static void main(String[] args){
		new Game();
	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}
