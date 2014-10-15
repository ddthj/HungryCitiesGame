package cities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class City {
	private int x,y;
	BufferedImage cityimage;
	cityimg = cities_gfx.load("/city.png");
	
	public City(int x, int y, BufferedImage cityimg){
		this.x = x;
		this.y = y;
		this.img = cityimg;
	}
	public void tick(){
		
	}
	public void render(Graphics g){
		g.drawImage(cityimg,x,y,25*cities_main.SCALE, 25 * cities_main.SCALE,null);
		
	}

}
