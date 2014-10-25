package ghp.tilegame.main.entities;

import ghp.tilegame.main.Game;
import ghp.tilegame.main.gfx.ImageManager;
import ghp.tilegame.main.gfx.SpriteSheet;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Player implements KeyListener{

	private int x, y;
	private ImageManager im;
	private boolean up = false, dn = false, rt = false, lt = false;
	private double SPEED = 2;
	public Player(int x, int y, ImageManager im){
		this.x = x;
		this.y = y;
		this.im = im;
	}
	public void tick(){
		if(up) {
			y -= SPEED;
		}
		if(dn) {
			y += SPEED;
		}
		if(lt) {
			x -= SPEED;
		}
		if(rt){
			x += SPEED;
		}
	}
	
	public void render(Graphics g){
		g.drawImage(im.player, x, y, 16 * Game.SCALE, 16 * Game.SCALE, null);
	}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP){
			up = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			dn = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			lt = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			rt = true;
		}
	}

	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_UP){
			up = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			dn = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			lt = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			rt = false;
		}
	}

	public void keyTyped(KeyEvent e) {
	}
	
}