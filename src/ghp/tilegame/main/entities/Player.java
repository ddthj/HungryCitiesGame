package ghp.tilegame.main.entities;

import ghp.tilegame.main.Game;
import ghp.tilegame.main.gfx.SpriteSheet;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player implements KeyListener{

	private int x, y;
	private SpriteSheet ss;
	
	public Player(int x, int y, SpriteSheet ss){
		this.x = x;
		this.y = y;
		this.ss = ss;
	}
	
	public void tick(){
		
	}
	
	public void render(Graphics g){
		g.drawImage(ss.crop(0, 0, 16, 16), x, y, 16 * Game.SCALE, 16 * Game.SCALE, null);
	}

	public void keyPressed(KeyEvent e) {
		
	}

	public void keyReleased(KeyEvent e) {
		
	}

	public void keyTyped(KeyEvent e) {
	}
	
}