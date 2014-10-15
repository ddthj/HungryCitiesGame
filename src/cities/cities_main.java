package cities;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class cities_main extends Canvas implements Runnable{

	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 250, HEIGHT = 250, SCALE = 2;
	public static boolean running = false;
	public Thread citiesThread;
	//private BufferedImage grass;
	//private BufferedImage dirt;
	//private BufferedImage trees;
	//private BufferedImage scrap;
	private BufferedImage cityimg;
	private City city;
	public void init(){
		cities_gfx gfx = new cities_gfx();
		//grass = gfx.load("/CHGME");
		//dirt = gfx.load("/CHGME");
		//trees = gfx.load("/CHGME");
		//scrap = gfx.load("/CHGME");
		cityimg = gfx.load("/city.png");
		city = new City(0,0,cityimg);
	}
	public synchronized void start(){
		if(running)return;
		running = true;
		citiesThread = new Thread(this);
		citiesThread.start();
	}
	public synchronized void stop(){
		if(!running)return;
		running = false;
		try {
			citiesThread.join();
		} catch (InterruptedException e) {e.printStackTrace();}
	}
	
	public void tick() {
		city.tick();
		
	}
	public void render(){
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);
		city.render(g);
		g.dispose();
		bs.show();
	}
	public void run() {
		init();
		long lastTime = System.nanoTime();
		final double amountOfTicks = 60D;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		
		while(running) {
			long now = System.nanoTime();
			delta += (now-lastTime) / ns;
			lastTime = now;
			if(delta>=1){
				tick();
				delta--;
			}
			render();
		}
		stop();
	}

	public static void main(String args[]){
		cities_main cities_m = new cities_main();
		cities_m.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		cities_m.setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		cities_m.setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		
		JFrame frame = new JFrame("HungryCities");
		frame.setSize(WIDTH * SCALE, HEIGHT * SCALE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(cities_m);
		frame.setVisible(true);
	}
		

}
