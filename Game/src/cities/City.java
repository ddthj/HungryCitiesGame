package cities;

import java.awt.Graphics;
import java.awt.Image;

public class City {
	public int x;
	public int y;
	public int width;
	public int height;
	// public BufferedImage cityimage;
	public Image cityImage = new cities_gfx().load("/city.png");

	public City(int x, int y, Image cityImage) {
		this.x = x;
		this.y = y;
		this.cityImage = cityImage;
	}

	public void tick() {

	}

	public void render(Graphics g) {
		g.drawImage(cityImage, x, y, 25 * cities_main.SCALE,
				25 * cities_main.SCALE, null);

	}

}
