package code;

import java.awt.Canvas;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements KeyListener{

	private Image spritesheet;
	private BufferStrategy strategy;
	private boolean right;
	private boolean left;
	private boolean up;
	private boolean down;
	private Map map;
	private Player player;
	public int MAPSIZE = 5;
	
	
	public void init(){
		map.generate(MAPSIZE);
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
