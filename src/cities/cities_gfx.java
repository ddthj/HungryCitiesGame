package cities;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class cities_gfx {
	public BufferedImage load(String path){
		try {
			return ImageIO.read(getClass().getResource(path));
		} catch (IOException e) {e.printStackTrace();
			e.printStackTrace();
		}
		return null;
	}

}
